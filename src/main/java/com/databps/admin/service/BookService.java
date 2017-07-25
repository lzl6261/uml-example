package com.databps.admin.service;

import com.databps.admin.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Book.
 */
public interface BookService {

    /**
     * Save a book.
     *
     * @param book the entity to save
     * @return the persisted entity
     */
    Book save(Book book);

    /**
     *  Get all the books.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<Book> findAll(Pageable pageable);

    /**
     *  Get the "id" book.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Book findOne(String id);

    /**
     *  Delete the "id" book.
     *
     *  @param id the id of the entity
     */
    void delete(String id);
}
