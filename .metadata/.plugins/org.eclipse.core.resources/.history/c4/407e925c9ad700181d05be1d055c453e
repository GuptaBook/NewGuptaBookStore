package com.thirdware.guptabookstore.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thirdware.guptabookstore.dao.BookDao;
import com.thirdware.guptabookstore.daoimpl.BookDaoImpl;
import com.thirdware.guptabookstore.models.Author;
import com.thirdware.guptabookstore.models.Book;
import com.thirdware.guptabookstore.models.Subject;

/**
 * Servlet implementation class FetchBookByIdUpdateServlet
 */
@WebServlet("/FetchBookByIdUpdateServlet")
public class FetchBookByIdUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchBookByIdUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bid=Integer.parseInt(request.getParameter("id"));
		//int bid=1;
		BookDao bookDao=new BookDaoImpl();
		Book b=bookDao.fetchBookById(bid);
		Subject sub=bookDao.getSubById(b.getSubid());
		Author auth=bookDao.getAuthById(b.getAuthid());
		request.setAttribute("bookdetail", b);		
		List<Subject> subList=bookDao.fetchBookBySub();
		List<Author> authList=bookDao.fetchBookByAuth();
		request.setAttribute("sub", sub);
		request.setAttribute("auth", auth);
		request.setAttribute("sublist", subList);
		request.setAttribute("authlist", authList);
		RequestDispatcher rd=request.getRequestDispatcher("views/book/updatebookdetails.jsp");
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
