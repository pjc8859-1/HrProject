<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'human_register.jsp' starting page</title>
    
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
		<link rel="stylesheet" type="text/css" media="all" href="javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
		<script type="text/javascript" src="javascript/comm/select.js"></script>
		<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" src="javascript/userdetails.js"></script>
		<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
		<script type="text/javascript">
			var listconfigfirstkind = ${listconfigfirstkind};//一级机构json数组
			var listconfigsecondkind = ${listconfigsecondkind};//二级机构json数组
			var listconfigthridkind = ${listconfigthridkind};//三级机构json数组
			var listmajorkind = ${listmajorkind};//职业分类
			var listconfigmajor = ${listconfigmajor};//职业
			var firstkindselect = null;
			var secondkindselect = null;
			var thirdkindselect = null;
			var zyflselect = null;
			var zyselect = null;
		
		$(function(){
			aaa = 2;
			showfirstkind();
			showsecondkind();
			showthirdkind();
			showzyfl();
			showzy();
			savelist();
			$("#selectfirst").change(function(){
				
				changelocation($("#selectfirst option:selected").html());
				
			});
			$("#selectsecond").change(function(){
				
				changelocation1($("#selectsecond option:selected").html());
				
			});
			$("#selectthrid").change(function(){
						
						//changelocation2($("#selectthrid option:selected").html());
						
			});
			$("#selectmajorkind").change(function(){
				
				changelocation2($("#selectmajorkind option:selected").html());
				
			});
			
		})
		
		function savelist(){
			firstkindselect = document.getElementById("selectfirst").outerHTML;
			secondkindselect = document.getElementById("selectsecond").outerHTML;
			thirdkindselect = document.getElementById("selectthrid").outerHTML;
			zyflselect = document.getElementById("selectmajorkind").outerHTML;
			zyselect =document.getElementById("selectmajor").outerHTML;
		}
		function showfirstkind(firstneedshow)
		{		
			//得到所有select标签;
			$("#selectfirst").empty();//清空一级机构
			//$("#selectfirst").append("<option value=''  selected='true'></option>");//添加一个空的选项
			if(firstneedshow ==null || firstneedshow =="")
			{
				//如果没有传值,就显示全部
				for(var i=0; i< listconfigfirstkind.length ;i++)
					{	
						var id = listconfigfirstkind[i].firstKindId;
						var name = listconfigfirstkind[i].firstKindName;
						
						$("#selectfirst").append("<option value="+id+">"+name+"</option>");
					}
			}
		}
		function showsecondkind(secondneedshow){
			$("#selectsecond").empty();//清空二级机构
			//$("#selectsecond").append("<option value='' selected='true'"+"></option>");
			if(secondneedshow == null || secondneedshow =="")
				{
					
					for(var i=0; i< listconfigsecondkind.length ;i++)
					{	
						var fid = listconfigsecondkind[i].firstKindId;
						var fname = listconfigsecondkind[i].firstKindName;
						var sid = listconfigsecondkind[i].secondKindId;
						var sname = listconfigsecondkind[i].secondKindName;
						
						$("#selectsecond").append("<option value="+sid+">"+fname+"/"+sname+"</option>");
					}
				}else
					{
						//传了值
						
						$("#selectsecond").append(secondneedshow);
					}
			
		}
		function lista(){
			var myform = document.getElementById("myform");
			myform.submit();
		}
		function showthirdkind(thirdneedshow){
			$("#selectthrid").empty();//清空三级机构
			
			if(thirdneedshow == null || thirdneedshow =="")
			{
				
				for(var i=0; i< listconfigthridkind.length ;i++)
				{	
					var fid = listconfigthridkind[i].firstKindId;
					var fname = listconfigthridkind[i].firstKindName;
					var sid = listconfigthridkind[i].secondKindId;
					var sname = listconfigthridkind[i].secondKindName;
					var tid = listconfigthridkind[i].thirdKindId;
					var tname = listconfigthridkind[i].thirdKindName;
					
					$("#selectthrid").append("<option value="+tid+">"+fname+"/"+sname+"/"+tname+"</option>");
				}
			}
			else{
				$("#selectthrid").append(thirdneedshow);
			}
			
			
			
		}
		
		function showzyfl(fourthneedshow){
			$("#selectmajorkind").empty();//清空职位分类
				if(fourthneedshow == null || fourthneedshow =="")
				{
					for(var i=0; i< listmajorkind.length ;i++)  
					{	
						var fid = listmajorkind[i].majorKindId;
						var fname = listmajorkind[i].majorKindName;
						
						$("#selectmajorkind").append("<option value="+fid+">"+fname+"</option>");
					}
				}
				else{
					$("#selectmajorkind").append(fourthneedshow);
				}
				
		}
		
		function showzy(fifthneedshow){
			$("#selectmajor").empty();//清空职位分类
			if(fifthneedshow == null || fifthneedshow =="")    
			{
				for(var i=0; i< listconfigmajor.length ;i++)
				{	
					var fid = listconfigmajor[i].majorKindId;
					var fname = listconfigmajor[i].majorKindName;
					var sid = listconfigmajor[i].majorId;
					var sname =listconfigmajor[i].majorName;
					$("#selectmajor").append("<option value="+sid+">"+fname+"/"+sname+"</option>");
				}
			}
			else{
				$("#selectmajor").append(fifthneedshow);
			}
			
		}
		
		function changelocation(locationid)
		{	
		   var locid=locationid;
			 	if(locid==""||locid==null){
			 		//如果选中first为空的值，则secondshow出全部值
			 		showsecondkind();
			 		showthirdkind();
			 	} 
			 	else{
			 			
			 		//不是空就去比较第二个集合里面以选择的值开头的项展示出来
			 		var list =``;
			 		for(var j =0;j < $(secondkindselect).children().length; j++)
			 			{	
			 				if($($(secondkindselect).children()).eq(j).html().startsWith(locid)){
			 					var  txt = ($(secondkindselect).children().eq(j))[0].outerHTML;
			 					list+=txt;
			 					}
			 			}
			 		showsecondkind(list);
			 		}
		}	
		 function changelocation1(locationid)
		  {
			 var locid=locationid;
			 	if(locid==""||locid==null){
			 		//如果选中first为空的值，则secondshow出全部值
			 		showthirdkind();
			 	} 
			 	else{
			 			
			 		//不是空就去比较第二个集合里面以选择的值开头的项展示出来
			 		console.log("locid"+locid);
			 		console.log( $(thirdkindselect).children());
			 		var list =``;
			 		for(var j =0 ;j < $(thirdkindselect).children().length; j++)
			 			{	
			 				if($($(thirdkindselect).children()).eq(j).html().startsWith(locid)){
			 					var  txt = ($(thirdkindselect).children().eq(j))[0].outerHTML;
			 					list+=txt;
			 					}
			 			}
			 		showthirdkind(list);
			 		}
		 }
		 
		 
		 function changelocation2(locationid)
		  {
			 var locid=locationid;
			 console.log("locid"+locid);
			 	if(locid==""||locid==null){
			 		
			 		//如果选中first为空的值，则secondshow出全部值
			 		showzy();
			 	} 
			 	else{
			 			
			 		//不是空就去比较第二个集合里面以选择的值开头的项展示出来
			 		var list =``;
			 		console.log("length"+zyselect);
			 		for(var j =0 ;j < $(zyselect).children().length; j++)
			 			{	
			 				if($($(zyselect).children()).eq(j).html().startsWith(locid)){
			 					//var  txt = $(secondkindselect).children().eq(j).html();
			 					var  txt = ($(zyselect).children().eq(j))[0].outerHTML;
			 					list+=txt;
			 					}
			 			}
			 		showzy(list);
			 		}
		 }
		 
		</script>
		
  </head>
  
 <body>
 <form name="humanfileForm" method="post"   enctype="multipart/form-data"   action="hr/humanfilregister.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案登记 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1" onclick="mysubmit()">
						<input type="reset" value="清除" class="BUTTON_STYLE1">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="11%">
						I级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						<select name="item.firstKindId" class="SELECT_STYLE1" id="selectfirst">
						</select>    
					</td>
					<td width="11%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						<select name="item.secondKindId" class="SELECT_STYLE1" id="selectsecond">
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2" colspan="2">
						<select name="item.thirdKindId" class="SELECT_STYLE1" id="selectthrid"></select>
					</td>
					<td rowspan="5">
						<img src="" height="150px" id="img" onclick="picselect()" style="width: 200px; "/>
					</td>
						<input id="input_picture" name="item.picture" type="file" style="height: 30px;display: none;" onchange="show(this)"/>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanMajorKindId"   class="SELECT_STYLE1" id="selectmajorkind"> 
						</select>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						<select name="item.hunmaMajorId" class="SELECT_STYLE1" id="selectmajor">
						</select>
					</td>
					<td class="TD_STYLE1">
						职称
					</td>
					<td colspan="2" class="TD_STYLE2">
						<select name="item.humanProDesignation" class="SELECT_STYLE1">
							<c:forEach items="${listzc}" var="zc">
								<option>${zc.attributeName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.humanName" value="" id="myname" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanSex" class="SELECT_STYLE1" id="mysex"><option value="男">男</option>
							<option value="女">女</option></select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="item.humanEmail" id="myemail" value="" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.humanTelephone" id="myphone" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						QQ
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.humanQq" id="myqq" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="item.humanMobilephone" id="mymobilephone" value="" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="item.humanAddress" id="myaddress" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="item.humanPostcode" id="mypostcard" value="" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanNationality" class="SELECT_STYLE1">
						<c:forEach items="${listgj }" var="gj">
							<option>${gj.attributeName}</option>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.humanBirthplace" id="mybirthadd" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" class="TD_STYLE2">
						<input type="text" name="item.str_humanBirthday" id="mybirthday" value="" class="INPUT_STYLE2">
					</td>
					<td width="11%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2" width="14%">
						<select name="item.humanRace" class="SELECT_STYLE1" id="myhumanrace">
						<c:forEach items="${listmz }" var="mz">
							<option>${mz.attributeName}</option>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanReligion" class="SELECT_STYLE1" id="myhumanreligion">
						<c:forEach items="${listzjxy }" var="zjxy">
							<option>${zjxy.attributeName}</option>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2">
						<select name="item.humanParty" class="SELECT_STYLE1" id="myhumanparty">
							<c:forEach items="${listzzmm }" var="zzmm">
								<option>${zzmm.attributeName}</option>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.humanIdCard" value="" class="INPUT_STYLE2" id="myidcard">
					</td>
					<td class="TD_STYLE1">
						社会保障号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" id="mysocietysrcurityid" name="item.humanSocietySecurityId" value="" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" id="myage" name="item.humanAge" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
						<select id="myeducateddegree" name="item.humanEducatedDegree" class="SELECT_STYLE1">
							<c:forEach items="${listxl }" var="xl">
								<option>${xl.attributeName}</option>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<select id="myeducatedyears" name="item.humanEducatedYears" class="SELECT_STYLE1">
							<c:forEach items="${listjynx }" var="jynx">
								<option>${jynx.attributeName}</option>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<select id="myeducatedmajor" name="item.humanEducatedMajor" class="SELECT_STYLE1">
							<c:forEach items="${listzy }" var="zy">
								<option>${zy.attributeName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						薪酬标准
					</td>
					<td class="TD_STYLE2">
						<select id="mysalarystandard" name="item.salaryStandardName" class="SELECT_STYLE1"><option value="0/未定义">0/未定义</option></select>
					</td>
					<td class="TD_STYLE1">
						开户行
					</td>
					<td class="TD_STYLE2">
						<input id="mybank" type="text" name="item.humanBank" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						帐号
					</td>
					<td class="TD_STYLE2">
						<input id="myaccount" type="text" name="item.humanAccount" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.register" value="better_wanghao" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						建档时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.str_registTime"  id="humanregistertime"  readonly="readonly" class="INPUT_STYLE2">
						<script type="text/javascript">
									 
							 function nowtime()
							 {
								console.log("进到时间函数");
							 	var time = new Date();
							 	var Y = time.getFullYear();
							 	var Mt = time.getMonth()+1;
							 	var D = time.getDate();
							 	var H = time.getHours();
							 	var min = time.getMinutes();
							 	var se = time.getSeconds();
							 	return Y+"-"+Mt+"-"+D+" "+H+":"+min+":"+se;
							 }
							
							document.getElementById("humanregistertime").value = nowtime();
		
							
						</script>
					
					
					</td>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<select id="myspeciality" name="item.humanSpeciality" class="SELECT_STYLE1">
							<c:forEach items="${listtc }" var="tc">
								<option>${tc.attributeName}</option>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<select id="myhoppy" name="item.humanHobby" class="SELECT_STYLE1">
							<c:forEach items="${listah }" var="ah">
								<option>${ah.attributeName}</option>
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
						个人履历
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea id="myhistoryrecords" name="item.humanHistroyRecords" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						家庭关系信息
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea id="mymembersgip" name="item.humanFamilyMembership" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea id="myremark" name="item.remark" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script type="text/javascript">
	
	var isok="${exist}";
	if(isok=="exist")
	{
		alert("注册失败！用户名已存在！请重新输入用户名！");
	}
	
	
	
	
	function mysubmit()
	{
		var myName = $("#myname");//姓名
		var mySex = $("#mysex");//性别
		var myEmail = $("#myemail");//邮箱
		var myphone = $("#myphone");//电话
		var myQQ = $("#myqq");//qq
		var myMobilephone=$("#mymobilephone");//手机
		var myAddress = $("#myaddress");//地址
		var myPostcard = $("#mypostcard");//邮编
		var myBirthadd = $("#mybirthadd");//出生地
		var myBirthday = $("#mybirthday");//生日
		var myIdcard = $("#myidcard");//身份证
		var mySocietysrcurityid = $("#mysocietysrcurityid");//社会保障号
	 	var myAge = $("#myage");//年龄
		var myBank = $("#mybank");//开户行
		var myAccount = $("#myaccount");//账户
		var myHistoryrecords = $("#myhistoryrecords");//个人履历
		var myMembersgip = $("#mymembersgip");//家庭关系
		var myRemark = $("#myremark");//备注
		var reg1 = /^\s+/;
		var reg2 = /\s+$/;
		var reg3 = /^\w+@(qq|163)\.com$/;//邮箱
		var reg4 = /^\d{17}[0-9X]$/;
		var reg7 = /^[1-9][0-9]{4,}$/;//qq
		var reg8 = /^[1-9]{2}\d{9}$/;//电话
		if(!reg4.test($("#myidcard").val()) || $("#myidcard").val()=="")
		{
			alert("身份证格式不对！");
			return $("#myidcard").focus();
		}
		if(reg1.test(myName.val()) || reg2.test(myName.val()) || myName.val() == "" )
		{
			alert("姓名不能为空且不能以空格开头结尾！");
			return $("#myname").focus();
		}
		if(!reg3.test(myEmail.val()) || $("#myemail")=="")
		{
			alert("邮箱格式不正确且不能为空");
			return $("#myemail").focus();
		}
		if(!reg7.test(myQQ.val()) || myQQ.val()=="")
		{
			alert("请填写正确的QQ号！");
			return $("#myqq").focus();
		}
		if(!reg8.test(myMobilephone.val())||myMobilephone.val()=="")
		{
			alert("请填写正确的手机号！");
			return $("#mymobilephone").focus();
		}
		if(myAddress.val()=="")
		{
			alert("请输入正确的地址信息");
			return $("#myaddress").foucus;
		}
		if(myPostcard.val()=="")
		{
			alert("请填写邮编");
			return $("#mypostcard").focus();
	 	}
		if(myBirthadd.val()=="")
		{
			alert("请填写出生地");
			return $("#mybirthadd").focus();
	 	}
		if(mySocietysrcurityid.val()=="")
		{
			alert("请填写社会保障号码");
			return $("#mysocietysrcurityid").focus();
	 	}
		if(myAge.val()=="")
		{
			alert("请填写您的年龄！");
			return $("#myage").focus();
		}
	 	if(myBank.val()=="")
	 	{
			alert("请填写开户银行");
			return $("#mybank").focus();
	 	}
	 	if(myAccount.val()=="")
	 	{
			alert("请填写银行账户");
			return $("#myaccount").focus();
	 	}
	 	if(myHistoryrecords.val()=="")
	 	{
	 		alert("请填写您的个人履历");
	 		return $("#myhistoryrecords").focus();
	 	}
	 	if(myMembersgip.val()=="")
	 	{
	 		alert("请填写家庭关系！");
	 		return $("#mymembersgip").focus();
	 	}
	 	if(myRemark.val()=="")
	 	{
	 		alert("请完善备注！");
	 		return $("#myremark").focus();
	 	}
	 	if($("#mybirthday").val()=="")
	 	{
	 		alert("请输入您的生日！");
	 		return $("#mybirthday").focus();
	 	}
	 	if($("#myphone").val()=="")
	 	{
	 		alert("请输入您的电话号码");
	 		return $("#myphone").focus();
	 	}
	 	if($("#input_picture").val()=="")
	 	{
	 		alert("请选择您的照片！");
	 		return ;
	 	}
		
		document.humanfileForm.submit();
	}
	
	
	</script>
<script type="text/javascript">
Calendar.setup ({inputField : "mybirthday", ifFormat : "%Y-%m-%d", showsTime : false, button : "mybirthday", singleClick : true, step : 1});
Calendar.setup ({inputField : "date_end", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_end", singleClick : true, step : 1});
</script>
</html>
