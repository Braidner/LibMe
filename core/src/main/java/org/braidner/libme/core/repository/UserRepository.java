package org.braidner.libme.core.repository;

import org.braidner.libme.core.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 30/01/2016
 * Time: 13:27
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByLogin(String login);
}
