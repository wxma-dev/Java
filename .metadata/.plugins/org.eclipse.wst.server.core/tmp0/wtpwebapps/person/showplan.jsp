<span style="font-size:12px;">
<span style="font-size:14px;">
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*,java.text.SimpleDateFormat,java.util.Date" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!--

创建计划表
create database person;
use person;
create table plan(
id                 int primary key auto_increment  COMMENT 'id号',
plan_name          varchar(1024) not null          COMMENT '计划（任务）名称',
datenum_consuming  int(50) not null                COMMENT '耗时（天）',
datenum_interval   int(50) not null                COMMENT '间隔（天）',
lastdate_review    date not null                   COMMENT '上次复习日期',
nextdate_review    date not null                   COMMENT '下次复习日期',
date_calculate     date not null                   COMMENT '计算时的日期',
byy                varchar(20480)                  COMMENT '备注',
importance         int(1) not null                 COMMENT '重要性',
count_review       int(50) not null                COMMENT '复习次数',
complete_flag      int(1) not null                 COMMENT '完成情况,0-未完成，1-完成'
);

alter table plan modify lastdate_review date default '2001-01-01';
alter table plan modify nextdate_review date default '2001-01-01';
alter table plan modify date_calculate date default '2001-01-01';
alter table plan modify count_review int(50) default 0;

alter table plan modify importance  int(10) not null COMMENT '重要性';
alter table plan modify complete_flag  int(10) not null COMMENT '完成情况';
alter table plan add emergency int(10) not null COMMENT '紧急性';

create table operation_record(
keystring      varchar(10) primary key not null    COMMENT 'key的值',
valuestring    varchar(255) not null               COMMENT 'value的值',
plan_data      date                                COMMENT '日期',
byy            varchar(1024) not null              COMMENT '备注'
);

-->

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
	</style>


	<title>日常规划计划</title>
	
	<link rel="stylesheet" href="style.css">
	
	
