package com.animal_index.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Animal_index;
/** 
 *表格名稱 : <br>
 *	動物圖鑑<br>
 *	英文:animal_index<br>
 */ 
public class Animal_indexDAO implements Animal_indexDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO animal_index(animal_No,animal_detail,animal_class,animal_class_No ) VALUES  ( animal_index_seq1.nextval , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE animal_index SET animal_detail=?,animal_class=? ,animal_class_No=?  WHERE animal_No=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM animal_index WHERE animal_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT animal_No,animal_detail,animal_class,animal_class_No FROM animal_index WHERE animal_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT animal_No,animal_detail,animal_class,animal_class_No FROM animal_index order by animal_No " ; 

	//====以下是GET_ByFK_STMT指令====

	//====以下是新增指令====
	private static final String UPDATE_ANIMAL_DETAIL =" UPDATE animal_index set ANIMAL_DETAIL=?  WHERE animal_No=? " ; 
	private static final String UPDATE_ANIMAL_CLASS =" UPDATE animal_index set ANIMAL_CLASS=?  WHERE animal_No=? " ; 
	private static final String UPDATE_ANIMAL_CLASS_NO =" UPDATE animal_index set ANIMAL_CLASS_NO=?  WHERE animal_No=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Animal_indexVO aAnimal_indexVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Animal_indexDAO.INSERT_STMT);
			pstmt.setString (1, aAnimal_indexVO.getAnimal_detail());
			pstmt.setString (2, aAnimal_indexVO.getAnimal_class());
			pstmt.setString (3, aAnimal_indexVO.getAnimal_class_No());
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
	public void update(Animal_indexVO aAnimal_indexVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Animal_indexDAO.UPDATE);
			pstmt.setString (1, aAnimal_indexVO.getAnimal_detail());
			pstmt.setString (2, aAnimal_indexVO.getAnimal_class());
			pstmt.setString (3, aAnimal_indexVO.getAnimal_class_No());
			pstmt.setString (4, aAnimal_indexVO.getAnimal_No());
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
	public void delete(String  aAnimal_index){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Animal_indexDAO.DELETE);
			pstmt.setString (1,aAnimal_index);
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
	public Animal_indexVO findByPrimaryKey(String  aPK_NO){
		Animal_indexVO animal_indexVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Animal_indexDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				animal_indexVO = new Animal_indexVO();
				animal_indexVO.setAnimal_No(rs.getString("animal_No"));
				animal_indexVO.setAnimal_detail(rs.getString("animal_detail"));
				animal_indexVO.setAnimal_class(rs.getString("animal_class"));
				animal_indexVO.setAnimal_class_No(rs.getString("animal_class_No"));
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
		return animal_indexVO; 
	} 

    @Override
    public List<Animal_indexVO> getAll() {
        List<Animal_indexVO> list = new ArrayList<Animal_indexVO>();
        Animal_indexVO animal_indexVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // animal_indexVO 也稱為 Domain objects
                animal_indexVO = new Animal_indexVO();
                animal_indexVO.setAnimal_No(rs.getString("animal_No"));
                animal_indexVO.setAnimal_detail(rs.getString("animal_detail"));
                animal_indexVO.setAnimal_class(rs.getString("animal_class"));
                animal_indexVO.setAnimal_class_No(rs.getString("animal_class_No"));

                list.add(animal_indexVO); // Store the row in the vector
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
    public List<Animal_indexVO> getAll(Map<String, String[]> map) {
        List<Animal_indexVO> list = new ArrayList<Animal_indexVO>();
        Animal_indexVO animal_indexVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Animal_index "
                  + jdbcUtil_CompositeQuery_Animal_index.get_WhereCondition(map)
                  + "order by animal_No";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                animal_indexVO = new Animal_indexVO();
                
                animal_indexVO.setAnimal_No(rs.getString ("animal_No"));
                animal_indexVO.setAnimal_detail(rs.getString ("animal_detail"));
                animal_indexVO.setAnimal_class(rs.getString ("animal_class"));
                animal_indexVO.setAnimal_class_No(rs.getString ("animal_class_No"));
             
                list.add(animal_indexVO); // Store the row in the List
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