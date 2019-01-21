<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'derivedetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	<meta http-equiv="Refresh" content="1; url=<%=path%>/derive/${Path}">
	-->
	
	<script type="text/javascript">
	 function load()
	 {
		 var id=document.getElementById('id').value;
		 var type=document.getElementById('type').value;
		 var word=document.getElementById('word').value;
		 word=encodeURI(word);
		 window.location.href="<%=path%>/viewruledetail.action?id=${id}&type="+type+"&word="+word; 
		 //window.open("<%=path%>/viewruledetail.action?id=${id}&type="+type,"","height=700,width=950,top=100,left=290,scrollbars=yes,resizable=yes"); 
		// window.opener=null;
		 // window.open('','_self');
		 // window.close();
	 }
	</script>
	<script type="text/javascript">setTimeout("go()", 1);  </script>
	<SCRIPT language=javascript>
	function go()
	{
	 	window.history.go(-1);
	}
	</SCRIPT>
  </head>
  
  <body onload=load()>
 	 <input id="id" type="hidden" name="id" value="${id}"/>
 	 <input id="type" type="hidden" name="type" value="${type}"/>
 	 <input id="word" type="hidden" name="word" value="${word}"/>
  </body>
</html>
