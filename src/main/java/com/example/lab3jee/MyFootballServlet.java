package com.example.lab3jee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

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

        try
        {
            connectDB(out);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    public void connectDB(PrintWriter out) throws ClassNotFoundException
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/labcsc584";
            String user = "root";
            String pass = "rootpassword";

            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            String sql = "SELECT * FROM bola";

            if (conn != null)
            {
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());

                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(sql);

                while (res.next())
                {
                    out.println("<h1>" + "Team : " + res.getString("team") + "</h1>");
                    out.println("<h1>" + "Coach : " + res.getString("coach") + "</h1>");
                    out.println("<h1>" + "Player : " + res.getString("player") + "</h1>");
                    out.println("<h1>" + "Formation : " + res.getString("formation") + "</h1>");
                    out.println("<h1>" + "Position : " + res.getString("position") + "</h1>");
                }
            }

        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        String id = "123";
        String myname = (String) session.getAttribute("MyName");
        String myage = (String) session.getAttribute("MyAge");
        String myhobbies = (String) session.getAttribute("MyHobbies");
        String team = request.getParameter("myTeam");
        String coach = request.getParameter("myCoach");
        String player = request.getParameter("myPlayer");
        String formation = request.getParameter("myFormation");
        String position = request.getParameter("myPosition");

        MyFootball myFootball = new MyFootball(id,myname,myage,myhobbies,team,coach,player,formation ,position);



        myfootballdao rdbc = new myfootballdao();
        String result = rdbc.insert(myFootball);
        out.print("<p>" + result + "</p>");

    }
}
