package com.databps.admin.web.controller;

import com.databps.admin.domain.Admin;
import com.databps.admin.service.UserService;
import com.databps.admin.web.controller.vm.ManagedUserVM;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author merlin
 * @create 2017-07-31 下午7:52
 */
@Controller
@RequestMapping(value = "/api")
public class AdminController {

  @Autowired
  private UserService userService;


  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String register(@Valid ManagedUserVM managedUserVM, Model model) {

    if (!checkPasswordLength(managedUserVM.getPassword())) {
      return "redirect:register";
    }

    if (userService.findOneByLogin(managedUserVM.getLogin().toLowerCase()).isPresent()) {
      model.addAttribute("error", "login already in use");

    } else {
      Admin user = userService
          .createUser(managedUserVM.getLogin(), managedUserVM.getPassword(),
              managedUserVM.getFirstName(), managedUserVM.getLastName(),
              managedUserVM.getEmail().toLowerCase(), managedUserVM.getImageUrl(),
              managedUserVM.getLangKey());
    }
    return "redirect:register";

  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String gets(Model model) {

    return "admin/register";

  }


  private boolean checkPasswordLength(String password) {
    return !StringUtils.isEmpty(password) &&
        password.length() >= ManagedUserVM.PASSWORD_MIN_LENGTH &&
        password.length() <= ManagedUserVM.PASSWORD_MAX_LENGTH;
  }

}
