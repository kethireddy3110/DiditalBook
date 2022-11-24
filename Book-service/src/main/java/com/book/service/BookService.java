package com.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.book.components.Book;
import com.book.components.User;

public interface BookService {
	public Book findBookByAuthorId(Long authorId);

	public List<Book> getAllBooks();
	public Book searchBook(Book book);
	public Book searchBookByTitleAndAuthorName(Book book);

	public List<Book> getAllBooksSubscribedByUser(String subscribedBy);
	public int subscribeBook(Book book, User user);
	public String createBook(Book book);
	public String updateBook(Book book);

	public Long subscribeBook(Long authorId, String subscribedBy);

}
