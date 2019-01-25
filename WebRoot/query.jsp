<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'query.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table border="1" width="80%">
    	<tr><th>序号</th><th>id</th><th>名字</th><th>数量</th><th>单位</th><th>操作</th></tr>
    	<c:forEach items="${gList}" var="g" varStatus="s">
    		<tr>
    			
    			<td>${s.count }</td>
    			<td>${g.id }</td>
    			<td>${g.goodsName }</td>
    			<td>${g.num }</td>
    			<td>${g.unit }</td>
    			<td><a>修改</a><a>删除</a></td>
    		</tr>
    	</c:forEach>
    </table>
    <hr/>
  </body>
</html>
