<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
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

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
});
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>用户管理</b>
							</td>
						</tr>
	
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>用户名</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>工号</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>	
																		
						</tr>
							<s:iterator value="list" status="L">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center"><s:property value="username"/></div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center"><s:property value="no"/></div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">&nbsp;
										<a href="<%=path%>/userinfo.action?type=del&ids=<s:property value="id"/>">删除</a>
										&nbsp;&nbsp;&nbsp;
										<!-- <a href="<%=path%>/userinfo.action?type=to_update&id=<s:property value="id"/>">修改</a> -->
											&nbsp;&nbsp;
											</div>
											</td>
							</tr>
							</s:iterator>
							<tr class="表格表头背景">
							<td colspan="3">
								<div align="center">
								<a	href="<%=path%>/user.action?type=find_all&currentPage=${previousPage}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/user.action?type=find_all&currentPage=${nextPage}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
								</div></td>
						</tr>
		</table>
		
  </body>
</html>
