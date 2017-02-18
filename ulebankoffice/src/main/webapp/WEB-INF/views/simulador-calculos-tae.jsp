<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        
        <meta name="description" content="Cálculo de TAE.">
        <meta name="keywords" content="ULe-Bank, calculos, tae, tasa, anual, equivalente">
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
        
        <title>Cálculo de TAE</title>
        
    </head>

    <body>
        
 
        
        <main class="general-class">
        
        	<div class="container">
        
        		<div class="global-header"></div>
        		
                <ol class="breadcrumb">
                    <li><a href="/">Inicio</a></li>    
                </ol>
                
                <div class="page-header">
  					<h1>Cálculo de TAE</h1>
				</div>

				<form:form role="form" method="post" modelAttribute="tae">
					<div class="row">
						<div class="col-md-4">
	    					<label for="i">Tipo de interés:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Interés nominal anual. Mayor o igual que 0."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="i"/>
		    					<span class="input-group-addon"><i class="fa fa-percent" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="i"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Interés nominal anual. Mayor o igual que 0."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="p">Tipo de periodo:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Número de pagos en el año."></span>
	    					<form:select class="form-control" path="p">
	    						<form:option value="1" label="1 - anual"/>
	    						<form:option value="2" label="2 - semestral"/>
	    						<form:option value="3" label="3 - cuatrimestral"/>
	    						<form:option value="4" label="4 - trimestral"/>
	    						<form:option value="6" label="6 - bimensual"/>
	    						<form:option value="12" label="12 - mensual"/>
	    					</form:select>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Número de pagos en el año."></span>
  					</div>
  					<br>
				  	<input type="submit" class="btn btn-default" value="Calcular">
				</form:form>
				
				<br>
				
				<div class="bg-info">
                    <h3><c:out value="${model.resultado}"/></h3>
                </div>
                
                <p class="modal-link last-element"><a href="#" data-toggle="modal" data-target="#modalExplicativo">¿Qué es la TAE?</a></p>
				
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
                        <h4 class="modal-title" id="modalExplicativoLabel">TAE - Tasa Anual Equivalente</h4>
                    </div>
                    <div class="modal-body">
                        La Tasa Anual Equivalente se utiliza para denotar el tipo de interés asociado a una inversión o a un crédito.                     
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
		        					<th>Tipo de interés</th>
		        					<th>Pagos anuales</th>
		        					<th>Tasa Anual Equivalente (TAE)</th>
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