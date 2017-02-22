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
	max-height: 200px;
	max-width: 200px;
}
</style>

</head>
<body>

 
<%	
		
	
	
	Emg_HVO emg_HVO =new Emg_HVO();
	Emg_HService emg_HSvc = new Emg_HService();
	
	String emg_H_Id=(String)request.getAttribute("emg_H_Id");
	
	emg_HVO = emg_HSvc.getOneEmg_H(emg_H_Id);
	pageContext.setAttribute("emg_HVO",emg_HVO);	
	 
%>




	<h3>所有緊急求救 - ListOneEmg_H.jsp</h3>
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


	<table border='1' bordercolor='#CCCCFF' width='800' class="${emg_HVO.emg_H_status eq '已被檢舉'?'status':''}">
		<tr>
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
			<th>檢舉</th>

		</tr>
		



		
			<tr align='center' valign='middle' >

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
							name="emg_H_Id" value="${emg_HVO.emg_H_Id}">
							<input type="hidden" name="action" value="delete_Emg_H">
					</FORM>		
				</td>
				
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/front-end/emg_H/emg_H.do">
						<input type="submit" value="送出查詢"> <input type="hidden"
							name="emg_H_Id" value="${emg_HVO.emg_H_Id}"> 
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
				
				<td>
					<!-- 按下時跑出Form 表單填寫 -->
					<a href='#modal-id' data-toggle="modal" class="btn btn-primary">檢舉</a>
									
				</td>
				

			</tr>
		
	</table>



	
	<%if (request.getAttribute("listEmg_H_Msg_ByEmg_H_Id")!=null){%>
	<jsp:include page="/front-end/emg_H/listEmg_H_Msg_ByEmg_H_Id.jsp" />
	<%} %>

<!--  彈跳出的表單 -->
	<div class="modal fade" id="modal-id">
		<div class="modal-dialog">
			<div class="modal-content">

				<form id='report_form'>
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>

						<h4 class="modal-title">檢舉標題</h4>

						<input type='text' name="report_name" value="" id="report_name" >
					</div>


					<div class="modal-body">
						<h4 class="modal-title">檢舉內容</h4>
						<textarea rows="9" cols="75" name="report_content" value="" id="report_content" maxlength="80"></textarea>

						<%-- 傳送Report Table 所需要的欄位值 --%>
						<input type="hidden" name="report_class" value="emg_Help"> 
						<input type="hidden" name="report_class_No" value="emg_H_Id"> 
						<input type="hidden" name="report_class_No_value" value="${emg_HVO.emg_H_Id}"> 
						<input type="hidden" name="report_class_status" value="emg_H_status="> 											
						<input type="hidden" name="report_status" value="0"> 
						<input type="hidden" name="mem_Id_active" value="100"> <%--檢舉人ID 暫時寫 等SESSION 傳物件 --%>
						<input type="hidden" name="mem_Id_passive" value="${emg_HVO.mem_Id}"> 
						<input type="hidden" name="action" value="InsertReport">  
						
					</div>
					<div class="modal-footer">
						<button type="button" class=" btn btn-default " id="close" data-dismiss="modal">關閉</button>
						<button type="button" class="btn btn-primary" id="submit">送出</button>
					</div>
				</form>

			</div>
		</div>
	</div>

	<script>
	       	//JQuery Ajax 寫法 
	       	//submit 後傳送FORM表單的值
		   $("#submit").click(function(){
			  
			   $.ajax({
				   type:"POST",
				   url:"<%=request.getContextPath()%>/back-end/report/report.do",
				   data:$("#report_form").serialize(),
				   
					      
				   
				   success:function(data){
					   console.log(data);
					   alert("檢舉成功");
					   //檢舉成功後 Onclick 關閉彈跳出來的視窗
					   $("#close").click();
					   //把之前在Form表單裡的值清空
					   $("#report_name").val("");
					   $("#report_content").val("");
					   
				   },
				   error:function(data){
					   alert("傳送失敗")
				   }				   
				   
			   })
			   
		   });
	       	//如果是已檢舉的狀態 就隱藏
	       	$(".status").hide();
			  
	</script>






</body>
</html>