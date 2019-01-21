
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	int id = Integer.parseInt(request.getParameter("id"));
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" errorPage="../public/error.jsp"%>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
		
		function validateForm() {
			if(document.form.hnCl.value.length == 0){
				alert("行内人员当月产量目标值不能为空！");
				document.form.hnCl.focus();
				return false;
			}
			if(document.form.hnZl.value.length == 0){
				alert("行内人员当月质量目标值不能为空！");
				document.form.hnZl.focus();
				return false;
			}
			return true;
		}
	</script>
<title>参数修改</title>
</head>
<body>
	<div class="layout">
		<form name="form" id="form" method="post" action="monthparaupdate.action" onsubmit="return validateForm()">
			<div class="title">参数修改</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">月份（YYYYMM）:</div>
					<div class="four_columns_input">
					<input type="hidden" id="id" name="id" value="<%=id%>"/>
					<input type="hidden" id="month" name="month" value="${entity.month}"/>
					<input type="hidden" name="username" value="${username}"/>
					<input type="hidden" name="no891" value="${no891}"/>
						 ${entity.month}
					</div>
				<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">行内人员当月产量目标值</div>
					<div class="four_columns_input">
						 <input type="text" id="hnCl" name="hnCl" value="${entity.hnCl}"/>
					</div>
					<div class="four_columns_text">行内人员当月质量目标值</div>
					<div class="four_columns_input">
						 <input type="text" id="hnZl" name="hnZl" value="${entity.hnZl}"/>
					</div>
				<div class="clear"></div>
				</div>
				<div class="four_columns">		
					<div class="four_columns_text">外包人员当月产量目标值</div>
					<div class="four_columns_input">
						<input type="text" id="wbCl" name="wbCl" value="${entity.wbCl}"/>
					</div>
					<div class="four_columns_text">外包人员当月质量目标值</div>
					<div class="four_columns_input">
						  <input type="text" id="TBz" name="TBz" value="${entity.TBz}"/>
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
</body>
</html>