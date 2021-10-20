package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory(){throw new UnsupportedOperationException();}

    public static Connection getConnection() throws SQLException {

        String driver = "postgresql";
        String dataBaseAddress = "localhost";
        String dataBaseName = "postgres";
        String user = "postgres";
        String password = "123";
        Connection conn = null;

        StringBuilder sb = new StringBuilder("jdbc:")
                .append(driver).append("://")
                .append(dataBaseAddress).append("/")
                .append(dataBaseName);
        String urlConnection = sb.toString();

        try{
            conn = DriverManager.getConnection(urlConnection,user,password);

        }catch (Exception e){
            System.err.println("erro" + e.getMessage());
        }
        return conn;
    }
}
