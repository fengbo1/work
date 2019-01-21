
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
<title>操作员基础信息表导入</title>
</head>
<body>
	<div class="layout">
		<form name="filename" method="post" action="importno.action"
			enctype="multipart/form-data">
			<div class="title">操作员基础信息表导入</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
						<input type="hidden" name="oname" value="${username}"/>
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="上传">
					</div>
					<div class="four_columns_text"><p style="color:red">（请导入全量操作员基础信息，导入后原表将被覆盖，无法恢复）</p></div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
				<input type="button" value="返回"onclick="javascript:history.go(-1);" />
			</div>
		</form>
	</div>
</body>
</html>