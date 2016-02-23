package org.braidner.libme.core.repository;

import org.braidner.libme.core.model.Library;
import org.braidner.libme.core.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 03/02/2016
 * Time: 21:47
 */
@Repository
public interface LibraryRepository extends MongoRepository<Library, String> {


    Library findByOwner(User user);

}
