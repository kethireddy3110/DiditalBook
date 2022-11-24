package com.book.components;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name="book")
public class Book {
	@Id
	@javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AUTHORID")
	private Long authorId;
	
	@Column(name="AUTHOR")
	private String author;
	
	@Column(name="BOOKTITLE")
	private String bookTitle;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="PUBLISHER")
	private String publisher;
	
	@Column(name="ACTIVE")
	private boolean active;
	
	@Column(name="PUBLISHERDATE")
	private String publishedDate;
	
	@Column(name="PRICE")
	private int price;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="CHAPTER")
	private String chapter;
	
	
	@Column(name="SUBUSER")
	private String subscribedBy; //userName
	

	//@Column(name = "LOGO", unique = false, nullable = false, length = 100000)
	@Column(name = "LOGO", unique = false, nullable = true, length = 100000)
	private byte[] logo;

	@Column(name = "IMAGENAME")
	private String imageName;

	@Column(name = "IMAGETYPE")
	private String imageType;
	
	
	
//	 @OneToMany(targetEntity = SubscriberDetails.class, cascade = CascadeType.ALL)
//	 @JoinColumn(name ="sub_key",referencedColumnName = "authorId", insertable = true)
//	private List<SubscriberDetails> subscribers; 

	public Book(Long authorId, String author, String bookTitle, String category, String publisher, boolean active,
			String publishedDate, int price, String status, String chapter, String subscribedBy,
			List<SubscriberDetails> subscribers) {
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
		
	}

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

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
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
		return status;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getSubscribedBy() {
		return subscribedBy;
	}

	public Book(Long authorId, String author, String bookTitle, String category, String publisher, boolean active,
			String publishedDate, int price, String status, String chapter, String subscribedBy) {
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
	}

	public Book() {
		
	}

	public Book(Book book) {
	}
}
