<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0"> 
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
</head>
<body>
 <p align="center"><font size=" 3" color="#FF3300">用户注册</font></p>
<form id="form1" name="form1" method="post" action="addUserServlet">
<table width="340" border="0" align="center">
    <tr>
      <td width="141">用户名：</td>
      <td width="189"><label>
        <input name="user" type="text" id="user" />
      </label></td>
    </tr>
    <tr>
      <td>密码：</td>
      <td><label>
        <input name="pwd" type="password" id="pwd" />
      </label></td>
    </tr>
    <tr>
      <td>重输密码：</td>
      <td><label>
        <input name="pwd1" type="password" id="pwd1" />
      </label></td>
    </tr>
    <tr>
      <td>姓名：</td>
      <td><label>
        <input name="name" type="text" id="name" />
      </label></td>
    </tr>
    <tr>
      <td>性别：</td>
      <td><label>
        <input name="sex" type="radio" value="男" checked="checked" />
      男
      <input type="radio" name="***" value="女" />
      女</label></td>
    </tr>
    <tr>
      <td>年龄：</td>
      <td><label>
        <input name="age" type="text" id="age" />
      </label></td>
    </tr>
    <tr>
      <td><label>
        <input type="submit" name="Submit" value="提交" />
      </label></td>
      <td><label>
        <input type="reset" name="Submit2" value="重置" />
      </label></td>
    </tr>
</table>
</form>

</body>
</html>