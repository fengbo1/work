<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js"></script>
	<script type="text/javascript" src="<%=path%>/js/esl.js"></script>
	<script type="text/javascript" src="<%=path%>/js/echarts.js"></script>
	<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	 var x=document.getElementsByName("para");
		$('#btime').attr('value',x[0].value);
		$('#etime').attr('value',x[1].value);
		$('#part').attr('value',x[2].value);
		$('#key').attr('value',x[3].value);
		//$('#name').attr('value',x[4].value);
});
function validateForm() {
	 var bdate = document.getElementById("btime").value;
	 var edate = document.getElementById("etime").value;
	 var name=document.getElementById("name").value;
	 if(name==null||name.length<=0)
	 {
		alert("姓名不能为空，请重新填写");
		return false;	 
	 }
	// if(type=="day")
	 //{
		 if(bdate.length==0||edate.length==0)
		 {
			alert("请选择正确日期！");
			return false;
		 }
		 else if(bdate>=edate)
		 {
			alert("起始日期必须小于结束日期！");
			return false;
		 }
		 else
		 {
			 var bd = bdate.split("-");
			 var ed = edate.split("-");
			 if(ed[0]==bd[0])
			 {
				if((ed[1]-bd[1])>3)
				{
					alert("日期间隔不能大于三个月！");
					return false;
				}
				else if((ed[1]-bd[1])==3)
				{
					if(ed[2]>=bd[2])
					{
						alert("日期间隔不能大于三个月！");
						return false;
					}
					else
						return true;
				}
				else
				{
					return true;
				}
			 }
			 else if((ed[0]-bd[0])==1)
			 {
				 if((ed[1]-bd[1])==-9)
				 {
					 if(ed[2]>=bd[2])
					 {
						 	alert("日期间隔不能大于三个月！");
							return false;
					 }
						else
							return true;
				 }
				 else if((ed[1]-bd[1])<=-9)
				 {
					return true;
				 }
				 else
				 {
					alert("日期间隔不能大于三个月！");
					return false;
				 }
			 }
			 else
			 {
				alert("日期间隔不能大于三个月！");
				return false;
			 }
		 }
	}

	function change(cp){
		var part = document.getElementById('part').value;
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
		xmlhttp.open("GET","summaryajax.action?type=chartp&part="+part,true);
		xmlhttp.send();
		 }
 
 </script>	
  </head>
  
  <body>
   <form action="<%=path%>/detailjsp.action" method="post" onsubmit="return validateForm()">
    <div>
    	
					<table width="100%" align="center" cellpadding="0"	cellspacing="2">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 0px; border: 0px; font-size: 26px; font-family: '黑体';"
								align="center" bordercolor="#FFFFFF"><b>个人指标趋势图</b>									
							</td>
						</tr>
						<tr >
							<td style="padding-left: 0px"  align="center" height="10">
							
							 <div style="width: 600px; float: left">   	
							
							开始日期
								<input size="9" type="text" name="btime" id="btime" class="Wdate" value="${time}" onClick="WdatePicker()" >
							结束日期
								<input size="9" type="text" name="etime" id="etime" class="Wdate" value="${time}" onClick="WdatePicker()" >
							业务板块
								<select id="part" name="part" style="width: 140px" onchange="change('part')">
								<option value="all">所有板块</option>
								<option value="zw">账务类</option>
								<option value="fz">非账务</option>
								<option value="wh">外汇</option>
								<option value="jy">建亚</option>
								<option value="jh">稽核</option>
								<option value="fxq">反洗钱</option>
								</select>
							</div>
							<div id="keyd" style="width: 200px; float: left">
								业务指标
								<select id="key" name="key" style="width: 120px">
									<c:forEach items="${listnv}" var="nv" varStatus="status">
 										<option value="${nv.name}">${nv.value}</option>
 									</c:forEach>
								</select>
							</div>
							<div style="width: 300px; float: left">	
							<c:if test="${zhi=='0'||zhi=='1'||role=='6'||role=='7'||role=='9'}">
							姓名1
								<input id="name" style="width: 60px" type="text" name="name" value="${name}"/>
							姓名2
								<input id="name1" style="width: 60px" type="text" name="name1" value="${name1}"/>	
							</c:if>
							
							<c:if test="${zhi!='0'&&zhi!='1'&&role!='6'&&role!='7'&&role!='9'}">
								<input id="name" style="width: 60px" type="hidden" name="name" value="${username}"/>
								<input id="name1" style="width: 60px" type="hidden" name="name1" value="null"/>
							</c:if>	
								<input type="submit" value="查询" />
									<input type="hidden" name="para" value="${btime}"/>
									<input type="hidden" name="para" value="${etime}"/>
									<input type="hidden" name="para" value="${part}"/>
									<input type="hidden" name="para" value="${key}"/>
									<c:if test="${zhi!='0'&&zhi!='1'&&role!='6'&&role!='7'&&role!='9'}">
									<input type="hidden" name="para" value="${username}"/>
									<input type="hidden" name="para" value="null"/>
									</c:if>
									<c:if test="${zhi=='0'||zhi=='1'||role=='6'||role=='7'||role=='9'}">
									<input type="hidden" name="para" value="${name}"/>
									<input type="hidden" name="para" value="${name1}"/>
									</c:if>
							</div>		
							</td>	
						</tr>
						</table>
									
							
    </div>
