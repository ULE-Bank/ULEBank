<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="loginTitle" />
	</h1>
	<p>
		<fmt:message key="loginUserData" />
		<c:out value="${model.userName}" />
		<c:out value="${model.userEmail}" />
		<c:out value="${model.userPassword}" />
	</p>
	<p>
		<fmt:message key="LoginUserPermission" />
		<c:out value="${model.userPassword}" />
	</p>
	<br>
	<p><a href="/inicio">Volver a Login</a></p>
</html>