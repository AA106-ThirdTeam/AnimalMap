<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <nav>
		<main class="cd-main-content">
			<div class="cd-tab-filter-wrapper">
				<div class="cd-tab-filter">
					<ul class="cd-filters">
						<!-- 下面一行不能刪 -->
						<li class="placeholder"><a data-type="all" href="#0">All</a> <!-- selected option on mobile -->
						</li>
						<li class="filter"><a href="#0"
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
					<!-- Bad for 不能動態註冊 -->
					<%@ include file="/homepage_ver01/mem_login/ajaxLogin.jsp"%>
	            </form>
	            <a href="#0" class="cd-close">關閉</a>
	        </div> <!-- cd-filter -->
	
	        <a href="#0" class="cd-filter-trigger">　資訊看板</a>
		</main><!-- cd-main-content -->
	</nav>
