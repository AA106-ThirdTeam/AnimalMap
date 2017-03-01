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
.right{
   padding:35px;
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

				<form id='report_form'>
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>

						<h4 class="modal-title">檢舉標題</h4>

						<input type='text' name="report_name" value="" id="report_name" >
					</div>


					<div class="modal-body">
						<h4 class="modal-title">檢舉內容</h4>
						<textarea rows="9" cols="50" name="report_content" value="" id="report_content" maxlength="80"></textarea>

						<%-- 傳送Report Table 所需要的欄位值 --%>
						<input type="hidden" name="report_class" value="emg_Help"> 
						<input type="hidden" name="report_class_No" value="emg_H_Id"> 
						<input type="hidden" name="report_class_No_value" value="${emg_HVO.emg_H_Id}"> 
						<input type="hidden" name="report_class_status" value="emg_H_status="> 											
						<input type="hidden" name="report_status" value="0"> 
						<input type="hidden" name="mem_Id_active" value="1000003"> <%--檢舉人ID 暫時寫 等SESSION 傳物件 --%>
						<input type="hidden" name="mem_Id_passive" value="${emg_HVO.mem_Id}"> 
						<input type="hidden" name="action" value="InsertReport">  
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="submit">送出</button>
					</div>
				</form>

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