package com.product_kind.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.product.model.ProductVO;

public class Product_kindDAO implements Product_kindDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB_Hua");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO product_kind (product_kind_no,product_kind_name) VALUES (product_kind_seq1.NEXTVAL, ?)";
	private static final String GET_ALL_STMT = "SELECT product_kind_no , product_kind_name FROM product_kind";
	private static final String GET_ONE_STMT = "SELECT product_kind_no , product_kind_name FROM product_kind where product_kind_no = ?";
	private static final String GET_Products_ByProduct_kind_no_STMT = "SELECT product_no,product_name,product_introduction,product_price,product_stock,product_picture_large,product_picture_small,product_status,product_create_date,product_info,product_kind_no FROM product where product_kind_no = ? order by product_kind_no";

	private static final String DELETE_PRODUCTs = "DELETE FROM product where product_kind_no = ?";
	private static final String DELETE_Product_kind = "DELETE FROM product_kind where product_kind_no = ?";

	private static final String UPDATE = "UPDATE product_kind set product_kind_name=? where product_kind_no = ?";

	@Override
	public void insert(Product_kindVO product_kindVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, product_kindVO.getProduct_kind_name());

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

	@Override
	public void update(Product_kindVO product_kindVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, product_kindVO.getProduct_kind_name());
			pstmt.setString(2, product_kindVO.getProduct_kind_no());

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

	@Override
	public void delete(String product_kind_no) {
		int updateCount_PRODUCTs = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();

			con.setAutoCommit(false);

			// delete product~~~~~~
			pstmt = con.prepareStatement(DELETE_PRODUCTs);
			pstmt.setString(1, product_kind_no);
			updateCount_PRODUCTs = pstmt.executeUpdate();

			// delete product_kind~~~~~~~

			pstmt = con.prepareStatement(DELETE_Product_kind);
			pstmt.setString(1, product_kind_no);
			pstmt.executeUpdate();

			con.commit();
			con.setAutoCommit(true);
			System.out.println("刪除商品類別" + product_kind_no + "時,共有商品" + updateCount_PRODUCTs + "件同時被刪除");

		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. " + excep.getMessage());
				}
			}
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

	@Override
	public Product_kindVO findByPrimaryKey(String product_kind_no) {

		Product_kindVO product_kindVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, product_kind_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 也稱為 Domain objects
				product_kindVO = new Product_kindVO();
				product_kindVO.setProduct_kind_no(rs.getString("product_kind_no"));
				product_kindVO.setProduct_kind_name(rs.getString("product_kind_name"));

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
		return product_kindVO;
	}

	@Override
	public List<Product_kindVO> getAll() {
		List<Product_kindVO> list = new ArrayList<Product_kindVO>();
		Product_kindVO product_kindVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				product_kindVO = new Product_kindVO();
				product_kindVO.setProduct_kind_no(rs.getString("product_kind_no"));
				product_kindVO.setProduct_kind_name(rs.getString("product_kind_name"));
				list.add(product_kindVO); // Store the row in the list
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
		return list;
	}

	@Override
	public Set<ProductVO> getProductsByProduct_kind_no(String product_kind_no) {
		Set<ProductVO> set = new LinkedHashSet<ProductVO>();
		ProductVO productVO = null;
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_Products_ByProduct_kind_no_STMT);
			pstmt.setString(1, product_kind_no);
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
				set.add(productVO); // Store the row in the vector

			
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
		return set;
	}
}

