package com.emg_H.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.emg_H_Msg.model.Emg_H_MsgVO;


public class Emg_HDAO implements Emg_HDAO_interface{
	
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
			"Insert into emg_help values (emg_help_seq1.nextval,?,?,?,?,?,?,null,?,?,?,?,?,null)";
	private static final String GET_ALL_STMT = 
			"SELECT emg_H_Id,mem_Id,  emg_H_start_date, emg_H_end_date,emg_H_title,emg_H_content,emg_H_pic,emg_H_city,emg_H_town,emg_H_road,emg_H_lon,emg_H_lat,emg_H_status FROM emg_help order by emg_H_Id desc";
	private static final String GET_ONE_STMT = 
			"SELECT emg_H_Id,mem_Id,  emg_H_start_date, emg_H_end_date,emg_H_title,emg_H_content,emg_H_pic,emg_H_city,emg_H_town,emg_H_road,emg_H_lon,emg_H_lat,emg_H_status FROM emg_help  where emg_H_Id = ?";
	private static final String GET_EMG_H_MSG_ByEMG_H_ID_STMT = 
			"SELECT emg_H_Msg_Id,mem_Id,Emg_H_Id, emg_H_msg_start,emg_H_Msg_content FROM emg_H_Msg where emg_H_Id = ? order by emg_H_Msg_Id";

		private static final String DELETE_EMG_H_MSG = 
			"DELETE FROM emg_H_Msg where emg_H_Id = ?";
		private static final String DELETE_EMG_H= 
			"DELETE FROM emg_help where emg_H_Id = ?";
		
		
		
		
	

	@Override
	public Emg_HVO insert(Emg_HVO emg_HVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			
			con.setAutoCommit(false);	
			
			//自增綁定PK
			String cols[] = {"Emg_H_Id"};
			pstmt = con.prepareStatement(INSERT_STMT,cols);

			pstmt.setString(1, emg_HVO.getMem_Id());
			pstmt.setTimestamp(2, emg_HVO.getEmg_H_start_date());
			pstmt.setTimestamp(3, emg_HVO.getEmg_H_end_date());
			pstmt.setString(4, emg_HVO.getEmg_H_title());
			pstmt.setString(5, emg_HVO.getEmg_H_content());
			pstmt.setBytes(6, emg_HVO.getEmg_H_pic());
			pstmt.setString(7, emg_HVO.getEmg_H_city());
			pstmt.setString(8, emg_HVO.getEmg_H_town());
			pstmt.setString(9, emg_HVO.getEmg_H_road());
			pstmt.setDouble(10, emg_HVO.getEmg_H_Lon());
			pstmt.setDouble(11, emg_HVO.getEmg_H_Lat());
			
			pstmt.executeUpdate();
			
			//掘取對應的自增主鍵值
			String next_Emg_H_Id = null;
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				next_Emg_H_Id = rs.getString(1);
				System.out.println("自增主鍵值= " + next_Emg_H_Id );
			} else {
				System.out.println("未取得自增主鍵值");
			}
			
			//把PK 放回VO裡 return
			emg_HVO.setEmg_H_Id(next_Emg_H_Id);
			
			con.commit();
			con.setAutoCommit(true);
			
			return emg_HVO;

