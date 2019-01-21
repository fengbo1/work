<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>acceptance_data</title>
		
		<link href="<%=path%>/css/add.css" type="text/css"
			rel="stylesheet" />
				<style type="text/css">
			textarea{
					width:800px;
					font-size:16px;
					font-family:"宋体";
			}
			.info{
					float:left;
					font-weight:bold;
					font-size:20px;
			}
			.infoimg{
					font-weight:bold;
					font-size:20px;
			}
		</style>
		<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "UTF-8"></script>
		<script type="text/javascript">  
			$(function(){  
			function zoomImg(o) {  
			var zoom = parseInt(o.style.zoom, 10) || 100;  
			zoom += event.wheelDelta / 20; //可适合修改  
			if (zoom > 0)  
			o.style.zoom = zoom + '%';  
			}  
			$(document).ready(function() {  
			$("img").bind("mousewheel", function() {  
			zoomImg(this);  
			return false;  
			});  
			});  
			})  
			$(document).ready(function(){
				var ta1len=document.getElementById('ta1len').value;
				var ta2len=document.getElementById('ta2len').value;
				var ta3len=document.getElementById('ta3len').value;
				var ta4len=document.getElementById('ta4len').value;
				document.getElementById('ta1').style.height=(ta1len.length+40)/2+"px";
				document.getElementById('ta2').style.height=(ta2len.length+40)/2+"px";
				document.getElementById('ta3').style.height=(ta3len.length+40)/2+"px";
				document.getElementById('ta4').style.height=(ta4len.length+40)/2+"px";

				 var reg1=new RegExp("∧","g"); 
			     //var reg2=new RegExp(";","g");
			     $('textarea').each(function()//遍历文章；
			             {
			                var html = $(this).html();
			                var newHtml1 = html.replace(reg1, '<br/>');//回车符
			                $(this).html(newHtml1);//更新文章；
			     });
			});
		</script> 
	</head>
	<body>
		<form action="" method="post">
			<div class="layout" >
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
				align="center">
					<b>案例详情</b>
				</div>

				<div id="content">
					
					<div class="four_columns">
						<div class="two_columns_text">
							板块:&nbsp;
						</div>
						<div class="info">
						 	${rc.plate}
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="two_columns_text">
							任务池:&nbsp;
					</div>
					<div class="info">
						${rc.pool}
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							环节:&nbsp;
					</div>
					<div class="info">
							${rc.part}
					</div>	
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							要素:&nbsp;
					</div>
					<div class="info">
						${rc.factor}
					</div>
					<div class="clear"></div>
				</div>
				<!-- 
				<div class="four_columns">	
					<div class="two_columns_text">
							${rc.facAName}:&nbsp;
					</div>
					<div class="info">
						${rc.facA}
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							${rc.facBName}:&nbsp;
					</div>
					<div class="info">
						${rc.facB}
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							${rc.facCName}:&nbsp;
					</div>
					<div class="info">
						${rc.facC}
					</div>
					<div class="clear"></div>
				</div>
				 -->		
				<div class="four_columns">
						<div class="two_columns_text">
							更新日期:&nbsp;
						</div>
						<div class="four_columns_input">
							${rc.renewdate}
						</div>
					<div class="clear"></div>
				</div>	
				<div class="two_columns">
						
					<div class="two_columns_text">
							切片:&nbsp;<br/>滚动缩放
					</div>
					<div class="infoimg">
						<c:if test="${rc.picname!=''}">
							<img src="${imagepath}${rc.picname}">
						</c:if>
						<c:if test="${rc.picname==''}">
							无
						</c:if>
					</div>
						
					<div class="clear"></div>
				</div>
				<div class="two_columns">
						
					<div class="two_columns_text">
							案例描述:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea id="ta1" readonly="readonly" name="rule">${rc.rule}</textarea>
						<input type="hidden" id="ta1len" value="${rc.rule}"/>
					</div>
						
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							案例点评:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea id="ta2" readonly="readonly" name="exp">${rc.exp}</textarea>
						<input type="hidden" id="ta2len" value="${rc.exp}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							备注:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea id="ta3" readonly="readonly" name="remark">${rc.remark}</textarea>
						<input type="hidden" id="ta3len" value="${rc.remark}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							更新说明:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea id="ta4" readonly="readonly" name="renewexp">${rc.renewexp}</textarea>
						<input type="hidden" id="ta4len" value="${rc.renewexp}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div  style="padding-left:400px" >
						<input type="button" class="but"  value="关闭当前页" onclick="javascript:window.close();">
					<div class="clear"></div>
				</div>
				</div>
			</div>
		</form>
	</body>

</html>

