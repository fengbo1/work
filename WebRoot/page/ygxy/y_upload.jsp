<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
		<title>员工响应数据上传</title>
	</head>
	<body>
		
		<div class="layout">
			<form name="filename" method="post" action="y_upload.action"
				enctype="multipart/form-data">
				<div class="title">
					源数据导入
				</div>
				<div id="content">
					<div class="four_columns">
						<div class="four_columns_text">
							选择上传文件
						</div>
						<div class="four_columns_input">
							<input type="file" name="file" />
						</div>
						<div class="four_columns_input">
							<input type="submit" name="submit" value="上传">
						</div>
						<div class="four_columns_text">
							<p style="color: red">
								（请另存为excel2003格式后上传）
							</p>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</form>
		</div>
		<div class="layout">
			<form name="filename" method="post" action="lxscupload.action"
				enctype="multipart/form-data">
				<div class="title">
					离线时长表导入
				</div>
				<div id="content">
					<div class="four_columns">
						<div class="four_columns_text">
							选择上传文件
						</div>
						<div class="four_columns_input">
							<input type="file" name="file" />
						</div>
						<div class="four_columns_input">
							<input type="submit" name="submit" value="上传">
						</div>
						<div class="four_columns_text">
							<a href="<%=path%>/templet/ygxylixian.xls">下载【离线时长表】模板</a>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</form>
		</div>
		<div class="layout">
			<form name="filename" method="post" action="ypbmx.action"
				enctype="multipart/form-data">
				<div class="title">
					排班明细表导入
				</div>
				<div id="content">
					<div class="four_columns">
						<div class="four_columns_text">
							选择上传文件
						</div>
						<div class="four_columns_input">
							<input type="file" name="file" />
						</div>
						<div class="four_columns_input">
							<input type="submit" name="submit" value="上传">
						</div>
						<div class="four_columns_input" align="right">
							<a href="<%=path%>/templet/ygxypaiban.xls">下载【排班明细表】模板</a>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</form>
		</div>
		<div class="layout">
			<form name="filename" method="post" action="yzjmx.action"
				enctype="multipart/form-data">
				<div class="title">
					质检明细表导入
				</div>
				<div id="content">
					<div class="four_columns">
						<div class="four_columns_text">
							选择上传文件
						</div>
						<div class="four_columns_input">
							<input type="file" name="file" />
						</div>
						<div class="four_columns_input">
							<input type="submit" name="submit" value="上传">
						</div>
						<div class="four_columns_text">
							<p style="color: red">
								（请另存为excel2003格式后上传）
							</p>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>