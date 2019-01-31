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
.highlight {
        color:red;
    }
-->
</style>
<script type="text/javascript">
 $(document).ready(function(){ 
	 $("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
	 $("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$('#pool').attr('value',${pool});
$('#bz').attr('value',${bz});
$('#factor').attr('value','${factor}');	
highlight(); 
});

	function toupdate(idd)
	{
		window.open("<%=path%>/rulehgtoupdate.action?id="+idd+"&pool=${pool}","","height=700,width=950,top=100,left=290,scrollbars=yes,resizable=yes");
		window.close();
	}
	function delrule(idd)
	{
		if (window.confirm("请确认是否删除")) {
			with(document.forms[0]) {
				window.open("<%=path%>/delrule.action?id="+idd,"","height=10,width=10,top=400,left=600");
				window.close();
			}
		}
	}
	function xinzeng()
	{
		
		window.open("<%=path%>/page/rulecase/hegui/rulefhcyadd.jsp","","height=700,width=950,top=100,left=290,scrollbars=yes,resizable=yes");
	}
	function importhg()
	{
		window.open("<%=path%>/ruletoadd.action?plate="+plate,"","height=700,width=950,top=100,left=290,scrollbars=yes,resizable=yes");
	}
	function highlight()
	 {
	     //clearSelection();//先清空一下上次高亮显示的内容；
	     var searchText = $('#word').val();//获取你输入的关键字；
	     var st=searchText.split(' ');
	     for(var i=0;i<st.length;i++)
	     {
	    	 if(st[i]!="")
	         {
	        	 var regExp = new RegExp(st[i], 'g');//创建正则表达式，g表示全局的，如果不用g，则查找到第一个就不会继续向下查找了；
	             $('span').each(function()//遍历文章；
	             {
	                 var html = $(this).html();
	                 var newHtml = html.replace(regExp, '<a class="highlight" >'+st[i]+'</a>');//将找到的关键字替换，加上highlight属性；
	                 $(this).html(newHtml);//更新文章；
	             });
	         }
	     }

	     var reg1=new RegExp("∧","g"); 
	     var reg2=new RegExp("。","g");
	     $('span').each(function()//遍历文章；
	             {
	                var html = $(this).html();
	                var newHtml1 = html.replace(reg2, '。<br/>');//回车符
	                $(this).html(newHtml1);//更新文章；
	     });
	 }
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  
			<table align="center" style="width: 1200px;height:500px">
			<tr>
			<td>
			<form action="<%=path%>/rulehg.action" method="post">
			<table  height="80" align="center" cellpadding="0" cellspacing="2">
				<tr class="qq">
					<td
						style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
						colspan="11" align="center" bordercolor="#FFFFFF">
						<b>分行差异</b>
					</td>
				</tr>
				<tr height="50px" class="qq">
					<td colspan="11">
						<div style="width: 1200px;" align="center">
							功能
							<select id="pool" name="pool" style="width: 100px">
								<option value="1">审核标准</option>
								<option value="2">分行差异</option>
								<option value="3">印鉴不符</option>
							</select>
							在用标志
							<select id="bz" name="bz" style="width: 100px">
								<option value="1">在用</option>
								<option value="0">停用</option>
								<option value="9">最近更新</option>
							</select>
							适用范围
							<select id="factor" name="factor" style="width: 140px">
								<option value="all">全行</option>
 								<c:forEach items="${listfac}" var="fac" varStatus="status">
 								<option value="${fac}">${fac}</option>
 	 							</c:forEach>
							</select>
							关键字
							<input id="word" type="text"  style="width: 120px" name="word" value="${word}"/>
							<input type="submit" id="chaxun" value="查询"/>
						</div>
					</td>
				</tr>
				<tr height="40px" class="表格表头背景1" id="hang">
					<td width="40px" align="center" valign="middle"
						bordercolor=none>
						<div align="center">
							<p>
								序号
							</p>
						</div>
					</td>
					<td width="60px" align="center" valign="middle"
						bordercolor=none>
						<div align="center">
							<p>
								模型号
							</p>
						</div>
					</td>
					<td width="60px" align="center" valign="middle"
						bordercolor=none>
						<div align="center">
							<p>
								模型名称
							</p>
						</div>
					</td>
					<td width="60px" align="center" valign="middle"
						bordercolor=none>
						<div align="center">
							<p>
								审核要点
							</p>
						</div>
					</td>
					<td width="600px" align="center" valign="middle"
						bordercolor=none>
						<div align="center">
							<p>
								审核标准
							</p>
						</div>
					</td>
					<td width="60px" align="center" valign="middle"
						bordercolor=none>
						<div align="center">
							<p>
								制度依据
							</p>
						</div>
					</td>
					<td width="60px" align="center" valign="middle"
						bordercolor=none>
						<div align="center">
							<p>
								生效时间
							</p>
						</div>
					</td>
					<td width="60px" align="center" valign="middle"
						bordercolor=none>
						<div align="center">
							<p>
								失效时间
							</p>
						</div>
					</td>
					<td width="60px" align="center" valign="middle"
						bordercolor=none>
						<div align="center">
							<p>
								在用标志
							</p>
						</div>
					</td>
					<td width="60px" align="center" valign="middle"
						bordercolor=none>
						<div align="center">
							<p>
								适用范围
							</p>
						</div>
					</td>
					<td width="80px" align="center" valign="middle"
						bordercolor=none>
						<div align="center">
							<p>
								操作
							</p>
						</div>
					</td>
				</tr>
			</table>
			</form>
			</td>
			</tr>
			<tr>
			<td style="padding-left:1px">
			<div id="scroll" align="center" style="overflow-y: scroll; overflow-x: hidden;height:380px">
					<table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
				<c:forEach items="${list}" var="rule" varStatus="status">
					<tr id="hang" class="btbj" style="height: 20px">
						<td height="25" width="40px" align="center" valign="middle">
							<div align="center">
								${status.index+1+(currentPage-1)*pageSize}
							</div>
						</td>
						<td height="25" width="60px" align="center" valign="middle">
							<div align="center" style="word-break:break-all;">
								${rule.part}
							</div>
						</td>
						<td height="25" width="60px" align="center" valign="middle">
							<div align="center" style="word-break:break-all;">
								${rule.area}
							</div>
						</td>
						<td height="25" width="60px" align="center" valign="middle">
							<div align="center" style="word-break:break-all;">
								<span>${rule.remark}</span>
							</div>
						</td>
						<td height="25" width="600px" align="center" valign="middle">
							<div align="left" style="word-break:break-all;">
								<span>${rule.rule}</span>
							</div>
						</td>
						<td height="25" width="60px" align="center" valign="middle">
							<div align="left" style="word-break:break-all;">
								<span>${rule.exp}</span>
							</div>
						</td>
						<td height="25" width="60px" align="center" valign="middle">
							<div align="center" style="word-break:break-all;">
								<span>${rule.facB}</span>
							</div>
						</td>
						<td height="25" width="60px" align="center" valign="middle">
							<div align="center" style="word-break:break-all;">
								<span>${rule.facC}</span>
							</div>
						</td>
						<td height="25" width="60px" align="center" valign="middle">
							<div align="center" style="word-break:break-all;">
								<span>${rule.facA}</span>
							</div>
						</td>
						<td height="25" width="60px" align="center" valign="middle">
							<div align="center" style="word-break:break-all;">
								<span>
									${rule.fujian}
								</span>
							</div>
						</td>
						<td height="25" width="60px" align="center" valign="middle">
							<div align="center" style="word-break:break-all;">
								<c:if test="${role=='11'}">
								<input type="button" value="修改" onclick="toupdate('${rule.id}');"><br/>
								<input type="button" value="删除" onclick="delrule('${rule.id}');">
								</c:if>
							</div>
						</td>
					</tr>
				</c:forEach>
				</table>
			</div>
			</td>
			</tr>
			<tr>
			<td style="padding-left:1px">
			<div id="btm" align="center" style="height:40px">
				<table width="1200px" height="40" align="center" cellpadding="0"
						cellspacing="2" >
				<tr class="表格表头背景">
							<td colspan="3">
								<div align="center">
								<a	href="<%=path%>/rulehg.action?zhuan=1&pool=${pool}&bz=${bz}&factor=${factor}&word=${word}&currentPage=${previousPage}"
							style="padding-right: 30px;color: #104E8B">上一页</a>  
									${currentPage} of ${totalPages}
							<a	href="<%=path%>/rulehg.action?zhuan=1&pool=${pool}&bz=${bz}&factor=${factor}&word=${word}&currentPage=${nextPage}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
								</div></td>
							<td colspan="3">
								<div align="center">
								<c:if test="${role=='11'}">
								<input type="button" value="新增" onclick="xinzeng();">
								<input type="button" value="导入" onclick="importhg();">
								</c:if>
								</div>
							</td>	
						</tr>
				</table>
			</div>
			</td>
			</tr>	
			</table>
	</body>
</html>
