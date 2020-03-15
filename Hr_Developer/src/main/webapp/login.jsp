<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
		<meta name="ProgId" content="FrontPage.Editor.Document">
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
		<META HTTP-EQUIV="Expires" CONTENT="0">
		<META content="Microsoft FrontPage 4.0" name=GENERATOR>
		<link href="table.css" rel="stylesheet" />
		<script type="text/javascript" src="javascript/comm/comm.js"></script>

		<title>欢迎进入伯乐HR系统</title>

		<STYLE>
.t {
	LINE-HEIGHT: 1.4
}
BODY {
	FONT-FAMILY: 宋体;
	FONT-SIZE: 9pt;
	SCROLLBAR-HIGHLIGHT-COLOR: buttonface;
	SCROLLBAR-SHADOW-COLOR: buttonface;
	SCROLLBAR-3DLIGHT-COLOR: buttonhighlight;
	SCROLLBAR-TRACK-COLOR: #eeeeee;
	SCROLLBAR-DARKSHADOW-COLOR: buttonshadow;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
TD {
	FONT-FAMILY: 宋体; FONT-SIZE: 9pt
}
DIV {
	FONT-FAMILY: 宋体; FONT-SIZE: 9pt
}
FORM {
	FONT-FAMILY: 宋体; FONT-SIZE: 9pt
}

P {
	FONT-FAMILY: 宋体; FONT-SIZE: 9pt
}
TD {
	FONT-FAMILY: 宋体; FONT-SIZE: 9pt
}
BR {
	FONT-FAMILY: 宋体; FONT-SIZE: 9pt
}
.style5 {
	color: #CC6699;
	font-family: "Courier New", Courier, mono;
}
.style6 {color: #CC9900}
.style8 {color: #CCCCCC}
.style9 {
	font-family: "幼圆", Times, serif;
	color: #006633;
}
</STYLE>
<script type="text/javascript">

 function login()
 {
 	var yesOrno = ${yesOrno};
	
	if (yesOrno == "true" ) {
		alert("恭喜登录成功！")
		return true;
	}
	if(yesOrno == "false")
	{
		alert("登录失败！")
		return false;
	}
	
}
</script>
  </head>
  
 <body background="images/bg.jpg">
		<table class="TABLE_STYLE2" height="250">
			<tr class="TR_STYLE1">
				<td class="TD_STYLE3">
					<div id="Layer1"
						style="position:absolute; width:346px; height:77px; z-index:1; left: 620px; top: 33px; font-size: 50px; font-weight: bold; font-style: italic;">
						<span class="style6">Be</span><span class="style5">tt</span><span
							class="style6">er</span><span class="style9">伯乐</span><span
							class="style8">HR</span>
					</div>
				</td>
			</tr>
		</table>

		<form method="post" action="users.do" >
			<table align="center" border="1">
				<tr>
					<td>
						<table width="100%">
							<tr>
								<td colspan="2" align="center">
									<font color="#30358D"><b>Better伯乐HR&nbsp;v2.0</b>
									</font>
								</td>
							</tr>
							<tr class="TR_STYLE1">
								<td class="TD_STYLE3">
									<p style="line-height: 200%">
										<font color="#30358D"><b>用户名:</b>
										</font>
								</td>
								<td>
									<input type="text" name="item.UName" id="myloginname" value="" style="width:150px">
								</td>
							</tr>
							<tr class="TR_STYLE1">
								<td class="TD_STYLE3">
									<p style="line-height: 200%">
										<font color="#30358D"><b>密码:</b>
										</font>
								</td>
								<td>
									<input type="password" name="item.UPassword" id="myloginpass" value="" style="width:150px">
								</td>
							</tr>
							<tr class="TR_STYLE1">
								<td colspan="2" class="TD_STYLE3" align="center">
									<p style="line-height: 200%">
										<input type="button" value="登录"  class="BUTTON_STYLE1" onclick="javascript:login();">
										<input type="button" class="BUTTON_STYLE1" value="注册"
											onClick="window.location.href='register.jsp'">
										<input type="button" class="BUTTON_STYLE1" value="修改密码"
											onClick="javascript:toEditPwd();">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table class="TABLE_STYLE2" height="90">
				<tr class="TR_STYLE1">
					<td class="TD_STYLE3">
						&nbsp;
					</td>
				</tr>
			</table>
			<center>
				<table width="80%" height="10%" align="center">
					<tr class="TR_STYLE1">
						<td height="10%" align="center">
							<p class="testonline.style1">
								<br>
								<font color="#FFFFFF" size="2.5"><b>北京Better伯乐科技有限公司&nbsp;版权所有</b>
						</td>
					</tr>
				</table>
			</center>
		</form>
	</body>
</html>
