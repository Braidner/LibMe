package org.braidner.libme.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 05/03/2016
 * Time: 22:43
 */
@Document(collection = "Settings")
public class Setting {

    @Id private String id;

    private SettingsEnum name;
    private String value;
    private Boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public SettingsEnum getName() {
        return name;
    }

    public void setName(SettingsEnum name) {
        this.name = name;
    }
}
