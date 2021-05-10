package com.individual.assignment.bekker.assignment.dao.department;

import com.individual.assignment.bekker.assignment.dao.DataSourceBeen;
import com.individual.assignment.bekker.assignment.model.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    private DataSourceBeen dataSource;
    private final String GET_ALL_LECTURERS =
            "SELECT * FROM department";

    public DepartmentDaoImpl(DataSourceBeen dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws SQLException {
        return dataSource
                .getDataSource()
                .getConnection();
    }

    @Override
    public Department get(long id) {
        return null;
    }

    @Override
    public List<Department> getAll() {
        List<Department> result = new ArrayList<>();

        try (Statement statement = getConnection().createStatement()) {
            statement.execute(GET_ALL_LECTURERS);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Department department = new Department(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                );
                result.add(department);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    @Override
    public Department save(Department department) {
        return null;
    }

    @Override
    public void update(Department department, String[] params) {

    }

    @Override
    public void delete(Department department) {

    }
}
