package com.second_prod.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Second_Prod;
/** 
 *表格名稱 : <br>
 *	二手商品<br>
 *	英文:second_Prod<br>
 */ 
public class Second_ProdDAO implements Second_ProdDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO second_Prod(second_Prod_Id,mem_Id,second_Prod_Title,second_Prod_Content,second_Prod_adp_start_date,second_Prod_adp_end_date,second_Prod_adp_upDate,second_Prod_adp_city,second_Prod_Town,second_Prod_Road,second_Prod_Lon,second_Prod_Lat ) VALUES  ( second_Prod_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE second_Prod SET second_Prod_Title=?,second_Prod_Content=? ,second_Prod_adp_start_date=? ,second_Prod_adp_end_date=? ,second_Prod_adp_upDate=? ,second_Prod_adp_city=? ,second_Prod_Town=? ,second_Prod_Road=? ,second_Prod_Lon=? ,second_Prod_Lat=?  WHERE second_Prod_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM second_Prod WHERE second_Prod_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT second_Prod_Id,mem_Id,second_Prod_Title,second_Prod_Content,to_char(second_Prod_adp_start_date,'yyyy-mm-dd') second_Prod_adp_start_date,to_char(second_Prod_adp_end_date,'yyyy-mm-dd') second_Prod_adp_end_date,to_char(second_Prod_adp_upDate,'yyyy-mm-dd') second_Prod_adp_upDate,second_Prod_adp_city,second_Prod_Town,second_Prod_Road,second_Prod_Lon,second_Prod_Lat FROM second_prod WHERE second_Prod_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT second_Prod_Id,mem_Id,second_Prod_Title,second_Prod_Content,to_char(second_Prod_adp_start_date,'yyyy-mm-dd') second_Prod_adp_start_date,to_char(second_Prod_adp_end_date,'yyyy-mm-dd') second_Prod_adp_end_date,to_char(second_Prod_adp_upDate,'yyyy-mm-dd') second_Prod_adp_upDate,second_Prod_adp_city,second_Prod_Town,second_Prod_Road,second_Prod_Lon,second_Prod_Lat FROM second_Prod order by second_Prod_Id " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Second_Prods_ByMem_Id_STMT = 
		"SELECT second_Prod_Id,mem_Id,second_Prod_Title,second_Prod_Content,to_char(second_Prod_adp_start_date,'yyyy-mm-dd') second_Prod_adp_start_date,to_char(second_Prod_adp_end_date,'yyyy-mm-dd') second_Prod_adp_end_date,to_char(second_Prod_adp_upDate,'yyyy-mm-dd') second_Prod_adp_upDate,second_Prod_adp_city,second_Prod_Town,second_Prod_Road,second_Prod_Lon,second_Prod_Lat FROM Second_Prod WHERE mem_Id = ? order by mem_Id";

	//====以下是新增指令====
	private static final String UPDATE_SECOND_PROD_TITLE =" UPDATE second_Prod set SECOND_PROD_TITLE=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_CONTENT =" UPDATE second_Prod set SECOND_PROD_CONTENT=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_ADP_START_DATE =" UPDATE second_Prod set SECOND_PROD_ADP_START_DATE=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_ADP_END_DATE =" UPDATE second_Prod set SECOND_PROD_ADP_END_DATE=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_ADP_UPDATE =" UPDATE second_Prod set SECOND_PROD_ADP_UPDATE=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_ADP_CITY =" UPDATE second_Prod set SECOND_PROD_ADP_CITY=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_TOWN =" UPDATE second_Prod set SECOND_PROD_TOWN=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_ROAD =" UPDATE second_Prod set SECOND_PROD_ROAD=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_LON =" UPDATE second_Prod set SECOND_PROD_LON=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_LAT =" UPDATE second_Prod set SECOND_PROD_LAT=?  WHERE second_Prod_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Second_ProdVO aSecond_ProdVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdDAO.INSERT_STMT);
			pstmt.setString (1, aSecond_ProdVO.getMem_Id());
			pstmt.setString (2, aSecond_ProdVO.getSecond_Prod_Title());
			pstmt.setString (3, aSecond_ProdVO.getSecond_Prod_Content());
			pstmt.setDate (4, aSecond_ProdVO.getSecond_Prod_adp_start_date());
			pstmt.setDate (5, aSecond_ProdVO.getSecond_Prod_adp_end_date());
			pstmt.setDate (6, aSecond_ProdVO.getSecond_Prod_adp_upDate());
			pstmt.setString (7, aSecond_ProdVO.getSecond_Prod_adp_city());
			pstmt.setString (8, aSecond_ProdVO.getSecond_Prod_Town());
			pstmt.setString (9, aSecond_ProdVO.getSecond_Prod_Road());
			pstmt.setDouble (10, aSecond_ProdVO.getSecond_Prod_Lon());
			pstmt.setDouble (11, aSecond_ProdVO.getSecond_Prod_Lat());
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
	public void update(Second_ProdVO aSecond_ProdVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdDAO.UPDATE);
			pstmt.setString (1, aSecond_ProdVO.getSecond_Prod_Title());
			pstmt.setString (2, aSecond_ProdVO.getSecond_Prod_Content());
			pstmt.setDate (3, aSecond_ProdVO.getSecond_Prod_adp_start_date());
			pstmt.setDate (4, aSecond_ProdVO.getSecond_Prod_adp_end_date());
			pstmt.setDate (5, aSecond_ProdVO.getSecond_Prod_adp_upDate());
			pstmt.setString (6, aSecond_ProdVO.getSecond_Prod_adp_city());
			pstmt.setString (7, aSecond_ProdVO.getSecond_Prod_Town());
			pstmt.setString (8, aSecond_ProdVO.getSecond_Prod_Road());
			pstmt.setDouble (9, aSecond_ProdVO.getSecond_Prod_Lon());
			pstmt.setDouble (10, aSecond_ProdVO.getSecond_Prod_Lat());
			pstmt.setString (11, aSecond_ProdVO.getSecond_Prod_Id());
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
	public void delete(String  aSecond_Prod){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdDAO.DELETE);
			pstmt.setString (1,aSecond_Prod);
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
	public Second_ProdVO findByPrimaryKey(String  aPK_NO){
		Second_ProdVO second_prodVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				second_prodVO = new Second_ProdVO();
				second_prodVO.setSecond_Prod_Id(rs.getString("second_Prod_Id"));
				second_prodVO.setMem_Id(rs.getString("mem_Id"));
				second_prodVO.setSecond_Prod_Title(rs.getString("second_Prod_Title"));
				second_prodVO.setSecond_Prod_Content(rs.getString("second_Prod_Content"));
				second_prodVO.setSecond_Prod_adp_start_date(rs.getDate("second_Prod_adp_start_date"));
				second_prodVO.setSecond_Prod_adp_end_date(rs.getDate("second_Prod_adp_end_date"));
				second_prodVO.setSecond_Prod_adp_upDate(rs.getDate("second_Prod_adp_upDate"));
				second_prodVO.setSecond_Prod_adp_city(rs.getString("second_Prod_adp_city"));
				second_prodVO.setSecond_Prod_Town(rs.getString("second_Prod_Town"));
				second_prodVO.setSecond_Prod_Road(rs.getString("second_Prod_Road"));
				second_prodVO.setSecond_Prod_Lon(rs.getDouble("second_Prod_Lon"));
				second_prodVO.setSecond_Prod_Lat(rs.getDouble("second_Prod_Lat"));
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
		return second_prodVO; 
	} 

    @Override
    public List<Second_ProdVO> getAll() {
        List<Second_ProdVO> list = new ArrayList<Second_ProdVO>();
        Second_ProdVO second_prodVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // second_prodVO 也稱為 Domain objects
                second_prodVO = new Second_ProdVO();
                second_prodVO.setSecond_Prod_Id(rs.getString("second_Prod_Id"));
                second_prodVO.setMem_Id(rs.getString("mem_Id"));
                second_prodVO.setSecond_Prod_Title(rs.getString("second_Prod_Title"));
                second_prodVO.setSecond_Prod_Content(rs.getString("second_Prod_Content"));
                second_prodVO.setSecond_Prod_adp_start_date(rs.getDate("second_Prod_adp_start_date"));
                second_prodVO.setSecond_Prod_adp_end_date(rs.getDate("second_Prod_adp_end_date"));
                second_prodVO.setSecond_Prod_adp_upDate(rs.getDate("second_Prod_adp_upDate"));
                second_prodVO.setSecond_Prod_adp_city(rs.getString("second_Prod_adp_city"));
                second_prodVO.setSecond_Prod_Town(rs.getString("second_Prod_Town"));
                second_prodVO.setSecond_Prod_Road(rs.getString("second_Prod_Road"));
                second_prodVO.setSecond_Prod_Lon(rs.getDouble("second_Prod_Lon"));
                second_prodVO.setSecond_Prod_Lat(rs.getDouble("second_Prod_Lat"));

                list.add(second_prodVO); // Store the row in the vector
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
    public List<Second_ProdVO> getAll(Map<String, String[]> map) {
        List<Second_ProdVO> list = new ArrayList<Second_ProdVO>();
        Second_ProdVO second_prodVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Second_Prod "
                  + jdbcUtil_CompositeQuery_Second_Prod.get_WhereCondition(map)
                  + "order by second_Prod_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                second_prodVO = new Second_ProdVO();
                
                second_prodVO.setSecond_Prod_Id(rs.getString ("second_Prod_Id"));
                second_prodVO.setMem_Id(rs.getString ("mem_Id"));
                second_prodVO.setSecond_Prod_Title(rs.getString ("second_Prod_Title"));
                second_prodVO.setSecond_Prod_Content(rs.getString ("second_Prod_Content"));
                second_prodVO.setSecond_Prod_adp_start_date(rs.getDate ("second_Prod_adp_start_date"));
                second_prodVO.setSecond_Prod_adp_end_date(rs.getDate ("second_Prod_adp_end_date"));
                second_prodVO.setSecond_Prod_adp_upDate(rs.getDate ("second_Prod_adp_upDate"));
                second_prodVO.setSecond_Prod_adp_city(rs.getString ("second_Prod_adp_city"));
                second_prodVO.setSecond_Prod_Town(rs.getString ("second_Prod_Town"));
                second_prodVO.setSecond_Prod_Road(rs.getString ("second_Prod_Road"));
                second_prodVO.setSecond_Prod_Lon(rs.getDouble ("second_Prod_Lon"));
                second_prodVO.setSecond_Prod_Lat(rs.getDouble ("second_Prod_Lat"));
             
                list.add(second_prodVO); // Store the row in the List
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
    public Set<Second_ProdVO> getSecond_ProdsByMem_Id(String mem_Id) {
        Set<Second_ProdVO> set = new LinkedHashSet<Second_ProdVO>();
        Second_ProdVO second_prodVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Second_Prods_ByMem_Id_STMT);
            pstmt.setString(1, mem_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                second_prodVO = new Second_ProdVO();
				second_prodVO.setSecond_Prod_Id(rs.getString ("second_Prod_Id"));
				second_prodVO.setMem_Id(rs.getString ("mem_Id"));
				second_prodVO.setSecond_Prod_Title(rs.getString ("second_Prod_Title"));
				second_prodVO.setSecond_Prod_Content(rs.getString ("second_Prod_Content"));
				second_prodVO.setSecond_Prod_adp_start_date(rs.getDate ("second_Prod_adp_start_date"));
				second_prodVO.setSecond_Prod_adp_end_date(rs.getDate ("second_Prod_adp_end_date"));
				second_prodVO.setSecond_Prod_adp_upDate(rs.getDate ("second_Prod_adp_upDate"));
				second_prodVO.setSecond_Prod_adp_city(rs.getString ("second_Prod_adp_city"));
				second_prodVO.setSecond_Prod_Town(rs.getString ("second_Prod_Town"));
				second_prodVO.setSecond_Prod_Road(rs.getString ("second_Prod_Road"));
				second_prodVO.setSecond_Prod_Lon(rs.getDouble ("second_Prod_Lon"));
				second_prodVO.setSecond_Prod_Lat(rs.getDouble ("second_Prod_Lat"));

                set.add(second_prodVO); // Store the row in the vector
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