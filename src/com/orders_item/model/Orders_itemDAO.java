package com.orders_item.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Orders_item;
/** 
 *表格名稱 : <br>
 *	訂單明細<br>
 *	英文:orders_item<br>
 */ 
public class Orders_itemDAO implements Orders_itemDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO orders_item(orders_no,product_no,commodities_amout,selling_price ) VALUES  ( ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE orders_item SET commodities_amout=?,selling_price=?  WHERE =? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM orders_item WHERE =? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT orders_no,product_no,commodities_amout,selling_price FROM orders_item WHERE =? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT orders_no,product_no,commodities_amout,selling_price FROM orders_item order by  " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Orders_items_ByOrders_no_STMT = 
		"SELECT orders_no,product_no,commodities_amout,selling_price FROM Orders_item WHERE orders_no = ? order by orders_no";
    private static final String GET_Orders_items_ByProduct_no_STMT = 
		"SELECT orders_no,product_no,commodities_amout,selling_price FROM Orders_item WHERE product_no = ? order by product_no";

	//====以下是新增指令====
	private static final String UPDATE_COMMODITIES_AMOUT =" UPDATE orders_item set COMMODITIES_AMOUT=?  WHERE orders_no=? " ; 
	private static final String UPDATE_SELLING_PRICE =" UPDATE orders_item set SELLING_PRICE=?  WHERE orders_no=? " ; 
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
	public void delete_By_orders_no(String  aOrders_item){
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
	//====以下是改寫delete方法====
	@Override
	public void delete_By_product_no(String  aOrders_item){
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
	public Orders_itemVO findByPrimaryKey_By_orders_no(String  aPK_NO){
		Orders_itemVO orders_itemVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Orders_itemDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
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
	//====以下是改寫findByPrimaryKey方法====
	@Override
	public Orders_itemVO findByPrimaryKey_By_product_no(String  aPK_NO){
		Orders_itemVO orders_itemVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Orders_itemDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
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

    @Override
    public List<Orders_itemVO> getAll() {
        List<Orders_itemVO> list = new ArrayList<Orders_itemVO>();
        Orders_itemVO orders_itemVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // orders_itemVO 也稱為 Domain objects
                orders_itemVO = new Orders_itemVO();
                orders_itemVO.setOrders_no(rs.getString("orders_no"));
                orders_itemVO.setProduct_no(rs.getString("product_no"));
                orders_itemVO.setCommodities_amout(rs.getInt("commodities_amout"));
                orders_itemVO.setSelling_price(rs.getInt("selling_price"));

                list.add(orders_itemVO); // Store the row in the vector
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

    @Override
    public List<Orders_itemVO> getAll(Map<String, String[]> map) {
        List<Orders_itemVO> list = new ArrayList<Orders_itemVO>();
        Orders_itemVO orders_itemVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Orders_item "
                  + jdbcUtil_CompositeQuery_Orders_item.get_WhereCondition(map)
                  + "order by {PK英文名稱}";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                orders_itemVO = new Orders_itemVO();
                
                orders_itemVO.setOrders_no(rs.getString ("orders_no"));
                orders_itemVO.setProduct_no(rs.getString ("product_no"));
                orders_itemVO.setCommodities_amout(rs.getInt ("commodities_amout"));
                orders_itemVO.setSelling_price(rs.getInt ("selling_price"));
             
                list.add(orders_itemVO); // Store the row in the List
            }
    
            // ====
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
    public Set<Orders_itemVO> getOrders_itemsByOrders_no(String orders_no) {
        Set<Orders_itemVO> set = new LinkedHashSet<Orders_itemVO>();
        Orders_itemVO orders_itemVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Orders_items_ByOrders_no_STMT);
            pstmt.setString(1, orders_no);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                orders_itemVO = new Orders_itemVO();
				orders_itemVO.setOrders_no(rs.getString ("orders_no"));
				orders_itemVO.setProduct_no(rs.getString ("product_no"));
				orders_itemVO.setCommodities_amout(rs.getInt ("commodities_amout"));
				orders_itemVO.setSelling_price(rs.getInt ("selling_price"));

                set.add(orders_itemVO); // Store the row in the vector
            }
    
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
        return set;
    }


 

    @Override   
    public Set<Orders_itemVO> getOrders_itemsByProduct_no(String product_no) {
        Set<Orders_itemVO> set = new LinkedHashSet<Orders_itemVO>();
        Orders_itemVO orders_itemVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Orders_items_ByProduct_no_STMT);
            pstmt.setString(1, product_no);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                orders_itemVO = new Orders_itemVO();
				orders_itemVO.setOrders_no(rs.getString ("orders_no"));
				orders_itemVO.setProduct_no(rs.getString ("product_no"));
				orders_itemVO.setCommodities_amout(rs.getInt ("commodities_amout"));
				orders_itemVO.setSelling_price(rs.getInt ("selling_price"));

                set.add(orders_itemVO); // Store the row in the vector
            }
    
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
        return set;
    }




}