<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        
        <link rel="alternate" hreflang="es" href="http://ule-bank.appspot.com/" />
        
        <link rel="shortcut icon" type="image/x-icon" href="/resources/img/favicon.ico" />
        
        <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="/resources/css/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="/resources/css/styles-responsive.css">
        
        <script src="/resources/js/jquery.min.js"></script>
  		<script src="/resources/js/bootstrap.min.js"></script>
        
        <script src="/resources/js/script.js"></script>
        
        <title>Nueva pregunta de administrador</title>
        
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
        
        <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
        
        <main class="general-class">
        
        	<div class="container">
        
        		<div class="global-header"></div>
        		
                <ol class="breadcrumb">
                    <li><a href="/">Inicio</a></li>
                    <li><a href="/admin-questions.htm">Todas las consultas</a></li>     
                </ol>
                
                <div class="page-header">
  					<h1>Nueva pregunta de administrador</h1>
				</div>

				<form:form role="form" method="post" modelAttribute="newAdminQuestion">
					<div class="row">
						<div class="col-md-6">
	    					<label for="pregunta">Pregunta:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Pregunta que deseas plantear."></span>
	    					<form:input class="form-control" path="pregunta"/>
	    					<form:errors path="pregunta"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Pregunta que deseas plantear."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-6">
	    					<label for="ponderacion">Ponderación:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Ponderación de esta pregunta sobre el total."></span>
	    					<form:input class="form-control" path="ponderacion"/>
	    					<form:errors path="ponderacion"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Ponderación de esta pregunta sobre el total."></span>
  					</div>
  					<br>
				  	<input type="submit" class="btn btn-default last-element" value="Añadir pregunta">
				</form:form>
				
			</div>
        </main>
        
        <jsp:include page="/WEB-INF/views/footer.jsp">
        	<jsp:param name="lastUpdate" value="7 de Junio de 2016"/>
    	</jsp:include>
       
       	<script src="/resources/js/tooltip-script.js"></script>
       
    </body>
</html>