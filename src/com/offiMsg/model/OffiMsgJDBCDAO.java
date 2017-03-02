package com.offiMsg.model;

import java.util.*;
import java.sql.*;

public class OffiMsgJDBCDAO implements OffiMsgDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott";
	String passwd = "tiger";

	private static final String INSERT_STMT = 
			"INSERT INTO offiMsg (offiMsg_Id,offiMsg_empId,offiMsg_Title,offiMsg_Content,offiMsg_Date) VALUES (offiMsg_seq1.NEXTVAL, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT offiMsg_Id,offiMsg_empId,offiMsg_Title,offiMsg_Content,to_char(offiMsg_Date,'yyyy-mm-dd') offiMsg_Date FROM offiMsg order by offiMsg_Id";
		private static final String GET_ONE_STMT = 
			"SELECT offiMsg_Id,offiMsg_empId,offiMsg_Title,offiMsg_Content,to_char(offiMsg_Date,'yyyy-mm-dd') offiMsg_Date FROM offiMsg where offiMsg_Id = ?";
		private static final String DELETE = 
			"DELETE FROM offiMsg where offiMsg_Id = ?";
		private static final String UPDATE = 
			"UPDATE offiMsg set offiMsg_empId=?, offiMsg_Title=?, offiMsg_Content=?, offiMsg_Date=? where offiMsg_Id = ?";
	@Override
	public void insert(OffiMsgVO offiMsgVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, offiMsgVO.getOffiMsg_empId());
			pstmt.setString(2, offiMsgVO.getOffiMsg_Title());
			pstmt.setString(3, offiMsgVO.getOffiMsg_Content());
			pstmt.setDate(4, offiMsgVO.getOffiMsg_Date());
			
			pstmt.executeUpdate();
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}
	@Override
	public void update(OffiMsgVO offiMsgVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, offiMsgVO.getOffiMsg_empId());
			pstmt.setString(2, offiMsgVO.getOffiMsg_Title());
			pstmt.setString(3, offiMsgVO.getOffiMsg_Content());
			pstmt.setDate(4, offiMsgVO.getOffiMsg_Date());
			pstmt.setString(5, offiMsgVO.getOffiMsg_Id());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}
	@Override
	public void delete(String offiMsg_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, offiMsg_Id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	@Override
	public OffiMsgVO findByPrimaryKey(String offiMsg_Id) {
		OffiMsgVO offiMsgVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, offiMsg_Id);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// offiMsgVO 也稱為 Domain objects
				offiMsgVO = new OffiMsgVO();
				offiMsgVO.setOffiMsg_Id(rs.getString("offiMsg_Id"));
				offiMsgVO.setOffiMsg_empId(rs.getString("offiMsg_empId"));
				offiMsgVO.setOffiMsg_Title(rs.getString("offiMsg_Title"));
				offiMsgVO.setOffiMsg_Content(rs.getString("offiMsg_Content"));
				offiMsgVO.setOffiMsg_Date(rs.getDate("offiMsg_Date"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return offiMsgVO;
	}
	@Override
	public List<OffiMsgVO> getAll() {
		
		List<OffiMsgVO> list = new ArrayList<OffiMsgVO>();
		OffiMsgVO offiMsgVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// offiMsgVO 也稱為 Domain objects
				offiMsgVO = new OffiMsgVO();
				offiMsgVO.setOffiMsg_Id(rs.getString("offiMsg_Id"));
				offiMsgVO.setOffiMsg_empId(rs.getString("offiMsg_empId"));
				offiMsgVO.setOffiMsg_Title(rs.getString("offiMsg_Title"));
				offiMsgVO.setOffiMsg_Content(rs.getString("offiMsg_Content"));
				offiMsgVO.setOffiMsg_Date(rs.getDate("offiMsg_Date"));
				list.add(offiMsgVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		OffiMsgJDBCDAO dao = new OffiMsgJDBCDAO();

		// 新增
//		OffiMsgVO offiMsgVO1 = new OffiMsgVO();
//		offiMsgVO1.setOffiMsg_empId("5");
//		offiMsgVO1.setOffiMsg_Title("請愛護毛小孩");
//		offiMsgVO1.setOffiMsg_Content("拜託請不要棄養毛小孩");
//		offiMsgVO1.setOffiMsg_Date(java.sql.Date.valueOf("2017-02-24"));
//		dao.insert(offiMsgVO1);

		// 修改
//		OffiMsgVO offiMsgVO2 = new OffiMsgVO();
//		offiMsgVO2.setOffiMsg_Id("15");
//		offiMsgVO2.setOffiMsg_empId("5");
//		offiMsgVO2.setOffiMsg_Title("請愛護毛小孩2");
//		offiMsgVO2.setOffiMsg_Content("拜託請不要棄養毛小孩!!!!");
//		offiMsgVO2.setOffiMsg_Date(java.sql.Date.valueOf("2017-03-24"));
//		dao.update(offiMsgVO2);

		// 刪除
//		dao.delete("10");

		// 查詢
		OffiMsgVO offiMsgVO3  = dao.findByPrimaryKey("1");
		System.out.print(offiMsgVO3.getOffiMsg_Id() + ",");
		System.out.print(offiMsgVO3.getOffiMsg_empId() + ",");
		System.out.print(offiMsgVO3.getOffiMsg_Title() + ",");
		System.out.print(offiMsgVO3.getOffiMsg_Content() + ",");
		System.out.println(offiMsgVO3.getOffiMsg_Date());
		System.out.println("---------------------");

		// 查詢
		List<OffiMsgVO> list = dao.getAll();
		for (OffiMsgVO aOffiMsg : list) {
			System.out.print(aOffiMsg.getOffiMsg_Id() + ",");
			System.out.print(aOffiMsg.getOffiMsg_empId() + ",");
			System.out.print(aOffiMsg.getOffiMsg_Title() + ",");
			System.out.print(aOffiMsg.getOffiMsg_Content() + ",");
			System.out.print(aOffiMsg.getOffiMsg_Date());
			System.out.println();
		}
	}
}

