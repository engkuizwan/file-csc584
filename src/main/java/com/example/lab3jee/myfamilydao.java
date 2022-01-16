package com.example.lab3jee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class myfamilydao
{
    private String dbUrl = "jdbc:mysql://localhost:3306/labcsc584";
    private String dbUname = "root";
    private String dbPassword = "rootpassword";
    private String dbDriver = "com.mysql.jdbc.Driver";

    public void loadDriver(String dbDriver)
    {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        Connection con = null;
        try {
            con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }


    public String insert(MyFamily myFamily)
    {
        loadDriver(dbDriver);
        Connection con = getConnection();
        String result = "Data entered successfully";
        String sql = "insert into keluarga values(?,?,?)";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, myFamily.getMyDad());
            ps.setString(2, myFamily.getMyMom());
            ps.setString(3, myFamily.getMySiblings());

            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            result = "Data not entered";
        }
        return result;
    }


}
