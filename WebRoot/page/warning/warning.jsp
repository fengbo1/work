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
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "UTF-8"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>业务提示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link href="<%=path%>/css/buttons.css" rel="stylesheet" type="text/css">
  <style type="text/css">
  .aa td div strong {
	color: #39F;
	font-size: 24px;
}
  .a {
	font-size: 16px;
	color: #F00;
	font-weight: bold;
	text-align: right;
}
  .jindu {
	font-weight: bold;
}
  .ziti {
	font-size: 13px;
	font-weight: bold;
}
  .qq {
	color: #F00;
	font-weight: bold;
}
.back1{

background-color:#C0D3FD;
height:30px;
font-size: 14px;
}
.back2{

background-color:#F0F0F0;
height:30px;
font-size: 14px;
}
td font{
font-weight:800;
width:50px;
margin:0px;
padding:0px;
}
.td1{
text-align:right;
width:140;
}
.td2{
text-align:left;
width:270;

}
.td3{
text-align:left;
width:210;
}
.ddd {
	display:inline;
}

  </style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "UTF-8"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(document).ready(function(){ 
$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
});
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
<body>
  <table align="center" style="height:500px" border="0px" >
    

<tr><td>
				<form action="<%=path%>/warning.action" method="post" name="fm1">
					<table  align="left" cellpadding="0" border="0px">
						<tr>
							<td	style="color: #1778C2; padding-top: 0px; padding-bottom: 0px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="14" align="center" bordercolor="#FFFFFF"><b>${date.replace("-","")}汇总简报</b>
							</td>
						</tr>
						<tr><td colspan="14" align="center" height="10px">							
							<div align="center" >日期&nbsp;
								<input type="text" size="10" name="date" id="date" class="Wdate" value="${date}" onClick="WdatePicker()" >&nbsp;
								<input type="submit" value="查询"/>
							</div>
							</td>
						</tr>
						<tr  class="表格表头背景1" id="hang" >
						<td rowspan="2" height="60px" width="120px" nowrap><div align="center" ><p>指标名称</p></div></td>
							<td colspan="7" height="30px" width="360px" nowrap="nowrap">
							<div align="center" ><p>折合产量</p></div></td>
							
							<td colspan="2" height="30px" width="100px" nowrap><div align="center">
								<p>作业差错率</p></div></td>
							
							<td colspan="2" height="30px" width="100px" nowrap><div align="center">
								<p>人民币业务退票率</p></div></td>
							
							<td colspan="2" height="30px" width="100px" nowrap><div align="center">
								<p>人民币查询查复率</p></div></td>
						<!-- 	
							<td  colspan="2" height="30px" width="100px" nowrap><div align="center">
								<p>人民币转网点率</p></div></td> -->
						</tr>
						<tr class="表格表头背景1" id="hang" height="30px" >
							<td  width="50px" height="30px" align="center" valign="middle"   nowrap
								bordercolor=black><div align="center" >
									<p><font size=2>当月日均</font></p>
								</div></td>
							<td  height="30px" width="50px" align="center" valign="middle" nowrap
								bordercolor=black ><div align="center">
									<p><font size=2>当日</font></p>
								</div></td>
							<td  height="30px" width="50px" align="center" valign="middle" nowrap
								bordercolor=black ><div align="center">
									<p><font size=2>当日人民币</font></p>
								</div></td>	
							<td  height="30px" width="50px" align="center" valign="middle" nowrap
								bordercolor=black ><div align="center">
									<p><font size=2>当日外汇</font></p>
							</div></td>	
								<td  height="30px" width="50px" align="center" valign="middle" nowrap
								bordercolor=black ><div align="center">
									<p><font size=2>当日稽核</font></p>
								</div></td>	
							<td  height="40px" width="50px" align="center" valign="middle" nowrap
								bordercolor=black ><div align="center">
									<p><font size=2>当日反洗钱</font></p>
								</div></td>	
							<td  height="30px" width="50px" align="center" valign="middle" nowrap
								bordercolor=black ><div align="center">
									<p><font size=2>当日建亚</font></p>
								</div></td>				
							<td  width="50px" height="30px" align="center" valign="middle" nowrap  
								bordercolor=black><div align="center">
									<p><font size=2>当月日均</font></p>
								</div></td>
							<td  height="30px" width="50px" align="center" valign="middle" nowrap
								bordercolor=black ><div align="center">
									<p><font size=2>当日</font></p>
								</div></td>
							<td width="50px" height="30px" align="center" valign="middle"   nowrap
								bordercolor=black><div align="center">
									<p><font size=2>当月日均</font></p>
								</div></td>
							<td  height="30px" width="50px" align="center" valign="middle" nowrap
								bordercolor=black ><div align="center">
									<p><font size=2>当日</font></p>
								</div></td>
							<td width="50px" height="30px" align="center" nowrap bordercolor=black>
							<div align="center">
									<p><font size=2>当月日均</font></p>
								</div></td>
							<td  height="30px" width="50px" align="center" valign="middle" nowrap
								bordercolor=black ><div align="center">
									<p><font size=2>当日</font></p>
								</div></td>
							<!-- 	
							<td width="50px" height="30px"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
									<p><font size=2>当月日均</font></p>
								</div></td>
							<td  height="30px" width="30px" align="center" valign="middle" 
								bordercolor=black ><div align="center">
									<p><font size=2>当日</font></p>
								</div></td>	
							-->	
						</tr>
						
						 <c:forEach items="${list}" var="summary" varStatus="status">
							  <tr  
							
							      <c:if test="${status.count%2==0}">class="c_ghbs1"</c:if> 
							      <c:if test="${status.count%2!=0}">class="c_ghbs2"</c:if>  >
							    <td><div align="center" ><font color=black style="width:100px"><strong>${summary.jg}${summary.type}</strong></font></div></td>
							    <td width="50px" height="25" align="center" valign="middle" nowrap>${fb:doubleto0integer(summary.clAver)}</td>
							    <td width="50px" height="25" align="center" valign="middle" nowrap>${fb:doubleto0integer(summary.clDay)}</td>
								<td width="50px" height="25" align="center" valign="middle" nowrap>${fb:doubleto0integer(summary.clDayRmb)}</td>
								<td width="50px" height="25" align="center" valign="middle" nowrap>${fb:doubleto0integer(summary.clDayWh)}</td>
								<td width="50px" height="25" align="center" valign="middle" nowrap>${fb:doubleto0integer(summary.clDayJh)}</td>
								<td width="50px" height="25" align="center" valign="middle" nowrap>${fb:doubleto0integer(summary.clDayFxq)}</td>
								<td width="50px" height="25" align="center" valign="middle" nowrap>${fb:doubleto0integer(summary.clDayJy)}</td>
								<td width="50px" height="25" align="center" valign="middle" nowrap>${fb:doubledoubletolv(summary.clAver,summary.zycclAver)}</td>
								<td width="50px" height="25" align="center" valign="middle" nowrap>${fb:doubledoubletolv(summary.clDay,summary.zycclDay)}</td>
								<td width="50px" height="25" align="center" valign="middle" nowrap>${fb:doubledoubletolv(summary.clAver,summary.zytplAver)}</td>
								<td width="50px" height="25" align="center" valign="middle" nowrap>${fb:doubledoubletolv(summary.clDay,summary.zytplDay)}</td>
								<td width="50px" height="25" align="center" valign="middle" nowrap>${fb:doubledoubletolv(summary.clAver,summary.zycxlAver)}</td>	
								<td width="50px" height="25" align="center" valign="middle" nowrap>${fb:doubledoubletolv(summary.clDay,summary.zycxlDay)}</td>
								<!-- 
								<td width="30px" height="25" align="center" valign="middle" nowrap>${fb:doubletopercent(summary.zwd)}</td>
								<td width="30px" height="25" align="center" valign="middle" nowrap>${fb:doubletopercent(summary.ljzwd)}</td>
							-->
							</tr>
							</c:forEach>
							</table>
					</form>
				</td>
			</tr>
			
