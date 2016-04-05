package org.braidner.libme.core.service;

import org.braidner.libme.core.CoreTestConfig;
import org.braidner.libme.core.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author kuznetsovne/ 15.03.2016.
 */

public class UserServiceTest extends CoreTestConfig {

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