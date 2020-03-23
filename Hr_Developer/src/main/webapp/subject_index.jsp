<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<!-- 试题登记主页面 -->
   <base href="<%=basePath%>">
    
    <title>subject_index.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="table.css" type="text/css">
	<link rel="stylesheet" type="text/css" media="all"
	href="javascript/calendar/calendar-win2k-cold-1.css">
	<script type="text/javascript" src="javascript/calendar/cal.js"></script>
	<script type="text/javascript" src="javascript/comm/comm.js"></script>
	<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="javascript/comm/list.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#select1").change(function(){
				var  changetagouterhtml=getlastletter( $("#select1 option:selected").html());
				var changetaghtml = $($("#select1 option:selected")[0]).val();
				//修改hidden输入框的值
				console.log(changetagouterhtml);
				console.log(changetaghtml);
				$("#firstKindId").val(changetaghtml);
				$("#firstKindName").val(changetagouterhtml);
				//changelocation2($("#select4 option:selected").html());
				
			});
			$("#select2").change(function(){
				var  changetagouterhtml=getlastletter( $("#select2 option:selected").html());
				var changetaghtml = $($("#select2 option:selected")[0]).val();
				//修改hidden输入框的值
				$("#secondKindId").val(changetaghtml);
				$("#secondKindName").val(changetagouterhtml);
				//changelocation2($("#select4 option:selected").html());
				
			});
		})
		
	function getlastletter(word){
		var index = word .lastIndexOf("\/");  
		word  = word .substring(index + 1, word .length);
		return word;	
	}
	
	function formatDate(date) {
		  var date = new Date(date);
		  var YY = date.getFullYear() + '-';
		  var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
		  var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate());
		  var hh = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
		  var mm = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
		  var ss = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
		  return YY + MM + DD + " " + hh + mm+ss;
		}
	
	function submitsubject(){
		//判断为空情况
		if($("#firstKindId").val() == null || $("#firstKindId").val().trim() == "")
			{
				alert("试卷I级分类不能为空");
				return;
			}
		if($("#secondKindId").val() == null || $("#secondKindId").val().trim() == "")
		{
			alert("试卷II级分类不能为空");
			return;
		}
		if($("#content").val() == null || $("#content").val().trim() == "" )
			{
			alert("题干不能为空");
			return;
		}
		if($("#register").val() == null || $("#register").val().trim() =="" )
			{
			alert("登记人不能为空");
			return;
		}
		
		//判断答案数量
		var count = 0;
		if($("#keyA").val() != null && $("#keyA").val().trim() !="")
			{
				count++;
			}
		if($("#keyB").val() != null && $("#keyB").val().trim() !="")
			{
				count++;
			}
		if($("#keyC").val() != null && $("#keyC").val().trim() !="")
			{
				count++;
			}
		if($("#keyD").val() != null && $("#keyD").val().trim() !="")
			{
				count++;
			}
		if($("#keyE").val() != null && $("#keyE").val().trim() !="")
			{
				count++;
			}
		
		if(count < 2)
			{
				alert("请注意最少两个答案选项");
				return;
			}
		
		if($("#correctKey").val() == null || $("#correctKey").val().trim() == "")
			{
			alert("正确答案不能为空");
			return;
			}
		
		document.getElementById("myform").submit();
			
		
	}
	</script>
  </head>
  
  <body>
	   <form action="subject/submitsubject.do" method="post" id="myform">
		<table width="100%">
			<tr>
				<td>
					<font color="#0000CC">您正在做的业务是：人力资源--招聘管理-- 招聘考试题库管理 --试题登记</font>
				</td>
			</tr>
			<tr>
					<td align="right">
						<input type="button" value="提交"
							class="BUTTON_STYLE1" onclick="submitsubject()">
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
				<td width="11%" class="TD_STYLE1">
					试题I级分类
				</td>
				<td width="13.5%" class="TD_STYLE2">
					<input type="hidden" id="firstKindId" name="firstKindId" value="" />
					<input type="hidden" id="firstKindName" name="firstKindName" value="" />
					<select  class="SELECT_STYLE1" id="select1"  >
					<option value=""></option>
						<c:forEach items="${firstlist }" var="first" varStatus="i">
							<option value="${first.firstKindId}">${first.firstKindName}</option>
						</c:forEach>
					</select> 
				</td>
				<td width="11.5%" class="TD_STYLE1">
					试题II级分类
				</td>
				<td width="13.5%" class="TD_STYLE2">
				<input type="hidden" name="secondKindId" id="secondKindId" value="" />
				<input type="hidden" name="secondKindName" id="secondKindName" value="" />
					<select  class="SELECT_STYLE1" id="select2"  >
						<option value=""></option>
						<c:forEach items="${secondlist }" var="second" varStatus="i">
							<option value="${second.secondKindId}">${second.secondKindName}</option>
						 </c:forEach>
					</select>
				</td>
				<td width="10%" class="TD_STYLE1">
					登记人
				</td>
				<td width="15%" class="TD_STYLE2">
					<input class="INPUT_STYLE2"  name="register" id="register"/>
				</td>
				<td width="10%" class="TD_STYLE1">
					登记时间
				</td>
				<td width="15%" class="TD_STYLE2">
					<input class="INPUT_STYLE2" id="datetime" name="registTime1" readonly="readonly" value=""/>
					<script type="text/javascript">
					setInterval("document.getElementById('datetime').value=formatDate(new Date().getTime());", 1000);
					</script>
				</td>	
			</tr>
			<tr>
				<td class="TD_STYLE1">
						题干
				</td>
				<td colspan="7" class="TD_STYLE2">
					<textarea id="content"  rows="5" class="TEXTAREA_STYLE1" style="resize:none"  name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">
						答案a
				</td>
				<td colspan="7" class="TD_STYLE2">
					<textarea id="keyA"  rows="3" class="TEXTAREA_STYLE1" style="resize:none"  name="keyA"></textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">
						答案b
				</td>
				<td colspan="7" class="TD_STYLE2">
					<textarea id="keyB"  rows="3" class="TEXTAREA_STYLE1" style="resize:none"  name="keyB"></textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">
						答案c
				</td>
				<td colspan="7" class="TD_STYLE2">
					<textarea id="keyC"  rows="3" class="TEXTAREA_STYLE1" style="resize:none"  name="keyC"></textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">
						答案d
				</td>
				<td colspan="7" class="TD_STYLE2">
					<textarea id="keyD"  rows="3" class="TEXTAREA_STYLE1" style="resize:none"  name="keyD"></textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">
						答案e
				</td>
				<td colspan="7" class="TD_STYLE2">
					<textarea id="keyE"  rows="3" class="TEXTAREA_STYLE1" style="resize:none"  name="keyE"></textarea>
				</td>
			</tr>
			<tr>
				<td width="12.5%" class="TD_STYLE1">
					 正确答案
				</td>
				<td width="12.5%" class="TD_STYLE2">
					<input class="INPUT_STYLE2"  name="correctKey" id="correctKey"/>
				</td>
				<td width="12.5%" class="TD_STYLE1">
					 试题出处
				</td>
				<td width="12.5%" class="TD_STYLE2" >
					<input class="INPUT_STYLE2"  name="derivation"/>
				</td>
				<td width="12.5%" class="TD_STYLE1" colspan="4">
				
				</td>
				
			</tr>
		</table>
	</form>



  </body>
</html>
