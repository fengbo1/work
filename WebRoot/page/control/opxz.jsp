<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//ExpressReport er = new ExpressReport();
//ArrayList<HnDetail> hdlist = er.gethdList("20150103");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #ffffff;
}
-->
</style>
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js"></script>
<script type="text/javascript">
 $(document).ready(function(){ 
	 $("tr.btbjodd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
	 $("tr.btbjeven").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$(".btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px" }); 
$(".btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px" }); 

});
 function del(id)
 {
	 var o=id;
	 if (window.confirm("确认删除？")) {
			with(document.forms[0]) {
				action='opxzdelete.action?id='+o;
				method="post";
				submit();
			}
		}
	}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <form action="<%=path%>/opxz.action" method="post" name="fm1">
  <table align="center"  style="width:200px"  >
						<tr >
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="6" align="center"   bordercolor="#FFFFFF"><b>自定义群组控制表</b>
							</td>
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang" >
							<td  width="200px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>群组</p>
								</div></td>
							<td  width="300px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>描述</p>
								</div></td>	
							<td  width="150px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>
						</tr>
							 <c:forEach items="${list}" var="para" varStatus="status">
							 <c:if test="${para.indx==0}">
							 <tr class="btbj" id="hang" style="height:20px">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.content}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.detail}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<a	href="<%=path%>/opxztoupdate.action?id=${para.id}">修改</a> &nbsp;&nbsp;&nbsp;
											<a	href="#" onclick="del('${para.id}')">删除</a> 
										</div></td>									
							</tr>
							</c:if>
							</c:forEach>
							<tr class="表格表头背景">
								<td colspan="6" align="center">
								<a	href="<%=path%>/page/control/opxzaddqz.jsp" style="padding-right: 30px;color: #104E8B">新增自定义群组</a>
								</td>
							</tr>
						</table>
			<br/><br/><br/>			
		<table align="center"  style="width:200px"  >
						<tr >
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="6" align="center"   bordercolor="#FFFFFF"><b>人员属性控制表</b>
							</td>
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang" >
							<td  width="50px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>属性</p>
								</div></td>	
							<td  width="300px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>内容</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>
						</tr>
							 <c:forEach items="${list}" var="para" varStatus="status">
							 <c:if test="${para.indx>0}">
							 <tr 
								<c:if test="${para.beijing==0}">class="btbjodd"</c:if>
        						<c:if test="${para.beijing==1}">class="btbjeven"</c:if>
								 id="hang" style="height:20px">
								<c:if test="${para.rowsp!='0'}">
        							<td rowspan="${para.rowsp}" height="25" align="center" valign="middle" ><div align="center">${para.indx}</div></td>
        							<td rowspan="${para.rowsp}" height="25" align="center" valign="middle" ><div align="center">${para.type}</div></td>
        						</c:if>	 
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.content}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<a	href="<%=path%>/opxztoupdate.action?id=${para.id}">修改</a> &nbsp;&nbsp;&nbsp;
											<a	href="#" onclick="del('${para.id}')">删除</a> 
										</div></td>									
							</tr>
							</c:if>
							</c:forEach>
							<tr class="表格表头背景">
								<td colspan="6" align="center">
								<a	href="<%=path%>/page/control/opxzadd.jsp" style="padding-right: 30px;color: #104E8B">新增自定义属性</a>  	
								</td>
							</tr>
						</table>				
						</form>
  </body>
</html>
