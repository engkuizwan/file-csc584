package com.example.lab3jee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.UUID;

@WebServlet(name = "MyFamilyServlet", value = "/MyFamilyServlet")
public class MyFamilyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String id = "123";
        String myname = (String) session.getAttribute("MyName");
        String myage = (String) session.getAttribute("MyAge");
        String myhobbies = (String) session.getAttribute("MyHobbies");
        String myMom = (String) session.getAttribute("MyMom");
        String myDad = (String) session.getAttribute("MyDad");
        String mySibling = (String) session.getAttribute("MySibling");


        /*MyFamily myfamily = new MyFamily("Engku Muhammad Izwan Bin Engku Muda", "22", "Football",
                "Engku Muda Bin Engku Musa", "Asiah Binti Mohd Rusad", "Engku Muhammad Ilham Bin Engku Muda");*/

        MyFamily myfamily = new MyFamily(id, myname, myage, myhobbies, myDad, myMom, mySibling);

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

            String sql = "SELECT * FROM keluarga";

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
                    out.println("<h1>" + "Mom : " + res.getString("mom") + "</h1>");
                    out.println("<h1>" + "Dad : " + res.getString("dad") + "</h1>");
                    out.println("<h1>" + "Sibling : " + res.getString("sibling") + "</h1>");
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
        String mydad = request.getParameter("myDad");
        String mymom = request.getParameter("myMom");
        String mysibling = request.getParameter("mySibling");

        MyFamily myFamily = new MyFamily(id,myname,myage,myhobbies,mydad,mymom,mysibling);



        myfamilydao rdbc = new myfamilydao();
        String result = rdbc.insert(myFamily);
        out.print("<p>" + result + "</p>");

    }
}
