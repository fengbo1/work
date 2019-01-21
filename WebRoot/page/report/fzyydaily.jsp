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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>外包日报表</title>
    
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
}
.ddd {
	display:inline;
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
	<form action="<%=path%>/fzyydaily.action" method="post" name="fm1">
  <table align="center" style="height:299px" >
  	<tr>
				<td	style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="22" align="center" bordercolor="#FFFFFF"><b>${date.replace("-","")}辅助验印日报</b>
							</td>
						</tr>
						<tr height="20px">
							<td colspan="10" align="center">
							<div class="ddd" align="center">日期&nbsp;&nbsp;</div>
							<div class="ddd" align="center" style="width: 50px">
								<input size=10 type="text" name="date" id="date" class="Wdate" value="${date}" onClick="WdatePicker()" >&nbsp;&nbsp;
							</div>
						    <div class="ddd" align="center">
								<input type="submit" value="查询"/>
							</div>
						</td>	
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="51px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="140px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>公司名称</p>
								</div></td>
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>在线人数</p>
								</div></td>
							<td  width="65px" align="center" valign="middle" nowrap
								bordercolor=none ><div align="center">
									<p>人员占比</p>
								</div></td>		
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none style="padding-top:18px"><div align="center">
									<p>单笔时长<br><font size=2>(秒)</font></p>
								</div></td>		
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>工作量</p>
								</div></td>	
							<td  width="80px" align="center" valign="middle" nowrap
								bordercolor=none ><div align="center">
									<p>工作量占比</p>
								</div></td>
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none ><div align="center">
									<p>差错率</p>
								</div></td>
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none ><div align="center">
									<p>回收率</p>
								</div></td>
							<td  width="85px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>人均切片量</p>
								</div></td>		
							
						</tr>
			
							 <c:forEach items="${list}" var="wb" varStatus="status">
							 <tr class="btbj" id="hang" style="height:20px">
								<td  width="50px" height="30" align="center" valign="middle" nowrap><div
										align="center">${status.index+1}</div></td>
								<td width="140px" height="25" align="center" valign="middle" nowrap><div 
										align="center">${wb.corpname}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.online}</div></td>
								<td width="65px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletopercent(wb.onlineZb)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.avertime}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.cl}</div></td>
								<td width="80px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletopercent(wb.clZb)}</div></td>	
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubledoubletolv(wb.online,wb.ccl)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubledoubletolv(wb.online,wb.hsl)}</div></td>
								<td width="85px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0integer(wb.avevCl)}</div></td>							
								
							</tr>
							</c:forEach>
						</table>
					
		</form>
  </body>
</html>
