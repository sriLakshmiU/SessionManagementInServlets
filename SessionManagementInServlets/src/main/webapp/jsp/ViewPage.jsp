<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.jsp" isErrorPage="false"%>
    <%@page import= "pojo.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View page</title>
</head>
<body>
 <jsp:useBean id="user" type="pojo.User" scope="session" ></jsp:useBean> 
<p>Your profile</p>
<p>Username:</p><jsp:getProperty name="user" property="userName"/>
<p>Firstname:</p><jsp:getProperty property="firstName" name="user"/>
<p>Lastname:</p><jsp:getProperty property="lastName" name="user"/>
<p>Phone:</p><jsp:getProperty property="phone" name="user"/>
<p>Email:</p><jsp:getProperty property="email" name="user"/>

</body>
<%@include file="Footer.jsp" %>
</html>