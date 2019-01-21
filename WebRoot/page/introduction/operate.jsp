
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" errorPage="../public/error.jsp"%>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<title>日报表数据加工</title>
</head>
<body>
<div class="layout">
<!-- 
   <form name="filename" method="post" action="wbgeneral.action">
		<div class="title">外包日报表数据加工</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">日期</div>
					<div class="four_columns_input">
						 <input type="text" name="date" id="date" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input"></div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="生成">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
			</form>
		 -->	
		<form name="filename" method="post" action="producesummary.action">
		<div class="title">汇总日报表数据加工</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">日期</div>
					<div class="four_columns_input">
						 <input type="text" name="date" id="date" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input"></div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="生成">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
			</form>
		<form name="filename" method="post" action="producesimple.action">
		<div class="title">汇总简报数据加工</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">日期</div>
					<div class="four_columns_input">
						 <input type="text" name="date" id="date" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input"></div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="生成">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
			</form>
  </div>
	
</body>
</html>