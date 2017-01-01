package chat_room;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Init extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=Big5");
		PrintWriter out = response.getWriter();

		// System.out.println("HIHIHI");
		out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>\r\n" + 
				"<HTML>\r\n" + 
				"\r\n" + 
				"<HEAD>\r\n" + 
				"    <!--  -->\r\n" + 
				"    <META http-equiv='Content-Type' content='text/html; charset=UTF-8'>\r\n" + 
				"    <META name='GENERATOR' content='IBM Software Development Platform'>\r\n" + 
				"    <META http-equiv='Content-Style-Type' content='text/css'>\r\n" + 
				"    <TITLE>聊天室 ver0.1</TITLE>\r\n" + 
				"    <!-- <link rel='stylesheet' type='text/css' href='css/main.css'> -->\r\n" + 
				"</HEAD>\r\n" + 
				"\r\n" + 
				"<BODY>\r\n" + 
				"\r\n" + 
				"<!--     <FORM method=post\r\n" + 
				"        enctype='multipart/form-data'>\r\n" + 
				"        <input type='file' name='upfile1'> <input type='submit'\r\n" + 
				"            value='上傳'>\r\n" + 
				"    </FORM>  -->\r\n" + 
				"    <!-- 聊天室發送訊息外觀 -->\r\n" + 
				"    <div class='box user'>\r\n" + 
				"        暱稱:<input type='text' id='nameInput' class='name' placeholder='暱稱'> \r\n" + 
				"        想傳遞內容:<input type='text' id='messageInput' class='message box-flex-item' placeholder='消息' autofocus>\r\n" + 
				"        <button id='buttonMessage' name='送出' value='送出'>送出</button>\r\n" + 
				"    </div>\r\n" + 
				"    <div class='box'>\r\n" + 
				"        聊天室:\r\n" + 
				"        <br> --------------------------\r\n" + 
				"        <div id='messagesDiv'></div>\r\n" + 
				"    </div>\r\n" + 
				"</BODY>\r\n" + 
				"<script type='text/javascript'>\r\n" + 
				"window.onload = function () {\r\n" + 
				"    xhr = new XMLHttpRequest();\r\n" + 
				"    聊天室的框 = document.getElementById('messagesDiv');\r\n" + 
				"    repeat();\r\n" + 
				"    document.getElementById('buttonMessage').onclick = 留言發送;\r\n" + 
				"    傳空字串();\r\n" + 
				"\r\n" + 
				"    //Bad\r\n" + 
				"    setInterval(傳空字串,5000);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"//留言發送\r\n" + 
				"function 留言發送() {\r\n" + 
				"    //建立xhr物件(填入程式碼)\r\n" + 
				"    var data_info = 'nameInput=' + document.getElementById('nameInput').value //作者\r\n" + 
				"        + '&messageInput=' + document.getElementById('messageInput').value; //不要寫死\r\n" + 
				"    var url = 'ChatMessage.jsp?' + data_info; //直接把資料帶在網址裡面。\r\n" + 
				"\r\n" + 
				"    xhr.open('Get', url, true);\r\n" + 
				"    console.log(url);\r\n" + 
				"    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');\r\n" + 
				"    xhr.send(null);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"function 傳空字串() {\r\n" + 
				"    var data_info = '';\r\n" + 
				"    var url = 'ChatMessage.jsp?' + data_info;\r\n" + 
				"    xhr.open('Get', url, true);\r\n" + 
				"    xhr.send(null);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"function repeat() {\r\n" + 
				"   //設定好回呼函數 \r\n" + 
				"    xhr.onreadystatechange = function() {\r\n" + 
				"        if (xhr.readyState == 4) {\r\n" + 
				"            if (xhr.status == 200) {\r\n" + 
				"                var str = '';\r\n" + 
				"                var mssJson = JSON.parse(xhr.responseText);\r\n" + 
				"                for (var k in mssJson) {\r\n" + 
				"                    str += mssJson[k] + '<br>';\r\n" + 
				"                }\r\n" + 
				"                聊天室的框.innerHTML = str;\r\n" + 
				"                // repeat();\r\n" + 
				"                // alert(xhr.status);\r\n" + 
				"            } else {\r\n" + 
				"                // alert(xhr.status);\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"    }    \r\n" + 
				"};\r\n" + 
				"</script>\r\n" + 
				"\r\n" + 
				"</HTML>\r\n" + 
				"");
	}
}
