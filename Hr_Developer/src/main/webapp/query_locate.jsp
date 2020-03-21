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
    <title>列出所有状态为“正常”的员工</title>
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
			showfirst();
			showsecond();
			showthird();
			showfourth();
			showfifth();
			
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
		function show(){
			console.log(secondkindselect.children());
		}
		function savelist(){
			firstkindselect = document.getElementById("selectfirst").outerHTML;
			secondkindselect = document.getElementById("selectsecond").outerHTML;
			thirdkindselect = document.getElementById("selectthrid").outerHTML;
			zyflselect = document.getElementById("selectmajorkind").outerHTML;
			zyselect =document.getElementById("selectmajor").outerHTML;
			
		}
		function showfirst(firstneedshow)
		{		
			//得到所有select标签;
			$("#selectfirst").empty();//清空一级机构
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
		function showsecond(secondneedshow){
			$("#selectsecond").empty();//清空二级机构
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
		function showthird(thirdneedshow){
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
		
		function showfourth(fourthneedshow){
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
		
		function showfifth(fifthneedshow){
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
			 		showsecond();
			 		showthird();
			 	} 
			 	else{
			 			
			 		//不是空就去比较第二个集合里面以选择的值开头的项展示出来
			 		var list =``;
			 		for(var j =0;j < $(secondkindselect).children().length; j++)
			 			{	
			 				if($($(secondkindselect).children()).eq(j).html().startsWith(locid)){
			 					//var  txt = $(secondkindselect).children().eq(j).html();
			 					var  txt = ($(secondkindselect).children().eq(j))[0].outerHTML;
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
			 		console.log( $(thirdkindselect).children());
			 		var list =``;
			 		for(var j =0 ;j < $(thirdkindselect).children().length; j++)
			 			{	
			 				if($($(thirdkindselect).children()).eq(j).html().startsWith(locid)){
			 					//var  txt = $(secondkindselect).children().eq(j).html();
			 					var  txt = ($(thirdkindselect).children().eq(j))[0].outerHTML;
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
			 		console.log("length"+zyselect);
			 		for(var j =0 ;j < $(zyselect).children().length; j++)
			 			{	
			 				if($($(zyselect).children()).eq(j).html().startsWith(locid)){
			 					//var  txt = $(secondkindselect).children().eq(j).html();
			 					var  txt = ($(zyselect).children().eq(j))[0].outerHTML;
			 					list+=txt;
			 					}
			 			}
			 		showfifth(list);
			 		}
			 	
		 }
		 
 		</script>
  </head>
  
  <body>
  
  
  <form  id="myform" name="humanfileForm" method="get" action="hr/formquerry.do">
			<table width="100%">
				<tr> 
					<td>
						<font color="#0000CC">您正在做的业务是：调动管理 -- 调动登记 -- 合格档案查询
	</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="查询"
							class="BUTTON_STYLE1" onclick="lista()">
						<input type="button" value="搜索"
							class="BUTTON_STYLE1" onclick="javascript:search();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1" >
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择员工所在I级机构
					</td>
					<td width="84%" class="TD_STYLE2">
						<select id="selectfirst" name="item.firstKindId" size="5" class="SELECT_STYLE2">
							
						</select>	
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请选择员工所在II级机构
					</td>
					<td width="84%" class="TD_STYLE2">
						<select id="selectsecond" name="item.secondKindId" size="5" onchange="changelocation1(document.forms[0].elements['item.secondKindName'].options[document.forms[0].elements['item.secondKindName'].selectedIndex].innerHTML)" class="SELECT_STYLE2">
    						
    					</select>
					</td>
				</tr>
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择员工所在III级机构
					</td>
					<td width="84%" class="TD_STYLE2">
						<select id="selectthrid" name="item.thirdKindId" size="5" class="SELECT_STYLE2"><script language="javascript">
							changelocation1(document.forms[0].elements["item.secondKindName"].innerHTML)
							</script>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请选择职位分类
					</td>
					<td width="84%" class="TD_STYLE2">
						<select id="selectmajorkind" name="item.humanMajorKindName" size="5"  class="SELECT_STYLE2">
						
					</td>
				</tr>
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择职位名称
					</td>
					<td width="84%" class="TD_STYLE2">
						<select id="selectmajor" name="item.hunmaMajorName" size="5" class="SELECT_STYLE2">
								
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请输入建档时间
					</td>
					<td width="84%" class="TD_STYLE2">
						<input type="text" name="item.str_startTime" value="" style="width:14% " class="INPUT_STYLE2" id="date_start">至<input type="text" name="item.str_endTime" value="" style="width:14% " class="INPUT_STYLE2" id="date_end">
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


