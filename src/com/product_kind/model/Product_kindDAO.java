package com.product_kind.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	商品類別<br>
 *	英文:product_kind<br>
 */ 
public class Product_kindDAO implements Product_kindDAO_interface{
	private static DataSource ds = null; 
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AnimalMapDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO product_kind(product_kind_no,product_kind_name ) VALUES  ( product_kind_seq1.nextval , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE product_kind SET product_kind_name=? WHERE product_kind_no=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM product_kind WHERE product_kind_no=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT product_kind_no,product_kind_name FROM product_kind WHERE product_kind_no=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT product_kind_no,product_kind_name FROM product_kind order by product_kind_no " ; 
	//====以下是新增指令====
	private static final String UPDATE_PRODUCT_KIND_NAME =" UPDATE product_kind set PRODUCT_KIND_NAME=?  WHERE product_kind_no=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Product_kindVO aProduct_kindVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Product_kindDAO.INSERT_STMT);
			pstmt.setString (1, aProduct_kindVO.getProduct_kind_name());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
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
	public void update(Product_kindVO aProduct_kindVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Product_kindDAO.UPDATE);
			pstmt.setString (1, aProduct_kindVO.getProduct_kind_name());
			pstmt.setString (2, aProduct_kindVO.getProduct_kind_no());
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
	public void delete(String  aProduct_kind){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Product_kindDAO.DELETE);
			pstmt.setString (1,aProduct_kind);
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
	public Product_kindVO findByPrimaryKey(String  aPK_NO){
		Product_kindVO product_kindVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Product_kindDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				product_kindVO = new Product_kindVO();
				product_kindVO.setProduct_kind_no(rs.getString("product_kind_no"));
				product_kindVO.setProduct_kind_name(rs.getString("product_kind_name"));
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
                // product_kindVO 也稱為 Domain objects
                product_kindVO = new Product_kindVO();
                product_kindVO.setProduct_kind_no(rs.getString("product_kind_no"));
                product_kindVO.setProduct_kind_name(rs.getString("product_kind_name"));

                list.add(product_kindVO); // Store the row in the vector
            }

            // Handle any driver errors
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

}