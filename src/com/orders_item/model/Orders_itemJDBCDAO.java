package com.orders_item.model;

import java.util.*;


import java.sql.*;

public class Orders_itemJDBCDAO implements Orders_item_interface{

	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String url = "jdbc:oracle:thin:@grandli062902.ddns.net:1521:XE";
	String userid = "bertha";
	String passwd = "109910622";
	
	private static final String INSERT_STMT = 
			"INSERT INTO orders_item(ORDERS_NO,PRODUCT_NO,COMMODITIES_AMOUNT,SELLING_PRICE) VALUES (orders_seq1.NEXTVAL, ?, ?, ?)";
	private static final String INSERT2_STMT =
			"INSERT INTO orders_item(ORDERS_NO,PRODUCT_NO,COMMODITIES_AMOUNT,SELLING_PRICE) VALUES (?, ?, ?, ?)";		
	private static final String GET_ALL_STMT = 
			"SELECT ORDERS_NO,PRODUCT_NO,COMMODITIES_AMOUNT,SELLING_PRICE FROM orders_item";
	private static final String GET_ONE_STMT = 
			"SELECT ORDERS_NO,PRODUCT_NO,COMMODITIES_AMOUNT,SELLING_PRICE FROM orders_item where orders_no = ?";
	private static final String DELETE =
			"DELETE FROM orders_item where orders_no = ?";
	private static final String UPDATE = 
			"UPDATE orders_item set PRODUCT_NO=?,COMMODITIES_AMOUNT=?,SELLING_PRICE=? where ORDERS_NO=?";

	@Override
	public void insert(Orders_itemVO orders_itemVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
//			pstmt.setString(1, orders_itemVO.getOrders_no());
     		pstmt.setString(1, orders_itemVO.getProduct_no());
     		pstmt.setInt(2, orders_itemVO.getCommodities_amount());
     		pstmt.setInt(3, orders_itemVO.getSelling_price());
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
	public void update(Orders_itemVO orders_itemVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String orders_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orders_itemVO findByPrimaryKey(String orders_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders_itemVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert2(Orders_itemVO orders_itemVO, Connection con) {
		PreparedStatement pstmt = null;

		try {

     		pstmt = con.prepareStatement(INSERT2_STMT);
     		pstmt.setString(1, orders_itemVO.getOrders_no());
     		pstmt.setString(2, orders_itemVO.getProduct_no());
     		pstmt.setInt(3, orders_itemVO.getCommodities_amount());
     		pstmt.setInt(4, orders_itemVO.getSelling_price());
     		
     		pstmt.executeUpdate();
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					System.err.print("Transaction is being ");
					System.err.println("rolled back-由-emp");
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
		}
	}
	public static void main(String[] args) {

		Orders_itemJDBCDAO dao = new Orders_itemJDBCDAO();
//	// 新增
	Orders_itemVO orders_itemVO1 = new Orders_itemVO();
	orders_itemVO1.setOrders_no("1");
	orders_itemVO1.setProduct_no("1002");
	orders_itemVO1.setCommodities_amount(1);
	orders_itemVO1.setSelling_price(890);
	dao.insert(orders_itemVO1);
	System.out.println("~~~~~~~~~insert~~~~~~~~~~~");
	}
}
