<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<style>
  body {
/*     padding-top: 15px; */
/*     font-size: 12px */
  }
  .main {
    max-width: 320px;
    margin: 0 auto;
  }
  .login-or {
    position: relative;
    font-size: 18px;
    color: #aaa;
    margin-top: 10px;
            margin-bottom: 10px;
    padding-top: 10px;
    padding-bottom: 10px;
  }
  .span-or {
    display: block;
    position: absolute;
    left: 50%;
    top: -2px;
    margin-left: -25px;
    background-color: #fff;
    width: 50px;
    text-align: center;
  }
  .hr-or {
    background-color: #cdcdcd;
    height: 1px;
    margin-top: 0px !important;
    margin-bottom: 0px !important;
  }
  h3 {
/*     text-align: center; */
/*     line-height: 300%; */
  }
</style>	
	
<div id="AM_login">
	<div class="login-clean">
		<form method="post">
			<h2 class="sr-only">Login Form</h2>
			<div class="illustration">
				<i class="icon ion-ios-navigate"></i>
			</div>
			<div class="form-group">
				<input class="form-control" type="email" name="email"
					placeholder="Email" />
			</div>
			<div class="form-group">
				<input class="form-control" type="password" name="password"
					placeholder="Password" />
			</div>
			<div class="form-group">
				<!-- type="submit"有甚麼改進方法? -->
				<button class="btn btn-primary btn-block" type="submit">登入</button>
			</div>
			<a href="#" class="forgot">忘記密碼?</a>
		</form>
	</div>
</div>

