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
		<form name="filename" action="caseadd.action" method="post" enctype="multipart/form-data">
			<div class="layout" >
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
				align="center">
					<b>新增案例</b>
				</div>

				<div id="content">
					
					<div class="four_columns">
						<div class="two_columns_text">
							<b class="rd">*</b>板块:&nbsp;
						</div>
						<div class="four_columns_input">
						 	<select id="plate" name="plate" style="width: 120px">
						 		<option value="通用业务">通用业务</option>
						 		<option value="外汇业务">外汇业务</option>
							</select>	
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="two_columns_text">
							<b class="rd">*</b>任务池:&nbsp;
					</div>
					<div class="four_columns_input">
						<select id="pool" name="pool" style="width: 120px">
						 		<option value="891">891</option>
						 		<option value="895">895</option>
						</select>	
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							<b class="rd">*</b>环节:&nbsp;
					</div>
					<div class="four_columns_input">
							<input type="text" name="part"/>
					</div>	
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							要素:&nbsp;
					</div>
					<div class="four_columns_input">
						<input type="text" name="factor"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							<input type="text" name="facAName" style="width:80px"/>:&nbsp;
					</div>
					<div class="four_columns_input">
						<input type="text" name="facA"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							<input type="text" name="facBName" style="width:80px"/>:&nbsp;
					</div>
					<div class="four_columns_input">
						<input type="text" name="facB"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							<input type="text" name="facCName" style="width:80px"/>:&nbsp;
					</div>
					<div class="four_columns_input">
						<input type="text" name="facC"/>
					</div>
					<div class="clear"></div>
				</div>		
				<div class="two_columns">
						
					<div class="two_columns_text">
							切片:&nbsp;
					</div>
					<div class="two_columns_input">
						选择切片<input type="file" name="file" /><b class="rd">（文件名不含中文）</b>
					</div>
						
					<div class="clear"></div>
				</div>
				<div class="two_columns">
						
					<div class="two_columns_text">
							案例描述:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea name="rule" ></textarea>
					</div>
						
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							案例点评:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea name="exp" ></textarea>
					</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							备注:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea name="remark"></textarea>
					</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							更新说明:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea name="renewexp"></textarea>
					</div>
					<div class="clear"></div>
				</div>
				<div style="padding-left:340px" >
						<input type="hidden" name="id" value="${rr.id}"/>
						<input type="button" class="but" value="关闭页面" onclick="javascript:window.close();">
						&nbsp;&nbsp;
						<input type="submit" class="but"  value="确认新增">
					<div class="clear"></div>
				</div>
				</div>
			</div>
		</form>
	</body>

</html>


