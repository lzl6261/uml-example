package com.databps.admin.web.controller;

import com.databps.admin.domain.Author;
import com.databps.admin.service.AuthorService;
import com.databps.admin.vo.AuthorVO;
import com.databps.admin.vo.UserVO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * REST controller for managing Author.
 */
@Controller
@RequestMapping(value = "/author")
public class AuthorController {

  private final Logger log = LoggerFactory.getLogger(AuthorController.class);


  @Autowired
  private AuthorService authorService;


  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String getAllAuthors(Pageable pageable, Model model) {
    log.debug("REST request to get a page of Authors");
    Page<Author> page = authorService.findAll(pageable);

    model.addAttribute("page", page);

    return "user/list";
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
