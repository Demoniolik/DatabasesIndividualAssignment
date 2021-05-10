package com.individual.assignment.bekker.assignment.controller.admin;

import com.individual.assignment.bekker.assignment.dao.DataSourceBeen;
import com.individual.assignment.bekker.assignment.dao.department.DepartmentDaoImpl;
import com.individual.assignment.bekker.assignment.service.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    private DepartmentService departmentService =
            new DepartmentService(
                    new DepartmentDaoImpl(
                            new DataSourceBeen(
                                    "jdbc:mysql://127.0.0.1:3306/individual_assignment_vol03", "root",
                                    "", "org.mariadb.jdbc.Driver"
                            )
                    )
            );

    @RequestMapping("/getAllDepartments")
    public String getAllDepartments() {
        return departmentService.getAllDepartments();
    }

}
