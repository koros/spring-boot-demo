package com.example.demo.bootstrap;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by gkoros on 22/07/2018.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        // Eric
        Author eric = new Author("Eric", "Evans");
        Publisher pub1 = new Publisher("Harper Collins", "123 Hill Avenue");
        Book book1 = new Book("Domain Driven Design", "1234", pub1);
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(pub1);
        bookRepository.save(book1);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher pub2 = new Publisher("Worx", "23424 Garden City");
        Book book2 = new Book("J2EE Development without EJB", "38492", pub2);
        eric.getBooks().add(book2);
        book2.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(pub2);
        bookRepository.save(book2);
    }

}
