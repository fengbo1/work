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

$("tr.btbj:odd").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
});
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  <input type="button" value="返回" onclick="javascript:history.go(-1);">
  <div align="center"><b style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';">${date}&nbsp;&nbsp;${hd.name}</b>
 		</div>	
  <c:if test="${hd.ljrjcl>0}">
 		<div align="center"><b style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';">人民币主要指标</b>
 		</div>			 
  			
		<table height="80" align="center" cellpadding="0" cellspacing="2" >
		 	<tr class="表格表头背景1" id="hang" height="13px">
		 				<!-- 
		 				<td width="50" rowspan="3"><div align="center">
							    <p>工号</p>
					      </div></td>
						<td width="50" rowspan="3"><div align="center">
								  <p>姓名</p>
					      </div></td>
					      --> 
						<td height="30" colspan="9"><div align="center"><p>当日数据</p> </div></td>
						<td colspan="9"><div align="center" ><p>当月日均数据</p> </div></td>
						<td colspan="3"><div align="center">
								<p>当月累计</p>
						  </div></td>
						<td width="40" rowspan="3"><div align="center">
								<p>中心</p>
						  </div></td>
						<td width="40" rowspan="3"><div align="center">
								<p>性质</p>
						  </div></td>
				</tr>
		 		<tr  class="表格表头背景1" id="hang">
						<td width="50" rowspan="2"><div align="center">
								<p><font size=2>折合产量</font></p>
						  </div></td>
						<td width="50" rowspan="2"><div align="center">
								<p><font size=2>作业差错率</font></p>
						  </div></td>
						<td width="60" rowspan="2"><div align="center">
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
						<td width="50" rowspan="2"><div align="center">
								<p><font size=2>转网点率</font></p>
						  </div></td>
						 <td width="50" rowspan="2"><div align="center">
								<p><font size=2>录入修改差错</font></p>
						  </div></td>
						 <td width="50" rowspan="2"><div align="center">
								<p><font size=2>检核修改差错</font></p>
						  </div></td>
						  <td width="50" rowspan="2"><div align="center">
								<p><font size=2>上线天数</font></p>
						  </div></td>    
						</tr>
						<tr  class="表格表头背景1" id="hang">
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>账务</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>非账务</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>账务</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>非账务</font></p>
								</div></td>	
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>账务</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>非账务</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>账务</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>非账务</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>账务</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>非账务</font></p>
							</div></td>		
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>账务</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>非账务</font></p>
								</div></td>
							</tr>
					<tr class="btbj" id="hang" style="height:20px">
								<!-- 
								<td height="25" align="center" valign="middle" ><div
										align="center"><p style="font-size: ${fb:nofontsize(hd.no)}px;">${hd.no}</p></div></td>
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.name}</div></td>
								 -->		
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.output}</div></td>	
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.zyccl}</div></td>
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.percltime}</div></td>				
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.ccl891}</div></td>
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.ccl895}</div></td>		
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.cxl891}</div></td>
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.cxl895}</div></td>		
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.tpl891}</div></td>
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.tpl895}</div></td>				
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.ljrjcl}</div></td>
								<td width="56px" height="25" align="center" valign="middle" ><div
										align="center">${hd.rjclwcl}</div></td>
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.rjccl891}</div></td>
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.rjccl895}</div></td>		
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.rjcxl891}</div></td>
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.rjcxl895}</div></td>		
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.rjtpl891}</div></td>
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.rjtpl895}</div></td>		
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.ljqdlrzl}</div></td>		
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.ljlrcc}</div></td>
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.ljjhcc}</div></td>	
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.ljsxts}</div></td>					
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.zx}</div></td>
								<td height="25" align="center" valign="middle" ><div
										align="center">${hd.xz}</div></td>
							</tr>		
		 </table>
		 <br/>
		 <div align="center"><b style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';">人民币账务类各环节指标</b>
 		</div>	
		 <table height="80" align="center" cellpadding="0" cellspacing="2" >
		 		
		 		<tr  class="表格表头背景1" id="hang">
						<td colspan="2"><div align="center">
								<p>版面识别</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>影像拆分</p>
						  </div></td>
						<td colspan="4"><div align="center">
								<p>录入修改</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>录入授权</p>
						  </div></td>
						<td colspan="4"><div align="center">
								<p>检核修改</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>检核授权</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>失败原因</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>影像标注</p>
						  </div></td> 
						<td colspan="2"><div align="center">
								<p>初审录入</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>专业复审</p>
						  </div></td>
						     
						</tr>
						<tr  class="表格表头背景1" id="hang">
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>	
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错量</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错率</font></p>
								</div></td>		
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
							</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错量</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错率</font></p>
								</div></td>			
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>	
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="50" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
					</tr>
					<tr class="btbj" id="hang" style="height:20px">
								<td  height="25" align="center" valign="middle" nowrap><div
										align="center">${hn891.bmsb}</div></td>
								<td  height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn891.xlBmsb)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn891.yxcf}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn891.xlYxcf)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn891.lrxg}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn891.xlLrxg)}</div></td>	
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn891.lrcc}</div></td>	
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletolv(hn891.lrxg,hn891.lrccl)}</div></td>						
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn891.lrsq}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn891.xlLrsq)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn891.jhxg}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn891.xlJhxg)}</div></td>	
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn891.jhcc}</div></td>	
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletolv(hn891.jhcc,hn891.jhccl)}</div></td>			
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn891.jhsq}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn891.xlJhsq)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn891.sbyy}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn891.xlSbyy)}</div></td>								
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn891.yxbz}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn891.xlYxbz)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn891.cslr}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn891.xlCslr)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn891.zyfs}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn891.xlZyfs)}</div></td>
								
								
						</tr>				
		 </table>
		 <br/>
		 <div align="center"><b style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';">人民币非账务类各环节指标</b>
 		</div>	
		 <table height="80" align="center" cellpadding="0" cellspacing="2" >
		 		
		 		<tr  class="表格表头背景1" id="hang">
						
						<td colspan="2"><div align="center">
								<p>版面识别</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>影像拆分</p>
						  </div></td>
						<td colspan="4"><div align="center">
								<p>录入修改</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>录入授权</p>
						  </div></td>
						<td colspan="4"><div align="center">
								<p>检核修改</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>检核授权</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>失败原因</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>初审录入</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>专业复审</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>商户签约资料审核</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>商户签约发布失败处理</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>人力资源初审</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>人力资源复审</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>人力资源失败原因分析</p>
						  </div></td>
						  <td colspan="2"><div align="center">
								<p>小微快贷复核</p>
						  </div></td>
						<td colspan="2"><div align="center">
								<p>房源总行核对</p>
						  </div></td>          
						</tr>
						<tr  class="表格表头背景1" id="hang">
							
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>	
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错率</font></p>
								</div></td>				
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
							</div></td>	
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错率</font></p>
								</div></td>			
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
							</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
							</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
							</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
							</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
							</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
							</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
							</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
							</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
							</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
							</div></td>	
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>量</font></p>
								</div></td>
							<td  height="20" width="60" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
							</div></td>		
					</tr>
					<tr class="btbj" id="hang" style="height:20px">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.bmsb}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlBmsb)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.yxcf}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlYxcf)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.lrxg}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlLrxg)}</div></td>	
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.lrcc}</div></td>	
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletolv(hn895.lrcc,hn895.lrccl)}</div></td>					
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.lrsq}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlLrsq)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.jhxg}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlJhxg)}</div></td>	
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.jhcc}</div></td>	
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletolv(hn895.jhcc,hn895.jhccl)}</div></td>					
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.jhsq}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlJhsq)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.sbyy}</div></td>			
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlSbyy)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.cslr}</div></td>			
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlCslr)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.zyfs}</div></td>			
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlZyfs)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.shsh}</div></td>			
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlShsh)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.shsb}</div></td>			
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlShsb)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.rlcs}</div></td>			
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlRlcs)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.rlfs}</div></td>			
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlRlfs)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.rlsb}</div></td>			
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlRlsb)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.kdfh}</div></td>			
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlKdfh)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hn895.fyhd}</div></td>			
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(hn895.xlFyhd)}</div></td>					
						</tr>				
		 </table>
	</c:if>	 
		 <br/>
	<c:if test="${hw.ywl>0}">	 
		 <div align="center"><b style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';">外汇业务主要指标</b>
 		</div>	
		<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
				<!-- 外汇 -->	
						<tr height="30px" class="表格表头背景1" id="hang">
							<td colspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>对私专业初审</p>
								</div></td>
							<td colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>对私专业复审</p>
								</div></td>
							<td colspan="3"   align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>录入修改</p>
								</div></td>
							<td colspan="2"   align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>录入修改授权</p>
								</div></td>
							<td  colspan="3"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>检核修改</p>
								</div></td>
							<td  colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>检核修改授权</p>
								</div></td>
							<td  colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>票据初审</p>
								</div></td>
							<td  colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>票据复审</p>
								</div></td>
							<td  colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>失败原因分析</p>
								</div></td>
							<td colspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>对公汇出初审</p>
								</div></td>
							<td colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>对公汇出复审</p>
								</div></td>	
							<td  colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>对公汇入初审</p>
								</div></td>
							<td  colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>对公汇入复审</p>
								</div></td>		
							<td rowspan="2"  width="55px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>退票率</p>
								</div></td>
							<td rowspan="2"  width="55px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>查询率</p>
								</div></td>	
							<td rowspan="2"  width="55px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>驳回量</p>
								</div></td>	
							<td rowspan="2"  width="55px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>驳回率</p>
								</div></td>			
							<td  rowspan="2"  width="55px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>折合产量</p>
								</div></td>	
						</tr>
						<tr height="20px" class="表格表头背景1" id="hang">
							<td width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错率</font></p>
								</div></td>
							<td width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
								<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错率</font></p>
								</div></td>
							<td width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>	
							<td width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="40px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>										
						</tr>
							<tr class="btbj" id="hang" style="height:20px">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.zycs}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.xlzycs}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.zyfs}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.xlzyfs}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.lrxg}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.xllrxg}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletolv(hw.lrxg,hw.lclv)}</div></td>				
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.lrsq}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.xllrsq}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.jhxg}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.xljhxg}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletolv(hw.jhxg,hw.jclv)}</div></td>				
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.jhsq}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.xljhsq}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.pjcs}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.xlpjcs}</div></td>								
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.pjfs}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.xlpjfs}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.sbyy}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.xlsbyy}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.dgcs}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.xldgcs}</div></td>								
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.dgfs}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.xldgfs}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.hrcs}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.xlhrcs}</div></td>								
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.hrfs}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.xlhrfs}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletolv(hw.ywl,hw.tplv)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletolv(hw.ywl,hw.cxlv)}</div></td>									
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.bh}</div></td>						
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletolv(hw.zyfs,hw.bhl)}</div></td>										
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${hw.zhcl}</div></td>
							</tr>		
		</table>
		</c:if>
		<c:if test="${jh.cl>0}">
		<br/>
 	<div align="center"><b style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';">稽核业务主要指标</b>
 		</div>	
		<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
				<!--  -->	
						<tr height="30px" class="表格表头背景1" id="hang">
							<td width="180" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>核对类质检作业量</p>
								</div></td>
							<td  width="180" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>分析性质检</p>
								</div></td>
							<td  width="180" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>分析性稽核</p>
								</div></td>
							<td  width="180" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>问题管理业务量</p>
								</div></td>
							<td  width="180" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>发布问题量</p>
								</div></td>
							<td  width="180" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>审核取消问题量</p>
								</div></td>
							<td  width="180" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>直接取消问题量</p>
								</div></td>		
							<td width="170"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>折合产量</p>
								</div></td>			
						</tr>
							<tr class="btbj" id="hang" style="height:20px">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jh.hdlzj}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jh.fxxzj}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jh.fxxjh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jh.fbYs+jh.fbJy+jh.fbGf+jh.fbYb+jh.fbZd+jh.shYs+jh.shJy+jh.shGf+jh.shYb+jh.shZd+jh.zjYs+jh.zjJy+jh.zjGf+jh.zjYb+jh.zjZd}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jh.fbYs+jh.fbJy+jh.fbGf+jh.fbYb+jh.fbZd}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jh.shYs+jh.shJy+jh.shGf+jh.shYb+jh.shZd}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jh.zjYs+jh.zjJy+jh.zjGf+jh.zjYb+jh.zjZd}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jh.cl}</div></td>							
							</tr>		
		</table>
		</c:if>	
		
		<c:if test="${fxq.ywl>0}">
		<br/>
 	<div align="center"><b style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';">反洗钱业务主要指标</b>
 		</div>	
		<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
				<!--  -->
						<tr height="30px" class="表格表头背景1" id="hang">
							<td colspan="2" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>大额交易补录</p>
								</div></td>
							<td colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>可疑交易补录</p>
								</div></td>
							<td rowspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>折合产量</p>
								</div></td>	
						</tr>	
						<tr height="30px" class="表格表头背景1" id="hang">
							<td width="180" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>客户信息（客户数）</p>
								</div></td>
							<td  width="180" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>交易明细（笔数）</p>
								</div></td>
							<td width="180" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>客户信息（客户数）</p>
								</div></td>
							<td  width="180" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>交易明细（笔数）</p>
								</div></td>
						</tr>
							<tr class="btbj" id="hang" style="height:20px">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fxq.dekh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fxq.demx}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fxq.kykh}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fxq.kymx}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(fxq.cl)}</div></td>							
							</tr>		
		</table>
		</c:if>			
		<br/>
		<c:if test="${jy.zhcl>0}">
		<div align="center"><b style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';">建亚业务主要指标</b>
 		</div>
		<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
				<!-- 建亚 -->	
						<tr height="30px" class="表格表头背景1" id="hang">
							<td colspan="3"   align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>录入修改</p>
								</div></td>
							<td colspan="2"   align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>录入修改授权</p>
								</div></td>
							<td  colspan="3"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>检核修改</p>
								</div></td>
							<td  colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>检核修改授权</p>
								</div></td>
							<td  colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>票据初审</p>
								</div></td>
							<td  colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>票据复审</p>
								</div></td>
							<td  colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>失败原因分析</p>
								</div></td>
							<td  colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>初审录入</p>
								</div></td>
							<td  colspan="2"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>专业复审</p>
								</div></td>		
							<td rowspan="2"  width="40px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>退票率</p>
								</div></td>
							<td rowspan="2"  width="40px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>查询率</p>
								</div></td>	
							<td  rowspan="2"  width="40px"  align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p>折合产量</p>
								</div></td>	
						</tr>
						<tr height="20px" class="表格表头背景1" id="hang">
							<td width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td  width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错率</font></p>
								</div></td>
							<td width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
								<td  width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>差错率</font></p>
								</div></td>
							<td width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>
							<td width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>业务量</font></p>
								</div></td>
							<td  width="65px" align="center" valign="middle" 
								bordercolor=none><div align="center">
									<p><font size=2>效率</font></p>
								</div></td>							
						</tr>
							<tr class="btbj" id="hang" style="height:20px">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jy.lrxg}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(jy.xllrxg)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletolv(jy.lrxg,jy.lclv)}</div></td>				
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jy.lrsq}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(jy.xllrsq)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jy.jhxg}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(jy.xljhxg)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletolv(jy.jhxg,jy.jclv)}</div></td>				
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jy.jhsq}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(jy.xljhsq)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jy.pjcs}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(jy.xlpjcs)}</div></td>								
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jy.pjfs}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(jy.xlpjfs)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jy.sbyy}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(jy.xlsbyy)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jy.cslr}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(jy.xlcslr)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${jy.zyfs}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(jy.xlzyfs)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletolv(jy.zhcl,jy.tplv)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubletolv(jy.zhcl,jy.cxlv)}</div></td>									
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:doubleto0(jy.zhcl)}</div></td>
										
							</tr>		
		</table>
		<br/><br/>
		</c:if>
  </body>
</html>
