package com.thirdware.guptabookstore.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

/**
 * Servlet implementation class PlaceOrderServlet
 */
@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CartDao cartDao = new CartDaoImpl();
		int qunt=0;
		System.out.println("entering into place order");
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("email");
		List<Cart> cart=cartDao.getCart(email);
		for(Cart c:cart){
			Book b=new Book();
			b.setBookid(c.getBookId());
			Book book=cartDao.getBookDetails(b);
			qunt=book.getQuantity();
			System.out.println("qnt "+qunt+" "+book.getQuantity());
			if(qunt>=c.getQuantity()){
				System.out.println("quantity "+c.getQuantity());
				qunt-=c.getQuantity();
				book.setQuantity(qunt);
				book.setBookid(c.getBookId());
				cartDao.updateBookQunatity(book);
				cartDao.deleteCart(c.getCartId());
			}
			else{
				System.out.println("Product quantity is low");
				String error="Product quantity is low! we will update as well as soon";
				request.setAttribute("error", error);
				RequestDispatcher rd=request.getRequestDispatcher("FetchCartServlet");
				rd.forward(request, response);
			}
			}
		String msg="Thank you for shopping!";
		request.setAttribute("msg", msg);
		response.sendRedirect("views/thankyoupage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
