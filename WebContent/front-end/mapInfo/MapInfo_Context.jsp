<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>  
<%@page import="util.compareVO.CompareVO"%>
<%@ page import="heibernate_com.anihome.model.*"%>	
<%@ page import="heibernate_com.mem.model.*"%>	
<%@ page import="heibernate_com.park.model.*"%>	
<%@ page import="heibernate_com.emp.model.*"%>	
<%@ page import="heibernate_com.adp.model.*"%>	
<%@ page import="heibernate_com.mem.model.*"%>	
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
	.map_info_tr_context:hover {
   		 background-color:rgba(253, 230, 230, 0.93);
	}
</style>
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
<script type="text/javascript">
	function asid_one_member_infowindow(pk_value) {
		var path_parameter = 'action=getOne_For_Update&mem_Id=' + pk_value;
		var src='<%=request.getContextPath() %>/Heibernate_front-end/aside_info_window_member/profile_info.jsp?'+path_parameter 
		$('#details_page_iframe').attr('src',src);        	
        $("#details_page").show();
    }        
</script>
<script type="text/javascript">
	function updateDisplay2() {
		AM_markers.forEach(function (marker, key, mapObj) {
// 			marker.setMap(native_map);
			marker.setMap(null);
		});
	    $('.button-checkbox').each(function () {
	        // Settings
	        var $widget = $(this),
	            $button = $widget.find('button'),
	            $checkbox = $widget.find('input:checkbox'),
            	isChecked = $checkbox.is(':checked'),
            	checkbox_val = $checkbox.val();
	        if((isChecked)){
	        	if(AM_markers_ver02.has(checkbox_val)){
		        	(AM_markers_ver02.get(checkbox_val)).forEach(function (marker, key, mapObj) {
		    			marker.setMap(native_map);
		    		});		        	
	        	}
	        }else{
	        }
	    });	
	    
	    AM_markers.get('AM_autoLocation').setMap(native_map);
	}
