<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
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

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
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
  <form action="<%=path%>/hnnew.action" method="post" name="fm1">
  	<table align="center" style="" >
  	<tr>
			<td>
					<table  align="center" cellpadding="0"	cellspacing="2">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 0px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="30" align="center" bordercolor="#FFFFFF"><b>${date}日报</b>									
							</td>
						</tr>
						<tr>
						</tr>
						<tr >
							<td colspan="30" style="padding-left: 0px"  align="center" height="10">
							<div class="ddd" align="left">日期</div>
							<div class="ddd" align="left" style="">
								<input size="9" type="text" name="date" id="date" class="Wdate" value="${date}" onClick="WdatePicker()" >
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
								<option value="5">全部</option>
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
								<select id="key" name="key"	style="width: 130px">
								<option value="wu">请选择指标项</option>
								<option value="no">工号</option>
								<option value="rjcl">日均产量</option>
								<option value="rjccl">日均差错率</option>
								<option value="rjxl">日均效率</option>
								<option value="cl">总折合产量</option>
								<option value="clrmb">人民币产量</option>
								<option value="clwh">外汇产量</option>
								<option value="cljh">稽核产量</option>
								<option value="clsh">远程审核产量</option>
								<option value="ccl">总差错率</option>
								<option value="xl">总效率</option>
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
									<input type="hidden" name="name" value="${name}"/>
									<input type="hidden" name="zhuan" value="0"/>
							</div>
							</td>	
						</tr>
						<tr height="30px" class="表格表头背景1" id="hang">
							<td  width="30px" align="center" valign="middle" rowspan="2"
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" rowspan="2"
								bordercolor=none><div align="center">
									<p>工号</p>
								</div></td>
							<td  width="50px"  align="center" valign="middle" rowspan="2"
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>	
							<td  width="40px"  align="center" valign="middle" rowspan="2"
								bordercolor=none><div align="center">
									<p>上线</p>
								</div></td>	
							<td  width="40px"  align="center" valign="middle" rowspan="2"
								bordercolor=none><div align="center">
									<p>中心</p>
								</div></td>	
							<td  width="40px"  align="center" valign="middle" rowspan="2"
								bordercolor=none><div align="center">
									<p>班组</p>
								</div></td>
							<td  width="40px"  align="center" valign="middle" rowspan="2"
								bordercolor=none><div align="center">
									<p>性质</p>
								</div></td>
							<td  align="center" valign="middle" colspan="3"
								bordercolor=none><div align="center">
									<p>当月日均</p>
								</div></td>	
							<td  align="center" valign="middle" colspan="6"
								bordercolor=none><div align="center">
									<p>当日产量</p>
								</div></td>
							<td  align="center" valign="middle" colspan="4"
								bordercolor=none><div align="center">
									<p>当日差错率</p>
								</div></td>
							<td  align="center" valign="middle" colspan="6"
								bordercolor=none><div align="center">
									<p>当日作业效率</p>
								</div></td>
							<td  width="40px"  align="center" valign="middle" rowspan="2"
								bordercolor=none><div align="center">
									<p>当月累计上线天数</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" rowspan="2"
								bordercolor=none><div align="center">
									<p>查看详情</p>
								</div></td>																		
						</tr>
						<tr height="30px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>产量</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>差错率</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>效率</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>当日汇总</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>人民币</p>
								</div></td>
							<td  width="40px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>外汇</p>
								</div></td>	
							<td  width="40px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>稽核</p>
								</div></td>	
							<td  width="40px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>集中审核</p>
								</div></td>	
							<td  width="40px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>建亚</p>
								</div></td>
							<td  width="40px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>当日汇总</p>
								</div></td>
							<td  width="40px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>人民币</p>
								</div></td>
							<td  width="40px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>外汇</p>
								</div></td>
							<td  width="40px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>建亚</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>当日汇总</p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>人民币</p>
								</div></td>
							<td  width="40px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>外汇</p>
								</div></td>	
							<td  width="40px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>集中审核</p>
								</div></td>	
							<td  width="40px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>建亚</p>
								</div></td>																					
						</tr>
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
								<td width="30px"  height="25" align="center" valign="middle" nowrap><div
										align="center"></div>${status.index+1}</td>
										
								<c:if test="${role>'0'||hn.no==no891}">
									<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center"><p style="font-size: ${fb:nofontsize(hn.no)}px;">${hn.no}</p></div></td>
									<td width="50px" height="25" align="center" valign="middle" nowrap><div
										align="center"><p style="font-size: ${fb:nofontsize(hn.name)}px;">${hn.name}</p></div></td>		
								</c:if>		
								<c:if test="${role=='0'&&hn.no!=no891}">	
									<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center"><p style="font-size: ${fb:nofontsize(hn.no)}px;">**</p></div></td>
									<td width="50px" height="25" align="center" valign="middle" nowrap><div
										align="center"><p style="font-size: ${fb:nofontsize(hn.name)}px;">**</p></div></td>	
								</c:if>	
								
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:yesorno(hn.sx)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:zxToString(hn.zx)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:postoteamshort(hn.pos)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:xzToString(hn.xz,0)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn.rjcl)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletopercent(hn.rjccl)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn.rjxl)}</div></td>						
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn.cl)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn.clrmb)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn.clwh)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn.cljh)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn.clsh)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn.cljy)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletopercent(hn.ccl)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletopercent(hn.cclrmb)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletopercent(hn.cclwh)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletopercent(hn.ccljy)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn.xl)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn.xlrmb)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn.xlwh)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn.xlsh)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn.xljy)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletopercent(hn.ljsx)}</div></td>																																														
								<td width="43px" height="25" align="center" valign="middle" nowrap><div
										align="center">
								<c:if test="${role>'0'||hn.no==no891}">		
										<a href="<%=path%>/hnnewdetail.action?no=${hn.no}&date=${hn.date}">详情</a>
								</c:if>		
											</div>
											</td>		
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
