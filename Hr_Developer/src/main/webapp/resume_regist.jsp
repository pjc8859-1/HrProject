<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<!-- 简历登记页面 -->
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
		var fourthlist = ${fourthlist};//职业分类
		var fifthlist = ${fifthlist};//职业
		var fourthselect = null;
		var fifthselect = null;
		$(function(){
			showfourth();
			showfifth();
			savelist();
			$("#select4").change(function(){
				var  changetagouterhtml=getlastletter( $("#select4 option:selected").html());
				var changetaghtml = $($("#select4 option:selected")[0]).val();
				//修改hidden输入框的值
				
				$("#newMajorKindId").val(changetaghtml);
				$("#newMajorKindName").val(changetagouterhtml);
				changelocation2($("#select4 option:selected").html());
				
			});
			$("#select5").change(function(){
				var  changetagouterhtml=getlastletter( $("#select5 option:selected").html());
				var changetaghtml = $($("#select5 option:selected")[0]).val();
				//修改hidden输入框的值
				$("#newMajorId").val(changetaghtml);
				$("#newMajorName").val(changetagouterhtml);
						//changelocation2($("#select3 option:selected").html());
						
			});
			$("#select6").change(function(){
				var  changetagouterhtml=getlastletter( $("#select6 option:selected").html());
				var changetaghtml = $($("#select6 option:selected")[0]).val();
				//修改hidden输入框的值
				$("#newSalaryStandardId").val(changetaghtml);
				$("#newSalaryStandardName").val(changetagouterhtml);
			});
			
		})
		//------------------------------------------------------------
		function getlastletter(word){
		var index = word .lastIndexOf("\/");  
		word  = word .substring(index + 1, word .length);
		return word;
	}
	function show(){
		console.log(secondselect.children());
	}
	function savelist(){
		fourthselect = document.getElementById("select4").outerHTML;
		fifthselect =document.getElementById("select5").outerHTML;
		
	}
	
	function showfourth(fourthneedshow){
		$("#select4").empty();//清空职位分类
		$("#select4").append("<option value='' selected='true' ></option>");
			if(fourthneedshow == null || fourthneedshow =="")
			{
				for(var i=0; i< fourthlist.length ;i++)
				{	
					var fid = fourthlist[i].majorKindId;
					var fname = fourthlist[i].majorKindName;
					
					$("#select4").append("<option value="+fid+">"+fname+"</option>");
				}
			}
			else{
				$("#select4").append(fourthneedshow);
			}
			
	}
	
	function showfifth(fifthneedshow){
		$("#select5").empty();//清空职位分类
		$("#select5").append("<option value='' selected='true' ></option>");
		if(fifthneedshow == null || fifthneedshow =="")
		{
			for(var i=0; i< fifthlist.length ;i++)
			{	
				var fid = fifthlist[i].majorKindId;
				var fname = fifthlist[i].majorKindName;
				var sid = fifthlist[i].majorId;
				var sname =fifthlist[i].majorName;
				$("#select5").append("<option value="+sid+">"+fname+"/"+sname+"</option>");
			}
		}
		else{
			$("#select5").append(fifthneedshow);
		}
		
	}
	 
	 
	 function changelocation2(locationid)
	  {
		 var locid=locationid;
		 	if(locid==""||locid==null){
		 		
		 		//如果选中first为空的值，则secondshow出全部值
		 		showfifth();
		 	} 
		 	else{
		 			
		 		//不是空就去比较第二个集合里面以选择的值开头的项展示出来
		 		var list =``;
		 		for(var j =0 ;j < $(fifthselect).children().length; j++)
		 			{	
		 				if($($(fifthselect).children()).eq(j).html().startsWith(locid)){
		 					//var  txt = $(secondselect).children().eq(j).html();
		 					var  txt = ($(fifthselect).children().eq(j))[0].outerHTML;
		 					list+=txt;
		 					}
		 			}
		 		showfifth(list);
		 		}
		 	
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
			var content;
			function showphoto(){
				var obj = document.getElementById("photo");
					var fr = new FileReader();
					var f = obj.files[0];
					fr.readAsDataURL(f);
					fr.onload = function(e){
						content = e.target.result;
						var filemin = 0;
						var filemax = 1024*10;//限定为10m
						var filesize  = f.size/1024;
						document.getElementById("img").src=content;
						if(filesize > filemax )
							{
								alert("文件过大<0-10M>");
								$("#submit").attr("disabled","disabled");
							}
					}
				}
			function isornotnull(obj)
			{
			}
			function checknullorempty(){
				if($("#newMajorKindName").val() == "" ||$("#newMajorKindName").val()==null)
					{
						alert("职位分类不能为空");
						return false;
					}
				if($("#newMajorName").val() == "" ||$("#newMajorName").val()==null)
				{
					alert("职位不能为空");
					return false;
				}
			
				if($("#engageType").val() == "" ||$("#engageType").val()==null)
				{
					alert("招聘类型不能为空");
					return false;
				}
				if($("#humanNames").val() == "" ||$("#humanNames").val()==null)
				{
					alert("姓名不能为空");
					return false;
				}
				if($("#humanSex").val() == "" ||$("#humanSex").val()==null)
				{
					alert("性别不能为空");
					return false;
				}
				if($("#humanEmail").val() == "" ||$("#humanEmail").val()==null)
				{
					alert("Email不能为空");
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
 <form id="myform"  method="post"  enctype="multipart/form-data" action="resumemanage/submitresumeregist.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--招聘管理-- 简历管理 --简历登记 </font>
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
					<td class="TD_STYLE1" width="14%">
						职位分类
					</td>
					<td width="14%" class="TD_STYLE2">
					<input  id="newMajorKindId" type="hidden" name="humanMajorKindId" value=""/>
					<input id="newMajorKindName" type="hidden" name="humanMajorKindName" value=""/>
						<select  class="SELECT_STYLE1" id="select4">
							
						</select>    
					</td>
					<td width="14%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="14%" class="TD_STYLE2">
					<input  id="newMajorId" type="hidden" name="humanMajorId" value=""/>
					<input  id="newMajorName" type="hidden" name="humanMajorName" value=""/>
						<select class="SELECT_STYLE1" id="select5">
						  
						</select>
					</td>
					<td width="14%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" colspan="2" width="14%">
						<select  class="SELECT_STYLE1"  name="engageType" id="engageType">
							<option value=""></option>
							<c:forEach items="${charlist}" var="cha" >
								<option value="${cha.attributeName}">${cha.attributeName}</option>
							</c:forEach>
						</select>
					</td>
					<td rowspan="6" width="14%">
							<!-- 图片 -->
							<input  type="file" id="photo" name= "file" style="display:none;"  onchange="showphoto()"/>
    						<img id="img"style="width: 130px;height: 150px" alt="点击上传图片" onclick="document.getElementById('photo').click()" />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input class="INPUT_STYLE2" name="humanName" id="humanNames"/>
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select  class="SELECT_STYLE1"  name="humanSex" id="humanSex">
							<option value=""></option>
							<c:forEach items="${sexlist}" var="sex" >
								<option value="${sex.attributeName}">${sex.attributeName}</option>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						Email
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input class="INPUT_STYLE2" name="humanEmail" id="humanEmail"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						<input class="INPUT_STYLE2" name="humanTelephone" />
					</td>
					<td class="TD_STYLE1">
						家庭电话
					</td>
					<td class="TD_STYLE2">
					<input class="INPUT_STYLE2" name="humanHomephone" />
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input class="INPUT_STYLE2" name="humanMobilephone" />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input class="INPUT_STYLE2" name="humanAddress" />
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input class="INPUT_STYLE2" name="humanPostcode" />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<select name="humanNationality" class="SELECT_STYLE1">
						<c:forEach items="${countrylist }" var="country">
							<option value="${country.attributeName}">${country.attributeName}</option>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input class="INPUT_STYLE2" name="humanBirthplace" />
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td class="TD_STYLE2" colspan="2">
						<input class="INPUT_STYLE2" id="birthday" name="humanBirthday1"/>
					</td>
					
				</tr>
				<tr>
					<td class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2">
						<select name="humanRace" class="SELECT_STYLE1">
						<c:forEach items="${nationlist }" var="race">
							<option value="${race.attributeName}">${race.attributeName}</option>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<select name="humanReligion" class="SELECT_STYLE1">
						<c:forEach items="${religiouslist }" var="religious">
							<option value="${religious.attributeName}">${religious.attributeName}</option>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2" colspan="2">
						<select name="humanParty" class="SELECT_STYLE1">
						<c:forEach items="${politicallist }" var="political">
							<option value="${political.attributeName}">${political.attributeName}</option>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input class="INPUT_STYLE2" name="humanIdcard"/>
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input class="INPUT_STYLE2" type="number"  name="humanAge"/>
					</td>
					<td class="TD_STYLE1">
						毕业院校
					</td>
					<td class="TD_STYLE2" colspan="1" width="100px">
						<input class="INPUT_STYLE2"  name="humanCollege"/>
						
					</td>
					<td class="TD_STYLE1" width="100px">
						学历
						</td>
					<td class="TD_STYLE2">
						<select name="humanEducatedDegree" class="SELECT_STYLE1">
						<c:forEach items="${educationlist }" var="education">
							<option value="${education.attributeName}">${education.attributeName}</option>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<select name="humanEducatedYears" class="SELECT_STYLE1">
							<c:forEach items="${educationyearslist }" var="educationyears">
								<option value="${educationyears.attributeName}">${educationyears.attributeName}</option>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<select name="humanEducatedMajor" class="SELECT_STYLE1">
							<c:forEach items="${majorlist }" var="major">
								<option value="${major.attributeName}">${major.attributeName}</option>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						薪酬要求
					</td>
					<td class="TD_STYLE2">
						<input class="INPUT_STYLE2"  name="demandSalaryStandard"/>
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					<td class="TD_STYLE2">
						<input class="INPUT_STYLE2" id="datetime" name="registTime1" readonly="readonly" value=""/>
						<script type="text/javascript">
						setInterval("document.getElementById('datetime').value=formatDate(new Date().getTime());", 1000);
						</script>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<select name="humanSpecility" class="SELECT_STYLE1">
							<c:forEach items="${specialitylist }" var="speciality">
								<option value="${speciality.attributeName}">${speciality.attributeName}</option>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<select name="humanHobby" class="SELECT_STYLE1">
							<c:forEach items="${hobbylist }" var="hobby">
								<option value="${hobby.attributeName}">${hobby.attributeName}</option>
							</c:forEach>
						</select>
					</td>
					
				</tr>
				<tr>
					<td class="TD_STYLE1">
						个人履历
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea style="resize:none"	 id="myhistoryrecords" name="recomandation" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea id="myremark" name="remark" rows="4" class="TEXTAREA_STYLE1" style="resize:none" ></textarea>
					</td>
				</tr>
			</table>
			
		</form>
	</body>
	
	
	

	
	
	
<script type="text/javascript">
Calendar.setup ({inputField : "birthday", ifFormat : "%Y-%m-%d", showsTime : false, button : "birthday", singleClick : true, step : 1});
Calendar.setup ({inputField : "date_end", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_end", singleClick : true, step : 1});
</script>
</html>
