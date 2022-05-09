<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invalid User page</title>
</head>
<body>
<%if(request.getAttribute("error")!=null){ %>
<%=request.getAttribute("error") %>
<%} %>
<br>
<a href="HomePage.html">Login</a>
</body>
</html>