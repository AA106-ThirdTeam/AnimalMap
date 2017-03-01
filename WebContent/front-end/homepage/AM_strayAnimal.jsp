<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<div class="uploader" id="drag-and-drop-zone">
    <div>Drag &amp; Drop Images Here</div>
    <div class="or">-or-</div>
    <div class="browser">
        <label>
            <span>Select Image</span>
            <input type="file" title="Click to add Images" accept="image/*" name="files">
        </label>
    </div>
</div>

<script>

$(document).ready(function(){
    $(window).on('dragenter', function(){
        $(this).preventDefault();
    });
    $('#drag-and-drop-zone').bind('dragover', function(){
        $(this).addClass('drag-over');
    });
    $('#drag-and-drop-zone').bind('dragleave', function(){
        $(this).removeClass('drag-over');
    });
});

</script>

<style>
/*AM_strayAnimal*/
.uploader{
    width: 100%;
    background-color: #f9f9f9;
    color: #92AAB0;
    text-align: center;
    vertical-align: middle;
    padding: 30px 0px;
    margin-bottom: 10px;
    border-radius: 5px;
    font-size: 200%;
    box-shadow: inset 0px 0px 20px #c9afb2;
    cursor: default;
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -khtml-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

.uploader div.or {
    font-size: 50%;
    font-weight: bold;
    color: #C0C0C0;
    padding: 10px;
}

.uploader div.browser label {
    background-color: #ffffff;
    border: 2px solid #f44;
    padding: 5px 15px;
    color: #f44;
    padding: 6px 0px;
    font-size: 40%;
    font-weight: bold;
}
</style>