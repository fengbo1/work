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
.ddd {
	display:inline;
}
p {
	margin: 0px;
	padding: 0px;
	}
-->
</style>
<script type="text/javascript">
 $(document).ready(function(){ 
$(".btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px" }); 
$(".btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px" }); 

	var x=document.getElementsByName("para");
	$('#zx').attr('value',x[0].value);
	$('#team').attr('value',x[1].value);
	$('#xz').attr('value',x[2].value);
	$('#key').attr('value',x[3].value);
	$('#sequence').attr('value',x[4].value);
	$('#keytb').attr('value',x[5].value);
});
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  <body>
	<form action="<%=path%>/express.action" method="post" name="fm1">
  <table align="center" style="" >
  	<tr>
			<td>
					<table  align="center" cellpadding="0"	cellspacing="2">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 0px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="27" align="center" bordercolor="#FFFFFF"><b>${time}日报</b>									
							</td>
						</tr>
						<tr>
						</tr>
						<tr >
							<td colspan="27" style="padding-left: 0px"  align="left" height="10">
							<div class="ddd" align="left">日期</div>
							<div class="ddd" align="left" style="">
								<input size="9" type="text" name="time" id="time" class="Wdate" value="${time}" onClick="WdatePicker()" >
							</div>
							<div class="ddd" align="left">中心</div>
							<div class="ddd" align="left">
								<select id="zx" name="zx" style="width: 80px" >
								<option value="2">全部</option>
								<option value="0">成都中心</option>
								<option value="1">武汉中心</option>
							    </select>
							</div>    
							<div class="ddd" align="left">小组</div>	
							<div class="ddd" align="left">
						    	<select id="team" name="team" style="width: 90px">
								<option value="0">全部</option>
								<option value="1">业务处理1组</option>
								<option value="2">业务处理2组</option>
								<option value="3">业务处理3组</option>
								<option value="4">专业处理1组</option>
								<option value="5">专业处理2组</option>
								<option value="6">专业处理3组</option>
								<option value="7">稽核业务团队</option>
								</select>
							</div>	
							<div class="ddd" align="left">性质</div>
							<div class="ddd" align="left">
								<select id="xz" name="xz" style="width: 80px">
								<option value="4">全部</option>
								<option value="5">行内人员</option>
								<option value="3">外包人员</option>
								<option value="0">专职生产人员</option>
								<option value="1">其他生产人员</option>
								</select>
							</div>
							 <c:if test="${zhi=='0'||zhi=='1'||role=='6'||role=='7'||role=='9'}">	
							<div class="ddd" align="left">查关键字</div>
							<div class="ddd" align="left">	
								<input id="keyword" style="width: 60px" type="text" name="keyword" value="${strtemp}"/>
							</div>
							</c:if>
							<div class="ddd" align="left">按</div>
							<div class="ddd" align="left">	
								<select id="key" name="key"	style="width: 170px">
								<option value="wu">请选择指标项</option>
								<option value="no">工号</option>
								<option value="ljrjcl">当月日均产量</option>
								<option value="rjccl891">当月账务类日均差错率</option>
								<option value="ljqdlrzl">当月日均转网点率</option>
								<option value="rjtpl891">当月账务类日均退票率</option>
								<option value="ljcl">当月累计产量</option>
								<option value="output">当日折合产量</option>
								<option value="output891">当日账务类折合产量</option>
								<option value="output895">当日非账务折合产量</option>
								<option value="lrxg">当日账务类录入修改任务量</option>
								<option value="lrsq">当日账务类录入授权任务量</option>
								<option value="ccl891">当日账务类差错率</option>
								<option value="cxl891">当日账务类查询率</option>
								<option value="tpl891">当日账务类退票率</option>
								<option value="team">专业处理分组</option>
								</select>
							</div>
							<div class="ddd" align="left">
								<select id="sequence" name="sequence" style="width: 60px">
								<option value="1">倒序</option>
								<option value="0">正序</option>
							    </select>	
							</div>
							<div class="ddd" align="left">
									<input type="submit" value="查询"/>
									<input type="hidden" name="para" value="${zx}"/>
									<input type="hidden" name="para" value="${team}"/>
									<input type="hidden" name="para" value="${xz}"/>
									<input type="hidden" name="para" value="${key}"/>
									<input type="hidden" name="para" value="${sequence}"/>
									<input type="hidden" name="para" value="${keytb}"/>
							</div>
				<div class="ddd"  style="font-size: 13px; ;font-family: '宋体'">截至${temptime}两中心累计人均产量<span style="color:red;">${percl}</span></div>
							
							</td>	
						</tr>
						<tr  class="表格表头背景1" id="hang" height="13px">
						<td    width="34" rowspan="3">
						  <div align="center">
								  <p>序号</p>
					      </div></td>
						<td width="40" rowspan="3">
						  <div align="center">
								  <p>是否达标</p>
					      </div></td>
						<td width="35" rowspan="3"><div align="center">
							    <p>工号</p>
					      </div></td>
						<td width="48" rowspan="3"><div align="center">
								  <p>姓名</p>
					      </div></td>
						<td height="30" colspan="9"><div align="center"><p>当日数据</p> </div></td>
						<td colspan="9"><div align="center" ><p>当月日均数据</p> </div></td>
						<td width="41" rowspan="3"><div align="center">
								<p>当月累计上线天数</p>
						  </div></td>
						<td width="40" rowspan="3"><div align="center">
								<p>中心</p>
						  </div></td>
						<td width="40" rowspan="3"><div align="center">
								<p>性质</p>
						  </div></td>
						<td width="64" rowspan="3"><div align="center">
								<p>分组</p>
						  </div></td>						
						</tr>
						<tr  class="表格表头背景1" id="hang">
						<td width="41" rowspan="2"><div align="center">
								<p><font size=2>折合产量</font></p>
						  </div></td>
						<td width="41" rowspan="2"><div align="center">
								<p><font size=2>作业差错率</font></p>
						  </div></td>
						<td width="41" rowspan="2"><div align="center">
								<p><font size=2>单位产能作业时间</font></p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p><font size=2>差错率</font></p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p><font size=2>查询率</font></p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p><font size=2>退票率</font></p>
						  </div></td>
						<td width="40" rowspan="2"><div align="center">
								<p><font size=2>折合产量</font></p>
						  </div></td>
						<td width="56" rowspan="2"><div align="center">
								<p><font size=2>折合产量<br>完成率</font></p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p><font size=2>差错率</font></p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p><font size=2>查询率</font></p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p><font size=2>退票率</font></p>
						  </div></td>
						<td width="41" rowspan="2"><div align="center">
								<p><font size=2>转网点率</font></p>
						  </div></td>  
						</tr>
						<tr  class="表格表头背景1" id="hang">
							<td  height="20" width="41" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>账务类</font></p>
								</div></td>
							<td  height="20" width="41" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>非账务</font></p>
								</div></td>
							<td  height="20" width="41" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>账务类</font></p>
								</div></td>
							<td  height="20" width="41" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>非账务</font></p>
								</div></td>	
							<td  height="20" width="41" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>账务类</font></p>
								</div></td>
							<td  height="20" width="41" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>非账务</font></p>
								</div></td>
							<td  height="20" width="42" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>账务类</font></p>
								</div></td>
							<td  height="20" width="42" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>非账务</font></p>
								</div></td>
							<td  height="20" width="42" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>账务类</font></p>
								</div></td>
							<td  height="20" width="42" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>非账务</font></p>
							</div></td>		
							<td  height="20" width="42" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>账务类</font></p>
								</div></td>
							<td  height="20" width="42" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>非账务</font></p>
								</div></td>	
							<!--  -->
							<!--  -->						</tr>
						</table>
				</td>
			</tr>
			<tr >
				<td >
				<div id="scroll" align="center" style="overflow-y: scroll; overflow-x: hidden; height: 455px; ">
						<table  align="center" id="ghbs" cellpadding="0">
						 
							 <c:forEach items="${list}" var="hn" varStatus="status">
							 <tr <c:if test="${status.count%2==0}">class="c_ghbs1"</c:if> 
							      <c:if test="${status.count%2!=0}">class="c_ghbs2"</c:if> style="height:20px">
								<td  width="34px" height="25" align="center" valign="middle" ><div
										align="center">${status.index+1}</div></td>
								<td width="40px" height="25" align="center" valign="middle" ><div
										align="center">${hn.zyzl}</div></td>		
								<c:if test="${zhi=='0'||zhi=='1'||role=='6'||role=='7'||role=='9'||hn.no==no891||(zu==hn.remarkteam&&role=='10')}">
								<td width="35px" height="25" align="center" valign="middle" ><div
										align="center"><p style="font-size: ${fb:nofontsize(hn.no)}px;">${hn.no}</p></div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div
										align="center">${hn.name}</div></td>
								</c:if>
								<c:if test="${zhi!='0'&&zhi!='1'&&role!='6'&&role!='7'&&role!='9'&&hn.no!=no891&&(zu!=hn.remarkteam||role!='10')}">
								<td width="35px" height="25" align="center" valign="middle" ><div
										align="center">**</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div
										align="center">**</div></td>
								</c:if>
								<td width="41px" height="25" align="center" valign="middle" ><div
										align="center">${hn.output}</div></td>	
								<td width="42px" height="25" align="center" valign="middle" ><div
										align="center">${hn.zyccl}</div></td>
								<td width="42px" height="25" align="center" valign="middle" ><div
										align="center">${hn.percltime}</div></td>				
								<td width="41px" height="25" align="center" valign="middle" ><div
										align="center">${hn.ccl891}</div></td>
								<td width="41px" height="25" align="center" valign="middle" ><div
										align="center">${hn.ccl895}</div></td>		
								<td width="41px" height="25" align="center" valign="middle" ><div
										align="center">${hn.cxl891}</div></td>
								<td width="41px" height="25" align="center" valign="middle" ><div
										align="center">${hn.cxl895}</div></td>		
								<td width="41px" height="25" align="center" valign="middle" ><div
										align="center">${hn.tpl891}</div></td>
								<td width="41px" height="25" align="center" valign="middle" ><div
										align="center">${hn.tpl895}</div></td>				
								<td width="41px" height="25" align="center" valign="middle" ><div
										align="center">${hn.ljrjcl}</div></td>
								<td width="56px" height="25" align="center" valign="middle" ><div
										align="center">${hn.rjclwcl}</div></td>
								<td width="42px" height="25" align="center" valign="middle" ><div
										align="center">${hn.rjccl891}</div></td>
								<td width="42px" height="25" align="center" valign="middle" ><div
										align="center">${hn.rjccl895}</div></td>		
								<td width="42px" height="25" align="center" valign="middle" ><div
										align="center">${hn.rjcxl891}</div></td>
								<td width="42px" height="25" align="center" valign="middle" ><div
										align="center">${hn.rjcxl895}</div></td>		
								<td width="42px" height="25" align="center" valign="middle" ><div
										align="center">${hn.rjtpl891}</div></td>
								<td width="42px" height="25" align="center" valign="middle" ><div
										align="center">${hn.rjtpl895}</div></td>		
								<td width="42px" height="25" align="center" valign="middle" ><div
										align="center">${hn.ljqdlrzl}</div></td>		
								<td width="41px" height="25" align="center" valign="middle" ><div
										align="center">${hn.ljsxts}</div></td>
								<td width="41px" height="25" align="center" valign="middle" ><div
										align="center">${hn.zx}</div></td>
								<td width="41px" height="25" align="center" valign="middle" ><div
										align="center">${hn.xz}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div
										align="center">${hn.team}</div></td>
												
							</tr>
							</c:forEach>
							
						</table>
					</div>
				</td>
			</tr>
	
	<!-- <tr ><td align="center" style="font-size: 13px; ;font-family: '宋体'">★★表示当月累计日均产量高于两中心专业处理人员累计人均产量(含)且累计日均差错率低于0.3%(含)&nbsp;★表示当月累计日均产量高于两中心专业处理人员累计人均产量(含)或累计日均差错率低于0.3%(含)</td></tr> -->
	<tr ><td align="center" style="font-size: 13px; ;font-family: '宋体'">注：产量达标指当月日均产量>=两中心专业处理人员人均产量，质量达标指当月日均差错率<=0.3%。★★表示双项达标，★表示单项达标</td></tr>
				
		</table>
		</form>
  </body>
</html>
