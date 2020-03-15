<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'salarystandard_check.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="table.css" type="text/css" />
		<title>无标题文档</title>
		<script type="text/javascript">
		function doEdit()
		{
			//document.forms[0].action = document.forms[0].action + "?operate=doEdit&method=check&id=" + id;
			//document.forms[0].action ="salarystandard_check_success.jsp";
			document.forms[0].submit();
		}
		
		function countMoney() {
			var sum=0;
		 	for(var i=1;i<=6;i++){
		 		var salary=document.getElementById("salary"+i).value;
		 		if(salary==""){
		 		salary="0.00";
		 		}
		 		sum=Number(sum)+Number(salary);
		 		 
		 }
		 document.getElementById("sumSalary").value=sum;
		}
		</script>
  </head>
  
  <body>
  <form action="updatexc.do" method="post">
  <input type="hidden" name="sa" value="${sa }">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记复核</font>
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							<input type="button" value="复核通过" class="BUTTON_STYLE1" onclick="doEdit();">
							<input type="button" value="返回" onclick="history.back();" class="BUTTON_STYLE1">
						</div>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="12%" class="TD_STYLE1">
						薪酬编号
					</td>
					<td width="15%" class="TD_STYLE2">
						${sa.standardId }
						<input type="hidden" value="${sa.standardId }" name="standardId"/>
					</td>
					<td width="12%" class="TD_STYLE1">
						薪酬标准名称
					</td>
					<td width="11%" class="TD_STYLE2">
						<input type="text" name="standardName" value="${sa.standardName }" class="INPUT_STYLE2">
					</td>
					<td width="11%" class="TD_STYLE1">
						薪酬总额
					</td>
					<td width="17%" class="TD_STYLE2">
						<input type="text" name="item.salaryCount"  id="sumSalary"  readonly="readonly" value="${sa.salarySum }" class="INPUT_STYLE2">
					</td>
					<td width="12%" class="TD_STYLE1">
						&nbsp;
					</td>
					<td width="10%" class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						制定人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="designer" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						复核人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="checker" value="better_wanghao" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						复核时间
					</td>
					<td class="TD_STYLE2">
						<div id="datetime">
    					<script>
        				setInterval("document.getElementById('datetime').innerHTML=new Date().toLocaleString();", 1000);
   						</script>
</div>
					</td>
					<td class="TD_STYLE1">
						&nbsp;
					</td>
					<td class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						复核意见
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="checkComment" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						序号
					</td>
					<td colspan="3" class="TD_STYLE1">
						薪酬项目名称
					</td>
					<td colspan="4" class="TD_STYLE1">
						金额
					</td>
				</tr>
				
				<c:forEach items="${slist}" var="s" varStatus="vs">
					<tr class="TD_STYLE2">
						<td align="center">${s.xcxmid }</td>
						<td colspan="3">${s.name}
							<input type="hidden" value="${s.name}" name="name"/> 
						</td> 
						<td>
							<input type="text"  value="${s.money}" name="csum" id="salary${vs.count}"
								 class="INPUT_STYLE2" onkeyup="if(/^\d+(\.)?(\d+)?$/.test(this.value)==false){alert('请输入数字！');this.value='';}countMoney()">
							<input type="hidden" name="pbcid" value="${s.xcxmid }">
						</td>
						<td colspan="3">
							&nbsp;
						</td>
					</tr>
				</c:forEach>
				
			</table>
		</form>
  </body>
</html>
