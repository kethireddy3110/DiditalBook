package com.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.book.components.Book;
import com.book.components.SubscriberDetails;
import com.book.components.User;
import com.book.repository.BooksRepository;
import com.book.repository.SubscriberDetailsRepository;
import com.google.common.base.Objects;

@Service

public class BookServiceImpl implements BookService {
	@Autowired
	private BooksRepository booksRepo;

	@Autowired
	SubscriberDetailsRepository subsRepo;

	@Override
	public Book searchBook(Book book) {

		return null;
	}

	@Override
	public List<Book> getAllBooksSubscribedByUser(String subscribedBy) {
		List<Book> subscribedBooks = booksRepo.searchBooksBySubscription(subscribedBy);
		return subscribedBooks;
	}

	@Override
	public int subscribeBook(Book book, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String createBook(Book book) {

		booksRepo.save(book);
		return "CREATED";
	}

	@Override
	public String updateBook(Book book) {
		
		Optional<Book> findById = booksRepo.findById(book.getAuthorId());
		if(findById.isPresent()) {
			Book book2 = new Book();
			book2.setAuthorId(book.getAuthorId());
			book2.setCategory(book.getCategory());
			book2.setBookTitle(book.getBookTitle());
			if(!java.util.Objects.isNull(book.getStatus())) {
				book2.setStatus(book.getStatus());
			}
			booksRepo.save(book2);
		}		
		return "UPDATED";
	}

	// Get all books for geust, author and reader
	@Override
	public List<Book> getAllBooks() {
		List<Book> books = booksRepo.findAll();
		return books;
	}

	@Override
	public Book findBookByAuthorId(Long authorId) {
		return booksRepo.getById(authorId);
	}

	@Override
	public Book searchBookByTitleAndAuthorName(Book book) {
		// book.getBookTitle(), book.getAuthor()
		Book searchedBook = booksRepo.searchBookByTitleAndAuthor(book.getBookTitle(), book.getAuthor());
		return searchedBook;
	}

	@Override
	public Long subscribeBook(Long authorId, String subscribedBy) {

		// Book book = booksRepo.findBookByAuthorId(authorId);
		SubscriberDetails subDetails = new SubscriberDetails();
		subDetails.setSubscribedBy(subscribedBy);
		subDetails.setAuthorId(authorId);

		subsRepo.save(subDetails);
		// insertWithQuery(subDetails);

		// subsRepo.insertSubscriberDetails(authorId, subscribedBy);
		List<SubscriberDetails> subList = subsRepo.findAll();

		return subList.stream()
				.filter(s -> s.getSubscribedBy().equalsIgnoreCase(subscribedBy) && s.getAuthorId().equals(authorId))
				.findAny().get().getSubId();
	}
}
