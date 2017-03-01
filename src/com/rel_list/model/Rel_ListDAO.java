package com.rel_list.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	關係名單<br>
 *	英文:rel_List<br>
 */ 
public class Rel_ListDAO implements Rel_ListDAO_interface{
	private static DataSource ds = null; 
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB_dream");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO rel_List(rel_MemId,added_MemId,isBlackList,isInvited ) VALUES  ( ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE rel_List SET rel_MemId=?,added_MemId=?,isBlackList=?,isInvited=? WHERE rel_MemId=? AND added_MemId=?" ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM rel_List WHERE =? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT rel_MemId,added_MemId,isBlackList,isInvited FROM rel_list WHERE =? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT rel_MemId,added_MemId,isBlackList,isInvited FROM rel_List order by  " ; 
	//====以下是新增指令====
	private static final String UPDATE_ISBLACKLIST =" UPDATE rel_List set ISBLACKLIST=?  WHERE rel_MemId=? " ; 
	private static final String UPDATE_ISINVITED =" UPDATE rel_List set ISINVITED=?  WHERE rel_MemId=? " ; 
	
	private static final String GET_REL_LIST_BY_REL_MEMID_STMT = "SELECT rel_MemId,added_MemId,isBlackList,isInvited FROM rel_list WHERE rel_MemId=? ";
	private static final String GET_REL_LIST_BY_ADDED_MEMID_STMT = "SELECT rel_MemId,added_MemId,isBlackList,isInvited FROM rel_list WHERE added_MemId=? ";
	private static final String FIND_BY_PRIME_KEY_STMT="SELECT rel_MemId,added_MemId,isBlackList,isInvited FROM rel_list WHERE rel_MemId=? AND added_MemId=? ";
	
	
	//====以下是改寫insert方法====
	@Override
	public void insert(Rel_ListVO aRel_ListVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(Rel_ListDAO.INSERT_STMT);
			pstmt.setString (1, aRel_ListVO.getRel_MemId());
			pstmt.setString (2, aRel_ListVO.getAdded_MemId());
			pstmt.setString (3, aRel_ListVO.getIsBlackList());
			pstmt.setString (4, aRel_ListVO.getIsInvited());
			pstmt.executeUpdate();
			
			con.commit();
		} catch (SQLException se) {
			se.printStackTrace();
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
	} 
	//====以下是改寫update方法====
	@Override
	public void update(Rel_ListVO aRel_ListVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(Rel_ListDAO.UPDATE);
			pstmt.setString (1, aRel_ListVO.getRel_MemId());
			pstmt.setString (2, aRel_ListVO.getAdded_MemId());
			pstmt.setString (3, aRel_ListVO.getIsBlackList());
			pstmt.setString (4, aRel_ListVO.getIsInvited());
			pstmt.setString (5, aRel_ListVO.getRel_MemId());
			pstmt.setString (6, aRel_ListVO.getAdded_MemId());
			pstmt.executeUpdate();
			
			con.commit();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
	} 
	//====以下是改寫delete方法====
	@Override
	public void delete_By_rel_MemId(String  aRel_List){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Rel_ListDAO.DELETE);
			pstmt.setString (1,aRel_List);
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
	public Rel_ListVO findByPrimaryKey(String rel_MemId, String added_mimId){
		Rel_ListVO rel_listVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Rel_ListDAO.FIND_BY_PRIME_KEY_STMT);
			pstmt.setString (1,rel_MemId);
			pstmt.setString (2,added_mimId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				rel_listVO = new Rel_ListVO();
				rel_listVO.setRel_MemId(rs.getString("rel_MemId"));
				rel_listVO.setAdded_MemId(rs.getString("added_MemId"));
				rel_listVO.setIsBlackList(rs.getString("isBlackList"));
				rel_listVO.setIsInvited(rs.getString("isInvited"));
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
		return rel_listVO; 
	} 
	//====以下是改寫findByPrimaryKey方法====
	@Override
	public Rel_ListVO findByPrimaryKey_By_added_MemId(String  aPK_NO){
		Rel_ListVO rel_listVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Rel_ListDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				rel_listVO = new Rel_ListVO();
				rel_listVO.setRel_MemId(rs.getString("rel_MemId"));
				rel_listVO.setAdded_MemId(rs.getString("added_MemId"));
				rel_listVO.setIsBlackList(rs.getString("isBlackList"));
				rel_listVO.setIsInvited(rs.getString("isInvited"));
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
		return rel_listVO; 
	} 

    @Override
    public List<Rel_ListVO> getAll() {
        List<Rel_ListVO> list = new ArrayList<Rel_ListVO>();
        Rel_ListVO rel_listVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // rel_listVO 也稱為 Domain objects
                rel_listVO = new Rel_ListVO();
                rel_listVO.setRel_MemId(rs.getString("rel_MemId"));
                rel_listVO.setAdded_MemId(rs.getString("added_MemId"));
                rel_listVO.setIsBlackList(rs.getString("isBlackList"));
                rel_listVO.setIsInvited(rs.getString("isInvited"));

                list.add(rel_listVO); // Store the row in the vector
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
	public Set<Rel_ListVO> getRel_ListByRel_MemId(String rel_MemId) {
		Set<Rel_ListVO> list = new LinkedHashSet<Rel_ListVO>();
        Rel_ListVO rel_listVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
        	
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_REL_LIST_BY_REL_MEMID_STMT);
            
            pstmt.setString(1, rel_MemId);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // rel_listVO 也稱為 Domain objects
                rel_listVO = new Rel_ListVO();
                rel_listVO.setRel_MemId(rs.getString("rel_MemId"));
                rel_listVO.setAdded_MemId(rs.getString("added_MemId"));
                rel_listVO.setIsBlackList(rs.getString("isBlackList"));
                rel_listVO.setIsInvited(rs.getString("isInvited"));

                list.add(rel_listVO); // Store the row in the vector
            }
            
            
            return list;
                        
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
        
	}
	@Override
	public Set<Rel_ListVO> getRel_ListByAdded_MemId(String added_mem_Id) {
		Set<Rel_ListVO> list = new LinkedHashSet<Rel_ListVO>();
        Rel_ListVO rel_listVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
			System.out.println("added_MemId= "+added_mem_Id);

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_REL_LIST_BY_ADDED_MEMID_STMT);
            
            pstmt.setString(1, added_mem_Id);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // rel_listVO 也稱為 Domain objects
                rel_listVO = new Rel_ListVO();
                rel_listVO.setRel_MemId(rs.getString("rel_MemId"));
                rel_listVO.setAdded_MemId(rs.getString("added_MemId"));
                rel_listVO.setIsBlackList(rs.getString("isBlackList"));
                rel_listVO.setIsInvited(rs.getString("isInvited"));

                list.add(rel_listVO); // Store the row in the vector
            }
            
            
            return list;
                        
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
	}
	@Override
	public void delete_By_added_MemId(String added_MemId) {
		// TODO Auto-generated method stub
		
	}
	

}