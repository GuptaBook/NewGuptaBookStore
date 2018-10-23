package com.thirdware.guptabookstore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.thirdware.guptabookstore.dao.EmpDao;
import com.thirdware.guptabookstore.getconnection.ConnectionProvider;
import com.thirdware.guptabookstore.models.Emp;


public class EmpDaoImpl implements EmpDao {
	ConnectionProvider dbConnection=new ConnectionProvider();
	Connection con=dbConnection.CONN();
	public Emp empRegister(Emp emp) {
		if(con==null)
		{
			System.out.println("Not Connected,Try again");
		}
		else
		{
			String query="insert into emp(ename,email,phoneno,role,password) values(?,?,?,?,?)";
			try
			{
				PreparedStatement pstmt=con.prepareStatement(query);
				//pstmt.setInt(1,emp.getEid());
				pstmt.setString(1,emp.getEname());
				pstmt.setString(2,emp.getEmail());
				pstmt.setString(3,emp.getPhoneno());
				pstmt.setString(4,emp.getRole());
				pstmt.setString(5,emp.getPassword());
				int count=pstmt.executeUpdate();
				
				if(count>0)
				{
					System.out.println("Records affected:"+count);
				}
				if(con!=null)
					con.close();
				if(pstmt!=null)
					   pstmt.close();
				return emp;
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	


	@Override
	public Emp empLogin(String email) {
	{
		ConnectionProvider dbConnection=new ConnectionProvider();
		Connection con=dbConnection.CONN();
		if(con==null)
		{
			System.out.println("Not Connected,Try again");
		}
		else
		{
			String query="select * from emp where email=?";
			try
			{
				PreparedStatement pstmt=con.prepareStatement(query);
			    Emp emp=new Emp();
				pstmt.setString(1,email);
				System.out.println("checking in daoimpl "+email);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					emp.setEid(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setEmail(rs.getString(3));
					emp.setPhoneno(rs.getString(4));
					emp.setRole(rs.getString(5));
					emp.setPassword(rs.getString(6));
				}
				
				if(con!=null)
					con.close();
				if(pstmt!=null)
					   pstmt.close();
				return emp;
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	}

}