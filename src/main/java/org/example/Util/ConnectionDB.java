package org.example.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/akhdan-gym",
                    "root",
                    "181001"
            );
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
