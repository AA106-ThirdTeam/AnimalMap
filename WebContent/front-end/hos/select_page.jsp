<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>G3 VetHos: Home</title></head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>G3 VetHos: Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for G3 VetHos: Home</p>

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
  <li><a href='listAllHos.jsp'>List</a> all Hos. </li> <br><br>
  
  
  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hos.do" >
        <b>輸入搜尋條件:</b>
        <input type="text" name="searchCondition">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="listHos_BySearchCondition">
  </FORM>
  

<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hos.do" name="form1">
        <b><font color=blue>萬用複合查詢:</font></b> <br>
        <b>輸入動物醫院編號:</b>
        <input type="text" name="hos_Id" placeholder="13000000"><br>
         
         <b>輸入動物醫院名稱:</b>
        <input type="text" name="hos_name" placeholder="XXX動物醫院"><br>
                      
       <b>輸入所在縣市:</b>
       <input type="text" name="hos_city" placeholder="桃園市"><br>
       
       <b>輸入所在鄉鎮市區:</b>
       <input type="text" name="hos_town" placeholder="中壢區"><br>
       
       <b>輸入所在道路:</b>
       <input type="text" name="hos_road" placeholder="中大路"><br>
    
       
              
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="listHos_ByCompositeQuery">
     </FORM>
  </li>
</ul>  
  
  
  

<h3>動物醫院管理</h3>

<ul>
  <li><a href='addHos.jsp'>Add</a> a new Hos.</li>
</ul>

</body>

</html>
