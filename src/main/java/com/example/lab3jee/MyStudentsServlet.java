package com.example.lab3jee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

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

            String sql = "SELECT * FROM pelajar";

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
                    out.println("<h1>" + "MatricNO : " + res.getString("matricno") + "</h1>");
                    out.println("<h1>" + "Programcode : " + res.getString("programcode") + "</h1>");
                    out.println("<h1>" + "Campus : " + res.getString("campus") + "</h1>");
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
        String matricno = request.getParameter("myCampus");
        String programcode = request.getParameter("myMatric");
        String campus = request.getParameter("myProgramCode");

        MyStudents myStudents = new MyStudents(id,myname,myage,myhobbies,matricno,programcode,campus);



        mystudentdao rdbc = new mystudentdao();
        String result = rdbc.insert(myStudents);
        out.print("<p>" + result + "</p>");


    }
}
