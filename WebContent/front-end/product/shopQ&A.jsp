<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>shopQ&A.jsp</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<meta name="description" content="Flexible Slide-to-top Accordion" />
<meta name="keywords" content="accordion, jquery, flexible, responsive, slide to top, tabs, UI, web design" />
<meta name="author" content="Codrops" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/layout.css" />
<link rel="shortcut icon" href="../favicon.ico"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/front-end/css/QAdemo.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/front-end/css/QAstyle.css" />
<link href='http://fonts.googleapis.com/css?family=Josefin+Slab:400,700' rel='stylesheet' type='text/css' />
	<style>
		.st-accordion ul li{
			height:auto;
		}
		.st-accordion ul li > a span{
			visibility:hidden;
		}
	</style>
</head>
<body>

<div id="layout">
	<div id="header">
		<div id="logo"><a href="#"><img src="<%=request.getContextPath()%>/front-end/images/1.png" alt="" /></a>
		</div><!-- End div_logo-->
<!--    		<div class="member_login"> -->
<!--       		<div class="login_box"> -->
<!-- 				<form action="" method="get"> -->
<!-- 					<fieldset> -->
<!-- 	          			<div class="column_1"> -->
<!-- 				            <label>username :</label> -->
<!-- 				            <label>password :</label> -->
<!-- 						</div>End div_column_1 -->
<!-- 	          			<div class="column_2"> -->
<!-- 				            <input type="text" name="" value="" /> -->
<!-- 				            <input type="text" name="" value="" /> -->
<!-- 	          			</div>End div_column_2 -->
<!-- 	          			<div class="column_3"> -->
<%-- 	           				<input type="image" src="<%=request.getContextPath()%>/front-end/images/login_btn.gif" class="login"/> --%>
<!-- 	          			</div>End div_column_3 -->
<!-- 	          			<div class="column_4"> -->
<!--            	 			<label class="password"><a href="#">Forgot <br /> -->
<!--            					 password</a></label> -->
<!--           			</div> -->
<!--           			</fieldset> -->
<!-- 				</form> -->
<!--       		</div>End div_login_box -->
<!--     	</div>End div_number_login -->
  	</div><!-- End div_header-->
<div id="body_container">
	<div id="body_container_inner">
		<div id="menu">
			<ul>
	          <li class="first"><a href="<%=request.getContextPath()%>/front-end/product/Shopindex.jsp">home</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/product/Shop.jsp">Product</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/orders/listMyOrders.jsp">Orders</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/charge/Charge.jsp">Charge</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/product/Cart.jsp">ShoppingCart</a></li>
	          <li><a class="current">Q&A</a></li>
          	</ul>
      	</div><!-- menuEnd -->
      	<div class="banner"><a href="#">
			<img src="<%=request.getContextPath()%>/front-end/images/banner2.jpg" /></a>
		</div><!-- End div_banner-->
      	<div class="container_row">
        	<div class="welcomezone"><!-- 內容START-->
    			<div class="container">            
            		<div class="wrapper">
               			 <div id="st-accordion" class="st-accordion">
                    		<ul>
		                        <li>
		                            <a href="#" style="font-family:Microsoft JhengHei ;font-size:xx-large">Q1:可以退換貨嗎？<span class="st-arrow">Open or Close</span></a>
		                            <div class="st-content">
		                                <p><span class="inner" style="font-size: 18px">
		                                1.接觸性商品一旦經過拆封使用、洗滌，基於寵物衛生及健康之理由，為了避免任何接觸性傳染疾病，恕不接受退換。（接觸商品包括：寵物衣服、寵物床墊、寵物背巾、寵物外出箱.包.籠等.....）
										</span></p>
		                                <p><span class="inner" style="font-size: 18px">
										2.收到商品若發現瑕疵品日起兩日內發e-mail與照片通知，有任何問題可以與我們客服聯絡。
										</span></p>
		                            </div>
		                        </li>
		                        <li>
		                            <a href="#" style="font-family:Microsoft JhengHei ;font-size:xx-large">Q2:購物滿多少免運?<span class="st-arrow">Open or Close</span></a>
		                            <div class="st-content">
		                                <p><span class="inner" style="font-size: 18px">
										購物金額滿1500元以上免運費，貨到付款需另加收30元手續費。 送件時間：早上、下午、晚上(運送時間不包含六、日及國定假日)。處理時間：約為3到14天。(商品缺貨或預購不在此限)
										</span></p>
		                            </div>
		                        </li>
		                        <li>
		                            <a href="#" style="font-family:Microsoft JhengHei ;font-size:xx-large">Q3:懷孕的母狗也能使用嗎?<span class="st-arrow">Open or Close</span></a>
		                            <div class="st-content">
		                                <p><span class="inner" style="font-size: 18px">
										YES!不影響!敬請安心使用
										</span></p>
		                            </div>
		                        </li>
		                        <li>
		                            <a href="#" style="font-family:Microsoft JhengHei ;font-size:xx-large">Q4:請問可以寄送到外島或海外嗎？<span class="st-arrow">Open or Close</span></a>
		                            <div class="st-content">
		                                <p><span class="inner" style="font-size: 18px">
										目前僅提供台灣本島的寄送服務。<br>
										海外人士或離島人士訂購，請您提供台灣親朋好友之寄送地址代為收貨。
										</span></p>
		                            </div>
		                        </li> 
							</ul>
						</div><!-- st-accordionEnd -->
					</div><!-- wrapperEnd -->
				</div><!-- containerEnd -->        
			</div><!-- 內容END-->
      	</div>  
		<div id="footer">
        	<div class="footer_link">
        		<ul style="color:#FFf;">
          		SSSSSSSSSSSSSS
				</ul>
        	</div><!-- End div_footer_link-->
		</div><!-- End div_footer-->
    </div><!-- End body_container_inner-->
</div><!-- End body_container-->
</div><!-- End layout-->

  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/jquery.accordion.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/jquery.easing.1.3.js"></script>
        <script type="text/javascript">
            $(function() {
			
				$('#st-accordion').accordion();
				
            });
        </script>
</body>
</html>

