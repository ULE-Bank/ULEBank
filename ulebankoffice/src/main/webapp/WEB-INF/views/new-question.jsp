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
        
        <title>Nueva consulta</title>
        
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
                    <li><a href="/user-questions.htm">Mis consultas</a></li>     
                </ol>
                
                <div class="page-header">
  					<h1>Nueva consulta</h1>
				</div>

				<form:form role="form" method="post" modelAttribute="newQuestion">
					<div class="row">
						<div class="col-md-6">
	    					<label for="nombre">Nombre:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Escribe tu nombre."></span>
	    					<form:input class="form-control" path="nombre"/>
	    					<form:errors path="nombre"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Escribe tu nombre."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-6">
	    					<label for="apellidos">Apellidos:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Escribe tus apellidos."></span>
	    					<form:input class="form-control" path="apellidos"/>
	    					<form:errors path="apellidos"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Escribe tus apellidos."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-6">
	    					<label for="edad">Edad:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="¿Cuantos años tienes?"></span>
	    					<form:input class="form-control" path="edad"/>
	    					<form:errors path="edad"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="¿Cuantos años tienes?"></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-6">
	    					<label for="claseSocial">Clase social:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="1. Vive con un patrimonio heredado y tiene familia famosa
    <br>2. Ha ganado altos ingresos mediante una capacidad excepcional en sus profesiones o negocios. Proviene de la clase media. 
    <br>3. Goza de buena posición como profesional, negociante independiente y administrador corporativo.
    <br>4.  Se compone de trabajadores manuales o técnicos que viven en barrios. Estimula a sus hijos para recibir educación universitaria.
    <br>5. Consiste de obreros de la clase trabajadora, sin importar sus ingresos, formación escolar o trabajo. 
    <br>6. Es gente que realiza trabajos no especializados y sus salarios son bajos. Presenta deficiencias educativas. 
    <br>7. Vive de la beneficencia social. Sus integrantes suelen estar desempleados."></span>
	    					<form:select class="form-control" path="claseSocial">
	    						<option value="aa">1. Alta - alta</option>
   								<option value="ab">2. Alta - baja</option>
   								<option value="ma">3. Media - alta</option>
   								<option value="m">4. Media</option>
   								<option value="t">5. Trabajadora</option>
   								<option value="ba">6. Baja - alta</option>
   								<option value="bb">7. Baja - baja</option>
	    					</form:select>
	    					<form:errors path="claseSocial"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="1. Vive con un patrimonio heredado y tiene familia famosa
    <br>2. Ha ganado altos ingresos mediante una capacidad excepcional en sus profesiones o negocios. Proviene de la clase media. 
    <br>3. Goza de buena posición como profesional, negociante independiente y administrador corporativo.
    <br>4.  Se compone de trabajadores manuales o técnicos que viven en barrios. Estimula a sus hijos para recibir educación universitaria.
    <br>5. Consiste de obreros de la clase trabajadora, sin importar sus ingresos, formación escolar o trabajo. 
    <br>6. Es gente que realiza trabajos no especializados y sus salarios son bajos. Presenta deficiencias educativas. 
    <br>7. Vive de la beneficencia social. Sus integrantes suelen estar desempleados."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-6">
	    					<label for="estadoCivil">Estado civil:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="¿Cual es tu estado civil?"></span>
	    					<form:select class="form-control" path="estadoCivil">
	    						<option value="soltero">Soltero/a</option>
   								<option value="comprometido">Comprometido/a</option>
   								<option value="casado">Casado/a</option>
   								<option value="separado">Separado/a</option>
   								<option value="divorciado">Divorciado/a</option>
   								<option value="viudo">Viudo/a</option>
	    					</form:select>
	    					<form:errors path="estadoCivil"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="¿Cual es tu estado civil?"></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-6">
	    					<label for="cargas">Cargas familiares:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="¿Tienes cargas familiares?"></span>
	    					<form:select class="form-control" path="cargas">
	    						<option value="si-cargas">Sí</option>
   								<option value="no-cargas">No</option>
	    					</form:select>
	    					<form:errors path="cargas"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="¿Tienes cargas familiares?"></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-6">
	    					<label for="titulo">Título de la consulta:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Título de tu consulta."></span>
	    					<form:input class="form-control" path="titulo"/>
	    					<form:errors path="titulo"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Título de tu consulta."></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-6">
	    					<label for="comentarios">Comentarios:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="¿Tienes algún comentario?"></span>
	    					<form:textarea class="form-control" path="comentarios" rows="4"/>
	    					<form:errors path="comentarios"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="¿Tienes algún comentario?"></span>
  					</div>
  					<br>
  					<div class="row">
	  					<div class="col-md-6">
	    					<label for="url">Enlace al contrato:</label>
	    					<span class="fa fa-info pull-right hidden-md hidden-lg" data-toggle="tooltip" data-placement="left" 
	    					title="Enlace al contrato de tu consulta."></span>
	    					<form:input class="form-control" path="url"/>
	    					<form:errors path="url"></form:errors>
	  					</div>
	  					<span class="fa fa-info input-info hidden-sm hidden-xs" data-toggle="tooltip" data-placement="right" 
	    				title="Enlace al contrato de tu consulta."></span>
  					</div>
  					<br>
				  	<input type="submit" class="btn btn-default last-element" value="Enviar consulta">
				</form:form>
				
			</div>
        </main>
        
        <jsp:include page="/WEB-INF/views/footer.jsp">
        	<jsp:param name="lastUpdate" value="7 de Junio de 2016"/>
    	</jsp:include>
       
       	<script src="/resources/js/tooltip-script.js"></script>
       
    </body>
</html>