package com.vibhorkolte.contentcalendar.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vibhorkolte.contentcalendar.model.Content;
import com.vibhorkolte.contentcalendar.model.Status;
import com.vibhorkolte.contentcalendar.model.Type;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class ContentCollectionRepository {
	
	private final List<Content> content = new ArrayList<>();
	
	public ContentCollectionRepository (){}
	
	public List<Content> findAll(){
		return content;
	}
	
	public Optional<Content> findById(Integer id){
		return content.stream().filter(v -> v.id().equals(id)).findFirst();	// findFirst() returns Optional<>
	}
	
	public void save(Content content) {
		this.content.add(content);
	}
	
	// Tells spring to run this method after the dependency injection is done.
	@PostConstruct
	private void init() {
		Content c = new Content(1, "First Blog Post", "First Blog Post", 
				Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, "");
		
		content.add(c);
		
	}
}
