package com.grp_comment.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Grp_comment;
/** 
 *表格名稱 : <br>
 *	揪團留言<br>
 *	英文:grp_comment<br>
 */ 
public class Grp_commentDAO implements Grp_commentDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO grp_comment(grpComment_Id,grpComment_MemId,grpComment_GrpId,grpComment_content,grpComment_SendTime ) VALUES  ( grp_comment_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE grp_comment SET grpComment_content=?,grpComment_SendTime=?  WHERE grpComment_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM grp_comment WHERE grpComment_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT grpComment_Id,grpComment_MemId,grpComment_GrpId,grpComment_content,to_char(grpComment_SendTime,'yyyy-mm-dd') grpComment_SendTime FROM grp_comment WHERE grpComment_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT grpComment_Id,grpComment_MemId,grpComment_GrpId,grpComment_content,to_char(grpComment_SendTime,'yyyy-mm-dd') grpComment_SendTime FROM grp_comment order by grpComment_Id " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Grp_comments_ByMem_Id_STMT = 
		"SELECT grpComment_Id,grpComment_MemId,grpComment_GrpId,grpComment_content,to_char(grpComment_SendTime,'yyyy-mm-dd') grpComment_SendTime FROM Grp_comment WHERE grpComment_MemId = ? order by grpComment_MemId";
    private static final String GET_Grp_comments_ByGrp_Id_STMT = 
		"SELECT grpComment_Id,grpComment_MemId,grpComment_GrpId,grpComment_content,to_char(grpComment_SendTime,'yyyy-mm-dd') grpComment_SendTime FROM Grp_comment WHERE grpComment_GrpId = ? order by grpComment_GrpId";

	//====以下是新增指令====
	private static final String UPDATE_GRPCOMMENT_CONTENT =" UPDATE grp_comment set GRPCOMMENT_CONTENT=?  WHERE grpComment_Id=? " ; 
	private static final String UPDATE_GRPCOMMENT_SENDTIME =" UPDATE grp_comment set GRPCOMMENT_SENDTIME=?  WHERE grpComment_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Grp_commentVO aGrp_commentVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Grp_commentDAO.INSERT_STMT);
			pstmt.setString (1, aGrp_commentVO.getGrpComment_MemId());
			pstmt.setString (2, aGrp_commentVO.getGrpComment_GrpId());
			pstmt.setString (3, aGrp_commentVO.getGrpComment_content());
			pstmt.setDate (4, aGrp_commentVO.getGrpComment_SendTime());
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
	public void update(Grp_commentVO aGrp_commentVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Grp_commentDAO.UPDATE);
			pstmt.setString (1, aGrp_commentVO.getGrpComment_content());
			pstmt.setDate (2, aGrp_commentVO.getGrpComment_SendTime());
			pstmt.setString (3, aGrp_commentVO.getGrpComment_Id());
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
	public void delete(String  aGrp_comment){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Grp_commentDAO.DELETE);
			pstmt.setString (1,aGrp_comment);
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
	public Grp_commentVO findByPrimaryKey(String  aPK_NO){
		Grp_commentVO grp_commentVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Grp_commentDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				grp_commentVO = new Grp_commentVO();
				grp_commentVO.setGrpComment_Id(rs.getString("grpComment_Id"));
				grp_commentVO.setGrpComment_MemId(rs.getString("grpComment_MemId"));
				grp_commentVO.setGrpComment_GrpId(rs.getString("grpComment_GrpId"));
				grp_commentVO.setGrpComment_content(rs.getString("grpComment_content"));
				grp_commentVO.setGrpComment_SendTime(rs.getDate("grpComment_SendTime"));
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
		return grp_commentVO; 
	} 

    @Override
    public List<Grp_commentVO> getAll() {
        List<Grp_commentVO> list = new ArrayList<Grp_commentVO>();
        Grp_commentVO grp_commentVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // grp_commentVO 也稱為 Domain objects
                grp_commentVO = new Grp_commentVO();
                grp_commentVO.setGrpComment_Id(rs.getString("grpComment_Id"));
                grp_commentVO.setGrpComment_MemId(rs.getString("grpComment_MemId"));
                grp_commentVO.setGrpComment_GrpId(rs.getString("grpComment_GrpId"));
                grp_commentVO.setGrpComment_content(rs.getString("grpComment_content"));
                grp_commentVO.setGrpComment_SendTime(rs.getDate("grpComment_SendTime"));

                list.add(grp_commentVO); // Store the row in the vector
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
    public List<Grp_commentVO> getAll(Map<String, String[]> map) {
        List<Grp_commentVO> list = new ArrayList<Grp_commentVO>();
        Grp_commentVO grp_commentVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Grp_comment "
                  + jdbcUtil_CompositeQuery_Grp_comment.get_WhereCondition(map)
                  + "order by grpComment_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                grp_commentVO = new Grp_commentVO();
                
                grp_commentVO.setGrpComment_Id(rs.getString ("grpComment_Id"));
                grp_commentVO.setGrpComment_MemId(rs.getString ("grpComment_MemId"));
                grp_commentVO.setGrpComment_GrpId(rs.getString ("grpComment_GrpId"));
                grp_commentVO.setGrpComment_content(rs.getString ("grpComment_content"));
                grp_commentVO.setGrpComment_SendTime(rs.getDate ("grpComment_SendTime"));
             
                list.add(grp_commentVO); // Store the row in the List
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
    public Set<Grp_commentVO> getGrp_commentsByMem_Id(String grpComment_MemId) {
        Set<Grp_commentVO> set = new LinkedHashSet<Grp_commentVO>();
        Grp_commentVO grp_commentVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Grp_comments_ByMem_Id_STMT);
            pstmt.setString(1, grpComment_MemId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                grp_commentVO = new Grp_commentVO();
				grp_commentVO.setGrpComment_Id(rs.getString ("grpComment_Id"));
				grp_commentVO.setGrpComment_MemId(rs.getString ("grpComment_MemId"));
				grp_commentVO.setGrpComment_GrpId(rs.getString ("grpComment_GrpId"));
				grp_commentVO.setGrpComment_content(rs.getString ("grpComment_content"));
				grp_commentVO.setGrpComment_SendTime(rs.getDate ("grpComment_SendTime"));

                set.add(grp_commentVO); // Store the row in the vector
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
    public Set<Grp_commentVO> getGrp_commentsByGrp_Id(String grpComment_GrpId) {
        Set<Grp_commentVO> set = new LinkedHashSet<Grp_commentVO>();
        Grp_commentVO grp_commentVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Grp_comments_ByGrp_Id_STMT);
            pstmt.setString(1, grpComment_GrpId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                grp_commentVO = new Grp_commentVO();
				grp_commentVO.setGrpComment_Id(rs.getString ("grpComment_Id"));
				grp_commentVO.setGrpComment_MemId(rs.getString ("grpComment_MemId"));
				grp_commentVO.setGrpComment_GrpId(rs.getString ("grpComment_GrpId"));
				grp_commentVO.setGrpComment_content(rs.getString ("grpComment_content"));
				grp_commentVO.setGrpComment_SendTime(rs.getDate ("grpComment_SendTime"));

                set.add(grp_commentVO); // Store the row in the vector
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