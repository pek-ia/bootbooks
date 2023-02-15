package com.example.bootbooks;

import org.springframework.data.repository.CrudRepository;

public interface BookDAO extends CrudRepository<Book, Long> {

}
