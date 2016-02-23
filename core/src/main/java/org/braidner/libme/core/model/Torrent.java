package org.braidner.libme.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 06/02/2016
 * Time: 19:09
 */
@Document(collection = "Torrents")
public class Torrent {

    @Id private String id;
    private User owner;
    private String name;
    private String torrentLocation;
    private String downloadLocation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTorrentLocation() {
        return torrentLocation;
    }

    public void setTorrentLocation(String torrentLocation) {
        this.torrentLocation = torrentLocation;
    }

    public String getDownloadLocation() {
        return downloadLocation;
    }

    public void setDownloadLocation(String downloadLocation) {
        this.downloadLocation = downloadLocation;
    }
}
