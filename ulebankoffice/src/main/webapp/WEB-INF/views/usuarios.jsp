<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title><fmt:message key="title" /></title>
<meta charset="UTF-8">
</head>
<body>
	<h1>
		<fmt:message key="loginTitle" />
	</h1>
	<p>
		<h1><fmt:message key="loginUserData" /><br></h1>
		<c:out value="${model.mensajeEnFuncionDeMetodo}" /><br>
		<h1>Estos son todos los usuarios. Sólo los puede ver el admin.</h1>
		<c:out value="${model.todosLosUsuarios}" /><br>
	</p>
	<p>
		<fmt:message key="loginUserPermission" />
		<c:out value="${model.userPermits}" />
	</p>
	<br>
	<p><a href="/inicio">Volver a Login</a></p>
</html>