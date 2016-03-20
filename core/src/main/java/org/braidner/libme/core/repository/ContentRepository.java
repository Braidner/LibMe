package org.braidner.libme.core.repository;

import org.braidner.libme.core.model.Content;
import org.braidner.libme.core.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kuznetsovne/ 14.03.2016.
 */
@Repository
public interface ContentRepository extends MongoRepository<Content, String> {
    List<Content> findByType(String type);
    List<Content> findByName(String name);
    List<Content> findByOwner(User owner);
}
