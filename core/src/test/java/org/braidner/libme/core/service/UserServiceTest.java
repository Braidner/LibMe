package org.braidner.libme.core.service;

import org.braidner.libme.core.config.AppConfig;
import org.braidner.libme.core.model.Film;
import org.braidner.libme.core.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author kuznetsovne/ 15.03.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;
    private User newUser;

    @Before
    public void setUp() throws Exception {
        newUser = userService.createUser("test@braidner.org", "flowpassword");
    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(newUser.getId());
    }

    @Test
    public void testCreateUser() throws Exception {
        assertNotNull("User not created", newUser);
        assertNotNull("User not created", newUser.getId());
    }

    @Test
    public void testFindUser() throws Exception {
        User user = userService.findUser(newUser.getLogin());
        assertNotNull("User not found", user);
        assertTrue("Duplicate user found", user.getId().equals(newUser.getId()));
    }
}