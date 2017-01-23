package com.hos_comment.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:診所留言<br>
 *	英文:hos_comment<br>
 */ 
public class Hos_commentDAO implements Hos_commentDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (hosComm_Id,hosComm_MemId,hosComm_HosId,hosComm_content,hosComm_SendTime ) VALUES  ( hos_comment_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE hos_comment SET hosComm_content=?,hosComm_SendTime=?  WHERE hosComm_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM hos_comment WHERE hosComm_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT hosComm_Id,hosComm_MemId,hosComm_HosId,hosComm_content,to_char(hosComm_SendTime,'yyyy-mm-dd') hosComm_SendTime WHERE hosComm_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT hosComm_Id,hosComm_MemId,hosComm_HosId,hosComm_content,to_char(hosComm_SendTime,'yyyy-mm-dd') hosComm_SendTime WHERE hosComm_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_HOSCOMM_CONTENT =" UPDATE hos_comment set HOSCOMM_CONTENT=?  WHERE hosComm_Id=? " ; 
	private static final String UPDATE_HOSCOMM_SENDTIME =" UPDATE hos_comment set HOSCOMM_SENDTIME=?  WHERE hosComm_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Hos_commentVO aHos_commentVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Hos_commentDAO.INSERT_STMT);
			pstmt.setString (1, aHos_commentVO.getHosComm_MemId());
			pstmt.setString (2, aHos_commentVO.getHosComm_HosId());
			pstmt.setString (3, aHos_commentVO.getHosComm_content());
			pstmt.setDate (4, aHos_commentVO.getHosComm_SendTime());
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
	public void update(Hos_commentVO aHos_commentVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Hos_commentDAO.UPDATE);
			pstmt.setString (1, aHos_commentVO.getHosComm_content());
			pstmt.setDate (2, aHos_commentVO.getHosComm_SendTime());
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
	public void delete(String  aHos_comment){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Hos_commentDAO.DELETE);
			pstmt.setString (1,aHos_comment);
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
	public Hos_commentVO findByPrimaryKey(String  aHos_comment){
	Hos_commentVO hos_commentVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Hos_commentDAO.DELETE);
			pstmt.setString (1,aHos_comment);
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
		return hos_commentVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Hos_commentVO> getAll(){ 
		List<Hos_commentVO> list = new ArrayList<Hos_commentVO>();
		Hos_commentVO hos_commentVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Hos_commentDAO.DELETE);
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