package com.thirdware.guptabookstore.dao;

import java.util.List;

import com.thirdware.guptabookstore.models.Author;
import com.thirdware.guptabookstore.models.Book;
import com.thirdware.guptabookstore.models.Subject;

public interface BookDao {
	Book insetBook(Book book);
	List<Book> fetchAllBook();
	Book fetchBookById(int bid);
	List<Subject> fetchBookBySub();
	List<Author> fetchBookByAuth();
	Book updateBook(Book book);
	Subject getSubById(int id);
	Author getAuthById(int id);	
	List<Book> getSubjectstatus();
	Book approveBook(int id);
	Book rejectBook(int id);
	List<Book> searchBook(String name);
}
