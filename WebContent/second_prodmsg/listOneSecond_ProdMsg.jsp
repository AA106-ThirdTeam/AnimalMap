 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.second_prodmsg.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Second_ProdMsgServlet.java已存入request的Second_ProdMsgVO物件--%>
<%Second_ProdMsgVO second_prodmsgVO = (Second_ProdMsgVO) request.getAttribute("second_prodmsgVO");%>

<html>
<head>
<title>二手商品留言資料 - listOneSecond_ProdMsg.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>二手商品留言資料 - ListOneSecond_ProdMsg.jsp</h3>
        <a href="<%=request.getContextPath()%>/second_prodmsg/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>二手商品留言編號</th>
		<th>二手商品編號</th>
		<th>留言會員編號</th>
		<th>二手商品留言</th>
		<th>留言發布日期</th>
		<th>留言更新日期</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${second_prodmsgVO.second_ProdMsg_Id}</td>
			<td>${second_prodmsgVO.second_Prod_Id}</td>
			<td>${second_prodmsgVO.mem_Id}</td>
			<td>${second_prodmsgVO.second_ProdMsg_Msg}</td>
			<td>${second_prodmsgVO.second_ProdMsg_DATE}</td>
			<td>${second_prodmsgVO.second_ProdMsg_adp_upDate}</td>
    
    </tr>
</table>

</body>
</html>        
