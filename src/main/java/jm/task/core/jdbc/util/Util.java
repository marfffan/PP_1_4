package jm.task.core.jdbc.util;
import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/pp_1_4";
        String user ="root";
        String passwd = "1125";

        Connection connection = DriverManager.getConnection(url, user, passwd);

    }
}