<tr>
			<td>
<br/>
<table width="600"  border="0px" cellspacing="0" style="margin-top:10">
	<tr class="aa">
	<td></td>
		<td	style="color: #1778C2; padding-top: 0px; padding-bottom: 0px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="3" align="center" bordercolor="#FFFFFF">
			<b><s:property value="y_time"/>&nbsp;&nbsp;指标提示</b>
			<s:if test='y_lv=="1"||y_cl=="1" ||lv891_cd > lv891_wh'>
				<a class="button small blue" href="<%=path%>/page/report/summarydaily.action">点击查看详细指标</a>
			</s:if>
		</td>
		
    </tr>
    	
	<tr class="back1">    
		<td class="td1" >
			​当日产量占比：
		</td>		
		<td class="td2"> 
			成都中心&nbsp;<font><s:property value="q_cl_cd"/>%</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;武汉中心&nbsp;<font><s:property value="q_cl_wh"/>%</font>
		</td>			
		<td class="td3">
			<s:if test='y_cl=="1"'><span style="color:red;">产量占比超过设定范围</span></s:if>
			<s:if test='y_cl=="-1"'><span style="color:red;">产量占比低于设定范围</span></s:if>
			<s:if test='y_cl=="0"' >产量占比未超过设定范围</s:if>
		</td>	
	</tr>
	<tr class="back2">    
		<td class="td1" >
			当月累计​产量占比：
		</td>		
		<td class="td2"> 
			成都中心&nbsp;<font><s:property value="cd_lj_zb"/>%</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;武汉中心&nbsp;<font><s:property value="wh_lj_zb"/>%</font>
		</td>			
		<td>
		</td>	
	</tr>
	<tr class=back1>
		<td class=td1>
			当日人员占比：
		</td>
		<td> 
			成都中心&nbsp;<font><s:property value="q_rs_cd"/>%</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;武汉中心&nbsp;<font><s:property value="q_rs_wh"/>%</font>
		</td>
		<td>	 
			
		</td> 
    </tr>
	
	<tr class=back2>
		<td class=td1>
			当月累计人员占比：
		</td>
		<td>
			成都中心&nbsp;<font><s:property value="cdljzb"/>%</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;武汉中心&nbsp;<font><s:property value="whljzb"/>%</font>
		</td>
	 	<td>
	 	</td>	
	</tr>
	<tr class=back1>
		<td class=td1>
			差错率：
		</td>
		<td>
			成都中心&nbsp;<font><s:property value="lv891_cd"/>%</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;武汉中心&nbsp;<font><s:property value="lv891_wh"/>%</font>
		</td>
	 	<td>
	 		<s:if test='y_lv=="1"'><span style="color:red;">差错率超过设定范围</span></s:if>
	 		<s:if test='y_lv=="0"'>差错率未超过设定范围</s:if>
	 		<s:if test="lv891_cd > lv891_wh"><span style="color:red;"><br>成都差错率高于武汉差错率</span></s:if>
	 	</td>	
    </tr>
