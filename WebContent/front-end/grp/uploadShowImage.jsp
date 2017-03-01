<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<html>


<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
    .selected {
        border: 2px dotted red;
    }
    
    
    #forUpload{
    	height:100px;
    	width:100px;
    }
   
    </style>
    <script src="http://code.jquery.com/jquery-1.10.1.min.js">
    	
    </script>
    
    
</head>

<body>
    <input type="file"  onchange="loadFile(event)" multiple>
    <br>
    <div id="output"></div>
   
</body>

</html>
<script>
// var length;
var output = document.getElementById("output");

var loadFile = function(e) {

    while (output.hasChildNodes()) {
        output.removeChild(output.childNodes[0]);
    }
    
    var evt = e ? e.target : e.srcElement;
    var file = evt.files
    length = file.length;

    
    for (var i = 0; i < length; i++) {
        var img = document.createElement("img");
        
        document.getElementById("output").appendChild(img);
		

        $("#output img").attr("id","forUpload");
        
        document.querySelectorAll("#forUpload")[i].addEventListener("click", function(e) {
            var evt = e ? e.target : e.srcElement;
                      
            if (!evt.hasAttribute("class")) {
            	
            	$("#output img").removeAttr("class");
            	
                evt.setAttribute("class", "selected");
            } else {
                evt.removeAttribute("class");
            }
            
        }, false);
    
        document.querySelectorAll("#forUpload")[i].src = URL.createObjectURL(file[i]);

//         console.log(length);
//         console.log(URL.createObjectURL(file[i]));

//         document.getElementsByTagName("img")[i].onload = function() {
//             window.URL.revokeObjectURL(this.src);
//         }
    }
        
};

	function addInput(){
		var forUpload = document.querySelectorAll("#forUpload");
		
		for(var i =0;i <forUpload.length ; i++){
			if(forUpload[i].hasAttribute("class")&&!(forUpload[i].hasAttribute("name"))){
				var input = document.createElement("input");
				forUpload[i].appendChild(input).setAttribute("name", "isDisplayPhoto");
				$("[name='isDisplayPhoto']").attr("value",i);
				$("[name='isDisplayPhoto']").attr("type","hidden");
			}
		}
		
		$("[name='form1']").submit();
	}

</script>
