package ru.itis.javalab.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {

  @Override
  public void init (FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter (ServletRequest reqest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      HttpServletRequest req = (HttpServletRequest) reqest;
      HttpServletResponse res = (HttpServletResponse) response;
      HttpSession session = req.getSession(false);

      Boolean isAuthenticated = false;
      Boolean sessionExists = session != null;
      Boolean isUserPage = req.getRequestURI().equals("/user");
      Boolean isSigninPage = req.getRequestURI().equals("/signin");
      Boolean isProfilePage = req.getRequestURI().equals("/profile");
      Boolean isCreatePost = req.getRequestURI().equals("/createpost");

      if (sessionExists) {
          isAuthenticated = (Boolean) session.getAttribute("authenticated");
      }

      if(isSigninPage){
          if (isAuthenticated){
              res.sendRedirect("/user");
          }
      }

      if (isUserPage || isProfilePage || isCreatePost){
          if (!isAuthenticated) {
              res.sendRedirect("/");
          }

      }
      chain.doFilter(req, res);

  }

  @Override
  public void destroy () {
  }
}