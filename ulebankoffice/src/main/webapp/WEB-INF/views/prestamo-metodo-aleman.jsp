<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        
        <meta name="description" content="Simulador de préstamo método Alemán.">
        <meta name="keywords" content="ULe-Bank, simulador, calculos, prestamo, metodo, aleman">
		<meta name="author" content="Alexis Gutiérrez & Camino Fernández">
		<meta name="robots" content="index,follow">
        
        <link rel="alternate" hreflang="es" href="http://ule-bank.appspot.com/" />
        
        <link rel="shortcut icon" type="image/x-icon" href="/resources/img/favicon.ico" />
        
        <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="/resources/css/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="/resources/css/styles-responsive.css">
        
        <script src="/resources/js/jquery.min.js"></script>
  		<script src="/resources/js/bootstrap.min.js"></script>
  		
  		<script src="/resources/js/Chart.js"></script>
        
        <script src="/resources/js/jquery-cookie.js"></script>
        
        <script src="/resources/js/script.js"></script>
        
        <title>Préstamo método Alemán</title>
        
        <!-- CONSTRUCCIÓN DEL CHART DEL MÉTODO ALEMAN -->
        <script type="text/javascript">
            function drawChart() {
                var ctx = document.getElementById("myChart").getContext("2d");
                
                /* JQUERY - GET COLORS FROM CSS TO CHART */
                var colorHeader = $("header").css("background-color");
                var colorCorporativo = $(".global-header").css("background-color");
                
                Chart.defaults.global.responsiveAnimationDuration = 1000;
                Chart.defaults.global.legend.position = "bottom";
                Chart.defaults.global.animation.easing = "easeOutCirc";

                var data = {
                    labels: ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"],
                    datasets: [
                        {
                            label: "Amortización",
                            backgroundColor: colorCorporativo,
                            borderColor: colorCorporativo,
                            data: [7500, 6500, 7333, 8166, 9000, 9833, 10666, 11500, 12333, 13166, 14000]
                        },
                        {
                            label: "Intereses",
                            backgroundColor: colorHeader,
                            borderColor: colorHeader,
                            data: [0, 7500, 6667, 5834, 5000, 4167, 3334, 2500, 1667, 834, 0]
                        }
                    ]
                };

                var myBarChart = new Chart(ctx, {
    				type: 'bar',
    				data: data,
    				animation:{
				        animateScale:true
				    },
    				options: {
        				scales: {
			                xAxes: [{
			                        stacked: true
			                }],
			                yAxes: [{
			                        stacked: true
			                }]
			            }
    				}
				});
            }
        </script>
        
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
                    <li><a href="/resources/browse/prestamos.html">Préstamos</a></li>   
                </ol>
                
                <div class="page-header">
  					<h1>Préstamo método Alemán</h1>
				</div>

				<form:form role="form" method="post" modelAttribute="prestamoMetodoAleman">
					<div class="row">
						<div class="col-md-4">
							<label for="C0">Capital inicial:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Cuantía al principio de la operación. Mayor o igual que 1."></span>
							<div class="input-group">
		    					<form:input class="form-control" path="C0"/>
		    					<span class="input-group-addon"><i class="fa fa-eur" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="C0"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Cuantía al principio de la operación. Mayor o igual que 1."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="i">Tipo de interés:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Tipo de interés del préstamo. Mayor o igual que 0."></span>
	    					<div class="input-group">
		    					<form:input class="form-control" path="i"/>
		    					<span class="input-group-addon"><i class="fa fa-percent" aria-hidden="true"></i></span>
		    				</div>
		    				<form:errors path="i"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Tipo de interés del préstamo. Mayor o igual que 0."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="k">Periodos:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Duración del préstamo. Mayor o igual que 1."></span>
	    					<form:input class="form-control" path="k"/>
	    					<form:errors path="k"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Duración del préstamo. Mayor o igual que 1."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-4">
	    					<label for="range">Tipo de periodo:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Número de pagos en el año."></span>
	    					<form:hidden path="p"/><span id="p-expl">1 - anual</span>
	    					<input type="range" id="range" min="1" max="6" value="1" onchange="rangeListener();"/>
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
                
                <p class="modal-link last-element"><a href="#" onclick="drawChart()" data-toggle="modal" data-target="#modalExplicativo">¿Qué un préstamo por el método Alemán?</a></p>
				
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
                        <h4 class="modal-title" id="modalExplicativoLabel">Préstamo método Alemán</h4>
                    </div>
                    <div class="modal-body">
                        <p>En esta modalidad el cálculo de las cuotas son constantes excepto
						la cuota del momento cero que corresponde al importe de los intereses prepagables de
						la operación. Existen, por tanto n+1 pagos, en cambio intereses calculados sólo hay n
						que van del momento cero hasta n-1.</p>
						
                        <canvas id="myChart" width="600" height="300"></canvas>
                        <br>
                        <div id="chart-legend"></div>
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