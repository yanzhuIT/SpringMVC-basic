<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="helloworld">hello world</a>
	<br />
	<br />
	<a href="springmvc/testRequestMapping">Test RequestMapping</a>
	<br />
	<br />
	<form action="springmvc/testMethod" method="post">
		<input type="submit" value="submit" />
	</form>
	<br />
	<br />
	<a href="springmvc/testParamsAndHeaders?username=gibhub&age=11">Test
		ParamsAndHeaders</a>
	<br />
	<br />
	<a href="springmvc/testAntPath/xyz/abc">Test AntPath</a>
	<br />
	<br />
	<a href="springmvc/testathVariable/1">Test PathVariable</a>
	<br />
	<br />
	<a href="springmvc/testRest/1">Test Rest get</a>
	<br />
	<br />
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="testRestPost">
	</form>
	<br />
	<br />
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"> <input
			type="submit" value="testRestDelete">
	</form>
	<br />
	<br />
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"> <input
			type="submit" value="testRestPUT">
	</form>
	<br />
	<br />
	<a href="springmvc/testRequestParam?username=github&age=11">Test
		RequestParam</a>
	<br />
	<br />
	<a href="springmvc/testCookieValue">Test CookieValue</a>
	<br />
	<br />
	<form action="springmvc/testPojo" method="post">
		username: <input type="text" name="username"> <br>
		password: <input type="password" name="password"> <br>
		address.state: <input type="text" name="address.state"> <br>
		address.county: <input type="text" name="address.county"> <br>
		<input type="submit" value="submit">
	</form>
	<br><br>
	<a href="springmvc/testServletAPI">Test ServletAPI</a>
	<br><br>
</body>
</html>