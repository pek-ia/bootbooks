package com.example.bootbooks;


import java.math.BigDecimal;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("JDBC_REPOSITORY")
public class BookListerJdbcRepository extends BookLister {
	
	private BookDAO bookDAO;

	public BookListerJdbcRepository(Logger logger, BookDAO bookDAO) {
		super(logger);
		this.bookDAO = bookDAO; 
	}
	
	@Override
	public void listAllBooksToLogger() {
		super.logger.info("ALL THE BOOKS: ");
		
		bookDAO.save(new Book(12L, "Hello Spring", BigDecimal.valueOf(1999,2)));

		Iterable<Book> books = bookDAO.findAll();
		StringBuilder sb = new StringBuilder().append("\n");
		for (Book b: books) {
			sb.append(b);
			sb.append("\n");
		}
		
		super.logger.info(sb.toString());
			
	}

}
