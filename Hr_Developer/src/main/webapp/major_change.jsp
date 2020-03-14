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
    
    <title>职位调动登记页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="table.css" type="text/css">
	<style type="text/css">
		.select1{
			width:100%;
			heigth:100%;
		}
	</style>
	<script type="text/javascript" src="javascript/comm/comm.js"></script>
  </head>
  
  <body>
  	<form method="post" action="configfilefirstkind.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源 -- 调动管理 -- 调动登记
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1"
							onclick="window.location.href='first_kind_register.jsp'" />
						<input type="reset" value="清除" class="BUTTON_STYLE1">
					</td>
				</tr>
			</table>
			
			
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<!-- 1 -->
				<tr>
					<td width="12.5%" class="TD_STYLE1" >
						档案编号
					</td>
					<td width="87.5%" class="TD_STYLE2" colspan="7">
						${humanfile.humanId}
					</td>
				</tr>
				
				<tr>
					<td width="12.5%" class="TD_STYLE1">
						原I级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
						${humanfile.firstKindName}
					</td>
					<td width="12.5%" class="TD_STYLE1">
						原II级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
						${humanfile.secondKindName }
					</td>
					<td width="12.5%" class="TD_STYLE1">
						原III级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
						${ humanfile.thirdKindName }
					</td>
					<td width="12.5%" class="TD_STYLE1">
						姓名
					</td>
					<td width="12.5%" class="TD_STYLE2">
						${humanfile.humanName}
					</td>
				</tr>
				
				
				
				<!-- 2 -->
				<tr>
					<td width="12.5%" class="TD_STYLE1">
						原职位分类
					</td>
					<td width="12.5%" class="TD_STYLE2">
						${humanfile.humanMajorKindName }
					</td>
					<td width="12.5%" class="TD_STYLE1">
						原职位名称
					</td>
					<td width="12.5%" class="TD_STYLE2">
						${humanfile.hunmaMajorName }
					</td>
					<td width="12.5%" class="TD_STYLE1">
						原薪酬标准
					</td>
					<td width="12.5%" class="TD_STYLE2">
						${humanfile.salaryStandardName}
					</td>
					<td width="12.5%" class="TD_STYLE1">
						
					</td>
					<td width="12.5%" class="TD_STYLE2">
						
					</td>
				</tr>
				
				
				<!-- 3 -->
				<tr>
					<td width="12.5%" class="TD_STYLE1">
						新I级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
							<select class="select1">
						  <option value ="volvo">Volvo</option>
						  
						</select>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						新II级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
							<select class="select1">
						  <option value ="volvo">Volvo</option>
						  
						</select>	
					</td>
					<td width="12.5%" class="TD_STYLE1">
						新III级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
							<select class="select1">
						  <option value ="volvo">Volvo</option>
						  
						</select>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						
					</td>
					<td width="12.5%" class="TD_STYLE2">
						
					</td>
				</tr>
				
				<!-- 4 -->
				<tr>
					<td width="12.5%" class="TD_STYLE1">
					新职位分类
				</td>
					<td width="12.5%" class="TD_STYLE2">
						<select class="select1">
					  	<option value ="volvo">Volvo</option>
						  
						</select>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						新职位名称
					</td>
					<td width="12.5%" class="TD_STYLE2">
							<select class="select1">
						  <option value ="volvo">Volvo</option>
						  
						</select>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						新薪酬标准
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<select class="select1">
						<option value ="volvo">Volvo</option>
						</select>	
					</td>
					<td width="12.5%" class="TD_STYLE1">
						
					</td>
					<td width="12.5%" class="TD_STYLE2">
						
					</td>
				</tr>
				
				<!-- 5 -->
				<tr>
					<td width="12.5%" class="TD_STYLE1">
						登记人
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<input class="select1" name="register"/>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						登记时间
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<div id="datetime">
    					<script>
        				setInterval("document.getElementById('datetime').innerHTML=new Date().toLocaleString();", 1000);
   						</script>
					</td>
					<td width="12.5%" class="TD_STYLE1">
					</td>
					<td width="12.5%" class="TD_STYLE2">
					</td>
					<td width="12.5%" class="TD_STYLE1">
						
					</td>
					<td width="12.5%" class="TD_STYLE2">
						
					</td>
				</tr>
				<tr>
					<td width="12.5%" height="100" class="TD_STYLE1" >
						调动原因
					</td>
					<td width="87.5%"  height="100" class="TD_STYLE2" colspan="7">
						<textarea  style="width:100%;height:100%;resize:none" name="reason" autoHeight="true"></textarea>
					</td>
				</tr>
				
			</table>
			<p>&nbsp;&nbsp;总数：1例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="images/go.bmp" width=18 height=18 border=0>
		</form>
  	
  </body>
</html>
