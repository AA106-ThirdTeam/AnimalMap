package com.joinlist.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_JoinList;
/** 
 *表格名稱 : <br>
 *	揪團參加名單<br>
 *	英文:JoinList<br>
 */ 
public class JoinListDAO implements JoinListDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO JoinList(joinList_GrpId,joinList_MemId ) VALUES  ( ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE JoinList SET  WHERE =? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM JoinList WHERE =? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT joinList_GrpId,joinList_MemId FROM joinlist WHERE =? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT joinList_GrpId,joinList_MemId FROM JoinList order by  " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_JoinLists_ByGrp_Id_STMT = 
		"SELECT joinList_GrpId,joinList_MemId FROM JoinList WHERE joinList_GrpId = ? order by joinList_GrpId";
    private static final String GET_JoinLists_ByMem_Id_STMT = 
		"SELECT joinList_GrpId,joinList_MemId FROM JoinList WHERE joinList_MemId = ? order by joinList_MemId";

	//====以下是新增指令====
	//====以下是改寫insert方法====
	@Override
	public void insert(JoinListVO aJoinListVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(JoinListDAO.INSERT_STMT);
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
	public void update(JoinListVO aJoinListVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(JoinListDAO.UPDATE);
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
	public void delete_By_joinList_GrpId(String  aJoinList){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(JoinListDAO.DELETE);
			pstmt.setString (1,aJoinList);
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
	public void delete_By_joinList_MemId(String  aJoinList){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(JoinListDAO.DELETE);
			pstmt.setString (1,aJoinList);
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
	public JoinListVO findByPrimaryKey_By_joinList_GrpId(String  aPK_NO){
		JoinListVO joinlistVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(JoinListDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				joinlistVO = new JoinListVO();
				joinlistVO.setJoinList_GrpId(rs.getString("joinList_GrpId"));
				joinlistVO.setJoinList_MemId(rs.getString("joinList_MemId"));
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
		return joinlistVO; 
	} 
	//====以下是改寫findByPrimaryKey方法====
	@Override
	public JoinListVO findByPrimaryKey_By_joinList_MemId(String  aPK_NO){
		JoinListVO joinlistVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(JoinListDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				joinlistVO = new JoinListVO();
				joinlistVO.setJoinList_GrpId(rs.getString("joinList_GrpId"));
				joinlistVO.setJoinList_MemId(rs.getString("joinList_MemId"));
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
		return joinlistVO; 
	} 

    @Override
    public List<JoinListVO> getAll() {
        List<JoinListVO> list = new ArrayList<JoinListVO>();
        JoinListVO joinlistVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // joinlistVO 也稱為 Domain objects
                joinlistVO = new JoinListVO();
                joinlistVO.setJoinList_GrpId(rs.getString("joinList_GrpId"));
                joinlistVO.setJoinList_MemId(rs.getString("joinList_MemId"));

                list.add(joinlistVO); // Store the row in the vector
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
    public List<JoinListVO> getAll(Map<String, String[]> map) {
        List<JoinListVO> list = new ArrayList<JoinListVO>();
        JoinListVO joinlistVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from JoinList "
                  + jdbcUtil_CompositeQuery_JoinList.get_WhereCondition(map)
                  + "order by {PK英文名稱}";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                joinlistVO = new JoinListVO();
                
                joinlistVO.setJoinList_GrpId(rs.getString ("joinList_GrpId"));
                joinlistVO.setJoinList_MemId(rs.getString ("joinList_MemId"));
             
                list.add(joinlistVO); // Store the row in the List
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
    public Set<JoinListVO> getJoinListsByGrp_Id(String joinList_GrpId) {
        Set<JoinListVO> set = new LinkedHashSet<JoinListVO>();
        JoinListVO joinlistVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_JoinLists_ByGrp_Id_STMT);
            pstmt.setString(1, joinList_GrpId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                joinlistVO = new JoinListVO();
				joinlistVO.setJoinList_GrpId(rs.getString ("joinList_GrpId"));
				joinlistVO.setJoinList_MemId(rs.getString ("joinList_MemId"));

                set.add(joinlistVO); // Store the row in the vector
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
    public Set<JoinListVO> getJoinListsByMem_Id(String joinList_MemId) {
        Set<JoinListVO> set = new LinkedHashSet<JoinListVO>();
        JoinListVO joinlistVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_JoinLists_ByMem_Id_STMT);
            pstmt.setString(1, joinList_MemId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                joinlistVO = new JoinListVO();
				joinlistVO.setJoinList_GrpId(rs.getString ("joinList_GrpId"));
				joinlistVO.setJoinList_MemId(rs.getString ("joinList_MemId"));

                set.add(joinlistVO); // Store the row in the vector
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