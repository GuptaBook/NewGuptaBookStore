package com.thirdware.guptabookstore.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.thirdware.guptabookstore.dao.EmpDao;
import com.thirdware.guptabookstore.daoimpl.EmpDaoImpl;
import com.thirdware.guptabookstore.models.Emp;

/**
 * Servlet implementation class EmpRegistration
 */
@WebServlet("/EmpRegistration")
public class EmpRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpRegistration() {
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
		String rootContext = request.getServletContext().getRealPath("/");
		//int eid=Integer.parseInt(request.getParameter("eid"));
		String ename=request.getParameter("ename");
		String email=request.getParameter("email");
		String phoneno=request.getParameter("phoneno");
		//String role=request.getParameter("role");
		String password=request.getParameter("password");
		EmpDao empDao=new EmpDaoImpl();
		Emp e=empDao.empLogin(email);
		System.out.println(e.getEname()+" "+e.getEid()+" "+(e.getEmail()!=null));
		/*if(e.getEmail()==null)
		{
			System.out.println("Email doesn't exists");
		}*/
		if(e.getEmail()!=null)
		{
			System.out.println(email);
			System.out.println("email is exist i.e,already Registered");
			System.out.println(e.getEname()+" "+e.getPassword());
			System.out.println("Redirecting to Registration page");
			String msg="Email is existing so try with other email";
			request.setAttribute("error", msg);
			RequestDispatcher rd=request.getRequestDispatcher("EmpRegis.jsp");
			rd.forward(request, response);
		}
		else
		{
		Emp emp=new Emp();
		//emp.setEid(eid);
		emp.setEname(ename);
		emp.setEmail(email);
		emp.setPhoneno(phoneno);
		emp.setRole("ROLE_EMPLOYEE");
		emp.setPassword(password);
		
		//EmpDao empDao=new EmpDaoImpl();
		System.out.println(emp.getEid()+" "+ename);
		Emp e1=empDao.empRegister(emp);
	    System.out.println("Registered Successfully");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doGet(request, response);
	}
	}
}
