<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>

<%@ page import="work.hndetail.pojo.*"%>
<%@ page import="work.hndetail.action.*"%>
<%@ page import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//ExpressReport er = new ExpressReport();
//ArrayList<HnDetail> hdlist = er.gethdList("20150103");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">

<html>
  <head>
    
    <title>汇总日报表</title>
    
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
.top_no{
padding-top:0px;


}
-->
</style>
<script type="text/javascript">
 $(document).ready(function(){ 

//$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
//$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" });

$("tr").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" });

$("tr[id='rs']").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"bold" });
$("tr[id='rwl']").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"bold" });
$("tr[id='zhcl']").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"bold" });
$("tr[id='rjcl']").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"bold" });
$("tr[id='lv']").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"bold" });
$("tr[id='xl']").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"bold" });

$("tr[id^='rs_']").fadeOut();
$("tr[id^='rwl_']").fadeOut();
$("tr[id^='zhcl_']").fadeOut();
$("tr[id^='rjcl_']").fadeOut();
$("tr[id^='lv_']").fadeOut();
$("tr[id^='xl_']").fadeOut();
});
 //rwl  hj_rs  zhcl  rjcl  lv  xl
 function clo(aa){
	 if(aa=='rwl')
	 {
		 $("tr[id^='rwl_']").fadeOut();
	 }
	 else if(aa=='rs')
	 {
		 $("tr[id^='rs_']").fadeOut();
	 }
	 else if(aa=='zhcl')
	 {
		 $("tr[id^='zhcl_']").fadeOut();
	 }
	 else if(aa=='rjcl')
	 {
		 $("tr[id^='rjcl_']").fadeOut();
	 }
	 else if(aa=='lv')
	 {
		 $("tr[id^='lv_']").fadeOut();
	 }
	 else if(aa=='xl')
	 {
		 $("tr[id^='xl_']").fadeOut();
	 }
	 }
 function ope(aa){
	 if(aa=='rwl')
	 {
		 $("tr[id^='rwl_']").fadeIn();
	 }
	 else if(aa=='rs')
	 {
		 $("tr[id^='rs_']").fadeIn();
	 }
	 else if(aa=='zhcl')
	 {
		 $("tr[id^='zhcl_']").fadeIn();
	 }
	 else if(aa=='rjcl')
	 {
		 $("tr[id^='rjcl_']").fadeIn();
	 }
	 else if(aa=='lv')
	 {
		 $("tr[id^='lv_']").fadeIn();
	 }
	 else if(aa=='xl')
	 {
		 $("tr[id^='xl_']").fadeIn();
	 }
	 }
 </script>

 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  <body>
	<form action="<%=path%>/summarydaily.action" method="post" name="fm1">
    <table align="center" style="height:500px" border="0px" >
    <tr>
			<td>
					<table  align="center" cellpadding="0" border="0px">
 						<tr>
							<td	style="color: #1778C2; padding-top: 0px; padding-bottom: 0px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="16" align="center" bordercolor="#FFFFFF"><b>${date.replace("-","")}汇总指标日报</b>
							</td>
						
						</tr>
						<tr><td colspan="16" align="center" height="10px">							
							<div align="center" >日期&nbsp;
								<input type="text" size="10" name="date" id="date" class="Wdate" value="${date}" onClick="WdatePicker()" >&nbsp;
								<input type="submit" value="查询"/>
							</div>
							</td>
						</tr>
						<tr height="30px" class="表格表头背景1" id="hang">
							<td colspan="7"><div align="center" >
								<font color=white size=4><strong>武汉中心</strong></font></div></td>
							<td colspan="6"><div align="center">
								<font color=white size=4><strong>成都中心</strong></font></div></td>
							<td colspan="3"><div align="center">
								<font color=white size=4><strong>合计</strong></font></div></td>
						</tr>
						
						<tr class="表格表头背景1" id="hang" height="50px" >
							<td  height="30px" width="122px" align="center" valign="middle" 
								bordercolor=none ><div align="center">
									<p>名称</p>
								</div></td>
							<td  class="top_no"width="72px" align="center" valign="top"  
								bordercolor=none><div align="center">
									<p>账务类<br/><font size=1>（COS_T系统导出数据）</font></p>
								</div></td>
							<td class="top_no" width="58px" align="center" valign="top" 
								bordercolor=none><div align="center">
									<p>账务类占比</p>
								</div></td>
							<td class="top_no" width="72px" align="center" valign="top" 
								bordercolor=none><div align="center">
									<p>非账务类<br/><font size=1>（COS_T系统导出数据）</font></p>
								</div></td>		
							<td class="top_no" width="58px" align="center" valign="top" 
								bordercolor=none><div align="center">
									<p>非账务类占比</p>
								</div></td>		
							<td class="top_no" width="72px" align="center" valign="top" 
								bordercolor=none><div align="center">
									<p>小计<br/><font size=1>（按实际生产人数统计）</font></p>
								</div></td>	
							<td class="top_no" width="65px" align="center" valign="top" 
								bordercolor=none><div align="center">
									<p>小计占比</p>
								</div></td>
							<td class="top_no" width="72px" align="center" valign="top" 
								bordercolor=none><div align="center">
									<p>账务类<br/><font size=1>（COS_T系统导出数据）</font></p>
								</div></td>
							<td class="top_no" width="58px" align="center" valign="top" 
								bordercolor=none><div align="center">
									<p>账务类占比</p>
								</div></td>
							<td class="top_no" width="72px" align="center" valign="top" 
								bordercolor=none><div align="center">
									<p>非账务类<br/><font size=1>（COS_T系统导出数据）</font></p>
								</div></td>	
							<td class="top_no" width="58px" align="center" valign="top" 
								bordercolor=none><div align="center">
									<p>非账务类占比</p>
								</div></td>		
							<td class="top_no" width="72px" align="center" valign="top" 
								bordercolor=none><div align="center">
									<p>小计<br/><font size=1>（按实际生产人数统计）</font></p>
								</div></td>	
							<td class="top_no" width="65px" align="center" valign="top" 
								bordercolor=none><div align="center">
									<p>小计占比</p>
								</div></td>
							<td class="top_no" width="72px" align="center" valign="top" 
								bordercolor=none><div align="center">
									<p>账务类<br/><font size=1>（COS_T系统导出数据）</font></p>
								</div></td>
							<td class="top_no" width="72px" align="center" valign="top" 
								bordercolor=none><div align="center">
									<p>非账务类<br/><font size=1>（COS_T系统导出数据）</font></p>
								</div></td>	
							<td class="top_no" width="84px" align="center" valign="top" 
								bordercolor=none><div align="center">
									<p>两任务池<br/><font size=1>(实际生产值）</font></p>
								</div></td>	
						</tr>
						</table>
				</td>
			</tr>
					<tr >
						<td style="padding-left:1px">
						<div id="scroll" align="center" style="overflow-y: scroll; overflow-x: hidden; height: 450px;">
						<table  align="center" border="0px" id="ghbs">
						
						 <c:forEach items="${list}" var="summary" varStatus="status">
						 <c:if test="${summary.remark1!='0'}">
						  
							 <tr id="${summary.itemCode}">
							     
								<td  width="118px" height="30" align="center" valign="middle" nowrap><div
										align="left"> <c:if test="${summary.itemCode=='rs'||summary.itemCode=='rwl'||summary.itemCode=='zhcl'||summary.itemCode=='rjcl'||summary.itemCode=='lv'||summary.itemCode=='xl'}"><b></c:if>
										 ${summary.itemName}<c:if test="${summary.itemCode=='rs'||summary.itemCode=='rwl'||summary.itemCode=='zhcl'||summary.itemCode=='rjcl'||summary.itemCode=='lv'||summary.itemCode=='xl'}">
										<br/>&nbsp;&nbsp;<a href="#" onclick="clo('${summary.itemCode}')">折叠</a>&nbsp;<a href="#" onclick="ope('${summary.itemCode}')">展开</a></b></c:if></div></td>
								<td width="71px" height="30" align="center" valign="middle" nowrap><div     
										align="center"><c:if test="${status.count==25}"><b></c:if>${fb:doubleaccordto(summary.wh891,summary.itemCode)}<c:if test="${status.count==25}"></b></c:if></div></td>
								<td width="57px" height="30" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletopercent(summary.wh891Zb)}</div></td>
								<td width="71px" height="30" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleaccordto(summary.wh895,summary.itemCode)}</div></td>
								<td width="58px" height="30" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletopercent(summary.wh895Zb)}</div></td>
								<td width="70px" height="30" align="center" valign="middle" nowrap><div
										align="center"><c:if test="${status.count==1||status.count==2||status.count==3||status.count==4}"><b></c:if>${fb:doubleaccordto(summary.whReal,summary.itemCode)}<c:if test="${status.count==1||status.count==2||status.count==3||status.count==4}"></b></c:if></div></td>
								<td width="65px" height="30" align="center" valign="middle" nowrap><div
										align="center"><c:if test="${status.count==1||status.count==16}"><b></c:if>${fb:doubletopercent(summary.whRealZb)}<c:if test="${status.count==1||status.count==16}"></b></c:if></div></td>	
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center"><c:if test="${status.count==25}"><b></c:if>${fb:doubleaccordto(summary.cd891,summary.itemCode)}<c:if test="${status.count==25}"></b></c:if></div></td>
								<td width="58px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletopercent(summary.cd891Zb)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleaccordto(summary.cd895,summary.itemCode)}</div></td>
								<td width="57px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletopercent(summary.cd895Zb)}</div></td>
								<td width="71px" height="25" align="center" valign="middle" nowrap><div
										align="center"><c:if test="${status.count==1||status.count==2||status.count==3||status.count==4}"><b></c:if>${fb:doubleaccordto(summary.cdReal,summary.itemCode)}<c:if test="${status.count==1||status.count==2||status.count==3||status.count==4}"></b></c:if></div></td>
								<td width="64px" height="25" align="center" valign="middle" nowrap><div
										align="center"><c:if test="${status.count==1||status.count==16}"><b></c:if>${fb:doubletopercent(summary.cdRealZb)}<c:if test="${status.count==1||status.count==16}"></b></c:if></div></td>
								<td width="72px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleaccordto(summary.total891,summary.itemCode)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleaccordto(summary.total895,summary.itemCode)}</div></td>
								<td width="66px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleaccordto(summary.totalReal,summary.itemCode)}</div></td>
												
							</tr>
							</c:if>
							</c:forEach>
							</table>
					</div>
				</td>
			</tr>
						</table>
		</form>
  </body>
</html>
