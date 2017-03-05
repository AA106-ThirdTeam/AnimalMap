package com.priv_message.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.rel_list.model.Rel_ListDAO;
import com.rel_list.model.Rel_ListVO;

public class Priv_messageDAO implements Priv_message_interface{
	private static DataSource ds = null; 
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB_dream");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static final String INSERT_STMT = "INSERT INTO Priv_message(PRIVMSG_ID,PRIVMSGSEND_MEMID,PRIVMSGREC_MEMID,PRIVMSG_CONTENT,PRIVMSG_SENDTIME,PRIVMSG_TYPE ) VALUES  (PRIV_MESSAGE_SEQ1.nextval, ? , ? , ? , ?, ? ) " ; 
	public static final String UPDATE_STMT = "UPDATE Priv_message SET PRIVMSGSEND_MEMID=?,PRIVMSGREC_MEMID=?,PRIVMSG_CONTENT=?,PRIVMSG_SENDTIME=?, PRIVMSG_TYPE=? WHERE PRIVMSG_ID=?" ; 
	public static final String GET_ALL_STMT = "SELECT PRIVMSG_ID,PRIVMSGSEND_MEMID,PRIVMSGREC_MEMID,PRIVMSG_CONTENT,PRIVMSG_SENDTIME, PRIVMSG_TYPE FROM Priv_message order by PRIVMSG_SENDTIME" ; 
	private static final String FIND_BY_PRIME_KEY_STMT = "SELECT PRIVMSG_ID,PRIVMSGSEND_MEMID,PRIVMSGREC_MEMID,PRIVMSG_CONTENT,PRIVMSG_SENDTIME, PRIVMSG_TYPE FROM Priv_message WHERE PRIVMSGSEND_MEMID=? AND PRIVMSGREC_MEMID=? ";
	private static final String GET_PRIV_MESSAGE_BY_SEND_MEMID =  "SELECT PRIVMSG_ID,PRIVMSGSEND_MEMID,PRIVMSGREC_MEMID,PRIVMSG_CONTENT,PRIVMSG_SENDTIME, PRIVMSG_TYPE FROM Priv_message WHERE PRIVMSGSEND_MEMID=? order by PRIVMSG_SENDTIME desc";
	private static final String GET_PRIV_MESSAGE_BY_REC_MEMID =  "SELECT PRIVMSG_ID,PRIVMSGSEND_MEMID,PRIVMSGREC_MEMID,PRIVMSG_CONTENT,PRIVMSG_SENDTIME, PRIVMSG_TYPE FROM Priv_message WHERE PRIVMSGREC_MEMID=? order by PRIVMSG_SENDTIME desc";
	private static final String GET_All_PRIV_MESSAGE_BY_MEMID =  "SELECT PRIVMSG_ID,PRIVMSGSEND_MEMID,"
			+ "PRIVMSGREC_MEMID,PRIVMSG_CONTENT,PRIVMSG_SENDTIME, PRIVMSG_TYPE FROM Priv_message "
			+ "WHERE (PRIVMSGREC_MEMID=? AND PRIVMSGSEND_MEMID=?) OR (PRIVMSGREC_MEMID=? AND PRIVMSGSEND_MEMID=?) "
			+ "order by PRIVMSG_SENDTIME asc";
	
	
	
	@Override
	public void insert(Priv_messageVO aPriv_messageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(Priv_messageDAO.INSERT_STMT);
			pstmt.setString (1, aPriv_messageVO.getPrivMsgSend_MemId());
			pstmt.setString (2, aPriv_messageVO.getPrivMsgRec_MemId());
			pstmt.setString (3, aPriv_messageVO.getPrivMsg_content());
			pstmt.setTimestamp (4, aPriv_messageVO.getPrivMsg_SendTime());
			pstmt.setString (5, aPriv_messageVO.getPrivMsg_type());
			pstmt.executeUpdate();
			con.commit();
			
		} catch (SQLException se) {
			se.printStackTrace();
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
		
	}

	@Override
	public void update(Priv_messageVO aPriv_messageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(Priv_messageDAO.UPDATE_STMT);
			pstmt.setString (1, aPriv_messageVO.getPrivMsgSend_MemId());
			pstmt.setString (2, aPriv_messageVO.getPrivMsgRec_MemId());
			pstmt.setString (3, aPriv_messageVO.getPrivMsg_content());
			pstmt.setTimestamp (4, aPriv_messageVO.getPrivMsg_SendTime());
			pstmt.setString (5, aPriv_messageVO.getPrivMsg_type());
			pstmt.setString (6, aPriv_messageVO.getPrivMsg_Id());
			
			
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
		
	}


		
	
	@Override
	public Set<Priv_messageVO> getPriv_MessageBySend_MemId(String privMsgSend_MemId) {
		Set<Priv_messageVO> set = new LinkedHashSet<Priv_messageVO>();
		Priv_messageVO priv_messageVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
			
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_PRIV_MESSAGE_BY_SEND_MEMID);
            
