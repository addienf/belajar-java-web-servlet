package pzn.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookieName = req.getParameter("name");
        String cookieVal = req.getParameter("value");

        Cookie cookie = new Cookie(cookieName, cookieVal);
        cookie.setPath("/");

        resp.addCookie(cookie);
        resp.getWriter().println("Success add cookie" + cookieName + ":" + cookieVal);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getCookies() != null){
            for (var cookie : req.getCookies()){
                resp.getWriter().println("Cookie " + cookie.getName() + ":" + cookie.getValue());
            }
        }
    }
}
