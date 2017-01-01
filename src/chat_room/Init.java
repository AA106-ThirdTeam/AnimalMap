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
				"    <TITLE>��ѫ� ver0.1</TITLE>\r\n" + 
				"    <!-- <link rel='stylesheet' type='text/css' href='css/main.css'> -->\r\n" + 
				"</HEAD>\r\n" + 
				"\r\n" + 
				"<BODY>\r\n" + 
				"\r\n" + 
				"<!--     <FORM method=post\r\n" + 
				"        enctype='multipart/form-data'>\r\n" + 
				"        <input type='file' name='upfile1'> <input type='submit'\r\n" + 
				"            value='�W��'>\r\n" + 
				"    </FORM>  -->\r\n" + 
				"    <!-- ��ѫǵo�e�T���~�[ -->\r\n" + 
				"    <div class='box user'>\r\n" + 
				"        �ʺ�:<input type='text' id='nameInput' class='name' placeholder='�ʺ�'> \r\n" + 
				"        �Q�ǻ����e:<input type='text' id='messageInput' class='message box-flex-item' placeholder='����' autofocus>\r\n" + 
				"        <button id='buttonMessage' name='�e�X' value='�e�X'>�e�X</button>\r\n" + 
				"    </div>\r\n" + 
				"    <div class='box'>\r\n" + 
				"        ��ѫ�:\r\n" + 
				"        <br> --------------------------\r\n" + 
				"        <div id='messagesDiv'></div>\r\n" + 
				"    </div>\r\n" + 
				"</BODY>\r\n" + 
				"<script type='text/javascript'>\r\n" + 
				"window.onload = function () {\r\n" + 
				"    xhr = new XMLHttpRequest();\r\n" + 
				"    ��ѫǪ��� = document.getElementById('messagesDiv');\r\n" + 
				"    repeat();\r\n" + 
				"    document.getElementById('buttonMessage').onclick = �d���o�e;\r\n" + 
				"    �ǪŦr��();\r\n" + 
				"\r\n" + 
				"    //Bad\r\n" + 
				"    setInterval(�ǪŦr��,5000);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"//�d���o�e\r\n" + 
				"function �d���o�e() {\r\n" + 
				"    //�إ�xhr����(��J�{���X)\r\n" + 
				"    var data_info = 'nameInput=' + document.getElementById('nameInput').value //�@��\r\n" + 
				"        + '&messageInput=' + document.getElementById('messageInput').value; //���n�g��\r\n" + 
				"    var url = 'ChatMessage.jsp?' + data_info; //�������Ʊa�b���}�̭��C\r\n" + 
				"\r\n" + 
				"    xhr.open('Get', url, true);\r\n" + 
				"    console.log(url);\r\n" + 
				"    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');\r\n" + 
				"    xhr.send(null);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"function �ǪŦr��() {\r\n" + 
				"    var data_info = '';\r\n" + 
				"    var url = 'ChatMessage.jsp?' + data_info;\r\n" + 
				"    xhr.open('Get', url, true);\r\n" + 
				"    xhr.send(null);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"function repeat() {\r\n" + 
				"   //�]�w�n�^�I��� \r\n" + 
				"    xhr.onreadystatechange = function() {\r\n" + 
				"        if (xhr.readyState == 4) {\r\n" + 
				"            if (xhr.status == 200) {\r\n" + 
				"                var str = '';\r\n" + 
				"                var mssJson = JSON.parse(xhr.responseText);\r\n" + 
				"                for (var k in mssJson) {\r\n" + 
				"                    str += mssJson[k] + '<br>';\r\n" + 
				"                }\r\n" + 
				"                ��ѫǪ���.innerHTML = str;\r\n" + 
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
