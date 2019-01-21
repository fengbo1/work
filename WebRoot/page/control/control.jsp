<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	pageEncoding="UTF-8"%>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<title>业务提示</title>
</head>
<body>
	<div class="layout">
		<form name="form" id="form" method="post" action="controlupdate.action">
			<div class="title">业务提示</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">质量业务提示:</div>
					<div class="four_columns_input">
						${control.zlYj}</div>
				<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">产量业务提示（低）:</div>
					<div class="four_columns_input">
						${control.clZbLow}</div>
					<div class="four_columns_text">产量业务提示（高）:</div>
					<div class="four_columns_input">
						${control.clZbHigh}</div>
				<div class="clear"></div>
				</div>
					<div class="four_columns">
						<div class="four_columns_input">
						</div>
						<div class="four_columns_input">
						</div>
						
						<div class="four_columns_input">
						<c:if test="${role=='6'}"> <!-- 主任、参数维护岗、系统管理员 -->
							<input type="button" onclick="location='<%=path%>/page/control/controlupdate.jsp'" value="修改参数值" />
						</c:if>
						</div>
						<div class="clear"></div>
					</div>
				</div>
		</form>
	</div>
</body>
</html>