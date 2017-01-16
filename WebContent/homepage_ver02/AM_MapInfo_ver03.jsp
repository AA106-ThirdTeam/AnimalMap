<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<hr>

<div id="AM_aside_mapInfo">
	<form class="searchform">
		<input type="text" placeholder="Is it me you’re looking for?">
		<button>Search</button>
	</form>
</div>

<hr>


<style>
.searchform input {
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
	background: rgb(52, 173, 236);
	background: -moz-linear-gradient(top, rgba(52, 173, 236, 1) 0%,
		rgba(38, 145, 220, 1) 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(52,
		173, 236, 1)), color-stop(100%, rgba(38, 145, 220, 1)));
	background: -webkit-linear-gradient(top, rgba(52, 173, 236, 1) 0%,
		rgba(38, 145, 220, 1) 100%);
	background: -o-linear-gradient(top, rgba(52, 173, 236, 1) 0%,
		rgba(38, 145, 220, 1) 100%);
	background: -ms-linear-gradient(top, rgba(52, 173, 236, 1) 0%,
		rgba(38, 145, 220, 1) 100%);
	background: linear-gradient(to bottom, rgba(52, 173, 236, 1) 0%,
		rgba(38, 145, 220, 1) 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#34adec',
		endColorstr='#2691dc', GradientType=0);
	border: none;
	color: #fff;
	cursor: pointer;
	font: 13px/13px 'HelveticaNeue', Helvetica, Arial, sans-serif;
	padding: 10px;
	width: 106px;
	box-shadow: 0 0 2px #2692dd inset;
	-moz-box-shadow: 0 0 2px #2692dd inset;
	/*-webkit-box-shadow:0 0 2px #2692dd inset;*/
	/*border-radius:9px;*/
	-moz-border-radius: 9px;
	-webkit-border-radius: 9px;
}
</style>

