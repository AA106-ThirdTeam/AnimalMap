<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body onload="reload()">
</body>



<script>
	function reload(){

			
//			在地圖上新增的點，新增時轉跳會失敗，因為沒有VO。
//  		window.parent.location.reload();
		var url = "<%=request.getContextPath()%>/front-end/homepage/index.jsp"
			window.parent.location.assign(url);
// 		alert("GO");
	}

</script>

</html>