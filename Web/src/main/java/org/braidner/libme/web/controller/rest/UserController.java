package org.braidner.libme.web.controller.rest;

import org.braidner.libme.core.model.User;
import org.braidner.libme.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public @ResponseBody String login() {
        boolean hasAccess = userService.login("admin", "123");
        return Boolean.toString(hasAccess);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public @ResponseBody String registration(@RequestBody User user) {
        userService.createUser(user.getLogin(), user.getPassword()); // TODO validation
        return "okay";
    }

}
