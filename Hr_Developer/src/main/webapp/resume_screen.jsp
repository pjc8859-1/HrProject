<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<!-- major_change_list.jsp -->
  <head>
    <base href="<%=basePath%>">
    <title>resume_screen.jsp 简历筛选主页</title>
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
		<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" src="javascript/comm/list.js"></script>
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
	 
	 
	 
	 function dosubmit(){
		 //校验是否为空
		/* if($("#newMajorKindName").val() == null || $("#newMajorKindName").val() == "")
			 {
			 	alert("职位分类不能为空");
			 	return;
			 }
		 if($("#newMajorName").val() == null || $("#newMajorName").val() == "")
		 {
		 	alert("职位不能为空");
		 	return;
		 }
		 */
		var myform = document.getElementById("myform");
		myform.submit();
		 
	 }
		</script>
  </head>
  
  <body>
  
  
  <form  id="myform" name="humanfileForm" method="get" action="resumemanage/submitresumescreen.do">
			<table width="100%">
				<tr> 
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源 -- 招聘管理 -- 简历管理 --简历筛选
	</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交"
							class="BUTTON_STYLE1" onclick="dosubmit()">
						<input type="button" value="清空"
							class="BUTTON_STYLE1" onclick="javascript:search();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1" >
				 
				<tr>
					<td class="TD_STYLE1">
						请选择职位分类
					</td>
					<td width="84%" class="TD_STYLE2">
						<input id="newMajorKindName" type="hidden" name="MajorKindName" value=""/>
						<select  class="SELECT_STYLE1" id="select4" size="5">
							
						</select>   
					</td>
				</tr>
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择职位名称
					</td>
					<td width="84%" class="TD_STYLE2">
						<input  id="newMajorName" type="hidden" name="MajorName" value=""/>
						<select class="SELECT_STYLE1" id="select5" size="7">
						  
						</select>
					</td>
				</tr>
				
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择关键字
					</td>
					<td width="10%" class="TD_STYLE2">
					<div style="width:30%;">
					<!--
					&#9;<input  type="checkbox" name="key" value="humanMajorKindName">职位类型</input>
					&#9;<input  type="checkbox" name="key" value="humanMajorName">职位</input>
					-->
					<label>&#9;<input  type="checkbox" name="key" value="humanTelephone">电话</input></label>
					<label>&#9;<input  type="checkbox" name="key" value="humanName">姓名</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanHomephone">家庭电话</input></label>
				<label>&#9;<input  type="checkbox" name="key" value="humanMobilephone">移动电话</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanEmail">邮箱</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanHobby">爱好</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanSpecility">特长</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanSex">性别</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanReligion">宗教</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanParty">政治面貌</input> </label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanNationality">国籍</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanRace">民族</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanBirthday">生日</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanAge">年龄</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanEducatedDegree">学历</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanEducatedYears">教育年限</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanEducatedMajor"> 学历专业</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanCollege">院校</input> </label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanIdcard">身份证</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="humanBirthplace">出生地</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="demandSalaryStandard">薪酬要求</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="remark">备注</input></label>
				<label>	&#9;<input  type="checkbox" name="key" value="recomandation">履历</input></label>
					</div>
						

					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请输入关键字
					</td>
					<td width="84%" class="TD_STYLE2">
						<input class="INPUT_STYLE2"  name="keywords"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请输入登记时间
					</td>
					<td width="84%" class="TD_STYLE2">
						<input type="text" name="starttime" value="" style="width:14% " class="INPUT_STYLE2" id="date_start">至<input type="text" name="endtime" value="" style="width:14% " class="INPUT_STYLE2" id="date_end">
						（YYYY-MM-DD）
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script type="text/javascript">
	Calendar.setup ({inputField : "date_start", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_start", singleClick : true, step : 1});
	Calendar.setup ({inputField : "date_end", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_end", singleClick : true, step : 1});
	</script>
</html>

