package com.example.bootbooks;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BookLister {	
	
	protected Logger logger;	

	@Autowired
	public BookLister(Logger logger) {
		this.logger = logger;
	}
	
	public void listAllBooksToLogger() {
		logger.info("I'm abstract; I don't do real books!");
	};
}
