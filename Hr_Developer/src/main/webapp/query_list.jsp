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
    
    <title>展示查询出来的结果</title>
    
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
  </head>
  
  <body>
   <form action="hr/query_list.do" method="post">
		<table width="100%">
			<tr>
				<td>
					<font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案查询 </font>
				</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr class="TR_STYLE1">
				<td width="16%" class="TD_STYLE1">
					档案编号
				</td>
				<td width="13%" class="TD_STYLE1">
					姓名
				</td>
				<td width="8%" class="TD_STYLE1">
					性别
				</td>
				<td width="14%" class="TD_STYLE1">
					I级机构
				</td>
				<td width="14%" class="TD_STYLE1">
					II级机构
				</td>
				<td width="14%" class="TD_STYLE1">
					III级机构
				</td>
				<td width="14%" class="TD_STYLE1">
					职位分类
				</td>
				<td width="7%" class="TD_STYLE1">
					职位名称
				</td>
			</tr>
			<c:forEach items="${humanfileqd}" var="hfqd">
					<tr>
						<td class="TD_STYLE2">
						${hfqd.humanId}
					</td>
					<td class="TD_STYLE2">
						${hfqd.humanName }
					</td>
					<td class="TD_STYLE2">
						${hfqd.humanSex }
					</td>
					<td class="TD_STYLE2">
						${hfqd.firstKindName }
					</td>
					<td class="TD_STYLE2">
						${hfqd.secondKindName }
					</td>
					<td class="TD_STYLE2">
						${hfqd.thirdKindName }
					</td>
					<td class="TD_STYLE2">
						${hfqd.humanMajorKindName }
					</td>
					<td class="TD_STYLE2">
						${hfqd.hunmaMajorName }
					</td>
					</tr>
				</c:forEach>
		</table>
	</form>
  </body>
</html>
