package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDaoJDBCImpl ud = new UserDaoJDBCImpl();
        ud.createUsersTable();
        ud.saveUser("Bread","Bredov", (byte) 1);
        ud.saveUser("Shora","Shorov", (byte) 2);
        ud.saveUser("Stepa","Stepov", (byte) 1);
        System.out.println(ud.getAllUsers());


        ud.dropUsersTable();
    }
}
