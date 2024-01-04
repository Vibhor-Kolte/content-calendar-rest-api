package com.vibhorkolte.contentcalendar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vibhorkolte.contentcalendar.model.Content;

import org.springframework.stereotype.Repository;

@Repository
public class ContentCollectionRepository {
	
	private final List<Content> content = new ArrayList<>();
	
	ContentCollectionRepository (){}
	
	public List<Content> findAll(){
		return content;
	}
	
	public Optional<Content> findById(Integer id){
		return content.stream().filter(v -> v.id().equals(id)).findFirst();	// findFirst() returns Optional<>
	}
}
