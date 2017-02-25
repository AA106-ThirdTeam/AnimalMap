<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>    
<%@ page import="heibernate_com.anihome.model.*"%>	
<%
{
    AniHomeService anihomeSvc = new AniHomeService();
    List<AniHomeVO> list_anihome = anihomeSvc.getAll();
    pageContext.setAttribute("list_anihome",list_anihome);
    int anihome_map_icon_size = 24;
%>

<html><head><meta charset="utf-8">
<style type="text/css">
	/*    --------------------------------------------------
		:: General
		-------------------------------------------------- */
	.content h1 {
		text-align: center;
	}
	
	.content .content-footer p {
		color: #6d6d6d;
		font-size: 12px;
		text-align: center;
	}
	
	.content .content-footer p a {
		color: inherit;
		font-weight: bold;
	}
	/*	--------------------------------------------------
		:: Table Filter
		-------------------------------------------------- */
	.panel {
		border: 1px solid #ddd;
		background-color: #fcfcfc;
	}
	
	.panel .btn-group {
		margin: 15px 0 30px;
	}
	
	.panel .btn-group .btn {
		transition: background-color .3s ease;
	}
	
	.table-filter {
		background-color: #fff;
		border-bottom: 1px solid #eee;
	}
	
	.table-filter tbody tr:hover {
		cursor: pointer;
		background-color: #eee;
	}
	
	.table-filter tbody tr td {
		padding: 10px;
		vertical-align: middle;
		border-top-color: #eee;
	}
	
	.table-filter tbody tr.selected td {
		background-color: #eee;
	}
	
	.table-filter tr td:first-child {
		width: 38px;
	}
	
	.table-filter tr td:nth-child(2) {
		width: 35px;
	}
	
	.ckbox {
		position: relative;
	}
	
	.ckbox input[type="checkbox"] {
		opacity: 0;
	}
	
	.ckbox label {
		-webkit-user-select: none;
		-moz-user-select: none;
		-ms-user-select: none;
		user-select: none;
	}
	
	.ckbox label:before {
		content: '';
		top: 1px;
		left: 0;
		width: 18px;
		height: 18px;
		display: block;
		position: absolute;
		border-radius: 2px;
		border: 1px solid #bbb;
		background-color: #fff;
	}
	
	.ckbox input[type="checkbox"]:checked+label:before {
		border-color: #2BBCDE;
		background-color: #2BBCDE;
	}
	
	.ckbox input[type="checkbox"]:checked+label:after {
		top: 3px;
		left: 3.5px;
		content: '\e013';
		color: #fff;
		font-size: 11px;
		font-family: 'Glyphicons Halflings';
		position: absolute;
	}
	
	.table-filter .star {
		color: #ccc;
		text-align: center;
		/*display: block;*/
	}
	
	.table-filter .star.star-checked {
		color: #F0AD4E;
	}
	
	.table-filter .star:hover {
		color: #ccc;
	}
	
	.table-filter .star.star-checked:hover {
		color: #F0AD4E;
	}
	
	.table-filter .media-photo {
		width: 35px;
	}
	
	.table-filter .media-body {
		/*display: block;*/
		/* Had to use this style to force the div to expand (wasn't necessary with my bootstrap version 3.3.6) */
	}
	
	.table-filter .media-meta {
		font-size: 11px;
		color: #999;
	}
	
	.table-filter .media .title {
		color: #2BBCDE;
		font-size: 14px;
		font-weight: bold;
		line-height: normal;
		margin: 0;
	}
	
	.table-filter .media .title span {
		font-size: .8em;
		margin-right: 20px;
	}
	
	.table-filter .media .title span.stray_Ani {
		color: #5cb85c;
	}
	
	.table-filter .media .title span.comm_ani {
		color: #f0ad4e;
	}
	
	.table-filter .media .title span.pet {
		color: #d9534f;
	}
	
	.table-filter .media .summary {
		font-size: 14px;
	}
</style>



</head><body><section class="">
	<div class="btn-group">
		<button type="button" class="btn btn-success btn-filter" data-target="stray_Ani">流浪動物</button>
		<button type="button" class="btn btn-warning btn-filter" data-target="comm_ani">社區動物</button>
		<button type="button" class="btn btn-danger btn-filter" data-target="pet">自家寵物</button>
		<button type="button" class="btn btn-default btn-filter" data-target="all">　全部　</button>
	</div>
	<table class="table table-filter" style="width: 60vh;;">
		<tbody>
			<%
				int tem_int = 0;
				for(AniHomeVO vo:list_anihome){
					tem_int++;
			%>
				<tr data-status="comm_ani">
					<td>
						<div class="media">
							<a href="#" class="pull-left"> <img src="https://i.imgur.com/fcQqBHr.png" class="media-photo">
							</a>
							<div class="media-body">
								<span class="media-meta pull-right">Febrero 13, 2016</span>
								<h4 class="title"><%=vo.getAniHome_title()%>   <span class="pull-right comm_ani">(新北市)</span>
								</h4>
								<p class="summary"><%=vo.getAniHome_content()%></p>
							</div>
						</div>
					</td>
				</tr>
			<%}%>
		</tbody>
	</table>
</section>
<script type="text/javascript">
	$(document).ready(function() {

		$('.star').on('click', function() {
			$(this).toggleClass('star-checked');
		});

		$('.ckbox label').on('click', function() {
			$(this).parents('tr').toggleClass('selected');
		});

		$('.btn-filter').on('click', function() {
			var $target = $(this).data('target');
			if ($target != 'all') {
				$('.table tr').css('display', 'none');
				$('.table tr[data-status="' + $target + '"]').fadeIn('slow');
			} else {
				$('.table tr').css('display', 'none').fadeIn('slow');
			}
		});

	});
</script>



</body></html>

<%}%>