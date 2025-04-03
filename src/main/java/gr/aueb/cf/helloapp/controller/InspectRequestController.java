package gr.aueb.cf.helloapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("inspect-request")
public class InspectRequestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().write("Session id: " + request.getSession() + "\n"); // Αν υπάρχει session θα μας το δείξει. Αν όχι επιστρέφει null

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    response.getWriter().write("Cookie name :" + cookie.getName() + ", Cookie value " + cookie.getValue() + "\n");
                }
            }
        }

        response.getWriter().write("Request URI: " + request.getRequestURI() + "\n");   // URI, όλο το πάνω που έχει ο browser
        response.getWriter().write("Request Context Path: " + request.getContextPath() + "\n");  // Context Path, μέρος μετά το base URL
        response.getWriter().write("Request Servlet Path: " + request.getServletPath() + "\n");  // controller
    }
}
