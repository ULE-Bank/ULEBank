<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	<h1>
		<fmt:message key="loginUserData" />
		<br>
	</h1>
	<c:out value="${model.mensajeEnFuncionDeMetodo}" />
	<br>
	<h1>Estos son todos los usuarios. Sólo los puede ver el admin.</h1>
	<c:forEach items="${model.todosLosUsuarios}" var="userAdmin">
		<table>
			<tr>
				<th>Name</th>
				<th>Last Name</th>
				<th>eMail</th>
				<th>password</th>
			</tr>
			<tr>
				<td><c:out value="${userAdmin.name}" /></td>
				<td><c:out value="${userAdmin.lastname}" /></td>
				<td><c:out value="${userAdmin.email}" /></td>
				<td><c:out value="${userAdmin.password}" /></td>
			</tr>
		</table>
		<br>
		<br>
	</c:forEach>
	<p>
		<fmt:message key="loginUserPermission" />
		<c:out value="${model.userPermits}" />
	</p>
	<br>
	<p>
		<a href="/inicio">Volver a Login</a>
	</p>
</html>