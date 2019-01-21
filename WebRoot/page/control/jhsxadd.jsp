
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
<title>上线人数增加或修改</title>
</head>
<body>
<!-- 
	<div class="layout">
		<form name="form" id="form" method="post" action="jhsxadd.action">
			<div class="title">上线人数增加或修改</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">日期（YYYYMMDD）:</div>
					<div class="four_columns_input">
					<input type="text" name="date" id="date" class="Wdate" onClick="WdatePicker()" >
					</div>
				<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">成都中心计划上线人数</div>
					<div class="four_columns_input">
						 <input type="text" id="cdjh" name="cdjh"/>
						 <input type="hidden" id="operator" name="operator" value="${username}"/>
					</div>
					<div class="four_columns_text">武汉中心计划上线人数</div>
					<div class="four_columns_input">
						 <input type="text" id="whjh" name="whjh"/>
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
							<input type="reset" value="重置" />
						</div>
						<div class="four_columns_input">
							<input type="submit" value="提交" />
						</div>
						<div class="clear"></div>
					</div>
				</div>
		</form>
	</div>
	 -->
	 <div class="layout">
		<form name="filename" method="post" action="importjhsx.action"
			enctype="multipart/form-data">
			<div class="title">计划上线人员表上传</div>
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
							<a href="<%=path%>/templet/jhsx.xls">下载【计划上线人员】模板</a>
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