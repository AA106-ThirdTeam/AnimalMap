package com.res_ponse.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:討論區留言 <br>
 *	英文:res_ponse<br>
 */ 
public class Res_ponseDAO implements Res_ponseDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (res_Id,mem_Id,post_Id,res_ponse_content,post_time,res_ponse_upDate ) VALUES  ( res_ponse_seq1.nextval , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE res_ponse SET res_ponse_content=?,post_time=? ,res_ponse_upDate=?  WHERE res_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM res_ponse WHERE res_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT res_Id,mem_Id,post_Id,res_ponse_content,to_char(post_time,'yyyy-mm-dd') post_time,to_char(res_ponse_upDate,'yyyy-mm-dd') res_ponse_upDate WHERE res_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT res_Id,mem_Id,post_Id,res_ponse_content,to_char(post_time,'yyyy-mm-dd') post_time,to_char(res_ponse_upDate,'yyyy-mm-dd') res_ponse_upDate WHERE res_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_RES_PONSE_CONTENT =" UPDATE res_ponse set RES_PONSE_CONTENT=?  WHERE res_Id=? " ; 
	private static final String UPDATE_POST_TIME =" UPDATE res_ponse set POST_TIME=?  WHERE res_Id=? " ; 
	private static final String UPDATE_RES_PONSE_UPDATE =" UPDATE res_ponse set RES_PONSE_UPDATE=?  WHERE res_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Res_ponseVO aRes_ponseVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Res_ponseDAO.INSERT_STMT);
			pstmt.setString (1, aRes_ponseVO.getMem_Id());
			pstmt.setString (2, aRes_ponseVO.getPost_Id());
			pstmt.setString (3, aRes_ponseVO.getRes_ponse_content());
			pstmt.setDate (4, aRes_ponseVO.getPost_time());
			pstmt.setDate (5, aRes_ponseVO.getRes_ponse_upDate());
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
	public void update(Res_ponseVO aRes_ponseVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Res_ponseDAO.UPDATE);
			pstmt.setString (1, aRes_ponseVO.getRes_ponse_content());
			pstmt.setDate (2, aRes_ponseVO.getPost_time());
			pstmt.setDate (3, aRes_ponseVO.getRes_ponse_upDate());
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
	public void delete(String  aRes_ponse){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Res_ponseDAO.DELETE);
			pstmt.setString (1,aRes_ponse);
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
	public Res_ponseVO findByPrimaryKey(String  aRes_ponse){
	Res_ponseVO res_ponseVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Res_ponseDAO.DELETE);
			pstmt.setString (1,aRes_ponse);
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
		return res_ponseVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Res_ponseVO> getAll(){ 
		List<Res_ponseVO> list = new ArrayList<Res_ponseVO>();
		Res_ponseVO res_ponseVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Res_ponseDAO.DELETE);
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