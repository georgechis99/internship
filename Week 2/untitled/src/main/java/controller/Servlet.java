package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/test", name = "uppercaseServlet")
    public class Servlet extends HttpServlet {

        @Override
        public void init() throws ServletException {
            System.out.println("TEST");
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            String inputString = request.getParameter("input").toUpperCase();
            String inputString2 = request.getRequestURI();

            PrintWriter out = response.getWriter();
            out.println(inputString + "xyz");
            out.println(inputString2);
        }
    }