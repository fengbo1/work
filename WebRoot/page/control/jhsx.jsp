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
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <form action="<%=path%>/jhsx.action" method="post" name="fm1">
  <table align="center"  style="width:200px"  >
						<tr >
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="26" align="center"   bordercolor="#FFFFFF"><b>计划上线人数</b>
							</td>
						</tr>
						<tr height="20px" class="表格表头背景1" id="hang" >
							<td  width="30px" rowspan="3" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="60px" rowspan="3" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>日期</p>
								</div></td>
							<td  width="160px" colspan="4" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>人民币账务</p>
								</div></td>
							<td  width="160px" colspan="4" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>人民币非账务</p>
								</div></td>
							<td  width="160px" colspan="4" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>外汇</p>
								</div></td>
							<td  width="160px" colspan="4" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>稽核</p>
								</div></td>
							<td  width="160px" colspan="4" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>远程审核</p>
								</div></td>
							<td  width="160px" colspan="4" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>建亚</p>
								</div></td>				
						</tr>
						<tr height="20px" class="表格表头背景1" id="hang" >
							<td  width="80px" colspan="2" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>成都</p>
								</div></td>
							<td  width="80px" colspan="2" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>武汉</p>
								</div></td>
							<td  width="80px" colspan="2" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>成都</p>
								</div></td>
							<td  width="80px" colspan="2" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>武汉</p>
								</div></td>
							<td  width="80px" colspan="2" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>成都</p>
								</div></td>
							<td  width="80px" colspan="2" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>武汉</p>
								</div></td>
							<td  width="80px" colspan="2" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>成都</p>
								</div></td>
							<td  width="80px" colspan="2" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>武汉</p>
								</div></td>
							<td  width="80px" colspan="2" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>成都</p>
								</div></td>
							<td  width="80px" colspan="2" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>武汉</p>
								</div></td>
							<td  width="80px" colspan="2" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>成都</p>
								</div></td>
							<td  width="80px" colspan="2" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>武汉</p>
								</div></td>	
						</tr>
						<tr height="20px" class="表格表头背景1" id="hang" >
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>计划</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>实际</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>计划</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>实际</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>计划</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>实际</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>计划</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>实际</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>计划</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>实际</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>计划</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>实际</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>计划</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>实际</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>计划</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>实际</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>计划</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>实际</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>计划</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>实际</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>计划</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>实际</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>计划</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>实际</p>
								</div></td>
						</tr>
							 <c:forEach items="${list}" var="para" varStatus="status">
							 <tr class="btbj" id="hang" style="height:20px">
								<td  height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.date}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.cdzwjh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.cdzwsj}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.whzwjh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.whzwsj}</div></td>
								
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.cdfzjh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.cdfzsj}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.whfzjh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.whfzsj}</div></td>
										
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.cdwhjh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.cdwhsj}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.whwhjh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.whwhsj}</div></td>
										
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.cdjhjh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.cdjhsj}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.whjhjh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.whjhsj}</div></td>
										
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.cdshjh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.cdshsj}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.whshjh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.whshsj}</div></td>
								
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.cdjyjh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.cdjysj}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.whjyjh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.whjysj}</div></td>														
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="25">
								<div align="center">
							<a	href="<%=path%>/jhsx.action?currentPage=${previousPage}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/jhsx.action?currentPage=${nextPage}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
								</div></td>
								<c:if test="${role=='6'}"> <!-- 主任、参数维护岗、系统管理员 -->
								<td align="center" colspan="2">
								<a	href="<%=path%>/page/control/jhsxadd.jsp">新增</a> 	
								</td>
								</c:if>
						</tr>
						</table>
						</form>
  </body>
</html>
