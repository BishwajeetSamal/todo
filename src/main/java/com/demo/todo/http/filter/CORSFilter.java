package com.demo.todo.http.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class CORSFilter implements Filter {

  /**
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse) res;

    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
    response.setHeader("Access-Control-Allow-Headers",
        "Origin, X-Requested-With, Content-Type, Accept, Authorization, type");
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.addIntHeader("Access-Control-Max-Age", 180);
    try {
      HttpServletRequest httpRequest = (HttpServletRequest) req;
      if (httpRequest.getHeader("Authorization") == null) {
        chain.doFilter(req, res);
      } else {

        String id = Jwts.parser().setSigningKey("SecretKeyToGenJWTs")
            .parseClaimsJws(httpRequest.getHeader("Authorization")).getBody().getSubject();
        req.setAttribute("id", id);
        chain.doFilter(req, res);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Override
  public void destroy() {
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

}
