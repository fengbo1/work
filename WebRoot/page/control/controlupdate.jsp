
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
<title>业务提示修改</title>
</head>
<body>
	<div class="layout">
		<form name="form" id="form" method="post" action="controlupdate.action">
			<div class="title">业务提示修改</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">质量业务提示:</div>
					<div class="four_columns_input">
						<input type="text" id="zlYj" name="zlYj" value="${control.zlYj}"/>
						</div>
				<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">产量业务提示（低）:</div>
					<div class="four_columns_input">
						<input type="text" id="clZbLow" name="clZbLow" value="${control.clZbLow}"/>
						</div>
					<div class="four_columns_text">产量业务提示（高）:</div>
					<div class="four_columns_input">
						<input type="text" id="clZbHigh" name="clZbHigh" value="${control.clZbHigh}"/>
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
						<div class="clear"></div>
					</div>
				</div>
		</form>
	</div>
</body>
</html>