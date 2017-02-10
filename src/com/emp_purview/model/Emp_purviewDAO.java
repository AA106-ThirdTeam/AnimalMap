package com.emp_purview.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Emp_purview;
/** 
 *表格名稱 : <br>
 *	員工權限<br>
 *	英文:emp_purview<br>
 */ 
public class Emp_purviewDAO implements Emp_purviewDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO emp_purview(emp_No,purview_No ) VALUES  ( ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE emp_purview SET  WHERE =? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM emp_purview WHERE =? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT emp_No,purview_No FROM emp_purview WHERE =? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT emp_No,purview_No FROM emp_purview order by  " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Emp_purviews_ByEmp_No_STMT = 
		"SELECT emp_No,purview_No FROM Emp_purview WHERE emp_No = ? order by emp_No";
    private static final String GET_Emp_purviews_ByPurview_No_STMT = 
		"SELECT emp_No,purview_No FROM Emp_purview WHERE purview_No = ? order by purview_No";

	//====以下是新增指令====
	//====以下是改寫insert方法====
	@Override
	public void insert(Emp_purviewVO aEmp_purviewVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emp_purviewDAO.INSERT_STMT);
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
	public void update(Emp_purviewVO aEmp_purviewVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emp_purviewDAO.UPDATE);
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
	public void delete_By_emp_No(String  aEmp_purview){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emp_purviewDAO.DELETE);
			pstmt.setString (1,aEmp_purview);
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
	public void delete_By_purview_No(String  aEmp_purview){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emp_purviewDAO.DELETE);
			pstmt.setString (1,aEmp_purview);
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
	public Emp_purviewVO findByPrimaryKey_By_emp_No(String  aPK_NO){
		Emp_purviewVO emp_purviewVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emp_purviewDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				emp_purviewVO = new Emp_purviewVO();
				emp_purviewVO.setEmp_No(rs.getString("emp_No"));
				emp_purviewVO.setPurview_No(rs.getString("purview_No"));
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
		return emp_purviewVO; 
	} 
	//====以下是改寫findByPrimaryKey方法====
	@Override
	public Emp_purviewVO findByPrimaryKey_By_purview_No(String  aPK_NO){
		Emp_purviewVO emp_purviewVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emp_purviewDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				emp_purviewVO = new Emp_purviewVO();
				emp_purviewVO.setEmp_No(rs.getString("emp_No"));
				emp_purviewVO.setPurview_No(rs.getString("purview_No"));
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
		return emp_purviewVO; 
	} 

    @Override
    public List<Emp_purviewVO> getAll() {
        List<Emp_purviewVO> list = new ArrayList<Emp_purviewVO>();
        Emp_purviewVO emp_purviewVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // emp_purviewVO 也稱為 Domain objects
                emp_purviewVO = new Emp_purviewVO();
                emp_purviewVO.setEmp_No(rs.getString("emp_No"));
                emp_purviewVO.setPurview_No(rs.getString("purview_No"));

                list.add(emp_purviewVO); // Store the row in the vector
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
    public List<Emp_purviewVO> getAll(Map<String, String[]> map) {
        List<Emp_purviewVO> list = new ArrayList<Emp_purviewVO>();
        Emp_purviewVO emp_purviewVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Emp_purview "
                  + jdbcUtil_CompositeQuery_Emp_purview.get_WhereCondition(map)
                  + "order by {PK英文名稱}";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                emp_purviewVO = new Emp_purviewVO();
                
                emp_purviewVO.setEmp_No(rs.getString ("emp_No"));
                emp_purviewVO.setPurview_No(rs.getString ("purview_No"));
             
                list.add(emp_purviewVO); // Store the row in the List
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
    public Set<Emp_purviewVO> getEmp_purviewsByEmp_No(String emp_No) {
        Set<Emp_purviewVO> set = new LinkedHashSet<Emp_purviewVO>();
        Emp_purviewVO emp_purviewVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Emp_purviews_ByEmp_No_STMT);
            pstmt.setString(1, emp_No);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                emp_purviewVO = new Emp_purviewVO();
				emp_purviewVO.setEmp_No(rs.getString ("emp_No"));
				emp_purviewVO.setPurview_No(rs.getString ("purview_No"));

                set.add(emp_purviewVO); // Store the row in the vector
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
    public Set<Emp_purviewVO> getEmp_purviewsByPurview_No(String purview_No) {
        Set<Emp_purviewVO> set = new LinkedHashSet<Emp_purviewVO>();
        Emp_purviewVO emp_purviewVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Emp_purviews_ByPurview_No_STMT);
            pstmt.setString(1, purview_No);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                emp_purviewVO = new Emp_purviewVO();
				emp_purviewVO.setEmp_No(rs.getString ("emp_No"));
				emp_purviewVO.setPurview_No(rs.getString ("purview_No"));

                set.add(emp_purviewVO); // Store the row in the vector
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