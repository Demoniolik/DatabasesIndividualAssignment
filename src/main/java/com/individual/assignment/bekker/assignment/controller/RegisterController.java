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

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    private UserService userService = new UserService(
            UserDaoImpl.getInstance(new DataSourceBeen(
                    "jdbc:mysql://127.0.0.1:3306/individual_assignment_vol03", "root",
                    "", "org.mariadb.jdbc.Driver"
            ))
    );


    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public RedirectView register(@RequestParam("firstName") String firstName,
                                 @RequestParam("secondName") String secondName,
                                 @RequestParam("login") String login,
                                 @RequestParam("password") String password,
                                 @RequestParam("passwordCheck") String passwordCheck) {

        User user = new User(0, firstName, secondName, login, password, false, UserType.CUSTOMER);
        String result = userService.registerUser(user);
        System.out.println(result);
        return new RedirectView(result);
    }

}
