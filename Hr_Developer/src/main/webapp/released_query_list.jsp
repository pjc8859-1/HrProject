<<<<<<< HEAD
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
    
    <title>展示需要已经提交了的职位发布项目</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<link rel="stylesheet" href="table.css" type="text/css">
	<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
	<script type="text/javascript">
		function apply(ele){
			var $eee = $(ele);
			var reId =$eee.parent().siblings("input").val();
			location.href="recruitment/applyrelease.do?mreId="+reId;
			
		
		}
		function detail(ele){
			var $eee = $(ele);
			var reId =$eee.parent().siblings("input").val();
			location.href="recruitment/showreleasedetail.do?mreId="+reId;
		}
		function deleterelease(ele){
			var $eee = $(ele);
			var reId =$eee.parent().siblings("input").val();
			

			
			//location.href="recruitment/.do?mreId="+reId;
		}
	</script>
  </head>
  
  <body>
   <form action="humanfile.do" method="post">
		<table width="100%">
			<tr>
				<td>
					<font color="#0000CC">您正在做的业务是：招聘管理 -- 职位发布管理--	职位发布查询</font>
				</td>
			</tr>
			<tr>
				<td>
					符合条件的职位发布档案总数：${fn:length(realeases)}例
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
					职位名称
				</td>
				<td width="10%" class="TD_STYLE1">
					机构名称
				</td>
				
				<td width="10%" class="TD_STYLE1">
					招聘人数
				</td>
				<td width="14%" class="TD_STYLE1">
					发布时间
				</td>
				<td width="14%" class="TD_STYLE1">
					截止时间
				</td>
				<td width="10%" class="TD_STYLE1">
					职位详情
				</td>
				<td width="14%" class="TD_STYLE1">
					申请职位
				</td>
			</tr>
			<c:forEach items="${realeases}" var="release">
				<tr class="TR_STYLE1">
				<input type="hidden" name="mreId" value="${release.mreId }" id="mreId"/>
				<td width="16%" class="TD_STYLE2 humanid">
					${release.majorName }
				</td>
				<td width="10%" class="TD_STYLE2">
					${release.secondKindName }
				</td>
				
				<td width="10%" class="TD_STYLE2">
					<!-- <input type="hidden" id="firstkindid" value="${human.firstKindId}"/> -->
					${release.humanAmount }
				</td>
				<td width="10%" class="TD_STYLE2">
					${fn:substring(release.registTime, 0, 19)}
				</td>
				<td width="10%" class="TD_STYLE2">
					${fn:substring(release.deadline, 0, 19)}
				</td>
				<td width="14%" class="TD_STYLE2">
					<a onclick="detail(this)">详情</a>
				</td>
				<td width="12%" class="TD_STYLE2">
					<a onclick="apply(this)">申请该职位</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</form>
  </body>
</html>
