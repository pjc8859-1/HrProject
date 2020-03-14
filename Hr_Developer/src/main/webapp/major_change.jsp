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
	<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
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
			
			changelocation($("#select1 option:selected").html());
			
		});
		$("#select2").change(function(){
			
			changelocation1($("#select2 option:selected").html());
			
		});
		$("#select3").change(function(){
					
					//changelocation2($("#select3 option:selected").html());
					
		});
		$("#select4").change(function(){
			
			changelocation2($("#select4 option:selected").html());
			
		});
		
	})
	function show(){
		console.log(secondselect.children());
	}
	function savelist(){
		firstselect = document.getElementById("select1").outerHTML;
		secondselect = document.getElementById("select2").outerHTML;
		thirdselect = document.getElementById("select3").outerHTML;
		fourthselect = document.getElementById("select4").outerHTML;
		fifthselect =document.getElementById("select5").outerHTML;
		alert("savelist执行");
		
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
	//	$("#select3").append("<option value='' selected='true' >&nbsp;</option>");
		
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
		 		console.log("locid"+locid);
		 		console.log( $(thirdselect).children());
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
		 console.log("locid"+locid);
		 	if(locid==""||locid==null){
		 		
		 		//如果选中first为空的值，则secondshow出全部值
		 		showfifth();
		 	} 
		 	else{
		 			
		 		//不是空就去比较第二个集合里面以选择的值开头的项展示出来
		 		var list =``;
		 		console.log("length"+fifthselect);
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
	</script>
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
							<select class="select1" id="select1">
						  
						</select>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						新II级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
							<select class="select1" id="select2">
						  
						</select>	
					</td>
					<td width="12.5%" class="TD_STYLE1" >
						新III级机构
					</td>
					<td width="12.5%" class="TD_STYLE2">
							<select class="select1" id="select3">
						  
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
						<select class="select1" id="select4">
						  
						</select>
					</td>
					<td width="12.5%" class="TD_STYLE1">
						新职位名称
					</td>
					<td width="12.5%" class="TD_STYLE2">
							<select class="select1" id="select5">
						  
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
