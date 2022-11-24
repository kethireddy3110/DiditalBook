package com.book.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.book.components.Book;
import com.book.repository.SubscriberDetailsRepository;
import com.book.service.BookService;

@ComponentScan
@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private SubscriberDetailsRepository subsService;

	@GetMapping("/{authorId}")
	public Book getUser(@PathVariable("authorId") Long authorId) {// replace with json

		Book book = bookService.findBookByAuthorId(authorId);

		return book;
	}

	@PostMapping("/create")
	public ResponseEntity<String> createBook(@RequestBody Book book) {
		System.out.println(book.getBookTitle() + "Created");
		return ResponseEntity.status(HttpStatus.CREATED).body((bookService.createBook(book)));

	}

//	@PostMapping("/upload/logo/{authorId}")
//	public ResponseEntity<String> uplaodLogo(@PathVariable("authorId") Long authorId,
//			@RequestParam("logo") MultipartFile logo) throws IOException {
//
//		Book book = new Book();
//		book.setImageName(logo.getOriginalFilename());
//		book.setImageType(logo.getContentType());
//		book.setAuthorId(authorId);
//		// .logo((logo.getBytes())).build();
//		book.setLogo(logo.getBytes());
//		return ResponseEntity.status(HttpStatus.OK).body((bookService.createBook(book)));
//	}

//	@GetMapping(value = "/get/logo/{authorId}", produces = MediaType.IMAGE_JPEG_VALUE)
//	public ResponseEntity<byte[]> getLogo(@PathVariable("authorId") Long authorId) throws IOException {
//
//		final Book dbImage = bookService.findBookByAuthorId(authorId);
//
//		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.getImageType())).body((dbImage.getLogo()));
//
//	}

	@PutMapping("/update")
	public ResponseEntity<String> updateBook(@RequestBody Book book) {

		return ResponseEntity.status(HttpStatus.CREATED).body((bookService.updateBook(book)));

	}

	// subscribe a book
	@GetMapping("/subscribe/{authorId}/{subscribedBy}")
	public Long subscribeBook(@PathVariable Long authorId, @PathVariable String subscribedBy) {

		return bookService.subscribeBook(authorId, subscribedBy);

	}

	// Returns book based on book title and author name
	@GetMapping("/search")
	public ResponseEntity<Book> searchBook(@RequestBody Book book) {

		return ResponseEntity.status(HttpStatus.FOUND).body(bookService.searchBookByTitleAndAuthorName(book));

	}

	// Return all books
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		// We will filter it in serviceImpl
		List<Book> searchedBooks = bookService.getAllBooks();
		return searchedBooks;
	}

	// Returns all books subscribed by user
	@GetMapping("/subsciberSearch/{subscribedBy}")
	public List<Book> searchBooksBySubscription(@PathVariable String subscribedBy) {

		List<Book> searchedBooks = bookService.getAllBooksSubscribedByUser(subscribedBy);
		return searchedBooks;

	}
}
