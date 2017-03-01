<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emg_H.model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EMG_H</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.pic {
	max-height: 200px;
	max-width: 200px;
}
</style>

</head>
<body>

<%  
	 Emg_HService emg_HSvc = new Emg_HService();
	 List<Emg_HVO> list =emg_HSvc.getAll();
	 pageContext.setAttribute("list",list);
 %>

	<%-- 
<jsp:useBean id="emg_HSvc" scope="page" class="com.emg_H.model.Emg_HService" />
--%>

	<h3>所有緊急求救 - ListAllEmg_H.jsp</h3>
	<a href="<%=request.getContextPath()%>/front-end/emg_H_Msg/select_page.jsp">回首頁</a>


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


	<table border='1' bordercolor='#CCCCFF' width='1200'>
		<tr >
			<th>求救編號</th>
			<th>會員編號</th>
			<th>開始時間</th>
			<th>結束時間</th>
			<th>求救標題</th>
			<th>求救內容</th>
			<th>求救圖片</th>
			<th>縣市</th>
			<th>市區</th>
			<th>街道</th>
			<th>經度</th>
			<th>緯度</th>

			<th>刪除<font color=red>(關聯測試與交易-小心)</font></th>
			<th>查詢留言</th>
			<th>新增留言</th>
			
			

		</tr>
		<%@ include file="pages/page1.file"%>



		<c:forEach var="emg_HVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">
												<%--與資料庫比對 如果是已被檢舉的狀態 隱藏欄位 --%>
			<tr align='center' valign='middle' class="${emg_HVO.emg_H_status eq '已被檢舉'?'status':''}">

				<td>${emg_HVO.emg_H_Id}</td>
				<td>${emg_HVO.mem_Id}</td>
				<td>${emg_HVO.emg_H_start_date}</td>
				<td>${emg_HVO.emg_H_end_date}</td>
				<td>${emg_HVO.emg_H_title}</td>
				<td>${emg_HVO.emg_H_content}</td>
				<td><img src="<%=request.getContextPath()%>/Emg_H_PicReader?emg_H_Id= ${emg_HVO.emg_H_Id}" class="pic"></td>
				<td>${emg_HVO.emg_H_city}</td>
				<td>${emg_HVO.emg_H_town}</td>
				<td>${emg_HVO.emg_H_road}</td>
				<td>${emg_HVO.emg_H_Lon}</td>
				<td>${emg_HVO.emg_H_Lat}</td>
				
				


				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/front-end/emg_H/emg_H.do">
						<input type="submit" value="刪除"> <input type="hidden"
							name="emg_H_Id" value="${emg_HVO.emg_H_Id}"> <input
							type="hidden" name="action" value="delete_Emg_H">
					</FORM>		
				</td>
				
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/front-end/emg_H/emg_H.do">
						<input type="submit" value="送出查詢"> 
						<input type="hidden" name="emg_H_Id" value="${emg_HVO.emg_H_Id}"> 
						<input type="hidden" name="action" value="listEmg_H_Msg_ByEmg_H_Id_B">
						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
					</FORM>		
							
				</td>
				
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/front-end/emg_H_Msg/emg_H_Msg.do">
						<input type="submit" value="新增留言 "> 
						<input type="hidden" name="emg_H_Id" value="${emg_HVO.emg_H_Id}"> 
						<input type="hidden" name="action" value="insert_Emg_MsgByEmg_H">
						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
							
					</FORM>		
				</td>
				

			</tr>
		</c:forEach>
	</table>


	<%@ include file="pages/page2.file"%>

	<%if (request.getAttribute("listEmg_H_Msg_ByEmg_H_Id")!=null){%>
	<jsp:include page="/front-end/emg_H/listEmg_H_Msg_ByEmg_H_Id.jsp" />
	<%} %>

	<script>
		
		$(".status").hide();
	
	
	
	</script>





</body>
</html>


