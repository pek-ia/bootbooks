package com.example.bootbooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
public class BootbooksApplication implements ApplicationRunner {

//    @Autowired
//    private Book book;
//
// Usually, we inject the logger, but here, we want it in main()

	private BookLister bookLister;
	
	private static Logger logger = LoggerFactory.getLogger(BootbooksApplication.class);
	
	public BootbooksApplication(BookLister bookLister) {
		super();
		this.bookLister = bookLister;
	}

	public static void main(String[] args) {
		logger.info("Bootbooks START");
		SpringApplication.run(BootbooksApplication.class, args);
		logger.info("Bootbooks EXIT");
	}

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		bookLister.listAllBooksToLogger();		
	}
	

}
