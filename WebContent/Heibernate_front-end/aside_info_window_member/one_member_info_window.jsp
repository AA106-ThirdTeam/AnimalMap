<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
{
	heibernate_com.mem.model.MemVO tem_vo = ((heibernate_com.mem.model.MemVO)session.getAttribute("account"));
%>
<div>
         <div style="
			    background: white;
			    padding: 10px;
			    margin-top: 50px;
			    margin-left: 7px;
			">
             <div class="map_info_tr_context_change_color">
                 <div>
                 <div>
                     <div class="">
                         <div class="square pull-left" style="margin-left: 35%;">
	                         <img  src="<%=tem_vo.getMem_profile() %>https://i.imgur.com/rv4YG8U.jpg" style="width: 130px;height: 130px;border-radius: 50%;border: 3px solid #505064;-webkit-transition: all 1.5s ease;transition: all 1.5s ease;margin-bottom: 25%;margin-top: 25%;">
                         </div>
  <table class="table">
    <thead>
      <tr>
        <th>Firstname</th>
      </tr>
    </thead>
    <tbody>
      <tr class="success" ><td>個人資訊:</td></tr>
      <tr><td>修改資料</td></tr>
      <tr><td>偏好設定</td></tr>
      <tr><td>歷史紀錄</td></tr>
      <tr><td>問題回報</td></tr>
      <tr><td>常見問題Q&A</td></tr>
            
      <tr class="success">
        <td>Success</td>
      </tr>
      <tr class="danger">
        <td>Danger</td>
      </tr>
      <tr class="info">
        <td>Info</td>
      </tr>
      <tr class="warning">
        <td>Warning</td>
      </tr>
      <tr class="active">
        <td>Active</td>
      </tr>
    </tbody>
  </table>
                     </div>
                 </div>      
                 <hr> 
                 </div>                        
             </div>
         </div>
         <div style="height: 5px;background: rgb(255, 109, 109);"><div style="padding: 3px;"></div></div>
     </div>
<%}%>