            pstmt.setString(1, privMsgSend_MemId);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // rel_listVO 也稱為 Domain objects
            	priv_messageVO = new Priv_messageVO();
            	priv_messageVO.setPrivMsg_Id(rs.getString("privMsg_Id"));
				priv_messageVO.setPrivMsgSend_MemId(rs.getString("privMsgSend_MemId"));
				priv_messageVO.setPrivMsgRec_MemId(rs.getString("privMsgRec_MemId"));
				priv_messageVO.setPrivMsg_content(rs.getString("privMsg_content"));
				priv_messageVO.setPrivMsg_SendTime(rs.getTimestamp("privMsg_SendTime"));
				priv_messageVO.setPrivMsg_type(rs.getString("privMsg_type"));

				set.add(priv_messageVO); // Store the row in the vector
            }
            
            
            return set;
                        
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
	}
	
	
	@Override
	public Set<Priv_messageVO> getPriv_MessageByRec_MemId(String privMsgRec_MemId) {
		Set<Priv_messageVO> set = new LinkedHashSet<Priv_messageVO>();
		Priv_messageVO priv_messageVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
			
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_PRIV_MESSAGE_BY_REC_MEMID);
            
            pstmt.setString(1, privMsgRec_MemId);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // rel_listVO 也稱為 Domain objects
            	priv_messageVO = new Priv_messageVO();
            	priv_messageVO.setPrivMsg_Id(rs.getString("privMsg_Id"));
				priv_messageVO.setPrivMsgSend_MemId(rs.getString("privMsgSend_MemId"));
				priv_messageVO.setPrivMsgRec_MemId(rs.getString("privMsgRec_MemId"));
				priv_messageVO.setPrivMsg_content(rs.getString("privMsg_content"));
				priv_messageVO.setPrivMsg_SendTime(rs.getTimestamp("privMsg_SendTime"));
				priv_messageVO.setPrivMsg_type(rs.getString("privMsg_type"));

				set.add(priv_messageVO); // Store the row in the vector
            }
            
            
            return set;
                        
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
	}
	
	@Override
	public Priv_messageVO findByPrimaryKey(String privMsgSend_MemId, String privMsgRec_MemId) {
		Priv_messageVO priv_messageVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Priv_messageDAO.FIND_BY_PRIME_KEY_STMT);
			pstmt.setString (1,privMsgSend_MemId);
			pstmt.setString (2,privMsgRec_MemId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				priv_messageVO = new Priv_messageVO();
				priv_messageVO.setPrivMsg_Id(rs.getString("privMsg_Id"));
				priv_messageVO.setPrivMsgSend_MemId(rs.getString("privMsgSend_MemId"));
				priv_messageVO.setPrivMsgRec_MemId(rs.getString("privMsgRec_MemId"));
				priv_messageVO.setPrivMsg_content(rs.getString("privMsg_content"));
				priv_messageVO.setPrivMsg_SendTime(rs.getTimestamp("privMsg_SendTime"));
				priv_messageVO.setPrivMsg_type(rs.getString("privMsg_type"));
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
		return null;
	}

	@Override
	public Set<Priv_messageVO> getAllPriv_MessageByMem_Id(String privMsgSend_MemId,String privMsgRec_MemId) {
		Set<Priv_messageVO> set = new LinkedHashSet<Priv_messageVO>();
		Priv_messageVO priv_messageVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
			
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_All_PRIV_MESSAGE_BY_MEMID);
            
            pstmt.setString(1, privMsgSend_MemId);
            pstmt.setString(2, privMsgRec_MemId);
            
            pstmt.setString(3, privMsgRec_MemId);
            pstmt.setString(4, privMsgSend_MemId);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // rel_listVO 也稱為 Domain objects
            	priv_messageVO = new Priv_messageVO();
            	priv_messageVO.setPrivMsg_Id(rs.getString("privMsg_Id"));
				priv_messageVO.setPrivMsgSend_MemId(rs.getString("privMsgSend_MemId"));
				priv_messageVO.setPrivMsgRec_MemId(rs.getString("privMsgRec_MemId"));
				priv_messageVO.setPrivMsg_content(rs.getString("privMsg_content"));
				priv_messageVO.setPrivMsg_SendTime(rs.getTimestamp("privMsg_SendTime"));
				priv_messageVO.setPrivMsg_type(rs.getString("privMsg_type"));

				set.add(priv_messageVO); // Store the row in the vector
            }
            
            
            return set;
                        
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
	}
	
	public void batchUpdate(Set<Priv_messageVO> priv_messageSet) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(Priv_messageDAO.UPDATE_STMT);
			
			for(Priv_messageVO aPriv_messageVO : priv_messageSet){
				pstmt.setString (1, aPriv_messageVO.getPrivMsgSend_MemId());
				pstmt.setString (2, aPriv_messageVO.getPrivMsgRec_MemId());
				pstmt.setString (3, aPriv_messageVO.getPrivMsg_content());
				pstmt.setTimestamp (4, aPriv_messageVO.getPrivMsg_SendTime());
				pstmt.setString (5, aPriv_messageVO.getPrivMsg_type());
				
				pstmt.setString (6, aPriv_messageVO.getPrivMsg_Id());
				
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			con.commit();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
		
	}

	
	
	

}
