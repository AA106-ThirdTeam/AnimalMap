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
public class Second_ProdMsgJDBCDAO implements Second_ProdMsgDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott";
	String passwd = "tiger";
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO second_ProdMsg (second_ProdMsg_Id,second_Prod_Id,mem_Id,second_ProdMsg_Msg,second_ProdMsg_DATE,second_ProdMsg_adp_upDate ) VALUES  ( second_ProdMsg_seq1.nextval , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE second_ProdMsg SET second_ProdMsg_Msg=?,second_ProdMsg_DATE=? ,second_ProdMsg_adp_upDate=?  WHERE second_ProdMsg_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM second_ProdMsg WHERE second_ProdMsg_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT second_ProdMsg_Id,second_Prod_Id,mem_Id,second_ProdMsg_Msg,to_char(second_ProdMsg_DATE,'yyyy-mm-dd') second_ProdMsg_DATE,to_char(second_ProdMsg_adp_upDate,'yyyy-mm-dd') second_ProdMsg_adp_upDate WHERE second_ProdMsg_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT second_ProdMsg_Id,second_Prod_Id,mem_Id,second_ProdMsg_Msg,to_char(second_ProdMsg_DATE,'yyyy-mm-dd') second_ProdMsg_DATE,to_char(second_ProdMsg_adp_upDate,'yyyy-mm-dd') second_ProdMsg_adp_upDate WHERE second_ProdMsg_Id=? " ; 
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
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdMsgDAO.GET_ONE_STMT);
			pstmt.setString (1,aSecond_ProdMsg);
			pstmt.executeUpdate();
			while (rs.next()) {
				second_prodmsgVO = new Second_ProdMsgVO();
				second_prodmsgVO.setSecond_ProdMsg_Id(rs.getString("second_ProdMsg_Id"));
				second_prodmsgVO.setSecond_Prod_Id(rs.getString("second_Prod_Id"));
				second_prodmsgVO.setMem_Id(rs.getString("mem_Id"));
				second_prodmsgVO.setSecond_ProdMsg_Msg(rs.getString("second_ProdMsg_Msg"));
				second_prodmsgVO.setSecond_ProdMsg_DATE(rs.getDate("second_ProdMsg_DATE"));
				second_prodmsgVO.setSecond_ProdMsg_adp_upDate(rs.getDate("second_ProdMsg_adp_upDate"));
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
		return second_prodmsgVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Second_ProdMsgVO> getAll(){ 
		List<Second_ProdMsgVO> list = new ArrayList<Second_ProdMsgVO>();
		Second_ProdMsgVO second_prodmsgVO = null;
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