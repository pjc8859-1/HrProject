<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<!-- major_release_detail.jsp -->
	<!-- 展示发布的职位详细信息 -->
  <head>
   <base href="<%=basePath%>">
    
    <title>major_release_detail.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" media="all"
			href="javascript/calendar/calendar-win2k-cold-1.css">
	<style type="text/css">
		input::-webkit-outer-spin-button,
		input::-webkit-inner-spin-button {
		  -webkit-appearance: none;
		}
		input[type="number"]{
		  -moz-appearance: textfield;
}
	</style>
	<link rel="stylesheet" href="table.css" type="text/css">
	<style type="text/css">
		.select1{
			width:100%;
			heigth:100%;
		}
	</style>
	<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="javascript/calendar/cal.js"></script>
	<script type="text/javascript" src="javascript/comm/comm.js"></script>
	
  </head>
  
 <body>
  	<form method="post" action="recruitment/submitmajorrelease.do" id="mainform">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源 -- 招聘管理 -- 职位发布管理 --职位发布详情
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
					<!-- <input type="button" value="提交" class="BUTTON_STYLE1"
							onclick="dosubmit()" />
						<input type="reset" value="清除" class="BUTTON_STYLE1">
					-->
						<input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.go(-1)" />
					</td>
					
				</tr>
			</table>
			
			
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				
				
				<!-- 3 -->
				<tr>
					<td width="12.5%" class="TD_STYLE1">
						I级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
							${release.firstKindName }
					</td>
					<td width="12.5%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
						${release.secondKindName }
					</td>
					<td width="12.5%" class="TD_STYLE1" >
						III级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
					${release.thirdKindName }
					</td>
					<td width="12.5%" class="TD_STYLE1">
						招聘类型
					</td>
					<td width="12.5%" class="TD_STYLE2">
						${release.engageType }
					</td>
				</tr>
	<!-- ================================================================================ -->			
				<!-- 4 -->
				<tr>
					<td width="12.5%" class="TD_STYLE1">
					职位分类
				</td>
					<td width="12.5%" class="TD_STYLE2">
						${release.majorKindName }
					</td>
					<td width="12.5%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="12.5%" class="TD_STYLE2">
						${release.majorName }
					</td>
					<td width="12.5%" class="TD_STYLE1">
						招聘人数
					</td>
					<td width="12.5%" class="TD_STYLE2">
						${release.humanAmount }
					</td>
					<td width="12.5%" class="TD_STYLE1">
						截止日期
					</td>
					<td width="12.5%" class="TD_STYLE2">
						${fn:substring(release.deadline, 0, 10)}
					</td>
				</tr>
				
				<!-- 5 -->
				<tr>
					<td width="12.5%" class="TD_STYLE1">
						登记人
					</td>
					<td width="12.5%" class="TD_STYLE2">
						${release.register }

					</td>
					<td width="12.5%" class="TD_STYLE1">
						登记时间
					</td>
					<td width="12.5%" class="TD_STYLE2">
						${fn:substring(release.registTime, 0, 19)}
					</td>
					<td width="12.5%" class="TD_STYLE1">
						修改时间
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<input id="datetime" type="text" class="select1" name="changeTime1" value="${fn:substring(release.changeTime, 0, 19)} " readonly="readonly"/>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						修改人
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<input class="select1" name="changer"  readonly="readonly" id="register" value="${release.changer }"/>
					</td>
				</tr>
				<tr>
					<td width="12.5%" height="100" class="TD_STYLE1" >
						职位描述
					</td>
					<td width="87.5%"  height="100" class="TD_STYLE2" colspan="7">
						<textarea  style="width:100%;height:100%;resize:none" readonly="readonly" autoHeight="true">${release.majorDescribe }</textarea>
					</td>
				</tr>
				<tr>
					<td width="12.5%" height="100" class="TD_STYLE1" >
						招聘要求
					</td>
					<td width="87.5%"  height="100" class="TD_STYLE2" colspan="7">
						<textarea  style="width:100%;height:100%;resize:none" readonly="readonly" autoHeight="true">${release.engageRequired }</textarea>
					</td>
				</tr>
				
			</table>
		</form>
  	<script type="text/javascript">
	Calendar.setup ({inputField : "deadline", ifFormat : "%Y-%m-%d", showsTime : false, button : "deadline", singleClick : true, step : 1});
	</script>
  </body>
  	
  </body>
</html>
