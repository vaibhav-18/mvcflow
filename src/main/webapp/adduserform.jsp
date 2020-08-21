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
	<h1 align="center">Registration Form</h1>
	<c:url value="/customer" var="registerUrl" />
	<form action="${registerUrl}" method="post">
		<table>
			<c:if test="${customer.id ne null}">
				<tr>
				<td>Customer ID:</td>
					<td><input type="text" name="id" value="${customer.id}" readonly="readonly"></td>
				</tr>
			</c:if>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" value="${customer.firstName}" required></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" value="${customer.lastName}" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="${customer.email}" required></td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><input type="tel" pattern="[789][0-9]{9}" name="mobile" value="${customer.mobile}" required></td>
			</tr>

			<c:if test="${customer.id ne null}">
				<tr>
					<td colspan="2"><input type="submit" value="Update"></td>
				</tr>
			</c:if>
			<c:if test="${customer.id eq null}">
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</c:if>
		</table>
	</form>
	
</body>
</html>
