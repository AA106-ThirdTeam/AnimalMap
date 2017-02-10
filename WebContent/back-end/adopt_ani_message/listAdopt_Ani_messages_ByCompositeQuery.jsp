	
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 錯誤表列 --%>
<c:if test="false">
  <font color='red'>請修正以下錯誤:
  <ul>
  <c:forEach var="message" items="">
    <li></li>
  </c:forEach>
  </ul>
  </font>
</c:if>

<%-- 萬用複合查詢-可由客戶端select_page.jsp隨意增減任何想查詢的欄位 --%>
<%-- 此頁只作為複合查詢時之結果練習，可視需要再增加分頁、送出修改、刪除之功能--%>

<jsp:useBean id="listAdopt_Ani_messages_ByCompositeQuery" scope="request" type="java.util.List" />


<!-- ====  ==== -->

<html>
<head>
<title>複合查詢 - listAdopt_Ani_messages_ByCompositeQuery.jsp</title>
	<!-- 共用HEAD -->
	
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>

</head>
<body bgcolor='white'>
<b><font color=blue>
☆萬用複合查詢-可由客戶端select_page.jsp隨意增減任何想查詢的欄位<br>
☆此頁作為複合查詢時之結果練習，</font> <font color=red>已增加分頁、送出修改、刪除之功能:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3><font color=red>複合查詢</font>送養動物留言 - listAdopt_Ani_messages_ByCompositeQuery.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/adopt_ani_message/select_page.jsp"><img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!-- ==== ==== -->

<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>送養動物留言編號</th>		<th>社區動物編號</th>		<th>送養動物會員編號</th>		<th>送養動物留言</th>		<th>發布時間</th>  
        <th>修改</th>
        <th>刪除</th>
    </tr>

<!-- page1_ByCompositeQuery start -->
<%  int rowsPerPage = 3;  //每頁的筆數    
    int rowNumber=0;      //總筆數
    int pageNumber=0;     //總頁數      
    int whichPage=1;      //第幾頁
    int pageIndexArray[]=null;
    int pageIndex=0; 
%>
 
<%  
    rowNumber=listAdopt_Ani_messages_ByCompositeQuery.size();
    if (rowNumber%rowsPerPage !=0)
     pageNumber=rowNumber/rowsPerPage +1;
    else pageNumber=rowNumber/rowsPerPage;    

    pageIndexArray=new int[pageNumber]; 
    for (int i=1 ; i<=pageIndexArray.length ; i++)
    pageIndexArray[i-1]=i*rowsPerPage-rowsPerPage;
%>

<%  try {
      whichPage = Integer.parseInt(request.getParameter("whichPage"));
      pageIndex=pageIndexArray[whichPage-1];
    } catch (NumberFormatException e) { //第一次執行的時候
       whichPage=1;
       pageIndex=0;
    } catch (ArrayIndexOutOfBoundsException e) { //總頁數之外的錯誤頁數
         if (pageNumber>0){
              whichPage=pageNumber;
              pageIndex=pageIndexArray[pageNumber-1];
         }
    } 
%>
<%if (pageNumber>0){%>
<b><font color= red>第<%=whichPage%>/<%=pageNumber%>頁　</font></b>
<%}%>
<b>●符 合 查 詢 條 件 如 下 所 示: 共<font color=red><%=rowNumber%></font>筆</b>
<!-- page1_ByCompositeQuery end -->

    <c:forEach var="adopt_ani_messageVO" items="${listAdopt_Ani_messages_ByCompositeQuery}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
        <tr align='center' valign='middle' ${(adopt_ani_messageVO.ado_Ani_Mes_No==param.ado_Ani_Mes_No) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->    
			<td>${adopt_ani_messageVO.ado_Ani_Mes_No}</td>			<td>${adopt_ani_messageVO.adopt_Ani_Id}</td>			<td>${adopt_ani_messageVO.mem_Id}</td>			<td>${adopt_ani_messageVO.ado_Ani_Mes}</td>			<td>${adopt_ani_messageVO.ado_Ani_Mes_time}</td>  
            <td>
                <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/adopt_ani_message/adopt_ani_message.do">
                    <input type="submit" value="修改"> 
                    <input type="hidden" name="ado_Ani_Mes_No" value="${adopt_ani_messageVO.ado_Ani_Mes_No}">
                    <input type="hidden" name="requestURL" value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
                    <input type="hidden" name="whichPage"  value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
                    <input type="hidden" name="action" value="getOne_For_Update">
                </FORM>
            </td>
            <td>
                <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/adopt_ani_message/adopt_ani_message.do">
                    <input type="submit" value="刪除">
                    <input type="hidden" name="ado_Ani_Mes_No" value="${adopt_ani_messageVO.ado_Ani_Mes_No}">
                    <input type="hidden" name="requestURL"  value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
                    <input type="hidden" name="whichPage"   value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
                    <input type="hidden" name="action"value="delete">
                </FORM>
            </td> 
        </tr>
    </c:forEach>
</table>

<!-- page2_ByCompositeQuery -->
<table border="0">    
 <tr>
  <%if (rowsPerPage<rowNumber) {%>
    <%if(pageIndex>=rowsPerPage){%>
        <td><A href="<%=request.getContextPath()%>/adopt_ani_message/adopt_ani_message.do?whichPage=1&action=listAdopt_Ani_messages_ByCompositeQuery">至第一頁</A>&nbsp;</td>
        <td><A href="<%=request.getContextPath()%>/adopt_ani_message/adopt_ani_message.do?whichPage=<%=whichPage-1%>&action=listAdopt_Ani_messages_ByCompositeQuery">上一頁 </A>&nbsp;</td>
    <%}%>
  
    <%if(pageIndex<pageIndexArray[pageNumber-1]){%>
        <td><A href="<%=request.getContextPath()%>/adopt_ani_message/adopt_ani_message.do?whichPage=<%=whichPage+1%>&action=listAdopt_Ani_messages_ByCompositeQuery">下一頁 </A>&nbsp;</td>
        <td><A href="<%=request.getContextPath()%>/adopt_ani_message/adopt_ani_message.do?whichPage=<%=pageNumber%>&action=listAdopt_Ani_messages_ByCompositeQuery">至最後一頁</A>&nbsp;</td>
    <%}%>
  <%}%>  
 </tr>
</table>    
<%if ( pageNumber > 1) {%>
<table border="0">   
 <tr> 
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </td>
   <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/adopt_ani_message/adopt_ani_message.do">   
        <td>
           <select size="1" name="whichPage">
        <%for (int i=1; i<=pageNumber; i++){%>
           <option value="<%=i%>">跳至第<%=i%>頁
        <%}%> 
           </select>
           <input type="submit" value="確定" >
           <input type="hidden" name="action"  value="listAdopt_Ani_messages_ByCompositeQuery">  
        </td>
   </FORM>
 </tr>
</table>
<%}%>


<!-- footer -->
<br>本網頁的路徑:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>
</body>
</html>        
