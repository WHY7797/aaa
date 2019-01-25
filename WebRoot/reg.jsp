<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.js"></script>
	<script type="text/javascript">
			  var second=60;
			  var h;
		$(function(){
			$("#but1").click(function(){
				if($("#email").val()==''){
					alert("邮箱不许为空");
					return;
				}
				
				var r="";
				for(var i=0;i<6;i++){
					r+=Math.floor(Math.random()*10);
				}
				$("#sess").val(r);
				/*$.ajax({
					url:"",
					data:{
						youxiang:$("#email").val(),
						sess:r
						}
				});*/
				
				$("#but1").attr("disabled",true);
				h=setInterval("time()", 1000);
			});
		});
		
		function time(){
			if(second<=0){
				$("#but1").attr("disabled",false);
				$("#but1").val("发送邮件");
				clearInterval(h);
			}else{
				$("#but1").val("已发送"+second--+"秒");
			}
		}
		
		function check(){
			var s=$("#s").val();
			if(s==$("#sess").val()){
				return true;
			}
			alert("验证码不对");
			return false;
		}
	</script>
  </head>
  
  <body>
     <form action="${pageContext.request.contextPath}/addUser" onsubmit="return check();">
     	<input type="hidden" id="sess"/>
    	用户名:<input type="text" name="user.userName"/><br>
    	密码:<input type="text" name="user.password"/><br>
    	邮箱:<input type="text" id="email" name="user.email"/><br>
    	验证码:<input type="text" id="s" name="sess"/><input type="button" id="but1" value="发送邮件"/><br>
    	<input type="submit" value="添加"/>
    </form>
   ${msg }
  </body>
</html>
