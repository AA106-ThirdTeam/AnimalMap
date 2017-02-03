package com.pet_message.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	自家寵物留言<br>
 *	英文:pet_Message<br>
 */ 
public class Pet_MessageDAO implements Pet_MessageDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO pet_Message(pet_Mes_No,pet_Id,mem_Id,pet_Mes,pet_Mes_time ) VALUES  ( pet_Message_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE pet_Message SET pet_Mes=?,pet_Mes_time=?  WHERE pet_Mes_No=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM pet_Message WHERE pet_Mes_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT pet_Mes_No,pet_Id,mem_Id,pet_Mes,to_char(pet_Mes_time,'yyyy-mm-dd') pet_Mes_time FROM pet_message WHERE pet_Mes_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT pet_Mes_No,pet_Id,mem_Id,pet_Mes,to_char(pet_Mes_time,'yyyy-mm-dd') pet_Mes_time FROM pet_Message order by pet_Mes_No " ; 
	//====以下是新增指令====
	private static final String UPDATE_PET_MES =" UPDATE pet_Message set PET_MES=?  WHERE pet_Mes_No=? " ; 
	private static final String UPDATE_PET_MES_TIME =" UPDATE pet_Message set PET_MES_TIME=?  WHERE pet_Mes_No=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Pet_MessageVO aPet_MessageVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_MessageDAO.INSERT_STMT);
			pstmt.setString (1, aPet_MessageVO.getPet_Id());
			pstmt.setString (2, aPet_MessageVO.getMem_Id());
			pstmt.setString (3, aPet_MessageVO.getPet_Mes());
			pstmt.setDate (4, aPet_MessageVO.getPet_Mes_time());
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
	public void update(Pet_MessageVO aPet_MessageVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_MessageDAO.UPDATE);
			pstmt.setString (1, aPet_MessageVO.getPet_Mes());
			pstmt.setDate (2, aPet_MessageVO.getPet_Mes_time());
			pstmt.setString (3, aPet_MessageVO.getPet_Mes_No());
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
	public void delete(String  aPet_Message){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_MessageDAO.DELETE);
			pstmt.setString (1,aPet_Message);
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
	public Pet_MessageVO findByPrimaryKey(String  aPK_NO){
		Pet_MessageVO pet_messageVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_MessageDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pet_messageVO = new Pet_MessageVO();
				pet_messageVO.setPet_Mes_No(rs.getString("pet_Mes_No"));
				pet_messageVO.setPet_Id(rs.getString("pet_Id"));
				pet_messageVO.setMem_Id(rs.getString("mem_Id"));
				pet_messageVO.setPet_Mes(rs.getString("pet_Mes"));
				pet_messageVO.setPet_Mes_time(rs.getDate("pet_Mes_time"));
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
		return pet_messageVO; 
	} 

    @Override
    public List<Pet_MessageVO> getAll() {
        List<Pet_MessageVO> list = new ArrayList<Pet_MessageVO>();
        Pet_MessageVO pet_messageVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // pet_messageVO 也稱為 Domain objects
                pet_messageVO = new Pet_MessageVO();
                pet_messageVO.setPet_Mes_No(rs.getString("pet_Mes_No"));
                pet_messageVO.setPet_Id(rs.getString("pet_Id"));
                pet_messageVO.setMem_Id(rs.getString("mem_Id"));
                pet_messageVO.setPet_Mes(rs.getString("pet_Mes"));
                pet_messageVO.setPet_Mes_time(rs.getDate("pet_Mes_time"));

                list.add(pet_messageVO); // Store the row in the vector
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