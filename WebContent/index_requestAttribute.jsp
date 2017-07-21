<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="testModelAndView"> test ModelAndView</a>
	<br>
	<br>
	<a href="testMap"> test Map</a>
	<br>
	<br>
	<a href="testSessionAttribute"> test SessionAttribute</a>
	<br>
	<br>
	<!-- simulate values from database, cannot edit password-->
	<form action="testModelAttribute" method="post">
	<input type="hidden" name="id" value="1">
	username: <input type="text" name="username" value="Tom">
	<input type="submit" value="submit">
	</form>  
	<br><br>
	<a href="testSelfView">test SelfView</a>
	<br><br>
	<a href="testRedirect">test redirect</a>
</body>
</html>