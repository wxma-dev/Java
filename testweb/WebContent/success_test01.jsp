<%@ page language="java"  import="testweb.AccountBean" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    AccountBean account = (AccountBean)session.getAttribute("account");
    %>
    username:<%= account.getUsername()%>
     <br>
     password:<%= account.getPassword() %>
</body>
</html>