			// Handle any SQL errors
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
	public void delete(String emg_H_Id) {
		// TODO Auto-generated method stub
		
		int updateCount_EmgMsg = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();

			// 1●設定於 pstm.executeUpdate()之前
						con.setAutoCommit(false);

						// 先刪除 留言table的求救編號
						pstmt = con.prepareStatement(DELETE_EMG_H_MSG);
						pstmt.setString(1, emg_H_Id);
						updateCount_EmgMsg = pstmt.executeUpdate();
						// 再刪除求救編號
						pstmt = con.prepareStatement(DELETE_EMG_H);
						pstmt.setString(1, emg_H_Id);
						pstmt.executeUpdate();

						// 2●設定於 pstm.executeUpdate()之後
						con.commit();
						con.setAutoCommit(true);
						System.out.println("刪除求救編號 " + emg_H_Id + " 時,求救的留言 " + updateCount_EmgMsg + " 同時被刪除");

			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public Emg_HVO findByPrimaryKey(String emg_H_Id) {
		// TODO Auto-generated method stub

		Emg_HVO emg_HVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, emg_H_Id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				emg_HVO = new Emg_HVO();

				emg_HVO.setEmg_H_Id(rs.getString("emg_H_Id"));
				emg_HVO.setMem_Id(rs.getString("mem_Id"));
				emg_HVO.setEmg_H_start_date(rs.getTimestamp("emg_H_start_date"));
				emg_HVO.setEmg_H_end_date(rs.getTimestamp("emg_H_end_date"));
				emg_HVO.setEmg_H_title(rs.getString("emg_H_title"));
				emg_HVO.setEmg_H_content(rs.getString("emg_H_content"));
				emg_HVO.setEmg_H_pic(rs.getBytes("emg_H_pic"));
				emg_HVO.setEmg_H_city(rs.getString("emg_H_city"));
				emg_HVO.setEmg_H_town(rs.getString("emg_H_town"));
				emg_HVO.setEmg_H_road(rs.getString("emg_H_road"));
				emg_HVO.setEmg_H_Lon(rs.getDouble("emg_H_Lon"));
				emg_HVO.setEmg_H_Lat(rs.getDouble("emg_H_Lat"));
				emg_HVO.setEmg_H_status(rs.getString("emg_H_status"));

			}

		} catch (SQLException e) {
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
		return emg_HVO;
	}

	@Override
	public List<Emg_HVO> getAll() {
		// TODO Auto-generated method stub

		List<Emg_HVO> list = new ArrayList<Emg_HVO>();
		Emg_HVO emg_HVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				emg_HVO = new Emg_HVO();

				emg_HVO.setEmg_H_Id(rs.getString("emg_H_Id"));
				emg_HVO.setMem_Id(rs.getString("mem_Id"));
				emg_HVO.setEmg_H_start_date(rs.getTimestamp("emg_H_start_date"));
				emg_HVO.setEmg_H_end_date(rs.getTimestamp("emg_H_end_date"));
				emg_HVO.setEmg_H_title(rs.getString("emg_H_title"));
				emg_HVO.setEmg_H_content(rs.getString("emg_H_content"));
				emg_HVO.setEmg_H_pic(rs.getBytes("emg_H_pic"));
				emg_HVO.setEmg_H_city(rs.getString("emg_H_city"));
				emg_HVO.setEmg_H_town(rs.getString("emg_H_town"));
				emg_HVO.setEmg_H_road(rs.getString("emg_H_road"));
				emg_HVO.setEmg_H_Lon(rs.getDouble("emg_H_lon"));
				emg_HVO.setEmg_H_Lat(rs.getDouble("emg_H_lat"));
				emg_HVO.setEmg_H_status(rs.getString("emg_H_status"));
				list.add(emg_HVO);

			}

		} catch (SQLException e) {
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
		return list;
	}

	@Override
	public Set<Emg_H_MsgVO> getEmg_H_MsgByEmg_H_Id(String emg_H_Id) {
		// TODO Auto-generated method stub
		
		Set<Emg_H_MsgVO> set = new LinkedHashSet<Emg_H_MsgVO>();
		Emg_H_MsgVO	 emg_H_MsgVO = null;
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
	
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_EMG_H_MSG_ByEMG_H_ID_STMT);
			
			pstmt.setString(1, emg_H_Id);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				
				emg_H_MsgVO = new Emg_H_MsgVO();				
				
				emg_H_MsgVO.setEmg_H_Msg_Id(rs.getString("emg_H_Msg_Id"));
				emg_H_MsgVO.setMem_Id(rs.getString("mem_Id"));
				emg_H_MsgVO.setEmg_H_Id(rs.getString("emg_H_Id"));
				emg_H_MsgVO.setEmg_H_Msg_start(rs.getTimestamp("emg_H_Msg_start"));
				emg_H_MsgVO.setEmg_H_Msg_content(rs.getString("emg_H_Msg_content"));
				set.add(emg_H_MsgVO); // Store the row in the vector
				
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
