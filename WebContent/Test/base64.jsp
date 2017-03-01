<%@page import="java.util.Base64"%>
<%@ page language="java" pageEncoding="UTF-8" %>
<jsp:directive.page import="java.io.InputStream"/>
<jsp:directive.page import="java.io.File"/>
<%
	File file = new File("C:/Users/Administrator/AppData/Local/Google/Chrome/User Data/Default/Extensions/nonjdcjchghhkdoolnlbekcfllmednbl/5.26.1_0/images/icon19.png");
	// 二进制数组
	byte[] binary = new byte[(int)file.length()];

	Base64.Decoder decoder = Base64.getDecoder();
	Base64.Encoder encoder = Base64.getEncoder();
	
	// BASE64 编码
	String content = encoder.encodeToString(binary);
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Cookie Encoding</title>
</head>
<body>
从 Cookie 中获取到的二进制图片：<img src="data:image/jpeg;base64,<%=content %>" /> <br/>
<textarea id='cookieArea' style='width:100%; height:200px; '>
<%=content %>
</textarea>

</body>
</html>
