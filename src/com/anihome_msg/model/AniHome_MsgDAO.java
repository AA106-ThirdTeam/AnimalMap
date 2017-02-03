package com.anihome_msg.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	動物之家留言<br>
 *	英文:aniHome_Msg<br>
 */ 
public class AniHome_MsgDAO implements AniHome_MsgDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO aniHome_Msg(aniHome_Msg_Id,aniHome_Id,mem_Id,aniHome_Msg,adp_start_date ) VALUES  ( aniHome_Msg_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE aniHome_Msg SET aniHome_Msg=?,adp_start_date=?  WHERE aniHome_Msg_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM aniHome_Msg WHERE aniHome_Msg_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT aniHome_Msg_Id,aniHome_Id,mem_Id,aniHome_Msg,to_char(adp_start_date,'yyyy-mm-dd') adp_start_date FROM anihome_msg WHERE aniHome_Msg_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT aniHome_Msg_Id,aniHome_Id,mem_Id,aniHome_Msg,to_char(adp_start_date,'yyyy-mm-dd') adp_start_date FROM aniHome_Msg order by aniHome_Msg_Id " ; 
	//====以下是新增指令====
	private static final String UPDATE_ANIHOME_MSG =" UPDATE aniHome_Msg set ANIHOME_MSG=?  WHERE aniHome_Msg_Id=? " ; 
	private static final String UPDATE_ADP_START_DATE =" UPDATE aniHome_Msg set ADP_START_DATE=?  WHERE aniHome_Msg_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(AniHome_MsgVO aAniHome_MsgVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHome_MsgDAO.INSERT_STMT);
			pstmt.setString (1, aAniHome_MsgVO.getAniHome_Id());
			pstmt.setString (2, aAniHome_MsgVO.getMem_Id());
			pstmt.setString (3, aAniHome_MsgVO.getAniHome_Msg());
			pstmt.setDate (4, aAniHome_MsgVO.getAdp_start_date());
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
	public void update(AniHome_MsgVO aAniHome_MsgVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHome_MsgDAO.UPDATE);
			pstmt.setString (1, aAniHome_MsgVO.getAniHome_Msg());
			pstmt.setDate (2, aAniHome_MsgVO.getAdp_start_date());
			pstmt.setString (3, aAniHome_MsgVO.getAniHome_Msg_Id());
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
	public void delete(String  aAniHome_Msg){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHome_MsgDAO.DELETE);
			pstmt.setString (1,aAniHome_Msg);
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
	public AniHome_MsgVO findByPrimaryKey(String  aPK_NO){
		AniHome_MsgVO anihome_msgVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHome_MsgDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				anihome_msgVO = new AniHome_MsgVO();
				anihome_msgVO.setAniHome_Msg_Id(rs.getString("aniHome_Msg_Id"));
				anihome_msgVO.setAniHome_Id(rs.getString("aniHome_Id"));
				anihome_msgVO.setMem_Id(rs.getString("mem_Id"));
				anihome_msgVO.setAniHome_Msg(rs.getString("aniHome_Msg"));
				anihome_msgVO.setAdp_start_date(rs.getDate("adp_start_date"));
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
		return anihome_msgVO; 
	} 

    @Override
    public List<AniHome_MsgVO> getAll() {
        List<AniHome_MsgVO> list = new ArrayList<AniHome_MsgVO>();
        AniHome_MsgVO anihome_msgVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // anihome_msgVO 也稱為 Domain objects
                anihome_msgVO = new AniHome_MsgVO();
                anihome_msgVO.setAniHome_Msg_Id(rs.getString("aniHome_Msg_Id"));
                anihome_msgVO.setAniHome_Id(rs.getString("aniHome_Id"));
                anihome_msgVO.setMem_Id(rs.getString("mem_Id"));
                anihome_msgVO.setAniHome_Msg(rs.getString("aniHome_Msg"));
                anihome_msgVO.setAdp_start_date(rs.getDate("adp_start_date"));

                list.add(anihome_msgVO); // Store the row in the vector
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