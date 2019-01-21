<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
占位￠
${name}
<select id="${key}" name="${key}" style="width: 120px">
	<c:forEach items="${listnv}" var="nv" varStatus="status">
 			<option value="${nv.name}">${nv.value}</option>
 	</c:forEach>
</select>