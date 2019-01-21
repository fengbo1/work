<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
占位￠${key}￠
<table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
				<c:forEach items="${listrc}" var="rule" varStatus="status">
					<tr <c:if test="${status.count%2==0}">class="odd"</c:if> 
							      <c:if test="${status.count%2!=0}">class="even"</c:if> id="hang" style="height: 20px">
						<td height="25" width="40px" align="center" valign="middle" nowrap>
							<div align="center">
								${status.index+1}
							</div>
						</td>
						<td height="25" width="60px" align="center" valign="middle">
							<div align="center">
								${rule.pool}
							</div>
						</td>
						<td height="25" width="90px" align="center" valign="middle">
							<div align="center"  style="word-break:break-all;">
								${rule.part}
							</div>
						</td>
						<td height="25" width="100px" align="center" valign="middle">
							<div align="center"  style="word-break:break-all;">
								<span>${rule.area}</span>
							</div>
						</td>
						<td height="25" width="100px" align="center" valign="middle">
							<div align="center"  style="word-break:break-all;">
								<span>${rule.factor}</span>
							</div>
						</td>
						<td height="25" width="590px" align="left" valign="middle">
							<div align="left"  style="word-break:break-all;">
								<span>${rule.rule}</span>
							</div>
						</td>
						<td height="25" width="60px" align="center" valign="middle">
							<div align="center">
								<c:if test="${rule.picname!=''}">
									<img style="width:58px;height:50px"  src="${imagepath}${rule.picname}">
								</c:if>
							</div>
						</td>
						<td height="25" width="100px" align="center" valign="middle" nowrap>
							<div align="center">
							<c:if test="${mg!=1}">	
							<a	href="javascript:view('${rule.id}')">查看详情</a>
							</c:if>
							<c:if test="${mg==1}">	
							<a href="javascript:toupdate('${rule.id}')">修改</a>
							<a onClick="return confirm('确定删除?');" href="javascript:delrule('${rule.id}')">删除</a>
							</c:if>
							</div>
						</td>
					
					</tr>
				</c:forEach>
				</table>
￠				
				<table width="1140px" height="40" align="center" cellpadding="0"
						cellspacing="2" >
				<tr class="表格表头背景">
							<td colspan="3">
								<div align="center">
								<a	href="#" onclick="change(${previousPage})"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="#" onclick="change(${nextPage})"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
								</div></td>
						</tr>
				</table>
￠
<c:if test="${key=='pool'}">
	环节
<select id="part" name="part" style="width: 160px" onchange="setkey('part');change('1')">
<option value="qxz">请选择</option>
 <c:forEach items="${list}" var="rule" varStatus="status">
 	<option value="${rule}">${rule}</option>
 </c:forEach>
 </select>
 ￠适用范围<select id="area" name="area" style="width: 20px"></select>	
 ￠要素<select id="factor" name="factor" style="width: 20px"></select>								
</c:if>
<c:if test="${key=='part'}">
	适用范围
<select id="area" name="area" style="width: 220px" onchange="setkey('area');change('1')">
 	<option value="qxz">请选择</option>
 <c:forEach items="${list}" var="rule" varStatus="status">
 	<option value="${rule}">${rule}</option>
 </c:forEach>
 </select>
  ￠要素<select id="factor" name="factor" style="width: 20px"></select>								
</c:if>
<c:if test="${key=='area'}">
	要素
<select id="factor" name="factor" style="width: 260px" onchange="setkey('factor');change('1')">
 	<option value="qxz">请选择</option>
 <c:forEach items="${list}" var="rule" varStatus="status">
 	<option value="${rule}">${rule}</option>
 </c:forEach>
 </select>								
</c:if>