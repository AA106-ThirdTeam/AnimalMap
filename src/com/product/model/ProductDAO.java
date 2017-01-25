package com.product.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:商品<br>
 *	英文:product<br>
 */ 
public class ProductDAO implements ProductDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (product_no,product_name,product_introduction,product_price,product_stock,product_picture_large,product_picture_small,product_status,product_create_date,product_info,product_kind_no ) VALUES  ( product_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE product SET product_name=?,product_introduction=? ,product_price=? ,product_stock=? ,product_picture_large=? ,product_picture_small=? ,product_status=? ,product_create_date=? ,product_info=? ,product_kind_no=?  WHERE product_no=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM product WHERE product_no=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT product_no,product_name,product_introduction,product_price,product_stock,product_picture_large,product_picture_small,product_status,to_char(product_create_date,'yyyy-mm-dd') product_create_date,product_info,product_kind_no WHERE product_no=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT product_no,product_name,product_introduction,product_price,product_stock,product_picture_large,product_picture_small,product_status,to_char(product_create_date,'yyyy-mm-dd') product_create_date,product_info,product_kind_no WHERE product_no=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_PRODUCT_NAME =" UPDATE product set PRODUCT_NAME=?  WHERE product_no=? " ; 
	private static final String UPDATE_PRODUCT_INTRODUCTION =" UPDATE product set PRODUCT_INTRODUCTION=?  WHERE product_no=? " ; 
	private static final String UPDATE_PRODUCT_PRICE =" UPDATE product set PRODUCT_PRICE=?  WHERE product_no=? " ; 
	private static final String UPDATE_PRODUCT_STOCK =" UPDATE product set PRODUCT_STOCK=?  WHERE product_no=? " ; 
	private static final String UPDATE_PRODUCT_PICTURE_LARGE =" UPDATE product set PRODUCT_PICTURE_LARGE=?  WHERE product_no=? " ; 
	private static final String UPDATE_PRODUCT_PICTURE_SMALL =" UPDATE product set PRODUCT_PICTURE_SMALL=?  WHERE product_no=? " ; 
	private static final String UPDATE_PRODUCT_STATUS =" UPDATE product set PRODUCT_STATUS=?  WHERE product_no=? " ; 
	private static final String UPDATE_PRODUCT_CREATE_DATE =" UPDATE product set PRODUCT_CREATE_DATE=?  WHERE product_no=? " ; 
	private static final String UPDATE_PRODUCT_INFO =" UPDATE product set PRODUCT_INFO=?  WHERE product_no=? " ; 
	private static final String UPDATE_PRODUCT_KIND_NO =" UPDATE product set PRODUCT_KIND_NO=?  WHERE product_no=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(ProductVO aProductVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ProductDAO.INSERT_STMT);
			pstmt.setString (1, aProductVO.getProduct_name());
			pstmt.setString (2, aProductVO.getProduct_introduction());
			pstmt.setInt (3, aProductVO.getProduct_price());
			pstmt.setInt (4, aProductVO.getProduct_stock());
			pstmt.setBytes (5, aProductVO.getProduct_picture_large());
			pstmt.setBytes (6, aProductVO.getProduct_picture_small());
			pstmt.setInt (7, aProductVO.getProduct_status());
			pstmt.setDate (8, aProductVO.getProduct_create_date());
			pstmt.setString (9, aProductVO.getProduct_info());
			pstmt.setInt (10, aProductVO.getProduct_kind_no());
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
	public void update(ProductVO aProductVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ProductDAO.UPDATE);
			pstmt.setString (1, aProductVO.getProduct_name());
			pstmt.setString (2, aProductVO.getProduct_introduction());
			pstmt.setInt (3, aProductVO.getProduct_price());
			pstmt.setInt (4, aProductVO.getProduct_stock());
			pstmt.setBytes (5, aProductVO.getProduct_picture_large());
			pstmt.setBytes (6, aProductVO.getProduct_picture_small());
			pstmt.setInt (7, aProductVO.getProduct_status());
			pstmt.setDate (8, aProductVO.getProduct_create_date());
			pstmt.setString (9, aProductVO.getProduct_info());
			pstmt.setInt (10, aProductVO.getProduct_kind_no());
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
	public void delete(String  aProduct){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ProductDAO.DELETE);
			pstmt.setString (1,aProduct);
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
	public ProductVO findByPrimaryKey(String  aProduct){
		ProductVO productVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ProductDAO.GET_ONE_STMT);
			pstmt.setString (1,aProduct);
			pstmt.executeUpdate();
			while (rs.next()) {
				productVO = new ProductVO();
				productVO.setProduct_no(rs.getString("product_no"));
				productVO.setProduct_name(rs.getString("product_name"));
				productVO.setProduct_introduction(rs.getString("product_introduction"));
				productVO.setProduct_price(rs.getInt("product_price"));
				productVO.setProduct_stock(rs.getInt("product_stock"));
				productVO.setProduct_picture_large(rs.getBytes("product_picture_large"));
				productVO.setProduct_picture_small(rs.getBytes("product_picture_small"));
				productVO.setProduct_status(rs.getInt("product_status"));
				productVO.setProduct_create_date(rs.getDate("product_create_date"));
				productVO.setProduct_info(rs.getString("product_info"));
				productVO.setProduct_kind_no(rs.getInt("product_kind_no"));
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
		return productVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<ProductVO> getAll(){ 
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;
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