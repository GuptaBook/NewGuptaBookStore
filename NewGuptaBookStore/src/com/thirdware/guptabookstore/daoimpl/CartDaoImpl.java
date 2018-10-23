package com.thirdware.guptabookstore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.thirdware.guptabookstore.dao.CartDao;
import com.thirdware.guptabookstore.getconnection.ConnectionProvider;
import com.thirdware.guptabookstore.models.Book;
import com.thirdware.guptabookstore.models.Cart;
import com.thirdware.guptabookstore.models.Customer;

public class CartDaoImpl implements CartDao {

	ConnectionProvider databaseConnection = new ConnectionProvider();
	Connection con = databaseConnection.CONN();

	@Override
	public int addCart(Cart cart) {
		con = databaseConnection.CONN();

		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
		} else {
			try {
				String query = "insert into cart(bookid,bookname,customername,quantity,price,cid) values(?,?,?,?,?,?)";
				PreparedStatement psmt = con.prepareStatement(query);
				
				psmt.setInt(1, cart.getBookId());
				psmt.setString(2, cart.getBookName());
				psmt.setString(3, cart.getCustomername());
				psmt.setInt(4, cart.getQuantity());
				psmt.setFloat(5, cart.getPrice());
				psmt.setInt(6, cart.getCustomerId());
				int i = psmt.executeUpdate();
				if (i > 0) {
					System.out.println("Inserted Successfully");

				}
				psmt.close();
				con.close();
				return 0;
			}

			catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return 0;

	}

	@Override
	public List<Cart> getCart(String email) {
		con = databaseConnection.CONN();
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
			return null;
		} else {
			try {
				String query = "select * from cart where customername=?";
				PreparedStatement psmt = con.prepareStatement(query);
				psmt.setString(1, email);
				ResultSet result = psmt.executeQuery();
				List<Cart> ls = new ArrayList<>();
				while (result.next()) {
					Cart cart = new Cart();
					cart.setCartId(result.getInt(1));
					cart.setBookId(result.getInt(6));
					cart.setBookName(result.getString(2));
					cart.setCustomerId(result.getInt(5));
					cart.setQuantity(result.getInt(3));
					cart.setPrice(result.getFloat(4));
					ls.add(cart);
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

	@Override
	public int deleteCart(int id) {
		con = databaseConnection.CONN();
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
		} else {
			try {
				String query = "delete from cart where cartid=?";
				PreparedStatement psmt = con.prepareStatement(query);
				psmt.setInt(1,id);
				int i = psmt.executeUpdate();
				if (i > 0) {

					System.out.println("Deleted Successfully");

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

	@Override
	public int deleteAll(String email) {
		con = databaseConnection.CONN();
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
		} else {
			try {
				String query = "delete from cart where customername=?";
				PreparedStatement psmt = con.prepareStatement(query);
				psmt.setString(1, email);
				int i = psmt.executeUpdate();
				if (i > 0) {
					System.out.println("Deleted Successfully");

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

	@Override
	public Book getBookDetails(Book book) {
		con = databaseConnection.CONN();
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
			return null;
		} else {
			try {
				String query = "select * from book where bookid=?";
				PreparedStatement psmt = con.prepareStatement(query);
				psmt.setInt(1, book.getBookid());
				ResultSet result = psmt.executeQuery();
				List<Book> ls = new ArrayList<>();
				while (result.next()) {
					book = new Book();
					book.setBookid(result.getInt(1));
					book.setBookname(result.getString(2));
					book.setQuantity(result.getInt(4));
					book.setPrice(result.getFloat(5));
					ls.add(book);
				}
				result.close();
				psmt.close();
				con.close();
				return book;
			}

			catch (Exception e) {
				System.err.println(e.getMessage());
			}

		}
		return null;
	}

	@Override
	public int updateBookQunatity(Book book) {
		con = databaseConnection.CONN();
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
		} else {
			try {
				String query = "update book set quantity=? where bookid=?";
				PreparedStatement psmt = con.prepareStatement(query);
				psmt.setInt(1, book.getQuantity());
				psmt.setFloat(2, book.getBookid());
				int i = psmt.executeUpdate();
				if (i > 0) {
					System.out.println("Deleted Successfully");

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

	@Override
	public Customer getCustomer(String email) {
		// TODO Auto-generated method stub
		con = databaseConnection.CONN();
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
		} else {
			try {
				Customer cust=new Customer();
				String query = "select * from customer where email=?";
				PreparedStatement psmt = con.prepareStatement(query);
				psmt.setString(1, email);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()){
					cust.setCid(rs.getInt(1));
				}
				return cust;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return null;
	}

}