</form>
	<div id="main"style="height:600px;border:1px solid #ccc;padding:10px;"></div>
	
	<script type="text/javascript">

		var myChart;
		var eCharts;
        require.config({

            paths: {

                echarts:'./js/echarts',
                'echarts/chart/bar':'./js/echarts',//这里需要注意的是除了mapchart使用的配置文件为echarts-map之外，
//其他的图形引用的配置文件都为echarts，这也是一般的图形跟地图的区别
                'echarts/chart/line':'./js/echarts'
            }
        });
        require(
        [
            'echarts',

            'echarts/chart/bar',

            'echarts/chart/line'
        ],

        function (ec) {
        	eCharts = ec;

            myChart=eCharts.init(document.getElementById('main'));
            myChart.showLoading({  
                text : "图表数据正在努力加载..."  
            }); 
            option= {
                tooltip: {
                    trigger:'axis',
                    axisPointer:{
            	type: 'line',
                lineStyle: {
                    color: '#CCCCCC',
                    width: 2,
                    type: 'solid'
                }
                }
                },
                legend: {},
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        //dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                animation:false,
                xAxis: [
        {
            type:'category',

            boundaryGap:false,

            axisLabel:{interval:0},
            splitLine:{show:false},
            data: ['']
        }
    ],
                yAxis: [
        {
            type:'value',
            scale: true,//刻度是否从零开始//false是
            splitArea: { show:true }
        }
    ],
                series: [{}]//数据明细

            };                   
            myChart.setOption(option);
            myChart.hideLoading();  
            getChartData();//aja后台交互   
        }

    );

        function getChartData() { 
        var x=document.getElementsByName("para");
            //var ty = $("#type").val();
            var bt = x[0].value;
            var et = x[1].value;
            var pa = x[2].value;
            var ke = x[3].value;
            var nm = x[4].value;
            var nm1 = x[5].value;
            
            //获得图表的options对象  
            var options = myChart.getOption();  
            
           
            //通过Ajax获取数据  
            $.ajax({  
                type : "post",  
                async : false, //同步执行  
                url : "<%=path%>/detailcharts.action?lx=0&btime="+bt+"&etime="+et+"&part="+pa+"&key="+ke+"&name="+encodeURI(nm)+"&name1="+encodeURI(nm1),  
                data : {},  
                dataType : "json", //返回数据形式为json  
                success : function(jsonArray) { 
                    if (jsonArray) {  
                        options.legend.data = jsonArray.legend;
                        options.xAxis[0].data = jsonArray.category;  
                        options.xAxis[0].axisLabel.interval = jsonArray.interval;
                        options.series = jsonArray.series;
                       
                        options.yAxis[0].min = jsonArray.min;
                        options.yAxis[0].max = jsonArray.max;
                        if(jsonArray.type=='lv')
                        { options.yAxis[0].axisLabel = {formatter:'{value}%'};
                            }
                        myChart.hideLoading();  
                        myChart.setOption(options);  
                    }  
                },  
                error : function(errorMsg) {  
                    alert("不好意思，图表请求数据失败啦!");  
                    myChart.hideLoading();  
                }  
            });  
        }  
  
    </script>
  </body>
</html>
