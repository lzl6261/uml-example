package com.databps.admin.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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


}
