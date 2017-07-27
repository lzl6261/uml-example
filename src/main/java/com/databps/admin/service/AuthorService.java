package com.databps.admin.service;

import com.databps.admin.domain.Author;
import com.databps.admin.vo.AuthorVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Author.
 */
public interface AuthorService {

    /**
     * Save a author.
     *
     * @param authorVO the entity to save
     * @return the persisted entity
     */
    void insert(AuthorVO authorVO);

    /**
     *  Get all the authors.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<Author> findAllByName(Pageable pageable,String name);

    /**
     *  Get the "id" author.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Author findOne(String id);

    /**
     *  Delete the "id" author.
     *
     *  @param id the id of the entity
     */
    void delete(String id);

    void update(AuthorVO authorVO);
}
