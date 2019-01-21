<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	//先

	//后
 window.onload = function(){
	 initoption();
	 }

 function initoption()
 {
	var x=document.getElementsByName("para");
	$('#btime').attr('value',x[0].value);
	$('#etime').attr('value',x[1].value);
	$('#chu').attr('value',x[2].value);
	$('#team').attr('value',x[3].value);
	$('#part').attr('value',x[4].value);
	$('#key').attr('value',x[5].value);
	$('#qz1').attr('value',x[6].value);
	$('#qz2').attr('value',x[7].value);
}
 
 function validateForm() {
	 var bdate = document.getElementById("btime").value;
	 var edate = document.getElementById("etime").value;
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
	function check(val){
		if(val!='non')
		{
			var qz1 = document.getElementById('qz1').value;
			var qz2 = document.getElementById('qz2').value;
			$('#chu').attr('value','0');
			$('#team').attr('value','0');
			$('#qz1').attr('value',qz1);
			$('#qz2').attr('value',qz2);
		}
		}
	function checkchu(val){
		if(val!='')
		{
			var chu = document.getElementById('chu').value;
			$('#qz1').attr('value','0');
			$('#qz2').attr('value','0');
			$('#chu').attr('value',chu);
		}
		}
	function change(cp){
		var chu = document.getElementById('chu').value;
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
				if(cp=='part')
				{document.getElementById("keyd").innerHTML=arr[1];
					}
				else if(cp=='chartchu')
				{document.getElementById("teamd").innerHTML=arr[1];
					}
				//alert(yesorno);
				//highlight();		
					//document.getElementById("chu").innerHTML=arr[0];
			}	
		}
		//alert(part); 
		if(cp=='part')
		{xmlhttp.open("GET","summaryajax.action?type=chartt&part="+part,true);
		}
		else if(cp=='chartchu')
		{xmlhttp.open("GET","summaryajax.action?type=chartchu&part="+chu,true);
		}
		
		xmlhttp.send();
		 }

	 function daochu(){
		var bdate = document.getElementById("btime").value;
		var edate = document.getElementById("etime").value;
		var qz1 = document.getElementById("qz1").value;
		var qz2 = document.getElementById("qz2").value;	
		var chu = document.getElementById("chu").value;	
		var team = document.getElementById("team").value;	
		window.location = "<%=path%>/exportteam.action?bdate="+bdate+"&edate="+edate+"&qz1="+qz1+"&qz2="+qz2+"&chu="+chu+"&team="+team;
		 }
	 
 </script>
  </head>
  
  <body>
  <form action="<%=path%>/teamjsp.action" method="post" onsubmit="return validateForm()">
    <div>
    	
					<table width="100%" align="center" cellpadding="0"	cellspacing="2">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 0px; border: 0px; font-size: 26px; font-family: '黑体';"
								align="center" bordercolor="#FFFFFF"><b>分组指标趋势图</b>									
							</td>
						</tr>
						<tr >
							<td style="padding-left: 0px"  align="center" height="10">
							<div style="width: 1000px;" align="center">   	
							开始日期
								<input size="9" type="text" name="btime" id="btime" class="Wdate" value="${time}" onClick="WdatePicker()" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							结束日期
								<input size="9" type="text" name="etime" id="etime" class="Wdate" value="${time}" onClick="WdatePicker()" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							自定义群组1
								<select id="qz1" name="qz1" style="width: 140px" onpropertychange="check(this.value)">
								<option value="0">空</option>
								<c:forEach items="${listqz}" var="qz" varStatus="status">
								<option value="${qz.value}">${qz.name}</option>
								</c:forEach>
							    </select>
							   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							   自定义群组2
								<select id="qz2" name="qz2" style="width: 140px" onpropertychange="check(this.value)">
								<option value="0">空</option>
								<c:forEach items="${listqz}" var="qz" varStatus="status">
								<option value="${qz.value}">${qz.name}</option>
								</c:forEach>
							    </select> 
							</div>
							</td>
						</tr>	
						<tr>
							<td style="padding-left: 200px;"  align="center" height="10">
							<div style="width: 120px; float: left">
							处室
								<select id="chu" name="chu" style="width: 80px" onchange="change('chartchu')" onpropertychange="checkchu(this.value)">
								<option value="2">合规</option>
								<option value="3">通用</option>
								<option value="6">专业</option>
							    </select>
							</div>
							<div  id="teamd" style="width: 200px; float: left">
								小组
								<select id="team" name="team" style="width: 120px" onpropertychange="checkchu(this.value)">
								<c:forEach items="${listnvc}" var="nvc" varStatus="status">
 										<option value="${nvc.name}">${nvc.value}</option>
 									</c:forEach>
							    </select>
							</div>
							<div style="width: 170px; float: left">
							业务板块
								<select id="part" name="part" style="width: 80px" onchange="change('part')">
								<option value="all">所有板块</option>
								<option value="rmb">人民币</option>
								<option value="wh">外汇</option>
								<option value="jy">建亚</option>
								<option value="jh">稽核</option>
								<option value="fxq">反洗钱</option>
								</select>
							</div>
							<div id="keyd" style="width: 200px; float: left">
								业务指标
								<select id="key" name="key" style="width: 120px">
									<c:forEach items="${listnvk}" var="nvk" varStatus="status">
 										<option value="${nvk.name}">${nvk.value}</option>
 									</c:forEach>
								</select>
							</div>
									<input type="submit" value="查询"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<c:if test="${zhi=='0'||zhi=='1'||role=='6'||role=='7'||role=='9'}">
									<input type="button" onclick="daochu()" value="导出"/>
									</c:if>
									<input type="hidden" name="para" value="${btime}"/>
									<input type="hidden" name="para" value="${etime}"/>
									<input type="hidden" name="para" value="${chu}"/>
									<input type="hidden" name="para" value="${team}"/>
									<input type="hidden" name="para" value="${part}"/>
									<input type="hidden" name="para" value="${key}"/>
									<input type="hidden" name="para" value="${qz1}"/>
									<input type="hidden" name="para" value="${qz2}"/>
							</td>	
						</tr>
						</table>
    </div>
	</form>
	<div id="main"style="height:550px;border:1px solid #ccc;padding:10px;"></div>
	
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
            var bt = x[0].value;
            var et = x[1].value;
            var ch = x[2].value;
            var te = x[3].value;
            var pa = x[4].value;
            var ke = x[5].value;
            var qz1 = x[6].value;
            var qz2 = x[7].value;
            //获得图表的options对象  
            var options = myChart.getOption();  
            //通过Ajax获取数据  
            $.ajax({  
                type : "post",  
                async : false, //同步执行  
                url : "<%=path%>/teamcharts.action?btime="+bt+"&etime="+et+"&chu="+ch+"&team="+te+"&part="+pa+"&key="+ke+"&qz1="+qz1+"&qz2="+qz2,  
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
