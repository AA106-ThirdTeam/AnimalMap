package com.priv_message.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:私人訊息<br>
 *	英文:priv_message<br>
 */ 
public class Priv_messageJDBCDAO implements Priv_messageDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott";
	String passwd = "tiger";
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO priv_message (privMes_Id,privMesSend_MemId,privMesRec_MemId,privMes_content,privMes_SendTime,privMes_type ) VALUES  ( priv_message_seq1.nextval , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE priv_message SET privMes_content=?,privMes_SendTime=? ,privMes_type=?  WHERE privMes_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM priv_message WHERE privMes_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT privMes_Id,privMesSend_MemId,privMesRec_MemId,privMes_content,to_char(privMes_SendTime,'yyyy-mm-dd') privMes_SendTime,privMes_type WHERE privMes_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT privMes_Id,privMesSend_MemId,privMesRec_MemId,privMes_content,to_char(privMes_SendTime,'yyyy-mm-dd') privMes_SendTime,privMes_type WHERE privMes_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Priv_messageVO aPriv_messageVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Priv_messageDAO.INSERT_STMT);
			pstmt.setString (1, aPriv_messageVO.getPrivMesSend_MemId());
			pstmt.setString (2, aPriv_messageVO.getPrivMesRec_MemId());
			pstmt.setString (3, aPriv_messageVO.getPrivMes_content());
			pstmt.setDate (4, aPriv_messageVO.getPrivMes_SendTime());
			pstmt.setString (5, aPriv_messageVO.getPrivMes_type());
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
	public void update(Priv_messageVO aPriv_messageVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Priv_messageDAO.UPDATE);
			pstmt.setString (1, aPriv_messageVO.getPrivMes_content());
			pstmt.setDate (2, aPriv_messageVO.getPrivMes_SendTime());
			pstmt.setString (3, aPriv_messageVO.getPrivMes_type());
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
	public void delete(String  aPriv_message){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Priv_messageDAO.DELETE);
			pstmt.setString (1,aPriv_message);
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
	public Priv_messageVO findByPrimaryKey(String  aPriv_message){
		Priv_messageVO priv_messageVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Priv_messageDAO.GET_ONE_STMT);
			pstmt.setString (1,aPriv_message);
			pstmt.executeUpdate();
			while (rs.next()) {
				priv_messageVO = new Priv_messageVO();
				priv_messageVO.setPrivMes_Id(rs.getString("privMes_Id"));
				priv_messageVO.setPrivMesSend_MemId(rs.getString("privMesSend_MemId"));
				priv_messageVO.setPrivMesRec_MemId(rs.getString("privMesRec_MemId"));
				priv_messageVO.setPrivMes_content(rs.getString("privMes_content"));
				priv_messageVO.setPrivMes_SendTime(rs.getDate("privMes_SendTime"));
				priv_messageVO.setPrivMes_type(rs.getString("privMes_type"));
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
		return priv_messageVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Priv_messageVO> getAll(){ 
		List<Priv_messageVO> list = new ArrayList<Priv_messageVO>();
		Priv_messageVO priv_messageVO = null;
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