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
        
        <title>Todas las consultas</title>
        
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
                </ol>
                
                <div class="page-header">
  					<h1>Bienvenido administrador</h1>
				</div>
				
				<h3>Estas son todas las consultas</h3>
				
				<br>
				
				<table class="table">
					<thead>
      					<tr>
        					<th>ID consulta</th>
        					<th>Título de consulta</th>
        					<th>Estado</th>
      					</tr>
    				</thead>
					<tbody>
						<c:forEach var="listValue" items="${lists}">
							<tr>
								<td>
				               		<a href="/question-page-admin.htm?id=<c:out value="${listValue.id}"/>"><c:out value="${listValue.id}"/></a>
				               	</td>
								<td>
				               		<c:out value="${listValue.title}"/>
				               	</td>
				               	<td>
				               		<c:out value="${listValue.state}"/>
				               	</td>
				           	</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div class="btn-group last-element pull-right" role="group">
					<a href="/new-admin-question.htm" class="btn btn-default">Nueva pregunta</a>
					<a href="/questions-list.htm" class="btn btn-default">Preguntas</a>
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