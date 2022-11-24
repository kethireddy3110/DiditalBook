package com.digitalBooks.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.digitalBooks.booksHelper.FilterBooksList;
import com.digitalBooks.components.Book;
import com.digitalBooks.components.User;
import com.digitalBooks.controller.apiHelper.HttpComponentsClientHttpRequestWithBodyFactory;
import com.digitalBooks.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	RestTemplate resTemplate;

	@GetMapping("/{userId}")
	public ResponseEntity<Object> getUser(@PathVariable("userId") int userId) {

		User user = userService.getUser(userId);
		return new org.springframework.http.ResponseEntity<>(user, HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		System.out.println(user.getUserName());
		return ResponseEntity.status(HttpStatus.CREATED).body((userService.createUser(user)));

	}

	// Login for user
	@GetMapping("/login")
	public ResponseEntity<Object> getUserByNameAndPassword(@RequestBody User loginUser) {

		Optional<User> user = userService.getUserByUserNameAndPassword(loginUser.getUserName(),
				loginUser.getPassword());
		if (user != null && user.isPresent()) {
			return new org.springframework.http.ResponseEntity<>(user.get(), HttpStatus.OK);

		} else {
			return new org.springframework.http.ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}

	}

	// For create book
	@PostMapping("/create/book")
	public HttpStatus createBook(@RequestBody Book book) {
		// System.out.println(user.getUserName());
		// HttpEntity<Book> request = new HttpEntity<>(new Book(book)); inserting null
		// resTemplate.setRequestFactory(new
		// HttpComponentsClientHttpRequestWithBodyFactory());

		// ResponseEntity<String> response =
		// resTemplate.exchange("http://Book-service/book/create", HttpMethod.POST,
		// request, String.class);
		resTemplate.exchange("http://localhost:8091/book/create", HttpMethod.POST, new HttpEntity<>(book), String.class);
		return HttpStatus.CREATED;

	}

	// For updating book
	@PutMapping("/update/book")
	public HttpStatus updateBook(@RequestBody Book book) {

		HttpEntity<Book> request = new HttpEntity<>(new Book(book));

		resTemplate.exchange("http://localhost:8091/book/update", HttpMethod.PUT, new HttpEntity<>(book), String.class);
		return HttpStatus.OK;

	}

	@PostMapping("/save/logo/{authorId}")
	public HttpStatus saveLogo(@PathVariable("authorId") Long authorId, @RequestParam("logo") MultipartFile logo)
			throws IOException {
		resTemplate.setRequestFactory(new HttpComponentsClientHttpRequestWithBodyFactory());

		String fileName = logo.getOriginalFilename();
		byte[] fileContent = logo.getBytes();

		HttpHeaders parts = new HttpHeaders();
		parts.setContentType(MediaType.TEXT_PLAIN);
		final ByteArrayResource byteArrayResource = new ByteArrayResource(fileContent) {
			@Override
			public String getFilename() {
				return fileName;
			}
		};
		final HttpEntity<ByteArrayResource> partsEntity = new HttpEntity<>(byteArrayResource, parts);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, Object> requestMap = new LinkedMultiValueMap<>();
		requestMap.add("logo", partsEntity);

//		final ParameterizedTypeReference<> typeReference = new ParameterizedTypeReference<>() {
//		};

		ResponseEntity<String> res = resTemplate.exchange("http://localhost:8091/book/upload/logo/" + authorId,
				HttpMethod.POST, new HttpEntity<>(requestMap, headers), String.class);

		return HttpStatus.OK;
	}

	// Get logo
	@GetMapping(value = "/get/logo/{authorId}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getLogo(@PathVariable Long authorId) {

		// HttpEntity<Book> request = new HttpEntity<>(new Book(book));

		byte[] responseLogo = resTemplate.getForObject("http://localhost:8091/book/get/logo/" + authorId, byte[].class);
		return responseLogo;

	}

	// Subscibe a book
	@GetMapping("/subscribe/book/{authorId}/{subscribedBy}")
	public Long subscribeBook(@PathVariable Long authorId, @PathVariable String subscribedBy) {

		// HttpEntity<Book> request = new HttpEntity<>(new Book(book));

		String id = resTemplate.getForObject("http://localhost:8091/book/subscribe/" + authorId + "/" + subscribedBy,
				String.class);
		return Long.valueOf(id);

	}

	// For get book, will return results based on title and author
	@GetMapping("/search/book")
	public ResponseEntity<Book> getBook(@RequestBody Book book) {

		// HttpEntity<Book> request = new HttpEntity<>(new Book(book));
		resTemplate.setRequestFactory(new HttpComponentsClientHttpRequestWithBodyFactory());
		ResponseEntity<Book> searchedbook = resTemplate.exchange("http://localhost:8091/book/search", HttpMethod.GET,
				new HttpEntity<>(book), Book.class);
		return searchedbook;

	}

	// Will return all books based on search criteria, for guest/ we have to
	// implement functionalities at UI
	@GetMapping("/book/getAll")
	public List<Book> getAllBooks(@RequestBody Book book) {

		resTemplate.setRequestFactory(new HttpComponentsClientHttpRequestWithBodyFactory());

		ResponseEntity<Book[]> response = resTemplate.getForEntity("http://localhost:8091/book/getAllBooks",
				Book[].class);

		List<Book> returnedBooks = Arrays.asList(response.getBody());

//		ResponseEntity<BooksList> allBooks = resTemplate.exchange("http://Book-service/book/getAllBooks", HttpMethod.GET,
//				new HttpEntity<>(book), BooksList.class);
//		BooksList result = allBooks.getBody();
//		return result.getBooks();
		return FilterBooksList.filterBooks(returnedBooks, book);

	}

	// Get all subscribed books by reader WIP
	@GetMapping("/searchBySubsName/{subscribedBy}")
	public List<Book> getUser(@PathVariable String subscribedBy) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("subsciberId", "1");
		params.put("userName", "aviansh");

//				BooksList  response = resTemplate.getForObject("http://Book-service/book/subsciberSearch"+"/subscribedBy", BooksList.class);
		ResponseEntity<Book[]> response = resTemplate
				.getForEntity("http://localhost:8091/book/subsciberSearch" + "/subscribedBy", Book[].class);

		List<Book> searchedBooks = Arrays.asList(response.getBody());
		return searchedBooks;

	}

}
