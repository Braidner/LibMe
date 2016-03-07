package org.braidner.libme.web.controller.rest;

import org.braidner.libme.core.model.User;
import org.braidner.libme.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 31/01/2016
 * Time: 17:31
 */
@RestController
@RequestMapping("rest")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String registration(Principal principal, @RequestBody User user) {
        if (principal == null) {
            userService.createUser(user.getLogin(), user.getPassword()); // TODO validation
        }
        return "okay";
    }

    @RequestMapping("user")
    public Principal user(Principal user) {
        return user;
    }

}
