<%@page import="utils.excel2sql.Excel_create_fakeDB"%>
<%@page import="utils.excel2sql.Excel_to_SQL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 	Excel_create_fakeDB ecfb = new Excel_create_fakeDB();
	// 	String[] args = {}; 
	// 	ecfb.main(args);
%>


<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>上傳Excel</title>
    <style type="text/css">
    body {
        font-family: sans-serif;
        background-color: #eeeeee;
    }
    
    .file-upload {
        background-color: #ffffff;
        width: 600px;
        margin: 0 auto;
        padding: 20px;
    }
    
    .file-upload-btn {
        width: 100%;
        margin: 0;
        color: #fff;
        background: #1FB264;
        border: none;
        padding: 10px;
        border-radius: 4px;
        border-bottom: 4px solid #15824B;
        transition: all .2s ease;
        outline: none;
        text-transform: uppercase;
        font-weight: 700;
    }
    
    .file-upload-btn:hover {
        background: #1AA059;
        color: #ffffff;
        transition: all .2s ease;
        cursor: pointer;
    }
    
    .file-upload-btn:active {
        border: 0;
        transition: all .2s ease;
    }
    
    .file-upload-content {
        display: none;
        text-align: center;
    }
    
    .file-upload-input {
        position: absolute;
        margin: 0;
        padding: 0;
        width: 100%;
        height: 100%;
        outline: none;
        opacity: 0;
        cursor: pointer;
    }
    
    .image-upload-wrap {
        margin-top: 20px;
        border: 4px dashed #1FB264;
        position: relative;
    }
    
    .image-dropping,
    .image-upload-wrap:hover {
        background-color: #1FB264;
        border: 4px dashed #ffffff;
    }
    
    .image-title-wrap {
        padding: 0 15px 15px 15px;
        color: #222;
    }
    
    .drag-text {
        text-align: center;
    }
    
    .drag-text h3 {
        font-weight: 100;
        text-transform: uppercase;
        color: #15824B;
        padding: 60px 0;
    }
    
    .file-upload-image {
        max-height: 200px;
        max-width: 200px;
        margin: auto;
        padding: 20px;
    }
    
    .remove-image {
        width: 200px;
        margin: 0;
        color: #fff;
        background: #cd4535;
        border: none;
        padding: 10px;
        border-radius: 4px;
        border-bottom: 4px solid #b02818;
        transition: all .2s ease;
        outline: none;
        text-transform: uppercase;
        font-weight: 700;
    }
    
    .remove-image:hover {
        background: #c13b2a;
        color: #ffffff;
        transition: all .2s ease;
        cursor: pointer;
    }
    
    .remove-image:active {
        border: 0;
        transition: all .2s ease;
    }
    </style>
</head>

<body>
    <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <div class="file-upload">
        <form action="UploadFile.do" method="post" enctype="multipart/form-data">
            <button class="file-upload-btn" type="button" onclick="$('.file-upload-input').trigger( 'click' )">上傳Excel</button>
            <div class="image-upload-wrap">
                <input class="file-upload-input" name="file" type='file' onchange="readURL(this);" accept="image/*" />
                <div class="drag-text">
                    <h3>拖拉Excel到這裡</h3>
                </div>
            </div>
            <div class="file-upload-content">
                <img class="file-upload-image" src="https://i.imgur.com/QqyiFBH.png" alt="Excel檔案" />
                <div class="image-title-wrap">
                    <button type="button" onclick="removeUpload()" class="remove-image">Remove <span class="image-title">上傳Excel</span></button>
                </div>
            </div>
            <input type="submit" class="file-upload-btn" value="upload" style="
			    background: #F44336;
			    border-bottom: 4px solid #742019;
			    margin-top: 20px;
			">
        </form>
    </div>
    <script type="text/javascript">
    function readURL(input) {
        if (input.files && input.files[0]) {

            var reader = new FileReader();

            reader.onload = function(e) {
                $('.image-upload-wrap').hide();

                // $('.file-upload-image').attr('src', e.target.result);
                $('.file-upload-content').show();

                $('.image-title').html(input.files[0].name);
            };

            reader.readAsDataURL(input.files[0]);

        } else {
            removeUpload();
        }
    }

    function removeUpload() {
        $('.file-upload-input').replaceWith($('.file-upload-input').clone());
        $('.file-upload-content').hide();
        $('.image-upload-wrap').show();
    }
    $('.image-upload-wrap').bind('dragover', function() {
        $('.image-upload-wrap').addClass('image-dropping');
    });
    $('.image-upload-wrap').bind('dragleave', function() {
        $('.image-upload-wrap').removeClass('image-dropping');
    });
    </script>
</body>

</html>
