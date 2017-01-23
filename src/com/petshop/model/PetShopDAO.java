package com.petshop.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:寵物商店<br>
 *	英文:petShop<br>
 */ 
public class PetShopDAO implements PetShopDAO_interface{
	private static DataSource ds = null; 
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO (shop_Id,shop_MemId,shop_name,shop_city,shop_town,shop_road,shop_Eval,shop_URL,shop_StartTime,shop_EndTime,shop_Tel,shop_Desc,shop_Long,shop_Lat,shop_CreateTime,shop_visible ) VALUES  ( petShop_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE petShop SET shop_name=?,shop_city=? ,shop_town=? ,shop_road=? ,shop_Eval=? ,shop_URL=? ,shop_StartTime=? ,shop_EndTime=? ,shop_Tel=? ,shop_Desc=? ,shop_Long=? ,shop_Lat=? ,shop_CreateTime=? ,shop_visible=?  WHERE shop_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM petShop WHERE shop_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT shop_Id,shop_MemId,shop_name,shop_city,shop_town,shop_road,shop_Eval,shop_URL,to_char(shop_StartTime,'yyyy-mm-dd') shop_StartTime,to_char(shop_EndTime,'yyyy-mm-dd') shop_EndTime,shop_Tel,shop_Desc,shop_Long,shop_Lat,to_char(shop_CreateTime,'yyyy-mm-dd') shop_CreateTime,shop_visible WHERE shop_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT shop_Id,shop_MemId,shop_name,shop_city,shop_town,shop_road,shop_Eval,shop_URL,to_char(shop_StartTime,'yyyy-mm-dd') shop_StartTime,to_char(shop_EndTime,'yyyy-mm-dd') shop_EndTime,shop_Tel,shop_Desc,shop_Long,shop_Lat,to_char(shop_CreateTime,'yyyy-mm-dd') shop_CreateTime,shop_visible WHERE shop_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_SHOP_NAME =" UPDATE petShop set SHOP_NAME=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_CITY =" UPDATE petShop set SHOP_CITY=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_TOWN =" UPDATE petShop set SHOP_TOWN=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_ROAD =" UPDATE petShop set SHOP_ROAD=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_EVAL =" UPDATE petShop set SHOP_EVAL=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_URL =" UPDATE petShop set SHOP_URL=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_STARTTIME =" UPDATE petShop set SHOP_STARTTIME=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_ENDTIME =" UPDATE petShop set SHOP_ENDTIME=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_TEL =" UPDATE petShop set SHOP_TEL=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_DESC =" UPDATE petShop set SHOP_DESC=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_LONG =" UPDATE petShop set SHOP_LONG=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_LAT =" UPDATE petShop set SHOP_LAT=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_CREATETIME =" UPDATE petShop set SHOP_CREATETIME=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_VISIBLE =" UPDATE petShop set SHOP_VISIBLE=?  WHERE shop_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(PetShopVO aPetShopVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PetShopDAO.INSERT_STMT);
			pstmt.setString (1, aPetShopVO.getShop_MemId());
			pstmt.setString (2, aPetShopVO.getShop_name());
			pstmt.setString (3, aPetShopVO.getShop_city());
			pstmt.setString (4, aPetShopVO.getShop_town());
			pstmt.setString (5, aPetShopVO.getShop_road());
			pstmt.setInt (6, aPetShopVO.getShop_Eval());
			pstmt.setString (7, aPetShopVO.getShop_URL());
			pstmt.setDate (8, aPetShopVO.getShop_StartTime());
			pstmt.setDate (9, aPetShopVO.getShop_EndTime());
			pstmt.setString (10, aPetShopVO.getShop_Tel());
			pstmt.setString (11, aPetShopVO.getShop_Desc());
			pstmt.setDouble (12, aPetShopVO.getShop_Long());
			pstmt.setDouble (13, aPetShopVO.getShop_Lat());
			pstmt.setDate (14, aPetShopVO.getShop_CreateTime());
			pstmt.setString (15, aPetShopVO.getShop_visible());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	//====以下是改寫update方法====
	@Override
	public void update(PetShopVO aPetShopVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PetShopDAO.UPDATE);
			pstmt.setString (1, aPetShopVO.getShop_name());
			pstmt.setString (2, aPetShopVO.getShop_city());
			pstmt.setString (3, aPetShopVO.getShop_town());
			pstmt.setString (4, aPetShopVO.getShop_road());
			pstmt.setInt (5, aPetShopVO.getShop_Eval());
			pstmt.setString (6, aPetShopVO.getShop_URL());
			pstmt.setDate (7, aPetShopVO.getShop_StartTime());
			pstmt.setDate (8, aPetShopVO.getShop_EndTime());
			pstmt.setString (9, aPetShopVO.getShop_Tel());
			pstmt.setString (10, aPetShopVO.getShop_Desc());
			pstmt.setDouble (11, aPetShopVO.getShop_Long());
			pstmt.setDouble (12, aPetShopVO.getShop_Lat());
			pstmt.setDate (13, aPetShopVO.getShop_CreateTime());
			pstmt.setString (14, aPetShopVO.getShop_visible());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	//====以下是改寫delete方法====
	@Override
	public void delete(String  aPetShop){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PetShopDAO.DELETE);
			pstmt.setString (1,aPetShop);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	//====以下是改寫findByPrimaryKey方法====
	@Override
	public PetShopVO findByPrimaryKey(String  aPetShop){
	PetShopVO petshopVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PetShopDAO.DELETE);
			pstmt.setString (1,aPetShop);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return petshopVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<PetShopVO> getAll(){ 
		List<PetShopVO> list = new ArrayList<PetShopVO>();
		PetShopVO petshopVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PetShopDAO.DELETE);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return list;	} 
}