package com.adopt_ani_message.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:送養動物留言<br>
 *	英文:adopt_Ani_message<br>
 */ 
public class Adopt_Ani_messageDAO implements Adopt_Ani_messageDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes,ado_Ani_Mes_time ) VALUES  ( adopt_Ani_message_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE adopt_Ani_message SET ado_Ani_Mes=?,ado_Ani_Mes_time=?  WHERE ado_Ani_Mes_No=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM adopt_Ani_message WHERE ado_Ani_Mes_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes,to_char(ado_Ani_Mes_time,'yyyy-mm-dd') ado_Ani_Mes_time WHERE ado_Ani_Mes_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes,to_char(ado_Ani_Mes_time,'yyyy-mm-dd') ado_Ani_Mes_time WHERE ado_Ani_Mes_No=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_ADO_ANI_MES =" UPDATE adopt_Ani_message set ADO_ANI_MES=?  WHERE ado_Ani_Mes_No=? " ; 
	private static final String UPDATE_ADO_ANI_MES_TIME =" UPDATE adopt_Ani_message set ADO_ANI_MES_TIME=?  WHERE ado_Ani_Mes_No=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Adopt_Ani_messageVO aAdopt_Ani_messageVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_messageDAO.INSERT_STMT);
			pstmt.setString (1, aAdopt_Ani_messageVO.getAdopt_Ani_Id());
			pstmt.setString (2, aAdopt_Ani_messageVO.getMem_Id());
			pstmt.setString (3, aAdopt_Ani_messageVO.getAdo_Ani_Mes());
			pstmt.setDate (4, aAdopt_Ani_messageVO.getAdo_Ani_Mes_time());
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
	public void update(Adopt_Ani_messageVO aAdopt_Ani_messageVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_messageDAO.UPDATE);
			pstmt.setString (1, aAdopt_Ani_messageVO.getAdo_Ani_Mes());
			pstmt.setDate (2, aAdopt_Ani_messageVO.getAdo_Ani_Mes_time());
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
	public void delete(String  aAdopt_Ani_message){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_messageDAO.DELETE);
			pstmt.setString (1,aAdopt_Ani_message);
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
	public Adopt_Ani_messageVO findByPrimaryKey(String  aAdopt_Ani_message){
		Adopt_Ani_messageVO adopt_ani_messageVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_messageDAO.GET_ONE_STMT);
			pstmt.setString (1,aAdopt_Ani_message);
			pstmt.executeUpdate();
			while (rs.next()) {
				adopt_ani_messageVO = new Adopt_Ani_messageVO();
				adopt_ani_messageVO.setAdo_Ani_Mes_No(rs.getString("ado_Ani_Mes_No"));
				adopt_ani_messageVO.setAdopt_Ani_Id(rs.getString("adopt_Ani_Id"));
				adopt_ani_messageVO.setMem_Id(rs.getString("mem_Id"));
				adopt_ani_messageVO.setAdo_Ani_Mes(rs.getString("ado_Ani_Mes"));
				adopt_ani_messageVO.setAdo_Ani_Mes_time(rs.getDate("ado_Ani_Mes_time"));
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
		return adopt_ani_messageVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Adopt_Ani_messageVO> getAll(){ 
		List<Adopt_Ani_messageVO> list = new ArrayList<Adopt_Ani_messageVO>();
		Adopt_Ani_messageVO adopt_ani_messageVO = null;
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