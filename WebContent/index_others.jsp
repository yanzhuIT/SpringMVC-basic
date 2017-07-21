<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-3.2.1.js"></script>

</head>
<body>
	<!-- upload file, test returning -->
	<form action="testHttpMessageConvert" method="post"
		enctype="multipart/form-data">
		File: <input type="file" name="file"><br> Desc: <input
			type="text" name="desc"><br> <input type="submit"
			value="upload">
	</form>
	<br>
	<br>
	<!-- download file -->
	<a href="testResponseEntity">testResponseEntity</a>
	<br>
	<br>
	<!-- International display-->
	<a href="I18N">I18N PAGE</a>
	<br>
	<br>


	<form action="testFileUpload" method="POST"
		enctype="multipart/form-data">
		File: <input type="file" name="file" /> Desc: <input type="text"
			name="desc" /> <input type="submit" value="Submit" />
	</form>
</body>
</html>