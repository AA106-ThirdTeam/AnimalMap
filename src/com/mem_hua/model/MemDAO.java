package com.mem_hua.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Mem;
/** 
 *表格名稱 : <br>
 *	一般會員<br>
 *	英文:mem<br>
 */ 
public class MemDAO implements MemDAO_interface{
	private static DataSource ds = null; 
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB_Hua");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO mem(mem_Id,mem_account,mem_Psw,mem_nick_name,mem_name,mem_gender,mem_Tw_Id,mem_birth_date,mem_phone,mem_Intro,mem_profile,mem_black_list,mem_permission,mem_setting,mem_balance ) VALUES  ( mem_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE mem SET mem_account=?,mem_Psw=? ,mem_nick_name=? ,mem_name=? ,mem_gender=? ,mem_Tw_Id=? ,mem_birth_date=? ,mem_phone=? ,mem_Intro=? ,mem_profile=? ,mem_black_list=? ,mem_permission=? ,mem_setting=? ,mem_balance=?  WHERE mem_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM mem WHERE mem_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT mem_Id,mem_account,mem_Psw,mem_nick_name,mem_name,mem_gender,mem_Tw_Id,to_char(mem_birth_date,'yyyy-mm-dd') mem_birth_date,mem_phone,mem_Intro,mem_profile,mem_black_list,mem_permission,mem_setting,mem_balance FROM mem WHERE mem_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT mem_Id,mem_account,mem_Psw,mem_nick_name,mem_name,mem_gender,mem_Tw_Id,to_char(mem_birth_date,'yyyy-mm-dd') mem_birth_date,mem_phone,mem_Intro,mem_profile,mem_black_list,mem_permission,mem_setting,mem_balance FROM mem order by mem_Id " ; 

	//====以下是GET_ByFK_STMT指令====

