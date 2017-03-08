<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
{
	
	heibernate_com.mem.model.MemVO tem_vo = ((heibernate_com.mem.model.MemVO)session.getAttribute("account"));
	
	if(tem_vo!=null){
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
	                         <img  src="<%=tem_vo.getMem_profile() %>" style="width: 130px;height: 130px;border-radius: 50%;border: 3px solid #505064;-webkit-transition: all 1.5s ease;transition: all 1.5s ease;margin-bottom: 25%;margin-top: 25%;">
                         </div>
  <table class="table">
    <tbody>
      <tr class="danger"><td>會員編號:</td><td><%=tem_vo.getMem_Id() %></td></tr>
      <tr class="success" ><td>姓名:</td><td><%=tem_vo.getMem_name() %></td></tr>
      <tr class="warning"><td>信箱:</td><td><%=tem_vo.getMem_email() %></td></tr>
      <tr class="default"><td>目前偏好設定:</td><td> 無 </td></tr>
      <tr  class="info" >
    	<td colspan="2">
			<!-- Trigger the modal with a button -->
			<button type="button" class="btn btn-info" style="
				    width: 100%;
				">
				偏好設定
			</button>  	
	 	 </td>
	  </tr>
      <tr class="active">
         <td colspan="2" class="danger">
			<!-- Trigger the modal with a button -->
			<button type="button" class="btn btn-danger" style="
				    width: 100%;
				">
				問題回報
			</button>  	
	 	 </td>
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
<%
	}else{
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
                         <div class="square pull-left" style="margin-left: 39%;">
	                         <img  src="https://i.imgur.com/wHeVP5Y.png" 
	                         style="    width: 130px;
							    height: 130px;
							    border-radius: 50%;
							    border: 3px solid #03A9F4;
							    -webkit-transition: all 1.5s ease;
							    transition: all 1.5s ease;
							    margin-bottom: 25%;
							    margin-top: 25%;
							    ">
                         </div>
  <table class="table">
    <tbody>
      <tr>
     		<td style="
			    padding: 20px;
			    margin: auto;
			    padding-left: 46%;
			    font-size: 25px;
			">訪客</td>
	  </tr>     
      <tr>
      		<td>
      		
			  <!-- Trigger the modal with a button -->
			  	
			  <button onclick="log_in()" type="button" class="btn btn-info" style="
				    width: 100%;
				    height: 50px;
				    margin-top: 5%;
			        margin-bottom: 20px;
				" ><a href="#" class="glyphicon glyphicon-log-out" ></a>登入</button>  	
	  		</td>
	  </tr>    
      <tr>
      		<td>
			  <!-- Trigger the modal with a button -->
			  <button type="button" class="btn btn-info" style="
				    width: 100%;
				    height: 50px;
				    margin-top: 5%;
				" >加入會員</button>  	
	  		</td>
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
		<%		
	}
}
%>