<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
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
tr.locktop{
background-color:#FFFFFF;
position:relative;
top:expression((this.offsetParent.scrollTop>this.parentElement.parentElement.offsetTop?this.offsetParent.scrollTop-this.parentElement.parentElement.offsetTop-1:0)-1);
}
.c_ghbs3{
background-color:#C6E2FF;
font-family:黑体;
font-size:14px;
position:relative;
font-weight:lighter;
top:expression((this.offsetParent.scrollTop>this.parentElement.parentElement.offsetTop?this.offsetParent.scrollTop-this.parentElement.parentElement.offsetTop-1:0)-1);
}
</style>
<script type="text/javascript">
 $(document).ready(function(){ 
$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr[id='xuanxiang']").fadeOut();
$("img[id='yc']").hide();
show('onload');
});

 function show(key){
	 var rnd = Math.floor(Math.random()*10);
	 //alert(rnd);
	 var paras = "";
	 var parts = "";
	 var role=document.getElementById('role').value;
	 var position=document.getElementById('position').value;
	 var chu=document.getElementById('chu').value;
	 var team=document.getElementById('team').value;
	 var choice=document.getElementById('choice').value;
	 var word=document.getElementById('word').value;
	 var date=document.getElementById('date').value;
	 var zx=document.getElementById('zx').value;
	 var qz=document.getElementById('qz').value;
	 var zhibiao=document.getElementById('zhibiao').value;
	 var sequence=document.getElementById('sequence').value;
	 
	 var part=document.getElementsByName("part");
	 for(var i=0;i<part.length;i++)
	 {
		parts+=ifchk(part[i]);
	 }
	 if(key=='chu')
	 {
		team='all';
	 }
	 if(key=='zhibiao')
	 {
		if(zhibiao=='rjcl'||zhibiao=='cl'||zhibiao=='clrmb'||zhibiao=='clwh'||zhibiao=='cljy'||zhibiao=='clfxq'||zhibiao=='cljh')
		{
			$('#sequence').attr('value','1');
			sequence = '1';
		}
		else
		{
			$('#sequence').attr('value','0');
			sequence = '0';
		}
	 }
	 paras+="key,";
	 paras+=key;
	 paras+="￠";
	 paras+="chu,";
	 paras+=chu;
	 paras+="￠";
	 paras+="team,";
	 paras+=team;
	 paras+="￠";
	 paras+="word,";
	 paras+=word;
	 paras+="￠";
	 paras+="date,";
	 paras+=date;
	 paras+="￠";
	 paras+="zx,";
	 paras+=zx;
	 paras+="￠";
	 paras+="qz,";
	 paras+=qz;
	 paras+="￠";
	 paras+="zhibiao,";
	 paras+=zhibiao;
	 paras+="￠";
	 paras+="sequence,";
	 paras+=sequence;
	 paras+="￠";
	 var para=document.getElementsByName('para');
	 for(var i=0;i<para.length;i++)
	 {
		 var j = i+1;
		 paras+="choice";
		 paras+=j;
		 paras+=",";
		 paras+=para[i].value;
		 if(j!=para.length)
		 {
			 paras+="￠";
		 }
	 } 
	 paras = encodeURI(paras);
	 if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	 xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				yesorno=xmlhttp.responseText;
				var arr=yesorno.split("￠");
				document.getElementById("title").innerHTML=arr[1];
				document.getElementById("scroll").innerHTML=arr[2];
				if(key=='chu'&&chu!='all')
				{
					document.getElementById("ttt").innerHTML=arr[3];
				}
				for(var i=1;i<18;i++)
				{
					document.getElementById("pj"+i).innerHTML=arr[i+3];
				}
				
			}				
		}
		//alert(part); 
		xmlhttp.open("GET","showhnnewajax.action?rnd="+rnd+"&role="+role+"&pos="+position+"&paras="+paras+"&choice="+choice+"&parts="+parts,true);
		xmlhttp.send();
	 }

 	function ifchk(obj)
	{
		if(obj.checked)
		{
			return "1";
		}
		else
		{
			return "0";
		}
	}

	function hidexz()
	{
		$("img[id='xs']").show();
		$("img[id='yc']").hide();
		$("tr[id='xuanxiang']").hide();
	}
	function showxz()
	{
		$("img[id='xs']").hide();
		$("img[id='yc']").show();
		$("tr[id='xuanxiang']").show();
	}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  <body >
			<table id="pol_table_list" cellspacing="0" align="center" style="width: 1150px;height:500px">
			<tr class="locktop">
			<th>
			<table  height="80" align="left" cellpadding="0" cellspacing="2">
				<tr class="qq">
					<td
						style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
						colspan="27" align="center" bordercolor="#FFFFFF">
						<div id="title"></div>
					</td>
				</tr>
				<tr height="20px" class="qq">
					<td colspan="27" align="center">
							<c:if test="${role>'0'||zhi!='3'}">
							姓名/工号关键字
							<input id="word" type="text"  style="width: 50px" name="word" oninput="show('date')"/>
							</c:if>
							<c:if test="${role=='0'&&zhi=='3'}">
							<input id="word" type="hidden"  style="width: 50px" name="word" value=""/>
							</c:if>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="ddd" align="left">日期</div>
							<div class="ddd" align="left" style="">
								<input size="9" type="text" name="date" id="date" class="Wdate" value="${date}" onClick="WdatePicker()" onchange="show()">
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="ddd" align="left">自定义群组</div>
							<div class="ddd" align="left">
								<select id="qz" name="qz" style="width: 140px" onchange="show('qz')">
								<option value="all">全部</option>
								<c:forEach items="${listqz}" var="qz" varStatus="status">
								<option value="${qz.value}">${qz.name}</option>
								</c:forEach>
							    </select>
							</div>
							<c:if test="${role>'0'||zhi!='3'}">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="ddd" align="left">人员属性群组</div>
							<img id="xs" src="images/show.PNG" alt="展开其余选项" width="20" height="20" style="cursor:hand" onclick="showxz()"/>
							<img id="yc" src="images/hide.PNG" alt="关闭其余选项" width="20" height="20" style="cursor:hand" onclick="hidexz()"/>		
							</c:if>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="ddd" align="left">指标</div>
							<div class="ddd" align="left">
								<select id="zhibiao" name="zhibiao" style="width: 140px" onchange="show('zhibiao')">
								<option value="rjcl">当月日均产量</option>
								<option value="rjccl">日均差错率</option>
								<option value="rjxl">日均效率</option>
								<option value="cl">总折合产量</option>
								<option value="clrmb">人民币产量</option>
								<option value="clwh">外汇产量</option>
								<option value="cljy">建亚产量</option>
								<option value="cljh">稽核产量</option>
								<option value="clfxq">反洗钱产量</option>
								<option value="ccl">总差错率</option>
								<option value="xl">总效率</option>
								<option value="no">工号</option>
							    </select>
							</div>
							<div class="ddd" align="left">
								<select id="sequence" name="sequence" style="width: 60px"  onchange="show('sequence')">
								<option value="1">倒序</option>
								<option value="0">正序</option>
							    </select>
							    <input type="button" value="查询" onclick="show()"/>
							</div>
							<input type="hidden" name="position" id="position" value="${position}"/>
							<input type="hidden" name="choice" id="choice" value="${choice}"/>
							<input type="hidden" name="role" id="role" value="${role}"/> 
					</td>
				</tr>
				<tr height="20px" class="qq" id="xuanxiang" align="center">
					<td colspan="27">
						<c:forEach items="${part}" var="p" varStatus="status">
							<input type="checkbox" name="part" value="${p.value}" onchange="show()"/>${p.name}&nbsp;&nbsp;&nbsp;&nbsp;
						</c:forEach>
						<div class="ddd" align="left">中心</div>
							<div class="ddd" align="left">
								<select id="zx" name="zx" style="width: 80px" onchange="show('zx')">
								<option value="0">成都中心</option>
								<option value="1">武汉中心</option>
								<option value="all">全部</option>
							    </select>
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="ddd" align="left">处室</div>
							<div class="ddd" align="left">
								<select id="chu" name="chu" style="width: 80px" onchange="show('chu')">
								<option value="all">全部</option>
								<option value="1">综合</option>
								<option value="2">合规</option>
								<option value="3">通用</option>
								<option value="5">研发</option>
								<option value="6">专业</option>
							    </select>
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="ddd" align="left">班组</div>
							<div id="ttt" class="ddd" align="left">
								<select id="team" name="team" style="width: 80px" onchange="show('team')">
								<option value="all">全部</option>
								<option value="1">一组</option>
							    </select>
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;
						<c:forEach items="${listcxb}" var="cxb" varStatus="status">
								 <c:if test="${status.count=='3'||status.count=='11'||status.count=='19'}"><br/></c:if>
								 ${cxb.type} 
								<select id="${cxb.tid}" name="para" style="width: 80px" onchange="show('para')">
									<option value="all">全部</option>
									<c:forEach items="${cxb.contents}" var="cx" varStatus="status">
										<option value="${cx.cnum}">${cx.content}</option>
									</c:forEach>
							    </select>
							   &nbsp;&nbsp;&nbsp;&nbsp;
							</c:forEach>
							
					</td>
					
				</tr>
				<tr height="30px" class="表格表头背景1" id="hang" >
							<td  width="33px" align="center" valign="middle" rowspan="2"
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
							<td  align="center" valign="middle" colspan="4"
								bordercolor=none><div align="center">
									<p>当日作业效率</p>
								</div></td>
							<td  width="40px"  align="center" valign="middle" rowspan="2"
								bordercolor=none><div align="center">
									<p>当月累计上线天数</p>
								</div></td>
							<td  width="90px"  align="center" valign="middle" rowspan="2"
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
									<p>反洗钱</p>
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
									<p>建亚</p>
								</div></td>																					
						</tr>
						
						<tr height="15px" class="c_ghbs3">
							<td width="30px"  height="15" align="center" valign="middle" nowrap></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap>均值</td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj1"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj2"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj3"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj4"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj5"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj6"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj7"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj8"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj9"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj10"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj11"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj12"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj13"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj14"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj15"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj16"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap><div align="center" id="pj17"></div></td>
							<td width="40px"  height="15" align="center" valign="middle" nowrap>-</td>
							<td width="50px"  height="15" align="center" valign="middle" nowrap>-</td>
							</tr>
			</table>
			</th>
			</tr>
			<tr>
			<td style="padding-left:1px">
			<div id="scroll" align="center" style=" overflow-x: hidden;height:430px">
					
			</div>
			</td>
			</tr>
			</table>
	</body>
</html>
