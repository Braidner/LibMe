package org.braidner.libme.core.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.braidner.libme.core.model.User;
import org.braidner.libme.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 30/01/2016
 * Time: 18:56
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String login, String password) {
        User user = new User();
        password = new BCryptPasswordEncoder().encode(password);
        user.setLogin(login);
        user.setPassword(password);
        //todo notify
        return userRepository.save(user);
    }

    @HystrixCommand(groupKey = "UserService", commandKey = "Login")//todo add hystrix timeout
    public User findUser(String login) {
        return userRepository.findByLogin(login);
    }

    public void deleteUser(String id) {
        userRepository.delete(id);
    }

}
