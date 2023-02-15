package com.example.bootbooks;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Qualifier("JDBC_TEMPLATE")
public class BookListerJdbcTemplate extends BookLister {
	
	private JdbcTemplate jdbcTemplate;

	public BookListerJdbcTemplate(Logger logger, JdbcTemplate jdbcTemplate) {
		super(logger);
		this.jdbcTemplate= jdbcTemplate; 
	}
	
	@Override
	public void listAllBooksToLogger() {
		super.logger.info("ALL THE BOOKS: ");

		String sql = "SELECT * FROM book";
		
		List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
		
		StringBuilder sb = new StringBuilder().append("\n");
		for (Book b: books) {
			sb.append(b);
			sb.append("\n");
		}
		
		super.logger.info(sb.toString());
			
	}

}
