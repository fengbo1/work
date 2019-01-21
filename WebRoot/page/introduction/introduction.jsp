<%@ page import="work.daily.dao.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	DailyStatusDAO dsdao = new DailyStatusDAO();
	String time = dsdao.findFinalWithHn();		
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" errorPage="../public/error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<title>源数据导入</title>
</head>
<body>
	<div class="layout">
		<form name="filename" method="post" action="introduction.action"
			enctype="multipart/form-data">
			<div class="title">源数据导入</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="上传">
					</div>
					<div class="four_columns_text"><p style="color:red">（请另存为excel2003格式后上传）</p></div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="title"></div>
			<div id="content" >
				<div class="six_columns">
					<div class="eight_columns_text" align="center"><b>${ds1.time}导入文件:</b></div>
					<c:if test="${ds1.hnonline>0}">
					<div class="eight_columns_text" align="center"><p>【人员上线情况表】</p></div>
					</c:if>
					<c:if test="${ds1.hnjihe>0}">
					<div class="eight_columns_text" align="center"><p>【行内稽核报表】</p></div>
					</c:if>
					<c:if test="${ds1.hnycsh>0}">
					<div class="eight_columns_text" align="center"><p>【行内远程审核】</p></div>
					</c:if>
					<c:if test="${ds1.hnfxq>0}">
					<div class="eight_columns_text" align="center"><p>【反洗钱】</p></div>
					</c:if>
					<c:if test="${ds1.hnx13>0}">
					<div class="eight_columns_text" align="center"><p>【行内卸数13】</p></div>
					</c:if>
					<c:if test="${ds1.hnwhbb>0}">
					<div class="eight_columns_text" align="center"><p>【武汉报表】</p></div>
					</c:if>
					
					<div class="clear"></div>
				</div>
				<div class="six_columns">
					<div class="eight_columns_text" align="center"><b>${ds2.time}导入文件:</b></div>
					<c:if test="${ds2.hnonline>0}">
					<div class="eight_columns_text" align="center"><p>【人员上线情况表】</p></div>
					</c:if>
					<c:if test="${ds2.hnjihe>0}">
					<div class="eight_columns_text" align="center"><p>【行内稽核报表】</p></div>
					</c:if>
					<c:if test="${ds2.hnycsh>0}">
					<div class="eight_columns_text" align="center"><p>【行内远程审核】</p></div>
					</c:if>
					<c:if test="${ds2.hnfxq>0}">
					<div class="eight_columns_text" align="center"><p>【反洗钱】</p></div>
					</c:if>
					<c:if test="${ds2.hnx13>0}">
					<div class="eight_columns_text" align="center"><p>【行内卸数13】</p></div>
					</c:if>
					<c:if test="${ds2.hnwhbb>0}">
					<div class="eight_columns_text" align="center"><p>【武汉报表】</p></div>
					</c:if>
					
					<div class="clear"></div>
				</div>
				<div class="six_columns">
					<div class="eight_columns_text" align="center"><b>${ds3.time}导入文件:</b></div>
					<c:if test="${ds3.hnonline>0}">
					<div class="eight_columns_text" align="center"><p>【人员上线情况表】</p></div>
					</c:if>
					<c:if test="${ds3.hnjihe>0}">
					<div class="eight_columns_text" align="center"><p>【行内稽核报表】</p></div>
					</c:if>
					<c:if test="${ds3.hnycsh>0}">
					<div class="eight_columns_text" align="center"><p>【行内远程审核】</p></div>
					</c:if>
					<c:if test="${ds3.hnfxq>0}">
					<div class="eight_columns_text" align="center"><p>【反洗钱】</p></div>
					</c:if>
					<c:if test="${ds3.hnx13>0}">
					<div class="eight_columns_text" align="center"><p>【行内卸数13】</p></div>
					</c:if>
					<c:if test="${ds3.hnwhbb>0}">
					<div class="eight_columns_text" align="center"><p>【武汉报表】</p></div>
					</c:if>
					
					<div class="clear"></div>
				</div>
				<div class="six_columns">
					<div class="eight_columns_text" align="center"><b>${ds4.time}导入文件:</b></div>
					<c:if test="${ds4.hnonline>0}">
					<div class="eight_columns_text" align="center"><p>【人员上线情况表】</p></div>
					</c:if>
					<c:if test="${ds4.hnjihe>0}">
					<div class="eight_columns_text" align="center"><p>【行内稽核报表】</p></div>
					</c:if>
					<c:if test="${ds4.hnycsh>0}">
					<div class="eight_columns_text" align="center"><p>【行内远程审核】</p></div>
					</c:if>
					<c:if test="${ds4.hnfxq>0}">
					<div class="eight_columns_text" align="center"><p>【反洗钱】</p></div>
					</c:if>
					<c:if test="${ds4.hnx13>0}">
					<div class="eight_columns_text" align="center"><p>【行内卸数13】</p></div>
					</c:if>
					<c:if test="${ds4.hnwhbb>0}">
					<div class="eight_columns_text" align="center"><p>【武汉报表】</p></div>
					</c:if>
					
					<div class="clear"></div>
				</div>
				<div class="six_columns">
					<div class="eight_columns_text" align="center"><b>${ds5.time}导入文件:</b></div>
					<c:if test="${ds5.hnonline>0}">
					<div class="eight_columns_text" align="center"><p>【人员上线情况表】</p></div>
					</c:if>
					<c:if test="${ds5.hnjihe>0}">
					<div class="eight_columns_text" align="center"><p>【行内稽核报表】</p></div>
					</c:if>
					<c:if test="${ds5.hnycsh>0}">
					<div class="eight_columns_text" align="center"><p>【行内远程审核】</p></div>
					</c:if>
					<c:if test="${ds5.hnfxq>0}">
					<div class="eight_columns_text" align="center"><p>【反洗钱】</p></div>
					</c:if>
					<c:if test="${ds5.hnx13>0}">
					<div class="eight_columns_text" align="center"><p>【行内卸数13】</p></div>
					</c:if>
					<c:if test="${ds5.hnwhbb>0}">
					<div class="eight_columns_text" align="center"><p>【武汉报表】</p></div>
					</c:if>
					
					<div class="clear"></div>
				</div>
			</div>
		</form>
	</div>
	<br/>
	<div class="layout">
		<form name="filename" method="post" action="introduction.action"
			enctype="multipart/form-data">
			<table border="1px">
				<tr>
					<td colspan="4" class="title">文件名规则</td>
				</tr>
				<tr>
					<td style="width:250px"></td>
					<td style="width:200px">文件名规则如下：</td>
					<td style="width:200px">示例如下：</td>
				</tr>
				<tr>
					<td>行内作业人员上线情况表：</td>
					<td>hn&nbsp;+&nbsp;日期&nbsp;+&nbsp;-online</td>
					<td>hn20150726-online.xls</td>
				</tr>
				<tr>
					<td>稽核报表：</td>
					<td>hn&nbsp;+&nbsp;日期&nbsp;+&nbsp;-jhbb</td>
					<td>hn20150726-jhbb.xls</td>
				</tr>
				<tr>
					<td>远程审核报表：</td>
					<td>hn&nbsp;+&nbsp;日期&nbsp;+&nbsp;-ycsh</td>
					<td>hn20150726-ycsh.xls</td>
				</tr>
					<tr>
					<td>反洗钱报表：</td>
					<td>hn&nbsp;+&nbsp;日期&nbsp;+&nbsp;-fxq</td>
					<td>hn20150726-fxq.xls</td>
				</tr>
				<tr>
					<td>COS_T导出卸数13：</td>
					<td>hn&nbsp;+&nbsp;日期&nbsp;+&nbsp;-x13</td>
					<td>hn20150726-x13.xlsx</td>
				</tr>
				<tr>
					<td>武汉报表：</td>
					<td>hn&nbsp;+&nbsp;日期&nbsp;+&nbsp;-whbb</td>
					<td>hn20150726-whbb.xls</td>
					<td>行内武汉报表导入后会重新生成汇总表和分组指标表</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>