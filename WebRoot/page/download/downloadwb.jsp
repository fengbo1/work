
<%	String path = request.getContextPath();
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
<title>外包数据下载</title>
</head>
<body>
	<div class="layout">
		<form name="filename" method="post" action="downloadbase.action"
			enctype="multipart/form-data">
			<div class="title">外包891基础数据下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">开始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">结束日期</div>
					<div class="four_columns_input">
						<input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
			</form>
			<form name="filename" method="post" action="yslrdownload.action"	enctype="multipart/form-data">
			<div class="title">要素录入日报表下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">开始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">结束日期</div>
					<div class="four_columns_input">
						<input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="lrzcdownload.action"	enctype="multipart/form-data">
			<div class="title">录入仲裁日报表下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">开始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">结束日期</div>
					<div class="four_columns_input">
						<input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="fzyydownload.action"	enctype="multipart/form-data">
			<div class="title">辅助验印日报表下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">开始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">结束日期</div>
					<div class="four_columns_input">
						<input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
	</div>
	
</body>
</html>