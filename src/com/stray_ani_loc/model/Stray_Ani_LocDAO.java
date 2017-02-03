package com.stray_ani_loc.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	社區流浪動物出沒範圍<br>
 *	英文:stray_Ani_Loc<br>
 */ 
public class Stray_Ani_LocDAO implements Stray_Ani_LocDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO stray_Ani_Loc(str_Ani_Loc_No,stray_Ani_Id,mem_Id,str_Ani_LocLat,str_Ani_LocLon ) VALUES  ( stray_Ani_Loc_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE stray_Ani_Loc SET str_Ani_LocLat=?,str_Ani_LocLon=?  WHERE str_Ani_Loc_No=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM stray_Ani_Loc WHERE str_Ani_Loc_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT str_Ani_Loc_No,stray_Ani_Id,mem_Id,str_Ani_LocLat,str_Ani_LocLon FROM stray_ani_loc WHERE str_Ani_Loc_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT str_Ani_Loc_No,stray_Ani_Id,mem_Id,str_Ani_LocLat,str_Ani_LocLon FROM stray_Ani_Loc order by str_Ani_Loc_No " ; 
	//====以下是新增指令====
	private static final String UPDATE_STR_ANI_LOCLAT =" UPDATE stray_Ani_Loc set STR_ANI_LOCLAT=?  WHERE str_Ani_Loc_No=? " ; 
	private static final String UPDATE_STR_ANI_LOCLON =" UPDATE stray_Ani_Loc set STR_ANI_LOCLON=?  WHERE str_Ani_Loc_No=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Stray_Ani_LocVO aStray_Ani_LocVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_LocDAO.INSERT_STMT);
			pstmt.setString (1, aStray_Ani_LocVO.getStray_Ani_Id());
			pstmt.setString (2, aStray_Ani_LocVO.getMem_Id());
			pstmt.setDouble (3, aStray_Ani_LocVO.getStr_Ani_LocLat());
			pstmt.setDouble (4, aStray_Ani_LocVO.getStr_Ani_LocLon());
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
	public void update(Stray_Ani_LocVO aStray_Ani_LocVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_LocDAO.UPDATE);
			pstmt.setDouble (1, aStray_Ani_LocVO.getStr_Ani_LocLat());
			pstmt.setDouble (2, aStray_Ani_LocVO.getStr_Ani_LocLon());
			pstmt.setString (3, aStray_Ani_LocVO.getStr_Ani_Loc_No());
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
	public void delete(String  aStray_Ani_Loc){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_LocDAO.DELETE);
			pstmt.setString (1,aStray_Ani_Loc);
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
	public Stray_Ani_LocVO findByPrimaryKey(String  aPK_NO){
		Stray_Ani_LocVO stray_ani_locVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_LocDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stray_ani_locVO = new Stray_Ani_LocVO();
				stray_ani_locVO.setStr_Ani_Loc_No(rs.getString("str_Ani_Loc_No"));
				stray_ani_locVO.setStray_Ani_Id(rs.getString("stray_Ani_Id"));
				stray_ani_locVO.setMem_Id(rs.getString("mem_Id"));
				stray_ani_locVO.setStr_Ani_LocLat(rs.getDouble("str_Ani_LocLat"));
				stray_ani_locVO.setStr_Ani_LocLon(rs.getDouble("str_Ani_LocLon"));
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
		return stray_ani_locVO; 
	} 

    @Override
    public List<Stray_Ani_LocVO> getAll() {
        List<Stray_Ani_LocVO> list = new ArrayList<Stray_Ani_LocVO>();
        Stray_Ani_LocVO stray_ani_locVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // stray_ani_locVO 也稱為 Domain objects
                stray_ani_locVO = new Stray_Ani_LocVO();
                stray_ani_locVO.setStr_Ani_Loc_No(rs.getString("str_Ani_Loc_No"));
                stray_ani_locVO.setStray_Ani_Id(rs.getString("stray_Ani_Id"));
                stray_ani_locVO.setMem_Id(rs.getString("mem_Id"));
                stray_ani_locVO.setStr_Ani_LocLat(rs.getDouble("str_Ani_LocLat"));
                stray_ani_locVO.setStr_Ani_LocLon(rs.getDouble("str_Ani_LocLon"));

                list.add(stray_ani_locVO); // Store the row in the vector
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

}