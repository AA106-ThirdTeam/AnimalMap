package com.orders.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Orders;
/** 
 *表格名稱 : <br>
 *	訂單<br>
 *	英文:orders<br>
 */ 
public class OrdersDAO implements OrdersDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO orders(orders_no,mem_Id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,orders_date,orders_ship_date,orders_total,orders_status,orders_credit ) VALUES  ( orders_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE orders SET orders_receiver=?,post_no=? ,post_adp_city=? ,post_town=? ,post_road=? ,orders_phone=? ,collect_mode_no=? ,orders_date=? ,orders_ship_date=? ,orders_total=? ,orders_status=? ,orders_credit=?  WHERE orders_no=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM orders WHERE orders_no=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT orders_no,mem_Id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,to_char(orders_date,'yyyy-mm-dd') orders_date,to_char(orders_ship_date,'yyyy-mm-dd') orders_ship_date,orders_total,orders_status,orders_credit FROM orders WHERE orders_no=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT orders_no,mem_Id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,to_char(orders_date,'yyyy-mm-dd') orders_date,to_char(orders_ship_date,'yyyy-mm-dd') orders_ship_date,orders_total,orders_status,orders_credit FROM orders order by orders_no " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Orderss_ByMem_Id_STMT = 
		"SELECT orders_no,mem_Id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,to_char(orders_date,'yyyy-mm-dd') orders_date,to_char(orders_ship_date,'yyyy-mm-dd') orders_ship_date,orders_total,orders_status,orders_credit FROM Orders WHERE mem_Id = ? order by mem_Id";

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
			pstmt.setString (13, aOrdersVO.getOrders_no());
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
	public OrdersVO findByPrimaryKey(String  aPK_NO){
		OrdersVO ordersVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(OrdersDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
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

    @Override
    public List<OrdersVO> getAll() {
        List<OrdersVO> list = new ArrayList<OrdersVO>();
        OrdersVO ordersVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // ordersVO 也稱為 Domain objects
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

                list.add(ordersVO); // Store the row in the vector
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
    public List<OrdersVO> getAll(Map<String, String[]> map) {
        List<OrdersVO> list = new ArrayList<OrdersVO>();
        OrdersVO ordersVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Orders "
                  + jdbcUtil_CompositeQuery_Orders.get_WhereCondition(map)
                  + "order by orders_no";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                ordersVO = new OrdersVO();
                
                ordersVO.setOrders_no(rs.getString ("orders_no"));
                ordersVO.setMem_Id(rs.getString ("mem_Id"));
                ordersVO.setOrders_receiver(rs.getString ("orders_receiver"));
                ordersVO.setPost_no(rs.getString ("post_no"));
                ordersVO.setPost_adp_city(rs.getString ("post_adp_city"));
                ordersVO.setPost_town(rs.getString ("post_town"));
                ordersVO.setPost_road(rs.getString ("post_road"));
                ordersVO.setOrders_phone(rs.getInt ("orders_phone"));
                ordersVO.setCollect_mode_no(rs.getInt ("collect_mode_no"));
                ordersVO.setOrders_date(rs.getDate ("orders_date"));
                ordersVO.setOrders_ship_date(rs.getDate ("orders_ship_date"));
                ordersVO.setOrders_total(rs.getInt ("orders_total"));
                ordersVO.setOrders_status(rs.getInt ("orders_status"));
                ordersVO.setOrders_credit(rs.getInt ("orders_credit"));
             
                list.add(ordersVO); // Store the row in the List
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
    public Set<OrdersVO> getOrderssByMem_Id(String mem_Id) {
        Set<OrdersVO> set = new LinkedHashSet<OrdersVO>();
        OrdersVO ordersVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Orderss_ByMem_Id_STMT);
            pstmt.setString(1, mem_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                ordersVO = new OrdersVO();
				ordersVO.setOrders_no(rs.getString ("orders_no"));
				ordersVO.setMem_Id(rs.getString ("mem_Id"));
				ordersVO.setOrders_receiver(rs.getString ("orders_receiver"));
				ordersVO.setPost_no(rs.getString ("post_no"));
				ordersVO.setPost_adp_city(rs.getString ("post_adp_city"));
				ordersVO.setPost_town(rs.getString ("post_town"));
				ordersVO.setPost_road(rs.getString ("post_road"));
				ordersVO.setOrders_phone(rs.getInt ("orders_phone"));
				ordersVO.setCollect_mode_no(rs.getInt ("collect_mode_no"));
				ordersVO.setOrders_date(rs.getDate ("orders_date"));
				ordersVO.setOrders_ship_date(rs.getDate ("orders_ship_date"));
				ordersVO.setOrders_total(rs.getInt ("orders_total"));
				ordersVO.setOrders_status(rs.getInt ("orders_status"));
				ordersVO.setOrders_credit(rs.getInt ("orders_credit"));

                set.add(ordersVO); // Store the row in the vector
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