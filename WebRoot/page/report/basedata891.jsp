<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

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
	$('#xz').attr('value',x[1].value);
	$('#key').attr('value',x[2].value);
	$('#sequence').attr('value',x[3].value);
});
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  <body>
	<form action="<%=path%>/hn891search.action" method="post" name="fm1">
  <table align="center" style="height:500px; " >
  	<tr>
			<td>
					<table  height="80" align="left" cellpadding="0" cellspacing="2">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 0px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="27" align="center" bordercolor="#FFFFFF"><b>${time}基础数据表891</b>
							</td>
						</tr>
						<tr  >
							<td colspan="27" height="10px">
								<div align="center">
									日期						
									<input size=10 type="text" name="time" id="time" class="Wdate" value="${time}" onClick="WdatePicker()" >
									中心								
							<select id="zx" name="zx" style="width: 100px" >
								<option value="2">全部</option>
								<option value="0">成都中心</option>
								<option value="1">武汉中心</option>
							</select>								
									人员性质
								<select id="xz" name="xz" style="width: 100px">
								<option value="9">全部</option>
								<option value="5">行内人员</option>
								<option value="3">外包人员</option>
								<option value="0">专职生产人员</option>
								<option value="1">其他生产人员</option>
								<option value="4">外汇</option>
								<!-- <option value="2">分行班组人员</option>
								 -->
							</select>						
									按关键字排序								
						    <select id="key" name="key"		style="width: 130px">
								<option value="zhcl">折合产量</option>
								<option value="no">工号</option>
								<option value="bmsb">版面识别</option>
								<option value="yxcf">影像拆分</option>
								<option value="lrxg">录入修改</option>
								<option value="lrsq">录入授权</option>
								<option value="jhxg">检核修改</option>
								<option value="jhsq">检核授权</option>
								<option value="sbyy">失败原因</option>
								<option value="yxbz">影像标注</option>
								<option value="cslr">初审录入</option>
								<option value="zyfs">专业复审</option>
								<!-- 
								<option value="lrcc">录入修改差错量</option>
								<option value="jhcc">检核修改差错量</option>
								<option value="lrccl">录入修改差错率</option>
								<option value="jhccl">检核修改差错率</option>
								<option value="lrtp">录入修改退票率</option>
								<option value="lrtpl">录入退票率</option>
								<option value="ccl">折合差错率</option>
								<option value="cx">查询量</option>
								<option value="cxl">查询率</option>
								 -->
							</select>
							<select id="sequence" name="sequence"
								style="width: 50px">
								<option value="1">倒序</option>
								<option value="0">正序</option>
							</select>
									<input type="submit" value="查询"/>
									<input type="hidden" name="para" value="${zx}"/>
									<input type="hidden" name="para" value="${xz}"/>
									<input type="hidden" name="para" value="${key}"/>
									<input type="hidden" name="para" value="${sequence}"/>
						</div></td>	
						</tr>
						<tr height="30px" class="表格表头背景1">
						  <td width="33" rowspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>序号</p>
						  </div></td>
						  <td width="42" rowspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>工号</p>
						  </div></td>
						  <td width="50" rowspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>姓名</p>
						  </div></td>
						  <td width="45" rowspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>折合产量</p>
						  </div></td>
						  <td width="51" rowspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>差错率</p>
						  </div></td>
						  <td colspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>版面识别</p>
						</div></td>
						  <td colspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>影像拆分</p></div></td>
						  <td colspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>录入修改</p></div></td>
						  <td width="100" colspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>录入修改授权</p></div></td>
						  <td colspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>检核修改</p></div></td>
						  <td  width="100" colspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>检核修改授权</p></div></td>
						  <td  width="100" colspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>失败原因分析</p></div></td>
						   <td  width="100" colspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>影像标注</p></div></td>
							<td  width="100" colspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>初审录入</p></div></td>
							<td  width="100" colspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>专业复审</p></div></td>	  		  
						  <td width="40" rowspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>中心</p>
						  </div></td>
						  <td width="65" rowspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
								  <p>人员性质</p>
						  </div></td>
					  </tr>
						<tr height="25px" class="表格表头背景1" id="hang">
							<td  width="40" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>任务量</font></p>
								</div></td>
							<td  width="30" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  width="40" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>任务量</font></p>
								</div></td>
							
							<td  width="30" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  width="40" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>任务量</font></p>
								</div></td>
							<td  width="30" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>	
							<!--		
							<td  width="40" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错量</font></p>
								</div></td>		
							<td  width="40" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错率</font></p>
								</div></td>	
							<td  width="40" align="center" valign="middle" 
								bordercolor=none><div align="center">
							    <p><font size=2>退票量</font></p>
								</div></td>
							<td  width="42" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>退票率</font></p>
								</div></td>	
							 -->	
							<td  width="56" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>任务量</font></p>
								</div></td>
							<td  width="42" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  width="40" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>任务量</font></p>
								</div></td>		
							<td  width="30" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>	
							<!-- 		
							<td  width="40" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错量</font></p>
								</div></td>	
							<td  width="40" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错率</font></p>
								</div></td>	
							 -->	
							<td  width="56" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>任务量</font></p>
								</div></td>		
							<td  width="42" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  width="56" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>任务量</font></p>
								</div></td>
							<td  width="42" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>	
							<td  width="56" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>任务量</font></p>
								</div></td>
							<td  width="42" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  width="56" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>任务量</font></p>
								</div></td>
							<td  width="42" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  width="56" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>任务量</font></p>
								</div></td>
							<td  width="42" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>				
						</tr>
						</table>
				</td>
			</tr>
			<tr>
				<td style="padding-left:1px">
				<div id="scroll" align="center" style="overflow-y: scroll; overflow-x: hidden; height: 500px;">
						<table  id="ghbs"  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
							 <c:forEach items="${list}" var="hn" varStatus="status">
							 <tr <c:if test="${status.count%2==0}">class="c_ghbs1"</c:if> 
							      <c:if test="${status.count%2!=0}">class="c_ghbs2"</c:if> style="height:20px">
								<td  width="33px" height="24" align="center" valign="middle" ><div
										align="center">${status.index+1}</div></td>
							<c:if test="${zhi=='0'||zhi=='1'||role=='6'||role=='7'||role=='9'||hn.no==no891}">			
							   <td width="42px" height="24" align="center" valign="middle" ><div
										align="center"><p style="font-size: ${fb:nofontsize(hn.no)}px;">${hn.no}</p></div></td>
							   <td width="50px" height="24" align="center" valign="middle" ><div
										align="center">${hn.name}</div></td>
							</c:if>
							<c:if test="${zhi!='0'&&zhi!='1'&&role!='6'&&role!='7'&&role!='9'&&hn.no!=no891}">			
							   <td width="42px" height="24" align="center" valign="middle" ><div
										align="center">**</div></td>
							   <td width="50px" height="24" align="center" valign="middle" ><div
										align="center">**</div></td>
							</c:if>				
							   <td width="45px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubleto0integer(hn.zhcl)}</div></td>
							   <td width="51px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubletopercent(hn.ccl)}</div></td>
							   <td width="40px" height="24" align="center" valign="middle" ><div
										align="center">${fb:integertostring(hn.bmsb)}</div></td>
								<c:if test="${type=='daily'}">			
							   <td width="30px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubleto0(hn.xlBmsb)}</div></td>
								</c:if>
								<c:if test="${type!='daily'}">			
							   <td width="30px" height="24" align="center" valign="middle" ><div
										align="center">-</div></td>
								</c:if>		
							   <td width="40px" height="24" align="center" valign="middle" ><div
										align="center">${fb:integertostring(hn.yxcf)}</div></td>
								<c:if test="${type=='daily'}">				
							   <td width="30px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubleto0(hn.xlYxcf)}</div></td>
								</c:if>				
								<c:if test="${type!='daily'}">			
							   <td width="30px" height="24" align="center" valign="middle" ><div
										align="center">-</div></td>
								</c:if>			
							   <td width="40px" height="24" align="center" valign="middle" ><div
										align="center">${fb:integertostring(hn.lrxg)}</div></td>
								<c:if test="${type=='daily'}">			
							   <td width="30px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubleto0(hn.xlLrxg)}</div></td>
								</c:if>
								<c:if test="${type!='daily'}">			
							   <td width="30px" height="24" align="center" valign="middle" ><div
										align="center">-</div></td>
								</c:if>
								<!-- 				
							   <td width="40px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubleto0integer(hn.lrcc)}</div></td>	
							   <td width="40px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubletopercent(hn.lrccl)}</div></td>
							   <td width="40px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubleto0integer(hn.lrtp)}</div></td>
							   <td width="40px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubletopercent(hn.lrtpl)}</div></td>
								 -->			
							   <td width="57px" height="24" align="center" valign="middle" ><div
										align="center">${fb:integertostring(hn.lrsq)}</div></td>
							   <c:if test="${type=='daily'}">
							   <td width="42px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubleto0(hn.xlLrsq)}</div></td>
							 	</c:if>
							  <c:if test="${type!='daily'}">
							   <td width="42px" height="24" align="center" valign="middle" ><div
										align="center">-</div></td>
							 	</c:if>		
							   <td width="40px" height="24" align="center" valign="middle" ><div
										align="center">${fb:integertostring(hn.jhxg)}</div></td>
							   <td width="30px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubleto0(hn.xlJhxg)}</div></td>
								<!--  									   
							   <td width="41px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubleto0integer(hn.jhcc)}</div></td>
							   <td width="40px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubletopercent(hn.jhccl)}</div></td>
							  -->
							   <td width="56px" height="24" align="center" valign="middle" ><div
										align="center">${fb:integertostring(hn.jhsq)}</div></td>
							   <td width="42px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubleto0(hn.xlJhsq)}</div></td>
							 
							   <td width="56px" height="24" align="center" valign="middle" ><div
										align="center">${fb:integertostring(hn.sbyy)}</div></td>
							   <td width="42px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubleto0(hn.xlSbyy)}</div></td>
										
							    <td width="56px" height="24" align="center" valign="middle" ><div
										align="center">${fb:integertostring(hn.yxbz)}</div></td>
							   <td width="42px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubleto0(hn.xlYxbz)}</div></td>
										
								<td width="56px" height="24" align="center" valign="middle" ><div
										align="center">${fb:integertostring(hn.cslr)}</div></td>
							   <td width="42px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubleto0(hn.xlCslr)}</div></td>
										
								<td width="56px" height="24" align="center" valign="middle" ><div
										align="center">${fb:integertostring(hn.zyfs)}</div></td>
							   <td width="42px" height="24" align="center" valign="middle" ><div
										align="center">${fb:doubleto0(hn.xlZyfs)}</div></td>
										
							   <td width="40px" height="24" align="center" valign="middle" ><div
										align="center">${fb:zxToString(hn.zx)}</div></td>
							   <td width="49px" height="24" align="center" valign="middle" ><div
										align="center">${fb:xzToString(hn.xz)}</div></td>
							</tr>
							</c:forEach>
						</table>
					</div>
				</td>
			</tr>
		</table>
		</form>
  </body>
</html>
