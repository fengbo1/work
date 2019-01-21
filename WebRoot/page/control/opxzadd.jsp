
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<style type="text/css">
			textarea{
					width:800px;
					height:150px;
					font-size:16px;
					font-family:"宋体";
			}
		</style>
<title>人员属性</title>
</head>
<body>
	<div class="layout">
		<form name="form" id="form" method="post" action="opxzadd.action">
			<div class="title">新增</div>
			<div id="content" >
				<div class="two_columns">
					<div class="two_columns_text">属性:</div>
					<div class="two_columns_input">
						<input type="text" id="type" name="type"></input>
						</div>
				<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">内容:</div>
					<div class="two_columns_input">
						<input type="text" id="content" name="content"></input>
					</div>
				<div class="clear"></div>
				<div class="two_columns">
					<div class="two_columns_text">描述:</div>
					<div class="two_columns_input">
						<input type="text" id="detail" name="detail"></input>
					</div>
				<div class="clear"></div>
				</div>
					<div class="four_columns">
						<div class="four_columns_input">
						</div>
						<div class="four_columns_input">
						<input type="button" value="返回"onclick="javascript:history.go(-1);" />
						</div>
						<div class="four_columns_input">
						<input type="reset" value="重置"/>
						</div>
						<div class="four_columns_input">
							<input type="submit" value="提交" />
						</div>
						<input type="hidden" name="qzsx" value="sx"/>
						<div class="clear"></div>
					</div>
				</div>
		</form>
	</div>
</body>
</html>