package com.hos_comment.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Hos_comment;
/** 
 *表格名稱 : <br>
 *	診所留言<br>
 *	英文:hos_comment<br>
 */ 
public class Hos_commentDAO implements Hos_commentDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO hos_comment(hosComment_Id,hosComment_MemId,hosComment_HosId,hosComment_content,hosComment_SendTime ) VALUES  ( hos_comment_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE hos_comment SET hosComment_content=?,hosComment_SendTime=?  WHERE hosComment_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM hos_comment WHERE hosComment_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT hosComment_Id,hosComment_MemId,hosComment_HosId,hosComment_content,to_char(hosComment_SendTime,'yyyy-mm-dd') hosComment_SendTime FROM hos_comment WHERE hosComment_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT hosComment_Id,hosComment_MemId,hosComment_HosId,hosComment_content,to_char(hosComment_SendTime,'yyyy-mm-dd') hosComment_SendTime FROM hos_comment order by hosComment_Id " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Hos_comments_ByMem_Id_STMT = 
		"SELECT hosComment_Id,hosComment_MemId,hosComment_HosId,hosComment_content,to_char(hosComment_SendTime,'yyyy-mm-dd') hosComment_SendTime FROM Hos_comment WHERE hosComment_MemId = ? order by hosComment_MemId";
    private static final String GET_Hos_comments_ByHos_Id_STMT = 
		"SELECT hosComment_Id,hosComment_MemId,hosComment_HosId,hosComment_content,to_char(hosComment_SendTime,'yyyy-mm-dd') hosComment_SendTime FROM Hos_comment WHERE hosComment_HosId = ? order by hosComment_HosId";

	//====以下是新增指令====
	private static final String UPDATE_HOSCOMMENT_CONTENT =" UPDATE hos_comment set HOSCOMMENT_CONTENT=?  WHERE hosComment_Id=? " ; 
	private static final String UPDATE_HOSCOMMENT_SENDTIME =" UPDATE hos_comment set HOSCOMMENT_SENDTIME=?  WHERE hosComment_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Hos_commentVO aHos_commentVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Hos_commentDAO.INSERT_STMT);
			pstmt.setString (1, aHos_commentVO.getHosComment_MemId());
			pstmt.setString (2, aHos_commentVO.getHosComment_HosId());
			pstmt.setString (3, aHos_commentVO.getHosComment_content());
			pstmt.setDate (4, aHos_commentVO.getHosComment_SendTime());
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
	public void update(Hos_commentVO aHos_commentVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Hos_commentDAO.UPDATE);
			pstmt.setString (1, aHos_commentVO.getHosComment_content());
			pstmt.setDate (2, aHos_commentVO.getHosComment_SendTime());
			pstmt.setString (3, aHos_commentVO.getHosComment_Id());
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
	public void delete(String  aHos_comment){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Hos_commentDAO.DELETE);
			pstmt.setString (1,aHos_comment);
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
	public Hos_commentVO findByPrimaryKey(String  aPK_NO){
		Hos_commentVO hos_commentVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Hos_commentDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				hos_commentVO = new Hos_commentVO();
				hos_commentVO.setHosComment_Id(rs.getString("hosComment_Id"));
				hos_commentVO.setHosComment_MemId(rs.getString("hosComment_MemId"));
				hos_commentVO.setHosComment_HosId(rs.getString("hosComment_HosId"));
				hos_commentVO.setHosComment_content(rs.getString("hosComment_content"));
				hos_commentVO.setHosComment_SendTime(rs.getDate("hosComment_SendTime"));
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
		return hos_commentVO; 
	} 

    @Override
    public List<Hos_commentVO> getAll() {
        List<Hos_commentVO> list = new ArrayList<Hos_commentVO>();
        Hos_commentVO hos_commentVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // hos_commentVO 也稱為 Domain objects
                hos_commentVO = new Hos_commentVO();
                hos_commentVO.setHosComment_Id(rs.getString("hosComment_Id"));
                hos_commentVO.setHosComment_MemId(rs.getString("hosComment_MemId"));
                hos_commentVO.setHosComment_HosId(rs.getString("hosComment_HosId"));
                hos_commentVO.setHosComment_content(rs.getString("hosComment_content"));
                hos_commentVO.setHosComment_SendTime(rs.getDate("hosComment_SendTime"));

                list.add(hos_commentVO); // Store the row in the vector
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
    public List<Hos_commentVO> getAll(Map<String, String[]> map) {
        List<Hos_commentVO> list = new ArrayList<Hos_commentVO>();
        Hos_commentVO hos_commentVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Hos_comment "
                  + jdbcUtil_CompositeQuery_Hos_comment.get_WhereCondition(map)
                  + "order by hosComment_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                hos_commentVO = new Hos_commentVO();
                
                hos_commentVO.setHosComment_Id(rs.getString ("hosComment_Id"));
                hos_commentVO.setHosComment_MemId(rs.getString ("hosComment_MemId"));
                hos_commentVO.setHosComment_HosId(rs.getString ("hosComment_HosId"));
                hos_commentVO.setHosComment_content(rs.getString ("hosComment_content"));
                hos_commentVO.setHosComment_SendTime(rs.getDate ("hosComment_SendTime"));
             
                list.add(hos_commentVO); // Store the row in the List
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
    public Set<Hos_commentVO> getHos_commentsByMem_Id(String hosComment_MemId) {
        Set<Hos_commentVO> set = new LinkedHashSet<Hos_commentVO>();
        Hos_commentVO hos_commentVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Hos_comments_ByMem_Id_STMT);
            pstmt.setString(1, hosComment_MemId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                hos_commentVO = new Hos_commentVO();
				hos_commentVO.setHosComment_Id(rs.getString ("hosComment_Id"));
				hos_commentVO.setHosComment_MemId(rs.getString ("hosComment_MemId"));
				hos_commentVO.setHosComment_HosId(rs.getString ("hosComment_HosId"));
				hos_commentVO.setHosComment_content(rs.getString ("hosComment_content"));
				hos_commentVO.setHosComment_SendTime(rs.getDate ("hosComment_SendTime"));

                set.add(hos_commentVO); // Store the row in the vector
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
    public Set<Hos_commentVO> getHos_commentsByHos_Id(String hosComment_HosId) {
        Set<Hos_commentVO> set = new LinkedHashSet<Hos_commentVO>();
        Hos_commentVO hos_commentVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Hos_comments_ByHos_Id_STMT);
            pstmt.setString(1, hosComment_HosId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                hos_commentVO = new Hos_commentVO();
				hos_commentVO.setHosComment_Id(rs.getString ("hosComment_Id"));
				hos_commentVO.setHosComment_MemId(rs.getString ("hosComment_MemId"));
				hos_commentVO.setHosComment_HosId(rs.getString ("hosComment_HosId"));
				hos_commentVO.setHosComment_content(rs.getString ("hosComment_content"));
				hos_commentVO.setHosComment_SendTime(rs.getDate ("hosComment_SendTime"));

                set.add(hos_commentVO); // Store the row in the vector
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