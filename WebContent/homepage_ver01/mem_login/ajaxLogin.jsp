<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="expires" content="0">
<style>
.empTable {
	border-collapse: collapse
}

.empTable th {
	background-color: #BFBFFF;
	color: blue;
	text-align: right;
	border-style: dotted;
	font-weight: normal;
	padding: 5px;
}

.empTable td {
	border: 2px dotted #999999;
	padding: 5px;
}
</style>
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/jquery.mixitup.min.js"></script>
</head>
<body>
	<%@include file='/homepage/mem_login/login_table.jsp' %>
	<%@include file='/homepage/mem_login/register_table.jsp' %>

	<script>
		$(document).on('ready',function(){
			//點擊加入會員 隱藏其它table
			$('#JoinMembership').on('click',function(){
				$('#tableLogin').hide();
				$('#register_table').show();
			})
			
			//一開始先隱藏註冊Table
 			$('#register_table').hide();
			
		});
	</script>
</body>
</html>
