<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<style>
	.am_bookmark{
		margin-top: 2px;
		margin-bottom: 2px;
	}
</style>	
	
<%
{
	if(((heibernate_com.mem.model.MemVO)session.getAttribute("account"))!=null){
%>
	<button type="button" id="AM_Mem" class="btn btn-default am_bookmark" onclick="change_aside_info('AM_aside_memInfo')">會員中心</button>
	<button type="button" id="AM_Friend" class="btn btn-primary am_bookmark">朋友</button>
	<button type="button" class="btn btn-info am_bookmark">參加的活動</button>
	<button type="button" class="btn btn-warning am_bookmark">店家管理</button>
	<button type="button" id="AM_MapInfo" class="btn btn-success am_bookmark" onclick="change_aside_info('AM_aside_mapInfo')">地圖資訊</button>
<%
	}else{
		%>	
	<button type="button" id="AM_Mem" class="btn btn-default am_bookmark" onclick="change_aside_info('AM_aside_memInfo')">會員中心</button>	
	<button type="button" id="AM_MapInfo" class="btn btn-success am_bookmark" onclick="change_aside_info('AM_aside_mapInfo')">地圖資訊</button>
		<%
	}
}
%>	

	<!--         <button type="button" class="btn btn-danger">Danger</button> -->
	<!--         <button type="button" class="btn btn-link">Link</button> -->

<script type="text/javascript">
	var aside_div_ids = ["AM_aside_mapInfo","AM_aside_memInfo"];
	function change_aside_info(id_val) {
		aside_div_ids.forEach(function(entry) {
			$("#"+entry).hide();
	  	});
		$("#"+id_val).show();
	}
</script>	
	
	