<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	
		
	</script>
  </head>
  
  <body>
	   <form action="humanfile.do" method="post">
		<table width="100%">
			<tr>
				<td>
					<font color="#0000CC">您正在做的业务是：人力资源--招聘管理-- 简历管理 --简历筛选结果</font>
				</td>
			</tr>
			<tr>
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
				<td width="11%" class="TD_STYLE1">
					试题I级分类
				</td>
				<td width="13.5%" class="TD_STYLE2">
					<select  class="SELECT_STYLE1" id="select1" >
							<option value=""></option>
					</select> 
				</td>
				<td width="11.5%" class="TD_STYLE1">
					试题II级分类
				</td>
				<td width="13.5%" class="TD_STYLE2">
					<select  class="SELECT_STYLE1" id="select1" >
							<option value=""></option>
					</select> 
				</td>
				<td width="10%" class="TD_STYLE1">
					登记人
				</td>
				<td width="15%" class="TD_STYLE2">
					<input class="INPUT_STYLE2"  name=""/>
				</td>
				<td width="10%" class="TD_STYLE1">
					登记时间
				</td>
				<td width="15%" class="TD_STYLE2">
					<input class="INPUT_STYLE2" id="datetime" name="" readonly="readonly" value=""/>
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
					<textarea id="myremark"  rows="5" class="TEXTAREA_STYLE1" style="resize:none"  name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">
						答案a
				</td>
				<td colspan="7" class="TD_STYLE2">
					<textarea id="myremark"  rows="3" class="TEXTAREA_STYLE1" style="resize:none"  name="keyA"></textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">
						答案b
				</td>
				<td colspan="7" class="TD_STYLE2">
					<textarea id="myremark"  rows="3" class="TEXTAREA_STYLE1" style="resize:none"  name="keyB"></textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">
						答案c
				</td>
				<td colspan="7" class="TD_STYLE2">
					<textarea id="myremark"  rows="3" class="TEXTAREA_STYLE1" style="resize:none"  name="keyC"></textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">
						答案d
				</td>
				<td colspan="7" class="TD_STYLE2">
					<textarea id="myremark"  rows="3" class="TEXTAREA_STYLE1" style="resize:none"  name="keyD"></textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">
						答案e
				</td>
				<td colspan="7" class="TD_STYLE2">
					<textarea id="myremark"  rows="3" class="TEXTAREA_STYLE1" style="resize:none"  name="keyE"></textarea>
				</td>
			</tr>
			<tr>
				<td width="12.5%" class="TD_STYLE1">
					 正确答案
				</td>
				<td width="12.5%" class="TD_STYLE2">
					<input class="INPUT_STYLE2"  name=""/>
				</td>
				<td width="12.5%" class="TD_STYLE1">
					 试题出处
				</td>
				<td width="12.5%" class="TD_STYLE2" >
					<input class="INPUT_STYLE2"  name=""/>
				</td>
				<td width="12.5%" class="TD_STYLE1" colspan="4">
				
				</td>
				
			</tr>
		</table>
	</form>



  </body>
</html>
<script type="text/javascript">
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

</script>