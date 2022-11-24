package com.digitalBooks.booksHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.digitalBooks.components.Book;

public class BooksList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BooksList(List<Book> books) {
		super();
		this.books = books;
	}

	private List<Book> books;
	
	    public List<Book> getBooks() {
		return books;
	}
	  
	public void setBooks(List<Book> books) {
		this.books = books;
	}

		public BooksList() {
	        books = new ArrayList<>();
	    }
	

}
