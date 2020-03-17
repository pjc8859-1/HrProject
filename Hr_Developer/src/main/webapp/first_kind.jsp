<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'first_kind.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="table.css" type="text/css">
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
  </head>
  
  <body>
  	<form method="post" action="configfilefirstkind.do">
			<table width="100%">
				<tr >
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--I级机构设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加" class="BUTTON_STYLE1"
							onclick="window.location.href='first_kind_register.jsp'" />
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				
				<tr id="show">
					<td width="20%" class="TD_STYLE1">
						I级机构编号
					</td>
					<td width="20%" class="TD_STYLE1">
						I级机构名称
					</td>
					<td width="25%" class="TD_STYLE1">
						薪酬发放责任人编号
					</td>
					<td width="25%" class="TD_STYLE1">
						销售责任人编号
					</td>
					<td width="5%" class="TD_STYLE1">
						变更
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>
			   <!-- 
					<tr>
						<td class="TD_STYLE2">
							01
						</td>
						<td class="TD_STYLE2">
							集团
						</td>
						<td class="TD_STYLE2">
							1
						</td>
						<td class="TD_STYLE2">
							1
						</td>
						<td class="TD_STYLE2">
							<a href="first_kind_change.jsp">变更</a>
						</td>
						<td class="TD_STYLE2">
							<a href="first_kind_delete.jsp">删除</a>
						</td>
					</tr>
					
					 -->
					
				
			</table>
			<!-- 
			<p>&nbsp;&nbsp;总数：1例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type="button"  width=18 height=18 value="跳转"/>
		 -->
		</form>
  </body>
</html>
<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
<script type="text/javascript" >
var str;
var value;
var index=1;
var no=1;
$(
    function(){
    $.ajax({
					type:"post",
					url:"configfirstkind/showconfigfirstkind.do",
					//contentType:"application/json;charset=utf-8",
					dataType:"json",
					success:function(result){
					if(result.length>0){
					value=result;
					no=Math.ceil(result.length/5);
					
						for(var i=0;i<(index==no?result.length:5);i++){
						str="<tr data=\""+result[i].ffkId+"\"><td class=\"TD_STYLE2\">"+result[i].firstKindId+"</td><td class=\"TD_STYLE2\">"+result[i].firstKindName+"</td>"
						+"<td class=\"TD_STYLE2\">"+result[i].firstKindSalaryId+"</td><td class=\"TD_STYLE2\">"+result[i].firstKindSaleId+"</td>"
						+"<td class=\"TD_STYLE2\"><a href=\"first_kind_change.jsp?id="+result[i].ffkId+"\">变更</a>	</td><td class=\"TD_STYLE2\"><a href=\"first_kind_delete.jsp?id="+result[i].ffkId+"\">删除</a></td></tr>";
					
					     $(".TABLE_STYLE1").append($(str));
						}	
						var str1="<p>&nbsp;&nbsp;总数："+result.length+"例 &nbsp;&nbsp;&nbsp;当前第<span id=\"np\"> "+index+"</span> 页  &nbsp;&nbsp;&nbsp;共 "+no+" 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=\"button\" width=18 height=18 value=\"跳转\" onclick=\"goPage(this)\"/>"
					  $(".TABLE_STYLE1").after($(str1));
					  }
					
					}
					
				});
    }
    
     
);

function goPage(a){
var page= $("input[name='page']").val() ;
var r = /^\+?[1-9][0-9]*$/;//判断是否为正整数 
  if( r.test(page)&&0<parseInt(page)&&parseInt(page)<=no){
  index=parseInt(page);
  $("#show").siblings().each(function(){
    $(this).remove();
 });

 
      for(var i=(index-1)*5;i<(index==no?value.length:5*index);i++){
      
						str="<tr ><td class=\"TD_STYLE2\">"+value[i].firstKindId+"</td><td class=\"TD_STYLE2\">"+value[i].firstKindName+"</td>"
						+"<td class=\"TD_STYLE2\">"+value[i].firstKindSalaryId+"</td><td class=\"TD_STYLE2\">"+value[i].firstKindSaleId+"</td>"
						+"<td class=\"TD_STYLE2\"><a href=\"first_kind_change.jsp?id="+value[i].ffkId+"\">变更</a>	</td>"
						+"<td class=\"TD_STYLE2\">	<a href=\"first_kind_delete.jsp?id="+value[i].ffkId+"\">删除</a></td></tr>";
					     $(".TABLE_STYLE1").append($(str));
						}
					$("#np").html(index);	
  }else{
  alert("页数输入错误");
  }
   

};


</script>



