package com.orders.model;

import java.sql.*;
import java.util.*;




import com.orders_item.model.Orders_itemJDBCDAO;
import com.orders_item.model.Orders_itemVO;
import com.orders_item.model.Orders_item_interface;

public class OrdersJDBCDAO implements OrdersDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
//	String url = "jdbc:oracle:thin:@grandli062902.ddns.net:1521:XE";
	String userid = "bertha";
	String passwd = "109910622";
	
	private static final String INSERT_STMT = 
			"INSERT INTO orders(orders_no,mem_id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,orders_date,orders_ship_date,orders_total,orders_status,orders_credit) VALUES (orders_seq1.NEXTVAL, ?, ? , ?, ? , ?, ? , ?, ? , ?, ? , ?, ?, ?)";
	private static final String UPDATE = 
			"UPDATE orders set mem_id=?,orders_receiver=?,post_no=?,post_adp_city=?,post_town=?,post_road=?,orders_phone=?,collect_mode_no=?,orders_date=?,orders_ship_date=?,orders_total=?,orders_status=?,orders_credit=? where orders_no=?";
	private static final String DELETE_Orders_items =
			"DELETE FROM orders_item where orders_no=?";
	private static final String DELETE_Orders = 
			"DELETE FROM��orders where orders_no = ?";
	private static final String GET_ALL_STMT = 
			"SELECT orders_no,mem_id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,orders_date,orders_ship_date,orders_total,orders_status,orders_credit FROM orders";
	private static final String GET_ONE_STMT = 
			"SELECT orders_no,mem_id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,orders_date,orders_ship_date,orders_total,orders_status,orders_credit FROM orders where orders_no=?";
	private static final String GET_Orders_items_ByOrders_no_STMT = 
			"SELECT orders_no,product_no,commodities_amount,selling_price FROM orders_item where orders_no = ? order by orders_no";
	
	@Override
	public void insert(OrdersVO ordersVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
//			pstmt.setString(1, ordersVO.getOrders_no());
			pstmt.setString(1, ordersVO.getMem_id());
			pstmt.setString(2, ordersVO.getOrders_receiver());
			pstmt.setString(3, ordersVO.getPost_no());
			pstmt.setString(4, ordersVO.getPost_adp_city());
			pstmt.setString(5, ordersVO.getPost_town());
			pstmt.setString(6, ordersVO.getPost_road());
			pstmt.setString(7, ordersVO.getOrders_phone());
			pstmt.setInt(8, ordersVO.getCollect_mode_no());
			pstmt.setDate(9, ordersVO.getOrders_date());
			pstmt.setDate(10, ordersVO.getOrders_ship_date());
			pstmt.setInt(11, ordersVO.getOrders_total());
			pstmt.setInt(12, ordersVO.getOrders_status());
			pstmt.setInt(13, ordersVO.getOrders_credit());

			pstmt.executeUpdate();
			
			
		}  catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	@Override
	public void update(OrdersVO ordersVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, ordersVO.getMem_id());
			pstmt.setString(2, ordersVO.getOrders_receiver());
			pstmt.setString(3, ordersVO.getPost_no());
			pstmt.setString(4, ordersVO.getPost_adp_city());
			pstmt.setString(5, ordersVO.getPost_town());
			pstmt.setString(6, ordersVO.getPost_road());
			pstmt.setString(7, ordersVO.getOrders_phone());
			pstmt.setInt(8, ordersVO.getCollect_mode_no());
			pstmt.setDate(9, ordersVO.getOrders_date());
			pstmt.setDate(10, ordersVO.getOrders_ship_date());
			pstmt.setInt(11, ordersVO.getOrders_total());
			pstmt.setInt(12, ordersVO.getOrders_status());
			pstmt.setInt(13, ordersVO.getOrders_credit());
			
			pstmt.executeUpdate();
			
		}   catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	@Override
	public void delete(String orders_no) {
		int updateCount_Order_items = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_Orders);
			
			// 1●設定於 pstm.executeUpdate()之前
			con.setAutoCommit(false);
			
			//先刪除明細
			pstmt = con.prepareStatement(DELETE_Orders_items);
			pstmt.setString(1, orders_no);
			updateCount_Order_items = pstmt.executeUpdate();
			
			//再刪除訂單
			pstmt = con.prepareStatement(DELETE_Orders);
			pstmt.setString(1, orders_no);
			pstmt.executeUpdate();
			
			// 2●設定於 pstm.executeUpdate()之後
			con.commit();
			con.setAutoCommit(true);
			System.out.println("��閮蝺刻��" + orders_no + "���,����敦" + updateCount_Order_items +"蝑��◤��");
			
			
		}  catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	@Override
	public OrdersVO findByPrimaryKey(String orders_no) {
		
		OrdersVO ordersVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setString(1, orders_no);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ordersVO = new OrdersVO();
				ordersVO.setMem_id(rs.getString("Mem_id"));
				ordersVO.setOrders_receiver(rs.getString("Orders_receiver"));
				ordersVO.setPost_no(rs.getString("post_no"));
				ordersVO.setPost_adp_city(rs.getString("post_adp_city"));
				ordersVO.setPost_town(rs.getString("post_town"));
				ordersVO.setPost_road(rs.getString("post_road"));
				ordersVO.setOrders_phone(rs.getString("orders_phone"));
				ordersVO.setCollect_mode_no(rs.getInt("collect_mode_no"));
				ordersVO.setOrders_date(rs.getDate("orders_date"));
				ordersVO.setOrders_ship_date(rs.getDate("orders_ship_date"));
				ordersVO.setOrders_total(rs.getInt("orders_total"));
				ordersVO.setOrders_status(rs.getInt("orders_status"));
				ordersVO.setOrders_credit(rs.getInt("orders_credit"));
				
			}
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	@Override
	public List<OrdersVO> getAll() {
		List<OrdersVO> list = new ArrayList<OrdersVO>();
		OrdersVO ordersVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			
			
			while (rs.next()) {
				ordersVO = new OrdersVO();
				ordersVO.setOrders_no(rs.getString("orders_no"));
				ordersVO.setMem_id(rs.getString("Mem_id"));
				ordersVO.setOrders_receiver(rs.getString("Orders_receiver"));
				ordersVO.setPost_no(rs.getString("post_no"));
				ordersVO.setPost_adp_city(rs.getString("post_adp_city"));
				ordersVO.setPost_town(rs.getString("post_town"));
				ordersVO.setPost_road(rs.getString("post_road"));
				ordersVO.setOrders_phone(rs.getString("orders_phone"));
				ordersVO.setCollect_mode_no(rs.getInt("collect_mode_no"));
				ordersVO.setOrders_date(rs.getDate("orders_date"));
				ordersVO.setOrders_ship_date(rs.getDate("orders_ship_date"));
				ordersVO.setOrders_total(rs.getInt("orders_total"));
				ordersVO.setOrders_status(rs.getInt("orders_status"));
				ordersVO.setOrders_credit(rs.getInt("orders_credit"));
				list.add(ordersVO);
			}
				
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		return list;

	}
	@Override
	public Set<Orders_itemVO> getOrders_itemByOrders_no(String orders_no) {
		Set<Orders_itemVO> set = new HashSet<Orders_itemVO>();
		Orders_itemVO orders_itemVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_Orders_items_ByOrders_no_STMT);
			
			pstmt.setString(1, orders_no);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				orders_itemVO = new Orders_itemVO();
				orders_itemVO.setOrders_no(rs.getString("orders_no"));
				orders_itemVO.setProduct_no(rs.getString("product_no"));
				orders_itemVO.setCommodities_amount(rs.getInt("commodities_amount"));
				orders_itemVO.setSelling_price(rs.getInt("selling_price"));
				set.add(orders_itemVO);
			}
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
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
		return set;

	}
	@Override
	public void insertWithOrders_item(OrdersVO ordersVO, List<Orders_itemVO> list) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			
    		con.setAutoCommit(false);
			//��憓�
    		String cols[] ={"ORDERS_NO"};
    		pstmt = con.prepareStatement(INSERT_STMT , cols);
    		pstmt.setString(1, ordersVO.getMem_id());
			pstmt.setString(2, ordersVO.getOrders_receiver());
			pstmt.setString(3, ordersVO.getPost_no());
			pstmt.setString(4, ordersVO.getPost_adp_city());
			pstmt.setString(5, ordersVO.getPost_town());
			pstmt.setString(6, ordersVO.getPost_road());
			pstmt.setString(7, ordersVO.getOrders_phone());
			pstmt.setInt(8, ordersVO.getCollect_mode_no());
			pstmt.setDate(9, ordersVO.getOrders_date());
			pstmt.setDate(10, ordersVO.getOrders_ship_date());
			pstmt.setInt(11, ordersVO.getOrders_total());
			pstmt.setInt(12, ordersVO.getOrders_status());
			pstmt.setInt(13, ordersVO.getOrders_credit());

			pstmt.executeUpdate();
			//掘取對應的自增主鍵值
			String next_orders_no = null;
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()){
				next_orders_no = rs.getString(1);
				System.out.println("自增主鍵值= " + next_orders_no +"(剛新增成功的部門編號)");
			} else {
				System.out.println("未取得自增主鍵值");
			}
			rs.close();
			
			//同時新增訂單明細
			Orders_itemJDBCDAO dao = new Orders_itemJDBCDAO();
			System.out.println("list.size()-A="+list.size());
			for (Orders_itemVO aOrders_item:list){
				aOrders_item.setOrders_no (next_orders_no);
				dao.insert2(aOrders_item,con);
			}
			con.commit();
			con.setAutoCommit(true);
			System.out.println("list.size()-B="+list.size());
			System.out.println("新增訂單編號" + next_orders_no + "時共有明細" + list.size()
			+ "筆同時被新增");
    		
    		
		}  catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					System.err.print("Transaction is being ");
					System.err.println("rolled back-�-dept");
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	
	public static void main(String[] args) {

		OrdersJDBCDAO dao = new OrdersJDBCDAO();
		
		
		OrdersVO ordersVO1 = new OrdersVO();
		ordersVO1.setMem_id("111");
		ordersVO1.setOrders_receiver("陳一");
		ordersVO1.setPost_no("320");
		ordersVO1.setPost_adp_city("桃園市");
		ordersVO1.setPost_town("中壢區");
		ordersVO1.setPost_road("中央路");
		ordersVO1.setOrders_phone("0912-345678");
		ordersVO1.setCollect_mode_no(1);
		ordersVO1.setOrders_date(java.sql.Date.valueOf("2005-01-01"));
		ordersVO1.setOrders_ship_date(java.sql.Date.valueOf("2005-01-01"));
		ordersVO1.setOrders_total(9999);
		ordersVO1.setOrders_status(1);
		ordersVO1.setOrders_credit(000000000);
//		dao.insert(ordersVO1);
		List<Orders_itemVO> testList = new ArrayList<Orders_itemVO>();
		Orders_itemVO orders_itemAA = new Orders_itemVO();
//		orders_itemAA.setOrders_no("111");
		orders_itemAA.setProduct_no("1002");
		orders_itemAA.setCommodities_amount(1);
		orders_itemAA.setSelling_price(990);
		
		testList.add(orders_itemAA);

		dao.insertWithOrders_item(ordersVO1 , testList);
		
		System.out.println("~~~~~Insert_RUN~~~~~");
//		Set<Orders_itemVO> set = dao.getOrders_itemByOrders_no("1");
//		for(Orders_itemVO aOrders : set){
//			System.out.print(aOrders.getOrders_no());
//			System.out.print(aOrders.getProduct_no());
//			System.out.print(aOrders.getCommodities_amount());
//			System.out.print(aOrders.getSelling_price());
//		}
	}	
}
