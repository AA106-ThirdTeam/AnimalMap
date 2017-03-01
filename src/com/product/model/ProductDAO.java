package com.product.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Product;

public class ProductDAO implements ProductDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB_Hua");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

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

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, productVO.getProduct_name());
			pstmt.setString(2, productVO.getProduct_introduction());
			pstmt.setInt(3, productVO.getProduct_price());
			pstmt.setInt(4, productVO.getProduct_stock());
			pstmt.setString(5,productVO.getProduct_picture_large() );
			pstmt.setString(6, productVO.getProduct_picture_small() );
			pstmt.setInt(7, productVO.getProduct_status());
			pstmt.setDate(8, productVO.getProduct_create_date());
			pstmt.setString(9, productVO.getProduct_info());
			pstmt.setString(10, productVO.getProduct_kind_no());

			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
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
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, product_no);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, product_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 也稱為 Domain objects
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

				con = ds.getConnection();
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

	@Override
	public List<ProductVO> getAll(Map<String, String[]> map) {
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			con = ds.getConnection();
			String finalSQL = "select * from product "
		          + jdbcUtil_CompositeQuery_Product.get_WhereCondition(map)
		          + "order by product_no";
			pstmt = con.prepareStatement(finalSQL);
			System.out.println("●●finalSQL(by DAO) = "+finalSQL);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
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
				list.add(productVO); // Store the row in the List
		}
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

}
