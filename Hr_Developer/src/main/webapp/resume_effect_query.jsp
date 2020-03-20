<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<!-- released_query_list.jsp-->
    <base href="<%=basePath%>">
    
    <title>展示有效简历查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<link rel="stylesheet" href="table.css" type="text/css">
	<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
	<script type="text/javascript">
		
		function gointerview(ele){
			var $eee = $(ele);
			var resId =$eee.parent().siblings("input").val();
			location.href="resumemanage/interviewregist.do?resId="+resId;
		}
	</script>
  </head>
  
  <body>
   <form action="humanfile.do" method="post">
		<table width="100%">
			<tr>
				<td>
					<font color="#0000CC">您正在做的业务是：人力资源--招聘管理-- 简历管理 --有效简历查询(可面试)</font>
				</td>
			</tr>
			<tr>
				<td>
					符合条件的简历总数：${fn:length(resumes)}例
				</td>
					<td align="right">
						<input type="button" value="刷新"
							class="BUTTON_STYLE1" onclick="window.location.reload();">
					</td>
				<td align="right">
						<input type="button" value="返回"
							class="BUTTON_STYLE1" onclick="history.back();">
					</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr class="TR_STYLE1">
			
				<td width="12%" class="TD_STYLE1">
					姓名
				</td>
				<td width="10%" class="TD_STYLE1">
					年龄
				</td>
				
				<td width="10%" class="TD_STYLE1">
					招聘职位类型
				</td>
				<td width="14%" class="TD_STYLE1">
					招聘职位
				</td>
				<td width="14%" class="TD_STYLE1">
					民族
				</td>
				<td width="10%" class="TD_STYLE1">
					去面试
				</td>
				
				<td width="14%" class="TD_STYLE1">
					同意状态
				</td>
			</tr>
			<c:forEach items="${resumes}" var="resume">
				<tr class="TR_STYLE1">
				<input type="hidden" name="resId" value="${resume.resId }" id="resId"/>
				<td width="16%" class="TD_STYLE2 humanid">
					${resume.humanName }
				</td>
				<td width="10%" class="TD_STYLE2">
					${resume.humanAge }
				</td>
				
				<td width="10%" class="TD_STYLE2">
					<!-- <input type="hidden" id="firstkindid" value="${human.firstKindId}"/> -->
					${resume.humanMajorKindName }
				</td>
				<td width="10%" class="TD_STYLE2">
					${ resume.humanMajorName}
				</td>
				<td width="10%" class="TD_STYLE2">
					${ resume.humanRace}
				</td>
				<td width="14%" class="TD_STYLE2">
					<a onclick="gointerview(this)">开始面试</a>
				</td>
				<td width="12%" class="TD_STYLE2">
					<c:if test="${resume.checkStatus == null}">
						<div style="width:100%;height:100%;background:whilte" >未筛选</div>
					</c:if>
					<c:if test="${resume.checkStatus == 0}">
						<div style="width:100%;height:100%;background:yellow;" >建议面试</div>
					</c:if>
					<c:if test="${resume.checkStatus == 1}">
						<div style="width:100%;height:100%;background:skyblue;" >建议笔试</div>
					</c:if>
					<c:if test="${resume.checkStatus == 2}">
						<div style="width:100%;height:100%;background:green;" >建议录用</div>
					</c:if>
					<c:if test="${resume.checkStatus == 3}">
						<div style="width:100%;height:100%;background:gray;" >被删除</div>
					</c:if>
					
				</td>
			</tr>
			</c:forEach>
		</table>
	</form>
  </body>
</html>
