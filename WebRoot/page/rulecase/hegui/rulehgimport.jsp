<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" errorPage="../public/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<title>合规业务规则导入</title>
</head>
<body>
	<div class="layout">
		<form name="filename" method="post" action="rulehgimport.action?pool=shbz"
			enctype="multipart/form-data">
			<div class="title">审核标准导入</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="上传">
					</div>
					<div class="four_columns_text">
							<a href="<%=path%>/templet/hgshbz.xlsx">下载【审核标准】模板</a>
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">&nbsp;</div>
					<input type="radio" name="type" value="fugai" />删除原表，全量覆盖
					<input type="radio" name="type" value="xinzeng" checked/>保留原表，更新新增
					<div class="four_columns_text">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="rulehgimport.action?pool=fhcy"
			enctype="multipart/form-data">
			<div class="title">分行差异导入</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="上传">
					</div>
					<div class="four_columns_text">
							<a href="<%=path%>/templet/hgfhcy.xlsx">下载【分行差异】模板</a>
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">&nbsp;</div>
					<input type="radio" name="type" value="fugai" />删除原表，全量覆盖
					<input type="radio" name="type" value="xinzeng" checked/>保留原表，更新新增
					<div class="four_columns_text">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="rulehgimport.action?pool=yjbf"
			enctype="multipart/form-data">
			<div class="title">印鉴不符导入</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="上传">
					</div>
					<div class="four_columns_text">
							<a href="<%=path%>/templet/hgyjbf.xlsx">下载【印鉴不符】模板</a>
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">&nbsp;</div>
					<input type="radio" name="type" value="fugai" />删除原表，全量覆盖
					<input type="radio" name="type" value="xinzeng" checked/>保留原表，更新新增
					<div class="four_columns_text">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>