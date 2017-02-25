<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>    
<%@ page import="heibernate_com.adp.model.*"%>	
<%
    AdpService adpSvc = new AdpService();
    List<AdpVO> list_adp = adpSvc.getAll();
    pageContext.setAttribute("list_adp",list_adp);
    int adp_map_icon_size = 24;
%>
<%
int tem_int = 0;
for(AdpVO vo:list_adp){
	tem_int++;
%>
<style>
.glyphicon-lg{font-size:3em}
.blockquote-box{border-right:5px solid #E6E6E6;margin-bottom:25px}
.blockquote-box .square{width:100px;min-height:50px;margin-right:22px;text-align:center!important;background-color:#E6E6E6;padding:20px 0}
.blockquote-box.blockquote-primary{border-color:#357EBD}
.blockquote-box.blockquote-primary .square{background-color:#428BCA;color:#FFF}
.blockquote-box.blockquote-success{border-color:#4CAE4C}
.blockquote-box.blockquote-success .square{background-color:#5CB85C;color:#FFF}
.blockquote-box.blockquote-info{border-color:#46B8DA}
.blockquote-box.blockquote-info .square{background-color:#5BC0DE;color:#FFF}
.blockquote-box.blockquote-warning{border-color:#EEA236}
.blockquote-box.blockquote-warning .square{background-color:#F0AD4E;color:#FFF}
.blockquote-box.blockquote-danger{border-color:#D43F3A}
.blockquote-box.blockquote-danger .square{background-color:#D9534F;color:#FFF}
</style>	
<div id=ex_animal_map_adp_<%=tem_int%> hidden>
        <div style="width: 20vw;">
            <div class="">
                <div class="square pull-left" style="margin-right: 20px;">
                	<img src="<%=vo.getAdp_adp_pic()%>" height="84" width="125">
                </div>
                <h4>
                	<%=vo.getAdp_title()%>
                </h4>
                <hr>
                <p>
        			<%=vo.getAdp_adp_content()%>
        		</p>
            </div>
        </div> 		
        <hr>
        <button onclick="show_aniHome_details_page(this.value)"
	   		class="btn .btn-md btn-block btn-info" >
	   		詳細資料!
	 	</button>
</div>
<%} %>
<script>
		//======================
		<%
		tem_int = 0;
		for(AdpVO vo:list_adp){
			tem_int++;
		%>			
			var infowindow_adp_<%=tem_int%> = null;
		<%}%>
		//======================
		map.tinyMap('modify',{
			'marker': [	
		<%
		tem_int = 0;
		for(AdpVO vo:list_adp){
			if(tem_int>0){
				out.print(",");
			}
			tem_int++;
		%>	
					,{
// 					    // 標記 ID
// 					    // Custom ID
					    id: 'marker_adp_<%=tem_int%>'
// 					    // 標記的位置
// 					    // Marker location
					    ,addr: ['<%=vo.getAdp_lon()%>', '<%=vo.getAdp_lat()%>']
// 					    // 標記抬頭文字（markerControl 使用此屬性建立清單）
// 					    // Marker title (for `markerControl` to create list)
// 					    title: 'string',
// 					    // 點擊標記時顯示於資訊視窗的文字（支援 HTML）
// 					    // Content of infoWindow
					    ,text: 
					    	'<div id ="div_adp_<%=tem_int%>">'
					    	+'<button onclick="show_adp_details_page(this.value)"'
					    	+ 'class="btn .btn-md btn-block btn-info" >詳細資料!</button>'
					    	+ '</div>'
// 					    // 標籤文字層，顯示於標記底下
// 					    // Text label of the Marker which will display below.
					    ,newLabel: 'string'
// 					    // 標籤文字層套用的 CSS 樣式名稱
// 					    // CSS class name of this text label.
// 					    newLabelCSS: 'string',
// 					    // 是否顯示 Label（預設 true）
// 					    // Show label or not. (Default to `true`)
					   	,showLabel: true
					    // 使用 modify 方法時，若標記 id 不存在，是否強制新增至地圖
					    // Force create the marker if custom id was not found.
					    ,forceInsert : true
// 					    // 標記圖示，可使用 string 指定圖示網址
// 					    // Icon URL of Marker.
// 					    icon: '圖示網址'
// 					    // 或是 Object 定義更詳細的圖示
			            ,'icon': {
			            	 // 圖示網址
			                'url': 'https://maxcdn.icons8.com/office/PNG/16/Animals/dog_bowl-16.png'
		                	// 縮放尺寸
			                ,'scaledSize': [<%=adp_map_icon_size%>, <%=adp_map_icon_size%>]
			            }
// 					    // 是否將此標記加入叢集（markerCluster 必須不為 null 或 false）
// 					    // Append this marker to cluster. `markerCluster` must not be `null` or `false`.
// 					    cluster: true|false,
// 					    // 設定 infoWindow
					    ,infoWindowOptions: {
					        disableAutoPan: true
					        ,maxWidth: 200
// 					        ,pixelOffset: [X, Y],
// 					        zIndex: number
					    }
// 					    // 自訂任意名稱屬性
// 					    // You can create own properties. Just give it a name/value.
					    ,class: 'smile'
// 					    // 定義 Click 事件
// 					    event       : function () {
// 					        console.log(this);
// 					    },
					    // 或是定義多個事件
					    ,event       : {
                            // 自訂 Click
                            mousedown: function () {
                                //console.log($("#div_aniHome_<%=tem_int%>_<%=tem_int%>").text())
                            },
                            // 自訂 mouseover
                            mouseover: function () {
                                //console.log($("#div_aniHome_<%=tem_int%>_<%=tem_int%>").text())
                            },
                            'click': {
                                func: function () {
                                    if(infowindow_adp_<%=tem_int%>==null){
                                        infowindow_adp_<%=tem_int%> = new google.maps.InfoWindow({
                                            content:$("#ex_animal_map_adp_<%=tem_int%>").html()
                                        });                                 
                                    } 
                                    infowindow_adp_<%=tem_int%>.open(map,this);
                                }
                            },  
                            mouseout: {
                                func: function () {
                                    if(infowindow_adp_<%=tem_int%>!=null){
                                        //infowindow_adp_<%=tem_int%>.close(map,this);
                                    }
                                }
                            }
					    }
					    // 啟用 MarkerWithLabel
// 			            ,'labelContent': '<strong>Hello World</strong><div><img src="/images/_111.jpg" alt="" /></div>'
// 			            ,'labelClass'  : 'box'
// 			            ,'icon': {
// 			                'path': 'M 0 0'
// 			            }					    
					}		
		<%}%>
			]/* marker結尾  */
		});
</script>
<script type="text/javascript">
    function show_adp_details_page(argument) {
		var parameter_Id = argument[0];
		var path_parameter = 'action=getOne_For_Display&adopt_Ani_Id=' + parameter_Id;
		var src='/AnimalMap/front-end/adoptani/adoptani.do?'+path_parameter 
		$('#details_page_iframe').attr('src',src);        	
        $("#details_page").show();
    }        
</script>
