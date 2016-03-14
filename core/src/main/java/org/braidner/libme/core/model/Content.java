package org.braidner.libme.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by goodl on 2/26/2016.
 */
@Document(collection = "Content")
public class Content {

    @Id protected String id;
    private String type;
    protected String name;
    protected String poster;

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

    @Override
    public String toString() {
        return "Content{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
