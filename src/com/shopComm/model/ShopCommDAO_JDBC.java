package com.shopComm.model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ShopCommDAO_JDBC implements ShopCommDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "aa106g3";
	String passwd = "aa106g3";
	
	
//	private String shopComment_Id;
//	private String shopComment_MemId ;
//	private String shopComment_ShopId ;
//	private String shopComment_content;
//	private Date shopComment_SendTime ;

	
	
	
	

	private static final String INSERT_STMT = "INSERT INTO shop_comment (shopComment_Id, shopComment_MemId, shopComment_ShopId, shopComment_content, shopComment_SendTime) "
			+ "VALUES (?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT shopComment_Id, shopComment_MemId, shopComment_ShopId, shopComment_content,"
			+ "to_char(shopComment_SendTime,'yyyy-mm-dd') shopComment_SendTime FROM shop_comment order by shopComment_id";

	private static final String FIND_BY_PRIMEKEY_STMT = "SELECT shopComment_Id, shopComment_MemId, shopComment_ShopId, shopComment_content,"
			+ "to_char(shopComment_SendTime,'yyyy-mm-dd') shopComment_SendTime FROM shop_comment where shopComment_id = ?";

	private static final String DELETE = "DELETE FROM shop_comment where shopComment_Id = ?";
	
	private static final String UPDATE = "UPDATE shop_comment set shopComment_MemId=?, shopComment_ShopId=?, shopComment_content=?,"
			+ "shopComment_SendTime=?  where shopComment_Id=?";

	@Override
	public void insert(ShopCommVO shopCommentVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			con.setAutoCommit(false);

			pstmt.setString(1, shopCommentVO.getShopComment_Id());
			pstmt.setString(2, shopCommentVO.getShopComment_MemId());
			pstmt.setString(3, shopCommentVO.getShopComment_ShopId());
			pstmt.setString(4, shopCommentVO.getShopComment_content());
			pstmt.setDate(5, shopCommentVO.getShopComment_SendTime());
		
			

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
	public void update(ShopCommVO shopCommentVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, userid, passwd);
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(UPDATE);
			
			
			
			pstmt.setString(1, shopCommentVO.getShopComment_MemId());
			pstmt.setString(2, shopCommentVO.getShopComment_ShopId());
			pstmt.setString(3, shopCommentVO.getShopComment_content());
			pstmt.setDate(4, shopCommentVO.getShopComment_SendTime());
			
			pstmt.setString(5, shopCommentVO.getShopComment_Id());
			
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
	public void delete(String shopComment_Id) {
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
	public ShopCommVO findByPrimaryKey(String shopComment_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShopCommVO shopCommVO = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(FIND_BY_PRIMEKEY_STMT);
			pstmt.setString(1, shopComment_Id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				shopCommVO = new ShopCommVO();
				shopCommVO.setShopComment_Id(rs.getString(1));
				shopCommVO.setShopComment_MemId(rs.getString(2));
				shopCommVO.setShopComment_ShopId(rs.getString(3));
				shopCommVO.setShopComment_content(rs.getString(4));
				shopCommVO.setShopComment_SendTime(rs.getDate(5));
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

		return shopCommVO;
	}

	@Override
	public List<ShopCommVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ShopCommVO> list = new ArrayList<>();
		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ShopCommVO shopCommVO = new ShopCommVO();

				shopCommVO.setShopComment_Id(rs.getString(1));
				shopCommVO.setShopComment_MemId(rs.getString(2));
				shopCommVO.setShopComment_ShopId(rs.getString(3));
				shopCommVO.setShopComment_content(rs.getString(4));
				shopCommVO.setShopComment_SendTime(rs.getDate(5));

	
				list.add(shopCommVO);
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
		ShopCommDAO_JDBC shopCommentDao = new ShopCommDAO_JDBC();
		Calendar cal = Calendar.getInstance();
		Date date =new Date(cal.getTimeInMillis());
		
//		int r = (int)Math.ceil(Math.random()*10);
//		
		
		 
//		 byte[] b = null;
//		 
//		 File f = new
//		 File("C:\\AA106_WebApp\\eclipse_WTP_workspace\\AA106G3\\WebContent\\group\\shopCommentImage\\1.jpg");
//		 
//		 try{
//		 FileInputStream fis = new FileInputStream(f);
//		 BufferedInputStream bis = new BufferedInputStream(fis);
//		 b = new byte[bis.available()];
//		 bis.read(b);
//		 }catch(Exception e){e.printStackTrace();}
		 
		 ShopCommVO shopCommentVO = new ShopCommVO();
		 
		 shopCommentVO.setShopComment_Id("01");
		 shopCommentVO.setShopComment_MemId("01");
		 shopCommentVO.setShopComment_ShopId("156") ;
		 shopCommentVO.setShopComment_content("to be or not to be this is the question.");
		 shopCommentVO.setShopComment_SendTime(date);

		 

		 shopCommentDao.insert(shopCommentVO);
		 
//test UPDATE=========================================================
		 
		
//		 byte[] b2 = null;
//		 File f2 = new
//		 File("C:\\AA106_WebApp\\eclipse_WTP_workspace\\AA106G3\\WebContent\\group\\shopCommentImage\\avatar.jpg");
//		 try{
//			 FileInputStream fis = new FileInputStream(f2);
//			 BufferedInputStream bis = new BufferedInputStream(fis);
//			 b2 = new byte[bis.available()];
//			 bis.read(b2);
//			 }catch(Exception e){e.printStackTrace();}
//		
//		 ShopCommVO shopCommVO2 = new ShopCommVO();
//		 shopCommVO2.setShopComment_Id("01");
//		 shopCommVO2.setShopComment_MemId("01");
//		 shopCommVO2.setShopComment_ShopId("752752") ;
//		 shopCommVO2.setShopComment_content("to be or not to be this is the question. -Hamlet");
//		 shopCommVO2.setShopComment_SendTime(date);
//
//		
//		 shopCommentDao.update(shopCommVO2);
		 
// test GETALL=========================================================
		 
//		 
//		List<ShopCommVO> list = shopCommentDao.getAll();
//		for (ShopCommVO g : list) {
//
//			System.out.println(g.getShopComment_Id());
//			System.out.println(g.getShopComment_MemId());
//			System.out.println(g.getShopComment_ShopId());
//			System.out.println(g.getShopComment_content());
//			System.out.println(g.getShopComment_SendTime());
//
//		}
			
//test findByPrimaryKey=============================================
//			ShopCommVO g = new ShopCommVO();
//		    g = shopCommentDao.findByPrimaryKey(1);
//			
//			System.out.println(g.getShopComment_Id());
//			System.out.println(g.getShopComment_MemId());
//			System.out.println(g.getShopComment_ShopId());
//			System.out.println(g.getShopComment_content());
//			System.out.println(g.getShopComment_SendTime());

//		test DELETE===================================================
			
//			shopCommentDao.delete(1);

	}

}
