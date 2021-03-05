package ru.itis.javalab.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(ServletRequest reqest, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
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
      if (session.getAttribute("authenticated") == null) {
        isAuthenticated = false;
      } else {
        isAuthenticated = (Boolean) session.getAttribute("authenticated");
      }
    }

    if (isSigninPage) {
      if (isAuthenticated) {
        res.sendRedirect("/user");
      }
    }

    if (isUserPage || isProfilePage || isCreatePost) {
      if (!isAuthenticated) {
        res.sendRedirect("/");
      }
    }
    chain.doFilter(req, res);
  }

  @Override
  public void destroy() {}
}
