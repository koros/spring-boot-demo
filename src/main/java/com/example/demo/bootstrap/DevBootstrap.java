package com.example.demo.bootstrap;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
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

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        // Eric
        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book1);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development without EJB", "38492", "Worx");
        eric.getBooks().add(book2);
        book2.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(book2);
    }

}
