package com.adoanispo.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_AdoAniSpo;
/** 
 *表格名稱 : <br>
 *	送養動物領養人<br>
 *	英文:adoAniSpo<br>
 */ 
public class AdoAniSpoDAO implements AdoAniSpoDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO adoAniSpo(adoAniSpoNo,adoAniSpoAniId,adoAniSpomem_Id,adoAniSpoMoney,adoAniSpoMat ) VALUES  ( adoAniSpo_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE adoAniSpo SET adoAniSpoMoney=?,adoAniSpoMat=?  WHERE adoAniSpoNo=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM adoAniSpo WHERE adoAniSpoNo=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT adoAniSpoNo,adoAniSpoAniId,adoAniSpomem_Id,adoAniSpoMoney,adoAniSpoMat FROM adoanispo WHERE adoAniSpoNo=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT adoAniSpoNo,adoAniSpoAniId,adoAniSpomem_Id,adoAniSpoMoney,adoAniSpoMat FROM adoAniSpo order by adoAniSpoNo " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_AdoAniSpos_ByAdopt_Ani_Id_STMT = 
		"SELECT adoAniSpoNo,adoAniSpoAniId,adoAniSpomem_Id,adoAniSpoMoney,adoAniSpoMat FROM AdoAniSpo WHERE adoAniSpoAniId = ? order by adoAniSpoAniId";
    private static final String GET_AdoAniSpos_ByMem_Id_STMT = 
		"SELECT adoAniSpoNo,adoAniSpoAniId,adoAniSpomem_Id,adoAniSpoMoney,adoAniSpoMat FROM AdoAniSpo WHERE adoAniSpomem_Id = ? order by adoAniSpomem_Id";

	//====以下是新增指令====
	private static final String UPDATE_ADOANISPOMONEY =" UPDATE adoAniSpo set ADOANISPOMONEY=?  WHERE adoAniSpoNo=? " ; 
	private static final String UPDATE_ADOANISPOMAT =" UPDATE adoAniSpo set ADOANISPOMAT=?  WHERE adoAniSpoNo=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(AdoAniSpoVO aAdoAniSpoVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdoAniSpoDAO.INSERT_STMT);
			pstmt.setString (1, aAdoAniSpoVO.getAdoAniSpoAniId());
			pstmt.setString (2, aAdoAniSpoVO.getAdoAniSpomem_Id());
			pstmt.setInt (3, aAdoAniSpoVO.getAdoAniSpoMoney());
			pstmt.setString (4, aAdoAniSpoVO.getAdoAniSpoMat());
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
	public void update(AdoAniSpoVO aAdoAniSpoVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdoAniSpoDAO.UPDATE);
			pstmt.setInt (1, aAdoAniSpoVO.getAdoAniSpoMoney());
			pstmt.setString (2, aAdoAniSpoVO.getAdoAniSpoMat());
			pstmt.setString (3, aAdoAniSpoVO.getAdoAniSpoNo());
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
	public void delete(String  aAdoAniSpo){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdoAniSpoDAO.DELETE);
			pstmt.setString (1,aAdoAniSpo);
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
	public AdoAniSpoVO findByPrimaryKey(String  aPK_NO){
		AdoAniSpoVO adoanispoVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdoAniSpoDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				adoanispoVO = new AdoAniSpoVO();
				adoanispoVO.setAdoAniSpoNo(rs.getString("adoAniSpoNo"));
				adoanispoVO.setAdoAniSpoAniId(rs.getString("adoAniSpoAniId"));
				adoanispoVO.setAdoAniSpomem_Id(rs.getString("adoAniSpomem_Id"));
				adoanispoVO.setAdoAniSpoMoney(rs.getInt("adoAniSpoMoney"));
				adoanispoVO.setAdoAniSpoMat(rs.getString("adoAniSpoMat"));
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
		return adoanispoVO; 
	} 

    @Override
    public List<AdoAniSpoVO> getAll() {
        List<AdoAniSpoVO> list = new ArrayList<AdoAniSpoVO>();
        AdoAniSpoVO adoanispoVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // adoanispoVO 也稱為 Domain objects
                adoanispoVO = new AdoAniSpoVO();
                adoanispoVO.setAdoAniSpoNo(rs.getString("adoAniSpoNo"));
                adoanispoVO.setAdoAniSpoAniId(rs.getString("adoAniSpoAniId"));
                adoanispoVO.setAdoAniSpomem_Id(rs.getString("adoAniSpomem_Id"));
                adoanispoVO.setAdoAniSpoMoney(rs.getInt("adoAniSpoMoney"));
                adoanispoVO.setAdoAniSpoMat(rs.getString("adoAniSpoMat"));

                list.add(adoanispoVO); // Store the row in the vector
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
    public List<AdoAniSpoVO> getAll(Map<String, String[]> map) {
        List<AdoAniSpoVO> list = new ArrayList<AdoAniSpoVO>();
        AdoAniSpoVO adoanispoVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from AdoAniSpo "
                  + jdbcUtil_CompositeQuery_AdoAniSpo.get_WhereCondition(map)
                  + "order by adoAniSpoNo";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                adoanispoVO = new AdoAniSpoVO();
                
                adoanispoVO.setAdoAniSpoNo(rs.getString ("adoAniSpoNo"));
                adoanispoVO.setAdoAniSpoAniId(rs.getString ("adoAniSpoAniId"));
                adoanispoVO.setAdoAniSpomem_Id(rs.getString ("adoAniSpomem_Id"));
                adoanispoVO.setAdoAniSpoMoney(rs.getInt ("adoAniSpoMoney"));
                adoanispoVO.setAdoAniSpoMat(rs.getString ("adoAniSpoMat"));
             
                list.add(adoanispoVO); // Store the row in the List
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
    public Set<AdoAniSpoVO> getAdoAniSposByAdopt_Ani_Id(String adoAniSpoAniId) {
        Set<AdoAniSpoVO> set = new LinkedHashSet<AdoAniSpoVO>();
        AdoAniSpoVO adoanispoVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_AdoAniSpos_ByAdopt_Ani_Id_STMT);
            pstmt.setString(1, adoAniSpoAniId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                adoanispoVO = new AdoAniSpoVO();
				adoanispoVO.setAdoAniSpoNo(rs.getString ("adoAniSpoNo"));
				adoanispoVO.setAdoAniSpoAniId(rs.getString ("adoAniSpoAniId"));
				adoanispoVO.setAdoAniSpomem_Id(rs.getString ("adoAniSpomem_Id"));
				adoanispoVO.setAdoAniSpoMoney(rs.getInt ("adoAniSpoMoney"));
				adoanispoVO.setAdoAniSpoMat(rs.getString ("adoAniSpoMat"));

                set.add(adoanispoVO); // Store the row in the vector
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
    public Set<AdoAniSpoVO> getAdoAniSposByMem_Id(String adoAniSpomem_Id) {
        Set<AdoAniSpoVO> set = new LinkedHashSet<AdoAniSpoVO>();
        AdoAniSpoVO adoanispoVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_AdoAniSpos_ByMem_Id_STMT);
            pstmt.setString(1, adoAniSpomem_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                adoanispoVO = new AdoAniSpoVO();
				adoanispoVO.setAdoAniSpoNo(rs.getString ("adoAniSpoNo"));
				adoanispoVO.setAdoAniSpoAniId(rs.getString ("adoAniSpoAniId"));
				adoanispoVO.setAdoAniSpomem_Id(rs.getString ("adoAniSpomem_Id"));
				adoanispoVO.setAdoAniSpoMoney(rs.getInt ("adoAniSpoMoney"));
				adoanispoVO.setAdoAniSpoMat(rs.getString ("adoAniSpoMat"));

                set.add(adoanispoVO); // Store the row in the vector
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