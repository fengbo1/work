<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  String zhi= (String) request.getSession().getAttribute("zhi");
  String role = (String) request.getSession().getAttribute("role");
   String chu = (String) request.getSession().getAttribute("chu");
  System.out.println("zhi:"+zhi);
  System.out.println("role:"+role);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%if(!chu.equals("4")){ %>
	<%if(zhi.equals("0")||zhi.equals("1")||role.equals("6")||role.equals("7")||role.equals("9")){ %>
	<meta http-equiv="Refresh" content="1; url=<%=path%>/warning.action">
	<%} %>
	<%} %>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   欢迎登陆生产信息管理工具..
  </body>
</html>
