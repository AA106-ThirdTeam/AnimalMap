<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>    
<%@ page import="com.strayani.model.*"%>	
    


	<%		
			StrayaniService strayaniSvc = new StrayaniService();
  		    List<StrayaniVO> list_strayani = strayaniSvc.getAll();
  			pageContext.setAttribute("list_strayani",list_strayani);
  			
  			int strayani_map_icon_size = 40;
	%>



<script>


			
			
			map.tinyMap('modify',{
				'marker': [	
					
	<%
			int tem_int_strayani = 0;
			
			
			for(StrayaniVO strayaniVO:list_strayani){
				
				
				
				if(tem_int_strayani>0){
					out.print(",");
				}
				tem_int_strayani++;
	%>			
				
						,{
		//					    // 標記 ID
		//					    // Custom ID
						    id: 'marker_stray_ani_<%=tem_int_strayani%>'
		//					    // 標記的位置
		//					    // Marker location
						    ,addr: ['<%=strayaniVO.getStray_Ani_FinLat()%>', '<%=strayaniVO.getStray_Ani_FinLon()%>']
		//					    // 標記抬頭文字（markerControl 使用此屬性建立清單）
		//					    // Marker title (for `markerControl` to create list)
		//					    title: 'string',
		//					    // 點擊標記時顯示於資訊視窗的文字（支援 HTML）
		//					    // Content of infoWindow
// 						    ,text: ' <div class="bs-calltoaction bs-calltoaction-info" style=" padding: 5px; height: 600px ; width:600px; > <div class="row" style=" "> <div class="col-md-9" style=" padding: 0; height: 400px ; width:800px;"><iframe style=" padding: 0; height: 600px ; width:600px;" src=../strayani/listOneStrayaniView.jsp></iframe></div> </div> </div> '
						    ,text: 
						    	'<h1><%=strayaniVO.getStray_Ani_name()%></h>'
						    	+'<button value="<%=strayaniVO.getStray_Ani_Id()%>" onclick="openDetailStrayAni(this.value);'
						    	+'show_details_page()" class="btn .btn-md btn-block btn-info" >詳細資料!</button>'
<%-- 						    ,text: ' <div class="bs-calltoaction bs-calltoaction-info" style=" padding: 5px;  "> <div class="row" style=" "> <div class="col-md-9" style=" padding: 0; "> <img src="<%=request.getContextPath()%>/front-end/DBGifReader_StrayaniPhoto/DBGifReader_StrayaniPhoto.do?stray_Ani_Id=<%= strayaniVO.getStray_Ani_Id()%>&str_Pic_type=0" style="width: 50px; height: 50px;"> <a href="#"><%=strayaniVO.getStray_Ani_name()%></a> <b style="border-left: solid #9E9E9E;">.....<%=strayaniVO.getStray_Ani_name()%></b> <b style="border-left: solid #9E9E9E;">.....<%=strayaniVO.getStray_Ani_name()%></b> </div> <div class="col-md-3 cta-button" style=""> <a href="#" class="btn .btn-md btn-block btn-info">詳細資料!</a> </div> </div> </div> ' --%>
		//					    
// 									,text: '<div class="bs-calltoaction bs-calltoaction-info"' 
// 						    		+ 'style=" padding: 5px; "> <div class="row" style=" "> <div class="col-md-9" style=" padding: 0; ">' 
<%-- 						    		+'<img src=<%=request.getContextPath()%>/front-end/DBGifReader_StrayaniPhoto/DBGifReader_StrayaniPhoto.do?stray_Ani_Id=<%= strayaniVO.getStray_Ani_Id()%>&str_Pic_type=0"'  --%>
<%-- 				    				+ 'style="width: 50px; height: 50px;> <b style="border-left: solid #9E9E9E;">.....<%=strayaniVO.getStray_Ani_name()%></b> <b style="border-left: solid #9E9E9E;">.....<%=strayaniVO.getStray_Ani_name()%></b> </div>'  --%>
// 				    				+ '<div class="col-md-3 cta-button" style=""> <a href="#" class="btn .btn-md btn-block btn-info" >詳細資料!</a> </div> </div> </div>'
						    
								// 標籤文字層，顯示於標記底下
		//					    // Text label of the Marker which will display below.
						    ,newLabel: 'string'
		//					    // 標籤文字層套用的 CSS 樣式名稱
		//					    // CSS class name of this text label.
		//					    newLabelCSS: 'string',
		//					    // 是否顯示 Label（預設 true）
		//					    // Show label or not. (Default to `true`)
						   	,showLabel: true
						    // 使用 modify 方法時，若標記 id 不存在，是否強制新增至地圖
						    // Force create the marker if custom id was not found.
						    ,forceInsert : true
		//					    // 標記圖示，可使用 string 指定圖示網址
		//					    // Icon URL of Marker.
		//					    icon: '圖示網址'
		//					    // 或是 Object 定義更詳細的圖示
				            ,'icon': {
				            	 // 圖示網址
				                'url': '<%=request.getContextPath()%>/front-end/homepage/imgs/map_strayani2.png'
			                	// 縮放尺寸
				                ,'scaledSize': [<%=strayani_map_icon_size%>, <%=strayani_map_icon_size%>]
				            }
		//					    // 是否將此標記加入叢集（markerCluster 必須不為 null 或 false）
		//					    // Append this marker to cluster. `markerCluster` must not be `null` or `false`.
		//					    cluster: true|false,
		//					    // 設定 infoWindow
				
						    ,infoWindowOptions: {
						        disableAutoPan: true
						        ,maxWidth: 200
		//					        ,pixelOffset: [X, Y],
		//					        zIndex: number
						    }
		//					    // 自訂任意名稱屬性
		//					    // You can create own properties. Just give it a name/value.
						    ,class: 'smile'
		//					    // 定義 Click 事件
		//					    event       : function () {
		//					        console.log(this);
		//					    },
						    // 或是定義多個事件
						    ,event       : {
						        // 自訂 Click
						        mousedown: function () {
// 						        	alert(this.id);
// 									this.setMap(null);
// 						        	var tem_marker = AM_markers.get(this.id);
// 						        	alert(tem_marker);
						        },
						        // 自訂 mouseover
						        mouseover: {
						            func: function () {
						            }
						        }
						    }
						    // 啟用 MarkerWithLabel
		//			            ,'labelContent': '<strong>Hello World</strong><div><img src="/images/_111.jpg" alt="" /></div>'
		//			            ,'labelClass'  : 'box'
		//			            ,'icon': {
		//			                'path': 'M 0 0'
		//			            }					    
						}		
			<%}%>
				]/* marker結尾  */
			});



</script>
<script>
	function openDetailStrayAni(button_value){
// 		$("body").append( "<div id='showView' style='position:absolute; z-index:10000; opacity:0.5; width:600px; height:600px; background-color:#FFBB73 '></div>" );
// 		document.getElementById("showView").innerHTML =  "<iframe style='position:absolute; z-index:10002;'  width='800' height='580' frameborder='0' id='iframeForDetails' src='/AnimalMap/front-end/strayani/strayani.do?action=getOne_For_Display&stray_Ani_Id="+stray_Ani_Id+"'></iframe>";


		var parameter_Id = button_value;
		var path_parameter = 'action=getOne_For_Display&stray_Ani_Id=' + parameter_Id;
		var src='/AnimalMap/front-end/strayani/strayani.do?'+path_parameter 
		$('#details_page_iframe').attr('src',src);
	}
</script>


