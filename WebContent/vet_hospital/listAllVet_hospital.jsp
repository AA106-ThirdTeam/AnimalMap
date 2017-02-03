<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.vet_hospital.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    Vet_hospitalService vet_hospitalSvc = new Vet_hospitalService();
    List<Vet_hospitalVO> list = vet_hospitalSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<html>
<head>
<title>所有診所資料 - listAllVet_hospital.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' >
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>所有診所資料 - ListAllVet_hospital.jsp</h3>
        <a href="<%=request.getContextPath()%>/vet_hospital/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

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

<table border='1' bordercolor='#CCCCFF' >
    <tr>
		<th>診所編號</th>
		<th>會員編號(負責人)</th>
		<th>診所名稱</th>
		<th>縣/市</th>
		<th>鄉鎮市區</th>
		<th>道路街名村里</th>
		<th>評價</th>
		<th>URL</th>
		<th>開始營業時間</th>
		<th>結束營業時間</th>
		<th>電話</th>
		<th>診所敘述</th>
		<th>診所經度座標</th>
		<th>診所緯度座標</th>
		<th>建立時間</th>
		<th>物件顯示狀態</th>

        <th>修改</th>
        <th>刪除</th>
    </tr>
    <!-- include page1部分 -->
    <%  int rowsPerPage = 3;  //每頁的筆數    
        int rowNumber=0;      //總筆數
        int pageNumber=0;     //總頁數      
        int whichPage=1;      //第幾頁
        int pageIndexArray[]=null;
        int pageIndex=0; 
    %>

    <%  
        rowNumber=list.size();
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
    <!-- END : include page1部分 -->

    <!-- 顯示查詢資料的部分 -->
    <c:forEach var="vet_hospitalVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
        <tr align='center' valign='middle'><!--將修改的那一筆加入對比色而已-->
			<td>${vet_hospitalVO.hos_Id}</td>
			<td>${vet_hospitalVO.mem_Id}</td>
			<td>${vet_hospitalVO.hos_name}</td>
			<td>${vet_hospitalVO.hos_city}</td>
			<td>${vet_hospitalVO.hos_town}</td>
			<td>${vet_hospitalVO.hos_road}</td>
			<td>${vet_hospitalVO.hos_Eval}</td>
			<td>${vet_hospitalVO.hos_URL}</td>
			<td>${vet_hospitalVO.hos_StartTime}</td>
			<td>${vet_hospitalVO.hos_EndTime}</td>
			<td>${vet_hospitalVO.hos_Tel}</td>
			<td>${vet_hospitalVO.hos_Desc}</td>
			<td>${vet_hospitalVO.hos_Long}</td>
			<td>${vet_hospitalVO.hos_Lat}</td>
			<td>${vet_hospitalVO.hos_CreateTime}</td>
			<td>${vet_hospitalVO.hos_visible}</td>
 
            <!-- 修改按鈕部分 -->
            <td>
                <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/vet_hospital/vet_hospital.do">
                    <input type="submit" value="修改"> 
                    <input type="hidden" name="hos_Id" value="${vet_hospitalVO.hos_Id}">
                    <input type="hidden" name="requestURL" value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
                    <input type="hidden" name="whichPage"  value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
                    <input type="hidden" name="action" value="getOne_For_Update">
                </FORM>
            </td>

            <!-- 刪除按鈕部分 -->
            <td>
              <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/vet_hospital/vet_hospital.do">
                <input type="submit" value="刪除">
                <input type="hidden" name="hos_Id" value="${vet_hospitalVO.hos_Id}">
                <input type="hidden" name="requestURL"  value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
                <input type="hidden" name="whichPage"   value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
                <input type="hidden" name="action" value="delete"></FORM>
            </td>            
        </tr>                       
    </c:forEach>  
</table>
<!-- page2部分 -->
<table border="0">
    <tr>
        <%if (rowsPerPage<rowNumber) {%>
        <%if(pageIndex>=rowsPerPage){%>
        <td><A href="<%=request.getRequestURI()%>?whichPage=1">至第一頁</A>&nbsp;</td>
        <td><A
            href="<%=request.getRequestURI()%>?whichPage=<%=whichPage-1%>">上一頁
        </A>&nbsp;</td>
        <%}%>

        <%if(pageIndex<pageIndexArray[pageNumber-1]){%>
        <td><A
            href="<%=request.getRequestURI()%>?whichPage=<%=whichPage+1%>">下一頁
        </A>&nbsp;</td>
        <td><A
            href="<%=request.getRequestURI()%>?whichPage=<%=pageNumber%>">至最後一頁</A>&nbsp;</td>
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
        <FORM METHOD="post" ACTION="<%=request.getRequestURI()%>">
            <td><select size="1" name="whichPage">
                    <%for (int i=1; i<=pageNumber; i++){%>
                    <option value="<%=i%>">跳至第<%=i%>頁
                        <%}%>
                    
            </select> <input type="submit" value="確定"></td>
        </FORM>
    </tr>
</table>
<%}%>

<br>本網頁的路徑:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>
</html>
