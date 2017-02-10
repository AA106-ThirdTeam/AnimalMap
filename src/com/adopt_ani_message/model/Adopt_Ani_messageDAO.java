package com.adopt_ani_message.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Adopt_Ani_message;
/** 
 *表格名稱 : <br>
 *	送養動物留言<br>
 *	英文:adopt_Ani_message<br>
 */ 
public class Adopt_Ani_messageDAO implements Adopt_Ani_messageDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO adopt_Ani_message(ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes,ado_Ani_Mes_time ) VALUES  ( adopt_Ani_message_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE adopt_Ani_message SET ado_Ani_Mes=?,ado_Ani_Mes_time=?  WHERE ado_Ani_Mes_No=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM adopt_Ani_message WHERE ado_Ani_Mes_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes,to_char(ado_Ani_Mes_time,'yyyy-mm-dd') ado_Ani_Mes_time FROM adopt_ani_message WHERE ado_Ani_Mes_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes,to_char(ado_Ani_Mes_time,'yyyy-mm-dd') ado_Ani_Mes_time FROM adopt_Ani_message order by ado_Ani_Mes_No " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Adopt_Ani_messages_ByAdopt_Ani_Id_STMT = 
		"SELECT ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes,to_char(ado_Ani_Mes_time,'yyyy-mm-dd') ado_Ani_Mes_time FROM Adopt_Ani_message WHERE adopt_Ani_Id = ? order by adopt_Ani_Id";
    private static final String GET_Adopt_Ani_messages_ByMem_Id_STMT = 
		"SELECT ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes,to_char(ado_Ani_Mes_time,'yyyy-mm-dd') ado_Ani_Mes_time FROM Adopt_Ani_message WHERE mem_Id = ? order by mem_Id";

	//====以下是新增指令====
	private static final String UPDATE_ADO_ANI_MES =" UPDATE adopt_Ani_message set ADO_ANI_MES=?  WHERE ado_Ani_Mes_No=? " ; 
	private static final String UPDATE_ADO_ANI_MES_TIME =" UPDATE adopt_Ani_message set ADO_ANI_MES_TIME=?  WHERE ado_Ani_Mes_No=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Adopt_Ani_messageVO aAdopt_Ani_messageVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_messageDAO.INSERT_STMT);
			pstmt.setString (1, aAdopt_Ani_messageVO.getAdopt_Ani_Id());
			pstmt.setString (2, aAdopt_Ani_messageVO.getMem_Id());
			pstmt.setString (3, aAdopt_Ani_messageVO.getAdo_Ani_Mes());
			pstmt.setDate (4, aAdopt_Ani_messageVO.getAdo_Ani_Mes_time());
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
	public void update(Adopt_Ani_messageVO aAdopt_Ani_messageVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_messageDAO.UPDATE);
			pstmt.setString (1, aAdopt_Ani_messageVO.getAdo_Ani_Mes());
			pstmt.setDate (2, aAdopt_Ani_messageVO.getAdo_Ani_Mes_time());
			pstmt.setString (3, aAdopt_Ani_messageVO.getAdo_Ani_Mes_No());
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
	public void delete(String  aAdopt_Ani_message){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_messageDAO.DELETE);
			pstmt.setString (1,aAdopt_Ani_message);
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
	public Adopt_Ani_messageVO findByPrimaryKey(String  aPK_NO){
		Adopt_Ani_messageVO adopt_ani_messageVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_messageDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				adopt_ani_messageVO = new Adopt_Ani_messageVO();
				adopt_ani_messageVO.setAdo_Ani_Mes_No(rs.getString("ado_Ani_Mes_No"));
				adopt_ani_messageVO.setAdopt_Ani_Id(rs.getString("adopt_Ani_Id"));
				adopt_ani_messageVO.setMem_Id(rs.getString("mem_Id"));
				adopt_ani_messageVO.setAdo_Ani_Mes(rs.getString("ado_Ani_Mes"));
				adopt_ani_messageVO.setAdo_Ani_Mes_time(rs.getDate("ado_Ani_Mes_time"));
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
		return adopt_ani_messageVO; 
	} 

    @Override
    public List<Adopt_Ani_messageVO> getAll() {
        List<Adopt_Ani_messageVO> list = new ArrayList<Adopt_Ani_messageVO>();
        Adopt_Ani_messageVO adopt_ani_messageVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // adopt_ani_messageVO 也稱為 Domain objects
                adopt_ani_messageVO = new Adopt_Ani_messageVO();
                adopt_ani_messageVO.setAdo_Ani_Mes_No(rs.getString("ado_Ani_Mes_No"));
                adopt_ani_messageVO.setAdopt_Ani_Id(rs.getString("adopt_Ani_Id"));
                adopt_ani_messageVO.setMem_Id(rs.getString("mem_Id"));
                adopt_ani_messageVO.setAdo_Ani_Mes(rs.getString("ado_Ani_Mes"));
                adopt_ani_messageVO.setAdo_Ani_Mes_time(rs.getDate("ado_Ani_Mes_time"));

                list.add(adopt_ani_messageVO); // Store the row in the vector
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
    public List<Adopt_Ani_messageVO> getAll(Map<String, String[]> map) {
        List<Adopt_Ani_messageVO> list = new ArrayList<Adopt_Ani_messageVO>();
        Adopt_Ani_messageVO adopt_ani_messageVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Adopt_Ani_message "
                  + jdbcUtil_CompositeQuery_Adopt_Ani_message.get_WhereCondition(map)
                  + "order by ado_Ani_Mes_No";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                adopt_ani_messageVO = new Adopt_Ani_messageVO();
                
                adopt_ani_messageVO.setAdo_Ani_Mes_No(rs.getString ("ado_Ani_Mes_No"));
                adopt_ani_messageVO.setAdopt_Ani_Id(rs.getString ("adopt_Ani_Id"));
                adopt_ani_messageVO.setMem_Id(rs.getString ("mem_Id"));
                adopt_ani_messageVO.setAdo_Ani_Mes(rs.getString ("ado_Ani_Mes"));
                adopt_ani_messageVO.setAdo_Ani_Mes_time(rs.getDate ("ado_Ani_Mes_time"));
             
                list.add(adopt_ani_messageVO); // Store the row in the List
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
    public Set<Adopt_Ani_messageVO> getAdopt_Ani_messagesByAdopt_Ani_Id(String adopt_Ani_Id) {
        Set<Adopt_Ani_messageVO> set = new LinkedHashSet<Adopt_Ani_messageVO>();
        Adopt_Ani_messageVO adopt_ani_messageVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Adopt_Ani_messages_ByAdopt_Ani_Id_STMT);
            pstmt.setString(1, adopt_Ani_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                adopt_ani_messageVO = new Adopt_Ani_messageVO();
				adopt_ani_messageVO.setAdo_Ani_Mes_No(rs.getString ("ado_Ani_Mes_No"));
				adopt_ani_messageVO.setAdopt_Ani_Id(rs.getString ("adopt_Ani_Id"));
				adopt_ani_messageVO.setMem_Id(rs.getString ("mem_Id"));
				adopt_ani_messageVO.setAdo_Ani_Mes(rs.getString ("ado_Ani_Mes"));
				adopt_ani_messageVO.setAdo_Ani_Mes_time(rs.getDate ("ado_Ani_Mes_time"));

                set.add(adopt_ani_messageVO); // Store the row in the vector
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
    public Set<Adopt_Ani_messageVO> getAdopt_Ani_messagesByMem_Id(String mem_Id) {
        Set<Adopt_Ani_messageVO> set = new LinkedHashSet<Adopt_Ani_messageVO>();
        Adopt_Ani_messageVO adopt_ani_messageVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Adopt_Ani_messages_ByMem_Id_STMT);
            pstmt.setString(1, mem_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                adopt_ani_messageVO = new Adopt_Ani_messageVO();
				adopt_ani_messageVO.setAdo_Ani_Mes_No(rs.getString ("ado_Ani_Mes_No"));
				adopt_ani_messageVO.setAdopt_Ani_Id(rs.getString ("adopt_Ani_Id"));
				adopt_ani_messageVO.setMem_Id(rs.getString ("mem_Id"));
				adopt_ani_messageVO.setAdo_Ani_Mes(rs.getString ("ado_Ani_Mes"));
				adopt_ani_messageVO.setAdo_Ani_Mes_time(rs.getDate ("ado_Ani_Mes_time"));

                set.add(adopt_ani_messageVO); // Store the row in the vector
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