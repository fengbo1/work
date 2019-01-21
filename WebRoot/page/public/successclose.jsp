<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
	function beforeclose()
	{
		//alert("beforeclose");
		//window.opener.window.opener.change("factor");
		window.close();
	}
</script>
</head>
<body>

${message}

<input type="button" value="关闭当前页" onclick="javascript:beforeclose()">
</body>
</html>