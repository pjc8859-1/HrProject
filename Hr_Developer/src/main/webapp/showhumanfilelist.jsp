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
    <base href="<%=basePath%>">
    
    <title>展示查询出来的结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<link rel="stylesheet" href="table.css" type="text/css">
	<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
	<script type="text/javascript">
		
	
		function bookin(ele){
			//拿到人员档案id传输
			var humanid = $(ele).parent().siblings(".humanid").html().trim();
			//http://localhost:8080/Hr_Developer/majorchange/formsubmit.do?item.firstKindId=01&item.secondKindId=01&item.thirdKindId=01&item.humanMajorKindName=01&item.hunmaMajorName=01&item.str_startTime=2020-03-01&item.str_endTime=2020-03-24
			location.href = "majorchange/showmove.do"+"?humanid="+humanid;		
					
		}
	</script>
  </head>
  
  <body>
   <form action="humanfile.do" method="post">
		<table width="100%">
			<tr>
				<td>
					<font color="#0000CC">您正在做的业务是：调动管理 -- 调动登记 -- 合格档案展示</font>
				</td>
			</tr>
			<tr>
				<td>
					符合条件的人力资源档案总数：${fn:length(humanlist)}例
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
				<td width="5%" class="TD_STYLE1">
					huf_id
				</td>
				<td width="16%" class="TD_STYLE1">
					档案编号
				</td>
				<td width="10%" class="TD_STYLE1">
					姓名
				</td>
				<td width="8%" class="TD_STYLE1">
					性别
				</td>
				<td width="10%" class="TD_STYLE1">
					I级机构
				</td>
				<td width="10%" class="TD_STYLE1">
					II级机构
				</td>
				<td width="10%" class="TD_STYLE1">
					III级机构
				</td>
				<td width="14%" class="TD_STYLE1">
					职位分类
				</td>
				<td width="7%" class="TD_STYLE1">
					职位名称
				</td>
				<td width="7%" class="TD_STYLE1">
					操作
				</td>
			</tr>
			<c:forEach items="${humanlist }" var="human">
				<tr class="TR_STYLE1">
				<td width="16%" class="TD_STYLE2 humanid">${human.hufId }</td>
				<td width="16%" class="TD_STYLE2">
					${human.humanId }
				</td>
				<td width="10%" class="TD_STYLE2">
					${human.humanName }
				</td>
				<td width="8%" class="TD_STYLE2">
					${human.humanSex }
				</td>
				<td width="10%" class="TD_STYLE2">
					<!-- <input type="hidden" id="firstkindid" value="${human.firstKindId}"/> -->
					${human.firstKindName }
				</td>
				<td width="10%" class="TD_STYLE2">
					${human.secondKindName }
				</td>
				<td width="10%" class="TD_STYLE2">
					${human.thirdKindName }
				</td>
				<td width="14%" class="TD_STYLE2">
					${human.humanMajorKindName }
				</td>
				<td width="7%" class="TD_STYLE2">
					${human.hunmaMajorName }
				</td>
				<td width="7%" class="TD_STYLE2">
					<input type="button" value="登记" onclick="bookin(this);" />
				</td>
			</tr>
			</c:forEach>
			
		</table>
		<p>&nbsp;&nbsp;总数：0例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="images/go.bmp" width=18 height=18 border=0>
	</form>
  </body>
</html>