	//====以下是新增指令====
	private static final String UPDATE_MEM_ACCOUNT =" UPDATE mem set MEM_ACCOUNT=?  WHERE mem_Id=? " ; 
	private static final String UPDATE_MEM_PSW =" UPDATE mem set MEM_PSW=?  WHERE mem_Id=? " ; 
	private static final String UPDATE_MEM_NICK_NAME =" UPDATE mem set MEM_NICK_NAME=?  WHERE mem_Id=? " ; 
	private static final String UPDATE_MEM_NAME =" UPDATE mem set MEM_NAME=?  WHERE mem_Id=? " ; 
	private static final String UPDATE_MEM_GENDER =" UPDATE mem set MEM_GENDER=?  WHERE mem_Id=? " ; 
	private static final String UPDATE_MEM_TW_ID =" UPDATE mem set MEM_TW_ID=?  WHERE mem_Id=? " ; 
	private static final String UPDATE_MEM_BIRTH_DATE =" UPDATE mem set MEM_BIRTH_DATE=?  WHERE mem_Id=? " ; 
	private static final String UPDATE_MEM_PHONE =" UPDATE mem set MEM_PHONE=?  WHERE mem_Id=? " ; 
	private static final String UPDATE_MEM_INTRO =" UPDATE mem set MEM_INTRO=?  WHERE mem_Id=? " ; 
	private static final String UPDATE_MEM_PROFILE =" UPDATE mem set MEM_PROFILE=?  WHERE mem_Id=? " ; 
	private static final String UPDATE_MEM_BLACK_LIST =" UPDATE mem set MEM_BLACK_LIST=?  WHERE mem_Id=? " ; 
	private static final String UPDATE_MEM_PERMISSION =" UPDATE mem set MEM_PERMISSION=?  WHERE mem_Id=? " ; 
	private static final String UPDATE_MEM_SETTING =" UPDATE mem set MEM_SETTING=?  WHERE mem_Id=? " ; 
	private static final String UPDATE_MEM_BALANCE =" UPDATE mem set MEM_BALANCE=?  WHERE mem_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(MemVO aMemVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(MemDAO.INSERT_STMT);
			pstmt.setString (1, aMemVO.getMem_account());
			pstmt.setString (2, aMemVO.getMem_Psw());
			pstmt.setString (3, aMemVO.getMem_nick_name());
			pstmt.setString (4, aMemVO.getMem_name());
			pstmt.setString (5, aMemVO.getMem_gender());
			pstmt.setString (6, aMemVO.getMem_Tw_Id());
			pstmt.setDate (7, aMemVO.getMem_birth_date());
			pstmt.setString (8, aMemVO.getMem_phone());
			pstmt.setString (9, aMemVO.getMem_Intro());
			pstmt.setBytes (10, aMemVO.getMem_profile());
			pstmt.setString (11, aMemVO.getMem_black_list());
			pstmt.setString (12, aMemVO.getMem_permission());
			pstmt.setString (13, aMemVO.getMem_setting());
			pstmt.setInt (14, aMemVO.getMem_balance());
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
	public void update(MemVO aMemVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(MemDAO.UPDATE);
			pstmt.setString (1, aMemVO.getMem_account());
			pstmt.setString (2, aMemVO.getMem_Psw());
			pstmt.setString (3, aMemVO.getMem_nick_name());
			pstmt.setString (4, aMemVO.getMem_name());
			pstmt.setString (5, aMemVO.getMem_gender());
			pstmt.setString (6, aMemVO.getMem_Tw_Id());
			pstmt.setDate (7, aMemVO.getMem_birth_date());
			pstmt.setString (8, aMemVO.getMem_phone());
			pstmt.setString (9, aMemVO.getMem_Intro());
			pstmt.setBytes (10, aMemVO.getMem_profile());
			pstmt.setString (11, aMemVO.getMem_black_list());
			pstmt.setString (12, aMemVO.getMem_permission());
			pstmt.setString (13, aMemVO.getMem_setting());
			pstmt.setInt (14, aMemVO.getMem_balance());
			pstmt.setString (15, aMemVO.getMem_Id());
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
	public void delete(String  aMem){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(MemDAO.DELETE);
			pstmt.setString (1,aMem);
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
	public MemVO findByPrimaryKey(String  aPK_NO){
		MemVO memVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(MemDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				memVO = new MemVO();
				memVO.setMem_Id(rs.getString("mem_Id"));
				memVO.setMem_account(rs.getString("mem_account"));
				memVO.setMem_Psw(rs.getString("mem_Psw"));
				memVO.setMem_nick_name(rs.getString("mem_nick_name"));
				memVO.setMem_name(rs.getString("mem_name"));
				memVO.setMem_gender(rs.getString("mem_gender"));
				memVO.setMem_Tw_Id(rs.getString("mem_Tw_Id"));
				memVO.setMem_birth_date(rs.getDate("mem_birth_date"));
				memVO.setMem_phone(rs.getString("mem_phone"));
				memVO.setMem_Intro(rs.getString("mem_Intro"));
				memVO.setMem_profile(rs.getBytes("mem_profile"));
				memVO.setMem_black_list(rs.getString("mem_black_list"));
				memVO.setMem_permission(rs.getString("mem_permission"));
				memVO.setMem_setting(rs.getString("mem_setting"));
				memVO.setMem_balance(rs.getInt("mem_balance"));
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
		return memVO; 
	} 

    @Override
    public List<MemVO> getAll() {
        List<MemVO> list = new ArrayList<MemVO>();
        MemVO memVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // memVO 也稱為 Domain objects
                memVO = new MemVO();
                memVO.setMem_Id(rs.getString("mem_Id"));
                memVO.setMem_account(rs.getString("mem_account"));
                memVO.setMem_Psw(rs.getString("mem_Psw"));
                memVO.setMem_nick_name(rs.getString("mem_nick_name"));
                memVO.setMem_name(rs.getString("mem_name"));
                memVO.setMem_gender(rs.getString("mem_gender"));
                memVO.setMem_Tw_Id(rs.getString("mem_Tw_Id"));
                memVO.setMem_birth_date(rs.getDate("mem_birth_date"));
                memVO.setMem_phone(rs.getString("mem_phone"));
                memVO.setMem_Intro(rs.getString("mem_Intro"));
                memVO.setMem_profile(rs.getBytes("mem_profile"));
                memVO.setMem_black_list(rs.getString("mem_black_list"));
                memVO.setMem_permission(rs.getString("mem_permission"));
                memVO.setMem_setting(rs.getString("mem_setting"));
                memVO.setMem_balance(rs.getInt("mem_balance"));

                list.add(memVO); // Store the row in the vector
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
    public List<MemVO> getAll(Map<String, String[]> map) {
        List<MemVO> list = new ArrayList<MemVO>();
        MemVO memVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Mem "
                  + jdbcUtil_CompositeQuery_Mem.get_WhereCondition(map)
                  + "order by mem_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                memVO = new MemVO();
                
                memVO.setMem_Id(rs.getString ("mem_Id"));
                memVO.setMem_account(rs.getString ("mem_account"));
                memVO.setMem_Psw(rs.getString ("mem_Psw"));
                memVO.setMem_nick_name(rs.getString ("mem_nick_name"));
                memVO.setMem_name(rs.getString ("mem_name"));
                memVO.setMem_gender(rs.getString ("mem_gender"));
                memVO.setMem_Tw_Id(rs.getString ("mem_Tw_Id"));
                memVO.setMem_birth_date(rs.getDate ("mem_birth_date"));
                memVO.setMem_phone(rs.getString ("mem_phone"));
                memVO.setMem_Intro(rs.getString ("mem_Intro"));
                memVO.setMem_profile(rs.getBytes ("mem_profile"));
                memVO.setMem_black_list(rs.getString ("mem_black_list"));
                memVO.setMem_permission(rs.getString ("mem_permission"));
                memVO.setMem_setting(rs.getString ("mem_setting"));
                memVO.setMem_balance(rs.getInt ("mem_balance"));
             
                list.add(memVO); // Store the row in the List
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
















}