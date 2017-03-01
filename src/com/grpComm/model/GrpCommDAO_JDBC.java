package com.grpComm.model;

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

public class GrpCommDAO_JDBC implements GrpCommDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "aa106g3";
	String passwd = "aa106g3";
	

	private static final String INSERT_STMT = "INSERT INTO grp_comment (grpComment_Id, grpComment_MemId, grpComment_GrpId, grpComment_content, grpComment_SendTime) "
			+ "VALUES (?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT grpComment_Id, grpComment_MemId, grpComment_GrpId, grpComment_content,"
			+ "to_char(grpComment_SendTime,'yyyy-mm-dd') grpComment_SendTime FROM grp_comment order by grpComment_id";

	private static final String FIND_BY_PRIMEKEY_STMT = "SELECT grpComment_Id, grpComment_MemId, grpComment_GrpId, grpComment_content,"
			+ "to_char(grpComment_SendTime,'yyyy-mm-dd') grpComment_SendTime FROM grp_comment where grpComment_id = ?";

	private static final String DELETE = "DELETE FROM grp_comment where grpComment_Id = ?";
	
	private static final String UPDATE = "UPDATE grp_comment set grpComment_MemId=?, grpComment_GrpId=?, grpComment_content=?,"
			+ "grpComment_SendTime=?  where grpComment_Id=?";

	@Override
	public void insert(GrpCommVO grpCommentVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			con.setAutoCommit(false);

			pstmt.setString(1, grpCommentVO.getGrpComment_Id());
			pstmt.setString(2, grpCommentVO.getGrpComment_MemId());
			pstmt.setString(3, grpCommentVO.getGrpComment_GrpId());
			pstmt.setString(4, grpCommentVO.getGrpComment_content());
			pstmt.setTimestamp(5, grpCommentVO.getGrpComment_SendTime());
		
			

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
	public void update(GrpCommVO grpCommentVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, userid, passwd);
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(UPDATE);
			
			
			
			pstmt.setString(1, grpCommentVO.getGrpComment_MemId());
			pstmt.setString(2, grpCommentVO.getGrpComment_GrpId());
			pstmt.setString(3, grpCommentVO.getGrpComment_content());
			pstmt.setTimestamp(4, grpCommentVO.getGrpComment_SendTime());
			
			pstmt.setString(5, grpCommentVO.getGrpComment_Id());
			
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
	public void delete(String grpComment_Id) {
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
	public GrpCommVO findByPrimaryKey(String grpComment_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GrpCommVO grpCommVO = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(FIND_BY_PRIMEKEY_STMT);
			pstmt.setString(1, grpComment_Id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				grpCommVO = new GrpCommVO();
				grpCommVO.setGrpComment_Id(rs.getString(1));
				grpCommVO.setGrpComment_MemId(rs.getString(2));
				grpCommVO.setGrpComment_GrpId(rs.getString(3));
				grpCommVO.setGrpComment_content(rs.getString(4));
				grpCommVO.setGrpComment_SendTime(rs.getTimestamp(5));
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

		return grpCommVO;
	}

	@Override
	public List<GrpCommVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GrpCommVO> list = new ArrayList<>();
		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				GrpCommVO grpCommVO = new GrpCommVO();

				grpCommVO.setGrpComment_Id(rs.getString(1));
				grpCommVO.setGrpComment_MemId(rs.getString(2));
				grpCommVO.setGrpComment_GrpId(rs.getString(3));
				grpCommVO.setGrpComment_content(rs.getString(4));
				grpCommVO.setGrpComment_SendTime(rs.getTimestamp(5));

	
				list.add(grpCommVO);
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
		GrpCommDAO_JDBC grpCommentDao = new GrpCommDAO_JDBC();
		Calendar cal = Calendar.getInstance();
		Timestamp date =new Timestamp(cal.getTimeInMillis());
		
//		int r = (int)Math.ceil(Math.random()*10);
//		
		
		 
//		 byte[] b = null;
//		 
//		 File f = new
//		 File("C:\\AA106_WebApp\\eclipse_WTP_workspace\\AA106G3\\WebContent\\group\\grpCommentImage\\1.jpg");
//		 
//		 try{
//		 FileInputStream fis = new FileInputStream(f);
//		 BufferedInputStream bis = new BufferedInputStream(fis);
//		 b = new byte[bis.available()];
//		 bis.read(b);
//		 }catch(Exception e){e.printStackTrace();}
		 
		 GrpCommVO grpCommentVO = new GrpCommVO();
		 
		 grpCommentVO.setGrpComment_Id("01");
		 grpCommentVO.setGrpComment_MemId("01");
		 grpCommentVO.setGrpComment_GrpId("156") ;
		 grpCommentVO.setGrpComment_content("to be or not to be this is the question.");
		 grpCommentVO.setGrpComment_SendTime(date);

		 

		 grpCommentDao.insert(grpCommentVO);
//		 
//test UPDATE=========================================================
		 
		
//		 byte[] b2 = null;
//		 File f2 = new
//		 File("C:\\AA106_WebApp\\eclipse_WTP_workspace\\AA106G3\\WebContent\\group\\grpCommentImage\\avatar.jpg");
//		 try{
//			 FileInputStream fis = new FileInputStream(f2);
//			 BufferedInputStream bis = new BufferedInputStream(fis);
//			 b2 = new byte[bis.available()];
//			 bis.read(b2);
//			 }catch(Exception e){e.printStackTrace();}
//		
//		 GrpCommVO grpCommVO2 = new GrpCommVO();
//		 grpCommVO2.setGrpComment_Id("01");
//		 grpCommVO2.setGrpComment_MemId("01");
//		 grpCommVO2.setGrpComment_GrpId("752752") ;
//		 grpCommVO2.setGrpComment_content("to be or not to be this is the question. -Hamlet");
//		 grpCommVO2.setGrpComment_SendTime(date);
//
//		
//		 grpCommentDao.update(grpCommVO2);
		 
// test GETALL=========================================================
		 
//		 
//		List<GrpCommVO> list = grpCommentDao.getAll();
//		for (GrpCommVO g : list) {
//
//			System.out.println(g.getGrpComment_Id());
//			System.out.println(g.getGrpComment_MemId());
//			System.out.println(g.getGrpComment_GrpId());
//			System.out.println(g.getGrpComment_content());
//			System.out.println(g.getGrpComment_SendTime());
//
//		}
			
//test findByPrimaryKey=============================================
//			GrpCommVO g = new GrpCommVO();
//		    g = grpCommentDao.findByPrimaryKey(1);
//			
//			System.out.println(g.getGrpComment_Id());
//			System.out.println(g.getGrpComment_MemId());
//			System.out.println(g.getGrpComment_GrpId());
//			System.out.println(g.getGrpComment_content());
//			System.out.println(g.getGrpComment_SendTime());

//		test DELETE===================================================
			
//			grpCommentDao.delete(1);

	}

}
