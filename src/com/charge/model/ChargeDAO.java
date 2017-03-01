package com.charge.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Charge;


public class ChargeDAO implements ChargeDAO_interface{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AnimalMapDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT =
			"INSERT INTO charge(charge_no,mem_Id,charge_number,pay,applytime) VALUES (charge_seq1.NEXTVAL,?,?,?,?)";
		
	private static final String UPDATE =
			"UPDATE charge set mem_Id= ?,charge_number= ?,pay= ?,applytime= ? where charge_no =?";
	
	private static final String DELETE = 
			"DELETE FROM charge where charge_no=?";
	
	private static final String GET_ALL_STMT =
			"SELECT charge_no,mem_Id,charge_number,pay,to_char(applytime,'yyyy-mm-dd') applytime FROM charge order by charge_no";
	
	private static final String GET_ONE_STMT =
			"SELECT charge_no,mem_Id,charge_number,pay,to_char(applytime,'yyyy-mm-dd') applytime FROM charge where charge_no = ?";

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Charges_ByMem_Id_STMT = 
		"SELECT charge_no,mem_Id,charge_NUMBER,pay,to_char(applytime,'yyyy-mm-dd') applytime FROM Charge WHERE mem_Id = ? order by mem_Id";

	@Override
	public void insert(ChargeVO chargeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, chargeVO.getMem_Id());
			pstmt.setInt(2, chargeVO.getCharge_number());
			pstmt.setInt(3, chargeVO.getPay());
			pstmt.setDate(4, chargeVO.getApplytime());
			
			pstmt.executeUpdate();
			
		}  catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
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

	@Override
	public void update(ChargeVO chargeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, chargeVO.getMem_Id());
			pstmt.setInt(2, chargeVO.getCharge_number());
			pstmt.setInt(3, chargeVO.getPay());
			pstmt.setDate(4, chargeVO.getApplytime());
			pstmt.setString(5, chargeVO.getCharge_no());
			pstmt.executeUpdate();
			
		}  catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
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

	@Override
	public void delete(String charge_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, charge_no);
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
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

	@Override
	public ChargeVO findByPrimaryKey(String charge_no) {
		ChargeVO chargeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setString(1, charge_no);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				chargeVO = new ChargeVO();
				chargeVO.setCharge_no(rs.getString("charge_no"));
				chargeVO.setMem_id(rs.getString("mem_Id"));
				chargeVO.setCharge_number(rs.getInt("charge_number"));
				chargeVO.setPay(rs.getInt("pay"));
				chargeVO.setApplytime(rs.getDate("applytime"));
			}
		}  catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return chargeVO;
	}

	@Override
	public List<ChargeVO> getAll() {
		List<ChargeVO> list = new ArrayList<ChargeVO>();
		ChargeVO chargeVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
			
			chargeVO = new ChargeVO();
			chargeVO.setCharge_no(rs.getString("charge_no"));
			chargeVO.setMem_id(rs.getString("mem_Id"));
			chargeVO.setCharge_number(rs.getInt("charge_number"));
			chargeVO.setPay(rs.getInt("pay"));
			chargeVO.setApplytime(rs.getDate("applytime"));
			list.add(chargeVO);
			}
		}  catch (SQLException se) {
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
	public List<ChargeVO> getAll(Map<String, String[]> map) {
		List<ChargeVO> list = new ArrayList<ChargeVO>();
		ChargeVO chargeVO =null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			con = ds.getConnection();
			String finalSQL = "select * from charge "
		          + jdbcUtil_CompositeQuery_Charge.get_WhereCondition(map)
		          + "order by charge_no";
			pstmt = con.prepareStatement(finalSQL);
			System.out.println("●●finalSQL(by DAO) = "+finalSQL);
			rs = pstmt.executeQuery();
			
			while(rs.next());
			
				chargeVO = new ChargeVO();
				chargeVO.setCharge_no(rs.getString("charge_no"));
				chargeVO.setMem_id(rs.getString("mem_Id"));
				chargeVO.setCharge_number(rs.getInt("charge_number"));
				chargeVO.setPay(rs.getInt("pay"));
				chargeVO.setApplytime(rs.getDate("applytime"));
				list.add(chargeVO);
	}  catch (SQLException se) {
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
	public Set<ChargeVO> getChargesByMem_Id(String mem_Id) {
		Set<ChargeVO> set = new LinkedHashSet<ChargeVO>();
        ChargeVO chargeVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Charges_ByMem_Id_STMT);
            pstmt.setString(1, mem_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                chargeVO = new ChargeVO();
				chargeVO.setCharge_no(rs.getString ("charge_no"));
				chargeVO.setMem_id(rs.getString ("mem_Id"));
				chargeVO.setCharge_number(rs.getInt ("charge_NUMBER"));
				chargeVO.setPay(rs.getInt ("pay"));
				chargeVO.setApplytime(rs.getDate ("applytime"));

                set.add(chargeVO); // Store the row in the vector
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
