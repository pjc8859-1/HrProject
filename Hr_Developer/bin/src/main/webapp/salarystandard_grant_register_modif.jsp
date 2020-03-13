<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'salarystandard_check_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="table.css" type="text/css" />
		<title>无标题文档</title>
		<style type="text/css">
<!--
.style3 {color: #0000CC}
-->
</style>
  </head>
  
  <body>
  <form method="post" action="salarystandard.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是:人力资源管理--薪酬发放管理--薪酬发放登记</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1"
							onclick="window.location.href='register_choose_picture.jsp'">
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="window.location.href='register_choose_picture.jsp'">
					</td>
				</tr>
				
				<tr>
					<td>
						薪酬单编号:<br>
						机构：<br>
						薪酬次数：3，总人数：，基本薪酬总额：，实发总额：
						<td align="right">登记人：<input type="text" value="admin" style="width:80px;background-color:#D4F8D4;">登记时间：</td>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="7%" class="TD_STYLE1">
						<span>序号</span>
					</td>
					<td width="8%" class="TD_STYLE1">
						<span>档案编号</span>
					</td>
					<td width="8%" class="TD_STYLE1">
						<span>姓名</span>
					</td>
					<td width="7%" class="TD_STYLE1">
						<span>基本工资</span>
					</td>
					<td width="7%" class="TD_STYLE1">
						交通补贴
					</td>
					<td width="7%" class="TD_STYLE1">
						通讯补贴
					</td>
					<td width="7%" class="TD_STYLE1">
						浮动工资
					</td>
					<td width="7%" class="TD_STYLE1">
						常规
					</td>
					<td width="7%" class="TD_STYLE1">
						午餐补助
					</td>
					<td width="7%" class="TD_STYLE1">
						交通补助
					</td>
					<td width="7%" class="TD_STYLE1">
						车补
					</td>
					<td width="7%" class="TD_STYLE1">
						奖励金额
					</td>
					<td width="7%" class="TD_STYLE1">
						销售绩效金额
					</td>
					<td width="7%" class="TD_STYLE1">
						应扣金额
					</td>
				</tr>
			</table>
		</form>
  </body>
</html>
