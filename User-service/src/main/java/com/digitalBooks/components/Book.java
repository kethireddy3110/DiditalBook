package com.digitalBooks.components;

public class Book {

	private int authorId;

	private String author;

	private String bookTitle;

	private String category;

	private String publisher;

	private boolean active;

	private String publishedDate;

	private int price;

	private String status;

	private String chapter;

	private String subscribedBy; // userName

	private int subscriptionId;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getSubscribedBy() {
		return subscribedBy;
	}

	public void setSubscribedBy(String subscribedBy) {
		this.subscribedBy = subscribedBy;
	}

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public Book(int authorId, String author, String bookTitle, String category, String publisher, boolean active,
			String publishedDate, int price, String status, String chapter, String subscribedBy, int subscriptionId) {
		super();
		this.authorId = authorId;
		this.author = author;
		this.bookTitle = bookTitle;
		this.category = category;
		this.publisher = publisher;
		this.active = active;
		this.publishedDate = publishedDate;
		this.price = price;
		this.status = status;
		this.chapter = chapter;
		this.subscribedBy = subscribedBy;
		this.subscriptionId = subscriptionId;
	}

	public Book() {

	}

	public Book(Book book) {

	}
}
