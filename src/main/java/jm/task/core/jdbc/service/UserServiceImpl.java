package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

//service - пакет service, содержит сервисные классы,
// которые обрабатывают бизнес-логику приложения. Все, что
// нам нужно от идеи приложения, вся логика, мы прописываем здесь,
public class UserServiceImpl implements UserService {
    private final UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

    @Override
    public void createUsersTable() {
        userDaoJDBC.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDaoJDBC.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userDaoJDBC.saveUser(name, lastName, age);
    }


    @Override
    public void removeUserById(long id) throws SQLException {
        userDaoJDBC.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return userDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJDBC.cleanUsersTable();
    }
}
