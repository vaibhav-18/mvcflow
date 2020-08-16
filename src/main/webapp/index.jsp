<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>SERVLET JSP MVC CRUD Example</title>  
</head>  
<body>  
<h1>MVC Flow</h1>  
<a href="adduserform.jsp">Add User</a>
	<c:url value="/user/viewUsers" var="viewUsers" />
	<form action="<%=request.getContextPath()%>/viewUsers" method="get">
	<input type="submit" value="View Users">
	</form>
  
</body>  
</html>  