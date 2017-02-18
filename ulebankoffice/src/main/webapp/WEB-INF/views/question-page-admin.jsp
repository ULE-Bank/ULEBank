<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        
        <link rel="shortcut icon" type="image/x-icon" href="/resources/img/favicon.ico" />
        
        <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="/resources/css/styles-responsive.css">
        
        <script src="/resources/js/jquery.min.js"></script>
  		<script src="/resources/js/bootstrap.min.js"></script>
        
        <script src="/resources/js/script.js"></script>
        
        <title>Consulta</title>
        
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
  					<h1><c:out value="${model.titulo}"/></h1>
				</div>
				
				<h4>Estado de la consulta: </h4><c:out value="${model.state}"/>
				<br>
				<br>
				<h4>Nombre: </h4><c:out value="${model.nombre}"/>
				<h4>Apellidos: </h4><c:out value="${model.apellidos}"/>
				<h4>Enlace de la consulta: </h4><a href="<c:out value="${model.url}"/>"><c:out value="${model.url}"/></a>
				<h4>Comentario: </h4><c:out value="${model.comentarios}"/>
				<form:form role="form" method="post" modelAttribute="adminAnswer">
					<div class="row">
						<div class="col-md-6">
	    					<h4>Respuesta:</h4>
	    					<form:textarea class="form-control" path="answer" rows="5"/>
	    					<form:errors path="answer"></form:errors>
	  					</div>
  					</div>
  					<form:hidden path="email" value="${model.email}"/>
  					<form:hidden path="idConsulta" value="${model.id_consulta}"/>
  					<br>
				  	<input type="submit" class="btn btn-default" value="Enviar respuesta">
				</form:form>
				
				<div class="btn-group last-element pull-right" role="group">
					<a href="/logout.htm" class="btn btn-default">Cerrar sesión</a>
				</div>
				
			</div>
        </main>
        
        <jsp:include page="/WEB-INF/views/footer.jsp">
        	<jsp:param name="lastUpdate" value="7 de Junio de 2016"/>
    	</jsp:include>
       
       	<script src="/resources/js/tooltip-script.js"></script>
       
    </body>
</html>