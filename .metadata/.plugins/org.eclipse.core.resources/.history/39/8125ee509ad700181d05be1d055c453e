package com.thirdware.guptabookstore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.thirdware.guptabookstore.getconnection.ConnectionProvider;
import com.thirdware.guptabookstore.dao.CommentDao;
import com.thirdware.guptabookstore.models.Comment;

public class CommentDaoImpl implements CommentDao {

	@Override
	public void insertComment(Comment comment) {
		ConnectionProvider databaseConnection = new ConnectionProvider();
		Connection con = databaseConnection.CONN();
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
		} else {
			try {
				String query = "insert into comment(content,customername,customerid,bookid) values(?,?,?,?)";
				PreparedStatement psmt = con.prepareStatement(query);
				comment = new Comment();
				psmt.setString(1, comment.getContent());
				psmt.setString(2, comment.getCustomername());
				psmt.setInt(3, comment.getCustomerId());
				psmt.setInt(4, comment.getBookid());
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

	}

	@Override
	public List<Comment> getAll(int id) {
		ConnectionProvider databaseConnection = new ConnectionProvider();
		Connection con = databaseConnection.CONN();
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
			return null;
		} else {
			try {
				String query = "select * from comment where bookid=?";
				PreparedStatement psmt = con.prepareStatement(query);
				psmt.setInt(1, id);
				ResultSet result = psmt.executeQuery();
				List<Comment> ls = new ArrayList<>();
				while (result.next()) {
					Comment comment = new Comment();
					comment.setContent(result.getString(2));
					comment.setCustomername(result.getString(5));
					comment.setCustomerId(result.getInt(3));
					comment.setBookid(result.getInt(4));
					ls.add(comment);
				}
				result.close();
				psmt.close();
				con.close();
				return ls;

			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		return null;

	}

}
