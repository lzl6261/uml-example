package com.databps.admin.web.controller;

import com.datbps.core.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户
 *
 * @author me
 * @create 2017-07-20 下午7:35
 */
@Controller
@RequestMapping(value = "/user")
@Deprecated
public class UserController extends BaseController {

//  @Autowired
//  private UserService userService;

  /**
   * 用户列表页面
   */
//  @RequestMapping(value = "/list", method = RequestMethod.GET)
//  public String list(Pageable pageable, Model model, HttpServletRequest request) {
//
//    List<UserVO> userList = userService.listOnPage(pageable);
//
//    model.addAttribute("userList", userList);
//    model.addAttribute("page", pageable);
//
//    return "user/list";
//  }
//
//  /**
//   * 用户新建页面
//   */
//  @RequestMapping(value = "/add", method = RequestMethod.GET)
//  public String add(Model model) {
//
//    return "user/add";
//  }
//
//  /**
//   * 用户编辑页面
//   */
//  @RequestMapping(value = "/edit", method = RequestMethod.GET)
//  public String edit(@RequestParam("userId") String userId, Model model,
//      HttpServletRequest request) {
//    UserVO userVO=userService.findByUserName(userId);
//
//    model.addAttribute("userVO", userVO);
//    return "user/edit";
//  }
//
//  /**
//   * 用户保存操作
//   * @param userVO
//   * @param result
//   * @param currentPage
//   * @param attr
//   * @param request
//   * @param model
//   * @return
//   */
//  @RequestMapping(value = "/save", method = RequestMethod.POST)
//  public String save(@Validated UserVO userVO, BindingResult result,
//      @RequestParam(defaultValue = "1") Integer currentPage, RedirectAttributes attr,
//      HttpServletRequest request, Model model) {
//
//    if (result.hasErrors()) {
//      return showErrorPage(model, result);
//    }
//
//    userService.insert(userVO);
//
//    return "redirect:list";
//  }
//
//  /**
//   * 用户更新操作
//   * @param userVO
//   * @param result
//   * @param currentPage
//   * @param attr
//   * @param request
//   * @param model
//   * @return
//   */
//  @RequestMapping(value = "/update", method = RequestMethod.POST)
//  public String update(@Validated UserVO userVO, BindingResult result,
//      @RequestParam(defaultValue = "1") Integer currentPage, RedirectAttributes attr, HttpServletRequest request,
//      Model model) {
//    if (result.hasErrors()) {
//      return showErrorPage(model, result);
//    }
//    attr.addAttribute("currentPage", currentPage);
//    return "redirect:list";
//  }


}
