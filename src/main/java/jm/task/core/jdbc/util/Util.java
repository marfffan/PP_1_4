package jm.task.core.jdbc.util;

import java.sql.*;


public class Util {

    private static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/pp_1_4";
    private static final String USERNAME = "root";
    private static final String PASS = "1125";

    public static Connection getConnection() {

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASS);
            System.out.println("Подключен");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Проблема подключения к БД");
        }
        return connection;
    }
}
