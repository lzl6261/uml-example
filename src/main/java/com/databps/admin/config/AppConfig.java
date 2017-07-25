package com.databps.admin.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * @author merlin
 * @create 2017-07-21 下午4:53
 */
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

  @Bean
  public GsonHttpMessageConverter gsonHttpMessageConverter() {
    Gson gson = new GsonBuilder()
        //.excludeFieldsWithoutExposeAnnotation()
        .create();
    GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
    converter.setGson(gson);
    return converter;
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(stringHttpMessageConverter());
    converters.add(gsonHttpMessageConverter());

  }

  @Bean
  public StringHttpMessageConverter stringHttpMessageConverter() {
    StringHttpMessageConverter jsonConverter = new StringHttpMessageConverter();
    jsonConverter.setWriteAcceptCharset(false);
    List<MediaType> mediaTypeList = new ArrayList<MediaType>();
    mediaTypeList.add(new MediaType("application", "json", Charset.forName("UTF-8")));
    jsonConverter.setSupportedMediaTypes(mediaTypeList);
    return jsonConverter;
  }

  @Bean
  public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
    FreeMarkerConfigurationFactory factory = new FreeMarkerConfigurationFactory();
    factory.setTemplateLoaderPaths("classpath:templates", "src/main/resource/templates");
    factory.setDefaultEncoding("UTF-8");
    FreeMarkerConfigurer result = new FreeMarkerConfigurer();

    Properties settings = new Properties();
    settings.put("classic_compatible", "true");
    settings.put("tag_syntax", "square_bracket");
    settings.put("whitespace_stripping", "true");
    settings.put("number_format", "#");
    settings.put("cache_storage","freemarker.cache.NullCacheStorage");
    factory.setFreemarkerSettings(settings);

    result.setConfiguration(factory.createConfiguration());
    return result;
  }


  @Bean
  public ViewResolver freeMarkerViewResolver() {
    FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
    viewResolver.setCache(false);
    viewResolver.setPrefix("");
    viewResolver.setSuffix(".ftl");
    viewResolver.setContentType("text/html;charset=UTF-8");
    viewResolver.setExposeSpringMacroHelpers(true);
    viewResolver.setExposeRequestAttributes(false);
    viewResolver.setExposeSessionAttributes(false);

    return viewResolver;
  }
}
