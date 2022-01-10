package com.example.lab3jee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyStudentsServlet", value = "/MyStudentsServlet")
public class MyStudentsServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String id = "123";
        String myname = (String) session.getAttribute("MyName");
        String myage = (String) session.getAttribute("MyAge");
        String myhobbies = (String) session.getAttribute("MyHobbies");
        String mycampus = (String) session.getAttribute("MyCampus");
        String mymatric = (String) session.getAttribute("MyMatric");
        String myprogramcode = (String) session.getAttribute("MyProgramCode");



        /*MyStudents mystudents = new MyStudents("Engku Muhammad izwan Bin Engku muda", "22", "Football" ,
                "UiTM Cawangan Melaka Kampus Jasin", "2021118985", "CS266");*/

        MyStudents mystudents = new MyStudents(id,myname, myage, myhobbies, mycampus, mymatric, myprogramcode);



        out.println("<html><body style=\"text-align: center\">");
        out.println("<div style=\"font-family: 'Century Gothic', serif\" style=\"border: cadetblue\">");
        out.println("<p>" + "Name : " + mystudents.getMyName()+ "</p>");
        out.println("<p>" + "Age : " + mystudents.getMyAge()+ "</p>");
        out.println("<p>" + "Hobbies : " + mystudents.getMyHobbies()+ "</p>");
        out.println("<p>" + "Campus : " + mystudents.getMyCampus()+ "</p>");
        out.println("<p>" + "Matric No : " + mystudents.getMyMatricNo()+ "</p>");
        out.println("<p>" + "Program Code : " + mystudents.getMyProgramCode()+ "</p>");
        out.println(mystudents.printCar());
        out.println("</div></body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
