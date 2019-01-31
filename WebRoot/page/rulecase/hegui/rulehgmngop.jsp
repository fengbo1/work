<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>	
		<title>acceptance_data</title>
		<link href="<%=path%>/css/add.css" type="text/css"
			rel="stylesheet" />
				<style type="text/css">
			textarea{
					width:800px;
					height:150px;
					font-size:16px;
					font-family:"宋体";
			}
			.rd{
					color:red;
			}
		</style>
	</head>
	<body>
		<form name="filename" action="mgopset.action" method="post" enctype="multipart/form-data">
			<div class="layout" >
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
				align="center">
					<b>配置维护操作岗</b>
				</div>

				<div id="content">
					
					<div class="four_columns">
						<div class="two_columns_text">
							当前配置维护操作岗:&nbsp;
						</div>
						<div class="four_columns_input">
						 	${mngop }
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="two_columns_text">
							配置维护操作岗:&nbsp;
					</div>
					<div class="four_columns_input">
						<input type="text" name="mngop" value=""/>
					</div>
					<div class="clear"></div>
				</div>
				
				<div  style="padding-left:340px">
						<input type="button" class="but"  value="关闭页面" onclick="javascript:window.close();">
						&nbsp;&nbsp;
						<input type="submit" class="but"  value="提交">
					<div class="clear"></div>
				</div>
				</div>
			</div>
		</form>
	</body>

</html>


