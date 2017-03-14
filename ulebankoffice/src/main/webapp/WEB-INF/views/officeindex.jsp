<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="description"
         content="Simulador de préstamo método Italiano.">
      <meta name="keywords"
         content="ULe-Bank, simulador, calculos, prestamo, metodo, italiano">
      <meta name="author" content="Razvan Raducu, Camino Fernández ">
      <meta name="robots" content="index,follow">
      <meta name="viewport"
         content="width=device-width, initial-scale=1, maximum-scale=1" />
      <link rel="alternate" hreflang="es" href="http://ule-bank.appspot.com/" />
      <link rel="stylesheet"
         href="/resources/services/css/font-awesome/css/font-awesome.min.css">
      <link rel="stylesheet"
         href="/resources/services/css/styles-responsive.css">
      <script src="/resources/services/js/jquery.min.js"></script>
      <!-- <script src="/resources/services/js/bootstrap.min.js"></script> -->
      <script src="/resources/services/js/jquery-cookie.js"></script>
      <script src="/resources/services/js/script.js"></script>
      <script src="/resources/services/js/Chart.js"></script>
      <!-- Favicon -->
      <link rel="shortcut icon" href="../favicon.ico" />
      <!-- bootstrap -->
      <link href="resources/template/css/bootstrap.min.css" rel="stylesheet"
         type="text/css" />
      <!-- plugins -->
      <link href="resources/template/css/plugins-css.css" rel="stylesheet"
         type="text/css" />
      <!-- mega menu -->
      <link href="resources/template/css/mega-menu/mega_menu.css"
         rel="stylesheet" type="text/css" />
      <!-- default -->
      <link href="resources/template/css/default.css" rel="stylesheet"
         type="text/css" />
      <!-- main style -->
      <link href="resources/template/css/style.css" rel="stylesheet"
         type="text/css" />
      <!-- responsive -->
      <link href="resources/template/css/responsive.css" rel="stylesheet"
         type="text/css" />
      <!-- custom style -->
      <link href="resources/template/css/custom.css" rel="stylesheet"
         type="text/css" />
      <title>Bienvenido a la oficina ulebanks</title>
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
      <div class="page-wrapper">
         <!--=================================
            preloader -->
         <div id="preloader">
            <div class="clear-loading loading-effect">
               <span></span>
            </div>
         </div>
         <!--=================================
            preloader -->
         <!--=================================
            header -->
         <jsp:include page="/WEB-INF/views/header.jsp" />
         <!--=================================
            header -->
         <!--=================================
            inner-intro-->
         <section
            class="inner-intro grayscale bg-office bg-opacity-black-70">
            <div class="container">
               <div class="row text-center intro-title">
                  <h1 class="text-blue">
                     Bienevnido a la oficina 
                  </h1>
                  <ul class="page-breadcrumb">
                     <li>
                        <a href="./">
                           <i class="fa fa-home"></i> 
                           <spring:message
                              code="label.sitehome" />
                        </a>
                        <i class="fa fa-angle-double-right"></i>
                     </li>
                     <li>
                        <a href="./#services">
                           <spring:message
                              code="label.siteservices" />
                        </a>
                        <i
                           class="fa fa-angle-double-right"></i>
                     </li>
                     <li>
                        <a href="/loans">
                           <spring:message
                              code="label.siteservice4" />
                        </a>
                        <i
                           class="fa fa-angle-double-right"></i>
                     </li>
                     <li>
                        <span>
                           Oficina
                        </span>
                     </li>
                  </ul>
               </div>
            </div>
         </section>
         <!--=================================
            inner-intro-->
         <section class="white-bg page-section-ptb" id="clientes">
            <div class="container">
               <div class="row">
                  <div class="col-md-8 col-md-offset-2">
