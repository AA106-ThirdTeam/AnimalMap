<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body onload="reload()">
</body>



<script>
	function reload(){

			
//			在地圖上新增的點，新增照片時轉跳會失敗，因為沒有VO。
//  		window.parent.location.reload();
		var url = "<%=request.getContextPath()%>/front-end/strayani/strayani.do?stray_Pic_type=0&action=getOne_For_Display&stray_Ani_Id=<%=request.getParameter("stray_Ani_Id")%>"
			window.parent.location.assign(url);
// 		alert("GO");
	}

</script>

</html>