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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
function delrulezl(idd)
{
	var message = "确认删除？";
	if (window.confirm(message)) {
		with(document.forms[0]) {
			action='delrulezl.action?id='+idd;
			method="post";
			submit();
		}
	}
}
function search()
{
	var word=document.getElementById('word').value;
	var mg=document.getElementById('mg').value;
	var type=document.getElementById('type').value;
	word=encodeURI(word);
	//action='rcrulezl.action?word='+word;
	window.location.href='rcrulezl.action?type='+type+'&mg='+mg+'&word='+word;
	}

$(document).ready(function(){ 
	var x=document.getElementsByName("para");
	$('#type').attr('value',x[0].value);
	});
</script>
<style type="text/css">
.rd{
					color:red;
			}
</style>
<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<title>源数据导入</title>
</head>
<body>
	<div class="layout">
		<form name="filename" method="post" action="zlimport.action?rulecase=rule"
			enctype="multipart/form-data">
			<table border="1px" align="center">
				<tr class="qq">
					<td
						style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
						colspan="5" align="center" bordercolor="#FFFFFF">
						<b>辅助资料下载</b>
					</td>
				</tr>
				<tr class="qq">
					<td colspan="5" align="center">
					类型
							<select id="type" name="type" style="width: 120px">
						 		<option value="1">辅助资料</option>
						 		<option value="2">附件</option>
							</select>	
						关键字:<input id="word" type="text"  style="width: 200px" name="word" value="${word}"/>
						<input type="button" onclick="search()" value="查询"/>
						<input type="hidden" id="mg" name="mg" value="${mg}"/>
						<input type="hidden" name="para" value="${type}"/>
					</td>
					
				</tr> 
				<tr align="center" style="font-weight:bold;font-size:19px">
					<td style="width:50px">序号</td>
					<td style="width:130px">上传时间</td>
					<td style="width:100px">类型</td>
					<td style="width:400px">资料名称</td>
					<td style="width:130px">操作</td>
				</tr>
				<c:forEach items="${list}" var="zl" varStatus="status">
				<tr align="center">
					<td>${status.index+1}</td>
					<td>${zl.date}</td>
					<td>${fb:rulezltostring(zl.type)}</td>
					<td>${zl.zlname}</td>
					<td><a	href="<%=path%>/derivezl.action?id=${zl.id}">下载</a>
					<c:if test="${mg==1}">
					&nbsp;
					<a onClick="return confirm('确定删除?');"  href="<%=path%>/delrulezl.action?id=${zl.id}">删除</a>
					</c:if>
					</td>
					
				</tr>
				</c:forEach>
				<tr class="表格表头背景">
							<td colspan="5">
								<div align="center">
								<a	href="<%=path%>/rcrulezl.action?mg=${mg}&word=${word}&type=${type}&currentPage=${previousPage}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/rcrulezl.action?mg=${mg}&word=${word}&type=${type}&currentPage=${nextPage}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
								</div></td>
				</tr>
				<c:if test="${mg==1}">
				<tr>
					<td colspan="5">
					资料上传
					</td>
				</tr>
				<tr>
					<td colspan="5">
						类型
							<select id="typetype" name="typetype" style="width: 120px">
						 		<option value="1">辅助资料</option>
						 		<option value="2">附件</option>
							</select>
					&nbsp;&nbsp;&nbsp;	
						板块
							<select id="plate" name="plate" style="width: 120px">
						 		<option value="1">通用业务</option>
						 		<option value="2">外汇业务</option>
							</select>	
					&nbsp;&nbsp;&nbsp;
						任务池
							<select id="pool" name="pool" style="width: 120px">
						 		<option value="891">891</option>
						 		<option value="895">895</option>
							</select>
					</td>		
				</tr>
				<tr>
					<td colspan="5">
					选择上传文件<input type="file" name="file" />
					&nbsp;&nbsp;&nbsp;
					填写资料名称<input type="text" name="zlname" />
					<input type="submit" name="submit"value="上传"></td>
				</tr>
				<tr>
					<td colspan="5">
					<b class="rd">文件名称请勿使用中文，资料名称可以使用中文</b>
					</td>
				</tr>
				</c:if>
			</table>
		</form>
	</div>
</body>
</html>