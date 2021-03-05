package ru.itis.javalab.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

public class SpringWebAppInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    servletContext.setInitParameter("spring.profiles.active", "dev");
  }
}
