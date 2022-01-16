package com.example.lab3jee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mystudentdao
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


    public String insert(MyStudents myStudents)
    {
        loadDriver(dbDriver);
        Connection con = getConnection();
        String result = "Data entered successfully";
        String sql = "insert into pelajar values(?,?,?)";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, myStudents.getMyMatricNo());
            ps.setString(2, myStudents.getMyProgramCode());
            ps.setString(3, myStudents.getMyCampus());

            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            result = "Data not entered";
        }
        return result;
    }
}
