<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>


  
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js">
 <style type="text/css">

    body {
        margin: 0px;
        font-family: 'Ubuntu', sans-serif;
    }
    
    h1 {
        font-style: italic;
        font-size: 50px;
    }
    
    .login {
        margin:60px auto;
        max-width: 500px;
    }
    
    .login-header {
        color: #fff;
        text-align: center;
        font-size: 300%;
    }
    
    .login-header h1 {
        text-shadow: 0px 5px 15px #000;
    }
    
    .login-form {
        border: 2px solid #999;
        background: #2c3e50;
        border-radius: 10px;
        box-shadow: 0px 0px 10px #000;
    }
    
    .login-form h3 {
        text-align: left;
        margin-left: 40px;
        color: #fff;
    }
    
    .login-form {
        box-sizing: border-box;
        padding-top: 15px;
        margin: 30px auto;
        text-align: center;
        overflow: hidden;
    }
    
    .login input[type="text"],
    .login input[type="password"] {
        width: 100%;
        max-width: 400px;
        height: 30px;
        font-family: 'Ubuntu', sans-serif;
        margin: 10px 0;
        border-radius: 5px;
        border: 2px solid #f2f2f2;
        outline: none;
        padding-left: 10px;
    }
    
    .login-form input[type="button"] {
        height: 30px;
        width: 100px;
        background: #fff;
        border: 1px solid #f2f2f2;
        border-radius: 20px;
        color: slategrey;
        text-transform: uppercase;
        font-family: 'Ubuntu', sans-serif;
        cursor: pointer;
    }
    
    .sign-up {
        color: #f2f2f2;
        margin-left: -400px;
        cursor: pointer;
        text-decoration: underline;
    }
    
    .no-access {
        color: #E86850;
        margin: 20px 0px 20px -300px;
        text-decoration: underline;
        cursor: pointer;
    }
    
    .try-again {
        color: #f2f2f2;
        text-decoration: underline;
        cursor: pointer;
    }
    
    .login-button {
        margin-top: 15px;
    }
    .logo{
        width: 80px;
        height: auto;
    }
    </style>
</head>






<body background="<%=request.getContextPath() %>/back-end/login/bg_2.jpeg">
    <link href="http://fonts.googleapis.com/css?family=Ubuntu:500" rel="stylesheet" type="text/css">
   
    
   
    <div><img src="<%=request.getContextPath() %>/back-end/login/logo.jpg" class="logo img-circle img-round"></div>
    <div class="login">
        <div class="login-header">
            <h1><b>ADMIN LOGIN</b></h1>
        </div>
        
     <c:if test="${not empty errorMsgs}">
		<H3><font color='red'>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</font></H3>
		
	</c:if>
        
       
     <FORM action="<%=request.getContextPath() %>/login" method="post">  
     
        <div class="login-form">
                
            <h3> 帳號 :</h3>
            <input type="text" placeholder="Username"  name="account" value="">
            <br>
            <h3> 密碼 :</h3>
            <input type="password" placeholder="Password" name="password" value="" >
            <br>
            <input type="submit" name="action" value="login" class="login-button btn-info img-rounded" ></a>
            <br>
            <br>
           
        </div>
        
      </FORM> 
       
    </div>


</body>




</html>