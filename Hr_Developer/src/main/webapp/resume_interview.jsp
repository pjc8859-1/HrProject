<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<!-- 面试页面 -->
  <head>
    <base href="<%=basePath%>">
    <!-- resume_interview.jsp -->
    <title>resume_interview.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="table.css" type="text/css">
		<link rel="stylesheet" type="text/css" media="all"
			href="javascript/calendar/calendar-win2k-cold-1.css">
			<style type="text/css">
		input::-webkit-outer-spin-button,
		input::-webkit-inner-spin-button {
		  -webkit-appearance: none;
		}
		input[type="number"]{
		  -moz-appearance: textfield;
}
	</style>
		<script type="text/javascript" src="javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
		<script type="text/javascript" src="javascript/comm/select.js"></script>
		<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" src="javascript/ajaxfileupload.js"></script>
		
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
			function checknullorempty(){
				if($("#checker").val() == "" ||$("#checker").val()==null)
					{
						alert("推荐人不能为空");
						return false;
					}
				if($("#suggestion").val() == "" ||$("#suggestion").val()==null)
				{
					alert("推荐意见不能为空");
					return false;
				}
			
				return true;
			}
			//提交按钮
			function mysubmit(){
				if(checknullorempty())
					{
						document.getElementById("myform").submit();
					}else{
						return;
					}
			}
		</script>
		
  </head>
  
 <body>
 <form id="myform"  method="post"  enctype="multipart/form-data" action="resumemanage/checkresume.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--招聘管理-- 简历管理 --简历登记 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label><input type="radio" name="suggest" value="0" checked="checked"/>建议面试</label>
						<label><input type="radio" name="suggest" value="1" />建议笔试</label>
						<label><input type="radio" name="suggest" value="2" />建议录用</label>
						<label><input type="radio" name="suggest" value="3" />删除简历</label>
						
						<input type="button" value="确认" class="BUTTON_STYLE1" onclick="mysubmit()">
						<input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.go(-1);">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<!-- 主键 -->
				<input type="hidden" name="resId" value="${er.resId }"/>
				<tr>
					<td class="TD_STYLE1" width="13%">
						职位分类
					</td>
					<td width="13%" class="TD_STYLE2">
						${er.humanMajorKindName }    
					</td>
					<td width="13%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="13%" class="TD_STYLE2">
					${er.humanMajorName } 
					</td>
					<td width="13%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" colspan="2" width="13%">
						${er.engageType } 
					</td>
					<td rowspan="6" width="13%">
							<!-- 图片 -->
    						<img id="img" src="upload/${er.humanPicture }"style="width: 130px;height: 150px" alt="未上传图片"  />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						${er.humanName }
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						${er.humanSex }
					</td>
					<td class="TD_STYLE1">
						Email
					</td>
					<td colspan="2" class="TD_STYLE2">
						${er.humanEmail }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						${er.humanTelephone }
					</td>
					<td class="TD_STYLE1">
						家庭电话
					</td>
					<td class="TD_STYLE2">
						${er.humanHomephone }
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						${er.humanMobilephone }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						${er.humanAddress }
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						${er.humanPostcode }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
					${er.humanNationality }
						
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
					${er.humanBirthplace }
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td class="TD_STYLE2" colspan="2">
						${er.humanBirthday }
					</td>
					
				</tr>
				<tr>
					<td class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2">
						${er.humanRace }
					</td>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						${er.humanReligion }
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2" colspan="2">
						${er.humanParty }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						${er.humanIdcard }
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						${er.humanAge }
					</td>
					<td class="TD_STYLE1">
						毕业院校
					</td>
					<td class="TD_STYLE2" colspan="1" width="100px">
						${er.humanCollege }
						
					</td>
					<td class="TD_STYLE1" width="100px">
						学历
					</td>
					<td class="TD_STYLE2">
						${er.humanEducatedDegree }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						${er.humanEducatedYears }
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						${er.humanEducatedMajor }
					</td>
					<td class="TD_STYLE1">
						薪酬要求
					</td>
					<td class="TD_STYLE2">
						${er.demandSalaryStandard }
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					<td class="TD_STYLE2">
						${fn:substring(er.registTime, 0, 19)}
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						${er.humanSpecility }
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						${er.humanHobby }
					</td>
					<td class="TD_STYLE1">
						推荐人
					</td>
					<td class="TD_STYLE2">
						${er.checker }
					</td>
					<td class="TD_STYLE1">
						推荐时间
					</td>
					<td class="TD_STYLE2">
						${fn:substring(er.checkTime, 0, 19)}
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						个人履历
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea style="resize:none"	 id="myhistoryrecords"  rows="4" class="TEXTAREA_STYLE1"  readonly="readonly">${er.recomandation }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea id="myremark"  rows="4" class="TEXTAREA_STYLE1" style="resize:none"  readonly="readonly">${er.remark }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						筛选推荐意见
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea id="suggestion"  readonly="readonly" name="suggestion" rows="4" class="TEXTAREA_STYLE1" style="resize:none" >${er.humanHistoryRecords }</textarea>
					</td>
				</tr>
				<form id="myform"  method="post"   action="resumemanage/checkresume.do">
					<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
						<tr>
							<td class="TD_STYLE1">
							面试次数
							</td>
							<td class="TD_STYLE2">
							第 1次面试
							</td>
							<td class="TD_STYLE1">
							形象评价
							</td>
							<td class="TD_STYLE2">
								<select name="" class="SELECT_STYLE1">
									<option value="A">A</option>
									<option value="B">B</option>
									<option value="C">C</option>
								</select>
							</td>
							<td class="TD_STYLE1">
							口才评价
							</td>
							<td class="TD_STYLE2">
								<select name="" class="SELECT_STYLE1">
									<option value="A">A</option>
									<option value="B">B</option>
									<option value="C">C</option>
								</select>
							</td>
							<td class="TD_STYLE1">
							外语口语能力
							</td>
							<td class="TD_STYLE2">
								<select name="" class="SELECT_STYLE1">
									<option value="A">A</option>
									<option value="B">B</option>
									<option value="C">C</option>
								</select>
							</td>
						</tr>
					<tr>
						<td class="TD_STYLE1">
						应变能力
						</td>
						<td class="TD_STYLE2">
							<select name="" class="SELECT_STYLE1">
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
							</select>
						</td>
						<td class="TD_STYLE1">
						EQ
						</td>
						<td class="TD_STYLE2">
							<select name="" class="SELECT_STYLE1">
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
							</select>
						</td>
						<td class="TD_STYLE1">
						IQ
						</td>
						<td class="TD_STYLE2">
							<select name="" class="SELECT_STYLE1">
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
							</select>
						</td>
						<td class="TD_STYLE1">
						综合素质
						</td>
						<td class="TD_STYLE2">
							<select name="" class="SELECT_STYLE1">
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="TD_STYLE1" width="12.5%">
						面试人
						</td>
						<td class="TD_STYLE2" width="12.5%">
							<input name="" class="INPUT_STYLE2"/>
						</td>
						<td class="TD_STYLE1" width="12.5%">
						面试时间
						</td>
						<td class="TD_STYLE2" width="12.5%">
							<input class="INPUT_STYLE2" id="datetime" name="registTime1" readonly="readonly" value=""/>
							<script type="text/javascript">
							setInterval("document.getElementById('datetime').value=formatDate(new Date().getTime());", 1000);
							</script>
						</td>
						<td class="TD_STYLE1" width="12.5%">
						
						</td>
						<td class="TD_STYLE2" width="12.5%">
							
						</td>
						<td class="TD_STYLE1" width="12.5%">
						
						</td>
						<td class="TD_STYLE2" width="12.5%">
							
						</td>
					</tr>
					<tr>
					<td class="TD_STYLE1">
						面试评价
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea id="myremark"  rows="3" class="TEXTAREA_STYLE1" style="resize:none" ></textarea>
					</td>
					</tr>
					
					
					
					</table>
				
				</form>
				
				
				
			</table>
			
		</form>
	</body>
	
	
	

	
	
	
<script type="text/javascript">
Calendar.setup ({inputField : "birthday", ifFormat : "%Y-%m-%d", showsTime : false, button : "birthday", singleClick : true, step : 1});
Calendar.setup ({inputField : "date_end", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_end", singleClick : true, step : 1});
</script>
</html>
