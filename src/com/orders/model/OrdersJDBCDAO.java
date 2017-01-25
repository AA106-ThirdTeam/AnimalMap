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
public class OrdersJDBCDAO implements OrdersDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott";
	String passwd = "tiger";
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO orders (orders_no,mem_Id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,orders_date,orders_ship_date,orders_total,orders_status,orders_credit ) VALUES  ( orders_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE orders SET orders_receiver=?,post_no=? ,post_adp_city=? ,post_town=? ,post_road=? ,orders_phone=? ,collect_mode_no=? ,orders_date=? ,orders_ship_date=? ,orders_total=? ,orders_status=? ,orders_credit=?  WHERE orders_no=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM orders WHERE orders_no=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT orders_no,mem_Id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,to_char(orders_date,'yyyy-mm-dd') orders_date,to_char(orders_ship_date,'yyyy-mm-dd') orders_ship_date,orders_total,orders_status,orders_credit WHERE orders_no=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT orders_no,mem_Id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,to_char(orders_date,'yyyy-mm-dd') orders_date,to_char(orders_ship_date,'yyyy-mm-dd') orders_ship_date,orders_total,orders_status,orders_credit WHERE orders_no=? " ; 
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
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(OrdersDAO.GET_ONE_STMT);
			pstmt.setString (1,aOrders);
			pstmt.executeUpdate();
			while (rs.next()) {
				ordersVO = new OrdersVO();
				ordersVO.setOrders_no(rs.getString("orders_no"));
				ordersVO.setMem_Id(rs.getString("mem_Id"));
				ordersVO.setOrders_receiver(rs.getString("orders_receiver"));
				ordersVO.setPost_no(rs.getString("post_no"));
				ordersVO.setPost_adp_city(rs.getString("post_adp_city"));
				ordersVO.setPost_town(rs.getString("post_town"));
				ordersVO.setPost_road(rs.getString("post_road"));
				ordersVO.setOrders_phone(rs.getInt("orders_phone"));
				ordersVO.setCollect_mode_no(rs.getInt("collect_mode_no"));
				ordersVO.setOrders_date(rs.getDate("orders_date"));
				ordersVO.setOrders_ship_date(rs.getDate("orders_ship_date"));
				ordersVO.setOrders_total(rs.getInt("orders_total"));
				ordersVO.setOrders_status(rs.getInt("orders_status"));
				ordersVO.setOrders_credit(rs.getInt("orders_credit"));
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
		return ordersVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<OrdersVO> getAll(){ 
		List<OrdersVO> list = new ArrayList<OrdersVO>();
		OrdersVO ordersVO = null;
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