</head>
<body>
	<%
		//当天日期
		Date dt=new Date();
		SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
		String rq=matter1.format(dt);
	%>

	<%
		//驱动程序名
		String driverName = "com.mysql.jdbc.Driver";
		//数据库用户名
		String userName = "root";
		//密码
		String userPasswd = "q";
		//数据库名
		String dbName = "person";
		//表名
		String tableName = "plan";
		//连接字符串
		String url = "jdbc:mysql://localhost:3306/" + dbName + "?user="
				+ userName + "&password=" + userPasswd;  
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();

		/*
		如果下次复习的时间 小于 当前日期，
		则更新 上次复习的日期，规则: 上次复习日期=下次复习日期。
		SQL语句如下：
		update plan set lastdate_review=nextdate_review 
		where nextdate_review < (select date_format(now(),'%Y-%m-%d'));
		*/
		statement.executeUpdate( "update plan set lastdate_review= " +
				"nextdate_review " +
				"where nextdate_review < (select date_format(now(),'%Y-%m-%d'));" );

		/*
		如果下次复习的时间 小于 当前日期，
		则更新 下次复习的日期、复习次数，规则: 下次复习日期=上次复习日期 + 间隔天数 + 耗时天数 - 1;
			复习次数 = 复习次数 + 1。
		SQL语句如下：
		update plan set nextdate_review=DATE_ADD( lastdate_review, INTERVAL (datenum_interval+datenum_consuming - 1) DAY),
		count_review=count_review+1
		where nextdate_review < (select date_format(now(),'%Y-%m-%d'));
		*/
		statement.executeUpdate( "update plan set nextdate_review= " +
			"DATE_ADD( lastdate_review, INTERVAL (datenum_interval+datenum_consuming) DAY), " +
			"count_review=count_review+1 " +
			"where nextdate_review < (select date_format(now(),'%Y-%m-%d'));" );

		ResultSet rst = statement.executeQuery("select * from operation_record " +
			"where plan_data = '"+rq+"' and keystring='XCFXRQJS' " );
		String sUpdateCompFlag = "";
		while (rst.next())
		{
			sUpdateCompFlag = rst.getString(2);
		}
		
		if(!sUpdateCompFlag.trim().equals("1") )
		{
			/*
			整个表中数据更新为未完成
			SQL语句如下:
			update plan set complete_flag=0;
			*/
			statement.executeUpdate( "update plan set complete_flag=0;" );
			
			/*
			更新operation_record表中的相关字段
			*/
			statement.executeUpdate( "update operation_record set valuestring='1',plan_data='"+rq+"' " );
		}
		
		/*
		查询plan表中的数据
		当日的任务  and 复习正在进行中任务
		*/
		ResultSet rs = statement.executeQuery("SELECT plan_name,datenum_consuming,datenum_interval,lastdate_review,byy,importance,count_review,complete_flag,id,emergency " +
			"FROM plan where ( nextdate_review='"+rq+"' ) or " +
			" ( DATE_ADD( lastdate_review, INTERVAL datenum_consuming DAY ) >= '"+rq+"' ) order by complete_flag asc,importance desc,emergency desc");
	%>

	<input type="button" value="添加" onclick="window.open('insertplan.jsp','_blank','height=450,width=800')">
    

	<form action="UpdatePlanFinishFlagServlet">
		<table border="0"  align="center" width="100%">
			<tr>
				<th>
				<div class="text" style=" text-align:right;">重要性：3非常重要，2比较重要，1一般重要；急：    3非常急  ，2比较急  ，1一般急  。</div>
				<div class="text" style=" text-align:right;">严格按照这个顺序来做，做完第一件事情，再做第二件。</div>
				</th>
			</tr>
		</table>
	<table align="center" width="100%">
		<tr><th colspan="11" >今日计划规划</th></tr>
		<tr>
			<th>
				<%
					out.print("计划（任务）名称");
				%>
			</th>
			<th>
				<%
					out.print("耗时（天）");
				%>
			</th>
			<th>
				<%
					out.print("间隔（天）");
				%>
			</th>
			<th>
				<%
					out.print("上次复习日期");
				%>
			</th>
			<th>
				<%
					out.print("备注说明");
				%>
			</th>
			<th>
				<%
					out.print("重要性");
					/*
						重要性：3非常重要，2比较重要，1一般重要
					*/
				%>
			</th>
			<th>
				<%
					out.print("紧急性");
					/*
						紧急性： 3非常急  ，2比较急  ，1一般急 
					*/
				%>
			<th>
				<%
					out.print("复习次数");
				%>
			</th>
			<th>
				<%
					out.print("完成情况");
				%>
			</th>
			<th>
				<%
					out.print("完成情况更新");
				%>
			</th>
			<th>
				<%
					out.print("修改");
				%>
			</th>
		</tr>

		<%
			while (rs.next())
			{
		%>
		<tr>
			<td width="20%">
				<%
					out.print(rs.getString(1).replaceAll("\r\n", "<br>"));
				%>
			</td>
			<td width="3%">
				<%
					out.print(rs.getString(2));
				%>
			</td>
			<td width="3%">
				<%
					out.print(rs.getString(3));
				%>
			</td>
			<td width="10%">
				<%
					out.print(rs.getString(4));
				%>
			</td>
			<td width="35%">
				<%
					out.print(rs.getString(5).replaceAll("\r\n", "<br>"));
				%>
			</td>
			<td width="2.5%">
				<%
					out.print(rs.getString(6));
				%>
			</td>
			<td width="2.5%">
				<%
					out.print(rs.getString(10));
				%>
			</td>
			<td width="4%">
				<%
					out.print(rs.getString(7));
				%>
			</td>
			<td width="4%">
				<%
					String sFinishFlag = rs.getString(8);
					if ( sFinishFlag.equals( "0" ) )
					{
						out.print( "未完" );
					}
					else if ( sFinishFlag.equals( "1" ) )
					{
						out.print( "完成" );
					}
					else
					{
						out.print( "未知" );
					}
				%>
			</td>
			<td width="10%">
				<!-- input type="radio" name="finishflag" value="0" onclick="getSex()" checked="checked" -->
				<input type="radio" name="finishflag" value="0|<% out.print(rs.getString(9));%>" onclick="javascript:form.submit();" checked="checked">未完

				<!-- input type="radio" name="finishflag" value="1" onclick="update_complete_flag(rs.getString(9), 1)" -->
				<input type="radio" name="finishflag" value="1|<% out.print(rs.getString(9));%>" onclick="javascript:form.submit();">完成
			</td>
			<td>
				<input type="button" value="修改" onclick="window.open('updateplan.jsp?id=<% out.print(rs.getString(9));%>&plan_name=<% out.print(rs.getString(1).replaceAll("\r\n", "<br>"));%>&datenum_consuming=<% out.print(rs.getString(2));%>&datenum_interval=<% out.print(rs.getString(3));%>&byy=<% out.print(rs.getString(5).replaceAll("\r\n", "<br>"));%>&importance=<% out.print(rs.getString(6));%>&emergency=<% out.print(rs.getString(10));%>&complete_flag=<% out.print(rs.getString(8));%>','_blank','height=450,width=800')">
			</td>
		</tr>
		<%
			}
		%>
		<tr>
            <th colspan="9">
			<p align="center">数据查询完成!</p>
			</th>
		</tr>
	</table>
	</form>
	<!-- div align="center">
		<%
			out.print("数据查询完成！");
		%>
	</div-->
	<%
		rst.close();
		rs.close();
		statement.close();
		connection.close();
	%>
</body>
</html>
</span>
	<span style="font-size:24px;color: rgb(255, 0, 0);"></span>
</span>