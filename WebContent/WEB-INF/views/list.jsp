<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		$(".delete").click(function(){
			var href=$(this).attr("href");
			$("form").attr("action", href).submit();
			return false;
		});
	})
</script>
</head>
<body>
	
	
	<!-- transform "POST" to "DELETE"-->
	<form action="" method="post">
		<input type="hidden" name="_method" value="DELETE">
	</form>

	<c:if test="${empty requestScope.employees}">
	no employee information
	</c:if>
	<c:if test="${!empty requestScope.employees }">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${requestScope.employees}" var="emp">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.gender == 0 ? "Femail" : "Male"  }</td>
					<td>${emp.department.departmentName }</td>
                    
                    <!-- tips: here "emp" in href is action name, like action in form -->
					<td><a class="edit" href="emp/${emp.id}">Edit</a></td>
					<!-- action name is also emp, but has a parameter and the method is "delete" -->
					<td><a class="delete"  href="emp/${emp.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<br>
	<!-- to adding employee page -->
	<a href="emp">Add an Employee</a>
</body>
</html>