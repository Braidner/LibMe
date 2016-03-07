package org.braidner.libme.core.repository;

import org.braidner.libme.core.model.Setting;
import org.braidner.libme.core.model.SettingsEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 05/03/2016
 * Time: 23:13
 */
@Repository
public interface SettingRepository extends MongoRepository<Setting, String> {

    Setting findByName(SettingsEnum setting);
}
