package com.thirdware.guptabookstore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thirdware.guptabookstore.getconnection.ConnectionProvider;
import com.thirdware.guptabookstore.dao.AuthorDao;
import com.thirdware.guptabookstore.models.Author;
import com.thirdware.guptabookstore.models.Book;

public class AuthorDaoImpl implements AuthorDao {

	public int insertAuthor(Author author) {
		ConnectionProvider databaseConnection = new ConnectionProvider();
		Connection con = databaseConnection.CONN();
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
		} else {
			try {
				String query = "insert into author values(?,?,?)";
				PreparedStatement psmt = con.prepareStatement(query);

				psmt.setInt(1, getMaxId() + 1);
				psmt.setString(2, author.getAuthname());
				psmt.setString(3, author.getAuthdesc());

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

	public List<Book> getAuthor(int id) {

		ConnectionProvider databaseConnection = new ConnectionProvider();
		Connection con = databaseConnection.CONN();
		if (con == null) {
			System.out.println("Not connected, Please check");
		} else {
			String query = "select * from book where authid = ?";
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
	  


	private int getMaxId() {
			// TODO Auto-generated method stub
		
			int maxId=0;
			String query="select max(authorid) from author";
			try{
				ConnectionProvider databaseConnection = new ConnectionProvider();
				Connection con = databaseConnection.CONN();
				if(con==null)
					System.out.println("please check the connection");
				PreparedStatement st=con.prepareStatement(query);
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					maxId=rs.getInt(1);
				}
				System.out.println("maxid "+maxId);
				return maxId;
			}catch(Exception e){System.out.println(e);}
			return -1;
		}

	@Override
	public List<Author> getallAuthor() {
		// TODO Auto-generated method stub
		ConnectionProvider databaseConnection = new ConnectionProvider();
		Connection con = databaseConnection.CONN();
		if(con==null)
			System.out.println("please check the connection");
		else{
			try{
				List<Author> ls=new ArrayList<>();
			String query="select * from author";
			PreparedStatement psmt=con.prepareStatement(query);
			ResultSet result=psmt.executeQuery();
			while(result.next()){
				Author auth=new Author();
				auth.setAuthid(result.getInt(1));
				auth.setAuthname(result.getString(2));
				auth.setAuthdesc(result.getString(3));
				ls.add(auth);
			}
			return ls;
			}catch(Exception e){
				System.out.println(e);
				}
		}
		return null;
	}

}
