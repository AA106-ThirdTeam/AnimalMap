package com.priv_message.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Priv_message;
/** 
 *表格名稱 : <br>
 *	私人訊息<br>
 *	英文:priv_message<br>
 */ 
public class Priv_messageDAO implements Priv_messageDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO priv_message(privMes_Id,privMesSend_MemId,privMesRec_MemId,privMes_content,privMes_SendTime,privMes_type ) VALUES  ( priv_message_seq1.nextval , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE priv_message SET privMes_content=?,privMes_SendTime=? ,privMes_type=?  WHERE privMes_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM priv_message WHERE privMes_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT privMes_Id,privMesSend_MemId,privMesRec_MemId,privMes_content,to_char(privMes_SendTime,'yyyy-mm-dd') privMes_SendTime,privMes_type FROM priv_message WHERE privMes_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT privMes_Id,privMesSend_MemId,privMesRec_MemId,privMes_content,to_char(privMes_SendTime,'yyyy-mm-dd') privMes_SendTime,privMes_type FROM priv_message order by privMes_Id " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Priv_messages_ByMem_Id_STMT = 
		"SELECT privMes_Id,privMesSend_MemId,privMesRec_MemId,privMes_content,to_char(privMes_SendTime,'yyyy-mm-dd') privMes_SendTime,privMes_type FROM Priv_message WHERE privMesSend_MemId = ? order by privMesSend_MemId";
    private static final String GET_Priv_messages_ByMem_Id2_STMT = 
		"SELECT privMes_Id,privMesSend_MemId,privMesRec_MemId,privMes_content,to_char(privMes_SendTime,'yyyy-mm-dd') privMes_SendTime,privMes_type FROM Priv_message WHERE privMesRec_MemId = ? order by privMesRec_MemId";

	//====以下是新增指令====
	private static final String UPDATE_PRIVMES_CONTENT =" UPDATE priv_message set PRIVMES_CONTENT=?  WHERE privMes_Id=? " ; 
	private static final String UPDATE_PRIVMES_SENDTIME =" UPDATE priv_message set PRIVMES_SENDTIME=?  WHERE privMes_Id=? " ; 
	private static final String UPDATE_PRIVMES_TYPE =" UPDATE priv_message set PRIVMES_TYPE=?  WHERE privMes_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Priv_messageVO aPriv_messageVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Priv_messageDAO.INSERT_STMT);
			pstmt.setString (1, aPriv_messageVO.getPrivMesSend_MemId());
			pstmt.setString (2, aPriv_messageVO.getPrivMesRec_MemId());
			pstmt.setString (3, aPriv_messageVO.getPrivMes_content());
			pstmt.setDate (4, aPriv_messageVO.getPrivMes_SendTime());
			pstmt.setString (5, aPriv_messageVO.getPrivMes_type());
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
	public void update(Priv_messageVO aPriv_messageVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Priv_messageDAO.UPDATE);
			pstmt.setString (1, aPriv_messageVO.getPrivMes_content());
			pstmt.setDate (2, aPriv_messageVO.getPrivMes_SendTime());
			pstmt.setString (3, aPriv_messageVO.getPrivMes_type());
			pstmt.setString (4, aPriv_messageVO.getPrivMes_Id());
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
	public void delete(String  aPriv_message){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Priv_messageDAO.DELETE);
			pstmt.setString (1,aPriv_message);
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
	public Priv_messageVO findByPrimaryKey(String  aPK_NO){
		Priv_messageVO priv_messageVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Priv_messageDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				priv_messageVO = new Priv_messageVO();
				priv_messageVO.setPrivMes_Id(rs.getString("privMes_Id"));
				priv_messageVO.setPrivMesSend_MemId(rs.getString("privMesSend_MemId"));
				priv_messageVO.setPrivMesRec_MemId(rs.getString("privMesRec_MemId"));
				priv_messageVO.setPrivMes_content(rs.getString("privMes_content"));
				priv_messageVO.setPrivMes_SendTime(rs.getDate("privMes_SendTime"));
				priv_messageVO.setPrivMes_type(rs.getString("privMes_type"));
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
		return priv_messageVO; 
	} 

    @Override
    public List<Priv_messageVO> getAll() {
        List<Priv_messageVO> list = new ArrayList<Priv_messageVO>();
        Priv_messageVO priv_messageVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // priv_messageVO 也稱為 Domain objects
                priv_messageVO = new Priv_messageVO();
                priv_messageVO.setPrivMes_Id(rs.getString("privMes_Id"));
                priv_messageVO.setPrivMesSend_MemId(rs.getString("privMesSend_MemId"));
                priv_messageVO.setPrivMesRec_MemId(rs.getString("privMesRec_MemId"));
                priv_messageVO.setPrivMes_content(rs.getString("privMes_content"));
                priv_messageVO.setPrivMes_SendTime(rs.getDate("privMes_SendTime"));
                priv_messageVO.setPrivMes_type(rs.getString("privMes_type"));

                list.add(priv_messageVO); // Store the row in the vector
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
    public List<Priv_messageVO> getAll(Map<String, String[]> map) {
        List<Priv_messageVO> list = new ArrayList<Priv_messageVO>();
        Priv_messageVO priv_messageVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Priv_message "
                  + jdbcUtil_CompositeQuery_Priv_message.get_WhereCondition(map)
                  + "order by privMes_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                priv_messageVO = new Priv_messageVO();
                
                priv_messageVO.setPrivMes_Id(rs.getString ("privMes_Id"));
                priv_messageVO.setPrivMesSend_MemId(rs.getString ("privMesSend_MemId"));
                priv_messageVO.setPrivMesRec_MemId(rs.getString ("privMesRec_MemId"));
                priv_messageVO.setPrivMes_content(rs.getString ("privMes_content"));
                priv_messageVO.setPrivMes_SendTime(rs.getDate ("privMes_SendTime"));
                priv_messageVO.setPrivMes_type(rs.getString ("privMes_type"));
             
                list.add(priv_messageVO); // Store the row in the List
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
    public Set<Priv_messageVO> getPriv_messagesByMem_Id(String privMesSend_MemId) {
        Set<Priv_messageVO> set = new LinkedHashSet<Priv_messageVO>();
        Priv_messageVO priv_messageVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Priv_messages_ByMem_Id_STMT);
            pstmt.setString(1, privMesSend_MemId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                priv_messageVO = new Priv_messageVO();
				priv_messageVO.setPrivMes_Id(rs.getString ("privMes_Id"));
				priv_messageVO.setPrivMesSend_MemId(rs.getString ("privMesSend_MemId"));
				priv_messageVO.setPrivMesRec_MemId(rs.getString ("privMesRec_MemId"));
				priv_messageVO.setPrivMes_content(rs.getString ("privMes_content"));
				priv_messageVO.setPrivMes_SendTime(rs.getDate ("privMes_SendTime"));
				priv_messageVO.setPrivMes_type(rs.getString ("privMes_type"));

                set.add(priv_messageVO); // Store the row in the vector
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
    public Set<Priv_messageVO> getPriv_messagesByMem_Id2(String privMesRec_MemId) {
        Set<Priv_messageVO> set = new LinkedHashSet<Priv_messageVO>();
        Priv_messageVO priv_messageVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Priv_messages_ByMem_Id2_STMT);
            pstmt.setString(1, privMesRec_MemId);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                priv_messageVO = new Priv_messageVO();
				priv_messageVO.setPrivMes_Id(rs.getString ("privMes_Id"));
				priv_messageVO.setPrivMesSend_MemId(rs.getString ("privMesSend_MemId"));
				priv_messageVO.setPrivMesRec_MemId(rs.getString ("privMesRec_MemId"));
				priv_messageVO.setPrivMes_content(rs.getString ("privMes_content"));
				priv_messageVO.setPrivMes_SendTime(rs.getDate ("privMes_SendTime"));
				priv_messageVO.setPrivMes_type(rs.getString ("privMes_type"));

                set.add(priv_messageVO); // Store the row in the vector
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