<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


  <meta charset="utf-8">
  <style>
  .modal-header, h4, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;
  }
  </style>

<!-- <div class="container"> -->
<!--   <h2>Modal Login Example</h2> -->
<!--   Trigger the modal with a button -->
<!--   <button type="button" class="btn btn-default btn-lg" id="myBtn">Login</button> -->

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog" >
    <div class="modal-dialog">    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
		    <!-- xxx -->
			<div class="vid-container">
				<video class="bgvid" autoplay="autoplay" muted="muted" preload="auto"
					loop="" style="">
					<source src="http://mazwai.com/#/grid/videos/161" type="video/webm">
				</video>
				<div class="inner-container">
					<!-- muted="muted" 是靜音效果 -->
					<video class="bgvid inner" autoplay="autoplay" muted="muted"
						preload="auto" loop="">
						<source
							src="http://mazwai.com/system/posts/videos/000/000/161/original/leonard_soosay--missfit.mp4?1424004876"
							type="video/webm">
					</video>
				</div>
			</div>
			<!-- xxx -->        
          <form role="form">
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
              <input type="text" class="form-control" id="usrname" placeholder="Enter email">
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="text" class="form-control" id="psw" placeholder="Enter password">
            </div>
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>Remember me</label>
            </div>
              <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
          </form>
          
          
          
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
          <p>Not a member? <a href="#">Sign Up</a></p>
          <p>Forgot <a href="#">Password?</a></p>
        </div>
      </div>
      
    </div>
  </div> 


<script>
	$(document).ready(function() {
		$("#myModal").modal();
// 	    $("#myBtn").click(function(){
// 	        $("#myModal").modal();
// 	    })
	    $("#AM_btn_Member").click(function() {
		    	$.ajax({
		            url:   "<%=request.getContextPath()%>/loginhandler", 
		            type : "POST",
		            data : { 
		            	account:$("input[name='account']").val(),
		            	password:$("input[name='password']").val() 
		            },//傳帳號密碼。
		            success: function(response){
		            	alert(response);
		            },
		            error:  function(data, status, er){
		            	console(data+"_"+status+"_"+er);
		            }
		        });
		    }
	    );
	});
</script>

