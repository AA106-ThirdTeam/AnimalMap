package com.park.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Park;
/** 
 *表格名稱 : <br>
 *	公園<br>
 *	英文:park<br>
 */ 
public class ParkDAO implements ParkDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO park(park_Id,emp_Id,park_title,park_content,park_pic,adp_start_date,adp_upDate,adp_city,park_town,park_road,park_lon,park_lat ) VALUES  ( park_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE park SET park_title=?,park_content=? ,park_pic=? ,adp_start_date=? ,adp_upDate=? ,adp_city=? ,park_town=? ,park_road=? ,park_lon=? ,park_lat=?  WHERE park_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM park WHERE park_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT park_Id,emp_Id,park_title,park_content,park_pic,to_char(adp_start_date,'yyyy-mm-dd') adp_start_date,to_char(adp_upDate,'yyyy-mm-dd') adp_upDate,adp_city,park_town,park_road,park_lon,park_lat FROM park WHERE park_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT park_Id,emp_Id,park_title,park_content,park_pic,to_char(adp_start_date,'yyyy-mm-dd') adp_start_date,to_char(adp_upDate,'yyyy-mm-dd') adp_upDate,adp_city,park_town,park_road,park_lon,park_lat FROM park order by park_Id " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Parks_ByEmp_No_STMT = 
		"SELECT park_Id,emp_Id,park_title,park_content,park_pic,to_char(adp_start_date,'yyyy-mm-dd') adp_start_date,to_char(adp_upDate,'yyyy-mm-dd') adp_upDate,adp_city,park_town,park_road,park_lon,park_lat FROM Park WHERE emp_Id = ? order by emp_Id";

	//====以下是新增指令====
	private static final String UPDATE_PARK_TITLE =" UPDATE park set PARK_TITLE=?  WHERE park_Id=? " ; 
	private static final String UPDATE_PARK_CONTENT =" UPDATE park set PARK_CONTENT=?  WHERE park_Id=? " ; 
	private static final String UPDATE_PARK_PIC =" UPDATE park set PARK_PIC=?  WHERE park_Id=? " ; 
	private static final String UPDATE_ADP_START_DATE =" UPDATE park set ADP_START_DATE=?  WHERE park_Id=? " ; 
	private static final String UPDATE_ADP_UPDATE =" UPDATE park set ADP_UPDATE=?  WHERE park_Id=? " ; 
	private static final String UPDATE_ADP_CITY =" UPDATE park set ADP_CITY=?  WHERE park_Id=? " ; 
	private static final String UPDATE_PARK_TOWN =" UPDATE park set PARK_TOWN=?  WHERE park_Id=? " ; 
	private static final String UPDATE_PARK_ROAD =" UPDATE park set PARK_ROAD=?  WHERE park_Id=? " ; 
	private static final String UPDATE_PARK_LON =" UPDATE park set PARK_LON=?  WHERE park_Id=? " ; 
	private static final String UPDATE_PARK_LAT =" UPDATE park set PARK_LAT=?  WHERE park_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(ParkVO aParkVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ParkDAO.INSERT_STMT);
			pstmt.setString (1, aParkVO.getEmp_Id());
			pstmt.setString (2, aParkVO.getPark_title());
			pstmt.setString (3, aParkVO.getPark_content());
			pstmt.setBytes (4, aParkVO.getPark_pic());
			pstmt.setDate (5, aParkVO.getAdp_start_date());
			pstmt.setDate (6, aParkVO.getAdp_upDate());
			pstmt.setString (7, aParkVO.getAdp_city());
			pstmt.setString (8, aParkVO.getPark_town());
			pstmt.setString (9, aParkVO.getPark_road());
			pstmt.setDouble (10, aParkVO.getPark_lon());
			pstmt.setDouble (11, aParkVO.getPark_lat());
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
	public void update(ParkVO aParkVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ParkDAO.UPDATE);
			pstmt.setString (1, aParkVO.getPark_title());
			pstmt.setString (2, aParkVO.getPark_content());
			pstmt.setBytes (3, aParkVO.getPark_pic());
			pstmt.setDate (4, aParkVO.getAdp_start_date());
			pstmt.setDate (5, aParkVO.getAdp_upDate());
			pstmt.setString (6, aParkVO.getAdp_city());
			pstmt.setString (7, aParkVO.getPark_town());
			pstmt.setString (8, aParkVO.getPark_road());
			pstmt.setDouble (9, aParkVO.getPark_lon());
			pstmt.setDouble (10, aParkVO.getPark_lat());
			pstmt.setString (11, aParkVO.getPark_Id());
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
	public void delete(String  aPark){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ParkDAO.DELETE);
			pstmt.setString (1,aPark);
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
	public ParkVO findByPrimaryKey(String  aPK_NO){
		ParkVO parkVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ParkDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				parkVO = new ParkVO();
				parkVO.setPark_Id(rs.getString("park_Id"));
				parkVO.setEmp_Id(rs.getString("emp_Id"));
				parkVO.setPark_title(rs.getString("park_title"));
				parkVO.setPark_content(rs.getString("park_content"));
				parkVO.setPark_pic(rs.getBytes("park_pic"));
				parkVO.setAdp_start_date(rs.getDate("adp_start_date"));
				parkVO.setAdp_upDate(rs.getDate("adp_upDate"));
				parkVO.setAdp_city(rs.getString("adp_city"));
				parkVO.setPark_town(rs.getString("park_town"));
				parkVO.setPark_road(rs.getString("park_road"));
				parkVO.setPark_lon(rs.getDouble("park_lon"));
				parkVO.setPark_lat(rs.getDouble("park_lat"));
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
		return parkVO; 
	} 

    @Override
    public List<ParkVO> getAll() {
        List<ParkVO> list = new ArrayList<ParkVO>();
        ParkVO parkVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // parkVO 也稱為 Domain objects
                parkVO = new ParkVO();
                parkVO.setPark_Id(rs.getString("park_Id"));
                parkVO.setEmp_Id(rs.getString("emp_Id"));
                parkVO.setPark_title(rs.getString("park_title"));
                parkVO.setPark_content(rs.getString("park_content"));
                parkVO.setPark_pic(rs.getBytes("park_pic"));
                parkVO.setAdp_start_date(rs.getDate("adp_start_date"));
                parkVO.setAdp_upDate(rs.getDate("adp_upDate"));
                parkVO.setAdp_city(rs.getString("adp_city"));
                parkVO.setPark_town(rs.getString("park_town"));
                parkVO.setPark_road(rs.getString("park_road"));
                parkVO.setPark_lon(rs.getDouble("park_lon"));
                parkVO.setPark_lat(rs.getDouble("park_lat"));

                list.add(parkVO); // Store the row in the vector
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
    public List<ParkVO> getAll(Map<String, String[]> map) {
        List<ParkVO> list = new ArrayList<ParkVO>();
        ParkVO parkVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Park "
                  + jdbcUtil_CompositeQuery_Park.get_WhereCondition(map)
                  + "order by park_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                parkVO = new ParkVO();
                
                parkVO.setPark_Id(rs.getString ("park_Id"));
                parkVO.setEmp_Id(rs.getString ("emp_Id"));
                parkVO.setPark_title(rs.getString ("park_title"));
                parkVO.setPark_content(rs.getString ("park_content"));
                parkVO.setPark_pic(rs.getBytes ("park_pic"));
                parkVO.setAdp_start_date(rs.getDate ("adp_start_date"));
                parkVO.setAdp_upDate(rs.getDate ("adp_upDate"));
                parkVO.setAdp_city(rs.getString ("adp_city"));
                parkVO.setPark_town(rs.getString ("park_town"));
                parkVO.setPark_road(rs.getString ("park_road"));
                parkVO.setPark_lon(rs.getDouble ("park_lon"));
                parkVO.setPark_lat(rs.getDouble ("park_lat"));
             
                list.add(parkVO); // Store the row in the List
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
    public Set<ParkVO> getParksByEmp_No(String emp_Id) {
        Set<ParkVO> set = new LinkedHashSet<ParkVO>();
        ParkVO parkVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Parks_ByEmp_No_STMT);
            pstmt.setString(1, emp_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                parkVO = new ParkVO();
				parkVO.setPark_Id(rs.getString ("park_Id"));
				parkVO.setEmp_Id(rs.getString ("emp_Id"));
				parkVO.setPark_title(rs.getString ("park_title"));
				parkVO.setPark_content(rs.getString ("park_content"));
				parkVO.setPark_pic(rs.getBytes ("park_pic"));
				parkVO.setAdp_start_date(rs.getDate ("adp_start_date"));
				parkVO.setAdp_upDate(rs.getDate ("adp_upDate"));
				parkVO.setAdp_city(rs.getString ("adp_city"));
				parkVO.setPark_town(rs.getString ("park_town"));
				parkVO.setPark_road(rs.getString ("park_road"));
				parkVO.setPark_lon(rs.getDouble ("park_lon"));
				parkVO.setPark_lat(rs.getDouble ("park_lat"));

                set.add(parkVO); // Store the row in the vector
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