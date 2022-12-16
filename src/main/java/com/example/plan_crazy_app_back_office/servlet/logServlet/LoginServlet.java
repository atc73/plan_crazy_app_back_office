package com.example.plan_crazy_app_back_office.servlet.logServlet;

import com.example.plan_crazy_app_back_office.dao.AppUserDao;
import com.example.plan_crazy_app_back_office.model.AppUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = LoginServlet.URL)
public class LoginServlet extends HttpServlet {


    public static final String URL = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("email") != null){
            // Filtrage OK
            resp.sendRedirect("/welcome");
        }else {
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        AppUserDao customerDao = new AppUserDao();
        Optional<AppUser> foundAppUser = customerDao.findByEmail(email);


        if (password.equals(foundAppUser.get().getPassword())) {
            // Get existing session or create one if not exist
            HttpSession session = req.getSession(true);

            session.setAttribute("email", email);
            // Expiration after 30 minutes
            session.setMaxInactiveInterval(30 * 60);


            resp.sendRedirect("/welcome");
        } else {
            req.setAttribute("loginFail", true);
            doGet(req, resp);
        }

    }
}