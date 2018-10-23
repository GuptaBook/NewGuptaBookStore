package com.thirdware.guptabookstore.dao;

import java.util.List;

import com.thirdware.guptabookstore.models.Author;
import com.thirdware.guptabookstore.models.Book;

public interface AuthorDao {
	public int insertAuthor(Author author);
	public List<Author> getallAuthor();
	public List<Book> getAuthor(int id);

}
