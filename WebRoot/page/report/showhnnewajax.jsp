<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
占位￠<b>${date}日报</b>￠
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
										align="center">${fb:doubleto0(hn.clfxq)}</div></td>
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
										align="center">${fb:doubleto0(hn.xljy)}</div></td>
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${hn.ljsx}</div></td>																																														
								<td width="90px" height="25" align="center" valign="middle" nowrap><div
										align="center">
								<c:if test="${role>'0'||hn.no==no891}">		
										<a href="<%=path%>/hnnewdetail.action?no=${hn.no}&date=${hn.date}">详情</a>
								</c:if>		
											</div>
											</td>		
							</tr>
							</c:forEach>
							
						</table>
￠<select id="team" name="team" style="width: 80px" onpropertychange="show('team')">
								<option value="all">全部</option>
								<c:forEach items="${listteam}" var="team" varStatus="status">
 								<option value="${status.index}">${team}</option>
 								</c:forEach>
							    </select>
￠${fb:doubleto0(hn.rjcl)}￠${fb:doubletopercent(hn.rjccl)}
￠${fb:doubleto0(hn.rjxl)}￠${fb:doubleto0(hn.cl)}
￠${fb:doubleto0(hn.clrmb)}￠${fb:doubleto0(hn.clwh)}
￠${fb:doubleto0(hn.cljh)}￠${fb:doubleto0(hn.clfxq)}
￠${fb:doubleto0(hn.cljy)}￠${fb:doubletopercent(hn.ccl)}
￠${fb:doubletopercent(hn.cclrmb)}￠${fb:doubletopercent(hn.cclwh)}
￠${fb:doubletopercent(hn.ccljy)}￠${fb:doubleto0(hn.xl)}
￠${fb:doubleto0(hn.xlrmb)}￠${fb:doubleto0(hn.xlwh)}
￠${fb:doubleto0(hn.xljy)}
