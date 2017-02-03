package com.stray_ani.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	社區流浪動物<br>
 *	英文:stray_Ani<br>
 */ 
public class Stray_AniDAO implements Stray_AniDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO stray_Ani(stray_Ani_Id,mem_Id,stray_Ani_name,stray_Ani_type,stray_Ani_gender,stray_Ani_heal,stray_Ani_Vac,stray_Ani_color,stray_Ani_body,stray_Ani_age,stray_Ani_Neu,stray_Ani_chip,stray_Ani_date,stray_Ani_status,stray_Ani_CreDate,stray_Ani_FinLat,stray_Ani_FinLon,stray_Ani_city,stray_Ani_town,stray_Ani_road ) VALUES  ( stray_Ani_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE stray_Ani SET stray_Ani_name=?,stray_Ani_type=? ,stray_Ani_gender=? ,stray_Ani_heal=? ,stray_Ani_Vac=? ,stray_Ani_color=? ,stray_Ani_body=? ,stray_Ani_age=? ,stray_Ani_Neu=? ,stray_Ani_chip=? ,stray_Ani_date=? ,stray_Ani_status=? ,stray_Ani_CreDate=? ,stray_Ani_FinLat=? ,stray_Ani_FinLon=? ,stray_Ani_city=? ,stray_Ani_town=? ,stray_Ani_road=?  WHERE stray_Ani_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM stray_Ani WHERE stray_Ani_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT stray_Ani_Id,mem_Id,stray_Ani_name,stray_Ani_type,stray_Ani_gender,stray_Ani_heal,stray_Ani_Vac,stray_Ani_color,stray_Ani_body,stray_Ani_age,stray_Ani_Neu,stray_Ani_chip,to_char(stray_Ani_date,'yyyy-mm-dd') stray_Ani_date,stray_Ani_status,to_char(stray_Ani_CreDate,'yyyy-mm-dd') stray_Ani_CreDate,stray_Ani_FinLat,stray_Ani_FinLon,stray_Ani_city,stray_Ani_town,stray_Ani_road FROM stray_ani WHERE stray_Ani_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT stray_Ani_Id,mem_Id,stray_Ani_name,stray_Ani_type,stray_Ani_gender,stray_Ani_heal,stray_Ani_Vac,stray_Ani_color,stray_Ani_body,stray_Ani_age,stray_Ani_Neu,stray_Ani_chip,to_char(stray_Ani_date,'yyyy-mm-dd') stray_Ani_date,stray_Ani_status,to_char(stray_Ani_CreDate,'yyyy-mm-dd') stray_Ani_CreDate,stray_Ani_FinLat,stray_Ani_FinLon,stray_Ani_city,stray_Ani_town,stray_Ani_road FROM stray_Ani order by stray_Ani_Id " ; 
	//====以下是新增指令====
	private static final String UPDATE_STRAY_ANI_NAME =" UPDATE stray_Ani set STRAY_ANI_NAME=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_TYPE =" UPDATE stray_Ani set STRAY_ANI_TYPE=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_GENDER =" UPDATE stray_Ani set STRAY_ANI_GENDER=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_HEAL =" UPDATE stray_Ani set STRAY_ANI_HEAL=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_VAC =" UPDATE stray_Ani set STRAY_ANI_VAC=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_COLOR =" UPDATE stray_Ani set STRAY_ANI_COLOR=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_BODY =" UPDATE stray_Ani set STRAY_ANI_BODY=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_AGE =" UPDATE stray_Ani set STRAY_ANI_AGE=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_NEU =" UPDATE stray_Ani set STRAY_ANI_NEU=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_CHIP =" UPDATE stray_Ani set STRAY_ANI_CHIP=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_DATE =" UPDATE stray_Ani set STRAY_ANI_DATE=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_STATUS =" UPDATE stray_Ani set STRAY_ANI_STATUS=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_CREDATE =" UPDATE stray_Ani set STRAY_ANI_CREDATE=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_FINLAT =" UPDATE stray_Ani set STRAY_ANI_FINLAT=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_FINLON =" UPDATE stray_Ani set STRAY_ANI_FINLON=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_CITY =" UPDATE stray_Ani set STRAY_ANI_CITY=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_TOWN =" UPDATE stray_Ani set STRAY_ANI_TOWN=?  WHERE stray_Ani_Id=? " ; 
	private static final String UPDATE_STRAY_ANI_ROAD =" UPDATE stray_Ani set STRAY_ANI_ROAD=?  WHERE stray_Ani_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Stray_AniVO aStray_AniVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_AniDAO.INSERT_STMT);
			pstmt.setString (1, aStray_AniVO.getMem_Id());
			pstmt.setString (2, aStray_AniVO.getStray_Ani_name());
			pstmt.setString (3, aStray_AniVO.getStray_Ani_type());
			pstmt.setString (4, aStray_AniVO.getStray_Ani_gender());
			pstmt.setString (5, aStray_AniVO.getStray_Ani_heal());
			pstmt.setString (6, aStray_AniVO.getStray_Ani_Vac());
			pstmt.setString (7, aStray_AniVO.getStray_Ani_color());
			pstmt.setString (8, aStray_AniVO.getStray_Ani_body());
			pstmt.setString (9, aStray_AniVO.getStray_Ani_age());
			pstmt.setString (10, aStray_AniVO.getStray_Ani_Neu());
			pstmt.setString (11, aStray_AniVO.getStray_Ani_chip());
			pstmt.setDate (12, aStray_AniVO.getStray_Ani_date());
			pstmt.setString (13, aStray_AniVO.getStray_Ani_status());
			pstmt.setDate (14, aStray_AniVO.getStray_Ani_CreDate());
			pstmt.setDouble (15, aStray_AniVO.getStray_Ani_FinLat());
			pstmt.setDouble (16, aStray_AniVO.getStray_Ani_FinLon());
			pstmt.setString (17, aStray_AniVO.getStray_Ani_city());
			pstmt.setString (18, aStray_AniVO.getStray_Ani_town());
			pstmt.setString (19, aStray_AniVO.getStray_Ani_road());
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
	public void update(Stray_AniVO aStray_AniVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_AniDAO.UPDATE);
			pstmt.setString (1, aStray_AniVO.getStray_Ani_name());
			pstmt.setString (2, aStray_AniVO.getStray_Ani_type());
			pstmt.setString (3, aStray_AniVO.getStray_Ani_gender());
			pstmt.setString (4, aStray_AniVO.getStray_Ani_heal());
			pstmt.setString (5, aStray_AniVO.getStray_Ani_Vac());
			pstmt.setString (6, aStray_AniVO.getStray_Ani_color());
			pstmt.setString (7, aStray_AniVO.getStray_Ani_body());
			pstmt.setString (8, aStray_AniVO.getStray_Ani_age());
			pstmt.setString (9, aStray_AniVO.getStray_Ani_Neu());
			pstmt.setString (10, aStray_AniVO.getStray_Ani_chip());
			pstmt.setDate (11, aStray_AniVO.getStray_Ani_date());
			pstmt.setString (12, aStray_AniVO.getStray_Ani_status());
			pstmt.setDate (13, aStray_AniVO.getStray_Ani_CreDate());
			pstmt.setDouble (14, aStray_AniVO.getStray_Ani_FinLat());
			pstmt.setDouble (15, aStray_AniVO.getStray_Ani_FinLon());
			pstmt.setString (16, aStray_AniVO.getStray_Ani_city());
			pstmt.setString (17, aStray_AniVO.getStray_Ani_town());
			pstmt.setString (18, aStray_AniVO.getStray_Ani_road());
			pstmt.setString (19, aStray_AniVO.getStray_Ani_Id());
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
	public void delete(String  aStray_Ani){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_AniDAO.DELETE);
			pstmt.setString (1,aStray_Ani);
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
	public Stray_AniVO findByPrimaryKey(String  aPK_NO){
		Stray_AniVO stray_aniVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_AniDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stray_aniVO = new Stray_AniVO();
				stray_aniVO.setStray_Ani_Id(rs.getString("stray_Ani_Id"));
				stray_aniVO.setMem_Id(rs.getString("mem_Id"));
				stray_aniVO.setStray_Ani_name(rs.getString("stray_Ani_name"));
				stray_aniVO.setStray_Ani_type(rs.getString("stray_Ani_type"));
				stray_aniVO.setStray_Ani_gender(rs.getString("stray_Ani_gender"));
				stray_aniVO.setStray_Ani_heal(rs.getString("stray_Ani_heal"));
				stray_aniVO.setStray_Ani_Vac(rs.getString("stray_Ani_Vac"));
				stray_aniVO.setStray_Ani_color(rs.getString("stray_Ani_color"));
				stray_aniVO.setStray_Ani_body(rs.getString("stray_Ani_body"));
				stray_aniVO.setStray_Ani_age(rs.getString("stray_Ani_age"));
				stray_aniVO.setStray_Ani_Neu(rs.getString("stray_Ani_Neu"));
				stray_aniVO.setStray_Ani_chip(rs.getString("stray_Ani_chip"));
				stray_aniVO.setStray_Ani_date(rs.getDate("stray_Ani_date"));
				stray_aniVO.setStray_Ani_status(rs.getString("stray_Ani_status"));
				stray_aniVO.setStray_Ani_CreDate(rs.getDate("stray_Ani_CreDate"));
				stray_aniVO.setStray_Ani_FinLat(rs.getDouble("stray_Ani_FinLat"));
				stray_aniVO.setStray_Ani_FinLon(rs.getDouble("stray_Ani_FinLon"));
				stray_aniVO.setStray_Ani_city(rs.getString("stray_Ani_city"));
				stray_aniVO.setStray_Ani_town(rs.getString("stray_Ani_town"));
				stray_aniVO.setStray_Ani_road(rs.getString("stray_Ani_road"));
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
		return stray_aniVO; 
	} 

    @Override
    public List<Stray_AniVO> getAll() {
        List<Stray_AniVO> list = new ArrayList<Stray_AniVO>();
        Stray_AniVO stray_aniVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // stray_aniVO 也稱為 Domain objects
                stray_aniVO = new Stray_AniVO();
                stray_aniVO.setStray_Ani_Id(rs.getString("stray_Ani_Id"));
                stray_aniVO.setMem_Id(rs.getString("mem_Id"));
                stray_aniVO.setStray_Ani_name(rs.getString("stray_Ani_name"));
                stray_aniVO.setStray_Ani_type(rs.getString("stray_Ani_type"));
                stray_aniVO.setStray_Ani_gender(rs.getString("stray_Ani_gender"));
                stray_aniVO.setStray_Ani_heal(rs.getString("stray_Ani_heal"));
                stray_aniVO.setStray_Ani_Vac(rs.getString("stray_Ani_Vac"));
                stray_aniVO.setStray_Ani_color(rs.getString("stray_Ani_color"));
                stray_aniVO.setStray_Ani_body(rs.getString("stray_Ani_body"));
                stray_aniVO.setStray_Ani_age(rs.getString("stray_Ani_age"));
                stray_aniVO.setStray_Ani_Neu(rs.getString("stray_Ani_Neu"));
                stray_aniVO.setStray_Ani_chip(rs.getString("stray_Ani_chip"));
                stray_aniVO.setStray_Ani_date(rs.getDate("stray_Ani_date"));
                stray_aniVO.setStray_Ani_status(rs.getString("stray_Ani_status"));
                stray_aniVO.setStray_Ani_CreDate(rs.getDate("stray_Ani_CreDate"));
                stray_aniVO.setStray_Ani_FinLat(rs.getDouble("stray_Ani_FinLat"));
                stray_aniVO.setStray_Ani_FinLon(rs.getDouble("stray_Ani_FinLon"));
                stray_aniVO.setStray_Ani_city(rs.getString("stray_Ani_city"));
                stray_aniVO.setStray_Ani_town(rs.getString("stray_Ani_town"));
                stray_aniVO.setStray_Ani_road(rs.getString("stray_Ani_road"));

                list.add(stray_aniVO); // Store the row in the vector
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