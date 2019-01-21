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
$(".btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px" }); 
$(".btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px" }); 

});
 function del(id)
 {
	 var o=id;
	 if (window.confirm("确认删除？")) {
			with(document.forms[0]) {
				action='configdelete.action?id='+o;
				method="post";
				submit();
			}
		}
	}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <form action="<%=path%>/jhsx.action" method="post" name="fm1">
  <table align="center"  style="width:200px"  >
						<tr >
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="22" align="center"   bordercolor="#FFFFFF"><b>业务参数控制表</b>
							</td>
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang" >
							<td  width="100px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>业务种类</p>
								</div></td>	
							<td  width="300px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>业务编码</p>
								</div></td>
							<td  width="200px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>环节</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>产量计入</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>折算系数</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>					
						</tr>
							 <c:forEach items="${list}" var="para" varStatus="status">
							 <tr class="btbj" id="hang" style="height:20px">
								<td  height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:ywtypetostring(para.type)}</div></td>
								<td height="25" align="center" valign="middle" style="word-break:break-all;">
								<div align="center" onmouseover="document.getElementById('word_detail_${para.id}').style.display=''"
onmouseout="document.getElementById('word_detail_${para.id}').style.display='none'">${fb:stringtoshort(para.code)}</div>
								<div style="word-break:break-all;width:263px;display:none;position:absolute;background-color:white;border-style: solid; border-width: 5px;;" id="word_detail_${para.id}">${para.code}</div>		
								</td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.part}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:ywtypetostring(para.intype)}</div></td>	
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.weig}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<a	href="<%=path%>/configtoupdate.action?id=${para.id}">修改</a> &nbsp;&nbsp;&nbsp;
											<a	href="#" onclick="del('${para.id}')">删除</a> 
										</div></td>									
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
								<td colspan="7" align="center">
								<a	href="<%=path%>/page/control/configadd.jsp" style="padding-right: 30px;color: #104E8B">新增</a> 	
								</td>
							</tr>
						</table>
						</form>
  </body>
</html>
