<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Success Page</h1>
	<h1>time: ${time}</h1>
	<h1>names: ${requestScope.names }</h1>
	<h1>user: ${sessionScope.user} }</h1>
	<h1>school: ${sessionScope.school }</h1>
	<h1>
		<fmt:message key="i18n.username"></fmt:message>
		<br>
		<fmt:message key="i18n.password"></fmt:message>
		<br><br>
		<a href="I18N2">I18N2 PAGE</a>
	</h1>
</body>
</html>