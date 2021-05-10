package com.individual.assignment.bekker.assignment;

import com.individual.assignment.bekker.assignment.applicationcontext.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AssignmentApplication {

    public static void main(String[] args) {
//        ApplicationContext applicationContext =
//                new ApplicationContext(
//                        "jdbc:mysql://127.0.0.1:3306/individual_assignment_vol03",
//                        "customer",
//                    "customer_password",
//                        "org.mariadb.jdbc.Driver"
//                );
//        applicationContext.init();
        SpringApplication.run(AssignmentApplication.class, args);
    }

}
