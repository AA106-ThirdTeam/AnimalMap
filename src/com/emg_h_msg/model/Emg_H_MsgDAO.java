package com.emg_h_msg.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:緊急求救留言<br>
 *	英文:emg_H_Msg<br>
 */ 
public class Emg_H_MsgDAO implements Emg_H_MsgDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (emg_H_Msg_Id,mem_Id,emg_H_Id,emg_H_Msg_start,emg_H_Msg_content ) VALUES  ( emg_H_Msg_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE emg_H_Msg SET emg_H_Msg_start=?,emg_H_Msg_content=?  WHERE emg_H_Msg_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM emg_H_Msg WHERE emg_H_Msg_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT emg_H_Msg_Id,mem_Id,emg_H_Id,to_char(emg_H_Msg_start,'yyyy-mm-dd') emg_H_Msg_start,emg_H_Msg_content WHERE emg_H_Msg_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT emg_H_Msg_Id,mem_Id,emg_H_Id,to_char(emg_H_Msg_start,'yyyy-mm-dd') emg_H_Msg_start,emg_H_Msg_content WHERE emg_H_Msg_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_EMG_H_MSG_START =" UPDATE emg_H_Msg set EMG_H_MSG_START=?  WHERE emg_H_Msg_Id=? " ; 
	private static final String UPDATE_EMG_H_MSG_CONTENT =" UPDATE emg_H_Msg set EMG_H_MSG_CONTENT=?  WHERE emg_H_Msg_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Emg_H_MsgVO aEmg_H_MsgVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emg_H_MsgDAO.INSERT_STMT);
			pstmt.setString (1, aEmg_H_MsgVO.getMem_Id());
			pstmt.setString (2, aEmg_H_MsgVO.getEmg_H_Id());
			pstmt.setDate (3, aEmg_H_MsgVO.getEmg_H_Msg_start());
			pstmt.setString (4, aEmg_H_MsgVO.getEmg_H_Msg_content());
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
	public void update(Emg_H_MsgVO aEmg_H_MsgVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emg_H_MsgDAO.UPDATE);
			pstmt.setDate (1, aEmg_H_MsgVO.getEmg_H_Msg_start());
			pstmt.setString (2, aEmg_H_MsgVO.getEmg_H_Msg_content());
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
	public void delete(String  aEmg_H_Msg){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emg_H_MsgDAO.DELETE);
			pstmt.setString (1,aEmg_H_Msg);
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
	public Emg_H_MsgVO findByPrimaryKey(String  aEmg_H_Msg){
	Emg_H_MsgVO emg_h_msgVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emg_H_MsgDAO.DELETE);
			pstmt.setString (1,aEmg_H_Msg);
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
		return emg_h_msgVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Emg_H_MsgVO> getAll(){ 
		List<Emg_H_MsgVO> list = new ArrayList<Emg_H_MsgVO>();
		Emg_H_MsgVO emg_h_msgVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emg_H_MsgDAO.DELETE);
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