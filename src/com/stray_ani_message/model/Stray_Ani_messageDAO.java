package com.stray_ani_message.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Stray_Ani_message;
/** 
 *表格名稱 : <br>
 *	社區流浪動物留言<br>
 *	英文:stray_Ani_message<br>
 */ 
public class Stray_Ani_messageDAO implements Stray_Ani_messageDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO stray_Ani_message(str_Ani_Mes_No,stray_Ani_Id,mem_Id,str_Ani_Mes_time,str_Ani_Mes ) VALUES  ( stray_Ani_message_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE stray_Ani_message SET str_Ani_Mes_time=?,str_Ani_Mes=?  WHERE str_Ani_Mes_No=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM stray_Ani_message WHERE str_Ani_Mes_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT str_Ani_Mes_No,stray_Ani_Id,mem_Id,to_char(str_Ani_Mes_time,'yyyy-mm-dd') str_Ani_Mes_time,str_Ani_Mes FROM stray_ani_message WHERE str_Ani_Mes_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT str_Ani_Mes_No,stray_Ani_Id,mem_Id,to_char(str_Ani_Mes_time,'yyyy-mm-dd') str_Ani_Mes_time,str_Ani_Mes FROM stray_Ani_message order by str_Ani_Mes_No " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Stray_Ani_messages_ByStray_Ani_Id_STMT = 
		"SELECT str_Ani_Mes_No,stray_Ani_Id,mem_Id,to_char(str_Ani_Mes_time,'yyyy-mm-dd') str_Ani_Mes_time,str_Ani_Mes FROM Stray_Ani_message WHERE stray_Ani_Id = ? order by stray_Ani_Id";
    private static final String GET_Stray_Ani_messages_ByMem_Id_STMT = 
		"SELECT str_Ani_Mes_No,stray_Ani_Id,mem_Id,to_char(str_Ani_Mes_time,'yyyy-mm-dd') str_Ani_Mes_time,str_Ani_Mes FROM Stray_Ani_message WHERE mem_Id = ? order by mem_Id";

	//====以下是新增指令====
	private static final String UPDATE_STR_ANI_MES_TIME =" UPDATE stray_Ani_message set STR_ANI_MES_TIME=?  WHERE str_Ani_Mes_No=? " ; 
	private static final String UPDATE_STR_ANI_MES =" UPDATE stray_Ani_message set STR_ANI_MES=?  WHERE str_Ani_Mes_No=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Stray_Ani_messageVO aStray_Ani_messageVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_messageDAO.INSERT_STMT);
			pstmt.setString (1, aStray_Ani_messageVO.getStray_Ani_Id());
			pstmt.setString (2, aStray_Ani_messageVO.getMem_Id());
			pstmt.setDate (3, aStray_Ani_messageVO.getStr_Ani_Mes_time());
			pstmt.setString (4, aStray_Ani_messageVO.getStr_Ani_Mes());
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
	public void update(Stray_Ani_messageVO aStray_Ani_messageVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_messageDAO.UPDATE);
			pstmt.setDate (1, aStray_Ani_messageVO.getStr_Ani_Mes_time());
			pstmt.setString (2, aStray_Ani_messageVO.getStr_Ani_Mes());
			pstmt.setString (3, aStray_Ani_messageVO.getStr_Ani_Mes_No());
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
	public void delete(String  aStray_Ani_message){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_messageDAO.DELETE);
			pstmt.setString (1,aStray_Ani_message);
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
	public Stray_Ani_messageVO findByPrimaryKey(String  aPK_NO){
		Stray_Ani_messageVO stray_ani_messageVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_messageDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stray_ani_messageVO = new Stray_Ani_messageVO();
				stray_ani_messageVO.setStr_Ani_Mes_No(rs.getString("str_Ani_Mes_No"));
				stray_ani_messageVO.setStray_Ani_Id(rs.getString("stray_Ani_Id"));
				stray_ani_messageVO.setMem_Id(rs.getString("mem_Id"));
				stray_ani_messageVO.setStr_Ani_Mes_time(rs.getDate("str_Ani_Mes_time"));
				stray_ani_messageVO.setStr_Ani_Mes(rs.getString("str_Ani_Mes"));
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
		return stray_ani_messageVO; 
	} 

    @Override
    public List<Stray_Ani_messageVO> getAll() {
        List<Stray_Ani_messageVO> list = new ArrayList<Stray_Ani_messageVO>();
        Stray_Ani_messageVO stray_ani_messageVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // stray_ani_messageVO 也稱為 Domain objects
                stray_ani_messageVO = new Stray_Ani_messageVO();
                stray_ani_messageVO.setStr_Ani_Mes_No(rs.getString("str_Ani_Mes_No"));
                stray_ani_messageVO.setStray_Ani_Id(rs.getString("stray_Ani_Id"));
                stray_ani_messageVO.setMem_Id(rs.getString("mem_Id"));
                stray_ani_messageVO.setStr_Ani_Mes_time(rs.getDate("str_Ani_Mes_time"));
                stray_ani_messageVO.setStr_Ani_Mes(rs.getString("str_Ani_Mes"));

                list.add(stray_ani_messageVO); // Store the row in the vector
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
    public List<Stray_Ani_messageVO> getAll(Map<String, String[]> map) {
        List<Stray_Ani_messageVO> list = new ArrayList<Stray_Ani_messageVO>();
        Stray_Ani_messageVO stray_ani_messageVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Stray_Ani_message "
                  + jdbcUtil_CompositeQuery_Stray_Ani_message.get_WhereCondition(map)
                  + "order by str_Ani_Mes_No";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                stray_ani_messageVO = new Stray_Ani_messageVO();
                
                stray_ani_messageVO.setStr_Ani_Mes_No(rs.getString ("str_Ani_Mes_No"));
                stray_ani_messageVO.setStray_Ani_Id(rs.getString ("stray_Ani_Id"));
                stray_ani_messageVO.setMem_Id(rs.getString ("mem_Id"));
                stray_ani_messageVO.setStr_Ani_Mes_time(rs.getDate ("str_Ani_Mes_time"));
                stray_ani_messageVO.setStr_Ani_Mes(rs.getString ("str_Ani_Mes"));
             
                list.add(stray_ani_messageVO); // Store the row in the List
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
    public Set<Stray_Ani_messageVO> getStray_Ani_messagesByStray_Ani_Id(String stray_Ani_Id) {
        Set<Stray_Ani_messageVO> set = new LinkedHashSet<Stray_Ani_messageVO>();
        Stray_Ani_messageVO stray_ani_messageVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Stray_Ani_messages_ByStray_Ani_Id_STMT);
            pstmt.setString(1, stray_Ani_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                stray_ani_messageVO = new Stray_Ani_messageVO();
				stray_ani_messageVO.setStr_Ani_Mes_No(rs.getString ("str_Ani_Mes_No"));
				stray_ani_messageVO.setStray_Ani_Id(rs.getString ("stray_Ani_Id"));
				stray_ani_messageVO.setMem_Id(rs.getString ("mem_Id"));
				stray_ani_messageVO.setStr_Ani_Mes_time(rs.getDate ("str_Ani_Mes_time"));
				stray_ani_messageVO.setStr_Ani_Mes(rs.getString ("str_Ani_Mes"));

                set.add(stray_ani_messageVO); // Store the row in the vector
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
    public Set<Stray_Ani_messageVO> getStray_Ani_messagesByMem_Id(String mem_Id) {
        Set<Stray_Ani_messageVO> set = new LinkedHashSet<Stray_Ani_messageVO>();
        Stray_Ani_messageVO stray_ani_messageVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Stray_Ani_messages_ByMem_Id_STMT);
            pstmt.setString(1, mem_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                stray_ani_messageVO = new Stray_Ani_messageVO();
				stray_ani_messageVO.setStr_Ani_Mes_No(rs.getString ("str_Ani_Mes_No"));
				stray_ani_messageVO.setStray_Ani_Id(rs.getString ("stray_Ani_Id"));
				stray_ani_messageVO.setMem_Id(rs.getString ("mem_Id"));
				stray_ani_messageVO.setStr_Ani_Mes_time(rs.getDate ("str_Ani_Mes_time"));
				stray_ani_messageVO.setStr_Ani_Mes(rs.getString ("str_Ani_Mes"));

                set.add(stray_ani_messageVO); // Store the row in the vector
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