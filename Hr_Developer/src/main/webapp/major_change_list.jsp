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
		<script type="text/javascript">
		var firstlist = ${firstlist};//一级机构json数组
		var secondlist = ${secondlist};//二级机构json数组
		var thirdlist = ${thirdlist};//三级机构json数组
		var firstselect = null;
		var secondselect = null;
		var thirdselect = null;
		
		$(function(){
			aaa = 2;
			showfirst();
			showsecond();
			showthird();
			savelist();
			$("#select1").change(function(){
				
				changelocation($("#select1 option:selected").html());
				
			});
			$("#select2").change(function(){
				
				changelocation1($("#select2 option:selected").html());
				
			});
		$("#select3").change(function(){
						
						changelocation2($("#select3 option:selected").html());
						
					});
			
		})
		function show(){
			console.log(secondselect.children());
		}
		function savelist(){
			firstselect = $("#select1");
			second = $("#select2");
			thirdselect = $("#select3");
			
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
		function showthird(thirdneedshow){
			selects= $("select");//得到所有select标签;
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
		function changelocation(locationid)
		{	
		   var locid=locationid;
			 	if(locid==""||locid==null){
			 		//如果选中first为空的值，则secondshow出全部值
			 		showsecond();
			 	} 
			 	else{
			 			
			 		//不是空就去比较第二个集合里面以选择的值开头的项展示出来
			 		var list =``;
			 		for(var j =1 ;j < $(secondselect).children().length; j++)
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
			 		for(var j =1 ;j < $(thirdselect).children().length; j++)
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
		 
		 
		 function changelocation2(select5,locationid)
		  {
		 
		 }
		
 		</script>
 		<script type="text/javascript" src="javascript/comm/list.js"></script>
  </head>
  
  <body>
  
  
  <form name="humanfileForm" method="post" action="aa/bb.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：调动管理 -- 调动登记 -- 合格档案查询
	</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="开始"
							class="BUTTON_STYLE1" onclick="javascript:list();">
						<input type="button" value="搜索"
							class="BUTTON_STYLE1" onclick="search();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择员工所在I级机构
					</td>
					<td width="84%" class="TD_STYLE2">
						<select id="select1" name="item.firstKindName" size="5" class="SELECT_STYLE2">
							
						</select>	
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请选择员工所在II级机构
					</td>
					<td width="84%" class="TD_STYLE2">
						<select id="select2" name="item.secondKindName" size="5" onchange="changelocation1(document.forms[0].elements['item.secondKindName'].options[document.forms[0].elements['item.secondKindName'].selectedIndex].innerHTML)" class="SELECT_STYLE2">
    						
    					</select>
					</td>
				</tr>
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择员工所在III级机构
					</td>
					<td width="84%" class="TD_STYLE2">
						<select id="select3" name="item.thirdKindName" size="5" class="SELECT_STYLE2"><script language="javascript">
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
						<select name="item.humanMajorKindName" size="5" onchange="changelocation2(document.forms[0].elements['item.hunmaMajorName'],document.forms[0].elements['item.humanMajorKindName'].options[document.forms[0].elements['item.humanMajorKindName'].selectedIndex].value)" class="SELECT_STYLE2">
						
								<option value="">&nbsp;</option>
							
								<option value="销售">销售</option>
							
								<option value="软件开发">软件开发</option>
							
								<option value="人力资源">人力资源</option>
							
								<option value="生产部">生产部</option></select>
					</td>
				</tr>
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择职位名称
					</td>
					<td width="84%" class="TD_STYLE2">
						<select name="item.hunmaMajorName" size="5" class="SELECT_STYLE2"><script language="javascript">
							changelocation2(document.forms[0].elements["item.hunmaMajorName"],document.forms[0].elements["item.humanMajorKindName"].value)
							</script></select>
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
<script type="text/javascript" src="javascript/comm/list.js"></script>
