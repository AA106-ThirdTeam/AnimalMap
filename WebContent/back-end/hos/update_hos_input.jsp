<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="com.hos.model.*"%>

<%
HosVO hosVO = (HosVO) request.getAttribute("hosVO");
%>

<html>
<head>
<title>動物醫院資料新增 - addHos.jsp</title></head>


<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>動物醫院資料更新 - updateHos.jsp</h3>
		</td>
		<td>
		   <a href="select_page.jsp"><img src="js/avatar.jpg" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>更新醫院資料:</h3>
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

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hos.do">
<table border="0">
	
	<tr>
		<td>診所編號:</td>
		<td>${hosVO.hos_Id}</td>
		
	</tr>
	
	
	<tr>
		<td>診所名稱:</td>
		<td><input type="TEXT" name="hos_name" size="45" 
			value="<%= (hosVO==null)? "JAVA動物醫院" : hosVO.getHos_name()%>" /></td>
	</tr>
	<tr>
		<td>負責人:</td>
		<td><input type="TEXT" name="hos_MemId" size="45"
			value="<%= (hosVO==null)? "吳永志" : hosVO.getHos_MemId()%>" /></td>
	</tr>
	<tr>
<%-- 		<%java.sql.Date date_SQL = new java.sql.Date(System.currentTimeMillis());%> --%>
		
		<td>
		<div id="basicExample">
		開始營業時間:
		<input type="text" class="date start" hidden/>		
		<input type="text" class="time start" name="hos_StartTime" 
		value="<%= (hosVO==null)? "07:30 AM" : hosVO.getHos_StartTime()%>" /> to<br/>
		結束營業時間:
		<input type="text" class="date end" hidden/>
		<input type="text" class="time end" name="hos_EndTime" value="<%= (hosVO==null)? "07:30 PM" : hosVO.getHos_EndTime()%>" />
		</div>
		</td>
	</tr>
	
	<tr>
		<td>地址</td>
		<td></td>
	</tr>
	
	
	<tr>
		<td>市:</td>
		<td><input type="TEXT" name="hos_city" size="45"
			value="<%= (hosVO==null)? "桃園市" : hosVO.getHos_city()%>" /></td>
	</tr>
	<tr>
		<td>區:</td>
		<td><input type="TEXT" name="hos_town" size="45"
			value="<%= (hosVO==null)? "中壢區" : hosVO.getHos_town()%>" /></td>
	</tr>
	<tr>
		<td>路:</td>
		<td><input type="TEXT" name="hos_road" size="45"
			value="<%= (hosVO==null)? "中大路" : hosVO.getHos_road()%>" /></td>
	</tr>
	
	<tr>
		<td>醫院簡介:</td>
		<td>
		<textarea style="height:2em" rows="1" cols="20" 
		id="text"  maxlength="300" name="hos_Desc" 
		><%= (hosVO==null)? "" : hosVO.getHos_Desc()%></textarea>
		</td>
	</tr>
	
	<tr>
		<td>經度:</td>
		<td>
		<input type="text" name="hos_Long" size="100" value=" <%= (hosVO==null)? "" : hosVO.getHos_Long()%>"/>
		</td>
	</tr>
	<tr>
		<td>緯度:</td>
		<td>
		<input type="text" name="hos_Lat" size="100" value=" <%= (hosVO==null)? "" : hosVO.getHos_Lat()%>"/>
		</td>
	</tr>
	
	<tr>
		<td>地圖上顯示:<font color=red><b>?</b></font></td>
		<td><select size="1" name="hos_visible">
			<option value="0" ${(hosVO.hos_visible==0)? 'selected':'' } >No
			<option value="1" ${(hosVO.hos_visible==1)? 'selected':'' } >Yes
		</select>
		</td>
	</tr>
	
	
	<tr>
		<td>評價:</td>
		<td>
		<input type="text" name="hos_Eval" size="100" value=" <%= (hosVO==null)? "" : hosVO.getHos_Eval()%>"/>
		</td>
	</tr>
	<tr>
		<td>網址:</td>
		<td>
		<input type="text" name="hos_URL" size="200" value=" <%= (hosVO==null)? "" : hosVO.getHos_URL()%>"/>
		</td>
	</tr>
	<tr>
		<td>電話:</td>
		<td>
		<input type="text" name="hos_Tel" size="45" value=" <%= (hosVO==null)? "" : hosVO.getHos_Tel()%>"/>
		</td>
	</tr>


	 

</table>
<br>

<input type="hidden" name="action" value="update">
<input type="hidden" name="hos_Id" value="<%=hosVO.getHos_Id()%>">
<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
<input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllEmp.jsp 與 複合查詢 listEmps_ByCompositeQuery.jsp-->
<input type="submit" value="送出新增"></FORM>
</body>

</html>
