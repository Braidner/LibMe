package org.braidner.libme.core.service;

import org.braidner.libme.core.model.Setting;
import org.braidner.libme.core.model.SettingsEnum;
import org.braidner.libme.core.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 05/03/2016
 * Time: 23:16
 */
@Service
public class SettingService {

    @Autowired
    private SettingRepository settingRepository;

    public boolean isActive(SettingsEnum settingsEnum) {
        Setting setting = settingRepository.findByName(settingsEnum);
        return setting != null && setting.getActive();
    }

    public String getValue(SettingsEnum settingsEnum) {
        Setting setting = settingRepository.findByName(settingsEnum);
        return setting != null ? setting.getValue() : null;
    }

    public Setting saveSetting(SettingsEnum settingsEnum, Object value) {
        Setting setting = new Setting();
        setting.setName(settingsEnum);
        if (value instanceof String) {
            setting.setValue((String) value);
        } else if (value instanceof Boolean) {
            setting.setActive((Boolean) value);
        }
        return settingRepository.save(setting);
    }

}
