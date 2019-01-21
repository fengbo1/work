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
.highlight {
        color:red;
    }
-->
</style>
<script type="text/javascript">
 $(document).ready(function(){ 
	 $("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
	 $("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 

	 
});
 function change(cp){

	//$('#keyword').attr('value',k);
	var word=document.getElementById('word').value;
	var key=document.getElementById('key').value;
	var pool=document.getElementById('pool').value;
	//var plate=document.getElementById('plate').value;
	var part=document.getElementById('part').value;
	var area=document.getElementById('area').value;
	var factor=document.getElementById('factor').value;
	var mg=document.getElementById('mg').value;
	var plate=encodeURI('建亚业务');
	part=encodeURI(part);
	word=encodeURI(word);
	area=encodeURI(area);
	factor=encodeURI(factor);
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			yesorno=xmlhttp.responseText;
			var arr=yesorno.split("￠");
			//alert(arr[1]);
			if(arr[1]=='pool')
			{
				document.getElementById("partd").innerHTML=arr[4];
				document.getElementById("aread").innerHTML=arr[5];
				document.getElementById("factord").innerHTML=arr[6];
				
			}
			else if(arr[1]=='part')
			{
				document.getElementById("aread").innerHTML=arr[4];
				document.getElementById("factord").innerHTML=arr[5];
			}
			else if(arr[1]=='area')
			{
				document.getElementById("factord").innerHTML=arr[4];
			}
			document.getElementById("scroll").innerHTML=arr[2];
			document.getElementById("btm").innerHTML=arr[3];
			//alert(yesorno);
			highlight();		
				//document.getElementById("chu").innerHTML=arr[0];
		}				
	}
	//alert(part); 
	xmlhttp.open("GET","ruleselect.action?currentPage="+cp+"&word="+word+"&plate="+plate+"&key="+key+"&pool="+pool+"&part="+part+"&area="+area+"&factor="+factor+"&mg="+mg,true);
	xmlhttp.send();

	 }
 	function setkey(key)
	{
		$("#key").val(key);
	}
	function view(idd)
	{
		var word=document.getElementById('word').value;
		word=encodeURI(word);
		window.open("<%=path%>/rulejumptodetail.action?id="+idd+"&word="+word,"","height=700,width=950,top=100,left=290,scrollbars=yes,resizable=yes");
		window.close();
	}
	function toupdate(idd)
	{
		var up = "to_update";
		window.open("<%=path%>/rulejumptodetail.action?id="+idd+"&type="+up,"","height=700,width=950,top=100,left=290,scrollbars=yes,resizable=yes");
		window.close();
	}
	function delrule(idd)
	{
		var up = "to_update";
		window.open("<%=path%>/delrule.action?id="+idd,"","height=10,width=10,top=400,left=600");
		window.close();
	}
	function xinzeng()
	{
		var plate=encodeURI('建亚业务');
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
	     //var reg2=new RegExp(";","g");
	     $('span').each(function()//遍历文章；
	             {
	                var html = $(this).html();
	                var newHtml1 = html.replace(reg1, '<br/>');//回车符
	                $(this).html(newHtml1);//更新文章；
	     });
	 }
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  <body>
			<table align="center" style="width: 1150px;height:500px">
			<tr>
			<td>
			<table  height="80" align="left" cellpadding="0" cellspacing="2">
				<tr class="qq">
					<td
						style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
						colspan="8" align="center" bordercolor="#FFFFFF">
						<b>建亚业务规则</b>
					</td>
				</tr>
				<tr height="50px" class="qq">
					<td colspan="8">
						<input type="hidden" id="key" name="key" value=""/>
						<div style="width: 160px; float: left">
							任务池
							<select id="pool" name="pool" style="width: 100px"
								onchange="setkey('pool');change(1)">
								<option value="qxz">
									请选择
								</option>
								<c:forEach items="${list}" var="pol" varStatus="status">
 										<option value="${pol}">${pol}</option>
 									</c:forEach>
							</select>
						</div>
						<div id="partd" style="width: 220px; float: left">
							环节
							<select id="part" name="part" style="width: 20px"
								onchange="change('part')">
							</select>
						</div>
						<div id="aread" style="width: 300px; float: left">
							适用范围
							<select id="area" name="area" style="width: 20px"
								onchange="change('area')">
							</select>
						</div>
						<div id="factord" style="width: 300px; float: left">
							要素
							<select id="factor" name="factor" style="width: 20px">
							</select>
						</div>
						&nbsp;&nbsp;&nbsp;
						<input type="button" id="chaxun" name="chaxun" value="刷新" onclick="change(1)" />
						<input type="hidden" id="mg" name="mg" value="${mg}" />
					</td>
				</tr>
				<tr>
					<td colspan="8">
						<div id="wordd" style="width: 300px; float: left">
							关键字
							<input id="word" type="text"  style="width: 200px" name="word" onpropertychange="setkey('word');change(1)"/>
							
						</div>
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
					<td width="55px" align="center" valign="middle" nowrap
						bordercolor=none>
						<div align="center">
							<p>
								任务池
							</p>
						</div>
					</td>
					<td width="90px" align="center" valign="middle" nowrap
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
								适用范围
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
					<td width="580px" align="center" valign="middle" nowrap
						bordercolor=none>
						<div align="center">
							<p>
								具体规则
							</p>
						</div>
					</td>
					<td width="60px" align="center" valign="middle" nowrap
						bordercolor=none>
						<div align="center">
							<p>
								切片
							</p>
						</div>
					</td>
					<td width="120px" align="center" valign="middle" nowrap
						bordercolor=none>
						<div align="center">
							<p>
								操作
								
							</p>
						</div>
					</td>
				</tr>
			</table>
			</td>
			</tr>
			<tr>
			<td style="padding-left:1px">
			<div id="scroll" align="center" style="overflow-y: scroll; overflow-x: hidden;height:380px">
					
			</div>
			</td>
			</tr>
			<tr>
			<td style="padding-left:1px">
			<div id="btm" align="center" style="height:40px">
			</div>
			</td>
			</tr>	
			</table>
	</body>
</html>
