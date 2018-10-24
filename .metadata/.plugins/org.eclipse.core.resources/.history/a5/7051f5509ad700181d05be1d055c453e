package com.thirdware.guptabookstore.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thirdware.guptabookstore.getconnection.ConnectionProvider;
import com.thirdware.guptabookstore.dao.SubjectDao;
import com.thirdware.guptabookstore.models.Book;
import com.thirdware.guptabookstore.models.Subject;

public class SubjectDaoImpl implements SubjectDao {
	public int insertSubject(Subject subject) {
		ConnectionProvider databaseConnection = new ConnectionProvider();
		Connection con = databaseConnection.CONN();
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
		} else {
			try {
				String query = "insert into subject values(?,?,?)";
				PreparedStatement psmt = con.prepareStatement(query);

				psmt.setInt(1, getmaxId() + 1);
				psmt.setString(2, subject.getSubname());
				psmt.setString(3, subject.getSubdescription());

				int i = psmt.executeUpdate();
				if (i > 0) {
					System.out.println("Inserted Successfully");

				}
				psmt.close();
				con.close();

			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		return 0;
	}

	public List<Book> getSubject(int id) {

		ConnectionProvider databaseConnection = new ConnectionProvider();
		Connection con = databaseConnection.CONN();
		if (con == null) {
			System.out.println("Not connected, Please check");
			return null;
		} else {
			String query = "select * from book where subid = ?";
			try {
				List<Book> ls=new ArrayList<>();

				PreparedStatement psmt = con.prepareStatement(query);
				psmt.setInt(1, id);
				ResultSet result = psmt.executeQuery();

				Book book=new Book();
				
				while (result.next()) {		
					
					book.setBookid(result.getInt(1));
					book.setBookname(result.getString(2));
					book.setBookdesc(result.getString(3));
					book.setQuantity(result.getInt(4));
					book.setPrice(result.getFloat(5));
					book.setSubid(result.getInt(6));
					book.setAuthid(result.getInt(7));
					book.setBookstatus(result.getInt(8));
					ls.add(book);
				}
				return ls;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private int getmaxId()
	{
		int maxId=0;
		String query="select max(subid) from subject";
		try{
			ConnectionProvider databaseConnection = new ConnectionProvider();
			Connection con = databaseConnection.CONN();
			if(con==null)
				System.out.println("please check the connection");
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				maxId=rs.getInt(1);
			}
			System.out.println("maxid "+maxId);
			return maxId;
		}catch(Exception e){System.out.println(e);}
		return -1;
		
	}
	
	public List<Subject> getAllSubject() {
		// TODO Auto-generated method stub
		ConnectionProvider databaseConnection = new ConnectionProvider();
		Connection con = databaseConnection.CONN();
		if(con==null)
			System.out.println("please check the connection");
		else{
			try{
				List<Subject> ls=new ArrayList<>();
			String query="select * from subject";
			PreparedStatement psm=con.prepareStatement(query);
			ResultSet result=psm.executeQuery();
			while(result.next()){
				Subject sub=new Subject();
				sub.setSubid(result.getInt(1));
				sub.setSubname(result.getString(2));
				sub.setSubdescription(result.getString(3));
				ls.add(sub);
			}
			return ls;
			}catch(Exception e){
				System.out.println(e);
				}
		}
		return null;
	}


}