<%--                      <form:form role="form" method="post" --%>
<%--                         modelAttribute="mongoDocument" id="servicesform"> --%>
<!--                         <div id="register-form" class="register-form"> -->
<!--                            <div class="row"> -->
<!--                               <div class="section-field col-md-6"> -->
<!--                                  <label for="name">Serie:</label> -->
<!--                               </div> -->
<!--                            </div> -->
<!--                            <div class="row"> -->
<!--                               <div class="section-field col-md-6"> -->
<!--                                  <div class="field-widget"> -->
<!--                                     <i class="fa fa-eur"></i> -->
<%--                                     <form:input type="text" value="" path="serie" /> --%>
<!--                                  </div> -->
<!--                               </div> -->
<!--                            </div> -->
<!--                            <div class="row"> -->
<!--                               <div class="section-field col-md-6"> -->
<%--                                  <form:errors style="color: red;" path="serie"></form:errors> --%>
<!--                               </div> -->
<!--                            </div> -->
<!--                            <div class="row"> -->
<!--                               <div class="section-field col-md-6"> -->
<!--                                  <label for="name">Nombre</label> -->
<!--                               </div> -->
<!--                            </div> -->
<!--                            <div class="row"> -->
<!--                               <div class="section-field col-md-6"> -->
<!--                                  <div class="field-widget"> -->
<!--                                     <i class="fa fa-percent"></i> -->
<%--                                     <form:input type="text" path="name" /> --%>
<!--                                  </div> -->
<!--                               </div> -->
<!--                            </div> -->
<!--                            <div class="row"> -->
<!--                               <div class="section-field col-md-6"> -->
<%--                                  <form:errors style="color: red;" path="name"></form:errors> --%>
<!--                               </div> -->
<!--                            </div> -->
<!--                            <div class="row"> -->
<!--                               <div class="section-field col-md-6"> -->
<!--                                  <label for="name">DNI:</label> -->
<!--                               </div> -->
<!--                            </div> -->
<!--                            <div class="row"> -->
<!--                               <div class="section-field col-md-6"> -->
<!--                                  <div class="field-widget"> -->
<!--                                     <i class="fa fa-clock-o"></i> -->
<%--                                     <form:input type="text" name="name" path="DNI" /> --%>
<!--                                  </div> -->
<!--                               </div> -->
<!--                            </div> -->
<!--                            <div class="row"> -->
<!--                               <div class="section-field col-md-6"> -->
<%--                                  <form:errors style="color: red;" path="DNI"></form:errors> --%>
<!--                               </div> -->
<!--                            </div> -->
<!--                            <div class="row"> -->
<!--                               <div class="section-field col-md-6"> -->
<!--                                  <label for="name">Ruta:</label> -->
<!--                               </div> -->
<!--                            </div> -->
<!--                            <div class="row"> -->
<!--                               <div class="section-field col-md-6"> -->
<!--                                  <div class="field-widget"> -->
<!--                                     <i class="fa fa-clock-o"></i> -->
<%--                                     <form:input type="text" name="name" path="ruta" /> --%>
<!--                                  </div> -->
<!--                               </div> -->
<!--                            </div> -->
<!--                            <div class="row"> -->
<!--                               <div class="section-field col-md-6"> -->
<%--                                  <form:errors style="color: red;" path="ruta"></form:errors> --%>
<!--                               </div> -->
<!--                            </div> -->
<!--                         </div> -->
<!--                         <div class="row"> -->
<!--                            <a class="button mt-20" id="submitservices" -->
<!--                               onclick="document.getElementById('servicesform').submit()"> -->
<!--                               <span> -->
<%--                                  <spring:message code="label.calculate" /> --%>
<!--                               </span> -->
<!--                               <i -->
<!--                                  class="fa fa-calculator"></i> -->
<!--                            </a> -->
<!--                            En caso de que algún usuario tenga desactivado javascript, saldrá este mensaje por defecto. -->
<!--                            <noscript> -->
<!--                               <input type="submit" -->
<%--                                  value="<spring:message code="label.calculate"/>" /> --%>
<!--                            </noscript> -->
<!--                         </div> -->
<%--                      </form:form> --%>


					<div class="row"> 
					<a class="button mt-20"  id="mostrarFormularioBusquedaClientes"> <span> Buscar clientes </span> <i class ="fa fa-send"></i></a>
					
					<form action="" class="formularioBusquedaClientes" style="display: none;">
                      <div id="register-form" class="register-form"> 
                    <div class="section-field col-md-12">
                     DNI/NIE:
                     <div class="field-widget">
                      
                          <i class="fa fa-home"></i> 
                          <input class="" type="text" required name="u" placeholder="Identificación fiscal del cliente" >
                     </div> 
                     </div> 
                     
                 
                     <input class="col-md-3 col-md-offset-2" type="submit" value="Buscar cliente" onclick="window.location.href='/o#clientes'">
                     <a href="./o#clientes"><input class="col-md-3 col-md-offset-2" type="button" value="Limpiar búsqueda" onclick="history.go(0)"></a> 
                    
                      </div>
                     </form>
                     </div>
                     
                     <div class ="row formularioBusquedaClientes mt-20" style="display: none;">
                     <table border="1" class="col-md-12">
                        <thead>
                           <tr>
                              <!--       						<th><input type="checkbox"></th> -->
<!--                               <th>id</th> -->
  <th>DNI/NIE</th>
                              <th>Nombre</th>
                              <th>Apellidos</th>
                              <th>email</th>
                              <th>Fecha nacimiento</th>
                            
                           </tr>
                        </thead>
                        <c:forEach var="clients" items="${client}">
                           <tr>
<%--                               <td>${client.id}</td> --%>
<td>${client.DNI}</td>
                              <td>${client.name}</td>
                              <td>${client.lastname}</td>
                              <td>${client.email}</td>
                              <td>${client.fechaNacimiento}</td>
                              
