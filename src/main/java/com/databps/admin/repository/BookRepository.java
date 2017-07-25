package com.databps.admin.repository;

import com.databps.admin.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Book entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BookRepository extends MongoRepository<Book,String> {
    
}
