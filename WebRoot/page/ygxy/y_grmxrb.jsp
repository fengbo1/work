<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>

<%@ page import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username = (String) request.getSession().getAttribute("username");
String zhi = (String) request.getSession().getAttribute("zhi");
String role = (String) request.getSession().getAttribute("role");

//System.out.println("1:"+username+"2:"+name);
//ExpressReport er = new ExpressReport();
//ArrayList<HnDetail> hdlist = er.gethdList("20150103");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "UTF-8"></script>
<style type="text/css">
.neirong{
background-color:bfd3fc;
background-color:yellow;


}

</style>
<script type="text/javascript">
 $(document).ready(function(){
	 $(".btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px" }); 
	 $(".btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px" }); 

	  
	var x=document.getElementsByName("para");
	$('#keyword').attr('value',x[0].value);
	$('#des').attr('value',x[1].value);

});

 	function expressout()
	{
 		var date = document.getElementById("date").value;
 		var keyword = document.getElementById("keyword").value;
 		var shunxu = document.getElementById("shunxu").value;
		window.location = "<%=path%>/ygxymxbexpress.action?date="+date+"&keyword="+keyword+"&shunxu="+shunxu;
	}
 </script>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工响应日报</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link href="<%=path%>/css/buttons.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "UTF-8"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>

 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
