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
  	<!-- interview_query_result_list.jsp-->
    <base href="<%=basePath%>">
    
    <title>展示所有面试的数据用来筛选</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<link rel="stylesheet" href="table.css" type="text/css">
	<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
	<script type="text/javascript">
		function dointerview(ele){
			var $eee = $(ele);
			var resId =$eee.parent().siblings("input").val();
			location.href="resumemanage/interviewregist.do?resId="+resId;
			
		
		}
		function edit(ele){
			var $eee = $(ele);
			var reId =$eee.parent().siblings("input").val();
			location.href="resumemanage/interviewregist.do?reId="+reId;
		}
	</script>
  </head>
  
  <body>
   <form action="humanfile.do" method="post">
		<table width="100%">
			<tr>
				<td>
					<font color="#0000CC">您正在做的业务是：人力资源 -- 招聘管理 -- 面试管理 -- 面试筛选主页</font>
				</td>
			</tr>
			<tr>
				<td>
					符合条件的面试总数：${fn:length(interviews)}例
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
					面试次数
				</td>
				
				<td width="10%" class="TD_STYLE1">
					招聘职位类型
				</td>
				<td width="14%" class="TD_STYLE1">
					招聘职位
				</td>
				<td width="14%" class="TD_STYLE1">
					综合素质
				</td>
				
				<td width="10%" class="TD_STYLE1">
					开始面试
				</td>
			</tr>
			<c:forEach items="${interviews}" var="interview">
				<tr class="TR_STYLE1">
				<input type="hidden" name="resumeId" value="${interview.resumeId }" id="resumeId"/>
				<td width="16%" class="TD_STYLE2 humanid">
					${interview.humanName }
				</td>
				<td width="10%" class="TD_STYLE2">
					${interview.interviewAmount }
				</td>
				<td width="10%" class="TD_STYLE2">
					${interview.humanMajorKindName}
				</td>
				<td width="10%" class="TD_STYLE2">
					${ interview.humanMajorName}
				</td>
				<td width="10%" class="TD_STYLE2">
					${ interview.multiQualityDegree}
				</td>
				<td width="14%" class="TD_STYLE2">
					<a onclick="dointerview(this)">面试</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</form>
  </body>
</html>
