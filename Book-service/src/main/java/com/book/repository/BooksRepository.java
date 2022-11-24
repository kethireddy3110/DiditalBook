package com.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.book.components.Book;

public interface BooksRepository extends JpaRepository<Book, Long>{

	Book findBookByAuthorId(Long authorId);
	
//	@Query("UPDATE book b SET b.titile = book.get  ")
//	void updateBook(Book book);
	
//	@Transactional
//	@Modifying
//	@Query("from ShippingDocumentsJsonEntity e where e.fulfillmentId in ?1")
//	List<ShippingDocumentsJsonEntity> deleteByFulfillmentIdIn(List<String> fulfillmentIds);
//
	@Query("SELECT b FROM Book b WHERE b.bookTitle = ?1 and b.author = ?2")
	Book searchBookByTitleAndAuthor(String bookTitle, String author);
	
	@Query("SELECT b FROM Book b WHERE b.subscribedBy = subscribedBy")
	List<Book> searchBooksBySubscription(String subscribedBy);

	Book getById(Long authorId);
	

}