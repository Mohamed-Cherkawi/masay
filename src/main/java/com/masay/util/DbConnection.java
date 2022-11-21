package com.masay.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/masay";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "";
    private static final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private static Connection connection = null ;

    public static Connection getConnection(){
        if ( connection == null ) {
            try {
                Class.forName(jdbcDriver);
                connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void closeConnection() throws SQLException {
        if ( connection != null ){
            connection.close();
        }
        connection = null;
    }
    public static PreparedStatement prepareStatement(String query) throws SQLException {
        return getConnection().prepareStatement(query);
    }
}

