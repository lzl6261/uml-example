package com.databps.admin.config;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

/**
 * @author merlin
 * @create 2017-07-26 上午2:19
 */
public class RichFreeMarkerViewResolver extends AbstractTemplateViewResolver {
  public RichFreeMarkerViewResolver() {
    setViewClass(RichFreeMarkerView.class);
  }
  /**
   * if viewName start with / , then ignore prefix.
   */
  @Override
  protected AbstractUrlBasedView buildView(String viewName) throws Exception {
    AbstractUrlBasedView view = super.buildView(viewName);
    // start with / ignore prefix
    if (viewName.startsWith("/")) {
      view.setUrl(viewName + getSuffix());
    }
    return view;
  }
}
