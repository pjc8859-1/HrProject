<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <!-- <base href="<%=basePath%>"> -->
    
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="descriptio/n" content="This is my page">
	<script type="text/javascript" src="javascript/jquery-1.6.1.min.js"></script>
	<script type="text/javascript">
	var content;
	function showphoto(){
		var obj = document.getElementById("photo");
			var fr = new FileReader();
			var f = obj.files[0];
			fr.readAsDataURL(f);
			fr.onload = function(e){
				content = e.target.result;
				var filemin = 0;
				var filemax = 5;//限定为10m
				var filesize  = f.size/1024;
				document.getElementById("img").src=content;
				if(filesize > filemax )
					{
						alert("文件过大<0-5M>");
						$("#submit").attr("disabled","disabled");
					}
			}
		}
	</script>
  </head>
  
  <body>
    <form action="upload/up.do" method="post" enctype="multipart/form-data">
    	<input  type="file" id="photo" name= "file"   onchange="showphoto()"/>
    	<img id="img" width="500px" height="500px" alt="点击上传图片" onclick="document.getElementById('photo').click()" />
    	<input type="submit" value="上传" id="submit" />
    </form>
  </body>
</html>
