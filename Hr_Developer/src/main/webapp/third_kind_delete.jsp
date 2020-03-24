<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'first_kind_change.jsp' starting page</title>
    
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
<script type="text/javascript" src="javascript/comm/comm.js"></script>
  </head>
  
  <body>
  	<form name="configfilefirstkindForm" method="post" action="thirdkinddelectsuccess">
<table width="100%" >
  <tr>
    <td> 
    <font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--III级机构设置 </font></td>
  </tr>
  <tr>
    <td align="right"><input type="button" value="删除" class="BUTTON_STYLE1" onclick="toChange()">
      <input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();"></td>
  </tr>
  </table>
  
<table width="100%"  border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
 <!--  
  <tr>
    <td width="19%" class="TD_STYLE1">I级机构编号</td>
    <td width="81%" class="TD_STYLE2"><input type="text" name="item.firstKindId" value="01" readonly="readonly" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">I级机构名称</td>
    <td class="TD_STYLE2"><input type="text" name="item.firstKindName" value="集团" readonly="readonly" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">薪酬发放责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）</td>
    <td class="TD_STYLE2"><textarea name="item.firstKindSalaryId" rows="4" class="TEXTAREA_STYLE1">1</textarea></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">销售责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）</td>
    <td class="TD_STYLE2"><textarea name="item.firstKindSaleId" rows="4" class="TEXTAREA_STYLE1">1</textarea></td>
  </tr>
  -->
</table>
</form>
  </body>
  <% request.setAttribute("id", request.getParameter("id")); %>
</html>
<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
<script type="text/javascript">


var id=${id};
console.log(id);
$(
    function(){
    $.ajax({
					type:"post",
					url:"changethirdkind.do",
				   	dataType:"json",
					contentType:"application/html;charset=utf-8",
					data:""+id,
					success:function(result){
					console.log(result);
					var str=`
					               <tr>
    <td width="19%" class="TD_STYLE1">I级机构编号</td>
    <td width="81%" class="TD_STYLE2"><input type="text" name="item.firstKindId" value="\${result.firstKindId}" readonly="readonly" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">I级机构名称</td>
    <td class="TD_STYLE2"><input type="text" name="item.firstKindName" value="\${result.firstKindName}" readonly="readonly" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">II级机构编号</td>
    <td class="TD_STYLE2"><input type="text" name="item.secondKindId" value="\${result.secondKindId}" readonly="readonly" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">II级机构名称</td>
    <td class="TD_STYLE2"><input type="text" name="item.secondKindName" value="\${result.secondKindName}" readonly="readonly" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">III级机构编号</td>
    <td class="TD_STYLE2"><input type="text" name="item.thirdKindId" value="\${result.thirdKindId}" readonly="readonly" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">III级机构名称</td>
    <td class="TD_STYLE2"><input type="text" name="item.thirdKindName" value="\${result.thirdKindName}" readonly="readonly" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">销售责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）</td>
    <td class="TD_STYLE2"><textarea name="item.thirdKindSaleId" rows="4"  class="TEXTAREA_STYLE1" readonly="readonly">\${result.thirdKindSaleId}</textarea></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">是否零售</td>
    <td class="TD_STYLE2"><select name="item.thirdKindIsRetail" width="50px" id="thirdretail" disabled="disabled">
     <option value="是">是</option>
    <option value="否">否</option>
    </select></td>
  </tr>
					`;
					$(".TABLE_STYLE1").append(str);
					$("#thirdretail").val(result.thirdKindIsRetail);
					
					
					}
					
				});
    }
    
     
)

function toChange(){

document.forms[0].action = document.forms[0].action+"/"+id+".do";
document.forms[0].submit();
}

</script>