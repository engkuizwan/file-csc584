package com.example.lab3jee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyFamilyServlet", value = "/MyFamilyServlet")
public class MyFamilyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String myname = (String) session.getAttribute("MyName");
        String myage = (String) session.getAttribute("MyAge");
        String myhobbies = (String) session.getAttribute("MyHobbies");
        String myMom = (String) session.getAttribute("MyMom");
        String myDad = (String) session.getAttribute("MyDad");
        String mySibling = (String) session.getAttribute("MySibling");


        /*MyFamily myfamily = new MyFamily("Engku Muhammad Izwan Bin Engku Muda", "22", "Football",
                "Engku Muda Bin Engku Musa", "Asiah Binti Mohd Rusad", "Engku Muhammad Ilham Bin Engku Muda");*/

        MyFamily myfamily = new MyFamily(myname, myage, myhobbies, myDad, myMom, mySibling);

        out.println("<html><body style=\"text-align: center\">");
        out.println("<div style=\"font-family: 'Century Gothic', serif\" style=\"border: cadetblue\">");
        out.println("<p>" + "Name : " + myfamily.getMyName() + "</p>");
        out.println("<p>" + "Age : " + myfamily.getMyAge() + "</p>");
        out.println("<p>" + "Hobbies : " + myfamily.getMyHobbies() + "</p>");
        out.println("<p>" + "Father's Name : " + myfamily.getMyDad() + "</p>");
        out.println("<p>" + "Mother's Name : " + myfamily.getMyMom() + "</p>");
        out.println("<p>" + "Sibling's Name : " + myfamily.getMySiblings() + "</p>");
        out.println(myfamily.printCar());

        out.println("</div></body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
