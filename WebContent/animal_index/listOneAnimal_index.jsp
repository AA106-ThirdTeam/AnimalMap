 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.animal_index.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Animal_indexServlet.java已存入request的Animal_indexVO物件--%>
<%Animal_indexVO animal_indexVO = (Animal_indexVO) request.getAttribute("animal_indexVO");%>

<html>
<head>
<title>動物圖鑑資料 - listOneAnimal_index.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>動物圖鑑資料 - ListOneAnimal_index.jsp</h3>
        <a href="<%=request.getContextPath()%>/animal_index/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>圖鑑編號</th>
		<th>圖鑑敘述</th>
		<th>圖鑑類別</th>
		<th>圖鑑類別照片編號</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${animal_indexVO.animal_No}</td>
			<td>${animal_indexVO.animal_detail}</td>
			<td>${animal_indexVO.animal_class}</td>
			<td>${animal_indexVO.animal_class_No}</td>
    
    </tr>
</table>

</body>
</html>        
