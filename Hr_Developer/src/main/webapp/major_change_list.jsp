<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<base href="<%=basePath%>"> 
    
    <title>列出所有状态为“正常”的员工</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="table.css" type="text/css">
	<script type="text/javascript" src="javascript/comm/comm.js"></script>
  </head>
  
  <body>
  	<form method="post" action="configfilefirstkind.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源 -- 调动管理 -- 调动登记
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1"
							onclick="window.location.href='first_kind_register.jsp'" />
						<input type="reset" value="清除" class="BUTTON_STYLE1">
					</td>
				</tr>
			</table>
			
			
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="12.5%" class="TD_STYLE1" >
						档案编号
					</td>
					<td width="87.5%" class="TD_STYLE1" colspan="7"></td>
				</tr>
				<tr>
					<td width="12.5%" class="TD_STYLE1">
						档案编号
					</td>
					<td width="12.5%" class="TD_STYLE1"></td>
					<td width="12.5%" class="TD_STYLE1"></td>
					<td width="12.5%" class="TD_STYLE1"></td>
					<td width="12.5%" class="TD_STYLE1"></td>
					<td width="12.5%" class="TD_STYLE1"></td>
					<td width="12.5%" class="TD_STYLE1"></td>
					<td width="12.5%" class="TD_STYLE1"></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				
			</table>
			<p>&nbsp;&nbsp;总数：1例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="images/go.bmp" width=18 height=18 border=0>
		</form>
  	
  </body>
</html>
