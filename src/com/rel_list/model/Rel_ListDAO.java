package com.rel_list.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:關係名單<br>
 *	英文:rel_List<br>
 */ 
public class Rel_ListDAO implements Rel_ListDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (rel_MemId,added_MemId,isBlackList,isInvited ) VALUES  ( ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE rel_List SET isBlackList=?,isInvited=?  WHERE =? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM rel_List WHERE =? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT rel_MemId,added_MemId,isBlackList,isInvited WHERE =? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT rel_MemId,added_MemId,isBlackList,isInvited WHERE =? " ; 
	//====以下是新增指令====
	private static final String UPDATE_ISBLACKLIST =" UPDATE rel_List set ISBLACKLIST=?  WHERE rel_MemId=? " ; 
	private static final String UPDATE_ISINVITED =" UPDATE rel_List set ISINVITED=?  WHERE rel_MemId=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Rel_ListVO aRel_ListVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Rel_ListDAO.INSERT_STMT);
			pstmt.setString (2, aRel_ListVO.getIsBlackList());
			pstmt.setString (3, aRel_ListVO.getIsInvited());
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
	public void update(Rel_ListVO aRel_ListVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Rel_ListDAO.UPDATE);
			pstmt.setString (1, aRel_ListVO.getIsBlackList());
			pstmt.setString (2, aRel_ListVO.getIsInvited());
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
	public void delete(String  aRel_List){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Rel_ListDAO.DELETE);
			pstmt.setString (1,aRel_List);
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
	public Rel_ListVO findByPrimaryKey(String  aRel_List){
		Rel_ListVO rel_listVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Rel_ListDAO.GET_ONE_STMT);
			pstmt.setString (1,aRel_List);
			pstmt.executeUpdate();
			while (rs.next()) {
				rel_listVO = new Rel_ListVO();
				rel_listVO.setRel_MemId(rs.getString("rel_MemId"));
				rel_listVO.setAdded_MemId(rs.getString("added_MemId"));
				rel_listVO.setIsBlackList(rs.getString("isBlackList"));
				rel_listVO.setIsInvited(rs.getString("isInvited"));
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
		return rel_listVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Rel_ListVO> getAll(){ 
		List<Rel_ListVO> list = new ArrayList<Rel_ListVO>();
		Rel_ListVO rel_listVO = null;
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