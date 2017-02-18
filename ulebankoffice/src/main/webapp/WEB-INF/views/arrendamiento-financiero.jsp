<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        
        <meta name="description" content="Simulador de arrendamiento financiero.">
        <meta name="keywords" content="ULe-Bank, simulador, arrendamiento, financiero, leasing">
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
        
        <title>Arrendamiento financiero</title>
        
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
  					<h1>Arrendamiento financiero</h1>
				</div>

				<form:form role="form" method="post" modelAttribute="arrendamientoFinanciero">
					<div class="row">
						<div class="col-md-4">
	    					<label for="valorBien">Valor del bien:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Beneficio del bien. Mayor o igual que 1."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="valorBien"/>
		    					<span class="input-group-addon"><i class="fa fa-eur" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="valorBien"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Beneficio del bien. Mayor o igual que 1."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="tipoInteres">Tipo de interés:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Tasa nominal de interés establecida por ULe-Bank. Expresada tanto por ciento."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="tipoInteres"/>
		    					<span class="input-group-addon"><i class="fa fa-percent" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="tipoInteres"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Tasa nominal de interés establecida por ULe-Bank. Expresada tanto por ciento."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="duracionContrato">Duración del contrato:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Periodo hasta el vencimiento. Mayor o igual que 1."></span>
	    					<form:input class="form-control" path="duracionContrato"/>
	    					<form:errors path="duracionContrato"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Periodo hasta el vencimiento. Mayor o igual que 1."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="fraccionamientoPagoCuota">Fraccionamientos de pago de la cuota:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Fraccionamiento de pagos anuales."></span>
	    					<form:select class="form-control" path="fraccionamientoPagoCuota">
	    						<form:option value="1" label="1 - anual"/>
	    						<form:option value="2" label="2 - semestral"/>
	    						<form:option value="3" label="3 - cuatrimestral"/>
	    						<form:option value="4" label="4 - trimestral"/>
	    						<form:option value="12" label="12 - mensual"/>
	    					</form:select>
	    					<form:errors path="fraccionamientoPagoCuota"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Fraccionamiento de pagos anuales."></span>
  					</div>
  					<br>
				  	<input type="submit" class="btn btn-default" value="Calcular">
				</form:form>
				
				<br>
				
				<div class="bg-info">
                    <h3><c:out value="${model.resultado}"/></h3>
                </div>
                
                <p class="modal-link last-element"><a href="#" onclick="drawChart()" data-toggle="modal" data-target="#modalExplicativo">¿Qué es un arrendamiento financiero?</a></p>
				
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
                        <h4 class="modal-title" id="modalExplicativoLabel">Arrendamiento financiero</h4>
                    </div>
                    <div class="modal-body">
                    	<p>Un arrendamiento financiero es un contrato entre dos partes basado en que el arrendador cede el uso al arrendatario a 
                    	cambio del pago periódico de unas cuotas preestablecidas y acordadas mutuamente.</p>
                    	
                    	<br>
                    	
                    	<p>Para que se lleve a cabo este arrendamiento financiero más conocido como leasing se tienen que cumplir unos 
                    	requisitos mínimos.</p>
                    	
                    	<br>
                    	
                    	<ul>
                    		<li>Ser empresario o profesional, sino no se concede.</li>
                    		<li>El arrendatario tiene que aceptar la opción de compra.</li>
                    		<li>El bien arrendado tiene que ser estrictamente bien mueble o inmueble.</li>
                    		<li>La duración del contrato depende de qué tipo de bien sea, si este es un bien mueble la vida útil como mínimo tiene 
                    		que ser de 2 años y en cambio si es un bien inmueble la vida útil aumenta hasta llegar a los 10 años como mínimo.</li>
                    		<li>Tiene unos gastos asociados de formalización de contrato alrededor del 0,5% del valor del bien (IVA incluido).</li>
                    		<li>Esta operación está sujeta al 21% del IVA.</li>
                    	</ul>
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
		        					<th>Periodo</th>
		        					<th>Anualidad</th>
		        					<th>Interés</th>
		        					<th>Amortización</th>
		        					<th>Capital pendiente</th>
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