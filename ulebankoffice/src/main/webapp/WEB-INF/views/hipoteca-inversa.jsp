<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        
        <meta name="description" content="Cálculos de una hipoteca inversa".>
        <meta name="keywords" content="ULe-Bank, simulador, calculos, hipoteca, inversa">
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
        
        <title>Hipoteca inversa</title>
        
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
  					<h1>Hipoteca inversa</h1>
				</div>

				<form:form role="form" method="post" modelAttribute="hipotecaInversa">
					<div class="row">
						<div class="col-md-4">
	    					<label for="valorTasacion">Valor de tasación:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Valoración de la entidad sobre el inmueble. Mayor o igual que 1. En euros."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="valorTasacion"/>
		    					<span class="input-group-addon"><i class="fa fa-eur" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="valorTasacion"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Valoración de la entidad sobre el inmueble. Mayor o igual que 1. En euros."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="edad">Edad del solicitante:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Edad del solicitante. Mayor que 65 años."></span>
	    					<form:input class="form-control" path="edad"/>
	    					<form:errors path="edad"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Edad del solicitante. Mayor que 65 años."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="porcentajeSobreTasacion">Porcentaje de prestamo sobre la tasación:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Porcentaje de prestamo sobre la tasación. Mayor o igual que 0. En tanto por ciento."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="porcentajeSobreTasacion"/>
		    					<span class="input-group-addon"><i class="fa fa-percent" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="porcentajeSobreTasacion"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Porcentaje de prestamo sobre la tasación. Mayor o igual que 0. En tanto por ciento."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="tipoInteresPrestamo">Tipo de interés del préstamo:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Tipo de interés del préstamo. Mayor o igual que 0. En tanto por ciento."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="tipoInteresPrestamo"/>
		    					<span class="input-group-addon"><i class="fa fa-percent" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="tipoInteresPrestamo"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Tipo de interés del préstamo. Mayor o igual que 0. En tanto por ciento."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="comisionApertura">Comisión de apertura:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Porcentaje que cobra la entidad al inicio. Mayor o igual que 0. En tanto por ciento."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="comisionApertura"/>
		    					<span class="input-group-addon"><i class="fa fa-percent" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="comisionApertura"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Porcentaje que cobra la entidad al inicio. Mayor o igual que 0. En tanto por ciento."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="rentabilidadRenta">Rentabilidad de la renta:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Relación entre lo que se invierte y lo que se obtiene. Mayor o igual que 0. En tanto por ciento."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="rentabilidadRenta"/>
		    					<span class="input-group-addon"><i class="fa fa-percent" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="rentabilidadRenta"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Relación entre lo que se invierte y lo que se obtiene. Mayor o igual que 0. En tanto por ciento."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="costeTasacion">Coste de tasación:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Gasto a incurrir al realizar esta operación. Mayor o igual que 0. En euros."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="costeTasacion"/>
		    					<span class="input-group-addon"><i class="fa fa-eur" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="costeTasacion"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Gasto a incurrir al realizar esta operación. Mayor o igual que 0. En euros."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="gastosFormalizacion">Gastos de formalización:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Gasto procedente de la formalización del contrato. Mayor o igual que 0. En euros."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="gastosFormalizacion"/>
		    					<span class="input-group-addon"><i class="fa fa-eur" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="gastosFormalizacion"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Gasto procedente de la formalización del contrato. Mayor o igual que 0. En euros."></span>
  					</div>
  					<br>
				  	<input type="submit" class="btn btn-default" value="Calcular">
				</form:form>
				
				<br>
				
				<div class="bg-info">
                    <h3><c:out value="${model.resultado}"/></h3>
                </div>
                
                <p class="modal-link last-element"><a href="#" data-toggle="modal" data-target="#modalExplicativo">¿Qué es una hipoteca inversa?</a></p>
				
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
                        <h4 class="modal-title" id="modalExplicativoLabel">Hipotecas inversas</h4>
                    </div>
                    <div class="modal-body">
                        <p>Una hipoteca inversa es un préstamo hipotecario para personas mayores de 65 años a través
						del cual una entidad financiera abona una cuantía de forma mensual a una persona con la
						condición de que esta emplee su vivienda como garantía. La cantidad a abonar por la entidad
						financiera varía en función de valor de tasación de la vivienda y de la edad del solicitante del
						préstamo. A mayor valor y a mayor edad, mayor importe mensual se puede recibir.</p>
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
		        					<th>Valor del préstamo</th>
		        					<th>Total gastos</th>
		        					<th>Importe mensual</th>
		        					<th>Intereses mensuales</th>
		        					<th>Importe de libre disposición</th>
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