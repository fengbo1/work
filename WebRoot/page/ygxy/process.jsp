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
		<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "UTF-8"></script>
		<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<title>员工响应数据加工</title>
	</head>
	<body>
		
		<div class="layout">
			<form name="form" method="post" action="quarterprocess.action">
				<div class="title">
					生成季报表
				</div>
				<div id="content">
					<div class="four_columns">
						<div class="four_columns_text">
							选择
						</div>
						<div class="four_columns_input">
							<select name="year" id="year">
								<option value="${yeara}">${yeara}</option>
								<option value="${yearb}">${yearb}</option>
							</select>年
							<select name="quarter" id="quarter">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>季度
						</div>
						<div class="four_columns_input">
							<input type="submit" name="submit" value="生成">
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</form>
		</div>
		<div class="layout">
			<form name="form" method="post" action="quarterexpress.action">
				<div class="title">
					导出季报表
				</div>
				<div id="content">
					<div class="four_columns">
						<div class="four_columns_text">
							选择
						</div>
						<div class="four_columns_input">
							<select name="year" id="year">
								<option value="${yeara}">${yeara}</option>
								<option value="${yearb}">${yearb}</option>
							</select>年
							<select name="quarter" id="quarter">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>季度
						</div>
						<div class="four_columns_input">
							<input type="submit" name="submit" value="导出">
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</form>
		</div>
		<div class="layout">
			<form name="form" method="post" action="ygxymxbexpress.action">
				<div class="title">
					导出日报表
				</div>
				<div id="content">
					<div class="four_columns">
						<div class="four_columns_text">
							选择
						</div>
						<div style="width:300px">
							<input type="text" size="10" name="bgdate" id="bgdate" class="Wdate" onClick="WdatePicker()" >
							至
							<input type="text" size="10" name="eddate" id="eddate" class="Wdate" onClick="WdatePicker()" >
						</div>
						<div class="four_columns_input">
							<input type="submit" name="submit" value="导出">
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>