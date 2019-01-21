
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
<title>行内数据表下载</title>
</head>
<body>
	<div class="layout">
	<form name="filename" method="post" action="expressSummary.action"
			enctype="multipart/form-data">
			<div class="title">行内汇总报表下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">起始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">截止日期</div>
					<div class="four_columns_input">
						 <input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="expressSimple.action"
			enctype="multipart/form-data">
			<div class="title">行内汇总简报表下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">起始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">截止日期</div>
					<div class="four_columns_input">
						 <input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="newdailyreport.action"
			enctype="multipart/form-data">
			<div class="title">行内个人明细日报表下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">起始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">截止日期</div>
					<div class="four_columns_input">
						 <input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit" value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="dailyreport.action"
			enctype="multipart/form-data">
			<div class="title">行内个人明细日报表（人民币）下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">起始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">截止日期</div>
					<div class="four_columns_input">
						 <input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<!-- 
		<form name="filename" method="post" action="newdailydetail.action"
			enctype="multipart/form-data">
			<div class="title">行内个人明细日报表（非人民币汇总）下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">起始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">截止日期</div>
					<div class="four_columns_input">
						 <input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit" value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		 -->
		<form name="filename" method="post" action="expwaihui.action"
			enctype="multipart/form-data">
			<div class="title">外汇下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">起始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">截止日期</div>
					<div class="four_columns_input">
						 <input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit" value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="expjianya.action"
			enctype="multipart/form-data">
			<div class="title">建亚下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">起始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">截止日期</div>
					<div class="four_columns_input">
						 <input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit" value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="expjihe.action"
			enctype="multipart/form-data">
			<div class="title">稽核下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">起始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">截止日期</div>
					<div class="four_columns_input">
						 <input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit" value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="expycsh.action"
			enctype="multipart/form-data">
			<div class="title">远程审核下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">起始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">截止日期</div>
					<div class="four_columns_input">
						 <input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit" value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="expfxq.action"
			enctype="multipart/form-data">
			<div class="title">反洗钱下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">起始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">截止日期</div>
					<div class="four_columns_input">
						 <input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="express891.action"
			enctype="multipart/form-data">
			<div class="title">人民币账务基础数据表下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">起始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">截止日期</div>
					<div class="four_columns_input">
						 <input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
		<form name="filename" method="post" action="express895.action"
			enctype="multipart/form-data">
			<div class="title">人民币非账务基础数据表下载</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">起始日期</div>
					<div class="four_columns_input">
						 <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_text">截止日期</div>
					<div class="four_columns_input">
						 <input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="下载">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>