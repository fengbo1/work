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
		<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "UTF-8"></script>
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
		<script type="text/javascript">
 $(document).ready(function(){ 
$('#fac_a').attr('value',${rr.facA});
});
</script>	
	</head>
	<body>
		<form name="filename" action="rulehgupdate.action" method="post" enctype="multipart/form-data">
			<div class="layout" >
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
				align="center">
					<b>审核标准修改</b>
				</div>

				<div id="content">
					
					<div class="four_columns">
						<div class="two_columns_text">
							<b class="rd">*</b>模型编号:&nbsp;
						</div>
						<div class="four_columns_input">
						 	<input type="text" name="part" value="${rr.part}"/>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="two_columns_text">
							<b class="rd">*</b>模型名称:&nbsp;
					</div>
					<div class="four_columns_input">
						<input type="text" name="area" value="${rr.area}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							<b class="rd">*</b>在用标志:&nbsp;
					</div>
					<div class="four_columns_input">
							<select id="fac_a" name="fac_a" style="width: 120px">
						 		<option value="1">在用</option>
						 		<option value="0">停用</option>
							</select>	
					</div>	
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							生效时间:&nbsp;
					</div>
					<div class="four_columns_input">
							<input type="text" name="fac_b" id="fac_b" class="Wdate" onClick="WdatePicker()" value="${rr.facB}">
					</div>	
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							失效时间:&nbsp;
					</div>
					<div class="four_columns_input">
							<input type="text" name="fac_c" id="fac_c" class="Wdate" onClick="WdatePicker()" value="${rr.facC}">
					</div>	
					<div class="clear"></div>
				</div>
				<div class="two_columns">
						
					<div class="two_columns_text">
							审核标准:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea name="rule" >${rr.rule}</textarea>
					</div>
						
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							制度依据:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea name="exp" >${rr.exp}</textarea>
					</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							审核要点:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea name="remark">${rr.remark}</textarea>
					</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							更新说明:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea name="renewexp">${rr.renewexp }</textarea>
					</div>
					<div class="clear"></div>
				</div>
				<div  style="padding-left:340px">
						<input type="hidden" name="id" value="${id }"/>
						<input type="button" class="but"  value="关闭页面" onclick="javascript:window.close();">
						&nbsp;&nbsp;
						<input type="submit" class="but"  value="确认修改">
					<div class="clear"></div>
				</div>
				</div>
			</div>
		</form>
	</body>

</html>


