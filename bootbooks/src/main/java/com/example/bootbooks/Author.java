package com.example.bootbooks;
import org.springframework.stereotype.Component;

import lombok.*;

@Data
@Component
@AllArgsConstructor
public class Author {
	public Author() {
		this("bob", "foo.com");
	}
	
	String name;
	String website;
}
