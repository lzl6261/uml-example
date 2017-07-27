package com.databps.admin.web.controller;

import com.databps.admin.domain.Author;
import com.databps.admin.service.AuthorService;
import com.databps.admin.vo.AuthorVO;
import java.io.File;
import java.io.IOException;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * REST controller for managing Author.
 */
@Controller
@RequestMapping(value = "/author")
public class AuthorController {

  private final Logger log = LoggerFactory.getLogger(AuthorController.class);


  @Autowired
  private AuthorService authorService;

  private ResourceLoader resourceLoader = new DefaultResourceLoader();

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String getAllAuthors(Pageable pageable,
      @RequestParam(required = false) String name, Model model) {
    log.debug("REST request to get a page of Authors");
    Page<Author> authorList = authorService.findAllByName(pageable, name);
    model.addAttribute("page", authorList);

    return "author/list";
  }

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public String add(Model model) {
    return "author/edit";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String save(@Valid AuthorVO authorVO) {

    authorService.save(authorVO);

    return "redirect:list";
  }

}
