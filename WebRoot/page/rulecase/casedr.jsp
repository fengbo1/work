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
<script type="text/javascript">
	function xinzeng()
	{
		window.open("<%=path%>/casetoadd.action","","height=700,width=950,top=100,left=290,scrollbars=yes,resizable=yes");
	}

</script>
<title>案例导入</title>
</head>
<body>
	<div class="layout">
		<form name="filename" method="post" action="ruleimport.action?rulecase=case"
			enctype="multipart/form-data">
			<div class="title">案例导入</div>
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
							<a href="<%=path%>/templet/anliku.xlsx">下载【案例库】模板</a>
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
		<form name="filename" method="post" action="imgimport.action?rulecase=case"
			enctype="multipart/form-data">
			<div class="title">图片导入</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input" style="color:red">
						 <input type="submit" name="submit"value="上传">
					</div>
				</div>
				<div class="four_columns">
					<div class="two_columns_input" style="color:red">
						 (多个文件请压缩成ZIP格式，压缩文件小于50MB<br/>图片名规则：al_ty_891_lrxg_hm_201706010001)
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="imgimport.action?rulecase=rule"
			enctype="multipart/form-data">
			<div class="title">单个新增</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text"></div>
					<div class="four_columns_input">
						<input align="right" type="button" value="新  增" onclick="xinzeng();" />
					</div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="expresscase.action"
			enctype="multipart/form-data">
			<div class="title">全量导出</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text"></div>
					<div class="four_columns_input">
						<input align="right" type="submit" value="导  出" />
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>