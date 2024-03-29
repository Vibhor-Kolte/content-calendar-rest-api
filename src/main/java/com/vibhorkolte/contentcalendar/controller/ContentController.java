package com.vibhorkolte.contentcalendar.controller;

import com.vibhorkolte.contentcalendar.model.Content;
import com.vibhorkolte.contentcalendar.repository.ContentCollectionRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/content")
public class ContentController {
	
	private final ContentCollectionRepository repository;
	
//	// Manually Creating Dependency Object
//	public ContentController() {
//		repository = new ContentCollectionRepository();
//	}
	
	// Ask Spring to give object from its IOC Container..{Constructor Injection}
	// @Autowired by default when you have only one public constructor (no need to specify explicitly)
	public ContentController(ContentCollectionRepository repository) {
		this.repository = repository;
	}
	
	// Make a request and find all content in the system
	@GetMapping("/all")
	public List<Content> findAll(){
		return repository.findAll();
	}
	
	// Make a request and find a content by ID.
	@GetMapping("/{id}")	// {} dynamic placeholder
	public Content findById(@PathVariable Integer id){
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
	}
	
	@PostMapping("/create")
	public void create(@RequestBody Content content) {		
		repository.save(content);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/update/{id}")
	public void update(@RequestBody Content content, @PathVariable Integer id) {
		if(!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
		}
		
		repository.save(content);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {		
		repository.delete(id);
	}	
	

}
