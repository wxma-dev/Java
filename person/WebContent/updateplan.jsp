<%@ page language="java" import="java.sql.*,java.io.*,java.util.*,java.text.SimpleDateFormat,java.util.Date" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<style type="text/css">
	table {
		border: 2px #CCCCCC solid;
		width: 90%;
	}

	td,th {
		height: 30px;
		border: #CCCCCC 1px solid;
	}
	textarea{
		 border:none;
		 overflow:hidden;
		 height:100%;
		 width:100%;
	 }
	</style>
	
<title>修改</title>
</head>
<body>
	<% 
	String sId                = new String (request.getParameter("id").getBytes("ISO8859_1"),"UTF-8");
	String sPlan_name         = new String (request.getParameter("plan_name").getBytes("ISO8859_1"),"UTF-8");
	String sDatenum_consuming = new String (request.getParameter("datenum_consuming").getBytes("ISO8859_1"),"UTF-8");
	String sDatenum_interval  = new String (request.getParameter("datenum_interval").getBytes("ISO8859_1"),"UTF-8");
	String sByy               = new String (request.getParameter("byy").getBytes("ISO8859_1"),"UTF-8");
	String sImportance        = new String (request.getParameter("importance").getBytes("ISO8859_1"),"UTF-8");
	String sEmergency         = new String (request.getParameter("emergency").getBytes("ISO8859_1"),"UTF-8");
	String sComplete_flag     = new String (request.getParameter("complete_flag").getBytes("ISO8859_1"),"UTF-8");
	%>

	<form action="UpdatePlanServlet">
	<table align="center" width="100%">
		<tr>
			<td width="20%">
				<label for='label1'>计划（任务）名称</label>
			</td>
			<td width="80%">
				<!--   input type="text" value="<% out.print(sPlan_name); %> "  style="height:100%;widtd:100%;" -->
				<textarea name="textarea_sPlan_name" cols ="50" rows = "3"><% out.print(sPlan_name.replaceAll("<br>","\r\n")); %></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label for='label2'>耗时（天）</label>
			</td>
			<td>
				<!-- input type="text" value="<% out.print(sDatenum_consuming); %> "  style="height:100%;widtd:100%;" -->
				<textarea name="textarea_sDatenum_consuming" cols ="50" rows = "1"><% out.print(sDatenum_consuming); %></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label for='label2'>间隔（天）</label>
			</td>
			<td>
				<!-- input type="text" value="<% out.print(sDatenum_interval); %> "  style="height:100%;widtd:100%;" -->
				<textarea name="textarea_sDatenum_interval" cols ="50" rows = "1"><% out.print(sDatenum_interval); %></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label for='label3'>备注说明</label>
			</td>
			<td>
				<!--  input type="text" value="<% out.print(sByy); %> "  style="height:100%;widtd:100%;" -->
				<textarea name="textarea_sByy" cols ="50" rows = "10"><% out.print(sByy.replaceAll("<br>","\r\n")); %></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label for='label4'>重要性</label>
			</td>
			<td>
				<!-- input type="text" value="<% out.print(sImportance); %> "  style="height:100%;widtd:100%;" -->
				<textarea name="textarea_sImportance" cols ="50" rows = "1"><% out.print(sImportance); %></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label for='label4'>紧急性</label>
			</td>
			<td>
				<textarea name="textarea_sEmergency" cols ="50" rows = "1"><% out.print(sEmergency); %></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label for='label5'>完成情况</label>
			</td>
			<td>
				<!-- input type="text" value="<% out.print(sComplete_flag); %> "  style="height:100%;widtd:100%;" -->
				<textarea name="textarea_sComplete_flag" cols ="50" rows = "1"><% out.print(sComplete_flag); %></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<input name="flag_del_an_plan" type="checkbox" value="1" />是否删除该记录
			</td>
			<th colspan="2"  >
				<input type="hidden" name="button_id" value="<% out.print(sId); %>" />
				<input type="submit" value="修改提交" />
			</th>
		</tr>
	</table>
	</form>
</body>
</html>