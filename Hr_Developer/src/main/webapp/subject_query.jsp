<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<!-- resume_screen.jsp -->
  <head>
    <base href="<%=basePath%>">
    <title>题目查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="table.css" type="text/css">
		<link rel="stylesheet" type="text/css" media="all"
			href="javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
		<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" src="javascript/comm/list.js"></script>
		<script type="text/javascript">
		//提交按钮
		function mysubmit(){
			document.getElementById("myform").submit();
		}
		</script>
  </head>
  
  <body>
  
  
  <form  id="myform"  method="post" action="subject/subjectquerysubmit/1.do">
			<table width="100%">
				<tr> 
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--招聘管理-- 招聘考试题库管理 --试题查询
	</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交"
							class="BUTTON_STYLE1" onclick="mysubmit()">
						<input type="button" value="清空"
							class="BUTTON_STYLE1" onclick="javascript:search();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1" >
				 
				<tr>
					<td class="TD_STYLE1">
						请选择试题分类
					</td>
					<td width="30%" class="TD_STYLE2">
						<select style="width:30%"  id="select4" size="5" name="secondKindName">
							<option value=""></option>
							<c:forEach items="${subjects}" var="subject" varStatus="i">
								<option value="${subject.secondKindName }">${subject.secondKindName }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td class="TD_STYLE1">
						请输入关键字
					</td>
					<td width="84%" class="TD_STYLE2">
						<input class="INPUT_STYLE2"  name="keyword"/>(题干、登记人和试题出处)
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请输入登记时间
					</td>
					<td width="84%" class="TD_STYLE2">
						<input type="text" name="starttime" value="" style="width:14% " class="INPUT_STYLE2" id="date_start">至<input type="text" name="endtime" value="" style="width:14% " class="INPUT_STYLE2" id="date_end">
						（YYYY-MM-DD）
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script type="text/javascript">
	Calendar.setup ({inputField : "date_start", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_start", singleClick : true, step : 1});
	Calendar.setup ({inputField : "date_end", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_end", singleClick : true, step : 1});
	</script>
</html>


