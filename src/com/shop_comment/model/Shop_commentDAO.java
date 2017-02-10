package com.shop_comment.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Shop_comment;
/** 
 *表格名稱 : <br>
 *	商家留言<br>
 *	英文:shop_comment<br>
 */ 
public class Shop_commentDAO implements Shop_commentDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO shop_comment(shopComment_Id,shopComment_MemId,shopComment_ShopId,shopComment_content,shopComment_SendTime ) VALUES  ( shop_comment_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE shop_comment SET shopComment_content=?,shopComment_SendTime=?  WHERE shopComment_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM shop_comment WHERE shopComment_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT shopComment_Id,shopComment_MemId,shopComment_ShopId,shopComment_content,to_char(shopComment_SendTime,'yyyy-mm-dd') shopComment_SendTime FROM shop_comment WHERE shopComment_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT shopComment_Id,shopComment_MemId,shopComment_ShopId,shopComment_content,to_char(shopComment_SendTime,'yyyy-mm-dd') shopComment_SendTime FROM shop_comment order by shopComment_Id " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Shop_comments_ByMem_Id_STMT = 
		"SELECT shopComment_Id,shopComment_MemId,shopComment_ShopId,shopComment_content,to_char(shopComment_SendTime,'yyyy-mm-dd') shopComment_SendTime FROM Shop_comment WHERE shopComment_MemId = ? order by shopComment_MemId";
    private static final String GET_Shop_comments_ByShop_Id_STMT = 
		"SELECT shopComment_Id,shopComment_MemId,shopComment_ShopId,shopComment_content,to_char(shopComment_SendTime,'yyyy-mm-dd') shopComment_SendTime FROM Shop_comment WHERE shopComment_ShopId = ? order by shopComment_ShopId";

	//====以下是新增指令====
	private static final String UPDATE_SHOPCOMMENT_CONTENT =" UPDATE shop_comment set SHOPCOMMENT_CONTENT=?  WHERE shopComment_Id=? " ; 
	private static final String UPDATE_SHOPCOMMENT_SENDTIME =" UPDATE shop_comment set SHOPCOMMENT_SENDTIME=?  WHERE shopComment_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Shop_commentVO aShop_commentVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Shop_commentDAO.INSERT_STMT);
			pstmt.setString (1, aShop_commentVO.getShopComment_MemId());
			pstmt.setString (2, aShop_commentVO.getShopComment_ShopId());
			pstmt.setString (3, aShop_commentVO.getShopComment_content());
			pstmt.setDate (4, aShop_commentVO.getShopComment_SendTime());
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
	public void update(Shop_commentVO aShop_commentVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Shop_commentDAO.UPDATE);
			pstmt.setString (1, aShop_commentVO.getShopComment_content());
			pstmt.setDate (2, aShop_commentVO.getShopComment_SendTime());
			pstmt.setString (3, aShop_commentVO.getShopComment_Id());
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
	public void delete(String  aShop_comment){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Shop_commentDAO.DELETE);
			pstmt.setString (1,aShop_comment);
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
	public Shop_commentVO findByPrimaryKey(String  aPK_NO){
		Shop_commentVO shop_commentVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Shop_commentDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shop_commentVO = new Shop_commentVO();
				shop_commentVO.setShopComment_Id(rs.getString("shopComment_Id"));
				shop_commentVO.setShopComment_MemId(rs.getString("shopComment_MemId"));
				shop_commentVO.setShopComment_ShopId(rs.getString("shopComment_ShopId"));
				shop_commentVO.setShopComment_content(rs.getString("shopComment_content"));
				shop_commentVO.setShopComment_SendTime(rs.getDate("shopComment_SendTime"));
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
		return shop_commentVO; 
	} 

    @Override
    public List<Shop_commentVO> getAll() {
        List<Shop_commentVO> list = new ArrayList<Shop_commentVO>();
        Shop_commentVO shop_commentVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // shop_commentVO 也稱為 Domain objects
                shop_commentVO = new Shop_commentVO();
                shop_commentVO.setShopComment_Id(rs.getString("shopComment_Id"));
                shop_commentVO.setShopComment_MemId(rs.getString("shopComment_MemId"));
                shop_commentVO.setShopComment_ShopId(rs.getString("shopComment_ShopId"));
                shop_commentVO.setShopComment_content(rs.getString("shopComment_content"));
                shop_commentVO.setShopComment_SendTime(rs.getDate("shopComment_SendTime"));

                list.add(shop_commentVO); // Store the row in the vector
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
    public List<Shop_commentVO> getAll(Map<String, String[]> map) {
        List<Shop_commentVO> list = new ArrayList<Shop_commentVO>();
        Shop_commentVO shop_commentVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Shop_comment "
                  + jdbcUtil_CompositeQuery_Shop_comment.get_WhereCondition(map)
                  + "order by shopComment_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                shop_commentVO = new Shop_commentVO();
                
                shop_commentVO.setShopComment_Id(rs.getString ("shopComment_Id"));
                shop_commentVO.setShopComment_MemId(rs.getString ("shopComment_MemId"));
                shop_commentVO.setShopComment_ShopId(rs.getString ("shopComment_ShopId"));
                shop_commentVO.setShopComment_content(rs.getString ("shopComment_content"));
                shop_commentVO.setShopComment_SendTime(rs.getDate ("shopComment_SendTime"));
             
                list.add(shop_commentVO); // Store the row in the List
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
    public Set<Shop_commentVO> getShop_commentsByMem_Id(String shopComment_MemId) {
        Set<Shop_commentVO> set = new LinkedHashSet<Shop_commentVO>();
        Shop_commentVO shop_commentVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Shop_comments_ByMem_Id_STMT);
            pstmt.setString(1, shopComment_MemId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                shop_commentVO = new Shop_commentVO();
				shop_commentVO.setShopComment_Id(rs.getString ("shopComment_Id"));
				shop_commentVO.setShopComment_MemId(rs.getString ("shopComment_MemId"));
				shop_commentVO.setShopComment_ShopId(rs.getString ("shopComment_ShopId"));
				shop_commentVO.setShopComment_content(rs.getString ("shopComment_content"));
				shop_commentVO.setShopComment_SendTime(rs.getDate ("shopComment_SendTime"));

                set.add(shop_commentVO); // Store the row in the vector
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
    public Set<Shop_commentVO> getShop_commentsByShop_Id(String shopComment_ShopId) {
        Set<Shop_commentVO> set = new LinkedHashSet<Shop_commentVO>();
        Shop_commentVO shop_commentVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Shop_comments_ByShop_Id_STMT);
            pstmt.setString(1, shopComment_ShopId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                shop_commentVO = new Shop_commentVO();
				shop_commentVO.setShopComment_Id(rs.getString ("shopComment_Id"));
				shop_commentVO.setShopComment_MemId(rs.getString ("shopComment_MemId"));
				shop_commentVO.setShopComment_ShopId(rs.getString ("shopComment_ShopId"));
				shop_commentVO.setShopComment_content(rs.getString ("shopComment_content"));
				shop_commentVO.setShopComment_SendTime(rs.getDate ("shopComment_SendTime"));

                set.add(shop_commentVO); // Store the row in the vector
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