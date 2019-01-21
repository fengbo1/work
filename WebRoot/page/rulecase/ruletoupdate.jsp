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
		<form name="filename" action="ruleupdate.action" method="post" enctype="multipart/form-data">
			<div class="layout" >
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
				align="center">
					<b>修改规则</b>
				</div>

				<div id="content">
					
					<div class="four_columns">
						<div class="two_columns_text">
							板块:&nbsp;
						</div>
						<div class="four_columns_input">
						 	<input type="text" name="plate" value="${rr.plate}"/>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="two_columns_text">
							任务池:&nbsp;
					</div>
					<div class="four_columns_input">
						<input type="text" name="pool" value="${rr.pool}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							环节:&nbsp;
					</div>
					<div class="four_columns_input">
							<input style="width:600px" type="text" name="part" value="${rr.part}"/>
					</div>	
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							适用范围:&nbsp;
					</div>
					<div class="four_columns_input">
							<input style="width:600px" type="text" name="area" value="${rr.area}"/>
					</div>	
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							要素:&nbsp;
					</div>
					<div class="four_columns_input">
						<input style="width:600px" type="text" name="factor" value="${rr.factor}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							<input type="text" name="facAName" style="width:80px" value="${rr.facAName}"/>:&nbsp;
					</div>
					<div class="four_columns_input">
						<input style="width:600px" type="text" name="facA" value="${rr.facA}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							<input type="text" name="facBName" style="width:80px" value="${rr.facBName}"/>:&nbsp;
					</div>
					<div class="four_columns_input">
						<input style="width:600px" type="text" name="facB" value="${rr.facB}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							<input type="text" name="facCName" style="width:80px" value="${rr.facCName}"/>:&nbsp;
					</div>
					<div class="four_columns_input">
						<input style="width:600px" type="text" name="facC" value="${rr.facC}"/>
					</div>
					<div class="clear"></div>
				</div>		
				<div class="two_columns">
					<div class="two_columns_text">
							切片:&nbsp;
					</div>
					<div class="two_columns_input">
						<c:if test="${rr.picname!=''}">
							<img src="${imagepath}${rr.picname}">
						</c:if>
						<c:if test="${rr.picname==''}">
							无
						</c:if>
						<br/>
						更换图片<input type="file" name="file" /><b class="rd">（文件名不含中文）</b>
						<br/>
						<input type="checkbox" name="delpic" id="delpic"/>删除图片
					</div>
						
					<div class="clear"></div>
				</div>
				<div class="two_columns">
						
					<div class="two_columns_text">
							规则内容:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea name="rule" >${rr.rule}</textarea>
					</div>
						
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							规则说明:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea name="exp" >${rr.exp}</textarea>
					</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							备注:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea name="remark" >${rr.remark}</textarea>
					</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							更新说明:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea name="renewexp" >${rr.renewexp}</textarea>
					</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							附件:&nbsp;
					</div>
					<div class="two_columns_input">
						<c:forEach items="${fujian}" var="fj" varStatus="status">
							<input type="text" name="fujian" value="${fj}"/>
						</c:forEach>
						<input type="text" name="fujian"/>
						<input type="text" name="fujian"/>
						<input type="text" name="fujian"/>
					</div>
					<div class="clear"></div>
				</div>
				<div  style="padding-left:340px">
						<input type="hidden" name="id" value="${rr.id}"/>
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


