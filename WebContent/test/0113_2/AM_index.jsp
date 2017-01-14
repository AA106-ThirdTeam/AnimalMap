<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
	<title>動物地圖</title>
	<!-- 載入共用CSS、JS -->
	<%@include file="/assets/header.jsp" %>
</head>

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
<head>
<meta charset="utf-8">
</head>

<body>
	<div class="container">
		<div class="row">

			<div class="main">

				<h3>
					Please Log In, or <a href="#">Sign Up</a>
				</h3>
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
						<a href="#" class="btn btn-lg btn-primary btn-block">Facebook</a>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6">
						<a href="#" class="btn btn-lg btn-info btn-block">Google</a>
					</div>
				</div>
				<div class="login-or">
					<hr class="hr-or">
					<span class="span-or">or</span>
				</div>

				<form role="form">
					<div class="form-group">
						<label for="inputUsernameEmail">Username or email</label> <input
							type="text" class="form-control" id="inputUsernameEmail">
					</div>
					<div class="form-group">
						<a class="pull-right" href="#">Forgot password?</a> <label
							for="inputPassword">Password</label> <input type="password"
							class="form-control" id="inputPassword">
					</div>
					<div class="checkbox pull-right">
						<label> <input type="checkbox"> Remember me
						</label>
					</div>
					<button type="submit" class="btn btn btn-primary">Log In</button>
				</form>

			</div>

		</div>
	</div>
</body>

</html>