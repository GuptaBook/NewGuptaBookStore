package com.thirdware.guptabookstore.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thirdware.guptabookstore.dao.AuthorDao;
import com.thirdware.guptabookstore.dao.SubjectDao;
import com.thirdware.guptabookstore.daoimpl.AuthorDaoImpl;
import com.thirdware.guptabookstore.daoimpl.SubjectDaoImpl;
import com.thirdware.guptabookstore.models.Author;
import com.thirdware.guptabookstore.models.Subject;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subjectname=request.getParameter("subname");
		String subjectdescription=request.getParameter("subdesc");
		
		
		Subject subject = new Subject();
	
		subject.setSubname(subjectname);
		subject.setSubdescription(subjectdescription);
    
		SubjectDao insert=new SubjectDaoImpl();
		insert.insertSubject(subject);
		
		System.out.println("inserted to db");
		
		doGet(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("FetchInsertSubjectServlet");
		rd.forward(request, response);
		
	}

}
