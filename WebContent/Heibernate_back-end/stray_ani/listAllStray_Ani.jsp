<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.stray_ani.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>
<%
    Stray_AniService stray_aniSvc = new Stray_AniService();
    List<Stray_AniVO> list = stray_aniSvc.getAll();
    pageContext.setAttribute("list",list);
%>
<html>
<head>
<title>所有社區流浪動物資料 - listAllStray_Ani.jsp</title>
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table class="table table-hover">
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>所有社區流浪動物資料 - ListAllStray_Ani.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/stray_ani/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
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
    <tr align='center' valign='middle'>
		<td><b>社區動物編號</b></td>		<td><b>發布者會員</b></td>		<td><b>流浪動物名字</b></td>		<td><b>流浪動物種類</b></td>		<td><b>流浪性別</b></td>		<td><b>流浪動物健康狀況</b></td>		<td><b>流浪動物疫苗接踵</b></td>		<td><b>流浪動物毛色</b></td>		<td><b>流浪動物體型</b></td>		<td><b>流浪動物年齡</b></td>		<td><b>流浪動物節育</b></td>		<td><b>流浪動物晶片編號</b></td>		<td><b>流浪動物發現時間</b></td>		<td><b>流浪動物物件狀態</b></td>		<td><b>流浪動物建立時間</b></td>		<td><b>流浪出沒地點經度</b></td>		<td><b>流浪出沒地點緯度</b></td>		<td><b>縣/市</b></td>		<td><b>鄉鎮市區</b></td>		<td><b>道路街名村里</b></td>    
        <td><b>修改</b></td>
        <td><b>刪除</b></td>
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
    <b><font color= red>第<%=whichPage%>/<%=pageNumber%>頁</font></b>
    <%}%>
    <b>●符 合 查 詢 條 件 如 下 所 示: 共<font color=red><%=rowNumber%></font>筆</b>
    <!-- END : include page1部分 -->
    <!-- 顯示查詢資料的部分 -->
    <c:forEach var="stray_aniVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
        <tr align='center' valign='middle' ${(stray_aniVO.stray_Ani_Id==param.stray_Ani_Id) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
			<td>${stray_aniVO.stray_Ani_Id}</td>
	<td>
		<font color=orange>${stray_aniVO.memVO.mem_Id}</font>
	</td>
			<td>${stray_aniVO.stray_Ani_name}</td>
			<td>${stray_aniVO.stray_Ani_type}</td>
			<td>${stray_aniVO.stray_Ani_gender}</td>
			<td>${stray_aniVO.stray_Ani_heal}</td>
			<td>${stray_aniVO.stray_Ani_Vac}</td>
			<td>${stray_aniVO.stray_Ani_color}</td>
			<td>${stray_aniVO.stray_Ani_body}</td>
			<td>${stray_aniVO.stray_Ani_age}</td>
			<td>${stray_aniVO.stray_Ani_Neu}</td>
			<td>${stray_aniVO.stray_Ani_chip}</td>
			<td>${stray_aniVO.stray_Ani_date}</td>
			<td>${stray_aniVO.stray_Ani_status}</td>
			<td>${stray_aniVO.stray_Ani_CreDate}</td>
			<td>${stray_aniVO.stray_Ani_FinLat}</td>
			<td>${stray_aniVO.stray_Ani_FinLon}</td>
			<td>${stray_aniVO.stray_Ani_city}</td>
			<td>${stray_aniVO.stray_Ani_town}</td>
			<td>${stray_aniVO.stray_Ani_road}</td>
            <!-- 修改按鈕部分 -->
            <td>
                <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/stray_ani/stray_ani.do">
                    <input type="submit" value="修改"> 
                    <input type="hidden" name="stray_Ani_Id" value="${stray_aniVO.stray_Ani_Id}">
                    <input type="hidden" name="requestURL" value="<%=request.getServletPath()%>"><!--送出本網頁的path給Controller-->
                    <input type="hidden" name="whichPage"  value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
                    <input type="hidden" name="action" value="getOne_For_Update">
                </FORM>
            </td>
            <!-- 刪除按鈕部分 -->
            <td>
              <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/stray_ani/stray_ani.do">
                <input type="submit" value="刪除">
                <input type="hidden" name="stray_Ani_Id" value="${stray_aniVO.stray_Ani_Id}">
                <input type="hidden" name="requestURL"  value="<%=request.getServletPath()%>"><!--送出本網頁的path給Controller-->
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
<br>本網頁的path:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>
</html>
