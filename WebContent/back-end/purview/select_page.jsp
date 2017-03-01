<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>select page</title>
</head>
<body>

	<h3>資料查詢:</h3>
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

	<ul>
		<li><a href='<%=request.getContextPath() %>/back-end/purview/listAllPurview.jsp'>List</a> all Purview.</li>
		<br>
		<br>



		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath() %>/back-end/purview/purview.do">
				<b>輸入權限編號</b> <input type="text" name="purview_No"> <input
					type="submit" value="送出"> <input type="hidden"
					name="action" value="getOne_For_Display">
			</FORM>
		</li>

		<jsp:useBean id="purviewSvc" scope="page"
			class="com.purview.model.PurviewService" />

		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath() %>/back-end/purview/purview.do">
				<b>選擇權限編號:</b> <select size="1" name="purview_No">
					<c:forEach var="purviewVO" items="${purviewSvc.all}">
						<option value="${purviewVO.purview_No}">${purviewVO.purview_No}
					</c:forEach>
				</select> <input type="submit" value="送出"> <input type="hidden"
					name="action" value="getOne_For_Display">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath() %>/back-end/purview/purview.do">
				<b>選擇權限名稱:</b> <select size="1" name="purview_No">
					<c:forEach var="purviewVO" items="${purviewSvc.all}">
						<option value="${purviewVO.purview_No}">${purviewVO.purview_name}
					</c:forEach>
				</select> <input type="submit" value="送出"> <input type="hidden"
					name="action" value="getOne_For_Display">
			</FORM>
		</li>
	</ul>


	<h3>權限管理</h3>

	<ul>
		<li><a href='<%=request.getContextPath() %>/back-end/purview/addPurview.jsp'>Add</a> a new purview.</li>
	</ul>




</body>
</html>