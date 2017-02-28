<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>  
<%@page import="util.compareVO.CompareVO"%>
<%@page import="util.time.Timestamp_util"%>
<%@ page import="heibernate_com.anihome.model.*"%>	
<%@ page import="heibernate_com.mem.model.*"%>	
<%@ page import="heibernate_com.park.model.*"%>	
<%@ page import="heibernate_com.emp.model.*"%>	
<%@ page import="heibernate_com.adp.model.*"%>	
<%@ page import="heibernate_com.mem.model.*"%>	
<%@ page import="heibernate_com.emg_help.model.*"%>	
<%@ page import="heibernate_com.mem.model.*"%>	
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
<style>
	.map_info_tr_context{
		cursor: pointer;
		background: white;
    	padding: 10px;	
	}
</style>
<section class=""style="
	    margin-left: 12px;
	    margin-top: 15px;
	">
	<div class="btn-group" style=" padding-bottom: 5px;">
		<button type="button" class="btn btn-success btn-filter" data-target="aniHome">動物之家</button>
		<button type="button" class="btn btn-warning btn-filter" data-target="park">公園</button>
		<button type="button" class="btn btn-primary btn-filter" data-target="adp">領養活動</button>
		<button type="button" class="btn btn-danger btn-filter" data-target="emg_Help">緊急求救</button>
		<button type="button" class="btn btn-default btn-filter" data-target="all">全部</button>
	</div>
	<table class="table table-filter" style="width: 30vw;">
		<tbody>
