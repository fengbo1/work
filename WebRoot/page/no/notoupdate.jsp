<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" errorPage="../public/error.jsp"%>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>	
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "UTF-8"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/DatePicker.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
		
		function validateForm() {
			if(document.form.name.value.length == 0){
				alert("姓名不能为空！");
				document.form.name.focus();
				return false;
			}
			if(document.form.zx.value.length == 0){
				alert("所属中心");
				document.form.zx.focus();
				return false;
			}
			if(document.form.xz.value.length == 0){
				alert("人员性质");
				document.form.xz.focus();
				return false;
			}
			return true;
		}

		$(document).ready(function(){
			$('#sex').attr('value',${entity.sex});
			$('#zx').attr('value',${entity.zx});
			$('#key').attr('value',${chuteam});
			$('#chu').attr('value',${chu});
			$('#zhi').attr('value',${zhi});
			$('#schedeam').attr('value',${schedeam});
			$('#xz').attr('value',${xz});
		});


		function change(cp){
			var chu = document.getElementById('chu').value;
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}	
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					yesorno=xmlhttp.responseText;
					var arr=yesorno.split("￠");
					document.getElementById("keyd").innerHTML=arr[1];
					//alert(yesorno);
					//highlight();		
						//document.getElementById("chu").innerHTML=arr[0];
				}	
			}
			//alert(part); 
			xmlhttp.open("GET","summaryajax.action?type=chu&part="+chu,true);
			xmlhttp.send();
			 }
	</script>
<title>操作员基础信息修改</title>
</head>
<body>
	<div class="layout">
		<form name="form" id="form" method="post" action="noupdate.action">
			<div class="title">操作员修改</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">操作员姓名（必填）</div>
					<div class="four_columns_input">
						<input type="hidden" name="oname" value="${username}"/>
						<input type="hidden" name="ono" value="${no891}"/>
						<input type="hidden" name="id" value="${entity.id}"/>
						 <input type="text" id="name" name="name" value="${entity.name}"/>
					</div>
					<div class="four_columns_text">性别</div>
					<div class="four_columns_input">
						 <select id="sex" name="sex"
								style="width:155px">
								<option value="1">男</option>
								<option value="0">女</option>
						</select>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">所属中心（必填）</div>
					<div class="four_columns_input">
						  <select id="zx" name="zx"
								style="width:155px">
								<option value="0">成都</option>
								<option value="1">武汉</option>
						</select>
					</div>
					<div class="four_columns_text">新一代编号</div>
					<div class="four_columns_input">
						 <input type="text" id="newnumber" name="newnumber" value="${entity.newnumber}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">身份证号码</div>
					<div class="four_columns_input">
						   <input type="text" id="identity" name="identity" value="${entity.identity}"/>
					</div>
					<div class="four_columns_text">联系电话</div>
					<div class="four_columns_input">
						 <input type="text" id="tel" name="tel" value="${entity.tel}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">COST工号（后三位）</div>
					<div class="four_columns_input">
						   <input type="text" id="no891" name="no891" value="${entity.no891}"/>
				    </div>
					<div class="four_columns_text">工号1</div>
					<div class="four_columns_input">
						   <input type="text" id="no1" name="no1" value="${entity.no1}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">职务</div>
					<div class="four_columns_input">
						    <select id="zhi" name="zhi"
								style="width:155px">
								<option value="0">无</option>
								<option value="1">处室负责人</option>
								<option value="2">团队负责人</option>
								<option value="4">小组长</option>
								<option value="3">员工</option>
						</select>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">处室</div>
					<div class="four_columns_input">
						    <select id="chu" name="chu" onchange="change('chu')"
								style="width:155px">
								<option value="9">无</option>
								<option value="1">综合与生产管理处</option>
								<option value="2">合规与监督二处</option>
								<option value="3">通用业务二处</option>
								<option value="5">研发支持二处</option>
								<option value="6">专业处理二处</option>
						</select>
					</div>
					<div class="four_columns_text">小组</div>
					<div class="four_columns_input" id="keyd">
						   <select id="key" name="key" style="width: 120px">
									<c:forEach items="${listnv}" var="nv" varStatus="status">
 										<option value="${nv.name}">${nv.value}</option>
 									</c:forEach>
								</select>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">人员属性（必填）</div>
					<div class="four_columns_sm">
						 <select id="xz" name="xz"
								style="width:60px">
								<option value="0">专职</option>
								<option value="1">其他</option>
								<option value="2">分行</option>
								<option value="3">外包</option>
						</select>
						<input name="xzwh" type="hidden" value="1"/>
						<input name="xzjh" type="hidden" value="1"/>
						<input name="xzsh" type="hidden" value="1"/>
						<input name="xzjy" type="hidden" value="1"/>
						
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">来中心时间</div>
					<div class="four_columns_input">
						    <input size=10 type="text" name="comedate" id="comedate" readonly="readonly" value="${entity.comedate}" onclick="setmonth(this,'yyyyMM','2010-01','2099-12',1)" >
					</div>
					<div class="four_columns_text">稽核问题管理岗位数</div>
					<div class="four_columns_input">
						 <select id="schedeam" name="schedeam"
								style="width:155px">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
						</select>
					</div>
					<div class="clear"></div>
				</div>
					<div class="four_columns">
						<div class="four_columns_input">
						</div>
						<div class="four_columns_input">
						<input type="button" value="返回"onclick="javascript:history.go(-1);" />
						</div>
						<div class="four_columns_input">
							<input type="reset" value="重置" />
						</div>
						<div class="four_columns_input">
							<input type="submit" value="提交" />
						</div>
						<div class="clear"></div>
					</div>
				</div>
		</form>
	</div>
</body>
</html>