<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Title Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        <!--[if lt IE 9]>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <script src="https://code.jquery.com/jquery.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>        
    </head>
    <body>
        
        <h1 class="text-center">哈囉～哩後！</h1>
        <input type="button" name="" id="create_MVC-model" value="製造MVC_Model">
        
        <script>
            $(document).ready(function() {
                $("#create_MVC-model").click(function() {
<%--                		alert("<%=request.getContextPath()%>/excel2model_Servlet"); --%>
                    $.ajax({
                       url:   "<%=request.getContextPath()%>/excel2model_Servlet",
                       type : "POST",
                       data : {
                       	data : "HI"
                       },
                       //傳帳號密碼。
                       success : function(data, status) {
//                        	alert(data);
                       },
                       error : function(data, status, er) {
                       }
                   	});
               	});
            });
        </script>        
    </body>
</html>