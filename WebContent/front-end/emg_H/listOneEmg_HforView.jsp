<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emg_H.model.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>One_EMG_H</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

<style>
.pic {
	max-height: 350px;
	max-width: 350px;
}
.delete_Emg_H{
   margin:0px 350px;
}


</style>

</head>
<body>

 
<%	
		
	
	
	Emg_HVO emg_HVO =new Emg_HVO();
	Emg_HService emg_HSvc = new Emg_HService();
	
	String emg_H_Id=(String)request.getParameter("emg_H_Id");
	
	emg_HVO = emg_HSvc.getOneEmg_H(emg_H_Id);
	pageContext.setAttribute("emg_HVO",emg_HVO);
	
%>


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
	<br>
	
<div class="${emg_HVO.emg_H_status eq '已被檢舉'?'status':''}">

					

	<div class="col-xs-12 col-sm-3 ">
	
			<h4>求救標題 :  ${emg_HVO.emg_H_title} </h4>
			<h4>求救編號 :  ${emg_HVO.emg_H_Id} </h4>
			<h4>會員編號 :  ${emg_HVO.mem_Id} </h4>
			<h4>開始時間 :  ${emg_HVO.emg_H_start_date}</h4>
			<h4>結束時間 :  ${emg_HVO.emg_H_end_date}	</h4>
			<h4>縣市 :  ${emg_HVO.emg_H_city}</h4>
			<h4>市區 :  ${emg_HVO.emg_H_town}</h4>
			<h4>街道 :  ${emg_HVO.emg_H_road}</h4>
			<h4>經度 :  ${emg_HVO.emg_H_Lon}</h4>
			<h4>緯度 :  ${emg_HVO.emg_H_Lat}</h4>
			<h4>求救內容 :  </h4>
			<p>${emg_HVO.emg_H_content}</p>
		</div>	
					<%--如果求救是該會員(TEST--會員綁死)新增時才會有刪除的按鈕，其餘隱藏， 還有刪除後還待在iframe裡的問題要解決--%>									
				<div class="col-xs-12 col-sm-3  delete_Emg_H ${emg_HVO.mem_Id==1000001?'':'deletebtn' }"  >
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/front-end/emg_H/emg_H.do">
								<input type="submit" value="刪除" class="btn btn-danger"> 
								<input type="hidden" name="emg_H_Id" value="${emg_HVO.emg_H_Id}">
								<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
								<input type="hidden" name="action" value="delete_Emg_H_forView">
							</FORM>		
					</div>	

	
</div>

	       	
<script>

	$(".deletebtn").hide();
	
</script>





</body>
</html>