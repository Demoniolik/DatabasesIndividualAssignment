package com.individual.assignment.bekker.assignment.dao.lecturer;

import com.individual.assignment.bekker.assignment.dao.DataSourceBeen;
import com.individual.assignment.bekker.assignment.model.Lecturer;
import com.individual.assignment.bekker.assignment.view.wrapper.LecturerForEachCourseWrapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LecturerDaoImpl implements LecturerDao {
    private DataSourceBeen dataSource;
    private static LecturerDaoImpl instance;
    private final String GET_ALL_LECTURERS =
            "SELECT * FROM lecturer";
    private final String GET_ALL_LECTURERS_FOR_EACH_COURSE =
            "SELECT title, first_name, second_name " +
                    "FROM lecturer " +
                    "JOIN lecturer_workload ON lecturer_id = lecturer.id " +
                    "JOIN course_has_activity_type ON course_has_activity_type.id = lecturer_workload.course_has_activity_type_id " +
                    "JOIN semester ON semester.id = course_has_activity_type.course_id " +
                    "GROUP BY title";

    private LecturerDaoImpl(DataSourceBeen dataSource) {
        this.dataSource = dataSource;
    }

    public static LecturerDaoImpl getInstance(DataSourceBeen dataSource) {
        if (instance == null) {
            instance = new LecturerDaoImpl(dataSource);
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        return dataSource
                .getDataSource()
                .getConnection();
    }

    @Override
    public Lecturer get(long id) {
        return null;
    }

    @Override
    public List<Lecturer> getAll() {
        List<Lecturer> lecturers = new ArrayList<>();

        try (Statement statement = getConnection().createStatement()) {
            statement.execute(GET_ALL_LECTURERS);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Lecturer lecturer = buildLecturerFromResultSet(resultSet);
                lecturers.add(lecturer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lecturers;
    }

    private Lecturer buildLecturerFromResultSet(ResultSet resultSet) throws SQLException {
        Lecturer lecturer = new Lecturer(
                resultSet.getLong("id"),
                resultSet.getString("first_name"),
                resultSet.getString("second_name"),
                resultSet.getString("sex"),
                resultSet.getString("telephone_number"),
                resultSet.getString("email"),
                resultSet.getString("cabinet_number"),
                resultSet.getLong("department_id")
        );
        return lecturer;
    }

    @Override
    public Lecturer save(Lecturer lecturer) {
        return null;
    }

    @Override
    public void update(Lecturer lecturer, String[] params) {

    }

    @Override
    public void delete(Lecturer lecturer) {

    }

    @Override
    public List<LecturerForEachCourseWrapper> getListOfLecturersForEachCourse() {
        List<LecturerForEachCourseWrapper> list = new ArrayList<>();

        try (Statement statement = getConnection().createStatement()) {
            statement.execute(GET_ALL_LECTURERS_FOR_EACH_COURSE);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                LecturerForEachCourseWrapper lecturerForEachCourseWrapper =
                        new LecturerForEachCourseWrapper(
                                resultSet.getString("title"),
                                resultSet.getString("first_name"),
                                resultSet.getString("second_name")
                        );
                list.add(lecturerForEachCourseWrapper);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
}
