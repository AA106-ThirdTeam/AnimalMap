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
public class Emg_H_MsgJDBCDAO implements Emg_H_MsgDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott";
	String passwd = "tiger";
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO emg_H_Msg (emg_H_Msg_Id,mem_Id,emg_H_Id,emg_H_Msg_start,emg_H_Msg_content ) VALUES  ( emg_H_Msg_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE emg_H_Msg SET emg_H_Msg_start=?,emg_H_Msg_content=?  WHERE emg_H_Msg_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM emg_H_Msg WHERE emg_H_Msg_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT emg_H_Msg_Id,mem_Id,emg_H_Id,to_char(emg_H_Msg_start,'yyyy-mm-dd') emg_H_Msg_start,emg_H_Msg_content WHERE emg_H_Msg_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT emg_H_Msg_Id,mem_Id,emg_H_Id,to_char(emg_H_Msg_start,'yyyy-mm-dd') emg_H_Msg_start,emg_H_Msg_content WHERE emg_H_Msg_Id=? " ; 
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
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emg_H_MsgDAO.GET_ONE_STMT);
			pstmt.setString (1,aEmg_H_Msg);
			pstmt.executeUpdate();
			while (rs.next()) {
				emg_h_msgVO = new Emg_H_MsgVO();
				emg_h_msgVO.setEmg_H_Msg_Id(rs.getString("emg_H_Msg_Id"));
				emg_h_msgVO.setMem_Id(rs.getString("mem_Id"));
				emg_h_msgVO.setEmg_H_Id(rs.getString("emg_H_Id"));
				emg_h_msgVO.setEmg_H_Msg_start(rs.getDate("emg_H_Msg_start"));
				emg_h_msgVO.setEmg_H_Msg_content(rs.getString("emg_H_Msg_content"));
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
		return emg_h_msgVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Emg_H_MsgVO> getAll(){ 
		List<Emg_H_MsgVO> list = new ArrayList<Emg_H_MsgVO>();
		Emg_H_MsgVO emg_h_msgVO = null;
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