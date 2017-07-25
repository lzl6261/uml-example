package com.databps.admin.config;

import freemarker.ext.servlet.FreemarkerServlet;
import freemarker.ext.servlet.HttpRequestParametersHashModel;
import freemarker.ext.servlet.IncludePage;
import freemarker.template.SimpleHash;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * @author merlin
 * @create 2017-07-26 上午2:20
 */
public class RichFreeMarkerView extends FreeMarkerView {

  @Override
  protected void doRender(Map model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    exposeModelAsRequestAttributes(model, request);
    SimpleHash fmModel = buildTemplateModel(model, request, response);
    fmModel.put(FreemarkerServlet.KEY_INCLUDE, new IncludePage(request, response));
    // fmModel.put("widget", new WidgetDirective(request,response));
    fmModel.put("param", new HttpRequestParametersHashModel(request));
    fmModel.put("base", request.getContextPath());
    fmModel.put("path", request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
    Locale locale = RequestContextUtils.getLocale(request);
    processTemplate(getTemplate(locale), fmModel, response);
  }

}
