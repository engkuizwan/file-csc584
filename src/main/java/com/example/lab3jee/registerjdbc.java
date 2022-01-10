package com.example.lab3jee;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registerjdbc
{
    private String dbUrl = "jdbc:mysql://localhost:3306/lab584";
    private String dbUname = "root";
    private String dbPassword = "";
    private String dbDriver = "com.mysql.cj.jdbc.Driver";

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


    public String insert(MySelf mySelf)
    {
        loadDriver(dbDriver);
        Connection con = getConnection();
        String result = "Data entered successfully";
        String sql = "insert into user values(?,?,?)";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mySelf.getMyName());
            ps.setString(2, mySelf.getMyAge());
            ps.setString(3, mySelf.getMyHobbies());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            result = "Data not entered";
        }
        return result;
    }

}

