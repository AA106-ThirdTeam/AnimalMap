package com.product.model;

import java.util.*;
import java.sql.*;

public class ProductJDBCDAO implements ProductDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "bertha";
	String passwd = "109910622";
	
	private static final String INSERT_STMT = 
			"INSERT INTO product(product_no,product_name,product_introduction,product_price,product_stock,product_picture_large,product_picture_small,product_status,product_create_date,product_info,product_kind_no) VALUES (product_seq1.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT product_no,product_name,product_introduction,product_price,product_stock,product_picture_large,product_picture_small,product_status,to_char(product_create_date,'yyyy-mm-dd') product_create_date,product_info,product_kind_no FROM product order by product_no";
	private static final String GET_ONE_STMT = 
			"SELECT product_no,product_name,product_introduction,product_price,product_stock,product_picture_large,product_picture_small,product_status,to_char(product_create_date,'yyyy-mm-dd') product_create_date,product_info,product_kind_no FROM product where product_no = ?";
	private static final String DELETE = 
			"DELETE FROM product where product_no = ?";
	private static final String UPDATE = 
			"UPDATE product set product_name=?,product_introduction=?,product_price=?,product_stock=?,product_picture_large=?,product_picture_small=?,product_status=?,product_create_date=?,product_info=?,product_kind_no=? where product_no = ? ";
	@Override
	public void insert(ProductVO productVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, productVO.getProduct_name());
			pstmt.setString(2, productVO.getProduct_introduction());
			pstmt.setInt(3, productVO.getProduct_price());
			pstmt.setInt(4, productVO.getProduct_stock());
			pstmt.setString(5, productVO.getProduct_picture_large());
			pstmt.setString(6, productVO.getProduct_picture_small());
			pstmt.setInt(7, productVO.getProduct_status());
			pstmt.setDate(8, productVO.getProduct_create_date());
			pstmt.setString(9, productVO.getProduct_info());
			pstmt.setString(10, productVO.getProduct_kind_no());
			
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e){
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se){
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		}finally {
			if (pstmt != null) {
				try{
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null){
				try{
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	
	}
	@Override
	public void update(ProductVO productVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, productVO.getProduct_name());
			pstmt.setString(2, productVO.getProduct_introduction());
			pstmt.setInt(3, productVO.getProduct_price());
			pstmt.setInt(4, productVO.getProduct_stock());
			pstmt.setString(5, productVO.getProduct_picture_large());
			pstmt.setString(6, productVO.getProduct_picture_small());
			pstmt.setInt(7, productVO.getProduct_status());
			pstmt.setDate(8, productVO.getProduct_create_date());
			pstmt.setString(9, productVO.getProduct_info());
			pstmt.setString(10, productVO.getProduct_kind_no());
			pstmt.setString(11, productVO.getProduct_no());
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
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
	public void delete(String product_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, product_no);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
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
	public ProductVO findByPrimaryKey(String product_no) {
		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, product_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				//也稱為 Domain objects				
				productVO = new ProductVO();
				productVO.setProduct_no(rs.getString("product_no"));
				productVO.setProduct_name(rs.getString("product_name"));
				productVO.setProduct_introduction(rs.getString("product_introduction"));
				productVO.setProduct_price(rs.getInt("product_price"));
				productVO.setProduct_stock(rs.getInt("product_stock"));
				productVO.setProduct_picture_large(rs.getString("product_picture_large"));
				productVO.setProduct_picture_small(rs.getString("product_picture_small"));
				productVO.setProduct_status(rs.getInt("product_status"));
				productVO.setProduct_create_date(rs.getDate("product_create_date"));
				productVO.setProduct_info(rs.getString("product_info"));
				productVO.setProduct_kind_no(rs.getString("product_kind_no"));
				
			}

			// Handle any driver errors
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
		return productVO;
	}
	

	
	@Override
	public List<ProductVO> getAll() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				//  也稱為 Domain objects
				
				productVO = new ProductVO();
				productVO.setProduct_no(rs.getString("product_no"));
				productVO.setProduct_name(rs.getString("product_name"));
				productVO.setProduct_introduction(rs.getString("product_introduction"));
				productVO.setProduct_price(rs.getInt("product_price"));
				productVO.setProduct_stock(rs.getInt("product_stock"));
				productVO.setProduct_picture_large(rs.getString("product_picture_large"));
				productVO.setProduct_picture_small(rs.getString("product_picture_small"));
				productVO.setProduct_status(rs.getInt("product_status"));
				productVO.setProduct_create_date(rs.getDate("product_create_date"));
				productVO.setProduct_info(rs.getString("product_info"));
				productVO.setProduct_kind_no(rs.getString("product_kind_no"));
				list.add(productVO);
			}

			// Handle any driver errors
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
		return list;
	}
	
	public static void main(String args[]){
		
		ProductJDBCDAO dao = new ProductJDBCDAO();
		
	//Insert~~~~~~
		ProductVO productVO1 = new ProductVO();
		productVO1.setProduct_name("JDBC測試用 ");
		productVO1.setProduct_introduction("Vet Life獸醫寵愛天然處方系列-VCH-2狗用肝臟配方");
		productVO1.setProduct_price(1200);
		productVO1.setProduct_stock(1);
		productVO1.setProduct_picture_large("");
		productVO1.setProduct_picture_small("");
		productVO1.setProduct_status(2);
		productVO1.setProduct_create_date(java.sql.Date.valueOf("2017-02-05"));
		productVO1.setProduct_info("處方");
		productVO1.setProduct_kind_no("4");
		dao.insert(productVO1);
		System.out.println("-----------RUN----------");
		
	//Update~~~~~~
//		ProductVO productVO2 = new ProductVO();
//		productVO2.setProduct_no("4");
//		productVO2.setProduct_name("肝臟配方 ");
//		productVO2.setProduct_introduction("Vet Life獸醫寵愛天然處方系列-VCH-2貓用肝臟配方");
//		productVO2.setProduct_price(1200);
//		productVO2.setProduct_stock(1);
//		productVO2.setProduct_picture_large("");
//		productVO2.setProduct_picture_small("");
//		productVO2.setProduct_status(2);
//		productVO2.setProduct_create_date(java.sql.Date.valueOf("2017-02-08"));
//		productVO2.setProduct_info("處方");
//		productVO2.setProduct_kind_no("4");
//		dao.update(productVO2);
//		System.out.println("-----------RUN----------");
		
	//Delete~~~~~~
//		dao.delete(5);
//		System.out.println("-----------RUN----------");
		
	//Select~~~~~~
//		List<ProductVO> list = dao.getAll();
//		for (ProductVO aProduct : list){
//			System.out.println("商品編號："+aProduct.getProduct_no() + ",");
//			System.out.println("商品名稱："+aProduct.getProduct_name() + ",");
//			System.out.println("商品簡介："+aProduct.getProduct_introduction() + ",");
//			System.out.println("商品價格："+aProduct.getProduct_price() + ",");
//			System.out.println("商品庫存量："+aProduct.getProduct_stock() + ",");
//			System.out.println("商品圖片："+aProduct.getProduct_picture_large() + ",");
//			System.out.println("商品圖片（縮圖）："+aProduct.getProduct_picture_small() + ",");
//			System.out.println("商品上下架狀態："+aProduct.getProduct_status() + ",");
//			System.out.println("商品建立日期："+aProduct.getProduct_create_date() + ",");
//			System.out.println("商品資訊："+aProduct.getProduct_info() + ",");
//			System.out.println("商品類別編號："+aProduct.getProduct_kind_no()+"\n");
//			System.out.println("-----------RUN----------");
//		}
	}
	@Override
	public List<ProductVO> getAll(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
