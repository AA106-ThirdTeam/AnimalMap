package com.orders_item.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:訂單明細<br>
 *	英文:orders_item<br>
 */ 
public class Orders_itemJDBCDAO implements Orders_itemDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott";
	String passwd = "tiger";
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO orders_item (orders_no,product_no,commodities_amout,selling_price ) VALUES  ( ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE orders_item SET commodities_amout=?,selling_price=?  WHERE =? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM orders_item WHERE =? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT orders_no,product_no,commodities_amout,selling_price WHERE =? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT orders_no,product_no,commodities_amout,selling_price WHERE =? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Orders_itemVO aOrders_itemVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Orders_itemDAO.INSERT_STMT);
			pstmt.setInt (2, aOrders_itemVO.getCommodities_amout());
			pstmt.setInt (3, aOrders_itemVO.getSelling_price());
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
	public void update(Orders_itemVO aOrders_itemVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Orders_itemDAO.UPDATE);
			pstmt.setInt (1, aOrders_itemVO.getCommodities_amout());
			pstmt.setInt (2, aOrders_itemVO.getSelling_price());
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
	public void delete(String  aOrders_item){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Orders_itemDAO.DELETE);
			pstmt.setString (1,aOrders_item);
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
	public Orders_itemVO findByPrimaryKey(String  aOrders_item){
		Orders_itemVO orders_itemVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Orders_itemDAO.GET_ONE_STMT);
			pstmt.setString (1,aOrders_item);
			pstmt.executeUpdate();
			while (rs.next()) {
				orders_itemVO = new Orders_itemVO();
				orders_itemVO.setOrders_no(rs.getString("orders_no"));
				orders_itemVO.setProduct_no(rs.getString("product_no"));
				orders_itemVO.setCommodities_amout(rs.getInt("commodities_amout"));
				orders_itemVO.setSelling_price(rs.getInt("selling_price"));
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
		return orders_itemVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Orders_itemVO> getAll(){ 
		List<Orders_itemVO> list = new ArrayList<Orders_itemVO>();
		Orders_itemVO orders_itemVO = null;
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