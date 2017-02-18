<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>    
<%@ page import="heibernate_com.anihome.model.*"%>	
<%
    AniHomeService anihomeSvc = new AniHomeService();
    List<AniHomeVO> list_anihome = anihomeSvc.getAll();
    pageContext.setAttribute("list_anihome",list_anihome);
%>

<script>
	map.tinyMap('modify',{
		'marker': [	
	        {
	            'addr': ['25.039065815333753', '121.56097412109375'],
	            'text': '<strong>110台灣台北市信義區逸仙路288號</strong>',
	            'newLabel': '文字標籤',
	            'newLabelCSS': 'labels'
	            // 自訂外部圖示
	            ,'icon': {
	                'url': '/images/big.png',
	                'scaledSize': [48, 48]
	            }
	        },			
	<%
	for(AniHomeVO vo:list_anihome){
	%>	
			,{'addr': ['<%=vo.getAniHome_lon()%>', '<%=vo.getAniHome_lat()%>']
				, 'text': '標題 :<%=vo.getAniHome_title()%> <br>內容 : <%=vo.getAniHome_content()%>'	
	            ,'labelContent': '<strong>Hello World</strong><div><img src="https://i.imgur.com/NfpZ9TX.png" alt="" /></div>',
			},    
	<%}%>
		]/* marker結尾  */
	});
</script>