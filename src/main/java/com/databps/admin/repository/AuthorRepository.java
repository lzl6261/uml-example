package com.databps.admin.repository;

import com.databps.admin.domain.Author;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Author entity.
 */
@Repository
public class AuthorRepository {

  @Autowired
  private MongoOperations mongoOperations;

  public Page<Author> findAllByName(Pageable pageable, String name) {

    Query query = new Query();

    if (StringUtils.isNoneBlank(name)) {
      query.addCriteria(Criteria.where("name").is(name));
    }

    Sort sort = new Sort(Direction.DESC, "create_time");

    long count = mongoOperations.count(query, Author.class, "author");

    query.with(pageable).with(sort);

    List<Author> authorList = mongoOperations.find(query, Author.class, "author");

    return new PageImpl(authorList, pageable, count);
  }

  public void save(Author author) {

    mongoOperations.save(author);

  }

  public Author findOne(String id) {
    Query query = new Query();
    query.addCriteria(Criteria.where("_id").is(id));
    return mongoOperations.findOne(query, Author.class);
  }

  public void update(Author author){
    Query query = new Query();
    query.addCriteria(Criteria.where("_id").is(author.getId()));
    Update update=new Update();
    update.set("name",author.getName());
    mongoOperations.updateFirst(query,update,"author");
  }
}
