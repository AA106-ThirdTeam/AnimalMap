package com.offimsg.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	公告訊息<br>
 *	英文:offiMsg<br>
 */ 
public class OffiMsgDAO implements OffiMsgDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO offiMsg(offiMsg_Id,offiMsg_empId,offiMsg_Title,offiMsg_Content,offiMsg_Date ) VALUES  ( offiMsg_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE offiMsg SET offiMsg_Title=?,offiMsg_Content=? ,offiMsg_Date=?  WHERE offiMsg_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM offiMsg WHERE offiMsg_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT offiMsg_Id,offiMsg_empId,offiMsg_Title,offiMsg_Content,to_char(offiMsg_Date,'yyyy-mm-dd') offiMsg_Date FROM offimsg WHERE offiMsg_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT offiMsg_Id,offiMsg_empId,offiMsg_Title,offiMsg_Content,to_char(offiMsg_Date,'yyyy-mm-dd') offiMsg_Date FROM offiMsg order by offiMsg_Id " ; 
	//====以下是新增指令====
	private static final String UPDATE_OFFIMSG_TITLE =" UPDATE offiMsg set OFFIMSG_TITLE=?  WHERE offiMsg_Id=? " ; 
	private static final String UPDATE_OFFIMSG_CONTENT =" UPDATE offiMsg set OFFIMSG_CONTENT=?  WHERE offiMsg_Id=? " ; 
	private static final String UPDATE_OFFIMSG_DATE =" UPDATE offiMsg set OFFIMSG_DATE=?  WHERE offiMsg_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(OffiMsgVO aOffiMsgVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(OffiMsgDAO.INSERT_STMT);
			pstmt.setString (1, aOffiMsgVO.getOffiMsg_empId());
			pstmt.setString (2, aOffiMsgVO.getOffiMsg_Title());
			pstmt.setString (3, aOffiMsgVO.getOffiMsg_Content());
			pstmt.setDate (4, aOffiMsgVO.getOffiMsg_Date());
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
	public void update(OffiMsgVO aOffiMsgVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(OffiMsgDAO.UPDATE);
			pstmt.setString (1, aOffiMsgVO.getOffiMsg_Title());
			pstmt.setString (2, aOffiMsgVO.getOffiMsg_Content());
			pstmt.setDate (3, aOffiMsgVO.getOffiMsg_Date());
			pstmt.setString (4, aOffiMsgVO.getOffiMsg_Id());
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
	public void delete(String  aOffiMsg){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(OffiMsgDAO.DELETE);
			pstmt.setString (1,aOffiMsg);
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
	public OffiMsgVO findByPrimaryKey(String  aPK_NO){
		OffiMsgVO offimsgVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(OffiMsgDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				offimsgVO = new OffiMsgVO();
				offimsgVO.setOffiMsg_Id(rs.getString("offiMsg_Id"));
				offimsgVO.setOffiMsg_empId(rs.getString("offiMsg_empId"));
				offimsgVO.setOffiMsg_Title(rs.getString("offiMsg_Title"));
				offimsgVO.setOffiMsg_Content(rs.getString("offiMsg_Content"));
				offimsgVO.setOffiMsg_Date(rs.getDate("offiMsg_Date"));
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
		return offimsgVO; 
	} 

    @Override
    public List<OffiMsgVO> getAll() {
        List<OffiMsgVO> list = new ArrayList<OffiMsgVO>();
        OffiMsgVO offimsgVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // offimsgVO 也稱為 Domain objects
                offimsgVO = new OffiMsgVO();
                offimsgVO.setOffiMsg_Id(rs.getString("offiMsg_Id"));
                offimsgVO.setOffiMsg_empId(rs.getString("offiMsg_empId"));
                offimsgVO.setOffiMsg_Title(rs.getString("offiMsg_Title"));
                offimsgVO.setOffiMsg_Content(rs.getString("offiMsg_Content"));
                offimsgVO.setOffiMsg_Date(rs.getDate("offiMsg_Date"));

                list.add(offimsgVO); // Store the row in the vector
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