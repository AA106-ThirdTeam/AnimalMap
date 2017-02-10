package com.pet_group.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Pet_group;
/** 
 *表格名稱 : <br>
 *	揪團<br>
 *	英文:pet_group<br>
 */ 
public class Pet_groupDAO implements Pet_groupDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO pet_group(grp_Id,grp_MemId,grp_name,grp_city,grp_Addr,grp_road,grp_StartTime,grp_EndTime,grp_Desc,grp_Long,grp_Lat,grp_CreateTime,grp_visible,grp_photo ) VALUES  ( pet_group_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE pet_group SET grp_name=?,grp_city=? ,grp_Addr=? ,grp_road=? ,grp_StartTime=? ,grp_EndTime=? ,grp_Desc=? ,grp_Long=? ,grp_Lat=? ,grp_CreateTime=? ,grp_visible=? ,grp_photo=?  WHERE grp_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM pet_group WHERE grp_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT grp_Id,grp_MemId,grp_name,grp_city,grp_Addr,grp_road,grp_StartTime,grp_EndTime,grp_Desc,grp_Long,grp_Lat,to_char(grp_CreateTime,'yyyy-mm-dd') grp_CreateTime,grp_visible,grp_photo FROM pet_group WHERE grp_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT grp_Id,grp_MemId,grp_name,grp_city,grp_Addr,grp_road,grp_StartTime,grp_EndTime,grp_Desc,grp_Long,grp_Lat,to_char(grp_CreateTime,'yyyy-mm-dd') grp_CreateTime,grp_visible,grp_photo FROM pet_group order by grp_Id " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Pet_groups_ByMem_Id_STMT = 
		"SELECT grp_Id,grp_MemId,grp_name,grp_city,grp_Addr,grp_road,grp_StartTime,grp_EndTime,grp_Desc,grp_Long,grp_Lat,to_char(grp_CreateTime,'yyyy-mm-dd') grp_CreateTime,grp_visible,grp_photo FROM Pet_group WHERE grp_MemId = ? order by grp_MemId";

	//====以下是新增指令====
	private static final String UPDATE_GRP_NAME =" UPDATE pet_group set GRP_NAME=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_CITY =" UPDATE pet_group set GRP_CITY=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_ADDR =" UPDATE pet_group set GRP_ADDR=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_ROAD =" UPDATE pet_group set GRP_ROAD=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_STARTTIME =" UPDATE pet_group set GRP_STARTTIME=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_ENDTIME =" UPDATE pet_group set GRP_ENDTIME=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_DESC =" UPDATE pet_group set GRP_DESC=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_LONG =" UPDATE pet_group set GRP_LONG=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_LAT =" UPDATE pet_group set GRP_LAT=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_CREATETIME =" UPDATE pet_group set GRP_CREATETIME=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_VISIBLE =" UPDATE pet_group set GRP_VISIBLE=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_PHOTO =" UPDATE pet_group set GRP_PHOTO=?  WHERE grp_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Pet_groupVO aPet_groupVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_groupDAO.INSERT_STMT);
			pstmt.setString (1, aPet_groupVO.getGrp_MemId());
			pstmt.setString (2, aPet_groupVO.getGrp_name());
			pstmt.setString (3, aPet_groupVO.getGrp_city());
			pstmt.setString (4, aPet_groupVO.getGrp_Addr());
			pstmt.setString (5, aPet_groupVO.getGrp_road());
			pstmt.setString (6, aPet_groupVO.getGrp_StartTime());
			pstmt.setString (7, aPet_groupVO.getGrp_EndTime());
			pstmt.setString (8, aPet_groupVO.getGrp_Desc());
			pstmt.setDouble (9, aPet_groupVO.getGrp_Long());
			pstmt.setDouble (10, aPet_groupVO.getGrp_Lat());
			pstmt.setDate (11, aPet_groupVO.getGrp_CreateTime());
			pstmt.setString (12, aPet_groupVO.getGrp_visible());
			pstmt.setBytes (13, aPet_groupVO.getGrp_photo());
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
	public void update(Pet_groupVO aPet_groupVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_groupDAO.UPDATE);
			pstmt.setString (1, aPet_groupVO.getGrp_name());
			pstmt.setString (2, aPet_groupVO.getGrp_city());
			pstmt.setString (3, aPet_groupVO.getGrp_Addr());
			pstmt.setString (4, aPet_groupVO.getGrp_road());
			pstmt.setString (5, aPet_groupVO.getGrp_StartTime());
			pstmt.setString (6, aPet_groupVO.getGrp_EndTime());
			pstmt.setString (7, aPet_groupVO.getGrp_Desc());
			pstmt.setDouble (8, aPet_groupVO.getGrp_Long());
			pstmt.setDouble (9, aPet_groupVO.getGrp_Lat());
			pstmt.setDate (10, aPet_groupVO.getGrp_CreateTime());
			pstmt.setString (11, aPet_groupVO.getGrp_visible());
			pstmt.setBytes (12, aPet_groupVO.getGrp_photo());
			pstmt.setString (13, aPet_groupVO.getGrp_Id());
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
	public void delete(String  aPet_group){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_groupDAO.DELETE);
			pstmt.setString (1,aPet_group);
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
	public Pet_groupVO findByPrimaryKey(String  aPK_NO){
		Pet_groupVO pet_groupVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_groupDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pet_groupVO = new Pet_groupVO();
				pet_groupVO.setGrp_Id(rs.getString("grp_Id"));
				pet_groupVO.setGrp_MemId(rs.getString("grp_MemId"));
				pet_groupVO.setGrp_name(rs.getString("grp_name"));
				pet_groupVO.setGrp_city(rs.getString("grp_city"));
				pet_groupVO.setGrp_Addr(rs.getString("grp_Addr"));
				pet_groupVO.setGrp_road(rs.getString("grp_road"));
				pet_groupVO.setGrp_StartTime(rs.getString("grp_StartTime"));
				pet_groupVO.setGrp_EndTime(rs.getString("grp_EndTime"));
				pet_groupVO.setGrp_Desc(rs.getString("grp_Desc"));
				pet_groupVO.setGrp_Long(rs.getDouble("grp_Long"));
				pet_groupVO.setGrp_Lat(rs.getDouble("grp_Lat"));
				pet_groupVO.setGrp_CreateTime(rs.getDate("grp_CreateTime"));
				pet_groupVO.setGrp_visible(rs.getString("grp_visible"));
				pet_groupVO.setGrp_photo(rs.getBytes("grp_photo"));
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
		return pet_groupVO; 
	} 

    @Override
    public List<Pet_groupVO> getAll() {
        List<Pet_groupVO> list = new ArrayList<Pet_groupVO>();
        Pet_groupVO pet_groupVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // pet_groupVO 也稱為 Domain objects
                pet_groupVO = new Pet_groupVO();
                pet_groupVO.setGrp_Id(rs.getString("grp_Id"));
                pet_groupVO.setGrp_MemId(rs.getString("grp_MemId"));
                pet_groupVO.setGrp_name(rs.getString("grp_name"));
                pet_groupVO.setGrp_city(rs.getString("grp_city"));
                pet_groupVO.setGrp_Addr(rs.getString("grp_Addr"));
                pet_groupVO.setGrp_road(rs.getString("grp_road"));
                pet_groupVO.setGrp_StartTime(rs.getString("grp_StartTime"));
                pet_groupVO.setGrp_EndTime(rs.getString("grp_EndTime"));
                pet_groupVO.setGrp_Desc(rs.getString("grp_Desc"));
                pet_groupVO.setGrp_Long(rs.getDouble("grp_Long"));
                pet_groupVO.setGrp_Lat(rs.getDouble("grp_Lat"));
                pet_groupVO.setGrp_CreateTime(rs.getDate("grp_CreateTime"));
                pet_groupVO.setGrp_visible(rs.getString("grp_visible"));
                pet_groupVO.setGrp_photo(rs.getBytes("grp_photo"));

                list.add(pet_groupVO); // Store the row in the vector
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
    public List<Pet_groupVO> getAll(Map<String, String[]> map) {
        List<Pet_groupVO> list = new ArrayList<Pet_groupVO>();
        Pet_groupVO pet_groupVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Pet_group "
                  + jdbcUtil_CompositeQuery_Pet_group.get_WhereCondition(map)
                  + "order by grp_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                pet_groupVO = new Pet_groupVO();
                
                pet_groupVO.setGrp_Id(rs.getString ("grp_Id"));
                pet_groupVO.setGrp_MemId(rs.getString ("grp_MemId"));
                pet_groupVO.setGrp_name(rs.getString ("grp_name"));
                pet_groupVO.setGrp_city(rs.getString ("grp_city"));
                pet_groupVO.setGrp_Addr(rs.getString ("grp_Addr"));
                pet_groupVO.setGrp_road(rs.getString ("grp_road"));
                pet_groupVO.setGrp_StartTime(rs.getString ("grp_StartTime"));
                pet_groupVO.setGrp_EndTime(rs.getString ("grp_EndTime"));
                pet_groupVO.setGrp_Desc(rs.getString ("grp_Desc"));
                pet_groupVO.setGrp_Long(rs.getDouble ("grp_Long"));
                pet_groupVO.setGrp_Lat(rs.getDouble ("grp_Lat"));
                pet_groupVO.setGrp_CreateTime(rs.getDate ("grp_CreateTime"));
                pet_groupVO.setGrp_visible(rs.getString ("grp_visible"));
                pet_groupVO.setGrp_photo(rs.getBytes ("grp_photo"));
             
                list.add(pet_groupVO); // Store the row in the List
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
    public Set<Pet_groupVO> getPet_groupsByMem_Id(String grp_MemId) {
        Set<Pet_groupVO> set = new LinkedHashSet<Pet_groupVO>();
        Pet_groupVO pet_groupVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Pet_groups_ByMem_Id_STMT);
            pstmt.setString(1, grp_MemId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                pet_groupVO = new Pet_groupVO();
				pet_groupVO.setGrp_Id(rs.getString ("grp_Id"));
				pet_groupVO.setGrp_MemId(rs.getString ("grp_MemId"));
				pet_groupVO.setGrp_name(rs.getString ("grp_name"));
				pet_groupVO.setGrp_city(rs.getString ("grp_city"));
				pet_groupVO.setGrp_Addr(rs.getString ("grp_Addr"));
				pet_groupVO.setGrp_road(rs.getString ("grp_road"));
				pet_groupVO.setGrp_StartTime(rs.getString ("grp_StartTime"));
				pet_groupVO.setGrp_EndTime(rs.getString ("grp_EndTime"));
				pet_groupVO.setGrp_Desc(rs.getString ("grp_Desc"));
				pet_groupVO.setGrp_Long(rs.getDouble ("grp_Long"));
				pet_groupVO.setGrp_Lat(rs.getDouble ("grp_Lat"));
				pet_groupVO.setGrp_CreateTime(rs.getDate ("grp_CreateTime"));
				pet_groupVO.setGrp_visible(rs.getString ("grp_visible"));
				pet_groupVO.setGrp_photo(rs.getBytes ("grp_photo"));

                set.add(pet_groupVO); // Store the row in the vector
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