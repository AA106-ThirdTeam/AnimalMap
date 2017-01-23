package com.grp_comment.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:揪團留言<br>
 *	英文:grp_comment<br>
 */ 
public class Grp_commentDAO implements Grp_commentDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (grpComment_Id,grpComment_MemId,grpComment_GrpId,grpComment_content,grpComment_SendTime ) VALUES  ( grp_comment_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE grp_comment SET grpComment_content=?,grpComment_SendTime=?  WHERE grpComment_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM grp_comment WHERE grpComment_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT grpComment_Id,grpComment_MemId,grpComment_GrpId,grpComment_content,to_char(grpComment_SendTime,'yyyy-mm-dd') grpComment_SendTime WHERE grpComment_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT grpComment_Id,grpComment_MemId,grpComment_GrpId,grpComment_content,to_char(grpComment_SendTime,'yyyy-mm-dd') grpComment_SendTime WHERE grpComment_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_GRPCOMMENT_CONTENT =" UPDATE grp_comment set GRPCOMMENT_CONTENT=?  WHERE grpComment_Id=? " ; 
	private static final String UPDATE_GRPCOMMENT_SENDTIME =" UPDATE grp_comment set GRPCOMMENT_SENDTIME=?  WHERE grpComment_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Grp_commentVO aGrp_commentVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Grp_commentDAO.INSERT_STMT);
			pstmt.setString (1, aGrp_commentVO.getGrpComment_MemId());
			pstmt.setString (2, aGrp_commentVO.getGrpComment_GrpId());
			pstmt.setString (3, aGrp_commentVO.getGrpComment_content());
			pstmt.setDate (4, aGrp_commentVO.getGrpComment_SendTime());
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
	public void update(Grp_commentVO aGrp_commentVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Grp_commentDAO.UPDATE);
			pstmt.setString (1, aGrp_commentVO.getGrpComment_content());
			pstmt.setDate (2, aGrp_commentVO.getGrpComment_SendTime());
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
	public void delete(String  aGrp_comment){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Grp_commentDAO.DELETE);
			pstmt.setString (1,aGrp_comment);
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
	public Grp_commentVO findByPrimaryKey(String  aGrp_comment){
	Grp_commentVO grp_commentVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Grp_commentDAO.DELETE);
			pstmt.setString (1,aGrp_comment);
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
		return grp_commentVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Grp_commentVO> getAll(){ 
		List<Grp_commentVO> list = new ArrayList<Grp_commentVO>();
		Grp_commentVO grp_commentVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Grp_commentDAO.DELETE);
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