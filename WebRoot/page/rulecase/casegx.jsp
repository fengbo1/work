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
.qq td{
background-color: #ffffff;
}
.odd{
 background-color:#F0F0F0;
 font-family:黑体;
 font-size:14px;
}
.even{
 background-color:#bfd3fc;
 font-family:黑体;
 font-size:14px;
}
-->
</style>
<script type="text/javascript">

 $(document).ready(function(){ 
	 $("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
	 $("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 

	 var reg1=new RegExp("∧","g"); 
	  //   var reg2=new RegExp(";","g");
	     $('span').each(function()//遍历文章；
	             {
	                var html = $(this).html();
	                var newHtml1 = html.replace(reg1, '<br/>');//回车符
	                $(this).html(newHtml1);//更新文章；
	  }); 
});
 function view(idd)
	{
		window.open("<%=path%>/casejumptodetail.action?id="+idd,"","height=700,width=950,top=100,left=290,scrollbars=yes,resizable=yes");
		window.close();
	}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  <body>
		<form action="<%=path%>/rcrulety.action" method="post" name="fm1">
			<table align="center" style="width: 860px;height:540px">
			<tr>
			<td>
			<table  height="80" align="left" cellpadding="0" cellspacing="2">
				<tr class="qq">
					<td
						style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
						colspan="7" align="center" bordercolor="#FFFFFF">
						<b>案例库近期更新</b>
					</td>
				</tr>
				<tr height="50px" class="表格表头背景1" id="hang">
					<td width="40px" align="center" valign="middle" nowrap
						bordercolor=none>
						<div align="center">
							<p>
								序号
							</p>
						</div>
					</td>
					<td width="100px" align="center" valign="middle" nowrap
						bordercolor=none>
						<div align="center">
							<p>
								更新日期
							</p>
						</div>
					</td>
					<td width="100px" align="center" valign="middle" nowrap
						bordercolor=none>
						<div align="center">
							<p>
								业务板块
							</p>
						</div>
					</td>
					<td width="100px" align="center" valign="middle" nowrap
						bordercolor=none>
						<div align="center">
							<p>
								环节
							</p>
						</div>
					</td>
					<td width="100px" align="center" valign="middle" nowrap
						bordercolor=none>
						<div align="center">
							<p>
								要素
							</p>
						</div>
					</td>
					<td width="300px" align="center" valign="middle" nowrap
						bordercolor=none>
						<div align="center">
							<p>
								案例描述
							</p>
						</div>
					</td>
					
					<td width="100px" align="center" valign="middle" nowrap
						bordercolor=none>
						<div align="center">
							<p>
								查看详情
							</p>
						</div>
					</td>
				</tr>
			</table>
			</td>
			</tr>
			<tr>
			<td style="padding-left:1px">
			<div id="scroll" align="center" style="overflow-y: scroll; overflow-x: hidden;height:460px">
					<table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
				<c:forEach items="${list}" var="rule" varStatus="status">
					<tr class="btbj" id="hang" style="height: 20px">
						<td height="25" width="40px" align="center" valign="middle" nowrap>
							<div align="center">
								${status.index+1}
							</div>
						</td>
						<td height="25" width="100px" align="center" valign="middle">
							<div align="center">
								${rule.renewdate}
							</div>
						</td>
						<td height="25" width="100px" align="center" valign="middle">
							<div align="center">
								${rule.plate}
							</div>
						</td>
						<td height="25" width="100px" align="center" valign="middle">
							<div align="center">
								${rule.part}
							</div>
						</td>
						<td height="25" width="100px" align="center" valign="middle">
							<div align="center">
								${rule.factor}
							</div>
						</td>
						<td height="25" width="300px" align="center" valign="middle">
							<div align="left">
								<span>${rule.rule}</span>
							</div>
						</td>
						<td height="25" width="80px" align="center" valign="middle">
							<div align="center">
							<a	href="javascript:view('${rule.id}')">查看详情</a>
							</div>
						</td>
					</tr>
				</c:forEach>
				</table>
			</div>
			</td>
			</tr>
				<tr>
				<td>
				<table width="850px" height="40" align="center" cellpadding="0"
						cellspacing="2" >
						<tr class="表格表头背景">
							<td colspan="3">
								<div align="center">
								<a	href="<%=path%>/rccasegx.action?currentPage=${previousPage}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/rccasegx.action?currentPage=${nextPage}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
								</div></td>
						</tr>
				</table>				
				
				</td>
				</tr>
			</table>
		</form>
	</body>
</html>
