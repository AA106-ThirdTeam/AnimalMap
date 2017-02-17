$(document).ready(function() {
    $(".am_bookmark").click(function() {
        $.post("testControl/control.jsp", {
                btnName: $(this).attr('id') //bad
            },
            function(data, status) {
                //應該可以直接作成load路徑
                $("#AM_aside").load(data, function(responseTxt, statusTxt, xhr) {
                    if (statusTxt == "success")
                        console.log("External content loaded successfully!");
                    if (statusTxt == "error")
                        console.log("Error: " + xhr.status + ": " + xhr.statusText);
                });
            });
    });
});