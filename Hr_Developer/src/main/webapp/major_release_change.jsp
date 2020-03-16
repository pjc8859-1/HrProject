<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<!-- major_release_input.jsp -->
	<!-- 职位发布信息的输入,填写表单 -->
  <head>
   <base href="<%=basePath%>">
    
    <title>My JSP 'major_release_input.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
	<link rel="stylesheet" href="table.css" type="text/css">
	<style type="text/css">
		.select1{
			width:100%;
			heigth:100%;
		}
	</style>
	<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="javascript/calendar/cal.js"></script>
	<script type="text/javascript" src="javascript/comm/comm.js"></script>
	<script type="text/javascript">
	var firstlist = ${firstlist};//一级机构json数组
	var secondlist = ${secondlist};//二级机构json数组
	var thirdlist = ${thirdlist};//三级机构json数组
	var fourthlist = ${fourthlist};//职业分类
	var fifthlist = ${fifthlist};//职业
	var firstselect = null;
	var secondselect = null;
	var thirdselect = null;
	var fourthselect = null;
	var fifthselect = null;
	
	$(function(){
		aaa = 2;
		showfirst();
		showsecond();
		showthird();
		showfourth();
		showfifth();
		
		savelist();
		$("#select1").change(function(){
			var  changetagouterhtml= getlastletter( $("#select1 option:selected").html());
			var  changetaghtml= $($("#select1 option:selected")[0]).val();
			//修改hidden输入框的值
			$("#newFirstKindId").val(changetaghtml);
			$("#newFirstKindName").val(changetagouterhtml);
			changelocation(changetaghtml);
			
			
			
		});
		$("#select2").change(function(){
			var changetagouterhtml =getlastletter(  $("#select2 option:selected").html());
			var changetaghtml = $($("#select2 option:selected")[0]).val();
			//修改hidden输入框的值
			$("#newSecondKindId").val(changetaghtml);
			$("#newSecondKindName").val(changetagouterhtml);
			changelocation1($("#select2 option:selected").html());
			
		});
		$("#select3").change(function(){
			var  changetagouterhtml= getlastletter( $("#select3 option:selected").html());
			var changetaghtml = $($("#select3 option:selected")[0]).val();
			//修改hidden输入框的值
			
			$("#newThirdKindId").val(changetaghtml);
			$("#newThirdKindName").val(changetagouterhtml);
					//changelocation2($("#select3 option:selected").html());
					
		});
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
	function getlastletter(word){
		var index = word .lastIndexOf("\/");  
		word  = word .substring(index + 1, word .length);
		return word;
	}
	function show(){
		console.log(secondselect.children());
	}
	function savelist(){
		firstselect = document.getElementById("select1").outerHTML;
		secondselect = document.getElementById("select2").outerHTML;
		thirdselect = document.getElementById("select3").outerHTML;
		fourthselect = document.getElementById("select4").outerHTML;
		fifthselect =document.getElementById("select5").outerHTML;
		
	}
	function showfirst(firstneedshow)
	{		
		//得到所有select标签;
		$("#select1").empty();//清空一级机构
		$("#select1").append("<option value=''  selected='true'></option>");//添加一个空的选项
		if(firstneedshow ==null || firstneedshow =="")
		{
			//如果没有传值,就显示全部
			for(var i=0; i< firstlist.length ;i++)
				{	
					var id = firstlist[i].firstKindId;
					var name = firstlist[i].firstKindName;
					
					$("#select1").append("<option value="+id+">"+name+"</option>");
				}
		}
	}
	function showsecond(secondneedshow){
		$("#select2").empty();//清空二级机构
		$("#select2").append("<option value='' selected='true'"+"></option>");
		if(secondneedshow == null || secondneedshow =="")
			{
				
				for(var i=0; i< secondlist.length ;i++)
				{	
					var fid = secondlist[i].firstKindId;
					var fname = secondlist[i].firstKindName;
					var sid = secondlist[i].secondKindId;
					var sname = secondlist[i].secondKindName;
					
					$("#select2").append("<option value="+sid+">"+fname+"/"+sname+"</option>");
				}
			}else
				{
					//传了值
					
					$("#select2").append(secondneedshow);
				}
		
	}
	function lista(){
		var myform = document.getElementById("myform");
		myform.submit();
	}
	function showthird(thirdneedshow){
		$("#select3").empty();//清空三级机构
		$("#select3").append("<option value='' selected='true' >&nbsp;</option>");
		
		if(thirdneedshow == null || thirdneedshow =="")
		{
			
			for(var i=0; i< thirdlist.length ;i++)
			{	
				var fid = thirdlist[i].firstKindId;
				var fname = thirdlist[i].firstKindName;
				var sid = thirdlist[i].secondKindId;
				var sname = thirdlist[i].secondKindName;
				var tid = thirdlist[i].thirdKindId;
				var tname = thirdlist[i].thirdKindName;
				
				$("#select3").append("<option value="+tid+">"+fname+"/"+sname+"/"+tname+"</option>");
			}
		}
		else{
			$("#select3").append(thirdneedshow);
		}
		
		
		
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
	function changelocation(locationid)
	{	
	   var locid=locationid;
		 	if(locid==""||locid==null){
		 		//如果选中first为空的值，则secondshow出全部值
		 		showsecond();
		 		showthird();
		 	} 
		 	else{
		 			
		 		//不是空就去比较第二个集合里面以选择的值开头的项展示出来
		 		var list =``;
		 		for(var j =0;j < $(secondselect).children().length; j++)
		 			{	
		 				if($($(secondselect).children()).eq(j).html().startsWith(locid)){
		 					//var  txt = $(secondselect).children().eq(j).html();
		 					var  txt = ($(secondselect).children().eq(j))[0].outerHTML;
		 					list+=txt;
		 					}
		 			}
		 		showsecond(list);
		 		}
	}	
	 function changelocation1(locationid)
	  {
		 var locid=locationid;
		 	if(locid==""||locid==null){
		 		//如果选中first为空的值，则secondshow出全部值
		 		showthird();
		 	} 
		 	else{
		 			
		 		//不是空就去比较第二个集合里面以选择的值开头的项展示出来
		 		var list =``;
		 		for(var j =0 ;j < $(thirdselect).children().length; j++)
		 			{	
		 				if($($(thirdselect).children()).eq(j).html().startsWith(locid)){
		 					//var  txt = $(secondselect).children().eq(j).html();
		 					var  txt = ($(thirdselect).children().eq(j))[0].outerHTML;
		 					list+=txt;
		 					}
		 			}
		 		showthird(list);
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
		 
		 //提交之前处理时间格式
		 
		 
		//var thisTime = $("#datetime").val();
		//thisTime = thisTime.replace(/-/g, '/');
		//var time = new Date(thisTime);
		//time = time.getTime();
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
	  return YY + MM + DD + " " + hh + mm+ss;
	}
 		</script>
  </head>
  
 <body>
  	<form method="post" action="recruitment/submitmajorrelease.do" id="mainform">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源 -- 招聘管理 -- 职位发布管理 --职位发布登记
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1"
							onclick="dosubmit()" />
						<input type="reset" value="清除" class="BUTTON_STYLE1">
					</td>
				</tr>
			</table>
			
			
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				
				
				<!-- 3 -->
				<tr>
					<td width="12.5%" class="TD_STYLE1">
						I级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
							<input  id="newFirstKindId" type="hidden" name="firstKindId" value=""/>
							<input id="newFirstKindName" type="hidden" name="firstKindName" value=""/>
							<select class="select1" id="select1" >
						  	
						</select>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
					<input  id="newSecondKindId" type="hidden" name="secondKindId" value=""/>
					<input id="newSecondKindName" type="hidden" name="secondKindName" value=""/>
							<select class="select1" id="select2">
						  
						</select>	
					</td>
					<td width="12.5%" class="TD_STYLE1" >
						III级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
					<input  id="newThirdKindId" type="hidden" name="thirdKindId" value=""/>
					<input id="newThirdKindName" type="hidden" name="thirdKindName" value=""/>
							<select class="select1" id="select3">
						  
						</select>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						招聘类型
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<select  class="select1"  name="engageType">
							<option value=""></option>
							<c:forEach items="${charlist}" var="cha" >
								<option value="${cha.attributeName}">${cha.attributeName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
	<!-- ================================================================================ -->			
				<!-- 4 -->
				<tr>
					<td width="12.5%" class="TD_STYLE1">
					
					职位分类
				</td>
					<td width="12.5%" class="TD_STYLE2">
					<input  id="newMajorKindId" type="hidden" name="majorKindId" value=""/>
					<input id="newMajorKindName" type="hidden" name="majorKindName" value=""/>
						<select class="select1" id="select4">
						  
						</select>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="12.5%" class="TD_STYLE2">
					<input  id="newMajorId" type="hidden" name="majorId" value=""/>
					<input  id="newMajorName" type="hidden" name="majorName" value=""/>
						<select class="select1" id="select5">
						  
						</select>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						招聘人数
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<input type="number" name="humanAmount" class="select1"/>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						截止日期
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<input type="text" name="deadline1" value="" style="width:100% " class="INPUT_STYLE2 " id="deadline">
					</td>
				</tr>
				
				<!-- 5 -->
				<tr>
					<td width="12.5%" class="TD_STYLE1">
						登记人
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<input class="select1" name="register" />
					</td>
					<td width="12.5%" class="TD_STYLE1">
						登记时间
					</td>
					<td width="12.5%" class="TD_STYLE2">
						<input id="datetime" type="text" class="select1" name="registTime1" value="" readonly="readonly"/>
    					<script>
        				setInterval("document.getElementById('datetime').value=formatDate(new Date().getTime());", 1000);
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
						职位描述
					</td>
					<td width="87.5%"  height="100" class="TD_STYLE2" colspan="7">
						<textarea  style="width:100%;height:100%;resize:none" name="majorDescribe" autoHeight="true"></textarea>
					</td>
				</tr>
				<tr>
					<td width="12.5%" height="100" class="TD_STYLE1" >
						招聘要求
					</td>
					<td width="87.5%"  height="100" class="TD_STYLE2" colspan="7">
						<textarea  style="width:100%;height:100%;resize:none" name="engageRequired" autoHeight="true"></textarea>
					</td>
				</tr>
				
			</table>
		</form>
  	<script type="text/javascript">
	Calendar.setup ({inputField : "deadline", ifFormat : "%Y-%m-%d", showsTime : false, button : "deadline", singleClick : true, step : 1});
	</script>
  </body>
  	
  </body>
</html>
