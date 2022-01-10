package com.example.lab3jee;


import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

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

        response.getWriter().append("Served at: ").append(request.getContextPath());

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
            String dbURL = "jdbc:mysql://localhost:3306/lab584";
            String user = "root";
            String pass = "";

            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            String sql = "SELECT * FROM user";

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
                    out.println("<h1>" + "Name : " + res.getString("name") + "</h1>");
                    out.println("<h1>" + "Age : " + res.getString("age") + "</h1>");
                    out.println("<h1>" + "Hobbies : " + res.getString("hobbies") + "</h1>");
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
        String name = request.getParameter("myName");
        String age = request.getParameter("myAge");
        String hobbies = request.getParameter("myHobbies");

        MySelf mySelf = new MySelf(name,age,hobbies);

        registerjdbc rdbc = new registerjdbc();
        String result = rdbc.insert(mySelf);
        response.getWriter().print(result);

    }
}
