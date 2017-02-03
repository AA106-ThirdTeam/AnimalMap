 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>各個表格連結:</h3>
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


<!DOCTYPE html>
 <html lang="">
     <head>
         <meta charset="utf-8">
         <meta http-equiv="X-UA-Compatible" content="IE=edge">
         <meta name="viewport" content="width=device-width, initial-scale=1">
         <title>後台首頁</title>
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
         <!--[if lt IE 9]>
             <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
             <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
         <![endif]-->
     </head>
     <body>
         <table class="table table-hover">
             <tbody>
					<tr><td><a href='<%=request.getContextPath()%>/charge/select_page.jsp'>NO.1 : 儲值</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/product_kind/select_page.jsp'>NO.2 : 商品類別</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/orders_item/select_page.jsp'>NO.3 : 訂單明細</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/second_prodphotos/select_page.jsp'>NO.4 : 二手商品相簿</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/second_prodmsg/select_page.jsp'>NO.5 : 二手商品留言</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/product/select_page.jsp'>NO.6 : 商品</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/second_prod/select_page.jsp'>NO.7 : 二手商品</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/orders/select_page.jsp'>NO.8 : 訂單</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/rel_list/select_page.jsp'>NO.9 : 關係名單</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/priv_message/select_page.jsp'>NO.10 : 私人訊息</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/shop_comment/select_page.jsp'>NO.11 : 商家留言</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/shopphoto/select_page.jsp'>NO.12 : 商家相片</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/petshop/select_page.jsp'>NO.13 : 寵物商店</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/grp_comment/select_page.jsp'>NO.14 : 揪團留言</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/joinlist/select_page.jsp'>NO.15 : 揪團參加名單</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/pet_group/select_page.jsp'>NO.16 : 揪團</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/hosphoto/select_page.jsp'>NO.17 : 診所相片</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/hos_comment/select_page.jsp'>NO.18 : 診所留言</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/vet_hospital/select_page.jsp'>NO.19 : 診所</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/stray_ani_photos/select_page.jsp'>NO.20 : 社區流浪動物相簿</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/stray_ani_message/select_page.jsp'>NO.21 : 社區流浪動物留言</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/stray_ani_loc/select_page.jsp'>NO.22 : 社區流浪動物出沒範圍</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/stray_ani/select_page.jsp'>NO.23 : 社區流浪動物</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/pet_photos/select_page.jsp'>NO.24 : 自家寵物相簿</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/pet_message/select_page.jsp'>NO.25 : 自家寵物留言</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/pet/select_page.jsp'>NO.26 : 自家寵物</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/adopt_ani_photos/select_page.jsp'>NO.27 : 送養動物相簿</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/adopt_ani_message/select_page.jsp'>NO.28 : 送養動物留言</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/adopt_ani_sponsor/select_page.jsp'>NO.29 : 送養動物贊助</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/adoanispo/select_page.jsp'>NO.30 : 送養動物領養人</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/adopt_ani/select_page.jsp'>NO.31 : 送養動物</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/res_ponse/select_page.jsp'>NO.32 : 討論區留言</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/offimsg/select_page.jsp'>NO.33 : 公告訊息</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/post/select_page.jsp'>NO.34 : 討論區</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/emp_purview/select_page.jsp'>NO.35 : 員工權限</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/purview/select_page.jsp'>NO.36 : 權限</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/animal_index/select_page.jsp'>NO.37 : 動物圖鑑</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/emg_h_msg/select_page.jsp'>NO.38 : 緊急求救留言</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/emg_h/select_page.jsp'>NO.39 : 緊急求救</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/track/select_page.jsp'>NO.40 : 追蹤收藏</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/adpphotos/select_page.jsp'>NO.41 : 領養活動相簿</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/adpmsg/select_page.jsp'>NO.42 : 領養活動留言</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/adp/select_page.jsp'>NO.43 : 領養活動</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/park/select_page.jsp'>NO.44 : 公園</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/anihome_photos/select_page.jsp'>NO.45 : 動物之家相簿</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/anihome_msg/select_page.jsp'>NO.46 : 動物之家留言</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/anihome/select_page.jsp'>NO.47 : 動物之家</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/mem/select_page.jsp'>NO.48 : 一般會員</a></td></tr>
					<tr><td><a href='<%=request.getContextPath()%>/emp/select_page.jsp'>NO.49 : 員工</a></td></tr>

             </tbody>
         </table>
         
         <script src="https://code.jquery.com/jquery.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
     </body>
 </html> 
