package com.databps.admin.web.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author merlin
 * @create 2017-08-01 下午3:06
 */
@Controller
@RequestMapping(value = "/api")
public class LoginController {


  @RequestMapping(value = "/authentication", method = RequestMethod.GET)
  public String authenticate(Model model) {

    return "login/authenticate";

  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String getLoginPage(@RequestParam Optional<String> error, Model model) {
    model.addAttribute("error", error);

    return "login/authenticate";
  }

}
