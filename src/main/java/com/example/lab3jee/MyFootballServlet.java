package com.example.lab3jee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyFootballServlet", value = "/MyFootballServlet")
public class MyFootballServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String id = "123";
        String myname = (String) session.getAttribute("MyName");
        String myage = (String) session.getAttribute("MyAge");
        String myhobbies = (String) session.getAttribute("MyHobbies");
        String myTeam = (String) session.getAttribute("MyTeam");
        String myCoach = (String) session.getAttribute("MyCoach");
        String myPlayer = (String) session.getAttribute("MyPlayer");
        String myFormation = (String) session.getAttribute("MyFormation");
        String myPosition = (String) session.getAttribute("MyPosition");

        /*MyFootball myfootball = new MyFootball("Engku Muhammad Izwan Bin Engku Muda", "22", "Football",
                "Manchester United", "Pep Guardiola", "Cristiano Ronaldo", "4-3-3",
                "Ring Winger/Flanker");*/

        MyFootball myfootball = new MyFootball(id, myname, myage, myhobbies, myTeam, myCoach, myPlayer, myFormation, myPosition);


        out.println("<html><body style=\"text-align: center\">");
        out.println("<div style=\"font-family: 'Century Gothic', serif\" style=\"border: cadetblue\">");
        out.println("<p>" + "Name : " + myfootball.getMyName() + "</p>");
        out.println("<p>" + "Age : " + myfootball.getMyAge() + "</p>");
        out.println("<p>" + "Hobbies : " + myfootball.getMyHobbies() + "</p>");
        out.println("<p>" + "Favourite Football Team : " + myfootball.getMyTeam() + "</p>");
        out.println("<p>" + "Favourite Coach : " + myfootball.getMyCoach() + "</p>");
        out.println("<p>" + "Favourite Player : " + myfootball.getMyPlayer() + "</h1>");
        out.println("<p>" + "Favourite Formation : " + myfootball.getMyFormation() + "</p>");
        out.println("<p>" + "Favourite Position : " + myfootball.getMyPosition() + "</p>");
        out.println(myfootball.printCar());
        out.println("</div></body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
