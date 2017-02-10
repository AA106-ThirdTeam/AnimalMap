package com.vet_hospital.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Vet_hospital;
/** 
 *表格名稱 : <br>
 *	診所<br>
 *	英文:vet_hospital<br>
 */ 
public class Vet_hospitalDAO implements Vet_hospitalDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO vet_hospital(hos_Id,hos_MemId,hos_name,hos_city,hos_town,hos_road,hos_Eval,hos_URL,hos_StartTime,hos_EndTime,hos_Tel,hos_Desc,hos_Long,hos_Lat,hos_CreateTime,hos_visible ) VALUES  ( vet_hospital_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE vet_hospital SET hos_name=?,hos_city=? ,hos_town=? ,hos_road=? ,hos_Eval=? ,hos_URL=? ,hos_StartTime=? ,hos_EndTime=? ,hos_Tel=? ,hos_Desc=? ,hos_Long=? ,hos_Lat=? ,hos_CreateTime=? ,hos_visible=?  WHERE hos_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM vet_hospital WHERE hos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT hos_Id,hos_MemId,hos_name,hos_city,hos_town,hos_road,hos_Eval,hos_URL,hos_StartTime,hos_EndTime,hos_Tel,hos_Desc,hos_Long,hos_Lat,to_char(hos_CreateTime,'yyyy-mm-dd') hos_CreateTime,hos_visible FROM vet_hospital WHERE hos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT hos_Id,hos_MemId,hos_name,hos_city,hos_town,hos_road,hos_Eval,hos_URL,hos_StartTime,hos_EndTime,hos_Tel,hos_Desc,hos_Long,hos_Lat,to_char(hos_CreateTime,'yyyy-mm-dd') hos_CreateTime,hos_visible FROM vet_hospital order by hos_Id " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Vet_hospitals_ByMem_Id_STMT = 
		"SELECT hos_Id,hos_MemId,hos_name,hos_city,hos_town,hos_road,hos_Eval,hos_URL,hos_StartTime,hos_EndTime,hos_Tel,hos_Desc,hos_Long,hos_Lat,to_char(hos_CreateTime,'yyyy-mm-dd') hos_CreateTime,hos_visible FROM Vet_hospital WHERE hos_MemId = ? order by hos_MemId";

	//====以下是新增指令====
	private static final String UPDATE_HOS_NAME =" UPDATE vet_hospital set HOS_NAME=?  WHERE hos_Id=? " ; 
	private static final String UPDATE_HOS_CITY =" UPDATE vet_hospital set HOS_CITY=?  WHERE hos_Id=? " ; 
	private static final String UPDATE_HOS_TOWN =" UPDATE vet_hospital set HOS_TOWN=?  WHERE hos_Id=? " ; 
	private static final String UPDATE_HOS_ROAD =" UPDATE vet_hospital set HOS_ROAD=?  WHERE hos_Id=? " ; 
	private static final String UPDATE_HOS_EVAL =" UPDATE vet_hospital set HOS_EVAL=?  WHERE hos_Id=? " ; 
	private static final String UPDATE_HOS_URL =" UPDATE vet_hospital set HOS_URL=?  WHERE hos_Id=? " ; 
	private static final String UPDATE_HOS_STARTTIME =" UPDATE vet_hospital set HOS_STARTTIME=?  WHERE hos_Id=? " ; 
	private static final String UPDATE_HOS_ENDTIME =" UPDATE vet_hospital set HOS_ENDTIME=?  WHERE hos_Id=? " ; 
	private static final String UPDATE_HOS_TEL =" UPDATE vet_hospital set HOS_TEL=?  WHERE hos_Id=? " ; 
	private static final String UPDATE_HOS_DESC =" UPDATE vet_hospital set HOS_DESC=?  WHERE hos_Id=? " ; 
	private static final String UPDATE_HOS_LONG =" UPDATE vet_hospital set HOS_LONG=?  WHERE hos_Id=? " ; 
	private static final String UPDATE_HOS_LAT =" UPDATE vet_hospital set HOS_LAT=?  WHERE hos_Id=? " ; 
	private static final String UPDATE_HOS_CREATETIME =" UPDATE vet_hospital set HOS_CREATETIME=?  WHERE hos_Id=? " ; 
	private static final String UPDATE_HOS_VISIBLE =" UPDATE vet_hospital set HOS_VISIBLE=?  WHERE hos_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Vet_hospitalVO aVet_hospitalVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Vet_hospitalDAO.INSERT_STMT);
			pstmt.setString (1, aVet_hospitalVO.getHos_MemId());
			pstmt.setString (2, aVet_hospitalVO.getHos_name());
			pstmt.setString (3, aVet_hospitalVO.getHos_city());
			pstmt.setString (4, aVet_hospitalVO.getHos_town());
			pstmt.setString (5, aVet_hospitalVO.getHos_road());
			pstmt.setInt (6, aVet_hospitalVO.getHos_Eval());
			pstmt.setString (7, aVet_hospitalVO.getHos_URL());
			pstmt.setString (8, aVet_hospitalVO.getHos_StartTime());
			pstmt.setString (9, aVet_hospitalVO.getHos_EndTime());
			pstmt.setString (10, aVet_hospitalVO.getHos_Tel());
			pstmt.setString (11, aVet_hospitalVO.getHos_Desc());
			pstmt.setDouble (12, aVet_hospitalVO.getHos_Long());
			pstmt.setDouble (13, aVet_hospitalVO.getHos_Lat());
			pstmt.setDate (14, aVet_hospitalVO.getHos_CreateTime());
			pstmt.setString (15, aVet_hospitalVO.getHos_visible());
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
	public void update(Vet_hospitalVO aVet_hospitalVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Vet_hospitalDAO.UPDATE);
			pstmt.setString (1, aVet_hospitalVO.getHos_name());
			pstmt.setString (2, aVet_hospitalVO.getHos_city());
			pstmt.setString (3, aVet_hospitalVO.getHos_town());
			pstmt.setString (4, aVet_hospitalVO.getHos_road());
			pstmt.setInt (5, aVet_hospitalVO.getHos_Eval());
			pstmt.setString (6, aVet_hospitalVO.getHos_URL());
			pstmt.setString (7, aVet_hospitalVO.getHos_StartTime());
			pstmt.setString (8, aVet_hospitalVO.getHos_EndTime());
			pstmt.setString (9, aVet_hospitalVO.getHos_Tel());
			pstmt.setString (10, aVet_hospitalVO.getHos_Desc());
			pstmt.setDouble (11, aVet_hospitalVO.getHos_Long());
			pstmt.setDouble (12, aVet_hospitalVO.getHos_Lat());
			pstmt.setDate (13, aVet_hospitalVO.getHos_CreateTime());
			pstmt.setString (14, aVet_hospitalVO.getHos_visible());
			pstmt.setString (15, aVet_hospitalVO.getHos_Id());
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
	public void delete(String  aVet_hospital){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Vet_hospitalDAO.DELETE);
			pstmt.setString (1,aVet_hospital);
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
	public Vet_hospitalVO findByPrimaryKey(String  aPK_NO){
		Vet_hospitalVO vet_hospitalVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Vet_hospitalDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vet_hospitalVO = new Vet_hospitalVO();
				vet_hospitalVO.setHos_Id(rs.getString("hos_Id"));
				vet_hospitalVO.setHos_MemId(rs.getString("hos_MemId"));
				vet_hospitalVO.setHos_name(rs.getString("hos_name"));
				vet_hospitalVO.setHos_city(rs.getString("hos_city"));
				vet_hospitalVO.setHos_town(rs.getString("hos_town"));
				vet_hospitalVO.setHos_road(rs.getString("hos_road"));
				vet_hospitalVO.setHos_Eval(rs.getInt("hos_Eval"));
				vet_hospitalVO.setHos_URL(rs.getString("hos_URL"));
				vet_hospitalVO.setHos_StartTime(rs.getString("hos_StartTime"));
				vet_hospitalVO.setHos_EndTime(rs.getString("hos_EndTime"));
				vet_hospitalVO.setHos_Tel(rs.getString("hos_Tel"));
				vet_hospitalVO.setHos_Desc(rs.getString("hos_Desc"));
				vet_hospitalVO.setHos_Long(rs.getDouble("hos_Long"));
				vet_hospitalVO.setHos_Lat(rs.getDouble("hos_Lat"));
				vet_hospitalVO.setHos_CreateTime(rs.getDate("hos_CreateTime"));
				vet_hospitalVO.setHos_visible(rs.getString("hos_visible"));
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
		return vet_hospitalVO; 
	} 

    @Override
    public List<Vet_hospitalVO> getAll() {
        List<Vet_hospitalVO> list = new ArrayList<Vet_hospitalVO>();
        Vet_hospitalVO vet_hospitalVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // vet_hospitalVO 也稱為 Domain objects
                vet_hospitalVO = new Vet_hospitalVO();
                vet_hospitalVO.setHos_Id(rs.getString("hos_Id"));
                vet_hospitalVO.setHos_MemId(rs.getString("hos_MemId"));
                vet_hospitalVO.setHos_name(rs.getString("hos_name"));
                vet_hospitalVO.setHos_city(rs.getString("hos_city"));
                vet_hospitalVO.setHos_town(rs.getString("hos_town"));
                vet_hospitalVO.setHos_road(rs.getString("hos_road"));
                vet_hospitalVO.setHos_Eval(rs.getInt("hos_Eval"));
                vet_hospitalVO.setHos_URL(rs.getString("hos_URL"));
                vet_hospitalVO.setHos_StartTime(rs.getString("hos_StartTime"));
                vet_hospitalVO.setHos_EndTime(rs.getString("hos_EndTime"));
                vet_hospitalVO.setHos_Tel(rs.getString("hos_Tel"));
                vet_hospitalVO.setHos_Desc(rs.getString("hos_Desc"));
                vet_hospitalVO.setHos_Long(rs.getDouble("hos_Long"));
                vet_hospitalVO.setHos_Lat(rs.getDouble("hos_Lat"));
                vet_hospitalVO.setHos_CreateTime(rs.getDate("hos_CreateTime"));
                vet_hospitalVO.setHos_visible(rs.getString("hos_visible"));

                list.add(vet_hospitalVO); // Store the row in the vector
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
    public List<Vet_hospitalVO> getAll(Map<String, String[]> map) {
        List<Vet_hospitalVO> list = new ArrayList<Vet_hospitalVO>();
        Vet_hospitalVO vet_hospitalVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Vet_hospital "
                  + jdbcUtil_CompositeQuery_Vet_hospital.get_WhereCondition(map)
                  + "order by hos_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                vet_hospitalVO = new Vet_hospitalVO();
                
                vet_hospitalVO.setHos_Id(rs.getString ("hos_Id"));
                vet_hospitalVO.setHos_MemId(rs.getString ("hos_MemId"));
                vet_hospitalVO.setHos_name(rs.getString ("hos_name"));
                vet_hospitalVO.setHos_city(rs.getString ("hos_city"));
                vet_hospitalVO.setHos_town(rs.getString ("hos_town"));
                vet_hospitalVO.setHos_road(rs.getString ("hos_road"));
                vet_hospitalVO.setHos_Eval(rs.getInt ("hos_Eval"));
                vet_hospitalVO.setHos_URL(rs.getString ("hos_URL"));
                vet_hospitalVO.setHos_StartTime(rs.getString ("hos_StartTime"));
                vet_hospitalVO.setHos_EndTime(rs.getString ("hos_EndTime"));
                vet_hospitalVO.setHos_Tel(rs.getString ("hos_Tel"));
                vet_hospitalVO.setHos_Desc(rs.getString ("hos_Desc"));
                vet_hospitalVO.setHos_Long(rs.getDouble ("hos_Long"));
                vet_hospitalVO.setHos_Lat(rs.getDouble ("hos_Lat"));
                vet_hospitalVO.setHos_CreateTime(rs.getDate ("hos_CreateTime"));
                vet_hospitalVO.setHos_visible(rs.getString ("hos_visible"));
             
                list.add(vet_hospitalVO); // Store the row in the List
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
    public Set<Vet_hospitalVO> getVet_hospitalsByMem_Id(String hos_MemId) {
        Set<Vet_hospitalVO> set = new LinkedHashSet<Vet_hospitalVO>();
        Vet_hospitalVO vet_hospitalVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Vet_hospitals_ByMem_Id_STMT);
            pstmt.setString(1, hos_MemId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                vet_hospitalVO = new Vet_hospitalVO();
				vet_hospitalVO.setHos_Id(rs.getString ("hos_Id"));
				vet_hospitalVO.setHos_MemId(rs.getString ("hos_MemId"));
				vet_hospitalVO.setHos_name(rs.getString ("hos_name"));
				vet_hospitalVO.setHos_city(rs.getString ("hos_city"));
				vet_hospitalVO.setHos_town(rs.getString ("hos_town"));
				vet_hospitalVO.setHos_road(rs.getString ("hos_road"));
				vet_hospitalVO.setHos_Eval(rs.getInt ("hos_Eval"));
				vet_hospitalVO.setHos_URL(rs.getString ("hos_URL"));
				vet_hospitalVO.setHos_StartTime(rs.getString ("hos_StartTime"));
				vet_hospitalVO.setHos_EndTime(rs.getString ("hos_EndTime"));
				vet_hospitalVO.setHos_Tel(rs.getString ("hos_Tel"));
				vet_hospitalVO.setHos_Desc(rs.getString ("hos_Desc"));
				vet_hospitalVO.setHos_Long(rs.getDouble ("hos_Long"));
				vet_hospitalVO.setHos_Lat(rs.getDouble ("hos_Lat"));
				vet_hospitalVO.setHos_CreateTime(rs.getDate ("hos_CreateTime"));
				vet_hospitalVO.setHos_visible(rs.getString ("hos_visible"));

                set.add(vet_hospitalVO); // Store the row in the vector
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