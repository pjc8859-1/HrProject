<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
   body {
   width:100%;
	margin:0;
	padding:0;
    background-image: url(images/bg.jpg);
    background-size:cover;
    background-repeat:no-repeat;
	
}	
/*- Menu Tabs F--------------------------- */

    #tabsF {
    width:100%;
      float:left;
      font-size:85%;
	  white-space:nowrap;
    
	/*  border-bottom:1px solid #666;*/
      }
    #tabsF ul {
    width:100%;
	margin:0;
	cursor:hand;
	padding:0px 0px 0 0px;
	list-style:none;0
	 
      }
    #tabsF li {
    cursor:hand;
      display:inline;
      margin:0;
	 
      padding:0;     
width:9%;
      }
    #tabsF a {
      cursor:hand;
      float:left;
      background:url("images/tableftF.gif") repeat left top;
	  width:9%;
      margin:0;
      padding:0 0 0 1px;
      text-decoration:none;
      }
    #tabsF a span {
    cursor:hand;
      float:left;
      display:block;
	  width:100%;
      padding:5px 15px 4px 0px;
      color:#666;
      }
    /* Commented Backslash Hack hides rule from IE5-Mac \*/
    #tabsF a span {float:none;}
    /* End IE5-Mac hack */
    #tabsF a:hover span {
    cursor:hand;
      color:#FFF;
      }
    #tabsF a:hover {
    cursor:hand;
      background-position:100% -42px;
      }
    #tabsF a:hover span {
    cursor:hand;
      background-position:100% -42px;
      }
</style>
<STYLE>
A:visited {
	TEXT-DECORATION: none
}
A:active {
	TEXT-DECORATION: none
}
A:hover {

}
A:link {
	TEXT-DECORATION: none
}
.t {
	LINE-HEIGHT: 1.4
}

TD {
	FONT-FAMILY: 宋体; FONT-SIZE: 12px
}

FORM {
	FONT-FAMILY: 宋体; FONT-SIZE: 12px
}
OPTION {
	FONT-FAMILY: 宋体; FONT-SIZE: 12px
}
P {
	FONT-FAMILY: 宋体; FONT-SIZE: 12px
}
TD {
	FONT-FAMILY: 宋体; FONT-SIZE: 12px
}
BR {
	FONT-FAMILY: 宋体; FONT-SIZE: 12px
}
INPUT {
	BORDER-BOTTOM-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 1px; BORDER-LEFT-COLOR: #cccccc;  BORDER-LEFT-WIDTH: 1px; BORDER-RIGHT-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 1px;  BORDER-TOP-COLOR: #cccccc; BORDER-TOP-WIDTH: 1px; FONT-SIZE: 12px; HEIGHT: 18px;  PADDING-BOTTOM: 1px; PADDING-LEFT: 1px; PADDING-RIGHT: 1px; PADDING-TOP: 1px
}
TEXTAREA {
	BACKGROUND-COLOR: #efefef; BORDER-BOTTOM-COLOR: #000000; BORDER-BOTTOM-WIDTH: 1px;  BORDER-LEFT-COLOR: #000000; BORDER-LEFT-WIDTH: 1px; BORDER-RIGHT-COLOR: #000000;  BORDER-RIGHT-WIDTH: 1px; BORDER-TOP-COLOR: #000000; BORDER-TOP-WIDTH: 1px; FONT-FAMILY: 宋体 ; FONT-SIZE: 12px
}
SELECT {
	BACKGROUND-COLOR: #efefef; BORDER-BOTTOM-COLOR: #000000; BORDER-BOTTOM-WIDTH: 1px;  BORDER-LEFT-COLOR: #000000; BORDER-LEFT-WIDTH: 1px; BORDER-RIGHT-COLOR: #000000;  BORDER-RIGHT-WIDTH: 1px; BORDER-TOP-COLOR: #000000; BORDER-TOP-WIDTH: 1px; FONT-FAMILY: 宋体 ; FONT-SIZE: 12px
}
.tdhead2{
  COLOR: #000000;
  FILTER: DropShadow(Color=#eeeeee, OffX=1, OffY=1, Positive=1);
  FONT-SIZE: 10pt; font:family: 宋体;
  HEIGHT: 10pt;
  letter-spacing:1.5px;
}
</STYLE>
<!--end css info-->
             
<STYLE>.gray {
	CURSOR: hand; FILTER: gray
}
</STYLE>
<base target="middle">
<style type="text/css">
.tb{BORDER-BOTTOM: #ff0000 1px solid;BORDER-TOP: #ff0000 1px solid;BORDER-RIGHT: #cccccc 1px solid;}
.cd{BORDER-BOTTOM: #cccccc 1px solid;BORDER-TOP: #cccccc 1px solid;BORDER-LEFT: #cccccc 1px solid;}
.ef{BORDER-BOTTOM: #cccccc 1px solid;BORDER-TOP: #cccccc 1px solid;BORDER-LEFT: #cccccc 1px solid;BORDER-RIGHT: #cccccc 1px solid;}
.style3 {font-size: 24px}
.style6 {color: #33CCCC}
.style7 {color: #FF6633}
.style8 {color: #FFCC33}
-->
</style>
  </head>
  
 <body topmargin="0" leftmargin="0">
<table width="100%" border="0">
  <tr>
    <td><p class="style3"><span class="style6">Better</span><span class="style7">伯乐</span><span class="style8">人力资源管理系统</span></p></td>
  </tr>
  <tr><td height=11 id="aaa"></td></tr>
</table>
<table border="0" cellspacing="0" width="100%" id="AutoNumber7" cellpadding="0" height="30">
<tr>
	<td height="100%" align="right" style="padding-left:100">&nbsp;</td>
	 <div id="tabsF">
     <ul>
   <li><a onclick="window.parent.window.location.reload()" target="a"><span><font color="#FFFFFF" size="2px"><b>&nbsp;系统首页</b></font></span></a></li>
   <li><a href="" target="a"><span><font color="#FFFFFF" size="2px"><b>&nbsp;客户化设置</b></font></span></a></li>
   <li><a href="" target="a"><span><font color="#FFFFFF" size="2px"><b>&nbsp;人力资源档案管理</b></font></span></a></li>
   <li><a href="" target="a"><span><font color="#FFFFFF" size="2px"><b>&nbsp;&nbsp;薪酬标准管理</b></font></span></a></li>
   <li><a href="" target="a"><span><font color="#FFFFFF" size="2px"><b>&nbsp;&nbsp;薪酬发放管理</b></font></span></a></li>
   <li><a onclick="this.href='majorchange/majorchange.do';window.parent.document.getElementById('left').contentWindow.document.getElementById('major_change_pic').click();" target="mainFrame"><span><font color="#FFFFFF" size="2px"><b>&nbsp;&nbsp;调动管理</b></font></span></a></li>
   <li><a onclick="window.parent.document.getElementById('left').contentWindow.document.getElementById('engage_pic').click();" target="mainFrame"><span><font color="#FFFFFF" size="2px"><b>&nbsp;&nbsp;招聘管理</b></font></span></a></li>
   <li><a onclick="window.parent.document.getElementById('left').contentWindow.document.getElementById('exports_pic').click();" target="a"><span><font color="#FFFFFF" size="2px" ><b>&nbsp;标准数据报表</b></font></span></a></li>
  </ul>								
</div>	
</table>
  </body>
</html>
