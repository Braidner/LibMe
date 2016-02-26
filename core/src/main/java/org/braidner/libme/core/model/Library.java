package org.braidner.libme.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 30/01/2016
 * Time: 13:07
 */
@Document(collection = "Libraries")
public class Library {
    @Id private String id;
    private String name;
    private User owner;
    private Set<Content> content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Content> getContent() {
        if (content == null) content = new HashSet<>();
        return content;
    }

    public void setContent(Set<Content> content) {
        this.content = content;
    }
}
