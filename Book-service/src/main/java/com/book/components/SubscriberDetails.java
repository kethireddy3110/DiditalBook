package com.book.components;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "subscriberDetails")
public class SubscriberDetails {
	
	@Id
	@javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subId;
	private String subscribedBy; // userName
	
//	@ManyToOne(fetch = FetchType.EAGER, optional = false)
//	@JoinColumn(name = "authorId", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private Book book;
	
	
	
	 private Long authorId;
	 
	public SubscriberDetails(Long subId, String subscribedBy, Long authorId) {
		super();
		this.subId = subId;
		this.subscribedBy = subscribedBy;
		this.authorId = authorId;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getSubId() {
		return subId;
	}

	public SubscriberDetails() {
		super();
	}


	public void setSubId(Long subId) {
		this.subId = subId;
	}

	public String getSubscribedBy() {
		return subscribedBy;
	}

	public void setSubscribedBy(String subscribedBy) {
		this.subscribedBy = subscribedBy;
	}
	
}
