<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="table.css" rel="stylesheet"/>
<title>Better伯乐HR系统用户注册</title>
<style type="text/css">
<!--
.style1 {
	font-size: 18px;
	font-weight: bold;
	color: #660000;
}
-->
</style>

		<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" src="javascript/userdetails.js"></script>
		<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
<script type="text/javascript">

</script>
  </head>
  
 <body bgcolor="#E9F8F3">
<form method="post" action="userregister.do" name="register">
<table width="100%">
  <tr>
    <td height="169" colspan="3" align="center">
      <p >&nbsp;</p>
      <p >&nbsp;</p>
      <p >&nbsp;</p>
      <p class="style1">Better伯乐HR系统用户注册</p></td>
  </tr>
  <tr>
  <td width="18%" height="166">&nbsp;</td>
  <td width="62%">
  <table width="95%" border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
  <tr>
    <td width="20%" class="TD_STYLE1">使用单位简称</td>
    <td width="80%" class="TD_STYLE2" style="width: 551px; height: 51px"><input name="profix" type="text" class="INPUT_STYLE1" value="Better" readonly="readonly" style="width: 438px; height: 35px"></td>
  </tr>
  <tr>
    <td width="20%" class="TD_STYLE1">用户名</td>
    <td width="80%" class="TD_STYLE2" style="height: 55px; "><input type="text" name="item.UName" id="username" value="" class="INPUT_STYLE1" style="width: 436px; "></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">真实姓名</td>
    <td class="TD_STYLE2" style="height: 46px; "><input type="text" name="item.UTrueName" value="" id="truename" class="INPUT_STYLE1" style="width: 436px; "></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">密码</td>
    <td class="TD_STYLE2" style="height: 52px; "><input type="password" name="item.UPassword" id="firstpass" value="" style="background-color: #DEEBF7; width: 438px; height: 33px" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">确认密码</td>
    <td class="TD_STYLE2" style="height: 50px; "><input name="surPwd" type="password" class="INPUT_STYLE1" id="checkpass" style="background-color: #DEEBF7; width: 435px"></td>
  </tr>
  </table>
  </td>
  <td width="20%" >&nbsp;</td>
  </tr>
  <tr>
    <td></td>
    <td align="center"><input type="button" value="注册" class="BUTTON_STYLE1" id="registeruser" style="width: 126px; "> &nbsp;
	  <td></td>
  </tr>
</table>
</form>      
</body>
<script type="text/javascript">
				var isok="${exist}";
			 if(isok=="exist")
			 {
			 	alert("注册失败！用户名已存在！请重新输入用户名！");
			 	$("#username").focus();
			 	$("#username").val("${users.UName}");
			 	$("#truename").val("${users.UTrueName}");
			 	$("#firstpass").val("${users.UPassword}");
			 	$("#checkpass").val("${users.UPassword}");
			 }
			 if(isok=="error")
			 {
			 	alert("系统错误，清稍后重试！");
			 }
			 
		$(function() {
			$("#registeruser").click(function(){
				tosubmint();
		});
		$("html").die().live("keydown", function(event) {
		if (event.keyCode == 13) {
			tosubmint();
		}
	});
	});
	
	function tosubmint()
	{
				document.register.submit();
	}
</script>
</html>
