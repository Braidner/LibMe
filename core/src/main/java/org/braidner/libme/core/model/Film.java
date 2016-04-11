package org.braidner.libme.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 30/01/2016
 * Time: 13:07
 */
public class Film extends Content {
    private String description;
    private String path;
    private String year;
    private String kinopoiskId;
    private List<String> countries;
    private List<String> genres;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getKinopoiskId() {
        return kinopoiskId;
    }

    public void setKinopoiskId(String kinopoiskId) {
        this.kinopoiskId = kinopoiskId;
    }

    public List<String> getCountries() {
        if (countries == null) countries = new ArrayList<>();
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getGenres() {
        if (genres == null) genres = new ArrayList<>();
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

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
