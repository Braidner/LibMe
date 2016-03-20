package org.braidner.libme.core.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.annotation.Id;

/**
 * Created by goodl on 2/26/2016.
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Book.class, name="book"),
        @JsonSubTypes.Type(value=Serial.class, name="serial"),
        @JsonSubTypes.Type(value=Film.class, name="film")
})
public class Content {

    @Id private String id;
    private String type;
    protected String name;
    protected String poster;
    protected User owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        if (type == null) type = getClass().getName();
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Content{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
