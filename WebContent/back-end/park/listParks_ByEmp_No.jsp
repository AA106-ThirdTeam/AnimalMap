
	


<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%-- 此頁練習採用 EL 的寫法取值 --%>

<jsp:useBean id="listParks_ByEmp_No" scope="request" type="java.util.Set" />

<html>
<head>
<title>員工編號 - listParks_ByEmp_No.jsp</title>
	<!-- 共用HEAD -->
	
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>

</head>
<body bgcolor='white'>

<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>員工編號 - listParks_ByEmp_No.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/park/select_page.jsp"><img src="<%=request.getContextPath()%>/back-end/images/tomcat.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
    <font color='red'>請修正以下錯誤:
    <ul>
        <c:forEach var="message" items="${errorMsgs}">
            <li>${message}</li>
        </c:forEach>
    </ul>
    </font>
</c:if>

<table border='1' bordercolor='#CCCCFF' width='800'>
    <tr>
        <th>公園編號</th>
        <th>員工編號</th>
        <th>公園標題</th>
        <th>公園內容</th>
        <th>公園照片</th>
        <th>公園發布時間</th>
        <th>公園更新時間</th>
        <th>縣市</th>
        <th>鄉鎮市區</th>
        <th>道路街名村里</th>
        <th>公園經度座標</th>
        <th>緯度座標緯度座標</th>

        <th>修改</th>
        <th>刪除</th> 
    </tr>
    <c:forEach var="parkVO" items="${listParks_ByEmp_No}" >    
        <tr>
			<td>${parkVO.park_Id}</td>
			<td>${parkVO.emp_Id}</td>
			<td>${parkVO.park_title}</td>
			<td>${parkVO.park_content}</td>
			<td>${parkVO.park_pic}</td>
			<td>${parkVO.adp_start_date}</td>
			<td>${parkVO.adp_upDate}</td>
			<td>${parkVO.adp_city}</td>
			<td>${parkVO.park_town}</td>
			<td>${parkVO.park_road}</td>
			<td>${parkVO.park_lon}</td>
			<td>${parkVO.park_lat}</td>

            <td>
              <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/park/park.do">
                <input type="submit" value="修改"> 
                <input type="hidden" name="park_Id" value="${parkVO.park_Id}">
                <input type="hidden" name="requestURL"  value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
                <input type="hidden" name="action"  value="getOne_For_Update"></FORM>
            </td>
            <td>
              <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/park/park.do">
                <input type="submit" value="刪除">
                <input type="hidden" name="park_Id" value="${parkVO.park_Id}">
                <input type="hidden" name="requestURL"  value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
                <input type="hidden" name="action" value="delete"></FORM>
            </td>  
        </tr>
    </c:forEach>
</table>

<br>本網頁的路徑:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>
</html>
