package com.vibhorkolte.contentcalendar.controller;

import com.vibhorkolte.contentcalendar.repository.ContentCollectionRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	

}
