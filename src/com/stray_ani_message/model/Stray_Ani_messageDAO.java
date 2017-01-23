package com.stray_ani_message.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:社區流浪動物留言<br>
 *	英文:stray_Ani_message<br>
 */ 
public class Stray_Ani_messageDAO implements Stray_Ani_messageDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (str_Ani_Mes_No,stray_Ani_Id,mem_Id,str_Ani_Mes_time,str_Ani_Mes ) VALUES  ( stray_Ani_message_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE stray_Ani_message SET str_Ani_Mes_time=?,str_Ani_Mes=?  WHERE str_Ani_Mes_No=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM stray_Ani_message WHERE str_Ani_Mes_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT str_Ani_Mes_No,stray_Ani_Id,mem_Id,to_char(str_Ani_Mes_time,'yyyy-mm-dd') str_Ani_Mes_time,str_Ani_Mes WHERE str_Ani_Mes_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT str_Ani_Mes_No,stray_Ani_Id,mem_Id,to_char(str_Ani_Mes_time,'yyyy-mm-dd') str_Ani_Mes_time,str_Ani_Mes WHERE str_Ani_Mes_No=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_STR_ANI_MES_TIME =" UPDATE stray_Ani_message set STR_ANI_MES_TIME=?  WHERE str_Ani_Mes_No=? " ; 
	private static final String UPDATE_STR_ANI_MES =" UPDATE stray_Ani_message set STR_ANI_MES=?  WHERE str_Ani_Mes_No=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Stray_Ani_messageVO aStray_Ani_messageVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_messageDAO.INSERT_STMT);
			pstmt.setString (1, aStray_Ani_messageVO.getStray_Ani_Id());
			pstmt.setString (2, aStray_Ani_messageVO.getMem_Id());
			pstmt.setDate (3, aStray_Ani_messageVO.getStr_Ani_Mes_time());
			pstmt.setString (4, aStray_Ani_messageVO.getStr_Ani_Mes());
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
	public void update(Stray_Ani_messageVO aStray_Ani_messageVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_messageDAO.UPDATE);
			pstmt.setDate (1, aStray_Ani_messageVO.getStr_Ani_Mes_time());
			pstmt.setString (2, aStray_Ani_messageVO.getStr_Ani_Mes());
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
	public void delete(String  aStray_Ani_message){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_messageDAO.DELETE);
			pstmt.setString (1,aStray_Ani_message);
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
	public Stray_Ani_messageVO findByPrimaryKey(String  aStray_Ani_message){
	Stray_Ani_messageVO stray_ani_messageVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_messageDAO.DELETE);
			pstmt.setString (1,aStray_Ani_message);
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
		return stray_ani_messageVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Stray_Ani_messageVO> getAll(){ 
		List<Stray_Ani_messageVO> list = new ArrayList<Stray_Ani_messageVO>();
		Stray_Ani_messageVO stray_ani_messageVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_messageDAO.DELETE);
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