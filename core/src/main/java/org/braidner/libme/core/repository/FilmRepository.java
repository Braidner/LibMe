package org.braidner.libme.core.repository;

import org.braidner.libme.core.model.Film;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 30/01/2016
 * Time: 14:06
 */
@Repository
public interface FilmRepository extends MongoRepository<Film, String> {
    Film findByName(String name);
}
