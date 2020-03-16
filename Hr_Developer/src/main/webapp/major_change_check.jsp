<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<!-- major_change_check.jsp -->
  <head>
	<base href="<%=basePath%>"> 
    
    <title>职位调动审核详情</title>
    
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
	<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="javascript/comm/comm.js"></script>
	<script type="text/javascript">
	 function dosubmit(){
		 
		 //提交之前处理时间格式
		 
		 
		//var thisTime = $("#datetime").val();
		//thisTime = thisTime.replace(/-/g, '/');
		//var time = new Date(thisTime);
		//time = time.getTime();
		//判断单选框是否为通过
		//var radiovalue = $('input:radio:checked').val();
		//alert(radiovalue);
		
		//if(radiovalue == "0")
		//{alert();}
		//else{
			
		//}
		
		document.getElementById("mainform").submit(); 
	 }
	 function formatDate(date) {
		  var date = new Date(date);
		  var YY = date.getFullYear() + '-';
		  var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
		  var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate());
		  var hh = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
		  var mm = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
		  var ss = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
		  return YY + MM + DD;
		}
	</script>
  </head>
  
  <body>
  	<form method="post" action="majorchange/submitcheck.do" id="mainform">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源 -- 调动管理 -- 调动登记
						</font>
						<input type="hidden" name="mchId" value="${mchId}"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						通过:<input name="checkStatus" type="radio" checked="checked" value="1"/>
						不通过:<input name="checkStatus" type="radio" value="3"/>
					
						<input type="button" value="提交" class="BUTTON_STYLE1"
							onclick="dosubmit()" />
						<input type="reset" value="返回" class="BUTTON_STYLE1" onclick="history.go(-1)">
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
						<input type="hidden" name="humanId" value="${majorchange.humanId}"/>
						${majorchange.humanId}
					</td>
				</tr>
				
				<tr>
					<td width="12.5%" class="TD_STYLE1">
						原I级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
					<input type="hidden" name="firstKindId" value="${majorchange.firstKindId}"/>
					<input type="hidden" name="firstKindName" value="${majorchange.firstKindName}"/>
						${majorchange.firstKindName}
					</td>
					<td width="12.5%" class="TD_STYLE1">
						原II级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
					<input type="hidden" name="secondKindId" value="${majorchange.secondKindId}"/>
					<input type="hidden" name="secondKindName" value="${majorchange.secondKindName}"/>
						${majorchange.secondKindName }
					</td>
					<td width="12.5%" class="TD_STYLE1">
						原III级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
					<input type="hidden" name="thirdKindId" value="${majorchange.thirdKindId}"/>
					<input type="hidden" name="thirdKindName" value="${majorchange.thirdKindName}"/>
						${ majorchange.thirdKindName }
					</td>
					<td width="12.5%" class="TD_STYLE1">
					
						姓名
					</td>
					<td width="12.5%" class="TD_STYLE2">
					<input type="hidden" name="humanName" value="${majorchange.humanName}"/>
						${majorchange.humanName}
					</td>
				</tr>
				
				
				
				<!-- 2 -->
				<tr>
					<td width="12.5%" class="TD_STYLE1">
						原职位分类
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<input type="hidden" name="majorKindId" value="${majorchange.majorKindId}"/>
						<input type="hidden" name="majorKindName" value="${majorchange.majorKindName}"/>
						${majorchange.majorKindName }
					</td>
					<td width="12.5%" class="TD_STYLE1">
						原职位名称
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<input type="hidden" name="majorId" value="${majorchange.majorId}"/>
						<input type="hidden" name="majorName" value="${majorchange.majorName}"/>
						${majorchange.majorName }
					</td>
					<td width="12.5%" class="TD_STYLE1">
						原薪酬标准
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<input type="hidden" name="salaryStandardId" value="${majorchange.salaryStandardId}"/>
						<input type="hidden" name="salaryStandardName" value="${majorchange.salaryStandardName}"/>
						${majorchange.salaryStandardName}
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
							<input  id="newFirstKindId" type="hidden" name="newFirstKindId" value="${majorchange.newFirstKindId}"/>
							<input id="newFirstKindName" type="hidden" name="newFirstKindName" value="${majorchange.newFirstKindName}"/>
							${majorchange.newFirstKindName}
					</td>
					<td width="12.5%" class="TD_STYLE1">
						新II级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
					<input  id="newSecondKindId" type="hidden" name="newSecondKindId" value="${majorchange.newSecondKindId}"/>
					<input id="newSecondKindName" type="hidden" name="newSecondKindName" value="${majorchange.newSecondKindName}"/>
					${majorchange.newSecondKindName}
					</td>
					<td width="12.5%" class="TD_STYLE1" >
						新III级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
					<input  id="newThirdKindId" type="hidden" name="newThirdKindId" value="${majorchange.newThirdKindId}"/>
					<input id="newThirdKindName" type="hidden" name="newThirdKindName" value="${majorchange.newThirdKindName}"/>
						${majorchange.newThirdKindName}
					</td>
					<td width="12.5%" class="TD_STYLE1">
						
					</td>
					<td width="12.5%" class="TD_STYLE2">
						
					</td>
				</tr>
	<!-- ================================================================================ -->			
				<!-- 4 -->
				<tr>
					<td width="12.5%" class="TD_STYLE1">
					
					新职位分类
				</td>
					<td width="12.5%" class="TD_STYLE2">
					<input  id="newMajorKindId" type="hidden" name="newMajorKindId" value="${majorchange.newMajorKindId}"/>
					<input id="newMajorKindName" type="hidden" name="newMajorKindName" value="${majorchange.newMajorKindName}"/>
					${majorchange.newMajorKindName}
					</td>
					<td width="12.5%" class="TD_STYLE1">
						新职位名称
					</td>
					<td width="12.5%" class="TD_STYLE2">
					<input  id="newMajorId" type="hidden" name="newMajorId" value="${majorchange.newMajorId}"/>
					<input  id="newMajorName" type="hidden" name="newMajorName" value="${majorchange.newMajorName}"/>
					${majorchange.newMajorName}
					</td>
					<td width="12.5%" class="TD_STYLE1">
						新薪酬标准
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<input  id="newSalaryStandardId" type="hidden" name="newSalaryStandardId" value="${majorchange.salaryStandardId }"/>
						<input  id="newSalaryStandardName" type="hidden" name="newSalaryStandardName" value="${majorchange.salaryStandardName }"/>
						${majorchange.salaryStandardName }
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
						<input class="select1" name="register" value="${majorchange.register }" readonly="readonly"/>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						登记时间
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<input id="time" type="text" class="select1" name="registTime1" value="${fn:substring(majorchange.registTime, 0, 10)} " readonly="readonly"/>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						审核时间
					</td>
					<td width="12.5%" class="TD_STYLE2">
					<input id="datetime" type="text" class="select1" name="checkTime1" value="" readonly="readonly"/>
						<script>
        				setInterval("document.getElementById('datetime').value=formatDate(new Date().getTime());", 1000);
   						</script>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						审核人姓名
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<input class="select1" type="text" name="checker" />
					</td>
				</tr>
				<tr>
					<td width="12.5%" height="100" class="TD_STYLE1" >
						调动原因
					</td>
					<td width="87.5%"  height="100" class="TD_STYLE2" colspan="7">
						<textarea  style="width:100%;height:100%;resize:none" name="changeReason" autoHeight="true" readonly="readonly" value="${majorchange.changeReason }">${majorchange.changeReason }</textarea>
						
					</td>
				</tr>
				<tr>
					<td width="12.5%" height="100" class="TD_STYLE1" >
						审核意见
					</td>
					<td width="87.5%"  height="100" class="TD_STYLE2" colspan="7">
						<textarea  style="width:100%;height:100%;resize:none" name="checkReason" autoHeight="true" >${majorchange.checkReason }</textarea>
						
					</td>
				</tr>
				
			</table>
		</form>
  	
  </body>
</html>
