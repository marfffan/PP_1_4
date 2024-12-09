package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /** В методе main работаю с обектом сервиса использую полеморфизм */
        /** Не нашел у кокого поля класса в проекте отсутствует модификатор доступа простите пожалуйста */
        UserService ud = new UserServiceImpl();
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
