package com.mem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemDAO implements MemDAO_interface{
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static{
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/TestDB");
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = "INSERT INTO dept2(deptno,dname,loc) VALUES(dept2_seq.NEXTVAL,?,?)";
	
	
	@Override
	public void insert(MemDAO memDAO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		con = ds.getConnection();
		pstmt = con.prepareStatement(INSERT_STMT);
		
		pstmt.setString(1, deptVO.getDname());
	}

	@Override
	public void delete(Integer memId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MemDAO memDAO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemDAO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
