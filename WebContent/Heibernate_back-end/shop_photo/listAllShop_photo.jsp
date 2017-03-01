<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.shop_photo.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>
<%
    Shop_photoService shop_photoSvc = new Shop_photoService();
    List<Shop_photoVO> list = shop_photoSvc.getAll();
    pageContext.setAttribute("list",list);
%>
<html>
<head>
<title>所有商家相片資料 - listAllShop_photo.jsp</title>
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
        <h3>所有商家相片資料 - ListAllShop_photo.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/shop_photo/select_page.jsp">
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
		<td><b>相片編號</b></td>		<td><b>商家(相片擁有商家)</b></td>		<td><b>相片</b></td>		<td><b>是否為大頭貼相片</b></td>		<td><b>相片名稱</b></td>		<td><b>相片副檔名</b></td>    
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
    <c:forEach var="shop_photoVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
        <tr align='center' valign='middle' ${(shop_photoVO.shopPhoto_Id==param.shopPhoto_Id) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
			<td>${shop_photoVO.shopPhoto_Id}</td>
	<td>
		<font color=orange>${shop_photoVO.petShopVO.shop_Id}</font>
	</td>
	<td><img src="https://i.imgur.com/rv4YG8U.jpg" style="width:304px;height:228px;"></td>
			<td>${shop_photoVO.isDisp_shopPhoto}</td>
			<td>${shop_photoVO.shopPhoto_name}</td>
			<td>${shop_photoVO.SHOPPHOTO_EXTENTION}</td>
            <!-- 修改按鈕部分 -->
            <td>
                <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/shop_photo/shop_photo.do">
                    <input type="submit" value="修改"> 
                    <input type="hidden" name="shopPhoto_Id" value="${shop_photoVO.shopPhoto_Id}">
                    <input type="hidden" name="requestURL" value="<%=request.getServletPath()%>"><!--送出本網頁的path給Controller-->
                    <input type="hidden" name="whichPage"  value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
                    <input type="hidden" name="action" value="getOne_For_Update">
                </FORM>
            </td>
            <!-- 刪除按鈕部分 -->
            <td>
              <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/shop_photo/shop_photo.do">
                <input type="submit" value="刪除">
                <input type="hidden" name="shopPhoto_Id" value="${shop_photoVO.shopPhoto_Id}">
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
