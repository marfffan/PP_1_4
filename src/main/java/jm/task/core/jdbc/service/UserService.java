package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;
//service - пакет service, содержит сервисные классы,
// которые обрабатывают бизнес-логику приложения. Все, что нам
// нужно от идеи приложения, вся логика, мы прописываем здесь,

public interface UserService {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age) throws SQLException;

    void removeUserById(long id) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable();
}
