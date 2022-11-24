package com.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.book.components.SubscriberDetails;

public interface SubscriberDetailsRepository extends JpaRepository<SubscriberDetails, Long> {
	  List<SubscriberDetails> findBySubId(Long subId);
	  
//	  @Query("INSERT INTO SubscriberDetails (subscribedBy, authorId) VALUES (?1, ?2)")
//	  void insertSubscriberDetails(Long authorId, String subscribedBy);
	  
	}