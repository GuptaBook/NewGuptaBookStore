package com.thirdware.guptabookstore.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.thirdware.guptabookstore.dao.BookDao;
import com.thirdware.guptabookstore.daoimpl.BookDaoImpl;
import com.thirdware.guptabookstore.models.Book;

/**
 * Servlet implementation class InsertBookServlet
 */
@WebServlet("/InsertBookServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SAVE_DIRECTORY = "uploadDir";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String rootContext = request.getServletContext().getRealPath("/");*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		PrintWriter out=response.getWriter();
		String bookname=request.getParameter("bookname");
		String bookdesc=request.getParameter("bookdesc");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		float price=Float.parseFloat(request.getParameter("price"));
		int subid=Integer.parseInt(request.getParameter("subid"));
		int authid=Integer.parseInt(request.getParameter("authid"));
		Book book=new Book();
		book.setBookname(bookname);
		book.setBookdesc(bookdesc);
		book.setQuantity(quantity);
		book.setPrice(price);
		book.setSubid(subid);
		book.setAuthid(authid);
		BookDao bookDao=new BookDaoImpl();
		Book b=bookDao.insetBook(book);
		System.out.println("Inserted Successfully "+b.getBookid());
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			String description = request.getParameter("description");
			System.out.println("Description: " + description);

			// Gets absolute path to root directory of web app.
			String appPath = "C:/OnlineGuptaBook/OnlineGuptaBookStore/OnlineGuptaBookStore/WebContent/resources/images";
			appPath = appPath.replace('\\', '/');

			// The directory to save uploaded file
			String fullSavePath = null;
			if (appPath.endsWith("/")) {
				fullSavePath = appPath +""+ SAVE_DIRECTORY;
			} else {
				fullSavePath = appPath + "/" + SAVE_DIRECTORY;
			}

			// Creates the save directory if it does not exists
			File fileSaveDir = new File(fullSavePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}

			// Part list (multi files).
			for (Part part : request.getParts()) {
				String fileName = b.getBookid()+".png";
				if (fileName != null && fileName.length() > 0) {
					String filePath = fullSavePath + File.separator + fileName;
					System.out.println("Write attachment to file: " + filePath);
					// Write to file
					part.write(filePath);
				}
			}
			// Upload successfully!.
			response.sendRedirect(request.getContextPath() + "/insertbook.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Error: " + e.getMessage());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/insertbook.jsp");
			dispatcher.forward(request, response);
			doGet(request, response);
		}
		
		System.out.println("Inserted Successfully");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
