package org.braidner.libme.core.service;

import org.braidner.libme.core.model.Library;
import org.braidner.libme.core.model.User;
import org.braidner.libme.core.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 03/02/2016
 * Time: 21:50
 */
@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public Library loadLibrary() {
        return libraryRepository.findByOwner(/*getCurrentUser*/new User());
    }
}
