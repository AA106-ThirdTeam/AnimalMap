
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<script>
	function sign_test_button() {
		$("#mem_account").data("test", "DogLover");
		$("#mem_email").data("test", "shps951002@gmail.com");
		$("#mem_Psw").each(
				function(){
					$(this).data("test", "food1234");
				}
			);	
		$("#mem_name").data("test", "林暐翰");
		$("#mem_gender").data("test", "男");
		$("#mem_Tw_Id").data("test", "E124685551");
		$("#mem_birth_date").data("test", "1993/09/26");
		$("#mem_phone").data("test", "0908188926");
		$("#mem_Intro").data("test", "狗狗超可愛");
		
		
		
		$('input',"#form_sign_up")
			.each(
				function(){
					var test_val = $(this).data( "test" );
					console.log(test_val)
				$(this).val(test_val);
		    		console.log($(this));
				}
			);	
	}

</script>	
<input type="button" value="神奇小按鈕" onclick="sign_test_button()"/>
<div class="tab-pane fade active in" id="signup">
							<form id="form_sign_up" class="form-horizontal">
								<fieldset>
									<!-- Sign Up Form -->
									<!-- Text input-->
									<div class="control-group">
										<label class="control-label" for="mem_account" >帳號:</label>
										
									<div>
										
										<div class="controls">
											<input test="sdfsdfsd" id="mem_account" name="mem_account" class="form-control" type="text" placeholder="帳號" required="">
										</div>
									</div></div><div class="control-group">
										<label class="control-label" for="mem_Psw">密碼:</label>
										<div class="controls">
											<input  test="sdfsdfsd"  id="mem_Psw" name="mem_Psw" class="form-control" type="password" placeholder="密碼" required="">
											<em>1-8 個字節</em>
										</div>
									</div><div class="control-group">
										<label  class="control-label" for="reenterpassword">再次確認:</label>
										<div class="controls">
											<input  test="sdfsdfsd" id="mem_Psw" class="form-control" name="reenterpassword" type="password" placeholder="再次確認" required="">
										</div>
									</div><div class="control-group">
										<label class="control-label" for="email">信箱:</label>
										<div class="controls">
											<input test="sdfsdfsd"  id="mem_email" name="mem_email" class="form-control" type="email" placeholder="animalMap@sixpacksrus.com" required="">
										</div>
									</div>

									<!-- Text input-->
									<div class="control-group">
											<label class="control-label" for="mem_Tw_Id">身分證:</label>
											
											<input id="mem_Tw_Id" test="sdfsdfsd" name="mem_Tw_Id" class="form-control" type="text" required="" style="
" placeholder="E124555555">
										</div>

									<div class="control-group">
											<label class="control-label" for="mem_birth_date">出生年月日:</label><input id="mem_birth_date" name="mem_birth_date" class="form-control" type="date" required="" style="
">
										</div><div class="control-group">
											<label class="control-label" for="mem_birth_date">手機:</label>
										</div>
										
											<input test="sdfsdfsd" id="mem_phone" name="mem_phone" class="form-control" type="tel" required="" style="
"><div class="control-group">
											<label class="control-label" for="mem_profile">大頭照:</label>
										<input test="sdfsdfsd" id="mem_profile" name="mem_profile" type="file" required="" style="
">
<img hidden="" style=" width: 150px; height: 150px; " id="mem_profile_img">
<input test="sdfsdfsd" id="mem_profile_value" name="mem_profile" class="form-controlss" type="hidden" value="">


</div><!-- Password input-->
									

									<!-- Text input-->
									

									<!-- Multiple Radios (inline) -->
									
									<div class="control-group">
										<label class="control-label" for="humancheck">性別:</label>
										<div class="controls">
											
 <input type="radio" name="gender" value="男">男
<input type="radio" name="gender" value="女">女<br>
 
											
										</div>
									</div>

									<div class="control-group">
											<label class="control-label" for="mem_Intro">個人簡介:</label><input id="mem_Intro" name="mem_Intro" class="form-control" type="text" required="" style="
" placeholder="我喜歡動物.....">
										</div><!-- Button -->
									<div class="control-group" style="
    padding-left: 5px;
">
										<label class="control-label" for="confirmsignup"></label>
										<div class="controls">

										</div>
									</div>
								</fieldset>
							</form>

						</div>