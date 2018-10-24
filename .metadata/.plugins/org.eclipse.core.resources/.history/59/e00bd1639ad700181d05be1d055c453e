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

import org.apache.tomcat.util.collections.SynchronizedStack;

import com.thirdware.guptabookstore.dao.AuthorDao;
import com.thirdware.guptabookstore.dao.SubjectDao;
import com.thirdware.guptabookstore.daoimpl.AuthorDaoImpl;
import com.thirdware.guptabookstore.daoimpl.SubjectDaoImpl;
import com.thirdware.guptabookstore.models.Author;
import com.thirdware.guptabookstore.models.Subject;

/**
 * Servlet implementation class FetchAllAuthoServlet
 */
@WebServlet("/FetchAllAuthoServlet")
public class FetchAllAuthoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchAllAuthoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AuthorDao authorDao=new AuthorDaoImpl();
		List<Author> la=authorDao.getallAuthor();
		SubjectDao subjectDao = new SubjectDaoImpl();
		List<Subject> ls = subjectDao.getAllSubject();
		request.setAttribute("listSubject", ls);
		request.setAttribute("listAuthor", la);
		for(Subject s:ls)
			System.out.println(s.getSubid()+" "+s.getSubname()+" "+s.getSubdescription());
		for(Author a:la)
			System.out.println(a.getAuthdesc()+" "+a.getAuthid()+" "+a.getAuthname());
		HttpSession session=request.getSession();
		session.setAttribute("listSubject",ls);
		session.setAttribute("listAuthor",la);
		RequestDispatcher rd = request.getRequestDispatcher("views/home.jsp");
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
