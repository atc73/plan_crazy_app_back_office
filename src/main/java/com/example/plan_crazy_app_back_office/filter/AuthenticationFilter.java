package com.example.plan_crazy_app_back_office.filter;

import com.example.plan_crazy_app_back_office.servlet.logServlet.LoginServlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/welcome", "", "/admins/*", "/logout"})
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // Get existing session or return null
        boolean wantCreateIfNotExist = false;
        HttpSession session = req.getSession(wantCreateIfNotExist);

        if(session != null && session.getAttribute("email") != null){
            // Filtrage OK
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            resp.sendRedirect(LoginServlet.URL);
        }
    }
}