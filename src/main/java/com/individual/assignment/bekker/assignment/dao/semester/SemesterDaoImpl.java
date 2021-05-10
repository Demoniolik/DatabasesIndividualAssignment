package com.individual.assignment.bekker.assignment.dao.semester;

import com.individual.assignment.bekker.assignment.dao.DataSourceBeen;
import com.individual.assignment.bekker.assignment.model.Semester;
import com.individual.assignment.bekker.assignment.view.wrapper.CourseDepartmentWrapper;
import com.individual.assignment.bekker.assignment.view.wrapper.CoursesForAllLecturersWithWorkLoadWrapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SemesterDaoImpl implements SemesterDao {
    private DataSourceBeen dataSource;
    private static SemesterDaoImpl instance;
    private final String GET_ALL_COURSES_FOR_EACH_LECTURER_WITH_WORKLOAD =
            "SELECT first_name, second_name,  title, activity_name " +
                    "FROM lecturer " +
                    "JOIN lecturer_workload ON lecturer_id = lecturer.id " +
                    "JOIN course_has_activity_type ON course_has_activity_type.id = lecturer_workload.course_has_activity_type_id " +
                    "JOIN semester ON semester.id = course_has_activity_type.course_id " +
                    "JOIN activity_type ON activity_type.id = course_has_activity_type.activity_type_id " +
                    "GROUP BY lecturer.id";

    private final String GET_COURSES_FOR_EACH_DEPARTMENT =
            "SELECT name, s.title " +
                    "FROM department " +
                    "        JOIN lecturer l on department.id = l.department_id " +
                    "        JOIN lecturer_workload lw on l.id = lw.lecturer_id " +
                    "        JOIN course_has_activity_type chat on chat.id = lw.course_has_activity_type_id " +
                    "        JOIN semester s on s.id = chat.course_id";
    private final String GET_ALL_COURSES =
            "SELECT * FROM semester";

    private final String ADD_NEW_SUBJECT =
            "INSERT INTO semester SET " +
                    "title = ?, " +
                    "volume_in_credits = ?";

    private final String UPDATE_SUBJECT_DATA =
            "UPDATE semester SET " +
                    "title = ?, " +
                    "volume_in_credits = ? " +
                    "WHERE id = ?";

    private final String DELETE_SUBJECT_BY_ID =
            "DELETE FROM semester WHERE id = ?";

    public SemesterDaoImpl(DataSourceBeen dataSource) {
        this.dataSource = dataSource;
    }

    public static SemesterDaoImpl getInstance(DataSourceBeen dataSource) {
        if (instance == null) {
            instance = new SemesterDaoImpl(dataSource);
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        return dataSource
                .getDataSource()
                .getConnection();
    }

    @Override
    public Semester get(long id) {
        return null;
    }

    @Override
    public List<Semester> getAll() {
        List<Semester> result = new ArrayList<>();

        try (Statement statement = getConnection().createStatement()) {
            statement.execute(GET_ALL_COURSES);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Semester semester = new Semester(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("volume_in_credits")
                );
                result.add(semester);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    @Override
    public Semester save(Semester semester) {
        try (PreparedStatement statement =
                     getConnection().prepareStatement(ADD_NEW_SUBJECT,
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, semester.getTitle());
            statement.setInt(2, semester.getVolumeInCredits());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                //logger.error("User creation is failed");
            }else {
                //logger.info("User creation is successful");
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        semester.setId(generatedKeys.getLong(1));
                    }else {
//                        logger.error("Failed to create user, no obtained id");
//                        throw new DatabaseException("Failed to create user, no obtained id");
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Semester semester, String[] params) {

    }

    @Override
    public void delete(Semester semester) {

    }

    @Override
    public List<CoursesForAllLecturersWithWorkLoadWrapper>
    getCoursesForEachLecturerWithWorkload() {
        List<CoursesForAllLecturersWithWorkLoadWrapper> list = new ArrayList<>();

        try (Statement statement = getConnection().createStatement()) {
            statement.execute(GET_ALL_COURSES_FOR_EACH_LECTURER_WITH_WORKLOAD);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                CoursesForAllLecturersWithWorkLoadWrapper obj = new CoursesForAllLecturersWithWorkLoadWrapper(
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("title"),
                        resultSet.getString("activity_name")
                );
                list.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public List<CourseDepartmentWrapper> getCoursesForEachDepartment() {
        List<CourseDepartmentWrapper> list = new ArrayList<>();

        try (Statement statement = getConnection().createStatement()) {
            statement.execute(GET_COURSES_FOR_EACH_DEPARTMENT);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                CourseDepartmentWrapper obj = new CourseDepartmentWrapper(
                        resultSet.getString("name"),
                        resultSet.getString("title")
                );
                list.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public void changeSemesterData(Semester semester) {
        try (PreparedStatement statement =
                     getConnection().prepareStatement(UPDATE_SUBJECT_DATA)) {
            statement.setString(1, semester.getTitle());
            statement.setInt(2, semester.getVolumeInCredits());
            statement.setLong(3, semester.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        try (PreparedStatement statement =
                     getConnection().prepareStatement(DELETE_SUBJECT_BY_ID)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
