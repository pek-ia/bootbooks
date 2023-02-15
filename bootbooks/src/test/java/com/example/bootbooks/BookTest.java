package com.example.bootbooks;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
	
	Book book;
	
	@BeforeEach
	void setup() {
		book = new Book(1, "Title", BigDecimal.valueOf(1000,2));
	}

	@Test
	void constructorTest() {
		book = new Book(1, "Title", BigDecimal.valueOf(10,2));
	}
	
	@Test
	void getTitleTest() {
		assertEquals("Title", book.getTitle());
	}	

}
