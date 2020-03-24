<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'salarystandard_check_list.jsp' starting page</title>
    
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
		<title>无标题文档</title>
		<style type="text/css">
<!--
.style3 {color: #0000CC}
-->
</style>
<script type="text/javascript">
	function submit(){
		document.forms[0].submit();
	}
</script>

  </head>
  
  <body>
  <form method="post" action="grantCheckSubmit.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是:薪酬发放管理--薪酬发放登记复核</font>
					</td>	
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1"
							onclick="submit()">
						<input type="button" value="返回" class="BUTTON_STYLE1"
							>
					</td>
				</tr>
				
				<tr>
					<td>
						薪酬单编号:${sid}<br>
						<input type="hidden" name="sid" value="${sid }" />
						机构：<c:if test="${sg.firstKindId != null}"><span>${sg.firstKindName }</span></c:if>
							  <c:if test="${sg.secondKindId != null}"><span>/${sg.secondKindName }</span></c:if>
						薪酬次数：，总人数：${sg.humanAmount }，基本薪酬总额：${sg.salaryStandardSum }，实发总额：
						<input type="hidden" name="salarygrant" value="${sg }"/>
						<input type="hidden" id="count" value="${sg.humanAmount }"/>
						<span id="salarySum_sum">${summap.salarypall }</span>
							</td>
						<td align="right">复核人：<input type="text" name="checker" value="admin" style="width:80px;background-color:#D4F8D4;">复核时间：
							<span id="datetime">
    						<script>
        					setInterval("document.getElementById('datetime').innerHTML=new Date().toLocaleString();", 1000);
   							</script>
							</span>
						</td>
				
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="9%" class="TD_STYLE1">
						<span>薪酬发放细节编号</span>
					</td>
					<td width="9%" class="TD_STYLE1">
						<span>档案编号</span>
					</td>
					<td width="9%" class="TD_STYLE1">
						<span>姓名</span>
					</td>
					<td width="9%" class="TD_STYLE1">
						<span>	出差补助</span>
					</td>
					<td width="8%" class="TD_STYLE1">
						交通补贴
					</td>
					<td width="7%" class="TD_STYLE1">
							住房补贴
					</td>
					<td width="7%" class="TD_STYLE1">
							基本工资
					</td>
					<td width="7%" class="TD_STYLE1">
							年终奖
					</td>
					<td width="7%" class="TD_STYLE1">
							误餐补助
					</td>
					<td width="7%" class="TD_STYLE1">
						奖励金额
					</td>
					<td width="7%" class="TD_STYLE1">
						销售绩效金额
					</td>
					<td width="7%" class="TD_STYLE1">
						应扣金额
					</td>
					<td width="7%" class="TD_STYLE1">
						支付总额
					</td>
				</tr>
				
				 <c:forEach items="${sgdlist}" var="s" varStatus="vs">
				  <input type="hidden" name="grantDetails[${vs.index }].salaryGrantId" value="${s.humanId }">
				 	<input type="hidden" id="salaryStandardSum${vs.count }" name="grantDetails[${vs.index }].salaryStandardSum" value="${s.salaryStandardSum }"/>
				 	<tr class="TD_STYLE2">
					
						<td>
							${s.grdId }
						</td>
						<td>
							${s.humanId }
							<input type="hidden" name="humanId" value="${s.humanId }" />				
						</td>
						<td>
							${s.humanName }
							<input type="hidden" name="humanName" value="${s.humanName }" />
						</td>
						<c:forEach items="${salist}" var="sa">
						<td> 							
							${sa.money}
						</td>
						 	</c:forEach>	
						
										
						<td>
							<input type="text" name="bounsSum"  id="bounsSum${vs.count }"  onkeyup="onKeyPress('${vs.count}')" value="${s.bounsSum }" class="INPUT_STYLE2" />
						</td>
						<td>
							<input type="text" name="saleSum"   id="saleSum${vs.count }"  onkeyup="onKeyPress('${vs.count }')" value="${s.saleSum }" class="INPUT_STYLE2"/>
						</td>
						<td>
							<input type="text" name="deductSum"   id="deductSum${vs.count }" onkeyup="onKeyPress('${vs.count }')" value="${s.deductSum }" class="INPUT_STYLE2"/>
						</td>
						<td>
							<input type="text" name="salaryPaidSum" readonly="readonly"  id="salaryPaidSum${vs.count }" value="${s.salaryPaidSum } "/>
						</td>
					</tr>	
					</c:forEach>
				
			</table>
		</form>
  <script type="text/javascript">
function onKeyPress(i){
		var count = document.getElementById("count"); 
		var bounsSum=document.getElementById("bounsSum"+i);
		var saleSum =document.getElementById("saleSum"+i);
		var deductSum=document.getElementById("deductSum"+i);
		var salaryPaidSum=document.getElementById("salaryPaidSum"+i);
		if (isNaN(bounsSum.value) || bounsSum.value < 0) {
			alert("金额填写错误!");
		bounsSum.value="0.00";
		return;
	} 
		if (isNaN(saleSum.value) || saleSum.value < 0) {
			alert("金额填写错误!");
		saleSum.value="0.00";
		return;
	} 
		if (isNaN(deductSum.value) || deductSum.value < 0) {
			alert("金额填写错误!");
		deductSum.value="0.00";
		return;
	} 
		salaryPaidSum.value=Number(bounsSum.value)+Number(saleSum.value)-
		Number(deductSum.value)+Number(document.getElementById("salaryStandardSum"+i).value);
		
		var sum=0;
		for(var j=1;j<=count.value;j++){
			sum=Number(sum)+Number(document.getElementById("salaryPaidSum"+j).value);
		}
	 		 document.getElementById("salarySum_sum").innerHTML=sum;
}
		
		</script>
  </body>
</html>
