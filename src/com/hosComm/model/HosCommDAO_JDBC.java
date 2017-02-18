package com.hosComm.model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HosCommDAO_JDBC implements HosCommDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "aa106g3";
	String passwd = "aa106g3";
	
	
	private static final String INSERT_STMT = "INSERT INTO hos_comment (hosComment_Id, hosComment_MemId, hosComment_HosId, hosComment_content, hosComment_SendTime) "
			+ "VALUES (?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT hosComment_Id, hosComment_MemId, hosComment_HosId, hosComment_content,"
			+ "hosComment_SendTime FROM hos_comment order by hosComment_id";

	private static final String FIND_BY_PRIMEKEY_STMT = "SELECT hosComment_Id, hosComment_MemId, hosComment_HosId, hosComment_content,"
			+ "to_char(hosComment_SendTime,'yyyy-mm-dd') hosComment_SendTime FROM hos_comment where hosComment_id = ?";

	private static final String DELETE = "DELETE FROM hos_comment where hosComment_Id = ?";
	
	private static final String UPDATE = "UPDATE hos_comment set hosComment_MemId=?, hosComment_HosId=?, hosComment_content=?,"
			+ "hosComment_SendTime=?  where hosComment_Id=?";

	@Override
	public void insert(HosCommVO hosCommentVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			con.setAutoCommit(false);

			pstmt.setString(1, hosCommentVO.getHosComment_Id());
			pstmt.setString(2, hosCommentVO.getHosComment_MemId());
			pstmt.setString(3, hosCommentVO.getHosComment_HosId());
			pstmt.setString(4, hosCommentVO.getHosComment_content());
			pstmt.setTimestamp(5, hosCommentVO.getHosComment_SendTime());
		
			

			pstmt.executeUpdate();

			con.commit();
			con.setAutoCommit(true);
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {

			try {
				con.rollback();
			} catch (SQLException e) {

				e.printStackTrace();
			}

			throw new RuntimeException("A database error occured. " + se.getMessage());

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
	public void update(HosCommVO hosCommentVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, userid, passwd);
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(UPDATE);
			
			
			
			pstmt.setString(1, hosCommentVO.getHosComment_MemId());
			pstmt.setString(2, hosCommentVO.getHosComment_HosId());
			pstmt.setString(3, hosCommentVO.getHosComment_content());
			pstmt.setTimestamp(4, hosCommentVO.getHosComment_SendTime());
			
			pstmt.setString(5, hosCommentVO.getHosComment_Id());
			
			pstmt.executeUpdate();
			
			con.commit();
			con.setAutoCommit(true);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
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
	public void delete(String hosComment_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, userid, passwd);
			
			con.setAutoCommit(false);
			
			
			
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1,1);
			pstmt.executeUpdate();
			
			con.commit();
			con.setAutoCommit(true);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
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
	public HosCommVO findByPrimaryKey(String hosComment_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HosCommVO hosCommVO = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(FIND_BY_PRIMEKEY_STMT);
			pstmt.setString(1, hosComment_Id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				hosCommVO = new HosCommVO();
				hosCommVO.setHosComment_Id(rs.getString(1));
				hosCommVO.setHosComment_MemId(rs.getString(2));
				hosCommVO.setHosComment_HosId(rs.getString(3));
				hosCommVO.setHosComment_content(rs.getString(4));
				hosCommVO.setHosComment_SendTime(rs.getTimestamp(5));
			}

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

		return hosCommVO;
	}

	@Override
	public List<HosCommVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HosCommVO> list = new ArrayList<>();
		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				HosCommVO hosCommVO = new HosCommVO();

				hosCommVO.setHosComment_Id(rs.getString(1));
				hosCommVO.setHosComment_MemId(rs.getString(2));
				hosCommVO.setHosComment_HosId(rs.getString(3));
				hosCommVO.setHosComment_content(rs.getString(4));
				hosCommVO.setHosComment_SendTime(rs.getTimestamp(5));

	
				list.add(hosCommVO);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
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

		return list;
	}

	public static void main(String args[]) {

// test INSERT=============================================================
		HosCommDAO_JDBC hosCommentDao = new HosCommDAO_JDBC();
		Calendar cal = Calendar.getInstance();
		Timestamp date =new Timestamp(cal.getTimeInMillis());
		
//		int r = (int)Math.ceil(Math.random()*10);
//		
		
		 
//		 byte[] b = null;
//		 
//		 File f = new
//		 File("C:\\AA106_WebApp\\eclipse_WTP_workspace\\AA106G3\\WebContent\\group\\hosCommentImage\\1.jpg");
//		 
//		 try{
//		 FileInputStream fis = new FileInputStream(f);
//		 BufferedInputStream bis = new BufferedInputStream(fis);
//		 b = new byte[bis.available()];
//		 bis.read(b);
//		 }catch(Exception e){e.printStackTrace();}
		 
//		 HosCommVO hosCommentVO = new HosCommVO();
//		 
//		 hosCommentVO.setHosComment_Id("01");
//		 hosCommentVO.setHosComment_MemId("01");
//		 hosCommentVO.setHosComment_HosId("156") ;
//		 hosCommentVO.setHosComment_content("to be or not to be this is the question.");
//		 hosCommentVO.setHosComment_SendTime(date);
//
//		 
//
//		 hosCommentDao.insert(hosCommentVO);
		 
//test UPDATE=========================================================
		 
		
//		 byte[] b2 = null;
//		 File f2 = new
//		 File("C:\\AA106_WebApp\\eclipse_WTP_workspace\\AA106G3\\WebContent\\group\\hosCommentImage\\avatar.jpg");
//		 try{
//			 FileInputStream fis = new FileInputStream(f2);
//			 BufferedInputStream bis = new BufferedInputStream(fis);
//			 b2 = new byte[bis.available()];
//			 bis.read(b2);
//			 }catch(Exception e){e.printStackTrace();}
//		
//		 HosCommVO hosCommVO2 = new HosCommVO();
//		 hosCommVO2.setHosComment_Id("01");
//		 hosCommVO2.setHosComment_MemId("01");
//		 hosCommVO2.setHosComment_HosId("752752") ;
//		 hosCommVO2.setHosComment_content("to be or not to be this is the question. -Hamlet");
//		 hosCommVO2.setHosComment_SendTime(date);
//
//		
//		 hosCommentDao.update(hosCommVO2);
		 
// test GETALL=========================================================
		 
//		 
		List<HosCommVO> list = hosCommentDao.getAll();
		for (HosCommVO g : list) {

			System.out.println(g.getHosComment_Id());
			System.out.println(g.getHosComment_MemId());
			System.out.println(g.getHosComment_HosId());
			System.out.println(g.getHosComment_content());
			System.out.println(g.getHosComment_SendTime());

		}
			
//test findByPrimaryKey=============================================
//			HosCommVO g = new HosCommVO();
//		    g = hosCommentDao.findByPrimaryKey(1);
//			
//			System.out.println(g.getHosComment_Id());
//			System.out.println(g.getHosComment_MemId());
//			System.out.println(g.getHosComment_HosId());
//			System.out.println(g.getHosComment_content());
//			System.out.println(g.getHosComment_SendTime());

//		test DELETE===================================================
			
//			hosCommentDao.delete("13100002");

	}

}
