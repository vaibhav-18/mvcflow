<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet, JSP and JDBC CRUD Operations</title>
<link rel="stylesheet" type="text/css" href="common.css">
</head>
<body>
	<h1 align="center">List of Customers</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td>${customer.id}</td>
				<td>${customer.firstName}</td>
				<td>${customer.lastName}</td>
				<td>${customer.email}</td>
				<td>${customer.mobile}</td>
				
				<td>
					<form action="<c:url value="/customer"/>" method="get">
						<input type="hidden" name="custId" value="${customer.id}">
						<input type="submit" value="Edit">
					</form>
				<td>
					<form action="<c:url value="/customer"/>">
						<input type="hidden" name="custId" value="${customer.id}">
						<input type="hidden" name="_method" value="DELETE">
						<input style="background: #F00;" type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<center>
	<a href="adduserform.jsp">Add User</a>
	</center>
</body>
</html>
