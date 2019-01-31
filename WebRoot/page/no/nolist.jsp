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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
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
.qq td{
background-color: #ffffff;
}
-->
</style>
<script type="text/javascript">
//删除用户
function deleteUserItem(o,i,f){
	//alert(o);
	//alert(i);
	//删除提示
	if (window.confirm("确认删除员工【"+o+"】的信息？员工登陆权限同时被删除，删除后无法还原!")) {
		with(document.forms[0]) {
			window.location = "<%=path%>/nodelete.action?id="+i;
		}
	}	
}
 $(document).ready(function(){ 
$(".btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px" }); 
$(".btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px" }); 

	var x=document.getElementsByName("para");
	$('#zx').attr('value',x[0].value);
	$('#chu').attr('value',x[1].value);
});
// 导出excel
	function expressout()
	{
		var zx = document.getElementById("zx").value;
		var chu = document.getElementById("chu").value;	
		var keyword = document.getElementById("keyword").value;	
		window.location = "<%=path%>/noexpress.action?zx="+zx+"&chu="+chu+"&keyword="+keyword;
	}

	
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <form action="<%=path%>/nolist.action" method="post" name="fm1">
  <table align="center" id="ghbs" >
						<tr class="qq">
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="9" align="center" bordercolor="#FFFFFF"><b>操作员人员工号表</b>
							</td>
						</tr>
						<tr height="50px" class="qq" align="center">
							<td colspan="9">
									中心
								
								<select id="zx" name="zx"
								style="width: 100px" >
								<option value="2">全部</option>
								<option value="0">成都中心</option>
								<option value="1">武汉中心</option>
							</select>处室
								
								<select id="chu" name="chu"
								style="width: 120px">
								<option value="0">全部</option>
								<option value="1">综合与生产管理处</option>
								<option value="2">合规与监督二处</option>
								<option value="3">通用业务二处</option>
								<option value="5">研发支持二处</option>
								<option value="6">专业处理二处</option>
							</select>	
							
							搜索关键字
								<input id="keyword" style="width: 60px" type="text" name="keyword" value="${strtemp}"/>
								
									<input type="submit" value="查询"/>
									<input type="hidden" name="para" value="${zx}"/>
									<input type="hidden" name="para" value="${chu}"/>
									<input type="hidden" name="" value="${strtemp}"/>
									<input type="hidden" name="show" value="${show}"/>
								<c:if test="${show=='mng'}">
								<c:if test="${zhi=='0'||zhi=='1'||role=='6'||role=='7'||role=='9'}"> 
								<input type="button" value="导出" onclick="expressout()"/>
								</c:if>
								</c:if>	
						</tr>
						
						<tr height="40px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>新一代编号</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>COST工号</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>中心</p>
								</div></td>		
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>处室</p>
								</div></td>
							<td width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>人员性质</p>
								</div></td>		
							<td width="300px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>人员属性</p>
								</div></td>	
							<c:if test="${show=='mng'}">
							<td  width="100px"align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>
							</c:if>		
						</tr>
							 <c:forEach items="${list}" var="no" varStatus="status">
							 <tr <c:if test="${status.count%2==0}">class="c_ghbs1"</c:if> 
							      <c:if test="${status.count%2!=0}">class="c_ghbs2"</c:if>  style="height:20px">
								<td  height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${no.name}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${no.newnumber!='00000000'}">${no.newnumber}</c:if>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${no.no891}</div></td>				
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:zxToString(no.zx)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:cToString(no.position)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:xzToShortString(no.xz)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:shuxingtomiaosu(no.no2,no.source)}</div></td>
								<c:if test="${show=='mng'}">		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center"><c:if test="${role=='6'}"> <input type="button" onclick="location='<%=path%>/nobeforeupdate.action?id=${no.id}'" value="修改"/><input type="button" onclick="deleteUserItem('${no.name}',${no.id},'${no.remark1}')" value="删除"/></c:if></div></td>
								</c:if>
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="8">
								<div align="center">
								<a	href="<%=path%>/nolist.action?zhuan=1&currentPage=${previousPage}&zx=${zx}&chu=${chu}&keyword=${strtemp}&show=${show}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/nolist.action?zhuan=1&currentPage=${nextPage}&zx=${zx}&chu=${chu}&keyword=${strtemp}&show=${show}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
									&nbsp;&nbsp;&nbsp;
								第<input style="width:30px" type="text" name="currentPage"/>页
								<input type="submit" value="跳转"/>	
								</div></td>
								<td colspan="1">
								<c:if test="${show=='mng'}">
								<c:if test="${role=='6'}"> 
								<a	href="<%=path%>/page/no/noimport.jsp">导入全量操作员基础信息</a><br/>
									<a	href="<%=path%>/nobeforeadd.action">增加一个操作员</a>
									</c:if>
								</c:if>	
								</td>
						</tr>
						</table>
						</form>
  </body>
</html>
