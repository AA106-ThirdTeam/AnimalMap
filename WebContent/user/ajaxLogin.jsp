<%@page contentType="text/html;charset=Big5"  language="java" import="java.sql.*" errorPage=""%> 
<%@page import="org.json.JSONObject"%>
<%
//���o�e�ݰe�Ӫ���� 
String memId = request.getParameter("memId");
String memPsw = request.getParameter("memPsw");

//���JJDBC�X�ʵ{�����O 
//Class.forName("oracle.jdbc.driver.OracleDriver");
//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr", "123456"); 
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sample","root", "root");   
  
//�إ�PreparedStatement���� 
PreparedStatement stmt = conn.prepareStatement("select * from member_table where memId=? and memPsw=?");

//�N�J���    
stmt.setString(1, memId);
stmt.setString(2, memPsw);

//����PreparedStatement
ResultSet rs=stmt.executeQuery();
  
//���^�@�����
rs.next();

// session.setAttribute("memId" , memId);
out.print(rs.getString("memName"));
rs.close();
stmt.close();
conn.close();
%>  
