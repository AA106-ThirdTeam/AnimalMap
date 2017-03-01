<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.mem.model.*"%>
<%
MemVO memVO = (MemVO) request.getAttribute("memVO");
%>

<html>
<head>
<title>登入</title></head>


<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/mem/mem.do" name="form1">
登入之會員帳號:
<input type="text" name="loginMemId">
<input type="hidden" name="action" value="login">
<input type="submit" value="登入"></FORM>
</body>

</html>
