<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        
        <meta name="description" content="Descuentos">
        <meta name="keywords" content="ULe-Bank, descuentos">
		<meta name="author" content="Alexis Gutiérrez & Camino Fernández">
		<meta name="robots" content="index,follow">
        
        <link rel="alternate" hreflang="es" href="http://ule-bank.appspot.com/" />
        
        <link rel="shortcut icon" type="image/x-icon" href="/resources/img/favicon.ico" />
        
        <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="/resources/css/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="/resources/css/styles-responsive.css">
        
        <script src="/resources/js/jquery.min.js"></script>
  		<script src="/resources/js/bootstrap.min.js"></script>
        
        <script src="/resources/js/jquery-cookie.js"></script>
        
        <script src="/resources/js/script.js"></script>
        
        <title>Descuentos</title>
        
        <!-- GOOGLE ANALYTICS TRACKER -->
        <script>
  			(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  			(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  			m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  			})(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  			ga('create', 'UA-72492123-1', 'auto');
  			ga('send', 'pageview');
		</script>
        
    </head>

    <body>
        
      
        
        <main class="general-class">
        
        	<div class="container">
        
        		<div class="global-header"></div>
        		
                <ol class="breadcrumb">
                    <li><a href="/">Inicio</a></li>
                </ol>
                
                <div class="page-header">
  					<h1>Descuentos</h1>
				</div>

				<form:form role="form" method="post" modelAttribute="descuentos">
					<div class="row">
						<div class="col-md-4">
	    					<label for="importeDescuento">Importe sobre el que se aplica el descuento:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Nominal de la letra. Mayor o igual que 1. En euros."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="importeDescuento"/>
		    					<span class="input-group-addon"><i class="fa fa-eur" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="importeDescuento"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Nominal de la letra. Mayor o igual que 1. En euros."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="periodoDescuento">Periodo sobre el que se efectua el descuento:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Periodo desde que la entidad practica la liquidación hasta el vencimiento de la letra de cambio.
	    					Mayor o igual que 1."></span>
	    					<form:input class="form-control" path="periodoDescuento"/>
	    					<form:errors path="periodoDescuento"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Periodo desde que la entidad practica la liquidación hasta el vencimiento de la letra de cambio.
	    				Mayor o igual que 1."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="tipoInteres">Tipo de interés:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Tipo de interés del descuento. Mayor o igual que 0. En tanto por ciento."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="tipoInteres"/>
		    					<span class="input-group-addon"><i class="fa fa-percent" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="tipoInteres"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Tipo de interés del descuento. Mayor o igual que 0. En tanto por ciento."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="base">Base sobre la que se calculan los intereses:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Base sobre la que se calculan los intereses."></span>
	    					<form:select class="form-control" path="base">
	    						<option value="365">365 días - Año natural</option>
   								<option value="360">360 días - Año comercial</option>
	    					</form:select>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Base sobre la que se calculan los intereses."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="otrosGastos">Otros gastos:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Gastos no favorables a la entidad financiera. Mayor o igual que 0. En euros."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="otrosGastos"/>
		    					<span class="input-group-addon"><i class="fa fa-eur" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="otrosGastos"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Gastos no favorables a la entidad financiera. Mayor o igual que 0. En euros."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="comisiones">Comisiones:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Negociables entre la entidad financiera y el descontante. Mayor o igual que 0. En euros."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="comisiones"/>
		    					<span class="input-group-addon"><i class="fa fa-percent" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="comisiones"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Negociables entre la entidad financiera y el descontante. Mayor o igual que 0. En euros."></span>
  					</div>
  					<br>
				  	<input type="submit" class="btn btn-default" value="Calcular">
				</form:form>
				
				<br>
				
				<div class="bg-info">
                    <h3><c:out value="${model.efectivo}"/></h3>
                    <h3><c:out value="${model.descuento}"/></h3>
                </div>
                
                <p class="modal-link last-element"><a href="#" onclick="drawChart()" data-toggle="modal" data-target="#modalExplicativo">¿Qué un descuento?</a></p>
				
			</div>
        </main>
        
     
        	<jsp:param name="lastUpdate" value="7 de Junio de 2016"/>
    	</jsp:include>
        
        <!-- Modal -->
        <div class="modal fade" id="modalExplicativo" tabindex="-1" role="dialog" aria-labelledby="modalExplicativoLabel">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="modalExplicativoLabel">Descuentos</h4>
                    </div>
                    <div class="modal-body">
                    	<p>La cantidad anticipada por la entidad financiera a los clientes se denomina efectivo y se obtiene restando al nominal 
                    	de la letra de cambio el importe de los intereses y otros gastos y comisiones que aplica la entidad.</p>
                    	
                    	<p>Al vencimiento de la letra de cambio, si esta resultara impagada, se cargará en la cuenta del cliente el importe del 
                    	nominal más una serie de gastos.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Modal -->
        
        <!-- MODAL RESULTADOS -->
        <div class="modal fade" id="modalResultados" tabindex="-1" role="dialog" aria-labelledby="modalResultadosLabel">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="modalResultadosLabel">Resultado de la simulación</h4>
                    </div>
                    <div class="modal-body">
                        <table class="table">
							<thead>
		      					<tr>
			      					<th>Intereses</th>
			      					<th>Comisiones</th>
			      					<th>Total gastos</th>
		        					<th>Efectivo</th>
		      					</tr>
		    				</thead>
							<tbody>
								<c:forEach var="fila" items="${tabla}">
									<tr>
										<c:forEach var="itemFila" items="${fila}">
											<td>
							               		<c:out value="${itemFila}"/>
							               	</td>
							            </c:forEach>
						           	</tr>
								</c:forEach>
							</tbody>
						</table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- FIN MODAL RESULTADOS -->
       
       	<script src="/resources/js/tooltip-script.js"></script>
       
    </body>
</html>