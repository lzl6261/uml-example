package com.datbps.core.web.base;
import com.databps.core.message.ResponseJson;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * 基础controller返回异常信息
 *
 * @author merlin
 * @create 2017-07-21 上午10:12
 */
public class BaseController {

  @Autowired
  private MessageSource messageSource;

  protected Logger logger = LoggerFactory.getLogger(BaseController.class);

  protected static final String SUCCESS = getSuccessJson();

  public ResponseJson responseMsg(int code) {
    return new ResponseJson(code, MSG(code));
  }

  public ResponseJson responseMsg(int code, String msg) {
    return new ResponseJson(code, msg);
  }

  public ResponseJson responseMsg(int code, Object data) {
    return new ResponseJson(code, MSG(code), data);
  }

  public String MSG(int key) {
    Locale currentLocale = LocaleContextHolder.getLocale();
    return messageSource.getMessage("responseMsg.map." + key, null, currentLocale);
  }


  /**
   * 实体校验跳转到错误页面
   */
  public String showErrorPage(Model model, BindingResult result) {
    List<FieldError> list = result.getFieldErrors();
    List<String> errors = new ArrayList<String>();
    for (int i = 0; i < list.size(); i++) {
      FieldError fieldError = list.get(i);
      errors.add(fieldError.getField() + ":" + fieldError.getDefaultMessage());
    }

    model.addAttribute("errors", errors);
    return "error_message";
  }

  public ResponseJson showErrorJson(BindingResult result) {
    FieldError error = result.getFieldErrors().get(0);
    return new ResponseJson(101, error.getField() + ":" + error.getDefaultMessage());
  }

  public ResponseJson responseExceptionMsg() {
    return responseMsg(1);
  }

  public ResponseJson responseSuccessMsg() {
    return responseMsg(0);
  }

  public ResponseJson responseSuccessMsg(Object obj) {
    return responseMsg(0, obj);
  }

  protected static String getSuccessJson() {
    return "{\"code\":\"1\",\"msg\":\"success\"}";
  }
}
