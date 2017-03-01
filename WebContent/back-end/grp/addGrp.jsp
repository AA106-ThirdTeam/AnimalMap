<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="com.grp.model.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>


<%
	GrpVO grpVO = (GrpVO) request.getAttribute("grpVO");
%>

<html>
<head>

<title>揪團資料新增 - addHos.jsp</title>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link href="js/jquery-ui-timepicker-addon.css" rel="stylesheet"></link>
<script src="js/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script src="js/jquery-ui-sliderAccess.js" type="text/javascript"></script>

</head>
<%-- <jsp:include page="js/pickTime.file" flush="true"/> --%>


<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>揪團資料新增 - addGrp.jsp</h3>
			</td>
			<td><a href="select_page.jsp"><img src="js/avatar.jpg"
					width="100" height="100" border="1">回首頁</a></td>
		</tr>
	</table>

	<h3>新增揪團資料:</h3>
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

	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/grp/grp.do" name="form1" method=post
		enctype="multipart/form-data">
		<table border="0">
<% System.out.print(request.getContextPath()+"/grp/grp.do"); %>
			<tr>
				<td>揪團名稱:</td>
				<td><input type="TEXT" name="grp_name" size="45"
					value="<%=(grpVO == null) ? "JAVA動物團" : grpVO.getGrp_name()%>" /></td>
			</tr>
			<tr>
				<td>主揪人:</td>
				<td><input type="TEXT" name="grp_MemId" size="45"
					value="<%=(grpVO == null) ? "Peter" : grpVO.getGrp_MemId()%>" /></td>
			</tr>

			<%
				String startStr = null;
				String endStr = null;

				if (grpVO != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					startStr = sdf.format(grpVO.getGrp_StartTime());
					endStr = sdf.format(grpVO.getGrp_EndTime());
				}

				String now = new SimpleDateFormat("yyyy-MM-dd HH:mm")
						.format(new Date(System.currentTimeMillis()));
			%>



			<tr>

				<td>揪團開始時間:</td>
				<td><input id="datetimepicker1" type="text"
					name="grp_StartTime" value="<%=(grpVO == null) ? now : startStr%>" /></td>
			</tr>
			<tr>
				<td>揪團結束時間:</td>
				<td><input id="datetimepicker2" type="text" name="grp_EndTime"
					value="<%=(grpVO == null) ? now : endStr%>" /></td>
			</tr>

			<tr>
				<td>地址</td>
				<td></td>
			</tr>


			<tr>
				<td>市:</td>
				<td><input type="TEXT" name="grp_city" size="45"
					value="<%=(grpVO == null) ? "桃園市" : grpVO.getGrp_city()%>" /></td>
			</tr>
			<tr>
				<td>區:</td>
				<td><input type="TEXT" name="grp_town" size="45"
					value="<%=(grpVO == null) ? "中壢區" : grpVO.getGrp_town()%>" /></td>
			</tr>
			<tr>
				<td>路:</td>
				<td><input type="TEXT" name="grp_road" size="45"
					value="<%=(grpVO == null) ? "中大路" : grpVO.getGrp_road()%>" /></td>
			</tr>

			<tr>
				<td>揪團簡介:</td>
				<td><textarea style="height: 2em" rows="1" cols="20" id="text"
						maxlength="300" name="grp_Desc"><%=(grpVO == null) ? "" : grpVO.getGrp_Desc()%></textarea>
				</td>
			</tr>

			<tr>
				<td>經度:</td>
				<td><input type="text" name="grp_Long" size="100"
					value=" <%=(grpVO == null) ? "" : grpVO.getGrp_Long()%>" /></td>
			</tr>
			<tr>
				<td>緯度:</td>
				<td><input type="text" name="grp_Lat" size="100"
					value=" <%=(grpVO == null) ? "" : grpVO.getGrp_Lat()%>" /></td>
			</tr>

			<tr>
				<td>地圖上顯示:<font color=red><b>?</b></font></td>
				<td><select size="1" name="grp_visible">
						<option value="0" ${(grpVO.grp_visible==0)? 'selected':'' }>No
						<option value="1" ${(grpVO.grp_visible==1)? 'selected':'' }>Yes

				</select></td>
			</tr>

			<tr>
				<td>上傳一張照片吧:</td>
				<td><img id="blah" style="max-width: 100px; max-height: 100px">
					<input type="file" name="grp_photo" id="imgInp" /></td>
			</tr>


		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>
	
	<div id="output"></div>
	
	
</body>
<script>
	function readURL(input) {

		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {

				$('#blah').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}

	$("#imgInp").click(function() {
		$('#blah').attr('src', '');
	});

	$("#imgInp").change(function() {
		readURL(this);
	});

	var opt = {
		dateFormat : 'yy-mm-dd',
		showSecond : false,
		timeFormat : 'HH:mm'
	};
	$('#datetimepicker1').datetimepicker(opt);
	$('#datetimepicker2').datetimepicker(opt);
	
	$('#datetimepicker1').focus(function(){
	    $(this).attr('readonly', true);
	});
	
	$('#datetimepicker2').focus(function(){
	    $(this).attr('readonly', true);
	});
	
	
	
</script>
</html>
