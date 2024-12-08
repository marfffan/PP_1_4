package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDao ud = new UserDaoJDBCImpl();
        ud.createUsersTable();
        ud.saveUser("Bread","Bredov", (byte) 1);
        ud.saveUser("Shora","Shorov", (byte) 2);
        ud.saveUser("Stepa","Stepov", (byte) 1);
        ud.saveUser("Fedot","Fedotov", (byte) 4);
        System.out.println(ud.getAllUsers());
        ud.cleanUsersTable();
        ud.dropUsersTable();
    }
}