</script>
<section class=""style="
	    margin-left: 12px;
	    margin-top: 15px;
	">
	<div class="btn-group" >
		<span class="button-checkbox">
			<button type="button" onclick="updateDisplay2();" class="btn btn-success btn-filter" data-target="anihome">動物之家</button>
			<input type="checkbox" class="hidden" value='anihome'  checked />
		</span>			
		<span class="button-checkbox">
			<button type="button" onclick="updateDisplay2();" class="btn btn-warning btn-filter" data-target="park">公園</button>
			<input type="checkbox" class="hidden" value='park'  checked />
		</span>			
		<span class="button-checkbox">
			<button type="button" onclick="updateDisplay2();" class="btn btn-primary btn-filter" data-target="adp">領養活動</button>
			<input type="checkbox" class="hidden" value='adp'  checked />
		</span>			
		<!-- 自訂義 -->
		<span class="button-checkbox">
			<button type="button" onclick="updateDisplay2();" class="btn btn-primary btn-filter" data-target="emg_help">緊急求救</button>
			<input type="checkbox" class="hidden" value='emg_help'  checked />
		</span>		
		<span class="button-checkbox">
			<button type="button" onclick="updateDisplay2();" class="btn btn-primary btn-filter" data-target="adoptani">送養動物</button>
			<input type="checkbox" class="hidden" value='adoptani' checked  />
		</span>		
		
		
		
    <!-- All colors -->
    <hr style="margin-top: 2px;margin-bottom: 2px;"/>	
	<span class="button-checkbox">
		<button type="button" onclick="updateDisplay2();" class="btn btn-primary btn-filter" data-target="distance">距離</button>
		<input type="checkbox" class="hidden" value='distance' />
	</span>	 
	
	<hr style="margin-top: 2px;margin-bottom: 2px;"/>	   
	</div>
    
	<script type="text/javascript">
	$(function () {
	    $('.button-checkbox').each(function () {
	        // Settings
	        var $widget = $(this),
	            $button = $widget.find('button'),
	            $checkbox = $widget.find('input:checkbox'),
	            color = $button.data('color'),
	            settings = {
	                on: {
	                    icon: 'glyphicon glyphicon-check'
	                },
	                off: {
	                    icon: 'glyphicon glyphicon-unchecked'
	                }
	            };
	        // Event Handlers
	        $button.on('click', function () {
	            $checkbox.prop('checked', !$checkbox.is(':checked'));
	            updateDisplay2()
	            $checkbox.triggerHandler('change');
	            updateDisplay();
	        });
	        $checkbox.on('change', function () {
	            updateDisplay();
	        });
	        // Actions
	        function updateDisplay(btn_val) {
	            var isChecked = $checkbox.is(':checked');
	            // Set the button's state
	            $button.data('state', (isChecked) ? "on" : "off");
	            // Set the button's icon
	            $button.find('.state-icon')
	                .removeClass()
	                .addClass('state-icon ' + settings[$button.data('state')].icon);
	            // Update the button's color
	            if (isChecked) {
	                $button
	                    .removeClass('btn-default')
	                    .addClass('btn-' + color + ' active');
	            }
	            else {
	                $button
	                    .removeClass('btn-' + color + ' active')
	                    .addClass('btn-default');
	            }
	        }
	        // Initialization
	        function init() {
	            updateDisplay();
	            // Inject the icon if applicable
	            if ($button.find('.state-icon').length == 0) {
	                $button.prepend('<i class="state-icon ' + settings[$button.data('state')].icon + '"></i> ');
	            }
	        }
	        init();
	    });
	});	
	</script>	
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
                <div class="map_info_tr" data-status="anihome" data-index="<%=vo.getIndex()%>">
                    <div class="map_info_tr_context" id=tr_animal_map_anihome_<%=vo.getIndex()%> onclick="am_center_to_marker('marker_anihome_<%=vo.getIndex()%>')">
                        <div>
                            <div class="media">
                            <div >
                                <div class="">
                                    <div class="square pull-left" style="margin-right: 20px;">
                                    <a class="pull-left"> <img style=" width: 26px; height: 26px; " src="https://i.imgur.com/MaCYe1W.png" class="media-photo" ></a>
                                    <img style=" height: 84px; width: 125px; " src="<%=((heibernate_com.anihome.model.AniHomeVO)vo.getVo()).getAniHome_pic()%>" ></div>
                                    <h4 class="title">
                                        <%=((heibernate_com.anihome.model.AniHomeVO)vo.getVo()).getAniHome_title()%>
                                    </h4>
                                    <hr>
                                    <hr>
                                    <hr>
                                    <p style=" padding-left: 5px;">
                                        <%=((heibernate_com.anihome.model.AniHomeVO)vo.getVo()).getAniHome_content()%>
                                    </p>
                                </div>
                            </div>      
                            <hr> 
                                <div class="media-body">
                                    <span class="media-meta pull-right">發文日期 : <%=util.time.Timestamp_util.getBetweenTime(((heibernate_com.anihome.model.AniHomeVO)vo.getVo()).getAniHome_start_date())%></span>  
                                    <p class="summary">發布者 : 
                                    	<a onclick="asid_one_member_infowindow('<%=((heibernate_com.anihome.model.AniHomeVO)vo.getVo()).getMemVO().getMem_Id()%>');">
                                    		<%=((heibernate_com.anihome.model.AniHomeVO)vo.getVo()).getMemVO().getMem_name()%>
                                    	</a>
                                    </p>
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
                <div class="map_info_tr" data-status="park"  data-index="<%=vo.getIndex()%>">
                    <div class="map_info_tr_context" id=tr_animal_map_park_<%=vo.getIndex()%> onclick="am_center_to_marker('marker_park_<%=vo.getIndex()%>')">
                        <div>
                            <div class="media">
                            <div >
                                <div class="">
                                    <div class="square pull-left" style="margin-right: 20px;">
                                    <a class="pull-left"> <img style=" width: 26px; height: 26px; " src="https://i.imgur.com/UHd94rj.png" class="media-photo" ></a>
                                    <img style=" height: 84px; width: 125px; " src="<%=((heibernate_com.park.model.ParkVO)vo.getVo()).getPark_pic()%>" ></div>
                                    <h4 class="title">
                                        <%=((heibernate_com.park.model.ParkVO)vo.getVo()).getPark_title()%>
                                    </h4>
                                    <hr>
                                    <hr>
                                    <hr>
                                    <p style=" padding-left: 5px;">
                                        <%=((heibernate_com.park.model.ParkVO)vo.getVo()).getPark_content()%>
                                    </p>
                                </div>
                            </div>      
                            <hr> 
                                <div class="media-body">
                                    <span class="media-meta pull-right">發文日期 : <%=util.time.Timestamp_util.getBetweenTime(((heibernate_com.park.model.ParkVO)vo.getVo()).getPark_start_date())%></span>  
                                    <p class="summary">發布者 : 
                                    	<a onclick="asid_one_member_infowindow('<%=((heibernate_com.park.model.ParkVO)vo.getVo()).getEmpVO().getEmp_No()%>');">
                                    		<%=((heibernate_com.park.model.ParkVO)vo.getVo()).getEmpVO().getEmp_name()%>
                                    	</a>
                                    </p>
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
                <div class="map_info_tr" data-status="adp" data-index="<%=vo.getIndex()%>">
                    <div class="map_info_tr_context" id=tr_animal_map_adp_<%=vo.getIndex()%> onclick="am_center_to_marker('marker_adp_<%=vo.getIndex()%>')">
                        <div>
                            <div class="media">
                            <div >
                                <div class="">
                                    <div class="square pull-left" style="margin-right: 20px;">
                                    <a class="pull-left"> <img style=" width: 26px; height: 26px; " src="https://i.imgur.com/zOfiw3r.png" class="media-photo" ></a>
                                    <img style=" height: 84px; width: 125px; " src="<%=((heibernate_com.adp.model.AdpVO)vo.getVo()).getAdp_adp_pic()%>" ></div>
                                    <h4 class="title">
                                        <%=((heibernate_com.adp.model.AdpVO)vo.getVo()).getAdp_title()%>
                                    </h4>
                                    <hr>
                                    <hr>
                                    <hr>
                                    <p style=" padding-left: 5px;">
                                        <%=((heibernate_com.adp.model.AdpVO)vo.getVo()).getAdp_adp_content()%>
                                    </p>
                                </div>
                            </div>      
                            <hr> 
                                <div class="media-body">
                                    <span class="media-meta pull-right">發文日期 : <%=util.time.Timestamp_util.getBetweenTime(((heibernate_com.adp.model.AdpVO)vo.getVo()).getAdp_start_date())%></span>  
                                    <p class="summary">發布者 : 
                                    	<a onclick="asid_one_member_infowindow('<%=((heibernate_com.adp.model.AdpVO)vo.getVo()).getMemVO().getMem_Id()%>');">
                                    		<%=((heibernate_com.adp.model.AdpVO)vo.getVo()).getMemVO().getMem_name()%>
                                    	</a>
                                    </p>
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
	var map_distance_Circle_boolean = false;
	var map_distance_Circle =null;	
	 function map_distance_Circle_fun() {
		 	updateDisplay2()
			$('.map_info_tr').css('display', 'none');
			$('.button-checkbox').each(function () {
		        var $widget = $(this),
	            $button = $widget.find('button'),
	            $checkbox = $widget.find('input:checkbox'),
	         	isChecked = $checkbox.is(':checked'),
	         	checkbox_val = $checkbox.val();				
		        if((isChecked)){
					var $target = checkbox_val;
					console.log(checkbox_val);
					if(checkbox_val=='distance'){
						// ==== ====
						map_distance_Circle_boolean = true;
						
						// ==== ====
						var auto_marker = AM_markers.get('AM_autoLocation');
//						map_distance_Circle.radius = 1;
						if(map_distance_Circle!=null){
							map_distance_Circle.setMap(null);
						}
					    map_distance_Circle  = new google.maps.Circle({
					        strokeColor: 'rgba(91, 192, 222, 0.43)',
					        strokeOpacity: 0.8,
					        strokeWeight: 2,
					        fillColor: 'rgba(91, 192, 222, 0.43)',
					        fillOpacity: 0.35,
					        map: native_map,
					        center:	auto_marker.getPosition(),
					        radius: 8000
					      });	
					    
				    	AM_markers.forEach(function (marker, key, mapObj) {
							var meters = google.maps.geometry.spherical.computeDistanceBetween(marker.getPosition(), 
									(auto_marker.getPosition())	);
							console.log(meters);
							if(meters>8000){
								marker.setMap(null)
							}else{
								$('.map_info_tr[data-index="' + marker.index + '"]').fadeIn('slow');
							}
				    	});   						
						
					}else{
						$('.map_info_tr[data-status="' + $target + '"]').fadeIn('slow');
					}
		        }else{
		        	if(checkbox_val=='distance'){
		        		map_distance_Circle_boolean = false;
// 			        	alert('distance');
		        	}
		        }
			});
		 }
	$(document).ready(function() {
		$('.btn-filter').on('click',function(){ map_distance_Circle_fun();});
	 });
	
</script>