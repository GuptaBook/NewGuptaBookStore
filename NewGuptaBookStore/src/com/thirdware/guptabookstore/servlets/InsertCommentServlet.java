package com.thirdware.guptabookstore.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thirdware.guptabookstore.dao.CommentDao;
import com.thirdware.guptabookstore.daoimpl.CommentDaoImpl;
import com.thirdware.guptabookstore.models.Comment;
import com.thirdware.guptabookstore.models.Customer;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class InsertCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertCommentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer c=new Customer();
		HttpSession session=request.getSession();
		String content = request.getParameter("content");
		String cname = session.getAttribute("username").toString();
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setCustomername(cname);
		CommentDao insert = new CommentDaoImpl();
		insert.insertComment(comment);
		RequestDispatcher rd=request.getRequestDispatcher("FetchBookByIdServlet");
		rd.forward(request, response);
		doGet(request, response);
	}

}
