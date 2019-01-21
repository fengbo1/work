
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String month = request.getParameter("month");		
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" errorPage="../public/error.jsp"%>
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "UTF-8"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<title>导入配置信息</title>
</head>
<body>

	 <div class="layout">
		<form name="filename" method="post" action="importjihe.action"
			enctype="multipart/form-data">
			<div class="title">稽核人员明细</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit" value="上传">
					</div>
				<div class="four_columns_text">
							<a href="<%=path%>/templet/jihe.xls">下载【稽核人员明细】模板</a>
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
				
			</div>
			<input type="button" value="返回"onclick="javascript:history.go(-1);" />
		</form>
	</div>
	
	<div class="layout">
		<form name="filename" method="post" action="importfxq.action"
			enctype="multipart/form-data">
			<div class="title">反洗钱人员明细</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit" value="上传">
					</div>
				<div class="four_columns_text">
							<a href="<%=path%>/templet/fxq.xls">下载【反洗钱】模板</a>
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
				
			</div>
			<input type="button" value="返回"onclick="javascript:history.go(-1);" />
		</form>
	</div>
</body>
</html>