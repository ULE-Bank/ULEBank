<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
   </head>
   <body>
   
   
  
   
   ${cliente.dni}
   
   ${cliente.name}
   
   ${cliente.lastName}
   
   ${cliente.email}
   
   ${cliente.fechaNacimiento}
   
   ${cliente.fechaDeAlta}
   
  <c:forEach var="direccion" items="${direcciones}"> 
  		${direccion.calle}
  		${direccion.localidad}
  		${direccion.comunidadAutonoma}
  		${direccion.numero}
  		${direccion.codigoPostal}
  </c:forEach>
   
   
   
      </body>
</html>