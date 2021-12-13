package com.example.lab3jee;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class  HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello, My Name Is Engku Muhammad Izwan Bin Engku Muda";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body style=\"text-align: center\" >");
        out.println("<div style=\"font-family: 'Century Gothic', serif\" style=\"border: cadetblue\">");

        for(int i =0; i<=10; i++)
        out.println("<p>" + message + "</p>");

        out.println("</div></body></html>");
    }

    public void destroy() {
    }
}