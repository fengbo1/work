<%@page import="work.control.pojo.Control"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//String username = (String)request.getSession().getAttribute("username");
	String IP=request.getRemoteAddr();
	session.setAttribute("IP",IP);
%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/cccx_old.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style_old.css" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>生产信息管理工具</title>
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js"></script>
<script language="javascript"> 

function startTime()
{
	
var today=new Date();
var h=today.getHours();
var m=today.getMinutes();
var s=today.getSeconds();
// add a zero in front of numbers<10
m=checkTime(m);
s=checkTime(s);
document.getElementById('txt').innerHTML=h+":"+m+":"+s;
t=setTimeout('startTime()',500);

}

function checkTime(i)
{
if (i<10) 
  {i="0" + i;}
  return i;
}
 
</script>
<script type="text/javascript">

function frame(o)
{
	event.cancelBubble = true;
	var id = document.getElementById("id").value;
	var obj = " ";
	obj=o;
	if(obj=="userinfo")
	{
		document.getElementById("frame").src="<%=path%>/user.action?type=find_all";
	}
	else if(obj=="pwdmodify")
	{
	    document.getElementById("frame").src="<%=path%>/user.action?type=to_update&id="+id;
	}
	else if(obj=="introduction")
	{
		document.getElementById("frame").src="<%=path%>/prepare1.action";
	}
	else if(obj=="whimport")
	{
		document.getElementById("frame").src="<%=path%>/page/introduction/whimport.jsp";
	}
	else if(obj=="operate")
	{
		document.getElementById("frame").src="<%=path%>/page/introduction/operate.jsp";
	}
	else if(obj=="downloadwb")
	{
		document.getElementById("frame").src="<%=path%>/page/download/downloadwb.jsp";
	}
	else if(obj=="downloadhn")
	{
		document.getElementById("frame").src="<%=path%>/page/download/downloadhn.jsp";
	}
	else if(obj=="expressreport")
	{
		document.getElementById("frame").src="<%=path%>/express.action?time=null&xz=5&zx=0&team=0&sequence=1&key=wu&keytb=wu";
	}
	else if(obj=="hnnew")
	{
		document.getElementById("frame").src="<%=path%>/hnnew.action?date=null&xz=5&zx=0&team=0&sequence=1&key=wu&keytb=wu&name=${username}&zhuan=1";
	}
	else if(obj=="hn891")
	{
		document.getElementById("frame").src="<%=path%>/hn891search.action?time=null&xz=5&zx=0&sequence=1&key=zhcl";
	}
	else if(obj=="hn895")
	{
		document.getElementById("frame").src="<%=path%>/hn895search.action?time=null&xz=5&zx=0&sequence=1&key=zhcl";
	}
	else if(obj=="team")
	{
		document.getElementById("frame").src="<%=path%>/team.action?time=null&rmb=rmb&wh=wh&jh=jh&jy=jy&fxq=fxq";
	}
	else if(obj=="wbreport")
	{
		document.getElementById("frame").src="<%=path%>/page/report/wbdaily.action";
	}
	else if(obj=="lrzcreport")
	{
		document.getElementById("frame").src="<%=path%>/page/report/lrzcdaily.action";
	}
	else if(obj=="fzyyreport")
	{
		document.getElementById("frame").src="<%=path%>/page/report/fzyydaily.action";
	}
	else if(obj=="operator")
	{
		document.getElementById("frame").src="<%=path%>/nolist.action?xz=9&zx=2&chu=0&team=0&keytb=wu&show=mng";
	}
	else if(obj=="operatorshow")
	{
		document.getElementById("frame").src="<%=path%>/nolist.action?xz=9&zx=2&chu=0&team=0&keytb=wu&show=show";
	}
	else if(obj=="summaryreport")
	{
		document.getElementById("frame").src="<%=path%>/page/report/summarydaily.action";
	}
	else if(obj=="control")
	{
		document.getElementById("frame").src="<%=path%>/control.action";
	}
	//参数维护
	else if(obj=="config")
	{
		document.getElementById("frame").src="<%=path%>/hnconfigall.action";
	}
	else if(obj=="importcfg")
	{
		document.getElementById("frame").src="<%=path%>/page/control/importcfg.jsp";
	}
	else if(obj=="opxz")
	{
		document.getElementById("frame").src="<%=path%>/opxz.action";
	}
	else if(obj=="monthpara")
	{
		document.getElementById("frame").src="<%=path%>/monthparafindall.action";
	}
	else if(obj=="paralog")
	{
		document.getElementById("frame").src="<%=path%>/paralog.action?type=find_all_desc";
	}
	else if(obj=="nolog")
	{
		document.getElementById("frame").src="<%=path%>/nolog.action?type=find_all_desc";
	}
	else if(obj=="log")
	{
		document.getElementById("frame").src="<%=path%>/log.action?type=find_all_desc";
	}
	else if(obj=="warning")
	{
		document.getElementById("frame").src="<%=path%>/warning.action";
	}
	else if(obj=="charts")
	{
		document.getElementById("frame").src="<%=path%>/page/charts/charts.jsp";
	}
	else if(obj=="summarychart")
	{
		document.getElementById("frame").src="<%=path%>/summaryjsp.action?part=all&btime=${bt}&etime=${et}&key=rjcl&xz=0&zx=cdwh";
	}
	else if(obj=="detailchart")
	{
		document.getElementById("frame").src="<%=path%>/detailjsp.action?btime=${bt}&etime=${et}&name=${username}&part=all&key=cl&zhuan=1";
	}
	else if(obj=="detailchart_team")
	{
		document.getElementById("frame").src="<%=path%>/teamjsp.action?btime=${bt}&etime=${et}&chu=${chu}&team=0&part=all&key=rjcl";
	}
	else if(obj=="jhsx")
	{
		document.getElementById("frame").src="<%=path%>/jhsx.action";
	}
	//业务规则
	else if(obj=="rc_rule")
	{
		document.getElementById("frame").src="<%=path%>/rulesearch.action";
	}
	else if(obj=="rc_rule_ty")
	{
		document.getElementById("frame").src="<%=path%>/rcrulety.action?pool=qxz";
	}
	else if(obj=="rc_rule_wh")
	{
		document.getElementById("frame").src="<%=path%>/rcrulewh.action?pool=qxz";
	}
	else if(obj=="rc_rule_jy")
	{
		document.getElementById("frame").src="<%=path%>/rcrulejy.action?pool=qxz";
	}
	else if(obj=="rc_rule_hg")
	{
		document.getElementById("frame").src="<%=path%>/rulehg.action?role=${role}&pool=1&bz=1&factor=all&word=";
	}
	else if(obj=="rc_rule_zl")
	{
		document.getElementById("frame").src="<%=path%>/rcrulezl.action?type=1";
	}
	else if(obj=="rc_rule_gx")
	{
		document.getElementById("frame").src="<%=path%>/rcrulegx.action";
	}
	//典型案例
	else if(obj=="rc_case_ty")
	{
		document.getElementById("frame").src="<%=path%>/rccasety.action?pool=qxz";
	}
	else if(obj=="rc_case_wh")
	{
		document.getElementById("frame").src="<%=path%>/rccasewh.action?pool=qxz";
	}
	else if(obj=="rc_case_gx")
	{
		document.getElementById("frame").src="<%=path%>/rccasegx.action";
	}
	//规则维护
	else if(obj=="rc_rulemg_ty")
	{
		document.getElementById("frame").src="<%=path%>/rcrulety.action?pool=qxz&mg=1";
	}
	else if(obj=="rc_rulemg_wh")
	{
		document.getElementById("frame").src="<%=path%>/rcrulewh.action?pool=qxz&mg=1";
	}
	else if(obj=="rc_rulemg_jy")
	{
		document.getElementById("frame").src="<%=path%>/rcrulejy.action?pool=qxz&mg=1";
	}
	else if(obj=="rc_rulemg_zl")
	{
		document.getElementById("frame").src="<%=path%>/rcrulezl.action?mg=1";
	}
	else if(obj=="rc_rulemg_dr")
	{
		document.getElementById("frame").src="<%=path%>/page/rulecase/ruledr.jsp";
	}
	//案例维护
	else if(obj=="rc_casemg_ty")
	{
		document.getElementById("frame").src="<%=path%>/rccasety.action?pool=qxz&mg=1";
	}
	else if(obj=="rc_casemg_wh")
	{
		document.getElementById("frame").src="<%=path%>/rccasewh.action?pool=qxz&mg=1";
	}
	else if(obj=="rc_casemg_dr")
	{
		document.getElementById("frame").src="<%=path%>/page/rulecase/casedr.jsp";
	}
	
	else if(obj=="y_upload")
	{
		document.getElementById("frame").src="<%=path%>/page/ygxy/y_upload.jsp";
	}
	else if(obj=="y_xyrb")
	{
		document.getElementById("frame").src="<%=path%>/y_xyrb.action";
	}
	else if(obj=="y_process")
	{
		document.getElementById("frame").src="<%=path%>/getyear.action";
	}
}
</script>
<script type="text/javascript">
$(document).ready(function(){
						   
	/* 滑动/展开 */
	$("ul.expmenu li > div.header").click(
	function()
	{
		var arrow = $(this).find("span.arrow");
	
		$(this).parent().find("ul.menu").slideToggle("fast").parents(".a").siblings(".a").children("ul.menu").hide(300);
		
	}
);
	$(".frame").click(
			function()
			{
				$(".frame").css("width","155px");
				$(this).css("width","170px");	
			}
			);
});
</script>
<style>
.menu ol { padding-left:15px; border:#E7E7E7 1px solid; border-top:none;background: #f7f2e5;}
.menu li i{background-color: #ae9c7e;padding: 1px 4px;color: #fff;text-shadow: 0px 0px 0px rgba(255, 255, 255, 0.8);font-family: 宋体;font-style:normal;}
.menu a{color: #3f3f3f;text-decoration: none;}
.menu .no {display:none;}
.menu ol a{width: 228px;display: block;line-height: 2em;margin-left: 20px;}
</style>
</head>
<body onload="startTime()">
	<div id="zhuti" style="position:absolute">
		<div id="top">
			<img src="images/logo.gif" width="276" height="50"
				style="margin-top:0px" />
		</div>
		<div class=x_beijing>
			<div class=x_anniu>
				<div>
					<b class="b1"></b><b class="b2 d1"></b><b class="b3 d1"></b><b
						class="b4 d1"></b>
					<div class="b d1 k">
						<div class=x_gr>
							<!-- 登陆用户信息 -->
							<p style="margin-top: 5px">${username }</p>
							<p style="font-size:14px">欢迎访问生产信息管理工具</p>
							<p>
							<!--
								<input align="right" name="logout" type="button" value="修改密码" onclick="frame('pwdmodify')" />&nbsp;
								 <input align="right" name="logout" type="button" value="安全退出" onclick="location='<%=path%>/page/userinfo/logout.jsp'" />
								 -->
								<input align="right" name="logout" type="button" value="返回首页" onclick="location='http://64.244.180.111/office/mainccb.jsp'" />
								 
								<input type="hidden" id="id" name="id" value="${id}"/>
							</p>
							<p><%=new SimpleDateFormat("yyyy年MM月dd日").format(new java.util.Date())%></p>
							<p id="txt"></p>
							<p>累计访问量：${views}</p>
						</div>
					</div>
					<b class="b4b d1"></b><b class="b3b d1"></b><b class="b2b d1"></b><b
						class="b1b"></b>
				</div>
					<div class="menu" style="margin-top: 5px; background-color: #188AE7;">
						<ul class="expmenu">
					<c:if test="${(chu!='4')}"> <!--  区分COT 和员工响应-->
						<li class="a">
								<div class="header">
									<span class="label">图表展示</span>
								</div>
								<ul class="menu">
									
									<li class="frame" onclick="frame('summarychart')">汇总指标趋势图</li>
								    <li class="frame" onclick="frame('detailchart')">个人指标趋势图</li>
								    <li class="frame" onclick="frame('detailchart_team')">分组指标趋势图</li>
								</ul>
						</li>
						<li class="a">
								<div class="header">
									<span class="label">行内日报</span>
								</div>
								<ul class="menu">
								    <li class="frame" onclick="frame('summaryreport')">汇总指标日报</li>
									<li class="frame" onclick="frame('hnnew')">个人明细日报</li>
									<li class="frame" onclick="frame('team')">分组指标日报</li>
									<li class="frame" onclick="frame('operatorshow')">操作人员信息表</li>
									<!-- 
									<li class="frame" onclick="frame('expressreport')">明细日报（旧）</li>
									<li class="frame" onclick="frame('hn891')">891基础数据</li>
									<li class="frame" onclick="frame('hn895')">895基础数据</li>
									 -->
								</ul>
							</li>
							<c:if test="${zhi=='0'||zhi=='1'||role=='6'||role=='7'||role=='9'}"> 
							<!-- 
							<li class="a">
								<div class="header">
									<span class="label">外包日报</span>
								</div>
								<ul class="menu">
									<li class="frame" onclick="frame('wbreport')">要素录入日报</li>
									<li class="frame" onclick="frame('lrzcreport')">录入仲裁日报</li>
									<li class="frame" onclick="frame('fzyyreport')">辅助验印日报</li>
								</ul>
							</li>
							 -->
							<li class="a">
								<div class="header">
									<span class="label">数据管理</span>
								</div>
								<ul class="menu">
								<c:if test="${(zhi=='0'||zhi=='1'||role=='6')}"> 
									<li class="frame" onclick="frame('introduction')">数据导入</li>
								
									<li class="frame" onclick="frame('operate')">数据加工</li>
								</c:if>	
								
									<li class="frame" onclick="frame('downloadhn')">行内数据导出</li>
									<!-- 
									<li class="frame" onclick="frame('downloadwb')">外包数据导出</li>
									 -->
								</ul>
							</li>
							</c:if>
							
							<li class="a">
								<div class="header">
									<span class="label">参数维护</span>
								</div>
								<ul class="menu">
								<c:if test="${zhi=='0'||zhi=='1'||role=='6'||role=='7'||role=='9'}"> 
									<li class="frame" onclick="frame('control')">业务提示值</li>
									<li class="frame" onclick="frame('jhsx')">计划上线人数</li>
									</c:if>
									<!-- 
									<li class="frame" onclick="frame('monthpara')">产量质量目标值</li>
									 -->
									<c:if test="${zhi=='0'||zhi=='1'||role=='6'||role=='7'||role=='9'}"> 
									<li class="frame" onclick="frame('operator')">操作人员信息表</li>
									<li class="frame" onclick="frame('opxz')">人员属性控制表</li>
									<li class="frame" onclick="frame('config')">业务参数控制表</li>
									<li class="frame" onclick="frame('importcfg')">导入业务人员明细</li>
									</c:if>
									<c:if test="${zhi=='0'||zhi=='1'||role=='6'||role=='9'}">
									<!-- 
									<li class="frame" onclick="frame('paralog')">参数维护情况表</li>
									 -->
									<li class="frame" onclick="frame('nolog')">员工信息维护日志</li>
									</c:if>
									<!-- 
									<li class="frame" onclick="frame('log')">用户操作日志表</li> 
									 -->
								</ul>
							</li>
							<c:if test="${zhi=='0'||zhi=='1'||role=='6'||role=='7'||role=='9'}"> 
							<li class="a">
								<div class="header">
									<span class="label"> 业务提示</span>
								</div>
								<ul class="menu">
									<li class="frame" onclick="frame('warning')">业务提示</li>
									
								</ul>
							</li>
							</c:if>
							<li class="a">
								<div class="header" onclick="frame('rc_rule')">
									<span class="label" >规则案例库</span>
								</div>
								<ul class="menu">
									<li class="frame">业务规则
										<ul class="menu3">
											<li class="frame" onclick="frame('rc_rule_ty')">通用业务-人民币</li>
											<li class="frame" onclick="frame('rc_rule_wh')">通用业务-外汇</li>
											<li class="frame" onclick="frame('rc_rule_jy')">通用业务-建亚</li>
											<c:if test="${chu=='2'||zhi=='0'}">
											<li class="frame" onclick="frame('rc_rule_hg')">合规业务</li>
											</c:if>
											<li class="frame" onclick="frame('rc_rule_zl')">辅助资料</li>
											<li class="frame" onclick="frame('rc_rule_gx')">近期更新</li>
										</ul>
									</li>
									<li class="frame">典型案例
										<ul class="menu3">
											<li class="frame" onclick="frame('rc_case_ty')">通用业务-人民币</li>
											<li class="frame" onclick="frame('rc_case_wh')">通用业务-外汇</li>
											<li class="frame" onclick="frame('rc_case_gx')">近期更新</li>
										</ul>
									</li>
									<c:if test="${role=='9'}">
									<li class="frame">规则维护
										<ul class="menu3">
											<li class="frame" onclick="frame('rc_rulemg_ty')">通用业务-人民币</li>
											<li class="frame" onclick="frame('rc_rulemg_wh')">通用业务-外汇</li>
											<li class="frame" onclick="frame('rc_rulemg_jy')">通用业务-建亚</li>
											<li class="frame" onclick="frame('rc_rulemg_zl')">辅助资料</li>
											<li class="frame" onclick="frame('rc_rulemg_dr')">新增导入</li>
										</ul>
									</li>
									<li class="frame">案例维护
										<ul class="menu3">
											<li class="frame" onclick="frame('rc_casemg_ty')">通用业务-人民币</li>
											<li class="frame" onclick="frame('rc_casemg_wh')">通用业务-外汇</li>
											<li class="frame" onclick="frame('rc_casemg_dr')">新增导入</li>
										</ul>
									</li>
									</c:if>
								</ul>
							</li>
						</c:if><!--  区分COT 和员工响应-->
						<!-- 
						<c:if test="${(chu=='4'||role=='9')}"> 
							<li class="a">
								<div class="header">
									<span class="label">员工响应</span>
								</div>
								<ul class="menu">
									<li class="frame" onclick="frame('y_xyrb')">响应日报</li>
									<c:if test="${(role=='6')}">
									<li class="frame" onclick="frame('y_upload')">数据导入</li>
									<li class="frame" onclick="frame('y_process')">数据加工</li>									
									</c:if>									
								</ul>
							</li>
						</c:if>
						 -->
						</ul>
					</div>
			</div>
			<div class=x_xianshi style="overflow:auto">
				<div style="overflow:auto">
					<b class="b1"></b><b class="b2 d1"></b><b class="b3 d1"></b><b
						class="b4 d1"></b>
					<div class="b d1 k3">
						<iframe id="frame" class="mainpage"	src="<%=path%>/page/welcome.jsp" marginwidth='0'
							marginheight='0' frameborder='0'></iframe>
					</div>
					<b class="b4b d1"></b><b class="b3b d1"></b><b class="b2b d1"></b><b
						class="b1b"></b>
				</div>
			</div>
		</div>
	</div>
</body>
</html>