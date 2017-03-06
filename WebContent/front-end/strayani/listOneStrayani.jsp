<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.strayani.model.*"%>
<%@ page import="com.chung.tools.Tools"%>
<%@ page import="com.mem.model.*"%>

<%

StrayaniService strayaniSvc = new StrayaniService();
StrayaniVO strayaniVO = strayaniSvc.getOneStrayani(request.getParameter("stray_Ani_Id"));
pageContext.setAttribute("strayaniVO",strayaniVO);	//要放到scope裡面才找得到。


MemService memSvc = new MemService();
MemVO memVO = memSvc.getOneMem(strayaniVO.getMem_Id());
System.out.println(memVO.getMem_nick_name());
pageContext.setAttribute("memVO",memVO);
Tools tools = new Tools();
%>




<!-- <html> -->
<!-- <head> -->
<!-- <link rel="stylesheet" href="js/listOneStrayani.css"> -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- <title>社區動物資料 - listOneStrayani.jsp</title> -->
<!-- </head> -->
<!-- <body bgcolor='white'> -->





            <table border='1' bordercolor='#ffcc56' width='450'>
				<tr>
                    <th>社區動物編號</th> 
                    <td><%= strayaniVO.getStray_Ani_Id()%></td> 
                </tr>
                <tr>
                    <th>發布者會員編號</th>     
                    <td><%= strayaniVO.getMem_Id()%></td>
                </tr>
                <tr>
                    <th>社區動物名字</th> 
                    <td><%= strayaniVO.getStray_Ani_name()%></td>
                </tr>
                <tr>
                    <th>社區動物動物種類</th> 
                    <td><%= strayaniVO.getStray_Ani_type()%></td>
                </tr>
                <tr>
                    <th>社區動物性別</th>     
                    <td><%=  tools.genderExchange(strayaniVO.getStray_Ani_gender())%></td>
                </tr>
                <tr>
                    <th>社區動物健康狀況</th>       
                    <td><%= strayaniVO.getStray_Ani_heal()%></td>
                </tr>
                <tr>
                    <th>社區動物疫苗接踵</th>       
                    <td><%= strayaniVO.getStray_Ani_Vac() %></td>
                </tr>
                <tr>
                    <th>社區動物毛色</th>     
                    <td><%= strayaniVO.getStray_Ani_color()%></td>
                </tr>
                <tr>
                    <th>社區動物體型</th>     
                    <td><%= strayaniVO.getStray_Ani_body()%></td>
                </tr>
                <tr>
                    <th>社區動物年齡</th>     
                    <td><%= strayaniVO.getStray_Ani_age()%></td>
                </tr>
                <tr>
                    <th>社區動物節育</th>     
                    <td><%= tools.neuterExchange(strayaniVO.getStray_Ani_Neu())%></td>
                </tr>
                <tr>
                    <th>社區動物晶片編號</th>       
                    <td><%= strayaniVO.getStray_Ani_chip()%></td>
                </tr>
                <tr>
                    <th>社區時間</th>       
                    <td><%= strayaniVO.getStray_Ani_date()%></td>
                </tr>
                <tr>
                    <th>社區動物物件狀態</th>       
                    <td><%= tools.statusExchange(strayaniVO.getStray_Ani_status())%></td>
                </tr>
                <tr>
                    <th>社區動物建立時間</th>       
                    <td><%= strayaniVO.getStray_Ani_CreDate()%></td>
                </tr>
                <tr>
                    <th>社區地點經度</th>     
                    <td><%= strayaniVO.getStray_Ani_FinLat()%></td>
                </tr>
                <tr>
                    <th>社區地點緯度</th>     
                    <td><%= strayaniVO.getStray_Ani_FinLon()%></td>
                </tr>
                <tr>
                    <th>縣/市</th>        
                    <td><%= strayaniVO.getStray_Ani_city()%></td>
                </tr>
                <tr>
                    <th>鄉鎮市區</th>       
                    <td><%= strayaniVO.getStray_Ani_town()%></td>
                </tr>
                <tr>
                    <th>道路街名村里</th>     
                    <td><%= strayaniVO.getStray_Ani_road()%></td>
                </tr>
                <tr>
                    <th>喜愛數</th>     
                    <td><%= strayaniVO.getStray_Ani_like()%></td>
                </tr>
                <tr>

                    <td>
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/strayani/strayani.do">
						<input type="submit" value="修改">
						<input type="hidden" name="stray_Ani_Id" value="${strayaniVO.stray_Ani_Id}">
						<input type="hidden" name="action"	value="getOne_For_Update">
						<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
						</FORM>
					</td>
                    
                </tr>
            </table>
            <%-- <%if (request.getAttribute("oneStrayAniPhotoList")!=null){%> --%>
            <%--        <jsp:include page="listOneStrayaniAllPhoto.jsp" /> --%>
            <%-- <%} %> --%>









<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- </body> -->
</html>



