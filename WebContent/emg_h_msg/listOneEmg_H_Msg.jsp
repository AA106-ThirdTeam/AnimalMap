 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.emg_h_msg.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Emg_H_MsgServlet.java已存入request的Emg_H_MsgVO物件--%>
<%Emg_H_MsgVO emg_h_msgVO = (Emg_H_MsgVO) request.getAttribute("emg_h_msgVO");%>

<html>
<head>
<title>緊急求救留言資料 - listOneEmg_H_Msg.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>緊急求救留言資料 - ListOneEmg_H_Msg.jsp</h3>
        <a href="<%=request.getContextPath()%>/emg_h_msg/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>緊急求救留言編號</th>
		<th>留言會員編號</th>
		<th>求救編號</th>
		<th>發布時間</th>
		<th>留言內容</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${emg_h_msgVO.emg_H_Msg_Id}</td>
			<td>${emg_h_msgVO.mem_Id}</td>
			<td>${emg_h_msgVO.emg_H_Id}</td>
			<td>${emg_h_msgVO.emg_H_Msg_start}</td>
			<td>${emg_h_msgVO.emg_H_Msg_content}</td>
    
    </tr>
</table>

</body>
</html>        
