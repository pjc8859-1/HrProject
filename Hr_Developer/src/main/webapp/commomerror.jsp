<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register_success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="table.css" type="text/css">
<script type="text/javascript">
function locate()
{
	window.location.href='main.jsp';
}
</script>
  </head>
  
  <body>
  <form method="post" action="configprimarykey.do">
<table width="100%" >
  <tr>
    <td colspan="2"> 
    <font color="#0000CC">页面错误</font></td>
  </tr>
  <tr>
    <td width="49%"> 页面错误！请返回</td>
    <td width="51%" align="right">
    <input type="button" value="返回" class="BUTTON_STYLE1" onclick="javascript:locate();"></td></tr>
  </table>

</form>
  </body>
</html>
