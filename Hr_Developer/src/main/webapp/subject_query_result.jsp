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
    
    <title>展示试卷查询结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<link rel="stylesheet" href="table.css" type="text/css">
	<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
	<script type="text/javascript">
		function　jump(){
			var page = Number($("#page").val());
			var maxpage = Number(${maxnum});
			console.log(page,maxpage);
			if(page > maxpage)
				{
					page = maxpage;
					$("#page").val(page+"");
				}
			location.href="subject/subjectquerysubmit/"+page+".do";
		}
	</script>
  </head>
  
  <body>
   <form action="humanfile.do" method="post">
		<table width="100%">
			<tr>
				<td>
					<font color="#0000CC">您正在做的业务是：人力资源--招聘管理-- 招聘考试题库管理 -- 试卷查询结果</font>
				</td>
			</tr>
			<tr>
				<td>
					符合条件的试卷总数：${fn:length(resumes)}例
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
			<tr class="TR_STYLE1" width="100%">
				<td width="30%" class="TD_STYLE1">
					题干
				</td>
				<td width="5%" class="TD_STYLE1">
					年龄试题I级分类
				</td>
				
				<td width="5%" class="TD_STYLE1">
					年龄试题II级分类
				</td>
				<td width="10%" class="TD_STYLE1">
					登记人
				</td>
				<td width="10%" class="TD_STYLE1">
					登记日期
				</td>
				<td width="10%" class="TD_STYLE1">
					出处
				</td>
				<td width="5%" class="TD_STYLE1">
					正确答案
				</td>
			</tr>
			<c:forEach items="${subjects}" var="subject">
				<tr class="TR_STYLE1">
				<td width="30%" class="TD_STYLE2 humanid">
					${subject.content }
				</td>
				<td width="8%" class="TD_STYLE2">
					${subject.firstKindName }
				</td>
				
				<td width="8%" class="TD_STYLE2">
					${subject.secondKindName }
				</td>
				<td width="10%" class="TD_STYLE2">
					${subject.register }
				</td>
				<td width="15%" class="TD_STYLE2">
					${subject.registTime }
				</td>
				<td width="10%" class="TD_STYLE2">
					${subject.derivation }
				</td>
				<td width="5%" class="TD_STYLE2">
					${subject.correctKey }
				</td>
			</tr>
			</c:forEach>
		</table>
			<p>&nbsp;&nbsp;总数：${pagecount }例 &nbsp;&nbsp;&nbsp;当前第 ${currentnum } 页  &nbsp;&nbsp;&nbsp;共 ${maxnum } 页  &nbsp;&nbsp;&nbsp;跳到第 <input name="page" id="page" type="text"  value="${currentnum }" class="input1" style="width:100px;" onkeyup="if(/^\d+(\.)?(\d+)?$/.test(this.value)==false){alert('请输入数字！');this.value='';}"> 页&nbsp;&nbsp;<img  src="images/go.bmp" width="18" height="18" border="0"  onclick="jump();"/>
			</p>
	</form>
  </body>
</html>
