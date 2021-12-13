package com.example.lab3jee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MySelfServlet", value = "/MySelfServlet")
public class MySelfServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String myname = (String) session.getAttribute("MyName");
        String myage = (String) session.getAttribute("MyAge");
        String myhobbies = (String) session.getAttribute("MyHobbies");

//        MySelf myself = new MySelf("Engku" , 22 , "Football");
        MySelf myself = new MySelf(myname, myage, myhobbies);

        out.println("<html><body style=\"text-align: center\">");
        out.println("<div style=\"font-family: 'Century Gothic', serif\" style=\"border: cadetblue\">");

        out.println("<p>" + "Name: " + myself.getMyName() +  " </p>");
        out.println("<p>" + "Age: " + myself.getMyAge() +  "</p>");
        out.println("<p>" + "Hobbies: " + myself.getMyHobbies() +  "</p>");
        out.println(myself.printCar());


        out.println("</div></body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
