<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
      <link href="/resources/template/css/bootstrap.min.css" rel="stylesheet"
         type="text/css" />
      <!-- plugins -->
      <link href="/resources/template/css/plugins-css.css" rel="stylesheet"
         type="text/css" />
      <!-- mega menu -->
      <link href="/resources/template/css/mega-menu/mega_menu.css"
         rel="stylesheet" type="text/css" />
      <!-- default -->
      <link href="/resources/template/css/default.css" rel="stylesheet"
         type="text/css" />
      <!-- main style -->
      <link href="/resources/template/css/style.css" rel="stylesheet"
         type="text/css" />
      <!-- responsive -->
      <link href="/resources/template/css/responsive.css" rel="stylesheet"
         type="text/css" />
      <!-- custom style -->
      <link href="/resources/template/css/custom.css" rel="stylesheet"
         type="text/css" />
      <title>Oficina ulebank</title>
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
                     Sucursal bancaria
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
                  <div class="col-md-12">
                     <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <fieldset style="border: 1px solid #ff0000">
                           <legend>Controles administrador</legend>
                           <h3>Empleados de la sucursal</h3>
                           <c:if test="${param.errorRegistroEmpleado != null}"> <h2 style="color:red">${param.errorRegistroEmpleado}</h2></c:if>
                           <div style="height:150px; overflow:auto;">
                              <table border="1"  class="col-md-12" >
                                 <tr style="color:white;background-color:rgb(0,169,218);">
                                    <th>Nombre</th>
                                    <th>Privilegios</th>
                                    <th></th>
                                 </tr>
                                 <c:forEach var="employee" items="${employees}">
                                    <tr>
                                       <td>${employee.userName}</td>
                                       <td>${employee.role}</td>
                                       <c:if test="${employee.role != 'admin' }"><td><a href="/o/admin/d?ein=${employee.userName}">Eliminar</a></td></c:if>
                                    </tr>
                                 </c:forEach>
                              </table>
                           </div>
                           <div class="row col-md-12">
                        <a class="button mt-20"  id="mostrarFomrularioNuevoEmpleado"> <span> Crear empleado </span> <i class ="fa fa-send"></i></a>
                        <!--                      <a class="button mt-20"  > <span> Historial expedientes </span> <i class ="fa fa-send"></i></a> -->
                     </div>
                     <div class="row col-md-12">
                           <form:form style="display: none;" id="formularioNuevoEmpleado" method="post" action="/o/admin/submitEmployee" modelAttribute="nuevoEmpleado">
                              <div id="register-form" class="register-form">
                                 <div class="row">
                                    <div class="section-field col-md-12">
                                       <div class="row col-md-12">
                                          <h2>Datos nuevo empleado:</h2>
                                       </div>
                                       <div class="row">
                                          <div class="col-md-4">
                                             Usuario 
                                             <div class="field-widget">
                                                <i class="fa fa-user"></i> 
                                                <form:input path="userName" type="text" required="required"/>
                                                <form:errors style="color: red;" path="userName"></form:errors>
                                             </div>
                                          </div>
                                          <div class="col-md-4">
                                             Contraseña: 
                                             <div class="field-widget">
                                                <i class="fa fa-unlock-alt"></i> 
                                                <form:input path="password" class="" type="password" required="required"/>
                                                <form:errors style="color: red;" path="password"></form:errors>
                                             </div>
                                          </div>
                                     
                                          <div class="col-md-4">
                                             Privilegios: 
                                             <div class="field-widget">
                                                <form:select path="role" id="rol">
                                                   <form:option value="empleado" label="Empleado" />
                                                   <form:option value ="supervisor" label="Supervisor" />
                                                </form:select>
                                             </div>
                                          </div>
                                          </div>
                                          
                                          <div class="row col-md-12">
                                             <a class="button mt-20"  onclick="darDeAltaEmployee()"> <span> Dar de alta empleado </span> <i class ="fa fa-send"></i></a>
                                             <input id="submit_handle_employee" type="submit" style="display: none" />
                                          </div>
                                       
                                    </div>
                                 </div>
                              </div>
                           </form:form>
                           </div>
                        </fieldset>
                     </sec:authorize>
                     <h2>${error}</h2>
                     <div class="row">
                        <form method=get>
                           <div id="register-form" class="register-form">
                              <div class="section-field col-md-12">
                                 DNI/NIE:
                                 <div class="field-widget">
                                    <i class="fa fa-home"></i> 
                                    <input class="" type="text" required name="uin" placeholder="Identificación fiscal del cliente" >
                                 </div>
                              </div>
                              <input maxlength="9" class="col-md-3 col-md-offset-2" type="submit" value="Buscar cliente">
                              <a href="./o#clientes"><input class="col-md-3 col-md-offset-2" type="button" value="Limpiar búsqueda" onclick="history.go(0)"></a> 
                              <div class="col-md-12" style="text-align:center; color:red;">
                                 <h3 style="color:red;">${clientError}</h3>
                              </div>
                           </div>
                        </form>
                     </div>
                     <div class ="row mt-20" >
                        <div style="height:300px; overflow:auto;">
                           <table border="1"  class="col-md-12" >
                              <tr style="color:white;background-color:rgb(0,169,218);">
                                 <th>DNI/NIE</th>
                                 <th>Nombre</th>
                                 <th>Apellidos</th>
                                 <th>e-Mail</th>
                                 <th>Fecha nacimiento</th>
                              </tr>
                              <c:forEach var="client" items="${clients}">
                                 <tr>
                                    <%--                               <td>${client.id}</td> --%>
                                    <td><a href="/o/u?uin=${client.dni}">${client.dni}</a></td>
                                    <td>${client.name}</td>
                                    <td>${client.lastName}</td>
                                    <td>${client.email}</td>
                                    <td>${client.fechaNacimiento}</td>
                                    <!--                               <td><input type="button" value="delete" -->
                                    <%--                                  onclick="window.location='person/delete?id=${document.id}'" /></td> --%>
                                 </tr>
                              </c:forEach>
                           </table>
                        </div>
                     </div>
                     <div class="row">
                        <a class="button mt-20"  id="mostrarFomrularioNuevoCliente"> <span> Crear cliente </span> <i class ="fa fa-send"></i></a>
                        <!--                      <a class="button mt-20"  > <span> Historial expedientes </span> <i class ="fa fa-send"></i></a> -->
                        <a href="/o/logout" class="button mt-20"  > <span> Cerrar sesión </span> <i class ="fa fa-send"></i></a>
                     </div>
                     
                     <form:form style="display: none;" id="formularioNuevoCliente" method="post" modelAttribute="nuevoCliente">
                        <div id="register-form" class="register-form">
                           <div class="row">
                              <div class="section-field col-md-12">
                                 <div class="row col-md-12">
                                    <h2>Datos personales cliente</h2>
                                 </div>
                                 <div class="row">
                                    <div class="col-md-6">
                                       DNI: 
                                       <div class="field-widget">
                                          <i class="fa fa-home"></i> 
                                          <form:input path="dni" type="text" required="required"/>
                                          <form:errors style="color: red;" path="dni"></form:errors>
                                       </div>
                                    </div>
                                    <div class="col-md-6">
                                       Nombre: 
                                       <div class="field-widget">
                                          <i class="fa fa-home"></i> 
                                          <form:input path="name" class="" type="text" required="required"/>
                                          <form:errors style="color: red;" path="name"></form:errors>
                                       </div>
                                    </div>
                                 </div>
                                 <div class="row">
                                    <div class="col-md-6">
                                       Apellidos: 
                                       <div class="field-widget">
                                          <i class="fa fa-home"></i> 
                                          <form:input path="lastName" class="" type="text" required="required" name="u" />
                                          <form:errors style="color: red;" path="lastName"></form:errors>
                                       </div>
                                    </div>
                                    <div class="col-md-6">
                                       Email: 
                                       <div class="field-widget">
                                          <i class="fa fa-home"></i> 
                                          <form:input path="email" class="" type="email" required="required" name="u" />
                                          <form:errors style="color: red;" path="email"></form:errors>
                                       </div>
                                    </div>
                                 </div>
                                 <div class="row">
                                  <div class="col-md-6">
                                       Nacionalidad: 
                                       <div class="field-widget">
                                          <i class="fa fa-home"></i> 
                                          <form:input path="nacionalidad" class="" type="text" required="required" name="u" />
                                          <form:errors style="color: red;" path="nacionalidad"></form:errors>
                                       </div>
                                    </div>
                                 
                                    <div class="col-md-6">
                                       Fecha de nacimiento: 
                                       <div class="field-widget">
                                          <i class="fa fa-home"></i>  
                                          <form:input path="fechaNacimiento" id="datePicker" type="date" 
                                             required="required" name="u" />
                                          <form:errors style="color: red;" path="fechaNacimiento"></form:errors>
                                       </div>
                                    </div>
                                 </div>
                                 <div class="row col-md-12">
                                    <a class="button mt-20"  onclick="darDeAltaClient()"> <span> Dar de alta cliente </span> <i class ="fa fa-send"></i></a>
                                    <input id="submit_handle_client" type="submit" style="display: none" />
                                 </div>
                              </div>
                           </div>
                        </div>
                     </form:form>
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
      
      function darDeAltaClient(){
          $("#submit_handle_client").click();
         }
      
      function darDeAltaEmployee(){
       $("#submit_handle_employee").click();
      }
      
      //jQuery para mostrar u ocultar el formulario de creación de nuevo empleado
      $("#mostrarFomrularioNuevoEmpleado").click(function(){
       form = $("#formularioNuevoEmpleado");
       if (form.css('display') == 'none') {
      	 form.show(1000);
      } else {
      form.hide(1000);
      }
      });
      </script>
      <script src="/resources/services/js/tooltip-script.js"></script>
      <!-- bootstrap -->
      <script type="text/javascript"
         src="/resources/template/js/bootstrap.min.js"></script>
      <!-- plugins-jquery -->
      <script type="text/javascript"
         src="/resources/template/js/plugins-jquery.js"></script>
      <!-- mega menu -->
      <script type="text/javascript"
         src="/resources/template/js/mega-menu/mega_menu.js"></script>
      <!-- custom -->
      <script type="text/javascript" src="/resources/template/js/custom.js"></script>
   </body>
</html>