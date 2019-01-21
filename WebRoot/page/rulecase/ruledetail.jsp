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
					word-break:break-all;
					font-weight:bold;
					font-size:20px;
			}
			.infoimg{
					font-weight:bold;
					font-size:20px;
			}
			.highlight {
        color:red;
    }
		</style>	
		<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "UTF-8"></script>
		<script type="text/javascript">  
			$(function(){  
			function zoomImg(o) {  
			var zoom = parseInt(o.style.zoom, 10) || 100;  
			zoom += event.wheelDelta /20; //可适合修改  
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

				highlight();
				
			});

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
			        	 
			     		var reg1=new RegExp(" ","g"); 
			             $('textarea').each(function()//遍历文章；
					             {
					                 var html = $(this).html();
					                 var newHtml = html.replace(regExp, '<a class="highlight" >'+st[i]+'</a>');//将找到的关键字替换，加上highlight属性；
					                 $(this).html(newHtml);//更新文章；
					             });
			         }
			     }
			     var reg1=new RegExp("∧","g"); 
			     //var reg2=new RegExp(";","g");
			     $('textarea').each(function()//遍历文章；
			             {
			                var html = $(this).html();
			                var newHtml1 = html.replace(reg1, '<br/>');//回车符
			                $(this).html(newHtml1);//更新文章；
			     });	 
				 
			 }

			 function go(fujian)
				{
					window.open("<%=path%>/rulecase/rule/doc/"+fujian,"","height=10,width=10,top=400,left=600");
				}
		</script> 

	</head>
	<body>
		<form action="" method="post">
			<div class="layout" >
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
				align="center">
					<b>规则详情</b>
					<input type="hidden" id="word" name="word" value="${word}"/>
				</div>

				<div id="content">
					
					<div class="four_columns">
						<div class="two_columns_text">
							板块:&nbsp;
						</div>
						<div class="info">
						 	${rr.plate}
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="two_columns_text">
							任务池:&nbsp;
					</div>
					<div class="info">
						${rr.pool}
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							环节:&nbsp;
					</div>
					<div class="info">
							${rr.part}
					</div>	
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							适用范围:&nbsp;
					</div>
					<div class="info">
							${rr.area}
					</div>	
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							要素:&nbsp;
					</div>
					<div class="info">
						${rr.factor}
					</div>
					<div class="clear"></div>
				</div>
				<!-- 
				<div class="four_columns">	
					<div class="two_columns_text">
							${rr.facAName}:&nbsp;
					</div>
					<div class="info">
						${rr.facA}
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							${rr.facBName}:&nbsp;
					</div>
					<div class="info">
						${rr.facB}
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="two_columns_text">
							${rr.facCName}:&nbsp;
					</div>
					<div class="info">
						${rr.facC}
					</div>
					<div class="clear"></div>
				</div>	
				 -->	
				<div class="four_columns">
						<div class="two_columns_text">
							更新日期:&nbsp;
						</div>
						<div class="four_columns_input">
							${rr.renewdate}
						</div>
					<div class="clear"></div>
				</div>	
				<div class="two_columns">
						
					<div class="two_columns_text">
							切片:&nbsp;<br/>滚动缩放
					</div>
					<div class="infoimg">
						<c:if test="${rr.picname!=''}">
							<img src="${imagepath}${rr.picname}">
						</c:if>
						<c:if test="${rr.picname==''}">
							无
						</c:if>
					</div>
						
					<div class="clear"></div>
				</div>
				<div class="two_columns">
						
					<div class="two_columns_text">
							规则内容:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea id="ta1" readonly="readonly" name="rule">${rr.rule}</textarea>
						<input type="hidden" id="ta1len" value="${rr.rule}"/>
					</div>
						
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							规则说明:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea id="ta2" readonly="readonly" name="exp">${rr.exp}</textarea>
						<input type="hidden" id="ta2len" value="${rr.exp}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							备注:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea id="ta3" readonly="readonly" name="remark">${rr.remark}</textarea>
						<input type="hidden" id="ta3len" value="${rr.remark}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							更新说明:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea id="ta4" readonly="readonly" name="renewexp">${rr.renewexp}</textarea>
						<input type="hidden" id="ta4len" value="${rr.renewexp}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							附件:&nbsp;
					</div>
					<div class="two_columns_input">
						<c:forEach items="${fujian}" var="fj" varStatus="status">
							 <a	href="javascript:go('${fj}')">${fj}</a>点击下载
						</c:forEach>
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


