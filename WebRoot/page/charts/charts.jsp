<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  </head>
  
  <body>
    

	<div id="main"style="height:500px;border:1px solid #ccc;padding:10px;"></div>
	
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
            	title : {  
                	text : "两中心业务量对比"  
            	}, 
                tooltip: {
                    trigger:'axis'
                },
                legend: {},
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        //dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                animation:false,
                xAxis: [
        {
            type:'category',

            boundaryGap:false,

            data: ['']
        }
    ],
                yAxis: [
        {
            type:'value',
            scale: true,//刻度是否从零开始
            splitArea: { show:true }
            //min:0,
           // max:1
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
            //获得图表的options对象  
            var options = myChart.getOption();  
            //通过Ajax获取数据  
            $.ajax({  
                type : "post",  
                async : false, //同步执行  
                url : "<%=path%>/charts.action",  
                data : {},  
                dataType : "json", //返回数据形式为json  
                success : function(jsonArray) { 
                    if (jsonArray) {  
                        options.legend.data = jsonArray.legend;
                        options.xAxis[0].data = jsonArray.category;  
                        options.series = jsonArray.series;
                        options.yAxis[0].min = 0;
                        options.yAxis[0].max = 2; 
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
