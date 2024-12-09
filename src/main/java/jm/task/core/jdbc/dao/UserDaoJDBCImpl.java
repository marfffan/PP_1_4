package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;


public class UserDaoJDBCImpl implements UserDao {
/**Подправил конекшен и больше Dao не наследуется от утилитного метода*/
    private Connection connection = getConnection();

    public UserDaoJDBCImpl() {
    }

    @Override
    public void createUsersTable() {
        try (Statement statCreateTeble = connection.createStatement()) {
            String sqlCreateTeble = "CREATE TABLE IF NOT EXISTS users(id bigint AUTO_INCREMENT PRIMARY KEY, name varchar(100) NOT NULL, lastName varchar(100) NOT NULL, age tinyint DEFAULT 0)";
            statCreateTeble.executeUpdate(sqlCreateTeble);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/**Удаление таблицы теперь проверяет существует ли таблица и если да то удаляет её*/
    public void dropUsersTable() {
        try (Statement statDropTable = connection.createStatement()) {
            String sqlDropTable = "DROP TABLE IF EXISTS users";
            statDropTable.executeUpdate(sqlDropTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUser(String name, String lastName, byte age){
        String sqlSaveUser = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlSaveUser)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String sqlRemoveUserById = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRemoveUserById)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> userList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка возврата пользователей", e);
        }
        return userList;
    }

    public void cleanUsersTable() {
        try (Statement statCleanTable = connection.createStatement()) {
            String sqlCleanTable = "TRUNCATE TABLE users";
            statCleanTable.executeUpdate(sqlCleanTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
