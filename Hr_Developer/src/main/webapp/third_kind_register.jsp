
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
    <td width="81%" class="TD_STYLE2"><select id="firstKindId" name="firstKindId" style="width: 50px" disabled="disabled">
    
    </select></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">I级机构名称</td>
    <td class="TD_STYLE2">
    <select id="firstKindName" name="firstKindName" style="width: 50px"  onchange="firsnameChange(this)">
   
    </select>
    </td>
  </tr>
   <tr>
    <td width="19%" class="TD_STYLE1">II级机构编号</td>
    <td width="81%" class="TD_STYLE2"><select id="secondKindId" name="secondKindId"  style="width: 50px" disabled="disabled" >
    
    </select></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">II级机构名称</td>
    <td class="TD_STYLE2">
    <select id="secondKindName" name="secondKindName" style="width: 50px" onchange="secondnameChange(this)" >
   
    </select>
    </td>
  </tr>
  <tr>
   <td width="19%" class="TD_STYLE1">III级机构编号</td>
    <td width="81%" class="TD_STYLE2"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">III级机构名称</td>
    <td class="TD_STYLE2"><input type="text" name="item.thirdKindName" value="" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">III级机构销售责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）</td>
    <td class="TD_STYLE2"><textarea name="item.thirdKindSaleId" rows="4" class="TEXTAREA_STYLE1"></textarea></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">III级机构是否零售</td>
    <td class="TD_STYLE2"><select name="item.thirdKindIsRetail" >
    <option value="是">是</option>
    <option value="否">否</option>
    </select></td>
  </tr>
</table>
</form>
  </body>
</html>
<<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
<script type="text/javascript">
var firstKindId= document.forms[0].firstKindId;
var firstKindName=document.forms[0].firstKindName;
var secondKindId= document.forms[0].secondKindId;
var secondKindName= document.forms[0].secondKindName;
var list0=${list[0]};
var list1=${list[1]};

var index=0;
$(
function(){

firstKindId.length=list0.length;
firstKindName.length=list0.length;

for(var i=0;i<list0.length;i++){

firstKindId.options[i].text=list0[i].firstKindId;
firstKindId.options[i].value=list0[i].firstKindId;
firstKindName.options[i].text=list0[i].firstKindName;
firstKindName.options[i].value=list0[i].firstKindId;
}



for(var i=0;i<list1.length;i++){
if(list1[i].firstKindId==list0[0].firstKindId){

index++;
}
}

secondKindId.length=index;
secondKindName.length=index;
var j=0;
for(var i=0;i<list1.length;i++){
if(list0[0].firstKindId==list1[i].firstKindId){

secondKindId.options[j].text=list1[i].secondKindId;
secondKindId.options[j].value=list1[i].secondKindId;
secondKindName.options[j].text=list1[i].secondKindName;
secondKindName.options[j].value=list1[i].secondKindId;
j++;
}
}


}
);

function firsnameChange(a){
index=0;
var v=$(a).find("option:selected").val();
console.log(v);
for(var i=0;i<list1.length;i++){
if(v==list1[i].firstKindId){
index++;
}
}
console.log(index)
secondKindId.length=index;
secondKindName.length=index;
var j=0;
for(var i=0;i<list1.length;i++){
if(v==list1[i].firstKindId){

secondKindId.options[j].text=list1[i].secondKindId;
secondKindId.options[j].value=list1[i].secondKindId;
secondKindName.options[j].text=list1[i].secondKindName;
secondKindName.options[j].value=list1[i].secondKindId;
j++;
}
}
index=0;
$("#firstKindId").val(v);


}

function secondnameChange(a){
var options=$(a).find("option:selected").val();
$("#secondKindId").val(options);
}

function doSubmit(){

var secondname=$("#secondKindName").find("option:selected").text();
var firstname= $("#firstKindName").find("option:selected").text();
var firstid=$("#firstKindId").find("option:selected").text();
var secondid=$("#secondKindId").find("option:selected").text();

$("#aa").attr("action","registerThirdSuccess/"+firstname+"/"+secondname+"/"+firstid+"/"+secondid+".do");

$("#aa").submit();
}
</script>
