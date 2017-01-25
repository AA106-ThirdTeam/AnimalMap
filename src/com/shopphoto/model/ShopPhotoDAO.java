package com.shopphoto.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:商家相片<br>
 *	英文:shopPhoto<br>
 */ 
public class ShopPhotoDAO implements ShopPhotoDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (shopPhoto_Id,shopPhoto_ShopId,shopPhoto_photo,isDisp_shopPhoto,shopPhoto_name,shopPhoto_extent ) VALUES  ( shopPhoto_seq1.nextval , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE shopPhoto SET shopPhoto_photo=?,isDisp_shopPhoto=? ,shopPhoto_name=? ,shopPhoto_extent=?  WHERE shopPhoto_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM shopPhoto WHERE shopPhoto_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT shopPhoto_Id,shopPhoto_ShopId,shopPhoto_photo,isDisp_shopPhoto,shopPhoto_name,shopPhoto_extent WHERE shopPhoto_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT shopPhoto_Id,shopPhoto_ShopId,shopPhoto_photo,isDisp_shopPhoto,shopPhoto_name,shopPhoto_extent WHERE shopPhoto_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_SHOPPHOTO_PHOTO =" UPDATE shopPhoto set SHOPPHOTO_PHOTO=?  WHERE shopPhoto_Id=? " ; 
	private static final String UPDATE_ISDISP_SHOPPHOTO =" UPDATE shopPhoto set ISDISP_SHOPPHOTO=?  WHERE shopPhoto_Id=? " ; 
	private static final String UPDATE_SHOPPHOTO_NAME =" UPDATE shopPhoto set SHOPPHOTO_NAME=?  WHERE shopPhoto_Id=? " ; 
	private static final String UPDATE_SHOPPHOTO_EXTENT =" UPDATE shopPhoto set SHOPPHOTO_EXTENT=?  WHERE shopPhoto_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(ShopPhotoVO aShopPhotoVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ShopPhotoDAO.INSERT_STMT);
			pstmt.setString (1, aShopPhotoVO.getShopPhoto_ShopId());
			pstmt.setBytes (2, aShopPhotoVO.getShopPhoto_photo());
			pstmt.setString (3, aShopPhotoVO.getIsDisp_shopPhoto());
			pstmt.setString (4, aShopPhotoVO.getShopPhoto_name());
			pstmt.setString (5, aShopPhotoVO.getShopPhoto_extent());
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
	public void update(ShopPhotoVO aShopPhotoVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ShopPhotoDAO.UPDATE);
			pstmt.setBytes (1, aShopPhotoVO.getShopPhoto_photo());
			pstmt.setString (2, aShopPhotoVO.getIsDisp_shopPhoto());
			pstmt.setString (3, aShopPhotoVO.getShopPhoto_name());
			pstmt.setString (4, aShopPhotoVO.getShopPhoto_extent());
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
	public void delete(String  aShopPhoto){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ShopPhotoDAO.DELETE);
			pstmt.setString (1,aShopPhoto);
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
	public ShopPhotoVO findByPrimaryKey(String  aShopPhoto){
		ShopPhotoVO shopphotoVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ShopPhotoDAO.GET_ONE_STMT);
			pstmt.setString (1,aShopPhoto);
			pstmt.executeUpdate();
			while (rs.next()) {
				shopphotoVO = new ShopPhotoVO();
				shopphotoVO.setShopPhoto_Id(rs.getString("shopPhoto_Id"));
				shopphotoVO.setShopPhoto_ShopId(rs.getString("shopPhoto_ShopId"));
				shopphotoVO.setShopPhoto_photo(rs.getBytes("shopPhoto_photo"));
				shopphotoVO.setIsDisp_shopPhoto(rs.getString("isDisp_shopPhoto"));
				shopphotoVO.setShopPhoto_name(rs.getString("shopPhoto_name"));
				shopphotoVO.setShopPhoto_extent(rs.getString("shopPhoto_extent"));
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return shopphotoVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<ShopPhotoVO> getAll(){ 
		List<ShopPhotoVO> list = new ArrayList<ShopPhotoVO>();
		ShopPhotoVO shopphotoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);			pstmt.executeUpdate();
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
		return list;
	} 
}