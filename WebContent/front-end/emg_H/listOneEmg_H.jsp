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
	
	String emg_H_Id=(String)request.getAttribute("emg_H_Id");
	
	emg_HVO = emg_HSvc.getOneEmg_H(emg_H_Id);
	pageContext.setAttribute("emg_HVO",emg_HVO);	
	 
%>




	<h3>所有緊急求救 - ListOneEmg_H.jsp</h3> 
	<a href="<%=request.getContextPath()%>/front-end/emg_H_Msg/select_page.jsp">回首頁</a><br>


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
	
			<H3>求救標題 : ${emg_HVO.emg_H_title} </H3>
<!-- 			<h5>求救圖片</h5> -->
			<div><img src="<%=request.getContextPath()%>/Emg_H_PicReader?emg_H_Id= ${emg_HVO.emg_H_Id}" class="pic img-rounded"></div>
			<br>
			<h5>求救編號 :  ${emg_HVO.emg_H_Id} </h5>
			<h5>會員編號 :  ${emg_HVO.mem_Id} </h5>
			<h5>開始時間 :  ${emg_HVO.emg_H_start_date}</h5>
			<h5>結束時間 :  ${emg_HVO.emg_H_end_date}	</h5>
			<h5>縣市 :  ${emg_HVO.emg_H_city}</h5>
			<h5>市區 :  ${emg_HVO.emg_H_town}</h5>
			<h5>街道 :  ${emg_HVO.emg_H_road}</h5>
			<h5>經度 :  ${emg_HVO.emg_H_Lon}</h5>
			<h5>緯度 :  ${emg_HVO.emg_H_Lat}</h5>
			
			
		<div class="col-xs-12 col-sm-12 ">
			<table border="0">
				<tr>
					<td>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/front-end/emg_H/emg_H.do">
								<input type="submit" value="刪除" class="btn btn-danger"> 
								<input type="hidden" name="emg_H_Id" value="${emg_HVO.emg_H_Id}">
								<input type="hidden" name="action" value="delete_Emg_H">
							</FORM>		
					</td>
					
					
					<td>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/front-end/emg_H/emg_H.do">
								<input type="submit" value="查看留言" class="btn btn-info" >
								<input type="hidden" name="emg_H_Id" value="${emg_HVO.emg_H_Id}"> 
								<input type="hidden" name="action" value="listEmg_H_Msg_ByEmg_H_Id_B">
								<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
							</FORM>		
									
						</td>
						
						<td>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/front-end/emg_H_Msg/emg_H_Msg.do">
								<input type="submit" value="新增留言 " class="btn btn-info"> 
								<input type="hidden" name="emg_H_Id" value="${emg_HVO.emg_H_Id}"> 
								<input type="hidden" name="action" value="insert_Emg_MsgByEmg_H">
								<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
									
							</FORM>		
						</td>
						
						<td>
							<!-- 按下時跑出Form 表單填寫 -->
							<a href='#modal-id' data-toggle="modal" class="btn btn-info">檢舉</a>
											
						</td>
				</tr>
			</table>
		</div>
		
	</div> 
 
 	<div class="col-xs-12 col-sm-9 right" >
			<H3>求救內容</H3>
			<br>
			<p>${emg_HVO.emg_H_content}</p>
		
		<%--include 進來的頁面 --%>
			<div>
			<%if (request.getAttribute("listEmg_H_Msg_ByEmg_H_Id")!=null){%>
			<jsp:include page="/front-end/emg_H/listEmg_H_Msg_ByEmg_H_Id.jsp" />
			<%} %>
			</div>	
		<br>	
		<%--之後 引用進來的區塊 --%>
			<div>
			22222222222222222222222222222222222
			</div>
		
	</div>
</div>

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
						<input type="hidden" name="mem_Id_active" value="1000003"> <%--檢舉人ID 暫時寫 等SESSION 傳物件 --%>
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