package com.example.demo.repositories;

import com.example.demo.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gkoros on 22/07/2018.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