<%
{
    int tem_int = 0;  
    List<CompareVO> tem_total_list_sort_by_date = (List<CompareVO>)session.getAttribute("total_list_sort_by_date");   
    Collections.sort(tem_total_list_sort_by_date);
    for (CompareVO vo : tem_total_list_sort_by_date) {
        tem_int++;		
            if(vo.getVo_class().equals("heibernate_com.anihome.model.AniHomeVO")){
                %> 
                <div class="map_info_tr" data-status="aniHome" >
                    <div class="map_info_tr_context" id=tr_animal_map_anihome_<%=vo.getIndex()%> onclick="am_center_to_marker('marker_anihome_<%=vo.getIndex()%>')">
                        <div>
                            <div class="media">
                            <div style="width: 20vw;">
                                <div class="">
                                    <div class="square pull-left" style="margin-right: 20px;">
                                    <a class="pull-left"> <img style=" width: 26px; height: 26px; " src="https://maxcdn.icons8.com/Color/PNG/24/Animals/dog_house-24.png" class="media-photo" ></a>
                                    <img style=" height: 84px; width: 125px; " src="<%=((heibernate_com.anihome.model.AniHomeVO)vo.getVo()).getAniHome_pic()%>" ></div>
                                    <h4 class="title">
                                        <%=((heibernate_com.anihome.model.AniHomeVO)vo.getVo()).getAniHome_title()%>
                                    </h4>
                                    <hr>
                                    <p>
                                        <%=((heibernate_com.anihome.model.AniHomeVO)vo.getVo()).getAniHome_content()%>
                                    </p>
                                </div>
                            </div>      
                            <hr> 
                                <div class="media-body">
                                    <span class="media-meta pull-right">發文日期 : <%=Timestamp_util.getBetweenTime(((heibernate_com.anihome.model.AniHomeVO)vo.getVo()).getAniHome_start_date())%></span>  
                                    <p class="summary">發布者 : <a><%=((heibernate_com.anihome.model.AniHomeVO)vo.getVo()).getMemVO().getMem_name()%></a></p>
                                </div>
                            </div>                        
                        </div>
                    </div>
                    <div style="height: 5px;background: rgb(255, 109, 109);"><div style="padding: 3px;"></div></div>
                </div>
                <%
            }
            if(vo.getVo_class().equals("heibernate_com.park.model.ParkVO")){
                %> 
                <div class="map_info_tr" data-status="park" >
                    <div class="map_info_tr_context" id=tr_animal_map_park_<%=vo.getIndex()%> onclick="am_center_to_marker('marker_park_<%=vo.getIndex()%>')">
                        <div>
                            <div class="media">
                            <div style="width: 20vw;">
                                <div class="">
                                    <div class="square pull-left" style="margin-right: 20px;">
                                    <a class="pull-left"> <img style=" width: 26px; height: 26px; " src="https://maxcdn.icons8.com/Color/PNG/24/City/dog_park-24.png" class="media-photo" ></a>
                                    <img style=" height: 84px; width: 125px; " src="<%=((heibernate_com.park.model.ParkVO)vo.getVo()).getPark_pic()%>" ></div>
                                    <h4 class="title">
                                        <%=((heibernate_com.park.model.ParkVO)vo.getVo()).getPark_title()%>
                                    </h4>
                                    <hr>
                                    <p>
                                        <%=((heibernate_com.park.model.ParkVO)vo.getVo()).getPark_content()%>
                                    </p>
                                </div>
                            </div>      
                            <hr> 
                                <div class="media-body">
                                    <span class="media-meta pull-right">發文日期 : <%=Timestamp_util.getBetweenTime(((heibernate_com.park.model.ParkVO)vo.getVo()).getPark_start_date())%></span>  
                                    <p class="summary">發布者 : <a><%=((heibernate_com.park.model.ParkVO)vo.getVo()).getEmpVO().getEmp_name()%></a></p>
                                </div>
                            </div>                        
                        </div>
                    </div>
                    <div style="height: 5px;background: rgb(255, 109, 109);"><div style="padding: 3px;"></div></div>
                </div>
                <%
            }
            if(vo.getVo_class().equals("heibernate_com.adp.model.AdpVO")){
                %> 
                <div class="map_info_tr" data-status="adp" >
                    <div class="map_info_tr_context" id=tr_animal_map_adp_<%=vo.getIndex()%> onclick="am_center_to_marker('marker_adp_<%=vo.getIndex()%>')">
                        <div>
                            <div class="media">
                            <div style="width: 20vw;">
                                <div class="">
                                    <div class="square pull-left" style="margin-right: 20px;">
                                    <a class="pull-left"> <img style=" width: 26px; height: 26px; " src="https://maxcdn.icons8.com/office/PNG/16/Animals/dog_bowl-16.png" class="media-photo" ></a>
                                    <img style=" height: 84px; width: 125px; " src="<%=((heibernate_com.adp.model.AdpVO)vo.getVo()).getAdp_adp_pic()%>" ></div>
                                    <h4 class="title">
                                        <%=((heibernate_com.adp.model.AdpVO)vo.getVo()).getAdp_title()%>
                                    </h4>
                                    <hr>
                                    <p>
                                        <%=((heibernate_com.adp.model.AdpVO)vo.getVo()).getAdp_adp_content()%>
                                    </p>
                                </div>
                            </div>      
                            <hr> 
                                <div class="media-body">
                                    <span class="media-meta pull-right">發文日期 : <%=Timestamp_util.getBetweenTime(((heibernate_com.adp.model.AdpVO)vo.getVo()).getAdp_start_date())%></span>  
                                    <p class="summary">發布者 : <a><%=((heibernate_com.adp.model.AdpVO)vo.getVo()).getMemVO().getMem_name()%></a></p>
                                </div>
                            </div>                        
                        </div>
                    </div>
                    <div style="height: 5px;background: rgb(255, 109, 109);"><div style="padding: 3px;"></div></div>
                </div>
                <%
            }
            if(vo.getVo_class().equals("heibernate_com.emg_help.model.Emg_HelpVO")){
                %> 
                <div class="map_info_tr" data-status="emg_Help" >
                    <div class="map_info_tr_context" id=tr_animal_map_emg_help_<%=vo.getIndex()%> onclick="am_center_to_marker('marker_emg_help_<%=vo.getIndex()%>')">
                        <div>
                            <div class="media">
                            <div style="width: 20vw;">
                                <div class="">
                                    <div class="square pull-left" style="margin-right: 20px;">
                                    <a class="pull-left"> <img style=" width: 26px; height: 26px; " src="https://maxcdn.icons8.com/office/PNG/80/City/fire_station-80.png" class="media-photo" ></a>
                                    <img style=" height: 84px; width: 125px; " src="<%=((heibernate_com.emg_help.model.Emg_HelpVO)vo.getVo()).getEmg_H_Pic()%>" ></div>
                                    <h4 class="title">
                                        <%=((heibernate_com.emg_help.model.Emg_HelpVO)vo.getVo()).getEmg_H_title()%>
                                    </h4>
                                    <hr>
                                    <p>
                                        <%=((heibernate_com.emg_help.model.Emg_HelpVO)vo.getVo()).getEmg_H_content()%>
                                    </p>
                                </div>
                            </div>      
                            <hr> 
                                <div class="media-body">
                                    <span class="media-meta pull-right">發文日期 : <%=Timestamp_util.getBetweenTime(((heibernate_com.emg_help.model.Emg_HelpVO)vo.getVo()).getEmg_H_start_date())%></span>  
                                    <p class="summary">發布者 : <a><%=((heibernate_com.emg_help.model.Emg_HelpVO)vo.getVo()).getMemVO().getMem_name()%></a></p>
                                </div>
                            </div>                        
                        </div>
                    </div>
                    <div style="height: 5px;background: rgb(255, 109, 109);"><div style="padding: 3px;"></div></div>
                </div>
                <%
            }
	}	
}
%>			
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
				$('.map_info_tr').css('display', 'none');
				$('.map_info_tr[data-status="' + $target + '"]').fadeIn('slow');
			} else {
				$('.map_info_tr').css('display', 'none').fadeIn('slow');
			}
		});
	});
</script>
