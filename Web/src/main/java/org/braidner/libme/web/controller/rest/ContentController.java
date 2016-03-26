package org.braidner.libme.web.controller.rest;

import org.braidner.libme.core.model.Content;
import org.braidner.libme.core.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 03/02/2016
 * Time: 21:53
 */
@RestController
@RequestMapping("/rest/content")
public class ContentController {

    @Autowired
    private LibraryService libraryService;

    @RequestMapping
    public List<Content> loadLibrary() {
        return libraryService.loadLibrary();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Content> searchContent(@Param("name") String name, @Param("type") String type) {
        if (type != null) {
            return libraryService.loadContent(type);
        }
        return libraryService.loadLibrary();
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpStatus uploadContent(@RequestBody Content content) {
        Content upload = libraryService.upload(content);
        return upload != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void editContent(@RequestBody Content content) {
        System.out.println("edit content " + content.getName());
    }
}
