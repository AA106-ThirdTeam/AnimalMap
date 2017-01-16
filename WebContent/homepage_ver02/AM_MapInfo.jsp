<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<hr>

<div id="AM_aside_mapInfo">
	<div>
		<div class="col-md-3" style="padding: 0;">
			<div class="btn-group bootstrap-select">
				<button type="button"
					class="btn dropdown-toggle selectpicker btn-warning"
					data-toggle="dropdown" title="Mustard">
					<span class="filter-option pull-left">Mustard</span>&nbsp;<span
						class="caret"></span>
				</button>
				<div class="dropdown-menu open"
					style="max-height: 191.2px; overflow: hidden; min-height: 0px;">
					<ul class="dropdown-menu inner selectpicker" role="menu"
						style="max-height: 181.2px; overflow-y: auto; min-height: 0px;">
						<li rel="0" class="selected"><a tabindex="0" class=""
							style=""><span class="text">Mustard</span><i
								class="glyphicon glyphicon-ok icon-ok check-mark"></i></a></li>
						<li rel="1"><a tabindex="0" class="" style=""><span
								class="text">Ketchup</span><i
								class="glyphicon glyphicon-ok icon-ok check-mark"></i></a></li>
						<li rel="2"><a tabindex="0" class="" style=""><span
								class="text">Relish</span><i
								class="glyphicon glyphicon-ok icon-ok check-mark"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-md-9" style="padding: 0;">
			<div class="searchform search-wrapper">
				<input type="text" placeholder="篩選內容">
				<button>搜尋</button>
			</div>
		</div>
	</div>
</div>

<br>
<hr>
<%@include file="/homepage_ver02/google_Map.jsp"%>



<div
	style="max-width: 33vw; border-width: 3px; border-style: solid; border-color: #707070; padding: 5px;">
	測試邊框樣式</div>
<style>
#AM_aside_mapInfo select {
	-webkit-border-radius: 9px;
}

.searchform input {
	height: 15px;
	/*background:#fefefe;*/
	border: none;
	/*font:12px/12px 'HelveticaNeue', Helvetica, Arial, sans-serif;*/
	margin-right: 5px;
	padding: 10px;
	width: 216px;
	/*box-shadow:0 0 4px rgba(0,0,0,.4) inset, 1px 1px 1px rgba(255,255,255,.75);*/
	-moz-box-shadow: 0 0 4px rgba(0, 0, 0, .4) inset, 1px 1px 1px
		rgba(255, 255, 255, .75);
	/*-webkit-box-shadow:0 0 4px rgba(0,0,0,.4) inset, 1px 1px 1px rgba(255,255,255,.75);*/
	/*border-radius:9px;*/
	/*-moz-border-radius:9px;*/
	-webkit-border-radius: 9px;
}

.searchform button {
	/*height:15px;*/
	background: rgb(52, 173, 236);
	background: -moz-linear-gradient(top, rgba(52, 173, 236, 1) 0%,
		rgba(38, 145, 220, 1) 100%);
	/*background:-webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(52,173,236,1)), color-stop(100%,rgba(38,145,220,1)));*/
	/*background:-webkit-linear-gradient(top, rgba(52,173,236,1) 0%,rgba(38,145,220,1) 100%);*/
	/*background:-o-linear-gradient(top, rgba(52,173,236,1) 0%,rgba(38,145,220,1) 100%);*/
	/*background:-ms-linear-gradient(top, rgba(52,173,236,1) 0%,rgba(38,145,220,1) 100%);*/
	background: linear-gradient(to bottom, rgba(52, 173, 236, 1) 0%,
		rgba(38, 145, 220, 1) 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#34adec',
		endColorstr='#2691dc', GradientType=0);
	border: none;
	color: #fff;
	cursor: pointer;
	/*font:20px/20px;*/
	/*padding:10px;*/
	width: 106px;
	box-shadow: 0 0 2px #2692dd inset;
	-moz-box-shadow: 0 0 2px #2692dd inset;
	/*-webkit-box-shadow:0 0 2px #2692dd inset;*/
	/*border-radius:9px;*/
	/*-moz-border-radius:9px;*/
	-webkit-border-radius: 9px;
}
</style>

<script>
	
</script>