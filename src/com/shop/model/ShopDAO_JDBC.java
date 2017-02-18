package com.shop.model;

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

public class ShopDAO_JDBC implements ShopDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "aa106g3";
	String passwd = "aa106g3";

	private static final String INSERT_STMT = "INSERT INTO petShop (shop_Id, shop_MemId, shop_name, shop_city, shop_town, shop_road, shop_EndTime, shop_StartTime, "
			+ "shop_CreateTime, shop_Desc, shop_Long, shop_Lat, shop_visible, shop_Eval, shop_URL, shop_Tel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT shop_Id, shop_MemId, shop_name, shop_city, shop_town, shop_road, to_char(shop_EndTime,'yyyy-mm-dd') shop_EndTime,"
			+ "to_char(shop_StartTime,'yyyy-mm-dd') shop_StartTime, "
			+ "to_char(shop_CreateTime,'yyyy-mm-dd') shop_CreateTime, "
			+ "shop_Desc, shop_Long, shop_Lat, shop_visible, shop_Eval, shop_URL, shop_Tel FROM petShop order by shop_id";

	private static final String FIND_BY_PRIMEKEY_STMT = "SELECT shop_Id, shop_MemId, shop_name, shop_city, shop_town, shop_road, to_char(shop_EndTime,'yyyy-mm-dd') shop_EndTime,"
			+ "to_char(shop_StartTime,'yyyy-mm-dd') shop_StartTime, "
			+ "to_char(shop_CreateTime,'yyyy-mm-dd') shop_CreateTime, "
			+ "shop_Desc, shop_Long, shop_Lat, shop_visible, shop_Eval, shop_URL, shop_Tel FROM petShop where shop_Id=?";

	private static final String DELETE = "DELETE FROM petShop where shop_Id = ?";
	
	private static final String UPDATE = "UPDATE petShop set shop_MemId=? , shop_name=? , shop_city=? , shop_town=? , shop_road=? "
			+ ", shop_EndTime=? ,"
			+ " shop_StartTime=? , "
			+ " shop_CreateTime=? , "
			+ "shop_Desc=? , shop_Long=? , shop_Lat=? , shop_visible=? , shop_Eval=?, shop_URL=?, shop_Tel=? where shop_Id=?";

	@Override
	public void insert(ShopVO shopVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			con.setAutoCommit(false);

			pstmt.setString(1, shopVO.getShop_Id());
			pstmt.setString(2, shopVO.getShop_MemId());
			pstmt.setString(3, shopVO.getShop_name());
			pstmt.setString(4, shopVO.getShop_city());
			pstmt.setString(5, shopVO.getShop_town());
			pstmt.setString(6, shopVO.getShop_road());
			pstmt.setDate(7, shopVO.getShop_EndTime());
			pstmt.setDate(8, shopVO.getShop_StartTime());
			pstmt.setDate(9, shopVO.getShop_CreateTime());
			pstmt.setString(10, shopVO.getShop_Desc());
			pstmt.setDouble(11, shopVO.getShop_Long());
			pstmt.setDouble(12, shopVO.getShop_Lat());
			pstmt.setString(13, shopVO.getShop_visible());
			pstmt.setInt(14, shopVO.getShop_Eval());
			pstmt.setString(15, shopVO.getShop_URL());
			pstmt.setString(16, shopVO.getShop_Tel());
			

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
	public void update(ShopVO shopVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, userid, passwd);
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(UPDATE);
			
			
			pstmt.setString(1,shopVO.getShop_MemId());
			pstmt.setString(2,shopVO.getShop_name());
			pstmt.setString(3,shopVO.getShop_city());
			pstmt.setString(4,shopVO.getShop_town());
			pstmt.setString(5,shopVO.getShop_road());
			pstmt.setDate(6,shopVO.getShop_EndTime());
			pstmt.setDate(7,shopVO.getShop_StartTime());
			pstmt.setDate(8,shopVO.getShop_CreateTime());
			pstmt.setString(9,shopVO.getShop_Desc());
			pstmt.setDouble(10,shopVO.getShop_Long());
			pstmt.setDouble(11,shopVO.getShop_Lat());
			pstmt.setString(12,shopVO.getShop_visible());
			pstmt.setInt(13, shopVO.getShop_Eval());
			pstmt.setString(14, shopVO.getShop_URL());
			pstmt.setString(15, shopVO.getShop_Tel());
			
			pstmt.setString(16,shopVO.getShop_Id());
			
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
	public void delete(String shop_Id) {
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
	public ShopVO findByPrimaryKey(String shop_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShopVO shopvo = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(FIND_BY_PRIMEKEY_STMT);
			pstmt.setString(1, shop_Id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shopvo = new ShopVO();

				shopvo.setShop_Id(rs.getString(1));
				shopvo.setShop_MemId(rs.getString(2));
				shopvo.setShop_name(rs.getString(3));
				shopvo.setShop_city(rs.getString(4));
				shopvo.setShop_town(rs.getString(5));
				shopvo.setShop_road(rs.getString(6));
				shopvo.setShop_EndTime(java.sql.Date.valueOf(rs.getString(7)));
				shopvo.setShop_StartTime(java.sql.Date.valueOf(rs.getString(8)));
				shopvo.setShop_CreateTime(java.sql.Date.valueOf(rs.getString(9)));
				shopvo.setShop_Desc(rs.getString(10));
				shopvo.setShop_Long(rs.getDouble(11));
				shopvo.setShop_Lat(rs.getDouble(12));
				shopvo.setShop_visible(rs.getString(13));
				shopvo.setShop_Eval(rs.getInt(14));
				shopvo.setShop_URL(rs.getString(15));
				shopvo.setShop_Tel(rs.getString(16));
				

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

		return shopvo;
	}

	@Override
	public List<ShopVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ShopVO> list = new ArrayList<>();
		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ShopVO shopvo = new ShopVO();

				shopvo.setShop_Id(rs.getString(1));
				shopvo.setShop_MemId(rs.getString(2));
				shopvo.setShop_name(rs.getString(3));
				shopvo.setShop_city(rs.getString(4));
				shopvo.setShop_town(rs.getString(5));
				shopvo.setShop_road(rs.getString(6));
				shopvo.setShop_EndTime(java.sql.Date.valueOf(rs.getString(7)));
				shopvo.setShop_StartTime(java.sql.Date.valueOf(rs.getString(8)));
				shopvo.setShop_CreateTime(java.sql.Date.valueOf(rs.getString(9)));
				shopvo.setShop_Desc(rs.getString(10));
				shopvo.setShop_Long(rs.getDouble(11));
				shopvo.setShop_Lat(rs.getDouble(12));
				shopvo.setShop_visible(rs.getString(13));
				shopvo.setShop_Eval(rs.getInt(14));
				shopvo.setShop_URL(rs.getString(15));
				shopvo.setShop_Tel(rs.getString(16));

				list.add(shopvo);
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
		ShopDAO_JDBC shopdao = new ShopDAO_JDBC();
		Calendar cal = Calendar.getInstance();
		Date date =new Date(cal.getTimeInMillis());
		
//		int r = (int)Math.ceil(Math.random()*10);
//		
		
		 ShopVO shopvo = new ShopVO();
//		 byte[] b = null;
		 
//		 File f = new
//		 File("C:\\AA106_WebApp\\eclipse_WTP_workspace\\AA106G3\\WebContent\\group\\shopImage\\1.jpg");
//		 
//		 try{
//		 FileInputStream fis = new FileInputStream(f);
//		 BufferedInputStream bis = new BufferedInputStream(fis);
//		 b = new byte[bis.available()];
//		 bis.read(b);
//		 bis.close();
//		 fis.close();
		 
//		 }catch(Exception e){e.printStackTrace();}
		 
		 shopvo.setShop_Id("01");
		 shopvo.setShop_MemId("01");
		 shopvo.setShop_name("name01");
		 shopvo.setShop_city("city01");
		 shopvo.setShop_town("town01");
		 shopvo.setShop_road("road01");
		 shopvo.setShop_EndTime(date);
		 shopvo.setShop_StartTime(date);
		 shopvo.setShop_CreateTime(date);
		 shopvo.setShop_Desc("01");
		 shopvo.setShop_Long(100.40338);
		 shopvo.setShop_Lat(120.17403);
		 shopvo.setShop_visible("1");
		 shopvo.setShop_Eval(99);
		 shopvo.setShop_URL("http://www.googleYOU.com");
		 shopvo.setShop_Tel("0123456789");

		 shopdao.insert(shopvo);
//		 
//test UPDATE=========================================================
		 
		
//		 byte[] b2 = null;
//		 File f2 = new
//		 File("C:\\AA106_WebApp\\eclipse_WTP_workspace\\AA106G3\\WebContent\\group\\shopImage\\avatar.jpg");
//		 try{
//			 FileInputStream fis = new FileInputStream(f2);
//			 BufferedInputStream bis = new BufferedInputStream(fis);
//			 b2 = new byte[bis.available()];
//			 bis.read(b2);
//			 }catch(Exception e){e.printStackTrace();}
		
//		 
//		 ShopVO shopvo2 = new ShopVO();
//		 
//		 shopvo2.setShop_Id("01");
//		 shopvo2.setShop_MemId("78");
//		 shopvo2.setShop_name("name078");
//		 shopvo2.setShop_city("city078");
//		 shopvo2.setShop_town("town078");
//		 shopvo2.setShop_road("road078");
//		 shopvo2.setShop_EndTime(date);
//		 shopvo2.setShop_StartTime(date);
//		 shopvo2.setShop_CreateTime(date);
//		 shopvo2.setShop_Desc("04557");
//		 shopvo2.setShop_Long(178.401338);
//		 shopvo2.setShop_Lat(78.174113);
//		 shopvo2.setShop_visible("1");
//		 shopvo2.setShop_Eval("787878");
// 		 shopvo2.setShop_URL("http://www.googleYOU7578.com");
// 		 shopvo2.setShop_Tel("0123478");
//
//		
//		 shopdao.update(shopvo2);
//		 
// test GETALL=========================================================
		 
		 
//		List<ShopVO> list = shopdao.getAll();
//		for (ShopVO g : list) {
//
//			System.out.println(g.getShop_Id());
//			System.out.println(g.getShop_MemId());
//			System.out.println(g.getShop_name());
//			System.out.println(g.getShop_city());
//			System.out.println(g.getShop_town());
//			System.out.println(g.getShop_road());
//			System.out.println(g.getShop_EndTime());
//			System.out.println(g.getShop_StartTime());
//			System.out.println(g.getShop_CreateTime());
//			System.out.println(g.getShop_Desc());
//			System.out.println(g.getShop_Long());
//			System.out.println(g.getShop_Lat());
//			System.out.println(g.getShop_visible());
//			System.out.println(g.getShop_Eval());
//			System.out.println(g.getShop_URL());
//			System.out.println(g.getShop_Tel());
//		}
//test findByPrimaryKey=============================================
//			ShopVO g = new ShopVO();
//		    g = shopdao.findByPrimaryKey(1);
//			
//			System.out.println(g.getShop_Id());
//			System.out.println(g.getShop_MemId());
//			System.out.println(g.getShop_name());
//			System.out.println(g.getShop_city());
//			System.out.println(g.getShop_town());
//			System.out.println(g.getShop_road());
//			System.out.println(g.getShop_EndTime());
//			System.out.println(g.getShop_StartTime());
//			System.out.println(g.getShop_CreateTime());
//			System.out.println(g.getShop_Desc());
//			System.out.println(g.getShop_Long());
//			System.out.println(g.getShop_Lat());
//			System.out.println(g.getShop_visible());
//			System.out.println(g.getShop_Eval());
//			System.out.println(g.getShop_URL());
//			System.out.println(g.getShop_Tel());

//		test DELETE===================================================
			
//			shopdao.delete(1);

	}

}
