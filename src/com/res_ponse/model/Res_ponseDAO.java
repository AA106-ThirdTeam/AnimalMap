package com.res_ponse.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Res_ponse;
/** 
 *表格名稱 : <br>
 *	討論區留言<br>
 *	英文:res_ponse<br>
 */ 
public class Res_ponseDAO implements Res_ponseDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO res_ponse(res_Id,mem_Id,post_Id,res_ponse_content,post_time,res_ponse_upDate ) VALUES  ( res_ponse_seq1.nextval , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE res_ponse SET res_ponse_content=?,post_time=? ,res_ponse_upDate=?  WHERE res_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM res_ponse WHERE res_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT res_Id,mem_Id,post_Id,res_ponse_content,to_char(post_time,'yyyy-mm-dd') post_time,to_char(res_ponse_upDate,'yyyy-mm-dd') res_ponse_upDate FROM res_ponse WHERE res_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT res_Id,mem_Id,post_Id,res_ponse_content,to_char(post_time,'yyyy-mm-dd') post_time,to_char(res_ponse_upDate,'yyyy-mm-dd') res_ponse_upDate FROM res_ponse order by res_Id " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Res_ponses_ByMem_Id_STMT = 
		"SELECT res_Id,mem_Id,post_Id,res_ponse_content,to_char(post_time,'yyyy-mm-dd') post_time,to_char(res_ponse_upDate,'yyyy-mm-dd') res_ponse_upDate FROM Res_ponse WHERE mem_Id = ? order by mem_Id";
    private static final String GET_Res_ponses_ByPost_Id_STMT = 
		"SELECT res_Id,mem_Id,post_Id,res_ponse_content,to_char(post_time,'yyyy-mm-dd') post_time,to_char(res_ponse_upDate,'yyyy-mm-dd') res_ponse_upDate FROM Res_ponse WHERE post_Id = ? order by post_Id";

	//====以下是新增指令====
	private static final String UPDATE_RES_PONSE_CONTENT =" UPDATE res_ponse set RES_PONSE_CONTENT=?  WHERE res_Id=? " ; 
	private static final String UPDATE_POST_TIME =" UPDATE res_ponse set POST_TIME=?  WHERE res_Id=? " ; 
	private static final String UPDATE_RES_PONSE_UPDATE =" UPDATE res_ponse set RES_PONSE_UPDATE=?  WHERE res_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Res_ponseVO aRes_ponseVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Res_ponseDAO.INSERT_STMT);
			pstmt.setString (1, aRes_ponseVO.getMem_Id());
			pstmt.setString (2, aRes_ponseVO.getPost_Id());
			pstmt.setString (3, aRes_ponseVO.getRes_ponse_content());
			pstmt.setDate (4, aRes_ponseVO.getPost_time());
			pstmt.setDate (5, aRes_ponseVO.getRes_ponse_upDate());
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
	public void update(Res_ponseVO aRes_ponseVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Res_ponseDAO.UPDATE);
			pstmt.setString (1, aRes_ponseVO.getRes_ponse_content());
			pstmt.setDate (2, aRes_ponseVO.getPost_time());
			pstmt.setDate (3, aRes_ponseVO.getRes_ponse_upDate());
			pstmt.setString (4, aRes_ponseVO.getRes_Id());
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
	public void delete(String  aRes_ponse){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Res_ponseDAO.DELETE);
			pstmt.setString (1,aRes_ponse);
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
	public Res_ponseVO findByPrimaryKey(String  aPK_NO){
		Res_ponseVO res_ponseVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Res_ponseDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				res_ponseVO = new Res_ponseVO();
				res_ponseVO.setRes_Id(rs.getString("res_Id"));
				res_ponseVO.setMem_Id(rs.getString("mem_Id"));
				res_ponseVO.setPost_Id(rs.getString("post_Id"));
				res_ponseVO.setRes_ponse_content(rs.getString("res_ponse_content"));
				res_ponseVO.setPost_time(rs.getDate("post_time"));
				res_ponseVO.setRes_ponse_upDate(rs.getDate("res_ponse_upDate"));
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
		return res_ponseVO; 
	} 

    @Override
    public List<Res_ponseVO> getAll() {
        List<Res_ponseVO> list = new ArrayList<Res_ponseVO>();
        Res_ponseVO res_ponseVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // res_ponseVO 也稱為 Domain objects
                res_ponseVO = new Res_ponseVO();
                res_ponseVO.setRes_Id(rs.getString("res_Id"));
                res_ponseVO.setMem_Id(rs.getString("mem_Id"));
                res_ponseVO.setPost_Id(rs.getString("post_Id"));
                res_ponseVO.setRes_ponse_content(rs.getString("res_ponse_content"));
                res_ponseVO.setPost_time(rs.getDate("post_time"));
                res_ponseVO.setRes_ponse_upDate(rs.getDate("res_ponse_upDate"));

                list.add(res_ponseVO); // Store the row in the vector
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
    public List<Res_ponseVO> getAll(Map<String, String[]> map) {
        List<Res_ponseVO> list = new ArrayList<Res_ponseVO>();
        Res_ponseVO res_ponseVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Res_ponse "
                  + jdbcUtil_CompositeQuery_Res_ponse.get_WhereCondition(map)
                  + "order by res_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                res_ponseVO = new Res_ponseVO();
                
                res_ponseVO.setRes_Id(rs.getString ("res_Id"));
                res_ponseVO.setMem_Id(rs.getString ("mem_Id"));
                res_ponseVO.setPost_Id(rs.getString ("post_Id"));
                res_ponseVO.setRes_ponse_content(rs.getString ("res_ponse_content"));
                res_ponseVO.setPost_time(rs.getDate ("post_time"));
                res_ponseVO.setRes_ponse_upDate(rs.getDate ("res_ponse_upDate"));
             
                list.add(res_ponseVO); // Store the row in the List
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
    public Set<Res_ponseVO> getRes_ponsesByMem_Id(String mem_Id) {
        Set<Res_ponseVO> set = new LinkedHashSet<Res_ponseVO>();
        Res_ponseVO res_ponseVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Res_ponses_ByMem_Id_STMT);
            pstmt.setString(1, mem_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                res_ponseVO = new Res_ponseVO();
				res_ponseVO.setRes_Id(rs.getString ("res_Id"));
				res_ponseVO.setMem_Id(rs.getString ("mem_Id"));
				res_ponseVO.setPost_Id(rs.getString ("post_Id"));
				res_ponseVO.setRes_ponse_content(rs.getString ("res_ponse_content"));
				res_ponseVO.setPost_time(rs.getDate ("post_time"));
				res_ponseVO.setRes_ponse_upDate(rs.getDate ("res_ponse_upDate"));

                set.add(res_ponseVO); // Store the row in the vector
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
    public Set<Res_ponseVO> getRes_ponsesByPost_Id(String post_Id) {
        Set<Res_ponseVO> set = new LinkedHashSet<Res_ponseVO>();
        Res_ponseVO res_ponseVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Res_ponses_ByPost_Id_STMT);
            pstmt.setString(1, post_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                res_ponseVO = new Res_ponseVO();
				res_ponseVO.setRes_Id(rs.getString ("res_Id"));
				res_ponseVO.setMem_Id(rs.getString ("mem_Id"));
				res_ponseVO.setPost_Id(rs.getString ("post_Id"));
				res_ponseVO.setRes_ponse_content(rs.getString ("res_ponse_content"));
				res_ponseVO.setPost_time(rs.getDate ("post_time"));
				res_ponseVO.setRes_ponse_upDate(rs.getDate ("res_ponse_upDate"));

                set.add(res_ponseVO); // Store the row in the vector
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