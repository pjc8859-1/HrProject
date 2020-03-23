<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript"
			src="../javascript/jquery-1.7.2.js">
		</script>
		<link rel="stylesheet" href="table.css" type="text/css" />
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
		<title>无标题文档</title>
		<STYLE type="text/css">
		td{text-align: center}
		</STYLE>
	</head>

	<body>
		 
			<table width="100%">
				<tr>
					<td colspan="2" style="text-align: left">
						<font color="black">您正在做的业务是：薪酬发放管理--薪酬发放查询
						</font>
						 
					</td>
				</tr>
				 
			</table>
					<br> 
					符合条件的薪酬标准总数:${count}例
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				
				<tr>
					<td width="10%" class="TD_STYLE1">
						<span>薪酬发放编号</span>
					</td>			
					<td width="15%"  class="TD_STYLE1">
					I级机构名称 
					</td>
					<td width="15%"  class="TD_STYLE1">
					II级机构名称 
					</td>
					<td width="10%"  class="TD_STYLE1">
					制定人 
					</td>
					<td width="10%"  class="TD_STYLE1">
					复核人
					</td>
					<td width="10%" class="TD_STYLE1">
						<span>人数</span>
					</td>
					<td width="10%" class="TD_STYLE1">
						基本薪酬总额(元)
					</td>	
					<td width="10%" class="TD_STYLE1">
						实发薪酬总额(元)
					</td>				
					<td width="10%" class="TD_STYLE1">
						查看
					</td>
				</tr>
				
				<c:forEach items="${sglist}" var="s" varStatus="vs">
				
					<tr class="TD_STYLE2">
						<td>
							${s.salaryGrantId }
						</td>
						<td>
						${s.firstKindName }
						</td>
						<td>
						${s.secondKindName }
						</td>
						<td>
						${s.register }
						</td>
						<td>
						${s.checker }
						</td>
						<td>
							${s.humanAmount } 
						</td>
						<td>
							${s.salaryStandardSum} 
						</td>
						<td>
							${s.salaryPaidSum} 
						</td>
						<td>
							<a href="toGrantLook.do?sid=${s.salaryGrantId }&standardid=${s.salaryStandardId}" >查  看</a>
						</td>
					</tr>
				</c:forEach>	
				</table>
			<p>
			 
				&nbsp;
			</p>
		 
	</body>
</html>