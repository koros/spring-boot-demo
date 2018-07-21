package com.example.demo.repositories;

import com.example.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gkoros on 22/07/2018.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
