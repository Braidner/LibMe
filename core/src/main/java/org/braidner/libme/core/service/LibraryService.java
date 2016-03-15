package org.braidner.libme.core.service;

import org.braidner.libme.core.model.Content;
import org.braidner.libme.core.model.Library;
import org.braidner.libme.core.model.User;
import org.braidner.libme.core.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 03/02/2016
 * Time: 21:50
 */
@Service
public class LibraryService {

    @Autowired
    private Authentication authentication;

    @Autowired
    private ContentRepository contentRepository;

    public List<Content> loadLibrary() {
        return contentRepository.findByOwner((User) authentication.getPrincipal());
    }

    public Content upload(Content content) {
        content.setOwner((User) authentication.getPrincipal());
        Library library = new Library();
        library.getContent().add(content);
        return contentRepository.save(content);
    }
}
