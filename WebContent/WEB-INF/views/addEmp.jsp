<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- this modelAttribute name should be the same as the name of requestScope,
default name is command-->
	<!-- form label automatic handle displaying data if the data exists  -->
	<!-- path should be a absolute path -->
	<form:form action="${pageContext.request.contextPath }/emp"
		method="POST" modelAttribute="employee">
    <!-- display error information from validation -->
     <form:errors path="*"></form:errors>
     <br>
		<c:if test="${employee.id == null }">
			<!-- path equals "name" of html -->
     LastName: <form:input path="lastName" />
      <form:errors path="lastName"></form:errors>
		</c:if>
		<!-- if edit, last name cannot be edited -->
		<c:if test="${employee.id != null }">
			<form:hidden path="id" />
			<input type="hidden" name="_method" value="PUT" />
		</c:if>
		<br>
		<br>
		
     Email: <form:input path="email" />
     <form:errors path="email"></form:errors>
		<br>
		<br>
		<%
			Map<String, String> genders = new HashMap();
				genders.put("1", "Male");
				genders.put("0", "Female");
				request.setAttribute("genders", genders);
		%>
     Gender: 
     <br>
		<form:radiobuttons path="gender" items="${genders }" delimiter="<br>" />
		<br>
		<br>
     Department: <form:select path="department.id"
			items="${departments }" itemLabel="departmentName" itemValue="id"></form:select>
		<br>
		<br>
		Birthday: <form:input path="birth" />
		<br>
		<br>
		Salary: <form:input path="salary" />
		<br>
		<input type="submit" value="submit">
	</form:form>

</body>
</html>