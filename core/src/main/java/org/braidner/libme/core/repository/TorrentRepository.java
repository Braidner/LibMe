package org.braidner.libme.core.repository;

import org.braidner.libme.core.model.Torrent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 06/02/2016
 * Time: 19:12
 */
@Repository
public interface TorrentRepository extends MongoRepository<Torrent, String> {
}
