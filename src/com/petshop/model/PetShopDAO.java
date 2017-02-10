package com.petshop.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_PetShop;
/** 
 *表格名稱 : <br>
 *	寵物商店<br>
 *	英文:petShop<br>
 */ 
public class PetShopDAO implements PetShopDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO petShop(shop_Id,shop_MemId,shop_name,shop_city,shop_town,shop_road,shop_Eval,shop_URL,shop_StartTime,shop_EndTime,shop_Tel,shop_Desc,shop_Long,shop_Lat,shop_CreateTime,shop_visible ) VALUES  ( petShop_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE petShop SET shop_name=?,shop_city=? ,shop_town=? ,shop_road=? ,shop_Eval=? ,shop_URL=? ,shop_StartTime=? ,shop_EndTime=? ,shop_Tel=? ,shop_Desc=? ,shop_Long=? ,shop_Lat=? ,shop_CreateTime=? ,shop_visible=?  WHERE shop_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM petShop WHERE shop_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT shop_Id,shop_MemId,shop_name,shop_city,shop_town,shop_road,shop_Eval,shop_URL,shop_StartTime,shop_EndTime,shop_Tel,shop_Desc,shop_Long,shop_Lat,to_char(shop_CreateTime,'yyyy-mm-dd') shop_CreateTime,shop_visible FROM petshop WHERE shop_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT shop_Id,shop_MemId,shop_name,shop_city,shop_town,shop_road,shop_Eval,shop_URL,shop_StartTime,shop_EndTime,shop_Tel,shop_Desc,shop_Long,shop_Lat,to_char(shop_CreateTime,'yyyy-mm-dd') shop_CreateTime,shop_visible FROM petShop order by shop_Id " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_PetShops_ByMem_Id_STMT = 
		"SELECT shop_Id,shop_MemId,shop_name,shop_city,shop_town,shop_road,shop_Eval,shop_URL,shop_StartTime,shop_EndTime,shop_Tel,shop_Desc,shop_Long,shop_Lat,to_char(shop_CreateTime,'yyyy-mm-dd') shop_CreateTime,shop_visible FROM PetShop WHERE shop_MemId = ? order by shop_MemId";

	//====以下是新增指令====
	private static final String UPDATE_SHOP_NAME =" UPDATE petShop set SHOP_NAME=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_CITY =" UPDATE petShop set SHOP_CITY=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_TOWN =" UPDATE petShop set SHOP_TOWN=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_ROAD =" UPDATE petShop set SHOP_ROAD=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_EVAL =" UPDATE petShop set SHOP_EVAL=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_URL =" UPDATE petShop set SHOP_URL=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_STARTTIME =" UPDATE petShop set SHOP_STARTTIME=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_ENDTIME =" UPDATE petShop set SHOP_ENDTIME=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_TEL =" UPDATE petShop set SHOP_TEL=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_DESC =" UPDATE petShop set SHOP_DESC=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_LONG =" UPDATE petShop set SHOP_LONG=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_LAT =" UPDATE petShop set SHOP_LAT=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_CREATETIME =" UPDATE petShop set SHOP_CREATETIME=?  WHERE shop_Id=? " ; 
	private static final String UPDATE_SHOP_VISIBLE =" UPDATE petShop set SHOP_VISIBLE=?  WHERE shop_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(PetShopVO aPetShopVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PetShopDAO.INSERT_STMT);
			pstmt.setString (1, aPetShopVO.getShop_MemId());
			pstmt.setString (2, aPetShopVO.getShop_name());
			pstmt.setString (3, aPetShopVO.getShop_city());
			pstmt.setString (4, aPetShopVO.getShop_town());
			pstmt.setString (5, aPetShopVO.getShop_road());
			pstmt.setInt (6, aPetShopVO.getShop_Eval());
			pstmt.setString (7, aPetShopVO.getShop_URL());
			pstmt.setString (8, aPetShopVO.getShop_StartTime());
			pstmt.setString (9, aPetShopVO.getShop_EndTime());
			pstmt.setString (10, aPetShopVO.getShop_Tel());
			pstmt.setString (11, aPetShopVO.getShop_Desc());
			pstmt.setDouble (12, aPetShopVO.getShop_Long());
			pstmt.setDouble (13, aPetShopVO.getShop_Lat());
			pstmt.setDate (14, aPetShopVO.getShop_CreateTime());
			pstmt.setString (15, aPetShopVO.getShop_visible());
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
	public void update(PetShopVO aPetShopVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PetShopDAO.UPDATE);
			pstmt.setString (1, aPetShopVO.getShop_name());
			pstmt.setString (2, aPetShopVO.getShop_city());
			pstmt.setString (3, aPetShopVO.getShop_town());
			pstmt.setString (4, aPetShopVO.getShop_road());
			pstmt.setInt (5, aPetShopVO.getShop_Eval());
			pstmt.setString (6, aPetShopVO.getShop_URL());
			pstmt.setString (7, aPetShopVO.getShop_StartTime());
			pstmt.setString (8, aPetShopVO.getShop_EndTime());
			pstmt.setString (9, aPetShopVO.getShop_Tel());
			pstmt.setString (10, aPetShopVO.getShop_Desc());
			pstmt.setDouble (11, aPetShopVO.getShop_Long());
			pstmt.setDouble (12, aPetShopVO.getShop_Lat());
			pstmt.setDate (13, aPetShopVO.getShop_CreateTime());
			pstmt.setString (14, aPetShopVO.getShop_visible());
			pstmt.setString (15, aPetShopVO.getShop_Id());
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
	public void delete(String  aPetShop){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PetShopDAO.DELETE);
			pstmt.setString (1,aPetShop);
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
	public PetShopVO findByPrimaryKey(String  aPK_NO){
		PetShopVO petshopVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PetShopDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				petshopVO = new PetShopVO();
				petshopVO.setShop_Id(rs.getString("shop_Id"));
				petshopVO.setShop_MemId(rs.getString("shop_MemId"));
				petshopVO.setShop_name(rs.getString("shop_name"));
				petshopVO.setShop_city(rs.getString("shop_city"));
				petshopVO.setShop_town(rs.getString("shop_town"));
				petshopVO.setShop_road(rs.getString("shop_road"));
				petshopVO.setShop_Eval(rs.getInt("shop_Eval"));
				petshopVO.setShop_URL(rs.getString("shop_URL"));
				petshopVO.setShop_StartTime(rs.getString("shop_StartTime"));
				petshopVO.setShop_EndTime(rs.getString("shop_EndTime"));
				petshopVO.setShop_Tel(rs.getString("shop_Tel"));
				petshopVO.setShop_Desc(rs.getString("shop_Desc"));
				petshopVO.setShop_Long(rs.getDouble("shop_Long"));
				petshopVO.setShop_Lat(rs.getDouble("shop_Lat"));
				petshopVO.setShop_CreateTime(rs.getDate("shop_CreateTime"));
				petshopVO.setShop_visible(rs.getString("shop_visible"));
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
		return petshopVO; 
	} 

    @Override
    public List<PetShopVO> getAll() {
        List<PetShopVO> list = new ArrayList<PetShopVO>();
        PetShopVO petshopVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // petshopVO 也稱為 Domain objects
                petshopVO = new PetShopVO();
                petshopVO.setShop_Id(rs.getString("shop_Id"));
                petshopVO.setShop_MemId(rs.getString("shop_MemId"));
                petshopVO.setShop_name(rs.getString("shop_name"));
                petshopVO.setShop_city(rs.getString("shop_city"));
                petshopVO.setShop_town(rs.getString("shop_town"));
                petshopVO.setShop_road(rs.getString("shop_road"));
                petshopVO.setShop_Eval(rs.getInt("shop_Eval"));
                petshopVO.setShop_URL(rs.getString("shop_URL"));
                petshopVO.setShop_StartTime(rs.getString("shop_StartTime"));
                petshopVO.setShop_EndTime(rs.getString("shop_EndTime"));
                petshopVO.setShop_Tel(rs.getString("shop_Tel"));
                petshopVO.setShop_Desc(rs.getString("shop_Desc"));
                petshopVO.setShop_Long(rs.getDouble("shop_Long"));
                petshopVO.setShop_Lat(rs.getDouble("shop_Lat"));
                petshopVO.setShop_CreateTime(rs.getDate("shop_CreateTime"));
                petshopVO.setShop_visible(rs.getString("shop_visible"));

                list.add(petshopVO); // Store the row in the vector
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
    public List<PetShopVO> getAll(Map<String, String[]> map) {
        List<PetShopVO> list = new ArrayList<PetShopVO>();
        PetShopVO petshopVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from PetShop "
                  + jdbcUtil_CompositeQuery_PetShop.get_WhereCondition(map)
                  + "order by shop_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                petshopVO = new PetShopVO();
                
                petshopVO.setShop_Id(rs.getString ("shop_Id"));
                petshopVO.setShop_MemId(rs.getString ("shop_MemId"));
                petshopVO.setShop_name(rs.getString ("shop_name"));
                petshopVO.setShop_city(rs.getString ("shop_city"));
                petshopVO.setShop_town(rs.getString ("shop_town"));
                petshopVO.setShop_road(rs.getString ("shop_road"));
                petshopVO.setShop_Eval(rs.getInt ("shop_Eval"));
                petshopVO.setShop_URL(rs.getString ("shop_URL"));
                petshopVO.setShop_StartTime(rs.getString ("shop_StartTime"));
                petshopVO.setShop_EndTime(rs.getString ("shop_EndTime"));
                petshopVO.setShop_Tel(rs.getString ("shop_Tel"));
                petshopVO.setShop_Desc(rs.getString ("shop_Desc"));
                petshopVO.setShop_Long(rs.getDouble ("shop_Long"));
                petshopVO.setShop_Lat(rs.getDouble ("shop_Lat"));
                petshopVO.setShop_CreateTime(rs.getDate ("shop_CreateTime"));
                petshopVO.setShop_visible(rs.getString ("shop_visible"));
             
                list.add(petshopVO); // Store the row in the List
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
    public Set<PetShopVO> getPetShopsByMem_Id(String shop_MemId) {
        Set<PetShopVO> set = new LinkedHashSet<PetShopVO>();
        PetShopVO petshopVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_PetShops_ByMem_Id_STMT);
            pstmt.setString(1, shop_MemId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                petshopVO = new PetShopVO();
				petshopVO.setShop_Id(rs.getString ("shop_Id"));
				petshopVO.setShop_MemId(rs.getString ("shop_MemId"));
				petshopVO.setShop_name(rs.getString ("shop_name"));
				petshopVO.setShop_city(rs.getString ("shop_city"));
				petshopVO.setShop_town(rs.getString ("shop_town"));
				petshopVO.setShop_road(rs.getString ("shop_road"));
				petshopVO.setShop_Eval(rs.getInt ("shop_Eval"));
				petshopVO.setShop_URL(rs.getString ("shop_URL"));
				petshopVO.setShop_StartTime(rs.getString ("shop_StartTime"));
				petshopVO.setShop_EndTime(rs.getString ("shop_EndTime"));
				petshopVO.setShop_Tel(rs.getString ("shop_Tel"));
				petshopVO.setShop_Desc(rs.getString ("shop_Desc"));
				petshopVO.setShop_Long(rs.getDouble ("shop_Long"));
				petshopVO.setShop_Lat(rs.getDouble ("shop_Lat"));
				petshopVO.setShop_CreateTime(rs.getDate ("shop_CreateTime"));
				petshopVO.setShop_visible(rs.getString ("shop_visible"));

                set.add(petshopVO); // Store the row in the vector
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