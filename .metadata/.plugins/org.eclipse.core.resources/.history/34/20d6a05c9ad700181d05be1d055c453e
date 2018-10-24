package com.thirdware.guptabookstore.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thirdware.guptabookstore.dao.CartDao;
import com.thirdware.guptabookstore.daoimpl.CartDaoImpl;
import com.thirdware.guptabookstore.models.Book;
import com.thirdware.guptabookstore.models.Cart;
import com.thirdware.guptabookstore.models.Customer;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class InsertCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		int bookId = Integer.parseInt(request.getParameter("bookid"));
		//String bookName = request.getParameter("bookname");
		String cname = (String) session.getAttribute("email");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int bookqun=0;float price=0;
		System.out.println("book name "+quantity+" "+cname+" "+bookId);
		//float price = Float.parseFloat(request.getParameter("price"));

		// .out.println(username+""+password+""+phoneno+""+emailid+"");
		CartDao cartDao = new CartDaoImpl();
		Book book=new Book();
		Book book1=new Book();
		book1.setBookid(bookId);
	    book=cartDao.getBookDetails(book1);
		bookqun=book.getQuantity();
		/*bookqun-=quantity;*/
		Customer customer=cartDao.getCustomer(cname);
		price=book.getPrice();
		/*book.setQuantity(bookqun);
		cartDao.updateBookQunatity(book);*/
		
		price*=quantity;
		Cart cart = new Cart();
		cart.setBookId(bookId);
		cart.setCustomerId(customer.getCid());
		//cart.setCustomerId((Integer)session.getAttribute("email"));
		cart.setBookName(book.getBookname());
		cart.setCustomername(cname);
		cart.setQuantity(quantity);
		cart.setPrice(price);

		
		cartDao.addCart(cart);
		response.sendRedirect("FetchCartServlet");
		doGet(request, response);
	}

}
