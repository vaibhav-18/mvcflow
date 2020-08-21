<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet, JSP and JDBC CRUD Operations</title>
<link rel="stylesheet" type="text/css" href="common.css">

</head>

<body>
	<h1 align="center">Edit the Form</h1>
	
	<form action="<c:url value="/customer"/>" method="put">
		<table>
				<tr>
					<td>Customer ID:</td>
					<td><input type="text" name="id" value="${customer.id}"
						readonly="readonly"></td>
				</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName"
					value="${customer.firstName}" required></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"
					value="${customer.lastName}" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="${customer.email}"
					required></td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><input type="tel" pattern="[789][0-9]{9}" name="mobile"
					value="${customer.mobile}" required></td>
			</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Update"></td>
				</tr>
		 <input type="hidden" name="_method" value="PUT">
		</table>
	</form>

</body>
</html>
