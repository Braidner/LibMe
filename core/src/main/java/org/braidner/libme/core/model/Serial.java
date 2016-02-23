package org.braidner.libme.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 30/01/2016
 * Time: 13:07
 */
@Document(collection = "Serials")
public class Serial {
    @Id private String id;
    private String name;
    private Integer totalSeries;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalSeries() {
        return totalSeries;
    }

    public void setTotalSeries(Integer totalSeries) {
        this.totalSeries = totalSeries;
    }
}
