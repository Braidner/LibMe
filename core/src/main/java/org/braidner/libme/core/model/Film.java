package org.braidner.libme.core.model;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 30/01/2016
 * Time: 13:07
 */
public class Film extends Content {
    private String description;
    private String path;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
