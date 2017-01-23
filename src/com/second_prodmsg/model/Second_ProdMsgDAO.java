package com.second_prodmsg.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:二手商品留言<br>
 *	英文:second_ProdMsg<br>
 */ 
public class Second_ProdMsgDAO implements Second_ProdMsgDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (second_ProdMsg_Id,second_Prod_Id,mem_Id,second_ProdMsg_Msg,second_ProdMsg_DATE,second_ProdMsg_adp_upDate ) VALUES  ( second_ProdMsg_seq1.nextval , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE second_ProdMsg SET second_ProdMsg_Msg=?,second_ProdMsg_DATE=? ,second_ProdMsg_adp_upDate=?  WHERE second_ProdMsg_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM second_ProdMsg WHERE second_ProdMsg_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT second_ProdMsg_Id,second_Prod_Id,mem_Id,second_ProdMsg_Msg,to_char(second_ProdMsg_DATE,'yyyy-mm-dd') second_ProdMsg_DATE,to_char(second_ProdMsg_adp_upDate,'yyyy-mm-dd') second_ProdMsg_adp_upDate WHERE second_ProdMsg_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT second_ProdMsg_Id,second_Prod_Id,mem_Id,second_ProdMsg_Msg,to_char(second_ProdMsg_DATE,'yyyy-mm-dd') second_ProdMsg_DATE,to_char(second_ProdMsg_adp_upDate,'yyyy-mm-dd') second_ProdMsg_adp_upDate WHERE second_ProdMsg_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_SECOND_PRODMSG_MSG =" UPDATE second_ProdMsg set SECOND_PRODMSG_MSG=?  WHERE second_ProdMsg_Id=? " ; 
	private static final String UPDATE_SECOND_PRODMSG_DATE =" UPDATE second_ProdMsg set SECOND_PRODMSG_DATE=?  WHERE second_ProdMsg_Id=? " ; 
	private static final String UPDATE_SECOND_PRODMSG_ADP_UPDATE =" UPDATE second_ProdMsg set SECOND_PRODMSG_ADP_UPDATE=?  WHERE second_ProdMsg_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Second_ProdMsgVO aSecond_ProdMsgVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdMsgDAO.INSERT_STMT);
			pstmt.setString (1, aSecond_ProdMsgVO.getSecond_Prod_Id());
			pstmt.setString (2, aSecond_ProdMsgVO.getMem_Id());
			pstmt.setString (3, aSecond_ProdMsgVO.getSecond_ProdMsg_Msg());
			pstmt.setDate (4, aSecond_ProdMsgVO.getSecond_ProdMsg_DATE());
			pstmt.setDate (5, aSecond_ProdMsgVO.getSecond_ProdMsg_adp_upDate());
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
	public void update(Second_ProdMsgVO aSecond_ProdMsgVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdMsgDAO.UPDATE);
			pstmt.setString (1, aSecond_ProdMsgVO.getSecond_ProdMsg_Msg());
			pstmt.setDate (2, aSecond_ProdMsgVO.getSecond_ProdMsg_DATE());
			pstmt.setDate (3, aSecond_ProdMsgVO.getSecond_ProdMsg_adp_upDate());
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
	public void delete(String  aSecond_ProdMsg){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdMsgDAO.DELETE);
			pstmt.setString (1,aSecond_ProdMsg);
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
	public Second_ProdMsgVO findByPrimaryKey(String  aSecond_ProdMsg){
	Second_ProdMsgVO second_prodmsgVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdMsgDAO.DELETE);
			pstmt.setString (1,aSecond_ProdMsg);
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
		return second_prodmsgVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Second_ProdMsgVO> getAll(){ 
		List<Second_ProdMsgVO> list = new ArrayList<Second_ProdMsgVO>();
		Second_ProdMsgVO second_prodmsgVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdMsgDAO.DELETE);
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