package com.priv_message.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class Priv_messageDAO_jdbc implements Priv_message_interface{
		
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "aa106g3";
	String passwd = "aa106g3";
	
	
	
	public static final String INSERT_STMT = "INSERT INTO Priv_message(PRIVMSG_ID,PRIVMSGSEND_MEMID,PRIVMSGREC_MEMID,PRIVMSG_CONTENT,PRIVMSG_SENDTIME,PRIVMSG_TYPE ) VALUES  (priv_message_sq.nextval, ? , ? , ? , ?, ? )  " ; 
	public static final String UPDATE_STMT = "UPDATE Priv_message SET PRIVMSGSEND_MEMID=?,PRIVMSGREC_MEMID=?,PRIVMSG_CONTENT=?,PRIVMSG_SENDTIME=?, PRIVMSG_TYPE=? WHERE PRIVMSG_ID=?" ; 
	public static final String GET_ALL_STMT = "SELECT PRIVMSG_ID,PRIVMSGSEND_MEMID,PRIVMSGREC_MEMID,PRIVMSG_CONTENT,PRIVMSG_SENDTIME, PRIVMSG_TYPE FROM Priv_message order by PRIVMSG_SENDTIME" ; 
	private static final String FIND_BY_PRIME_KEY_STMT = "SELECT PRIVMSG_ID,PRIVMSGSEND_MEMID,PRIVMSGREC_MEMID,PRIVMSG_CONTENT,PRIVMSG_SENDTIME, PRIVMSG_TYPE FROM Priv_message WHERE PRIVMSGSEND_MEMID=? AND PRIVMSGREC_MEMID=? ";
	private static final String GET_PRIV_MESSAGE_BY_SEND_MEMID =  "SELECT PRIVMSG_ID,PRIVMSGSEND_MEMID,PRIVMSGREC_MEMID,PRIVMSG_CONTENT,PRIVMSG_SENDTIME, PRIVMSG_TYPE FROM Priv_message WHERE PRIVMSGSEND_MEMID=? order by PRIVMSG_SENDTIME";
	private static final String GET_PRIV_MESSAGE_BY_REC_MEMID =  "SELECT PRIVMSG_ID,PRIVMSGSEND_MEMID,PRIVMSGREC_MEMID,PRIVMSG_CONTENT,PRIVMSG_SENDTIME, PRIVMSG_TYPE FROM Priv_message WHERE PRIVMSGREC_MEMID=? order by PRIVMSG_SENDTIME";
	
	
	public static void main(String args[]){
		Priv_messageDAO_jdbc dao = new Priv_messageDAO_jdbc();
		
	    Priv_messageVO privMsgVO = new Priv_messageVO();
	    privMsgVO.setPrivMsgSend_MemId("1000002");
	    privMsgVO.setPrivMsgRec_MemId("1000000");
	    privMsgVO.setPrivMsg_SendTime(new Timestamp(System.currentTimeMillis()));
	    privMsgVO.setPrivMsg_type("0");
	    privMsgVO.setPrivMsg_content("今天天氣真好");
	    
	    dao.insert(privMsgVO);	    
	    

	}
	
	
	
	
	@Override
	public void insert(Priv_messageVO aPriv_messageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(Priv_messageDAO_jdbc.INSERT_STMT);
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(Priv_messageDAO_jdbc.UPDATE_STMT);
			
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			
        	Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
            
            
            
                        
            // Handle any driver errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
            // Clean up JDBC resources
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public Set<Priv_messageVO> getPriv_MessageByRec_MemId(String privMsgRec_MemId) {
		Set<Priv_messageVO> set = new LinkedHashSet<Priv_messageVO>();
		Priv_messageVO priv_messageVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
			
        	Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
            
            
           
                        
            // Handle any driver errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
            // Clean up JDBC resources
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public Priv_messageVO findByPrimaryKey(String privMsgSend_MemId, String privMsgRec_MemId) {
		Priv_messageVO priv_messageVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(Priv_messageDAO_jdbc.FIND_BY_PRIME_KEY_STMT);
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public Set<Priv_messageVO> getAllPriv_MessageByMem_Id(String privMsgSend_MemId) {
		// TODO Auto-generated method stub
		return null;
	}




	
	
	

}
