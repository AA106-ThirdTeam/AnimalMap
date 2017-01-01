<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	color: #000;
	font-size: 12px;
	margin: 0px auto;
}
</style>

<script type="text/javascript">
	function check(form) {
		//document.forms.form1.username.value取得form1中Username的值 並判斷是否為空
		if (document.forms.form1.username.value == "") {
			//如果 為""則彈出提示
			alert("pls input username");
			//將輸入焦點定位到沒有輸入的地方
			document.forms.form1.username.focus();
			//返回錯誤
			return false;
		}
		if (document.forms.form1.password.value == "") {
			alert("pls input password");
			document.forms.form1.password.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<form action="LoginServlet" method="post" name="form1">
		<table border="1" cellspacing="1" cellpadding="1" bordercolor="silver"
			align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#e8e8e8">登入</td>
			</tr>
			<tr>
				<td>帳號：</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="button" value="註冊" onclick="alert('HI')"/></td>

			</tr>
		</table>

	</form>
</body>
</html>