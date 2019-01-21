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
	pageEncoding="UTF-8" errorPage="../public/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js"></script>
<title>人员属性</title>
</head>
<body>
	<div class="layout">
		<form name="form" id="form" method="post" action="opxzupdate.action">
			<div class="title">修改</div>
			<div id="content" >
				<div class="two_columns">
					<div class="two_columns_text">顺序:</div>
					<div class="two_columns_input">
						<c:if test="${cx.indx=='0'}">${cx.indx}
						<input type="hidden" id="indx" name="indx" value="0"></input>
						</c:if>
						<c:if test="${cx.indx!='0'}">
						<input type="text" id="indx" name="indx" value="${cx.indx}"></input>
						</c:if>
						
						</div>
				<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">属性:</div>
					<div class="two_columns_input">
						<c:if test="${cx.indx=='0'}">${cx.type}
						<input type="hidden" id="type" name="type" value="${cx.type}"/>
						<input type="hidden" id="oldtype" name="oldtype" value="${cx.type}"/>
						</c:if>
						<c:if test="${cx.indx!='0'}">
						<input type="text" id="type" name="type" value="${cx.type}"></input>
						<input type="hidden" id="oldtype" name="oldtype" value="${cx.type}"/>
						</c:if>
						
						</div>
				<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">内容:</div>
					<div class="two_columns_input">
						<input type="text" id="content" name="content" value="${cx.content}"></input>
					</div>
				<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">描述:</div>
					<div class="two_columns_input">
						<input type="text" id="detail" name="detail" value="${cx.detail}"></input>
					</div>
				<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">成员（顿号隔开）:</div>
						<textarea name="members">${members}</textarea>
						<input type="hidden" id="oldmembers" name="oldmembers" value="${members}"/>
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
						<input type="hidden" name="id" value="${cx.id}"/>
					</div>
				</div>
		</form>
	</div>
</body>
</html>