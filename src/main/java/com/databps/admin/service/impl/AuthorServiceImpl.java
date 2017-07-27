package com.databps.admin.service.impl;

import com.databps.admin.domain.Author;
import com.databps.admin.repository.AuthorRepository;
import com.databps.admin.service.AuthorService;
import com.databps.admin.service.mapper.AuthorMapper;
import com.databps.admin.vo.AuthorVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Service Implementation for managing Author.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

  private final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

  @Autowired
  private AuthorRepository authorRepository;

  @Autowired
  public AuthorMapper authorMapper;

  /**
   * Save a author.
   *
   * @param authorVO the entity to save
   * @return the persisted entity
   */
  @Override
  public void insert(AuthorVO authorVO) {
    log.debug("Request to save Author : {}", authorVO);
    Author author = authorMapper.toEntity(authorVO);
    author.setId(null);
    authorRepository.insert(author);
  }

  /**
   * Get all the authors.
   *
   * @param pageable the pagination information
   * @return the list of entities
   */
  @Override
  public Page<Author> findAllByName(Pageable pageable,String name) {
    log.debug("Request to get all Authors");
    return authorRepository.findAllByName(pageable,name);
  }

  /**
   * Get one author by id.
   *
   * @param id the id of the entity
   * @return the entity
   */
  @Override
  public Author findOne(String id) {
    log.debug("Request to get Author : {}", id);
    return authorRepository.findOne(id);
  }

  /**
   * Delete the  author by id.
   *
   * @param id the id of the entity
   */
  @Override
  public void delete(String id) {
    log.debug("Request to delete Author : {}", id);
    //authorRepository.delete(id);
  }

  @Override
  public void update(AuthorVO authorVO) {
    Author author = authorMapper.toEntity(authorVO);
    authorRepository.update(author);
  }
}
