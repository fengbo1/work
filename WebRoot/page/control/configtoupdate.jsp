
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
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "UTF-8"></script>
<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
 $(document).ready(function(){ 
	var x=document.getElementsByName("para");
	$('#type').attr('value',x[0].value);
	$('#intype').attr('value',x[1].value);
});
 </script>
<title>系数</title>
</head>
<body>
	<div class="layout">
		<form name="form" id="form" method="post" action="configupdate.action">
			<div class="title">系数调整</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">业务种类:</div>
					<div class="four_columns_input">
						<select id="type" name="type" style="width: 120px" >
								<option value="1">人民币（账务）</option>
								<option value="2">人民币（非账务）</option>
								<option value="3">外汇</option>
								<option value="4">稽核</option>
								<option value="5">远程审核</option>
								<option value="6">建亚</option>
								<option value="7">反洗钱</option>
							</select>	
						</div>
				<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">业务编码:</div>
					<div >
						<textarea id="code" name="code" rows="10" cols="10">${hc.code}</textarea>
						</div>
				<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">环节:</div>
					<div class="four_columns_input">
						<input type="text" id="part" name="part" value="${hc.part}"/>
						</div>
				<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">产量计入:</div>
					<div class="four_columns_input">
						<select id="intype" name="intype" style="width: 120px" >
								<option value="1">人民币（账务）</option>
								<option value="2">人民币（非账务）</option>
								<option value="3">外汇</option>
								<option value="4">稽核</option>
								<option value="5">远程审核</option>
								<option value="6">建亚</option>
								<option value="7">反洗钱</option>
							</select>	
						</div>
				<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">折算系数:</div>
					<div class="four_columns_input">
						<input type="text" id="weig" name="weig" value="${hc.weig}"/>
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
				<input type="hidden" name="para" value="${hc.type}"/>
				<input type="hidden" name="para" value="${hc.intype}"/>
				<input type="hidden" name="id" value="${hc.id}"/>
		</form>
	</div>
</body>
</html>