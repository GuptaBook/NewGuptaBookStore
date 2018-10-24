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
 * Servlet implementation class FetchSubAuth
 */
@WebServlet("/FetchSubAuth")
public class FetchSubAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchSubAuth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		BookDao bookDao=new BookDaoImpl();
		List<Subject> subList=bookDao.fetchBookBySub();
		List<Author> authList=bookDao.fetchBookByAuth();
		List<Book> lb=bookDao.fetchAllBook();
		request.setAttribute("booklist", lb);
		for(Subject sub:subList)
		System.out.println(sub.getSubid()+" ");
		request.setAttribute("sublist", subList);
		request.setAttribute("authlist", authList);
		RequestDispatcher rd=request.getRequestDispatcher("views/book/insertbook.jsp");
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
