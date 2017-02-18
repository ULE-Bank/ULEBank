<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        
        <meta name="description" content="Créditos">
        <meta name="keywords" content="ULe-Bank, creditos">
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
        
        <script src="/resources/js/json2.js"></script>
        
        <title>Créditos</title>
        
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
  					<h1>Créditos</h1>
				</div>

				<form:form role="form" method="post" modelAttribute="creditos">
					<div class="row">
						<div class="col-md-4">
	    					<label for="limiteCredito">Límite del crédito:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Cantidad máxima a disposición del cliente. Si es sobrepasada se calificará como excedido."></span>
	    					<div class="input-group">
		    					<form:input path="limiteCredito" class="form-control"/>
		    					<span class="input-group-addon"><i class="fa fa-eur" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="limiteCredito"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Cantidad máxima a disposición del cliente. Si es sobrepasada se calificará como excedido."></span>
  					</div>
  					<br>
  					<div class="row">
						<div class="col-md-4">
	    					<label for="fechaApertura">Fecha de apertura:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Fecha en la que comienza la operación."></span>
	    					<input type="date" class="form-control" id="fechaApertura" name="fechaApertura" required="required"/>
	    					<form:errors path="fechaApertura"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Fecha en la que comienza la operación."></span>
  					</div>
  					<br>
  					<div class="row">
						<div class="col-md-4">
	    					<label for="fechaVencimiento">Fecha de vencimiento:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Fecha de fiscalización."></span>
	    					<input type="date" class="form-control" id="fechaVencimiento" name="fechaVencimiento" required="required"/>
	    					<form:errors path="fechaVencimiento"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Fecha de fiscalización."></span>
  					</div>
  					<br>
  					<div class="row">
						<div class="col-md-4">
	    					<label for="comisionApertura">Comisión de apertura:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="A favor del banco."></span>
	    					<div class="input-group">
		    					<form:input path="comisionApertura" class="form-control"/>
		    					<span class="input-group-addon"><strong>&#8240;</strong></span>
		    				</div>
		    				<form:errors path="comisionApertura"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="A favor del banco."></span>
  					</div>
  					<br>
  					<div class="row">
						<div class="col-md-4">
	    					<label for="corretaje">Corretaje:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="A favor de terceros."></span>
	    					<div class="input-group">
		    					<form:input path="corretaje" class="form-control"/>
		    					<span class="input-group-addon"><strong>&#8240;</strong></span>
		    				</div>
		    				<form:errors path="corretaje"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="A favor de terceros."></span>
  					</div>
  					<br>
  					<div class="row">
						<div class="col-md-4">
	    					<label for="interesDeudor">Interés deudor:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Porcentaje aplicado a los saldos deudores (a favor del banco)."></span>
	    					<div class="input-group">
		    					<form:input path="interesDeudor" class="form-control"/>
		    					<span class="input-group-addon"><i class="fa fa-percent" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="interesDeudor"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Porcentaje aplicado a los saldos deudores (a favor del banco)."></span>
  					</div>
  					<br>
  					<div class="row">
						<div class="col-md-4">
	    					<label for="interesExcedido">Interés excedido:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Porcentaje aplicado a los saldos excedidos (a favor del banco)."></span>
	    					<div class="input-group">
		    					<form:input path="interesExcedido" class="form-control"/>
		    					<span class="input-group-addon"><i class="fa fa-percent" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="interesExcedido"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Porcentaje aplicado a los saldos excedidos (a favor del banco)."></span>
  					</div>
  					<br>
  					<div class="row">
						<div class="col-md-4">
	    					<label for="interesAcreedor">Interés acreedor:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Porcentaje aplicado a los saldos acreedores (a favor del cliente)."></span>
	    					<div class="input-group">
		    					<form:input path="interesAcreedor" class="form-control"/>
		    					<span class="input-group-addon"><i class="fa fa-percent" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="interesAcreedor"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Porcentaje aplicado a los saldos acreedores (a favor del cliente)."></span>
  					</div>
  					<br>
  					<div class="row">
						<div class="col-md-4">
	    					<label for="comisionSMND">Comisión sobre saldo medio no dispuesto:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Porcentaje aplicado al saldo no utilizado por el cliente a favor del banco."></span>
	    					<div class="input-group">
		    					<form:input path="comisionSMND" class="form-control"/>
		    					<span class="input-group-addon"><strong>&#8240;</strong></span>
		    				</div>
		    				<form:errors path="comisionSMND"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Porcentaje aplicado al saldo no utilizado por el cliente a favor del banco."></span>
  					</div>
  					<br>
  					
                    <br>
                    
                    <div class="row">
                        <div class="col-md-3">
                            <label for="descripcion-cero">Descripción del movimiento:</label>
                            <input type="text" class="form-control" id="descripcion-cero" value="Comisión de apertura" disabled="disabled"/>
                        </div>

                        <div class="col-md-3">
                            <label for="importe-cero">Importe del movimiento:</label>
                            <div class="input-group">
                            	<input type="text" class="form-control" id="importe-cero" value="0" disabled="disabled"/>
                            	<span class="input-group-addon"><i class="fa fa-eur" aria-hidden="true"></i></span>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <label for="fecha-cero">Fecha del movimiento:</label>
                            <input type="date" class="form-control" id="fecha-cero" disabled="disabled"/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-3">
                            <label for="descripcion-uno">Descripción del movimiento:</label>
                            <input type="text" class="form-control" id="descripcion-uno" value="Corretaje" disabled="disabled"/>
                        </div>

                        <div class="col-md-3">
                            <label for="importe-uno">Importe del movimiento:</label>
                            <div class="input-group">
                            	<input type="text" class="form-control" id="importe-uno" value="0" disabled="disabled"/>
                            	<span class="input-group-addon"><i class="fa fa-eur" aria-hidden="true"></i></span>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <label for="fecha-uno">Fecha del movimiento:</label>
                            <input type="date" class="form-control" id="fecha-uno" disabled="disabled"/>
                        </div>
                    </div>
                    <br>
                    
                    <div id="moves-container">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="movimientos[0].descripcionMovimiento">Descripción del movimiento:</label>
                                <form:input path="movimientos[0].descripcionMovimiento" class="form-control" required="required"/>
                            </div>
                            <div class="col-md-3">
                                <label for="movimientos[0].importeMovimiento">Importe del movimiento:</label>
                                <div class="input-group">
                                	<form:input path="movimientos[0].importeMovimiento" class="form-control" required="required"/>
                                	<span class="input-group-addon"><i class="fa fa-eur" aria-hidden="true"></i></span>
                                </div>
                            </div>   
                            <div class="col-md-3">
                                <label for="movimientos[0].fechaMovimiento">Fecha del movimiento:</label>
                                <input type="date" class="form-control" id="movimientos0.fechaMovimiento" name="movimientos[0].fechaMovimiento" required="required"/>
                            </div>
                        </div>
                        <br>
                    </div>
                    
                    <br>
                    
                    <p>
                        <a href="#" id="add-moves">Añadir movimiento <span class="fa fa-plus-square"></span></a>
                    </p>
                    
                    <p>
                        <a href="#" id="remove-moves">Eliminar último movimiento <span class="fa fa-minus-square"></span></a>
                    </p>
                    
                    <br>
  					
				  	<input type="submit" class="btn btn-default" value="Calcular">
				</form:form>
				
				<br>
				
				<div class="bg-info">
                    <h3><c:out value="${model.prueba}"/></h3>
                </div>
                
                <p class="modal-link last-element"><a href="#" onclick="drawChart()" data-toggle="modal" data-target="#modalExplicativo">¿Qué una cuenta de crédito?</a></p>
				
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
                        <h4 class="modal-title" id="modalExplicativoLabel">Créditos</h4>
                    </div>
                    <div class="modal-body">
                    	<p>Una cuenta de crédito es uan cuenta a disposición del cliente la cual tiene un límite y sobre la cual se pueden realizar ingresos y cargos.</p>
                    	<br>
                    	<p>Los saldos de la cuenta de crédito pueden ser deudores y acreedores.</p>
                    	<br>
                    	<p>En las liquidaciones periódicas se generan unos determinados intereses dependiendo del saldo de la cuenta de crédito, pudiendo ser estos deudores, acreedores o excedidos.</p>
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
		        					<th>Saldo</th>
		        					<th>Días</th>
		        					<th>Números deudores</th>
		        					<th>Números excedidos</th>
		        					<th>Números acreedores</th>
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
       	<script src="/resources/js/dynamic-form.js"></script>
       
    </body>
</html>