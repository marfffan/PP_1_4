package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//dao - пакет dao (Data Access Object), содержит классы, отвечающие за взаимодействие с базой данных.
public class UserDaoJDBCImpl implements UserDao {

    private static Connection connection = Util.getConnection();

    //Конструктор без парамметров
    public UserDaoJDBCImpl() {
    }

    @Override
    public void createUsersTable() {

        try (Statement statCreateTeble = connection.createStatement()) {
            String sqlCreateTeble = "CREATE TABLE IF NOT EXISTS users(id bigint AUTO_INCREMENT PRIMARY KEY, name varchar(100) NOT NULL, lastName varchar(100) NOT NULL, age tinyint DEFAULT 0)";
            statCreateTeble.executeUpdate(sqlCreateTeble);
            System.out.println("Создали таблицу");
        } catch (SQLException e) {
            System.out.println("Не удалось создать таблицу");
        }
    }


    public void dropUsersTable() {
        try (Statement statDropTable = connection.createStatement()) {
            String sqlDropTable = "DROP TABLE users";
            statDropTable.executeUpdate(sqlDropTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String sqlSaveUser = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlSaveUser)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        }
        System.out.println("User с именем — " + name);
    }

    public void removeUserById(long id) throws SQLException {
        String sqlRemoveUserById = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRemoveUserById)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
    }


    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM users");

        while (rs.next()) {
            String name = rs.getString("name");
            String lastName = rs.getString("lastName");
            Byte age = rs.getByte("age");
            users.add(new User(name, lastName, age));
        }

        st.close();
        return users;
    }

    public void cleanUsersTable() {

    }
}
