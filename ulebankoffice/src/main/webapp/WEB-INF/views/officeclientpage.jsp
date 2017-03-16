<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
   </head>
   <body>
   
   <c:forEach var="cliente" items="${cliente}">
  
   
   ${cliente.dni}
   
   ${cliente.name}
   
   ${cliente.lastname}
   
   ${cliente.email}
   
   ${cliente.fechaNacimiento}
   
   ${cliente.direccion}
   </c:forEach>
   
   
      </body>
</html>