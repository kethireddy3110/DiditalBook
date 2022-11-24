package com.digitalBooks.booksHelper;

import java.util.List;
import java.util.stream.Collectors;

import com.digitalBooks.components.Book;

public class FilterBooksList {

	public static List<Book> filterBooks(List<Book> returnedBooks, Book book) {

		return returnedBooks.stream()
				.filter(bk -> bk.getBookTitle().equalsIgnoreCase(book.getBookTitle())
						|| bk.getAuthor().equalsIgnoreCase(book.getAuthor()) || bk.getPrice() == (book.getPrice())
						|| bk.getCategory().equalsIgnoreCase(book.getCategory()))
				.collect(Collectors.toList());
	}

}
