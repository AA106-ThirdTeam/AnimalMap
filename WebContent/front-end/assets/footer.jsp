<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<div class="col-md-12" id="AM_footer_content">
		<p style="
 			padding-top:10px; 
			padding-left: 50%;
		">
			<b>第川組 最棒棒。出品</b>
			　　　　　　<a> 動物地圖 © 2017</a>
		</p>
	</div>
	
	
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>	

    
<script>

setTimeout(
		function(){ 
<%
{
	String CompositeQuery2 = request.getParameter("CompositeQuery");
	if(CompositeQuery2==null){
		%>
		updateDisplay2();
		
		<%
	}
}
%>  
		}, 10);
</script>