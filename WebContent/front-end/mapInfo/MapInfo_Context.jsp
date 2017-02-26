<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>  
<%@ page import="heibernate_com.anihome.model.*"%>	
<%@ page import="heibernate_com.park.model.*"%>	
<%@ page import="heibernate_com.adp.model.*"%>	
<script>       
    function am_center_to_marker(marker_id) {       
    	AM_markers.forEach(function (marker, key, mapObj) {
    		marker.infoWindow.close();
    	});       	
       var tem_marker = AM_markers.get(marker_id);     
       native_map.panTo(tem_marker.getPosition());     
       native_map.panBy(overlayWidth, overlayHeight);      
       tem_marker.infoWindow.open(native_map,tem_marker);      
    }         
</script>
<%
{
	int tem_int = 0;
    AniHomeService anihomeSvc = new AniHomeService();
    List<AniHomeVO> list_anihome = anihomeSvc.getAll();
    pageContext.setAttribute("list_anihome",list_anihome);
    ParkService parkSvc = new ParkService();
    List<ParkVO> list_park = parkSvc.getAll();
    pageContext.setAttribute("list_park",list_park);
    AdpService adpSvc = new AdpService();
    List<AdpVO> list_adp = adpSvc.getAll();
    pageContext.setAttribute("list_adp",list_adp);
%>
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
/* 	.table-filter .media .title span.stray_Ani { */
/* 		color: #5cb85c; */
/* 	} */
/* 	.table-filter .media .title span.comm_ani { */
/* 		color: #f0ad4e; */
/* 	} */
/* 	.table-filter .media .title span.pet { */
/* 		color: #d9534f; */
/* 	} */
 	.table-filter .media .summary { 
 		font-size: 14px; 
 	} 
</style>
<section class=""style="
	    margin-left: 12px;
	    margin-top: 15px;
	">
	<div class="btn-group" >
		<button type="button" class="btn btn-success btn-filter" data-target="aniHome">動物之家</button>
		<button type="button" class="btn btn-warning btn-filter" data-target="park">公園</button>
		<button type="button" class="btn btn-primary btn-filter" data-target="adp">領養活動</button>
		<button type="button" class="btn btn-default btn-filter" data-target="all">全部</button>
	</div>
	<table class="table table-filter" style="width: 30vw;">
		<tbody>
			<%
				tem_int = 0;
				for(AniHomeVO vo:list_anihome){
					tem_int++;
			%>
			<tr data-status="aniHome" id=tr_animal_map_anihome_<%=tem_int%>
 -				onclick="am_center_to_marker('marker_anihome_<%=tem_int%>')"
				>
				<td>
					<div class="media">
						<a href="#" class="pull-left"> <img src="https://maxcdn.icons8.com/Color/PNG/24/Animals/dog_house-24.png" class="media-photo">
						</a>
						<div class="media-body">
							<span class="media-meta pull-right">Febrero 13, 2016</span>
							<img src="<%=vo.getAniHome_pic()%>" height="84" width="125">
							<h4 class="title"><%=vo.getAniHome_title()%><span class="pull-right stray_Ani">(台中市)</span>
							</h4>
							<p class="summary"><%=vo.getAniHome_content()%></p>
						</div>
					</div>
				</td>
			</tr>
			<%} %>
			<%
				tem_int = 0;
				for(ParkVO vo:list_park){
					tem_int++;
			%>
			<tr data-status="park" id=tr_animal_map_park_<%=tem_int%>
 -				onclick="am_center_to_marker('marker_park_<%=tem_int%>')"
				>
				<td>
					<div class="media">
						<a href="#" class="pull-left"> <img src="https://maxcdn.icons8.com/Color/PNG/24/City/dog_park-24.png" class="media-photo">
						</a>
						<div class="media-body">
							<span class="media-meta pull-right">Febrero 13, 2016</span>
							<img src="<%=vo.getPark_pic()%>" height="84" width="125">
							<h4 class="title"><%=vo.getPark_title()%><span class="pull-right stray_Ani">(台中市)</span>
							</h4>
							<p class="summary"><%=vo.getPark_content()%></p>
						</div>
					</div>
				</td>
			</tr>
			<%} %>
			<%
				tem_int = 0;
				for(AdpVO vo:list_adp){
					tem_int++;
			%>
			<tr data-status="adp" id=tr_animal_map_adp_<%=tem_int%>
 -				onclick="am_center_to_marker('marker_adp_<%=tem_int%>')"
				>
				<td>
					<div class="media">
						<a href="#" class="pull-left"> <img src="https://maxcdn.icons8.com/office/PNG/16/Animals/dog_bowl-16.png" class="media-photo">
						</a>
						<div class="media-body">
							<span class="media-meta pull-right">Febrero 13, 2016</span>
							<img src="<%=vo.getAdp_adp_pic()%>" height="84" width="125">
							<h4 class="title"><%=vo.getAdp_title()%><span class="pull-right stray_Ani">(台中市)</span>
							</h4>
							<p class="summary"><%=vo.getAdp_adp_content()%></p>
						</div>
					</div>
				</td>
			</tr>
			<%} %>
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
<%}%>