<body>
<form action="<%=path%>/y_xyrb.action" method="post" name="fm1">
	<table  border="0px" align="center" style="height:100px" >
		<tr>
			<td  >
				
					<table    border="0px"  align="left" cellpadding="0">
						<tr>
							<td	style="color: #1778C2; padding-top: 0px; padding-bottom: 0px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="30" align="center" bordercolor="#FFFFFF"><b>${date}员工响应团队个人明细日报</b>
							</td>
						</tr>
						
						<tr><td colspan="30" align="center" height="10px">							
							<div align="center" >日期&nbsp;
								<input type="text" size="10" name="date" id="date" class="Wdate" value="${date}" onClick="WdatePicker()" >&nbsp;
								<select name="keyword" id="keyword">
									<option value="ft_yddh+0">应答电话量</option>
									<option value="ft_yjdfl+0">一级答复量(一级响应热线电话)</option>
									<option value="fe_drjsl+0">当日经手量(一级响应电子工单)</option>
									<option value="fe_yjdfl+0">一级答复量(一级响应电子工单)</option>
									<option value="ste_drjsl+0">二级工单当日经手量</option>
									<option value="ste_ejdfl+0">二级工单答复量</option>
								</select>
								<select name="shunxu" id="des">
									<option value="desc">降序</option>
									<option value="asc">升序</option>									
								</select>
								 <input type="submit" value="查询"/>
								<!-- <input type="button" value="导出" onclick="expressout()"/> -->
								    <input type="hidden" name="para" value="${keyword}"/>
									<input type="hidden" name="para" value="${shunxu}"/>
							</div>
							</td>
						</tr>
						<tr  class="表格表头背景1" >
						  <td height="12" colspan="2" nowrap><div align="center" ><p>岗位名称</p></div></td>
						  <td colspan="20" height="30px" nowrap="nowrap"><div align="center" ><p>一级响应人员</p></div></td>
						   <td colspan="8" height="30px" nowrap="nowrap"><div align="center" ><p>二级响应人员</p></div></td>
					    </tr>
						
						<tr  class="表格表头背景1" id="hang" >
						  <td height="12" colspan="2" nowrap><div align="center" ><p>受理渠道</p></div></td>
						<td colspan="14" height="30px" nowrap="nowrap"><div align="center"><p>热线电话</p></div></td>
						<td colspan="6" height="30px" nowrap="nowrap"><div align="center"><p>电子工单</p></div></td>
						<td colspan="8" height="30px" nowrap="nowrap"><div align="center"><p>二级工单（热线电话+电子工单）</p></div></td>
						</tr>
						
						<tr class="表格表头背景1" id="hang" height="30px" style="font-size:14px;" >
						 
						  <td width="45" nowrap><div align="center" ><p>姓名</p></div></td>
						  <td width="30" nowrap><div align="center" ><p>组别</p></div></td>
						  <td width="50" align="center" valign="middle" bordercolor=black ><div align="center"><p>登录时长</p></div></td>
						  <td width="42"  align="center" valign="middle" bordercolor=black><div align="center" ><p>小休率</p></div></td>
						  <td width="30 " align="center" valign="middle" bordercolor=black><div align="center"><p>应答电话量</p></div></td>
						  <td width="50" align="center" valign="middle" bordercolor=black ><div align="center"><p>平均应答时长</p></div></td>
						  <td width="50" height="30px" align="center" valign="middle" bordercolor=black><div align="center"><p>平均事后处理时长</p></div></td>
							<td  height="30px" width="30" align="center" valign="middle" 
								bordercolor=black ><div align="center">
									<p>呼出电话数</p>
								</div></td>
							<td width="50"  align="center" valign="middle"   
								bordercolor=black><div align="center">
									<p>平均呼出时长</p>
								</div></td>
							<td width="50" align="center" valign="middle" 
								bordercolor=black ><div align="center">
									<p>平均处理时长</p>
								</div></td>
							<td width="30"   align="center"  valign="middle" 
								bordercolor=black><div align="center">
									<p>废单</p>
								</div></td>
							<td    width="30" align="center" valign="middle" 
								bordercolor=black ><div align="center">
									<p>团队外转量</p>
								</div></td>
						
							<td width="30"    align="center"  valign="middle" 
								bordercolor=black><div align="center" >
									<p>退回咨询人</p>
								</div></td>
							<td width="30"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>聚类工单量</p>
						    </div></td>
							<td width="30"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>一级答复量</p>
						    </div></td>
							
							
							<td width="32"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>一级答复率</p>
						    </div></td>
							<td width="30"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>当日经手量</p>
						    </div></td>
							<td width="50"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>一级平均处理时长</p>
						    </div></td>
							
							
							<td width="30"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>退回咨询人</p>
						    </div></td>
							<td width="30"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>聚类工单量</p>
						    </div></td>
							<td width="30 "  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>一级答复量</p>
						    </div></td>
							<td width="30"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>一级答复率</p>
						    </div></td>
							<td width="30"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>当日经手量</p>
						    </div></td>
						    
						    
						    
							<td width="50"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>二级平均处理时长</p>
						    </div></td>
							<td width="30"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>退回咨询人</p>
						    </div></td>
							<td width="30"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>聚类工单量</p>
						    </div></td>
							<td width="30 "  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>二级答复量</p>
						    </div></td>
							<td width="30"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>二级答复率</p>
						    </div></td>
							
							
							
							<td width="30"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>转三级量</p>
						    </div></td>
							<td width="30"  align="center"  valign="middle" 
								bordercolor=black><div align="center" >
							  <p>转三级率</p>
						    </div></td>
						</tr>
						</table>
						
				</td>
			</tr>		
						<tr >
						<td  >					
						<div id="scroll" align="center" style="overflow-y: scroll;  overflow-x: hidden; height:420px; padding:0px; margin:0px;">
						<table   border="0px"  align="left" cellpadding="0">
						<c:forEach items="${list}" var="y" varStatus="status"><!-- positiontoteam -->
							 <c:if test="${status.count%2==0}">
							  <tr style="background-color:#F0F0F0;font-size: 14px;" id="hang" style="font-size:14px;" >	
							 </c:if> 
							  <c:if test="${status.count%2!=0}">
							  <tr style="background-color:#bfd3fc;font-size: 14px;" id="hang" style="font-size:14px;" >	
							  </c:if>
							  						
							    <td   style="font-family: '黑体';" align="center" width="45" height="30">
								
								
								<%if(!zhi.equals("4")&&!role.equals("9")&&!role.equals("6")){%>
								<c:if test="${y.name==username}">						  
							    ${y.name}	
							    </c:if>
							    <c:if test="${y.name!=username}">						  
							    **						    
							    </c:if>		
							    <%} %>
							    <%if(zhi.equals("4")||role.equals("9")||role.equals("6")) {%>												  
							    ${y.name}
							     <%} %>
							    </td>
							    <td  width="31" valign="middle" align="center">
							    <%if(!zhi.equals("4")&&!role.equals("9")&&!role.equals("6")) {%>
								<c:if test="${y.name==username}">						  
							      ${fb:positiontoteam(y.position)}
							    					    
							    </c:if>
							    <c:if test="${y.name!=username}">						  
							    **						    
							    </c:if>		
							    <%} %>
							    <%if(zhi.equals("4")||role.equals("9")||role.equals("6")) {%>												  
							    ${fb:positiontoteam(y.position)}
							     <%} %>
							     </td>
							    <td   width="45"  align="center" valign="middle" nowrap><c:if test="${y.ftDlsc!='00:00:00'}">${y.ftDlsc}</c:if></td>
								<td   width="41" align="center" valign="middle" nowrap><c:if test="${y.ftDlsc!='00:00:00'}">${y.ftXxlv}</c:if></td>
								<td   width="30" align="center" valign="middle" nowrap><c:if test="${y.ftDlsc!='00:00:00'}">${y.ftYddh}</c:if></td>
								<td   width="50 "  align="center" valign="middle" nowrap><c:if test="${y.ftDlsc!='00:00:00'}">${y.ftPjydsc}</c:if></td>
								<td   width="50"  align="center" valign="middle" nowrap><c:if test="${y.ftDlsc!='00:00:00'}">${y.ftPjshsc}</c:if></td>
								<td   width="30"  align="center" valign="middle" nowrap><c:if test="${y.ftDlsc!='00:00:00'}">${y.ftHcdhs}</c:if></td>
								<td   width="50"  align="center" valign="middle" nowrap><c:if test="${y.ftDlsc!='00:00:00'}">${y.ftPjhcsc}</c:if></td>
								<td   width="50"  align="center" valign="middle" nowrap><c:if test="${y.ftDlsc!='00:00:00'}">${y.ftPjclsc}</c:if></td>	
								
								
								<td   width="30"  align="center" valign="middle" nowrap><c:if test="${y.ftDlsc!='00:00:00'}">${y.ftFeiql}</c:if></td>
								<td   width="30"  align="center" valign="middle" nowrap><c:if test="${y.ftDlsc!='00:00:00'}">${y.ftTdwzjl}</c:if></td>
								
								<td   width="30" align="center" valign="middle" nowrap><c:if test="${y.ftDlsc!='00:00:00'}">${y.ftTbjpl}</c:if></td>
								<td   width="30" align="center" valign="middle" nowrap><c:if test="${y.ftDlsc!='00:00:00'}">${y.ftGdjll}</c:if></td>
								<td   width="30" align="center" valign="middle" nowrap><c:if test="${y.ftDlsc!='00:00:00'}">${y.ftYjdfl}</c:if></td>
								
								<td   width="30" align="center" valign="middle" nowrap><c:if test="${y.ftDlsc!='00:00:00'}">${y.ftYjdflv}</c:if></td>
								
								
								
								<td   width="30" align="center" valign="middle" nowrap><c:if test="${y.feDrjsl!='0'}">${y.feDrjsl}</c:if></td>
								<td   width="50" align="center" valign="middle" nowrap><c:if test="${y.feDrjsl!='0'}">${y.feYjpjclsc}</c:if></td>
							
								<td   width="30" align="center" valign="middle" nowrap><c:if test="${y.feDrjsl!='0'}">${y.feTbjpl}</c:if></td>
								<td   width="30" align="center" valign="middle" nowrap><c:if test="${y.feDrjsl!='0'}">${y.feGdjll}</c:if></td>
								<td   width="30" align="center" valign="middle" nowrap><c:if test="${y.feDrjsl!='0'}">${y.feYjdfl}</c:if></td>
								<td   width="30" align="center" valign="middle" nowrap><c:if test="${y.feDrjsl!='0'}">${y.feYjdflv}</c:if></td>
								
								<td   width="30" align="center" valign="middle" nowrap><c:if test="${y.steDrjsl!='0'}">${y.steDrjsl}</c:if></td>
								
								
								<td   width="50" align="center" valign="middle" nowrap>${y.steEjpjclsc}</td>
								<td   width="30" align="center" valign="middle" nowrap>${y.steTpjpl}</td>
								<td   width="30" align="center" valign="middle" nowrap>${y.steGdjll}</td>
								<td   width="30" align="center" valign="middle" nowrap>
								<c:if test="${y.steDrjsl!='0'}">${y.steEjdfl}</c:if></td>
								<td   width="30" align="center" valign="middle" nowrap>${y.steEjdflv}</td>
								
								<td   width="30" align="center" valign="middle" nowrap>${y.steZsjl}</td>
								<td   width="30" align="center" valign="middle" nowrap>${y.steZsjlv}</td>
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
