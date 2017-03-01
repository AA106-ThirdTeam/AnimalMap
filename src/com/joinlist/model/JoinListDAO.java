package com.joinlist.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource;

import com.hosPhoto.model.HosPhotoVO; 
/** 
 *表格名稱 : <br>
 *	揪團參加名單<br>
 *	英文:JoinList<br>
 */ 
public class JoinListDAO implements JoinListDAO_interface{
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
public static final String INSERT_STMT = "INSERT INTO JoinList(joinList_GrpId,joinList_MemId,joinList_isInvited ) VALUES  ( ? , ? , ? ) " ; 
	//====以下是更新指令====
public static final String UPDATE = "UPDATE JoinList SET joinList_GrpId=? ,joinList_MemId=?,joinList_isInvited=? WHERE joinList_GrpId=? AND joinList_MemId=? " ; 
	//====以下是刪除指令====
public static final String DELETE = "DELETE FROM JoinList WHERE joinList_GrpId=? AND joinList_MemId=?" ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT joinList_GrpId,joinList_MemId FROM joinlist WHERE =? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT joinList_GrpId,joinList_MemId,joinList_isInvited  FROM JoinList" ; 

public static final String BATCH_INSERT = "INSERT INTO JoinList(joinList_GrpId,joinList_MemId,joinList_isInvited ) VALUES  ( ? , ? , ? ) " ;

	//====以下是新增指令====
	//====以下是改寫insert方法====
	@Override
	public void insert(JoinListVO aJoinListVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(JoinListDAO.INSERT_STMT);
			
			pstmt.setString(1, aJoinListVO.getJoinList_GrpId());
			pstmt.setString(2, aJoinListVO.getJoinList_MemId());
			pstmt.setString(3, aJoinListVO.getJoinList_isInvited());
						
System.out.println(aJoinListVO.getJoinList_GrpId());
System.out.println(aJoinListVO.getJoinList_MemId());
						
			pstmt.executeUpdate();
			
			con.commit();
		} catch (SQLException se) {
			se.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public void update(JoinListVO aJoinListVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(JoinListDAO.UPDATE);
			
			pstmt.setString(1, aJoinListVO.getJoinList_GrpId());
			pstmt.setString(2, aJoinListVO.getJoinList_MemId());
			pstmt.setString(3, aJoinListVO.getJoinList_isInvited());
			pstmt.setString(4, aJoinListVO.getJoinList_GrpId());
			pstmt.setString(5, aJoinListVO.getJoinList_MemId());
			
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException se) {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public void delete_By_joinList_GrpId_joinList_MemId(String joinList_GrpId,String joinList_MemId){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			
			
			pstmt = con.prepareStatement(JoinListDAO.DELETE);
			pstmt.setString (1,joinList_GrpId);
			pstmt.setString (2,joinList_MemId);
			pstmt.executeUpdate();
			
			
			con.commit();
		} catch (SQLException se) {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public void delete_By_joinList_MemId(String  aJoinList){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(JoinListDAO.DELETE);
			pstmt.setString (1,aJoinList);
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
	public JoinListVO findByPrimaryKey_By_joinList_GrpId(String  aPK_NO){
		JoinListVO joinlistVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(JoinListDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				joinlistVO = new JoinListVO();
				joinlistVO.setJoinList_GrpId(rs.getString("joinList_GrpId"));
				joinlistVO.setJoinList_MemId(rs.getString("joinList_MemId"));
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
		return joinlistVO; 
	} 
	//====以下是改寫findByPrimaryKey方法====
	@Override
	public JoinListVO findByPrimaryKey_By_joinList_MemId(String  aPK_NO){
		JoinListVO joinlistVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(JoinListDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				joinlistVO = new JoinListVO();
				joinlistVO.setJoinList_GrpId(rs.getString("joinList_GrpId"));
				joinlistVO.setJoinList_MemId(rs.getString("joinList_MemId"));
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
		return joinlistVO; 
	} 

    @Override
    public List<JoinListVO> getAll() {
        List<JoinListVO> list = new ArrayList<JoinListVO>();
        JoinListVO joinlistVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // joinlistVO 也稱為 Domain objects
                joinlistVO = new JoinListVO();
                joinlistVO.setJoinList_GrpId(rs.getString("joinList_GrpId"));
                joinlistVO.setJoinList_MemId(rs.getString("joinList_MemId"));
                joinlistVO.setJoinList_isInvited(rs.getString("joinList_isInvited"));

                list.add(joinlistVO); // Store the row in the vector
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
	public void BatchInsert(Set<JoinListVO> joinlistVOSet) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
					
			pstmt = con.prepareStatement(JoinListDAO.BATCH_INSERT);
			
			for(JoinListVO aJoinListVO : joinlistVOSet){
						System.out.println("aJoinListVO.getJoinList_MemId()==="+aJoinListVO.getJoinList_MemId());						
				pstmt.setString(1, aJoinListVO.getJoinList_GrpId());
				pstmt.setString(2, aJoinListVO.getJoinList_MemId());
				pstmt.setString(3, aJoinListVO.getJoinList_isInvited());
			
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
						
			con.commit();
			
		} catch (SQLException se) {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	

}