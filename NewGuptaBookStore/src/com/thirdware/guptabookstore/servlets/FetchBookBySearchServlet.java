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
import com.thirdware.guptabookstore.models.Book;

/**
 * Servlet implementation class FetchBookBySearchServlete
 */
@WebServlet("/FetchBookBySearchServlet")
public class FetchBookBySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchBookBySearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("name");
		BookDao bookDao=new BookDaoImpl();
		List<Book> bookList=bookDao.searchBook(name);
		request.setAttribute("booklist", bookList);
		RequestDispatcher rd=request.getRequestDispatcher("views/book/fetchallbook.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
