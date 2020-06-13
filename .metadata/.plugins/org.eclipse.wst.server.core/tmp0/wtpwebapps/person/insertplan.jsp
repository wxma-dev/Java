<%@ page language="java" contentType="text/html; charset=utf-8"
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
	
<title>插入</title>
</head>
<body>

	<form action="InsertPlanServlet">
	<table align="center" width="100%">
		<tr>
			<td width="20%">
				<label for='label1'>计划（任务）名称</label>
			</td>
			<td width="80%">
				<textarea name="textarea_sPlan_name" cols ="50" rows = "3"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label for='label2'>耗时（天）</label>
			</td>
			<td>
				<textarea name="textarea_sDatenum_consuming" cols ="50" rows = "1"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label for='label2'>间隔（天）</label>
			</td>
			<td>
				<textarea name="textarea_sDatenum_interval" cols ="50" rows = "1"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label for='label3'>备注说明</label>
			</td>
			<td>
				<textarea name="textarea_sByy" cols ="50" rows = "10"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label for='label4'>重要性</label>
			</td>
			<td>
				<textarea name="textarea_sImportance" cols ="50" rows = "1"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label for='label5'>紧急性</label>
			</td>
			<td>
				<textarea name="textarea_sEmergency" cols ="50" rows = "1"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label for='label6'>完成情况</label>
			</td>
			<td>
				<textarea name="textarea_sComplete_flag" cols ="50" rows = "1"></textarea>
			</td>
		</tr>
		<tr>
			<th colspan="2"  >
				<input type="submit" value="插入提交" />
			</th>
		</tr>
	</table>
	</form>

</body>
</html>