</table>
</td></tr>
<tr><td>
<br/>
<table width="1080px" border="0" cellpadding="0" cellspacing="0" style="margin-top:10">
	<tr class="aa">
	<td	style="color: #1778C2; padding-top: 0px; padding-bottom: 0px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="5" align="center" bordercolor="#FFFFFF"><b><s:property value="bbzt_time"/>报表加工进度</b>
	</td>
    </tr>
  <tr>
    <s:if test='ds.hnonline>0'>
    <td width="110" height="30" align="center" valign="top" class="ziti"><span class="ziti">&nbsp;&nbsp;&nbsp;人员上线情况&nbsp;</span></td>
    </s:if>
    
   
    
    <s:if test='ds.hnjihe>0'>
    <td width="110" align="center" valign="top" class="ziti"><span class="ziti"><span class="ziti">&nbsp;&nbsp;&nbsp;稽核报表生成&nbsp;</span></span></td>
    </s:if>
    
    <s:if test='ds.hnfxq>0'>
    <td width="110" align="center" valign="top" class="ziti"><span class="ziti"><span class="ziti">&nbsp;&nbsp;&nbsp;反洗钱报表生成&nbsp;</span></span></td>
    </s:if>
    <s:if test='ds.hnx13>0'>
    <td width="110" align="center" valign="top" class="ziti"  style="display:"><span class="ziti"><span class="ziti">&nbsp;&nbsp;&nbsp;人民币报表生成&nbsp;</span></span></td>
    <td width="110" align="center" valign="top" class="ziti"  style="display:"><span class="ziti"><span class="ziti">&nbsp;&nbsp;&nbsp;外汇报表生成&nbsp;</span></span></td>
    <td width="110" align="center" valign="top" class="ziti"  style="display:"><span class="ziti"><span class="ziti">&nbsp;&nbsp;&nbsp;建亚报表生成&nbsp;</span></span></td>
    </s:if>
   
    <s:if test='ds.hnwhbb>0'>
    <td width="110" align="center" valign="top" class="ziti"><span class="ziti"><span class="ziti">&nbsp;&nbsp;&nbsp;武汉数据导入&nbsp;</span></span></td>
    <td width="110" valign="top">&nbsp;</td>
    </s:if>
   
    <td width="110" valign="top">&nbsp;</td>
    <td width="110" valign="top">&nbsp;</td>
    <td width="110" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <s:if test='num>0'>
    <td bgcolor="#D8D8FE">&nbsp;</td></s:if>
   
    <s:if test='num>1'>
    <td bgcolor="#A5A5FB">&nbsp;</td></s:if>
   
     <s:if test='num>2'>
     <td bgcolor="#6BA5FA">&nbsp;</td></s:if>
     
      <s:if test='num>3'>
    <td bgcolor="#6B6CFA">&nbsp;</td></s:if>
    
     <s:if test='num>4'>
    <td bgcolor="#356CFA">&nbsp;</td></s:if>
    
     <s:if test='num>5'>
     <td bgcolor="#3534FA">&nbsp;</td></s:if>
   
     <s:if test='num>6'>
     <td bgcolor="#0304B4">&nbsp;</td>
      <td align="right">报表生成成功</td>
      <td align="right">&nbsp;</td>
    <td align="right">&nbsp;</td>
    <td align="right">&nbsp;</td>
     </s:if>
   
  </tr>
  <tr>
 	 <s:if test='num>0'>
     <td height="30" align="center" valign="bottom">1/7</td></s:if>
   
    <s:if test='num>1'>
    <td height="30" align="center" valign="bottom">2/7</td></s:if>
   
     <s:if test='num>2'>
     <td height="30" align="center" valign="bottom">3/7</td></s:if>
     
      <s:if test='num>3'>
    <td height="30" align="center" valign="bottom">4/7</td></s:if>
    
     <s:if test='num>4'>
   <td height="30" align="center" valign="bottom">5/7</td></s:if>
    
     <s:if test='num>5'>
     <td height="30" align="center" valign="bottom">6/7</td></s:if>
     
     <s:if test='num>6'>
     <td height="30" align="center" valign="bottom">7/7</td></s:if>
  
  <!-- 
    <s:if test='ds.hnonline>0'>
    <td height="30" align="center" valign="bottom">15%</td></s:if>
   
    <s:if test='ds.hnycsh>0'>
    <td align="center" valign="bottom">30%</td></s:if>
  
    <s:if test='ds.hnx13>0'>
    <td align="center" valign="bottom">45%</td>
    <td align="center" valign="bottom">60%</td>
    <td align="center" valign="bottom">75%</td></s:if>
   
    <s:if test='ds.hnwhbb>0'>
    <td align="center" valign="bottom">80%</td></s:if>
   
    <s:if test='ds.hnjihe>0'><td align="center" valign="bottom">100%</td>
      <td>&nbsp;</td>
    </s:if>
    -->
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</td></tr>
</table>
</body>
</html>
