package chat_room;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

class INSERT_PreparedStatement {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "SCOTT";
	private static final String PASSWORD = "food1234";
	private static final String SQL = "INSERT INTO TEST(NAME, SAY,TIME)" + "VALUES(?,?,?)";

	public static void main(String aName, String aSay) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);

			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, aName);
			pstmt.setString(2, aSay);

			// Date date = new Date(System.currentTimeMillis());
			// System.out.println(date);
			// pstmt.setDate(3, (java.sql.Date) date);// �����~
			Date date = new Date(System.currentTimeMillis());
			pstmt.setDate(3, date);

			int rowCount = pstmt.executeUpdate();
			System.out.println("�s�W " + rowCount + " �����");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}

public class MessageStorage implements ServletContextListener,ServletContextAttributeListener {
	private static final JSONObject JSON_OBJ = new JSONObject();
	// �d���s��
	private static long countSize = 0;
	// �̦h�X�����
	private static final long MAXMESSAGECOUNT = 5;
	// �Ҧ��D�P�B�ШD��AsyncContext�N�x�s�ܳo��List
	private List<AsyncContext> asyncs = new ArrayList<AsyncContext>();
	private static List<Object> list = new ArrayList<Object>();
	
	// ��l��
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// do nothing
		// System.out.println("ServletContextListener�q��: contextDestroyed....");
	}
	
    @Override
    public void attributeAdded(ServletContextAttributeEvent scab) {
        //...
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scab) {
        //...
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scab) {
        //...
    }	
	
	public static JSONObject main(boolean isNull, String aName, String aSay) {
		if (!isNull) {
			try {
				 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 String dateTime = df.format(System.currentTimeMillis()).toString();
				 JSON_OBJ.put(String.valueOf(++countSize), dateTime + " " +
				 aName + " ��: " + aSay);
				// �p�G�W�Lx���A�N�s��DB�h
				if (JSON_OBJ.length() > MAXMESSAGECOUNT) {
					System.out.println("WOW");
					// �R�����¤@��
					JSON_OBJ.remove(String.valueOf(countSize - MAXMESSAGECOUNT));
					// �x�s��DB
					INSERT_PreparedStatement.main(aName, aSay);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return JSON_OBJ;
	}

	public static void Test(HttpServletRequest req, HttpServletResponse res) {
		// System.out.println(req);
		// System.out.println(res);
		list.add(req);
	}

}
