<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<button>Send an HTTP POST request to a page and get the result back</button>
<button id="button2">button2</button>
<div id="test">sdfsdf</div>

<script>
	$(document).ready(function(){
	    $("button").click(function(){
	        $("#div1").load("index.jsp");
	    });
	    $("#button2").click(function(){
	        $.post("NewFile.jsp",
	        {
	          name: "Donald Duck",
	          city: "Duckburg"
	        },
	        function(data,status){
	        	alert(data);
// 	        	$("#test").html("hi good morning");
       	        $("#test").load(data, function(responseTxt, statusTxt, xhr){
       	            if(statusTxt == "success")
       	                alert("External content loaded successfully!");
       	            if(statusTxt == "error")
       	                alert("Error: " + xhr.status + ": " + xhr.statusText);
       	        });       	
	        });
	    });    
	});
</script>
</head>
<body>

</body>
</html>

