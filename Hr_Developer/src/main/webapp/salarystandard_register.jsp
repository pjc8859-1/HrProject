<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'salarystandard_register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="table.css" type="text/css" />
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
		<title>无标题文档</title>
		<script type="text/javascript">
			function tijiao(){
				if(document.getElementById("standardId").value==""){
					alert("薪酬编号不能为空！");
					return ;
				}
				if(document.getElementById("standardName").value==""){
					alert("薪酬名称不能为空！");
					return ;
				}
				if(document.getElementById("designer").value==""){
					alert("制定人不能为空！");
					return ;
				}
				for(var i=1;i<=6;i++){
			 		var salary=document.getElementById("salary"+i).value;
			 		if(salary==""){
			 			document.getElementById("salary"+i).value=0.0;
			 		}
				}
				document.forms[0].submit();
			}
			
			function countMoney() {
				var sum=0;
			 	for(var i=1;i<=6;i++){
			 		var salary=document.getElementById("salary"+i).value;
			 		if(salary==""){
			 		salary="0.00";
			 		}
			 		sum=Number(sum)+Number(salary);
			 		 
			 }
			 document.getElementById("sumSalary").value=sum;
			}
				
		</script>
		
		
  </head>
  
  <body>
  <form name="salarystandardForm" method="post" action="hr/salarystandard.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--薪酬标准管理--薪酬标准登记
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" onclick="tijiao()" class="BUTTON_STYLE1">
						<input type="reset" value="清除" class="BUTTON_STYLE1" >
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="74" class="TD_STYLE1">
						薪酬标准编号
					</td>
					<td width="168" class="TD_STYLE2">
						<input type="text" name="item.standardId" class="INPUT_STYLE2" id="standardId">
					</td>
					<td width="83" class="TD_STYLE1">
						薪酬标准名称
					</td>
					<td width="171" class="TD_STYLE2">
						<input type="text" name="item.standardName" value="" class="INPUT_STYLE2" id="standardName">
					</td>
					<td width="170" class="TD_STYLE1">
						薪酬总额
					</td>
					<td width="138" class="TD_STYLE2">
						<input type="text" name="item.salaryCount"  id="sumSalary"  readonly="readonly" value="" class="INPUT_STYLE2">
					</td>
					<td width="103" class="TD_STYLE1">
						&nbsp;
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						制定人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.designer" value="" class="INPUT_STYLE2" id="designer">
					</td>
					<td class="TD_STYLE1">
						登记人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.register" value="better_wanghao" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					<td class="TD_STYLE2">
						<!-- <input type="text" value="" class="INPUT_STYLE2">  -->
						<div id="datetime">
    					<script>
        				setInterval("document.getElementById('datetime').innerHTML=new Date().toLocaleString();", 1000);
   						</script>
</div>

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
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="item.remark" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr class="TD_STYLE1">
					<td align="center">
						序号
					</td>
					<td colspan="3">
						薪酬项目名称
					</td>
					<td>
						金额
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				
				<tr class="TD_STYLE2">
					<td align="center">
						1
						<input type="hidden" name="list[0].itemId" value="1">
					</td>
					<td colspan="3">
						出差补助
						<input type="hidden" name="list[0].itemName" value="出差补助"> 
					</td>
					<td>
						<input type="text" name="list[0].salary" value="0.0" class="INPUT_STYLE2" id="salary1" 
						onkeyup="if(/^\d+(\.)?(\d+)?$/.test(this.value)==false){alert('请输入数字！');this.value='';}countMoney()">
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				
				<tr class="TD_STYLE2">
					<td align="center">
						2
						<input type="hidden" name="list[1].itemId" value="2">
					</td>
					<td colspan="3">
						交通补贴
						<input type="hidden" name="list[1].itemName" value="交通补贴">
					</td>
					<td>
						<input type="text" name="list[1].salary" value="0.0" class="INPUT_STYLE2" id="salary2"
						onkeyup="if(/^\d+(\.)?(\d+)?$/.test(this.value)==false){alert('请输入数字！');this.value='';}countMoney()">
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				
				<tr class="TD_STYLE2">
					<td align="center">
						3
						<input type="hidden" name="list[2].itemId" value="3">
					</td>
					<td colspan="3">
						住房补贴
						<input type="hidden" name="list[2].itemName" value="住房补贴">
					</td>
					<td>
						<input type="text" name="list[2].salary" value="0.0" class="INPUT_STYLE2" id="salary3"
						onkeyup="if(/^\d+(\.)?(\d+)?$/.test(this.value)==false){alert('请输入数字！');this.value='';}countMoney()">
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				
				<tr class="TD_STYLE2">
					<td align="center">
						4
						<input type="hidden" name="list[3].itemId" value="4">
					</td>
					<td colspan="3">
						基本工资
						<input type="hidden" name="list[3].itemName" value="基本工资">
					</td>
					<td>
						<input type="text" name="list[3].salary" value="0.0" class="INPUT_STYLE2" id="salary4"
						onkeyup="if(/^\d+(\.)?(\d+)?$/.test(this.value)==false){alert('请输入数字！');this.value='';}countMoney()">
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				
				<tr class="TD_STYLE2">
					<td align="center">
						5
						<input type="hidden" name="list[4].itemId" value="5">
					</td>
					<td colspan="3">
						年终奖
						<input type="hidden" name="list[4].itemName" value="年终奖">
					</td>
					<td>
						<input type="text" name="list[4].salary" value="0.0" class="INPUT_STYLE2" id="salary5"
						onkeyup="if(/^\d+(\.)?(\d+)?$/.test(this.value)==false){alert('请输入数字！');this.value='';}countMoney()">
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				
				<tr class="TD_STYLE2">
					<td align="center">
						6
						<input type="hidden" name="list[5].itemId" value="6">
					</td>
					<td colspan="3">
						误餐补助
						<input type="hidden" name="list[5].itemName" value="误餐补助">
					</td>
					<td>
						<input type="text" name="list[5].salary" value="0.0" class="INPUT_STYLE2" id="salary6"
						onkeyup="if(/^\d+(\.)?(\d+)?$/.test(this.value)==false){alert('请输入数字！');this.value='';}countMoney()">
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				
			</table>
			<p>
				&nbsp;
			</p>
		</form>
  </body>
</html>
