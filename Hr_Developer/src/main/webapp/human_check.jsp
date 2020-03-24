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
    
    <title>My JSP 'human_check.jsp' starting page</title>
    
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
		<link rel="stylesheet" type="text/css" media="all"
			href="javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
		<script language="javascript" src="javascript/winopen/winopenm.js"></script>
		<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" src="javascript/userdetails.js"></script>
		<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
  </head>

  <body>
<form name="humanfileForm" method="post" action="hr/humancheckfile.do" id="myform">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案复核 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="复核通过" class="BUTTON_STYLE1" onclick="mysubmit()">
						<input type="reset" value="清除" class="BUTTON_STYLE1" >
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back()">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
				<input type="hidden" name="item.hufId" value="1">
					<td class="TD_STYLE1" width="10%">
						档案编号
					</td>
					
					<td colspan="6" class="TD_STYLE2">
						<input type="text" id="huid" name="item.huid" value="${humanf.humanId}" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td rowspan="6" width="1%">
						<img src="${pic}" height="150px" id="img" onclick="picselect()" style="width: 200px; "/>
					</td>
						<input id="input_picture" name="item.picture" type="file" style="height: 30px;display: none;" onchange="show(this)"/>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="10%">
						I级机构
					</td>
					<td width="13%" class="TD_STYLE2">
						${humanf.firstKindName}
					</td>
					<td width="10%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="13%" class="TD_STYLE2">
						${humanf.secondKindName}
					</td>
					<td width="10%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2" colspan="2" width="2%" >
						${humanf.thirdKindName}
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						${humanf.humanMajorKindName}
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						${humanf.hunmaMajorName}
					</td>
					<td class="TD_STYLE1">
						职称
					</td>
					<td colspan="2" class="TD_STYLE2">
						<select name="item.humanProDesignation" id="myzc" class="SELECT_STYLE1" id="hpro">
							<c:forEach items="${listzc}" var="zc">
								<c:if test="${zc.attributeName == humanf.humanProDesignation }">
									<option value="${zc.attributeName}" selected="selected">${zc.attributeName}</option>
								</c:if>
								<c:if test="${zc.attributeName != humanf.humanProDesignation}">
									<option value="${zc.attributeName }" >
											${zc.attributeName}
									</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
				</tr>
				<!-- <option>${zc.attributeName}</option> -->
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.humanName" value="${humanf.humanName }" class="INPUT_STYLE2">
						
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanSex" class="SELECT_STYLE1">
						<c:if test="${humanf.humanSex == '男'}">
							<option value="男"selected="selected">男</option>  
						</c:if>
						<c:if test="${humanf.humanSex == '女'}">
							<option value="男"selected="selected">女</option>  
						</c:if>
						</select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="item.humanEmail" value="${humanf.humanEmail}" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.humanTelephone" value="${humanf.humanTelephone}" class="INPUT_STYLE2">
						
					</td>
					<td class="TD_STYLE1">
						QQ
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.humanQq" value="${humanf.humanQq }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="item.humanMobilephone" value="${humanf.humanTelephone}" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="item.humanAddress" value="${humanf.humanAddress }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="item.humanPostcode" value="${humanf.humanPostcode }" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanNationality" class="SELECT_STYLE1">
						<c:forEach items="${listgj}" var="gj">
							<c:if test="${gj.attributeName == humanf.humanNationality }">
								<option value="${gj.attributeName}" selected="selected">
									${gj.attributeName}
								</option>
							</c:if>
							<c:if test="${gj.attributeName != humanf.humanNationality }">
								<option value="${gj.attributeName}">
									${gj.attributeName}
								</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.humanBirthplace" value="${humanf.humanBirthplace}" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" class="TD_STYLE2">
						<input type="text" name="item.humanBirthday" value="${humanf.humanBirthday }" class="INPUT_STYLE2" id="date_start">
					</td>
					<td width="10%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanRace" class="SELECT_STYLE1">
						<c:forEach items="${listmz}" var="mz">
							<c:if test="${mz.attributeName == humanf.humanRace }">
								<option value="${mz.attributeName}" selected="selected">${mz.attributeName}</option>
							</c:if>
							<c:if test="${mz.attributeName != humanf.humanRace }">
								<option value="${mz.attributeName}" >${mz.attributeName}</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanReligion" class="SELECT_STYLE1">
						<c:forEach items="${listzjxy }" var="zjxy">
							<c:if test="${zjxy.attributeName == humanf.humanReligion}">
								<option value="${zjxy.attributeName}" selected="selected">${zjxy.attributeName}</option>
							</c:if>
							<c:if test="${zjxy.attributeName != humanf.humanReligion}">
								<option value="${zjxy.attributeName}">${zjxy.attributeName}</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanParty" class="SELECT_STYLE1">
							<c:forEach items="${listzzmm}" var="zzmm">
							<c:if test="${zzmm.attributeName == humanf.humanParty }">
								<option value="${zzmm.attributeName}" selected="selected">${zzmm.attributeName}</option>
							</c:if>
							<c:if test="${zzmm.attributeName != humanf.humanParty }">
								<option value="${zzmm.attributeName}" >${zzmm.attributeName}</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.humanIdCard" value="${humanf.humanIdCard }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						社会保障号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.humanSocietySecurityId" value="${humanf.humanSocietySecurityId}" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.humanAge" value="${humanf.humanAge }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanEducatedDegree" class="SELECT_STYLE1">
						<c:forEach items="${listxl}" var="xl">
							<c:if test="${xl.attributeName == humanf.humanEducatedDegree }">
								<option value="${xl.attributeName}" selected="selected">${xl.attributeName}</option>
							</c:if>
							<c:if test="${xl.attributeName != humanf.humanEducatedDegree }">
								<option value="${xl.attributeName}" >${xl.attributeName}</option>
							</c:if>
						</c:forEach>
						
						</select>
					</td>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanEducatedYears" class="SELECT_STYLE1">
						<c:forEach items="${listjynx}" var="jynx">
							<c:if test="${jynx.attributeName == humanf.humanEducatedYears }">
								<option value="${jynx.attributeName}"  selected="selected">${jynx.attributeName}</option>
							</c:if>
							<c:if test="${jynx.attributeName != humanf.humanEducatedYears }">
								<option value="${jynx.attributeName}" >${jynx.attributeName}</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanEducatedMajor" class="SELECT_STYLE1">
							<c:forEach items="${listzy}" var="zy">
							<c:if test="${zy.attributeName == humanf.humanEducatedMajor }">
								<option value="${zy.attributeName}" selected="selected">${zy.attributeName}</option>
							</c:if>
							<c:if test="${zy.attributeName != humanf.humanEducatedMajor }">
								<option value="${zy.attributeName}" >${zy.attributeName}</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						薪酬标准
					</td>
					<td class="TD_STYLE2">
						<select name="item.salaryStandardName" class="SELECT_STYLE1"><option value="0/未定义">0/未定义</option></select>
					</td>
					<td class="TD_STYLE1">
						开户行
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.humanBank" value="${humanf.humanBank }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						帐号
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.humanAccount" value="${humanf.humanAccount }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						复核人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.checker" value="better_wanghao" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						复核时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.checkTime" id="humanchecktime"  readonly="readonly" class="INPUT_STYLE2">
				<script type="text/javascript">
					 function nowtime()
							 {
								console.log("进到时间函数");
							 	var time = new Date();
							 	alert(time);
							 	var Y = time.getFullYear();
							 	var Mt = time.getMonth()+1;
							 	var D = time.getDate();
							 	var H = time.getHours();
							 	var min = time.getMinutes();
							 	var se = time.getSeconds();
							 	return Y+"-"+Mt+"-"+D+" "+H+":"+min+":"+se;
							 }
							
							document.getElementById("humanchecktime").value = nowtime();
						</script>
					</td>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanSpeciality" class="SELECT_STYLE1">
							<c:forEach items="${listtc}" var="tc">
							<c:if test="${tc.attributeName == humanf.humanSpeciality}">
								<option value="${tc.attributeName}" selected="selected">${tc.attributeName} </option>
							</c:if>
							<c:if test="${tc.attributeName != humanf.humanSpeciality}">
								<option value="${tc.attributeName}"  >${tc.attributeName} </option>
							</c:if>
						</c:forEach>
							
						</select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanHobby" class="SELECT_STYLE1">
							<c:forEach items="${listah}" var="ah">
							<c:if test="${ah.attributeName == humanf.humanHobby}">
								<option value="${ah.attributeName}" selected="selected">${ah.attributeName}</option>
							</c:if>
							<c:if test="${ah.attributeName != humanf.humanHobby}">
								<option value="${ah.attributeName}" >${ah.attributeName}</option>
							</c:if>
						</c:forEach>
						
						</select>
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
						档案附件
					</td>
					<td colspan="7" class="TD_STYLE2">
						<a href="javascript:winopenm('query.jsp?filename=')"></a>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						个人履历
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="item.humanHistroyRecords" rows="4" value="" class="TEXTAREA_STYLE1">${humanf.humanHistroyRecords}</textarea>
					</td>
					
				</tr>
				<tr>
					<td class="TD_STYLE1">
						家庭关系信息
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="item.humanFamilyMembership" rows="4" value="" class="TEXTAREA_STYLE1">${humanf.humanFamilyMembership }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="item.remark" rows="4" class="TEXTAREA_STYLE1" value="">${humanf.remark }</textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
	  <script type="text/javascript">
	  	function mysubmit()
	  	{
	  				console.log($("#huid").val());
	  				alert($("#myzc").val());
	  				document.humanfileForm.submit();
	  	}
	</script>
<script type="text/javascript">
Calendar.setup ({inputField : "date_start", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_start", singleClick : true, step : 1});
Calendar.setup ({inputField : "date_end", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_end", singleClick : true, step : 1});
</script>
</html>