<!--                               <td><input type="button" value="delete" -->
<%--                                  onclick="window.location='person/delete?id=${document.id}'" /></td> --%>
                           </tr>
                        </c:forEach>
                     </table>
                     </div>
                   
                     <div class="row"> 
                     <a class="button mt-20"  id="mostrarFomrularioNuevoCliente"> <span> Crear cliente </span> <i class ="fa fa-send"></i></a>
                     <a class="button mt-20"  > <span> Historial expedientes </span> <i class ="fa fa-send"></i></a>
                     <a class="button mt-20"  > <span> Cerrar sesión </span> <i class ="fa fa-send"></i></a>
                     </div>
                     <script>
                     //jQuery para mostrar u ocultar el formulario de creación de nuevo cliente
                     $("#mostrarFomrularioNuevoCliente").click(function(){
                    	 form = $("#formularioNuevoCliente");
                    	 if (form.css('display') == 'none') {
                    		 form.show(1000);
						} else {
							form.hide(1000);
						}
                     });
                     
                     $("#mostrarFormularioBusquedaClientes").click(function(){
                    	 form = $(".formularioBusquedaClientes");
                    	 if (form.css('display') == 'none') {
                    		 form.show(1000);
						} else {
							form.hide(1000);
						}
                     });   
                     
                     function dardealtacliente(){
                    	 $("#submit_handle").click();
                     }
                     </script>
                     
                      <form style="display: none;" id="formularioNuevoCliente" method="post">
                      <div id="register-form" class="register-form"> 
                     <div class="row">
                     <div class="section-field col-md-12">
                     <div class="row">
                     <h2>Datos personales cliente</h2>
                     </div>
                     <div class="row">
                     <div class="col-md-6">
                    
                     DNI: 
                     <div class="field-widget">
                          <i class="fa fa-home"></i> 
                          <spring:bind path="nuevoCliente.dni">
                          <input class="" type="text" required/>
                          </spring:bind>
                          <form:errors style="color: red;" path="dni"></form:errors>
                     </div> 
                     </div>
                     <div class="col-md-6">
                     Nombre: 
                     <div class="field-widget">
                          <i class="fa fa-home"></i> 
                          <spring:bind path="nuevoCliente.name">
                          <input class="" type="text" required/>
                          </spring:bind>
                           <form:errors style="color: red;" path="name"></form:errors>
                     </div>
                     </div> 
                     </div>
                      <div class="row">
                     <div class="col-md-6">
                     Apellidos: 
                     <div class="field-widget">
                          <i class="fa fa-home"></i> 
                          <input class="" type="text" required name="u" />
                     </div> 
                       </div> 
                      <div class="col-md-6">
                      Email: 
                     <div class="field-widget">
                          <i class="fa fa-home"></i> 
                          <input class="" type="email" required name="u" />
                     </div> 
                      </div> 
                      </div> 
                     <div class="row">
                     <div class="col-md-6">
                     Fecha de nacimiento: 
                     <div class="field-widget">
                          <i class="fa fa-home"></i>  
                          <input id="datePicker" type="date" class="" required name="u" />
                     </div> 
                     </div> 
                      </div>
                       <div class="row">
                     <h2>Dirección cliente</h2>
                     </div>
                     
                      <div class="row">
                     <div class="col-md-6">
                     Comunidad autónoma: 
                     <div class="field-widget">
                          <i class="fa fa-home"></i> 
                          <input class="" type="text" required name="u"  >
                     </div> 
                     </div>
                     <div class="col-md-6">
                     Localidad: 
                     <div class="field-widget">
                          <i class="fa fa-home"></i> 
                          <input class="" type="text"  name="u" />
                     </div>
                      </div> 
                      </div> 
                     
                     
                      <div class="row">
                     <div class="col-md-4">
                     Calle: 
                     <div class="field-widget">
                          <i class="fa fa-home"></i> 
                          <input class="" type="text" required name="u" >
                     </div>
                     </div>
                     <div class="col-md-4">
                     Numero: 
                     <div class="field-widget">
                          <i class="fa fa-home"></i> 
                          <input class="" type="text" required name="n" >
                     </div>
                     </div>
                      <div class="col-md-4">
                     Código postal: 
                     <div class="field-widget">
                          <i class="fa fa-home"></i> 
                          <input class="" type="text" required name="n" >
                     </div>
                     </div>
                     </div>
   </div> 
                    
                 
                     <div class="row">
                      <a class="button mt-20"  onclick="dardealtacliente()"> <span> Dar de alta cliente </span> <i class ="fa fa-send"></i></a>
                     <input id="submit_handle" type="submit" style="display: none" >
                      </div>
                      </div>
                      </div>
                     </form>
                  </div>
               </div>
            </div>
         </section>
         <!--=================================
            Footer-->
         <jsp:include page="/WEB-INF/views/footer.jsp" />
         <!--=================================
            Footer-->
      </div>
      <script src="resources/services/js/tooltip-script.js"></script>
      <!-- bootstrap -->
      <script type="text/javascript"
         src="resources/template/js/bootstrap.min.js"></script>
      <!-- plugins-jquery -->
      <script type="text/javascript"
         src="resources/template/js/plugins-jquery.js"></script>
      <!-- mega menu -->
      <script type="text/javascript"
         src="resources/template/js/mega-menu/mega_menu.js"></script>
      <!-- custom -->
      <script type="text/javascript" src="resources/template/js/custom.js"></script>
   </body>
</html>