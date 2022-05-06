<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
<%String username =(String)request.getSession().getAttribute("username"); %>
<h2>Hello <%=username %> </h2>
<br>
<form action="/SessionManagementInServlets/ViewServlet" method="get"><button type="submit">View profile</button></form>
</body>
<%@include file="Footer.jsp" %>
</html>