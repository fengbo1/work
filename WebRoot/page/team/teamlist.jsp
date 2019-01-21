<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

//$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
//$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" });
//$("tr.btbj:eq(0),tr.btbj:eq(4),tr.btbj:eq(8)").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" });
//$("tr.btbj:eq(1),tr.btbj:eq(2),tr.btbj:eq(3),tr.btbj:eq(5),tr.btbj:eq(6),tr.btbj:eq(7),tr.btbj:eq(9)").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
});
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  <form action="<%=path%>/team.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="24" align="center" bordercolor="#FFFFFF"><b>${time}分组指标</b>
							</td>
						</tr>
						<tr height="45px">
							<td colspan="24" align="center" >
							日期&nbsp;<input size=10 type="text" name="time" id="time" class="Wdate" value="${time}" onClick="WdatePicker()" >&nbsp;<input type="submit" value="查询"/><br/>
							<input type="checkbox" id="rmb" name="rmb" <c:if test="${rmb=='rmb'}">checked="checked"</c:if>  value="rmb"/>人民币板块&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="checkbox" id="wh" name="wh" <c:if test="${wh=='wh'}">checked="checked"</c:if> value="wh"/>外汇板块&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="checkbox" id="jh" name="jh" <c:if test="${jh=='jh'}">checked="checked"</c:if> value="jh"/>稽核板块&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="checkbox" id="jy" name="jy" <c:if test="${jy=='jy'}">checked="checked"</c:if> value="jy"/>建亚板块&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="checkbox" id="fxq" name="fxq" <c:if test="${fxq=='fxq'}">checked="checked"</c:if> value="fxq"/>反洗钱板块&nbsp;&nbsp;&nbsp;&nbsp;
							
							</td>	
						</tr>		
						<tr height="45px" class="表格表头背景1" id="hang">
							<td  width="100px" rowspan="2" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>分组</p>
								</div></td>
							<td  width="315px" colspan="6" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>当月日均折合产量</p>
								</div></td>
							<td  width="315px" colspan="6" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>当日人均折合产量</p>
								</div></td>	
							<td  width="180px" colspan="4" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>人均作业差错率</p>
								</div></td>	
							<td  width="180px" colspan="4" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>人均单位产能作业时间（秒）</p>
								</div></td>	
						</tr>
						<tr height="45px" class="表格表头背景1" id="hang">
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>合计</p>
								</div></td>
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>人民币</p>
								</div></td>
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>外汇</p>
								</div></td>
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>稽核</p>
								</div></td>
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>建亚</p>
								</div></td>	
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>反洗钱</p>		
								</div></td>
							
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>合计</p>
								</div></td>
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>人民币</p>
								</div></td>
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>外汇</p>
								</div></td>
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>稽核</p>
								</div></td>
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>建亚</p>
								</div></td>	
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>反洗钱</p>		
								</div></td>	
							
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>合计</p>
								</div></td>
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>人民币</p>
								</div></td>
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>外汇</p>
								</div></td>
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>建亚</p>
								</div></td>
							
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>合计</p>
								</div></td>
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>人民币</p>
								</div></td>
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>外汇</p>
								</div></td>
							<td  width="45px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>建亚</p>
								</div></td>		
						</tr>
							<c:forEach items="${teamlist}" var="team" varStatus="status">
							
							<tr class="btbj" id="hang"
							<c:if test="${team.bgcolor=='1'}"> style="height:20px;background-color:#bfd3fc;font-family:黑体;font-size:14px;font-weight:lighter"</c:if>
							
							 <c:if test="${team.bgcolor=='2'}"> style="height:20px;background-color:#F0F0F0;font-family:黑体;font-size:14px;font-weight:lighter"</c:if>
							 >
								<td height="35" align="center" valign="middle"><div
										align="center">
										<font size=2>${team.team}</font>
										</div></td>
										
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>${team.rjcl}</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${rmb=='rmb'}">${team.rjclrmb}</c:if>
										<c:if test="${rmb!='rmb'}">-</c:if>
										</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${wh=='wh'}">${team.rjclwh}</c:if>
										<c:if test="${wh!='wh'}">-</c:if>
										</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${jh=='jh'}">${team.rjcljh}</c:if>
										<c:if test="${jh!='jh'}">-</c:if>
										</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${jy=='jy'}">${team.rjcljy}</c:if>
										<c:if test="${jy!='jy'}">-</c:if>
										</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${fxq=='fxq'}">${team.rjclfxq}</c:if>
										<c:if test="${fxq!='fxq'}">-</c:if>
										</font>
										</div></td>
												
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>${team.cl}</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${rmb=='rmb'}">${team.clrmb}</c:if>
										<c:if test="${rmb!='rmb'}">-</c:if>
										</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${wh=='wh'}">${team.clwh}</c:if>
										<c:if test="${wh!='wh'}">-</c:if>
										</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${jh=='jh'}">${team.cljh}</c:if>
										<c:if test="${jh!='jh'}">-</c:if>
										</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${jy=='jy'}">${team.cljy}</c:if>
										<c:if test="${jy!='jy'}">-</c:if>
										</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${fxq=='fxq'}">${team.clfxq}</c:if>
										<c:if test="${fxq!='fxq'}">-</c:if>
										</font>
										</div></td>

								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>${team.ccl}</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${rmb=='rmb'}">${team.cclrmb}</c:if>
										<c:if test="${rmb!='rmb'}">-</c:if>
										</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${wh=='wh'}">${team.cclwh}</c:if>
										<c:if test="${wh!='wh'}">-</c:if>
										</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${jy=='jy'}">${team.ccljy}</c:if>
										<c:if test="${jy!='jy'}">-</c:if>
										</font>
										</div></td>
										
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>${team.xl}</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${rmb=='rmb'}">${team.xlrmb}</c:if>
										<c:if test="${rmb!='rmb'}">-</c:if>
										</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${wh=='wh'}">${team.xlwh}</c:if>
										<c:if test="${wh!='wh'}">-</c:if>
										</font>
										</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<font size=2>
										<c:if test="${jy=='jy'}">${team.xljy}</c:if>
										<c:if test="${jy!='jy'}">-</c:if>
										</font>
										</div></td>						
							</tr>
							</c:forEach>
		</table>
		</form>
  </body>
</html>
