package com.individual.assignment.bekker.assignment.controller;

import com.individual.assignment.bekker.assignment.dao.DataSourceBeen;
import com.individual.assignment.bekker.assignment.dao.user.UserDaoImpl;
import com.individual.assignment.bekker.assignment.model.User;
import com.individual.assignment.bekker.assignment.model.UserType;
import com.individual.assignment.bekker.assignment.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
    private UserService userService = new UserService(
            UserDaoImpl.getInstance(new DataSourceBeen(
                    "jdbc:mysql://127.0.0.1:3306/individual_assignment_vol03", "root",
                    "", "org.mariadb.jdbc.Driver"
            ))
    );

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public RedirectView login(@RequestParam("login") String login,
                                 @RequestParam("password") String password) {

        User user = userService.getUserByCredentials(login, password);

        if (user == null) {
            return new RedirectView("index.html");
        }
        if (user.getUserType().equals(UserType.ADMIN)) {
            return new RedirectView("admin/mainAdminPage.html");
        }

        return new RedirectView("mainPage.html");
    }
}
