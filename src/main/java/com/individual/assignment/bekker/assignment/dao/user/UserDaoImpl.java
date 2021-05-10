package com.individual.assignment.bekker.assignment.dao.user;

import com.individual.assignment.bekker.assignment.dao.DataSourceBeen;
import com.individual.assignment.bekker.assignment.model.User;
import com.individual.assignment.bekker.assignment.model.UserType;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance;
    DataSourceBeen dataSourceBeen;
    private static final String QUERY_TO_CREATE_USER = "INSERT INTO user SET first_name = ?," +
            "second_name = ?," +
            "login = ?," +
            "password = ?," +
            "blocked = ?," +
            "user_type_id = ?";
    private final String GET_USER_BY_CREDENTIALS =
            "SELECT * FROM user WHERE login = ? AND password = ?";
    private final String IS_LOGIN_ALREADY_IN_BASE =
            "SELECT EXISTS(SELECT * FROM user WHERE login = ?)";

    private UserDaoImpl(DataSourceBeen dataSourceBeen) {
        this.dataSourceBeen = dataSourceBeen;
    }

    public static UserDaoImpl getInstance(DataSourceBeen dataSourceBeen) {
        if (instance == null) {
            instance = new UserDaoImpl(dataSourceBeen);
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        Connection connection =  dataSourceBeen
                .getDataSource()
                .getConnection();
        return connection;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public User getUserById() {
        return null;
    }

    @Override
    public User getUserByCredentials(String login, String password) {
        User user = null;

        try (PreparedStatement statement =
                     getConnection().prepareStatement(GET_USER_BY_CREDENTIALS)) {
            statement.setString(1, login);
            statement.setString(2, password);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("blocked"),
                        UserType.values()[resultSet.getInt("user_type_id") - 1]
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean isLoginAlreadyExist(String login) {
        try (PreparedStatement statement = getConnection()
                .prepareStatement(IS_LOGIN_ALREADY_IN_BASE)) {
            statement.setString(1, login);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();

            if (resultSet.next() && resultSet.getBoolean(1)) {
                return true;
            }
        } catch (SQLException throwables) {
            //TODO: add logger
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User save(User user) {
        try (PreparedStatement statement =
                     getConnection().prepareStatement(QUERY_TO_CREATE_USER,
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getSecondName());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.setBoolean(5, user.isBlocked());
            statement.setLong(6, user.getUserType().ordinal() + 1);
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                //logger.error("User creation is failed");
            }else {
                //logger.info("User creation is successful");
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setId(generatedKeys.getLong(1));
                    }else {
//                        logger.error("Failed to create user, no obtained id");
//                        throw new DatabaseException("Failed to create user, no obtained id");
                    }
                }
            }
        } catch (SQLException throwables) {
            //logger.error(exception.getMessage());
            //throw new DatabaseException(exception.getMessage());
            throwables.printStackTrace();
        }

        return user;
    }

    @Override
    public void update(User user, String[] params) {

    }

    @Override
    public void delete(User user) {

    }
}
