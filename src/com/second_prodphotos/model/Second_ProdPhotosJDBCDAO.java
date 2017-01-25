package com.second_prodphotos.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:二手商品相簿<br>
 *	英文:second_ProdPhotos<br>
 */ 
public class Second_ProdPhotosJDBCDAO implements Second_ProdPhotosDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott";
	String passwd = "tiger";
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO second_ProdPhotos (second_ProdPhotos_Id,second_Prod_Id ) VALUES  ( second_ProdPhotos_seq1.nextval , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE second_ProdPhotos SET  WHERE second_ProdPhotos_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM second_ProdPhotos WHERE second_ProdPhotos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT second_ProdPhotos_Id,second_Prod_Id WHERE second_ProdPhotos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT second_ProdPhotos_Id,second_Prod_Id WHERE second_ProdPhotos_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Second_ProdPhotosVO aSecond_ProdPhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdPhotosDAO.INSERT_STMT);
			pstmt.setString (1, aSecond_ProdPhotosVO.getSecond_Prod_Id());
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
	public void update(Second_ProdPhotosVO aSecond_ProdPhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdPhotosDAO.UPDATE);
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
	public void delete(String  aSecond_ProdPhotos){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdPhotosDAO.DELETE);
			pstmt.setString (1,aSecond_ProdPhotos);
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
	public Second_ProdPhotosVO findByPrimaryKey(String  aSecond_ProdPhotos){
		Second_ProdPhotosVO second_prodphotosVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdPhotosDAO.GET_ONE_STMT);
			pstmt.setString (1,aSecond_ProdPhotos);
			pstmt.executeUpdate();
			while (rs.next()) {
				second_prodphotosVO = new Second_ProdPhotosVO();
				second_prodphotosVO.setSecond_ProdPhotos_Id(rs.getString("second_ProdPhotos_Id"));
				second_prodphotosVO.setSecond_Prod_Id(rs.getString("second_Prod_Id"));
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
		return second_prodphotosVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Second_ProdPhotosVO> getAll(){ 
		List<Second_ProdPhotosVO> list = new ArrayList<Second_ProdPhotosVO>();
		Second_ProdPhotosVO second_prodphotosVO = null;
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