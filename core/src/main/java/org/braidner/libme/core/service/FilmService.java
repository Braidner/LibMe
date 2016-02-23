package org.braidner.libme.core.service;

import org.braidner.libme.core.model.Film;
import org.braidner.libme.core.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 03/02/2016
 * Time: 21:44
 */
@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public Film findFilm(String name) {
        return filmRepository.findByName(name);
    }

}
