package com.shopphoto.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_ShopPhoto;
/** 
 *表格名稱 : <br>
 *	商家相片<br>
 *	英文:shopPhoto<br>
 */ 
public class ShopPhotoDAO implements ShopPhotoDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO shopPhoto(shopPhoto_Id,shopPhoto_ShopId,shopPhoto_photo,isDisp_shopPhoto,shopPhoto_name,shopPhoto_extent ) VALUES  ( shopPhoto_seq1.nextval , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE shopPhoto SET shopPhoto_photo=?,isDisp_shopPhoto=? ,shopPhoto_name=? ,shopPhoto_extent=?  WHERE shopPhoto_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM shopPhoto WHERE shopPhoto_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT shopPhoto_Id,shopPhoto_ShopId,shopPhoto_photo,isDisp_shopPhoto,shopPhoto_name,shopPhoto_extent FROM shopphoto WHERE shopPhoto_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT shopPhoto_Id,shopPhoto_ShopId,shopPhoto_photo,isDisp_shopPhoto,shopPhoto_name,shopPhoto_extent FROM shopPhoto order by shopPhoto_Id " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_ShopPhotos_ByShop_Id_STMT = 
		"SELECT shopPhoto_Id,shopPhoto_ShopId,shopPhoto_photo,isDisp_shopPhoto,shopPhoto_name,shopPhoto_extent FROM ShopPhoto WHERE shopPhoto_ShopId = ? order by shopPhoto_ShopId";

	//====以下是新增指令====
	private static final String UPDATE_SHOPPHOTO_PHOTO =" UPDATE shopPhoto set SHOPPHOTO_PHOTO=?  WHERE shopPhoto_Id=? " ; 
	private static final String UPDATE_ISDISP_SHOPPHOTO =" UPDATE shopPhoto set ISDISP_SHOPPHOTO=?  WHERE shopPhoto_Id=? " ; 
	private static final String UPDATE_SHOPPHOTO_NAME =" UPDATE shopPhoto set SHOPPHOTO_NAME=?  WHERE shopPhoto_Id=? " ; 
	private static final String UPDATE_SHOPPHOTO_EXTENT =" UPDATE shopPhoto set SHOPPHOTO_EXTENT=?  WHERE shopPhoto_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(ShopPhotoVO aShopPhotoVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ShopPhotoDAO.INSERT_STMT);
			pstmt.setString (1, aShopPhotoVO.getShopPhoto_ShopId());
			pstmt.setBytes (2, aShopPhotoVO.getShopPhoto_photo());
			pstmt.setString (3, aShopPhotoVO.getIsDisp_shopPhoto());
			pstmt.setString (4, aShopPhotoVO.getShopPhoto_name());
			pstmt.setString (5, aShopPhotoVO.getShopPhoto_extent());
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
	public void update(ShopPhotoVO aShopPhotoVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ShopPhotoDAO.UPDATE);
			pstmt.setBytes (1, aShopPhotoVO.getShopPhoto_photo());
			pstmt.setString (2, aShopPhotoVO.getIsDisp_shopPhoto());
			pstmt.setString (3, aShopPhotoVO.getShopPhoto_name());
			pstmt.setString (4, aShopPhotoVO.getShopPhoto_extent());
			pstmt.setString (5, aShopPhotoVO.getShopPhoto_Id());
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
	public void delete(String  aShopPhoto){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ShopPhotoDAO.DELETE);
			pstmt.setString (1,aShopPhoto);
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
	public ShopPhotoVO findByPrimaryKey(String  aPK_NO){
		ShopPhotoVO shopphotoVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ShopPhotoDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shopphotoVO = new ShopPhotoVO();
				shopphotoVO.setShopPhoto_Id(rs.getString("shopPhoto_Id"));
				shopphotoVO.setShopPhoto_ShopId(rs.getString("shopPhoto_ShopId"));
				shopphotoVO.setShopPhoto_photo(rs.getBytes("shopPhoto_photo"));
				shopphotoVO.setIsDisp_shopPhoto(rs.getString("isDisp_shopPhoto"));
				shopphotoVO.setShopPhoto_name(rs.getString("shopPhoto_name"));
				shopphotoVO.setShopPhoto_extent(rs.getString("shopPhoto_extent"));
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
		return shopphotoVO; 
	} 

    @Override
    public List<ShopPhotoVO> getAll() {
        List<ShopPhotoVO> list = new ArrayList<ShopPhotoVO>();
        ShopPhotoVO shopphotoVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // shopphotoVO 也稱為 Domain objects
                shopphotoVO = new ShopPhotoVO();
                shopphotoVO.setShopPhoto_Id(rs.getString("shopPhoto_Id"));
                shopphotoVO.setShopPhoto_ShopId(rs.getString("shopPhoto_ShopId"));
                shopphotoVO.setShopPhoto_photo(rs.getBytes("shopPhoto_photo"));
                shopphotoVO.setIsDisp_shopPhoto(rs.getString("isDisp_shopPhoto"));
                shopphotoVO.setShopPhoto_name(rs.getString("shopPhoto_name"));
                shopphotoVO.setShopPhoto_extent(rs.getString("shopPhoto_extent"));

                list.add(shopphotoVO); // Store the row in the vector
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
    public List<ShopPhotoVO> getAll(Map<String, String[]> map) {
        List<ShopPhotoVO> list = new ArrayList<ShopPhotoVO>();
        ShopPhotoVO shopphotoVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from ShopPhoto "
                  + jdbcUtil_CompositeQuery_ShopPhoto.get_WhereCondition(map)
                  + "order by shopPhoto_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                shopphotoVO = new ShopPhotoVO();
                
                shopphotoVO.setShopPhoto_Id(rs.getString ("shopPhoto_Id"));
                shopphotoVO.setShopPhoto_ShopId(rs.getString ("shopPhoto_ShopId"));
                shopphotoVO.setShopPhoto_photo(rs.getBytes ("shopPhoto_photo"));
                shopphotoVO.setIsDisp_shopPhoto(rs.getString ("isDisp_shopPhoto"));
                shopphotoVO.setShopPhoto_name(rs.getString ("shopPhoto_name"));
                shopphotoVO.setShopPhoto_extent(rs.getString ("shopPhoto_extent"));
             
                list.add(shopphotoVO); // Store the row in the List
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
    public Set<ShopPhotoVO> getShopPhotosByShop_Id(String shopPhoto_ShopId) {
        Set<ShopPhotoVO> set = new LinkedHashSet<ShopPhotoVO>();
        ShopPhotoVO shopphotoVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ShopPhotos_ByShop_Id_STMT);
            pstmt.setString(1, shopPhoto_ShopId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                shopphotoVO = new ShopPhotoVO();
				shopphotoVO.setShopPhoto_Id(rs.getString ("shopPhoto_Id"));
				shopphotoVO.setShopPhoto_ShopId(rs.getString ("shopPhoto_ShopId"));
				shopphotoVO.setShopPhoto_photo(rs.getBytes ("shopPhoto_photo"));
				shopphotoVO.setIsDisp_shopPhoto(rs.getString ("isDisp_shopPhoto"));
				shopphotoVO.setShopPhoto_name(rs.getString ("shopPhoto_name"));
				shopphotoVO.setShopPhoto_extent(rs.getString ("shopPhoto_extent"));

                set.add(shopphotoVO); // Store the row in the vector
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