<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人管理系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0"> 
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="style1.css">

</head>
<body>
<div align="center"> <font size=" 2" color="#FF6633">用户登录</font>
</div>
<form id="form1" name="form1" method="post" action="CheckUserServlet">
<table width="357" border="0" align="center">
    <tr>
      <td width="128">用户名：</td>
      <td width="219"><label>
        <input name="user" type="text" id="user" />
      </label></td>
    </tr>
    <tr>
      <td>密　码：</td>
      <td><label>
        <input name="pwd" type="password" id="pwd" />
      </label></td>
    </tr>
    <tr>
      <td><label>
        <input type="submit" name="Submit" value="登录" />
      </label></td>
      <td><label><a href="adduser.jsp">用户注册</a></label></td>
    </tr>
</table>
<p>&nbsp;</p>
</form>
</body>
</html>