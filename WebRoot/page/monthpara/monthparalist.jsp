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
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "UTF-8"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
 <style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #ffffff;
}
-->
</style>
<script type="text/javascript">
 $(document).ready(function(){ 
$(".btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px" }); 
$(".btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px" }); 

});
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <form action="<%=path%>/nolist.action" method="post" name="fm1">
  <table align="center"  style="width:200px"  >
						<tr >
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="22" align="center"   bordercolor="#FFFFFF"><b>产量质量目标值</b>
							</td>
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang" >
							<td  width="50px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>月份</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>行内人员当月产量目标值</p>
								</div></td>		
							<td  width="100px" align="center" valign="middle" nowrap 
								bordercolor=none><div align="center">
									<p>行内人员当月质量目标值</p>
								</div></td>		
					<!-- 		<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>外包人员当月产量目标值</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>外包人员当月质量目标值</p>
								</div></td>	 -->
							<c:if test="${role=='6'}"> <!-- 主任、参数维护岗、系统管理员 -->	
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>
								</c:if>
						</tr>
							 <c:forEach items="${list}" var="para" varStatus="status">
							 <tr class="btbj" id="hang" style="height:20px">
								<td  height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.month}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.hnCl}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.hnZl}</div></td>
						<!--    <td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.wbCl}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${para.TBz}</div></td> -->
										<c:if test="${role=='6'}"> <!-- 主任、参数维护岗、系统管理员 -->		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center"><a href="<%=path%>/monthpara.action?type=to_update&id=${para.id}">修改</a> </div></td>
										</c:if>
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="4">
								<div align="center">
							<a	href="<%=path%>/monthparafindall.action?currentPage=${previousPage}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/monthparafindall.action?currentPage=${nextPage}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
								</div></td>
								<c:if test="${role=='6'}"> <!-- 主任、参数维护岗、系统管理员 -->
								<td>
								<a	href="<%=path%>/page/monthpara/monthparaadd.jsp?month=${month}" style="padding-right: 30px;color: #104E8B">新增一条</a> 	
								</td>
								</c:if>
						</tr>
						</table>
						</form>
  </body>
</html>
