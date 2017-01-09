function login() {
	var xhr = new XMLHttpRequest();
	// 設定好回呼函數
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var responseText = xhr.responseText;
				console.log(xhr.responseText);
			} else {
				alert(xhr.status);
			}// xhr.status == 200
		}// xhr.readyState == 4
	};// onreadystatechange

	// 建立好Get連接
	var data_info = "memId=" + document.getElementById("memId").value
			+ "&memPsw=" + document.getElementById("memPsw").value;
	console.log(data_info);
	var url = "mem_login/ajaxLogin_check.jsp"; // Bad : 沒有封死路徑
	xhr.open("Post", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(data_info);
}

document.getElementById("btnLogin").onclick = login;

