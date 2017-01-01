<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="zh" class="no-js">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/reset.css">
<!-- 不能刪 CSS reset -->
<link rel="stylesheet" href="css/default.css">
<!-- 不能刪  CSS reset -->
<link rel="stylesheet" href="css/style.css">
<!-- Resource style -->
<script src="js/modernizr.js"></script>
<!-- 讓我們知道語法有沒有過期 -->
<!-- Modernizr -->
<title>動物地圖(Animal Map)</title>
</head>

<body>
	<header class="cd-header htmleaf-header">
		<h1>
			動物地圖<span>Animal Map</span>
		</h1>
		<a class="htmleaf-icon icon-home" href="index.html" title="首頁"><span>首頁</span></a>
	</header>

	<main class="cd-main-content">
		<div class="cd-tab-filter-wrapper">
			<div class="cd-tab-filter">
				<ul class="cd-filters">
					<!-- 下面一行不能刪 -->
					<li class="placeholder"><a data-type="all" href="#0">All</a> <!-- selected option on mobile -->
					</li>
					<li class="filter"><a class="selected" href="#0"
						data-type="all">動物圖鑑</a></li>
					<li class="filter" data-filter=".color-1"><a href="#0"
						data-type="color-1">討論版</a></li>
					<li class="filter" data-filter=".color-3"><a href="#0"
						data-type="color-2">發文</a></li>
					<!-- 只有三個按鈕底下可以有底線 -->
					<li class="filter" data-filter=".color-2"><a href="#0"
						data-type="color-2">商城</a></li>
					<li class="filter" data-filter=".color-3"><a href="#0"
						data-type="color-2">發文</a></li>
				</ul><!-- cd-filters -->
			</div><!-- cd-tab-filter -->
		</div><!-- cd-tab-filter-wrapper --> 
	
       <div class="cd-filter">
            <form>
				<%@ include file="/user/ajaxLogin.htm" %>
            </form>
            <a href="#0" class="cd-close">關閉</a>
        </div> <!-- cd-filter -->

        <a href="#0" class="cd-filter-trigger">　資訊看板</a>
	
	</main><!-- cd-main-content -->



	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/jquery.mixitup.min.js"></script>
	<!-- 下面一行 掌管按鈕logic..等等 -->
	<script src="js/main.js"></script>
	<!-- Resource jQuery -->
</body>

</html>
