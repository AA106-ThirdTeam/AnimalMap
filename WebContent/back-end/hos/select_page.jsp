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

<h3>��Ƭd��:</h3>
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>�Эץ��H�U���~:
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
        <b>��J�j�M����:</b>
        <input type="text" name="searchCondition">
        <input type="submit" value="�e�X">
        <input type="hidden" name="action" value="listHos_BySearchCondition">
  </FORM>
  

<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hos.do" name="form1">
        <b><font color=blue>�U�νƦX�d��:</font></b> <br>
        <b>��J�ʪ���|�s��:</b>
        <input type="text" name="hos_Id" placeholder="13000000"><br>
         
         <b>��J�ʪ���|�W��:</b>
        <input type="text" name="hos_name" placeholder="XXX�ʪ���|"><br>
                      
       <b>��J�Ҧb����:</b>
       <input type="text" name="hos_city" placeholder="��饫"><br>
       
       <b>��J�Ҧb�m����:</b>
       <input type="text" name="hos_town" placeholder="���c��"><br>
       
       <b>��J�Ҧb�D��:</b>
       <input type="text" name="hos_road" placeholder="���j��"><br>
    
       
              
        <input type="submit" value="�e�X">
        <input type="hidden" name="action" value="listHos_ByCompositeQuery">
     </FORM>
  </li>
</ul>  
  
  
  

<h3>�ʪ���|�޲z</h3>

<ul>
  <li><a href='addHos.jsp'>Add</a> a new Hos.</li>
</ul>

</body>

</html>
