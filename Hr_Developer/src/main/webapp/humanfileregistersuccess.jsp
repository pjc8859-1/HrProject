<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%response.setStatus(HttpServletResponse.SC_OK);%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>SUCCESS</title>
		<script type="text/javascript" src="javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
		<script type="text/javascript" src="javascript/comm/select.js"></script>
		<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" src="javascript/userdetails.js"></script>
		<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
  </head>
  <script type="text/javascript">
  	var errortime=0;
  	var aaa =new Array();
  	aaa[0]="五";
  	aaa[1]="四";
  	aaa[2]="三";
  	aaa[3]="二";
  	aaa[4]="一";
  	function getUrlVal(property){
  	  var urlStr = window.location.search.substring(1);
  	  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  	  var result = urlStr.match(re);
  	  if(result == null){return null};
  	  return result[2];
  	};
  	$(function() {
  	var timer = setInterval(function() {
  		$("#time").html(aaa[++errortime]);
  		if (errortime==4) {
			clearInterval(timer);
			location.href="/Hr_Developer/index.jsp?";
		}
	},1000);
	});
  </script>
  <body style="background:#d8765d;">
  <center>
  <div style="margin-top: 100px">
  		<h1 style="color: white;">人力资源档案登记成功！<span id="time">五</span>秒之后回主页</h1>
  		<h3 style="color: white;"></h3>
 		</div>
  </center>
  </body>
</html>
