package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;
//dao - пакет dao (Data Access Object), содержит классы, отвечающие за взаимодействие с базой данных.
public interface UserDao {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
