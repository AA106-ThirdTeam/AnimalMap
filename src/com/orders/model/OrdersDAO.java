package com.orders.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:訂單<br>
 *	英文:orders<br>
 */ 
public class OrdersDAO implements OrdersDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (orders_no,mem_Id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,orders_date,orders_ship_date,orders_total,orders_status,orders_credit ) VALUES  ( orders_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE orders SET orders_receiver=?,post_no=? ,post_adp_city=? ,post_town=? ,post_road=? ,orders_phone=? ,collect_mode_no=? ,orders_date=? ,orders_ship_date=? ,orders_total=? ,orders_status=? ,orders_credit=?  WHERE orders_no=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM orders WHERE orders_no=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT orders_no,mem_Id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,to_char(orders_date,'yyyy-mm-dd') orders_date,to_char(orders_ship_date,'yyyy-mm-dd') orders_ship_date,orders_total,orders_status,orders_credit WHERE orders_no=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT orders_no,mem_Id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,to_char(orders_date,'yyyy-mm-dd') orders_date,to_char(orders_ship_date,'yyyy-mm-dd') orders_ship_date,orders_total,orders_status,orders_credit WHERE orders_no=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_ORDERS_RECEIVER =" UPDATE orders set ORDERS_RECEIVER=?  WHERE orders_no=? " ; 
	private static final String UPDATE_POST_NO =" UPDATE orders set POST_NO=?  WHERE orders_no=? " ; 
	private static final String UPDATE_POST_ADP_CITY =" UPDATE orders set POST_ADP_CITY=?  WHERE orders_no=? " ; 
	private static final String UPDATE_POST_TOWN =" UPDATE orders set POST_TOWN=?  WHERE orders_no=? " ; 
	private static final String UPDATE_POST_ROAD =" UPDATE orders set POST_ROAD=?  WHERE orders_no=? " ; 
	private static final String UPDATE_ORDERS_PHONE =" UPDATE orders set ORDERS_PHONE=?  WHERE orders_no=? " ; 
	private static final String UPDATE_COLLECT_MODE_NO =" UPDATE orders set COLLECT_MODE_NO=?  WHERE orders_no=? " ; 
	private static final String UPDATE_ORDERS_DATE =" UPDATE orders set ORDERS_DATE=?  WHERE orders_no=? " ; 
	private static final String UPDATE_ORDERS_SHIP_DATE =" UPDATE orders set ORDERS_SHIP_DATE=?  WHERE orders_no=? " ; 
	private static final String UPDATE_ORDERS_TOTAL =" UPDATE orders set ORDERS_TOTAL=?  WHERE orders_no=? " ; 
	private static final String UPDATE_ORDERS_STATUS =" UPDATE orders set ORDERS_STATUS=?  WHERE orders_no=? " ; 
	private static final String UPDATE_ORDERS_CREDIT =" UPDATE orders set ORDERS_CREDIT=?  WHERE orders_no=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(OrdersVO aOrdersVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(OrdersDAO.INSERT_STMT);
			pstmt.setString (1, aOrdersVO.getMem_Id());
			pstmt.setString (2, aOrdersVO.getOrders_receiver());
			pstmt.setString (3, aOrdersVO.getPost_no());
			pstmt.setString (4, aOrdersVO.getPost_adp_city());
			pstmt.setString (5, aOrdersVO.getPost_town());
			pstmt.setString (6, aOrdersVO.getPost_road());
			pstmt.setInt (7, aOrdersVO.getOrders_phone());
			pstmt.setInt (8, aOrdersVO.getCollect_mode_no());
			pstmt.setDate (9, aOrdersVO.getOrders_date());
			pstmt.setDate (10, aOrdersVO.getOrders_ship_date());
			pstmt.setInt (11, aOrdersVO.getOrders_total());
			pstmt.setInt (12, aOrdersVO.getOrders_status());
			pstmt.setInt (13, aOrdersVO.getOrders_credit());
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
	public void update(OrdersVO aOrdersVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(OrdersDAO.UPDATE);
			pstmt.setString (1, aOrdersVO.getOrders_receiver());
			pstmt.setString (2, aOrdersVO.getPost_no());
			pstmt.setString (3, aOrdersVO.getPost_adp_city());
			pstmt.setString (4, aOrdersVO.getPost_town());
			pstmt.setString (5, aOrdersVO.getPost_road());
			pstmt.setInt (6, aOrdersVO.getOrders_phone());
			pstmt.setInt (7, aOrdersVO.getCollect_mode_no());
			pstmt.setDate (8, aOrdersVO.getOrders_date());
			pstmt.setDate (9, aOrdersVO.getOrders_ship_date());
			pstmt.setInt (10, aOrdersVO.getOrders_total());
			pstmt.setInt (11, aOrdersVO.getOrders_status());
			pstmt.setInt (12, aOrdersVO.getOrders_credit());
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
	public void delete(String  aOrders){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(OrdersDAO.DELETE);
			pstmt.setString (1,aOrders);
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
	public OrdersVO findByPrimaryKey(String  aOrders){
	OrdersVO ordersVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(OrdersDAO.DELETE);
			pstmt.setString (1,aOrders);
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
		return ordersVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<OrdersVO> getAll(){ 
		List<OrdersVO> list = new ArrayList<OrdersVO>();
		OrdersVO ordersVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(OrdersDAO.DELETE);
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