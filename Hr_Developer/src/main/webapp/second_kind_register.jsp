
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'first_kind_register.jsp' starting page</title>
    
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
  <form id="aa" name="configfilefirstkindForm" method="post" action="">
<table width="100%" >
  <tr>
    <td> 
    <font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--II级机构设置 </font></td>
  </tr>
  <tr>
    <td align="right"><input type="button" value="提交" class="BUTTON_STYLE1" onclick="doSubmit()">
      <input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();">
    </td>
  </tr>
  </table>
  
<table width="100%"  border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
  <tr>
    <td width="19%" class="TD_STYLE1">I级机构编号</td>
    <td width="81%" class="TD_STYLE2"><select id="firstKindId" onchange="idChange(this)" style="width: 50px" >
    <c:forEach items="${secondlist}" var="list" >
    <option value="${list.firstKindId}">${list.firstKindId}</option>
    </c:forEach>
    </select></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">I级机构名称</td>
    <td class="TD_STYLE2">
    <select id="firstKindName" style="width: 50px"  onchange="nameChange(this)">
    <c:forEach items="${secondlist}" var="list1" >
    <option value="${list1.firstKindId}">${list1.firstKindName}</option>
    </c:forEach>
    </select>
    </td>
  </tr>
  <tr>
   <td width="19%" class="TD_STYLE1">II级机构编号</td>
    <td width="81%" class="TD_STYLE2"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">II级机构名称</td>
    <td class="TD_STYLE2"><input type="text" name="item.secondKindName" value="" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">II级机构薪酬发放责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）</td>
    <td class="TD_STYLE2"><textarea name="item.secondKindSalaryId" rows="4" class="TEXTAREA_STYLE1"></textarea></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">II级机构销售责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）</td>
    <td class="TD_STYLE2"><textarea name="item.secondKindSaleId" rows="4" class="TEXTAREA_STYLE1"></textarea></td>
  </tr>
</table>
</form>
  </body>
</html>
<<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
<script type="text/javascript">

var str=$("#firstKindName").val();

function idChange(s){
 var value=$(s).find("option:selected").text();
 $("#firstKindName").val(value);
}

function nameChange(n){
var value=$(n).find("option:selected").val();
$("#firstKindId").val(value);
}

function doSubmit(){

var firstid=$("#firstKindId").find("option:selected").text();
var firstname= $("#firstKindName").find("option:selected").text();
console.log(document.forms[0]);
$("#aa").attr("action","registerSuccess/"+firstid+"/"+firstname+".do");


$("#aa").submit();
}
</script>
