package com.shop_comment.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:商家留言<br>
 *	英文:shop_comment<br>
 */ 
public class Shop_commentDAO implements Shop_commentDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (shopComm_Id,shopComm_MemId,shopComm_ShopId,shopComm_content,shopComm_SendTime ) VALUES  ( shop_comment_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE shop_comment SET shopComm_content=?,shopComm_SendTime=?  WHERE shopComm_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM shop_comment WHERE shopComm_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT shopComm_Id,shopComm_MemId,shopComm_ShopId,shopComm_content,to_char(shopComm_SendTime,'yyyy-mm-dd') shopComm_SendTime WHERE shopComm_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT shopComm_Id,shopComm_MemId,shopComm_ShopId,shopComm_content,to_char(shopComm_SendTime,'yyyy-mm-dd') shopComm_SendTime WHERE shopComm_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_SHOPCOMM_CONTENT =" UPDATE shop_comment set SHOPCOMM_CONTENT=?  WHERE shopComm_Id=? " ; 
	private static final String UPDATE_SHOPCOMM_SENDTIME =" UPDATE shop_comment set SHOPCOMM_SENDTIME=?  WHERE shopComm_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Shop_commentVO aShop_commentVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Shop_commentDAO.INSERT_STMT);
			pstmt.setString (1, aShop_commentVO.getShopComm_MemId());
			pstmt.setString (2, aShop_commentVO.getShopComm_ShopId());
			pstmt.setString (3, aShop_commentVO.getShopComm_content());
			pstmt.setDate (4, aShop_commentVO.getShopComm_SendTime());
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
	public void update(Shop_commentVO aShop_commentVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Shop_commentDAO.UPDATE);
			pstmt.setString (1, aShop_commentVO.getShopComm_content());
			pstmt.setDate (2, aShop_commentVO.getShopComm_SendTime());
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
	public void delete(String  aShop_comment){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Shop_commentDAO.DELETE);
			pstmt.setString (1,aShop_comment);
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
	public Shop_commentVO findByPrimaryKey(String  aShop_comment){
		Shop_commentVO shop_commentVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Shop_commentDAO.GET_ONE_STMT);
			pstmt.setString (1,aShop_comment);
			pstmt.executeUpdate();
			while (rs.next()) {
				shop_commentVO = new Shop_commentVO();
				shop_commentVO.setShopComm_Id(rs.getString("shopComm_Id"));
				shop_commentVO.setShopComm_MemId(rs.getString("shopComm_MemId"));
				shop_commentVO.setShopComm_ShopId(rs.getString("shopComm_ShopId"));
				shop_commentVO.setShopComm_content(rs.getString("shopComm_content"));
				shop_commentVO.setShopComm_SendTime(rs.getDate("shopComm_SendTime"));
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
		return shop_commentVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Shop_commentVO> getAll(){ 
		List<Shop_commentVO> list = new ArrayList<Shop_commentVO>();
		Shop_commentVO shop_commentVO = null;
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