package org.braidner.libme.web.controller.rest;

import org.braidner.libme.core.model.Content;
import org.braidner.libme.core.model.Library;
import org.braidner.libme.core.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 03/02/2016
 * Time: 21:53
 */
@Controller
@RequestMapping("/rest/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @RequestMapping
    public Library loadLibrary() {
        return libraryService.loadLibrary();
    }

    @RequestMapping(value = "/search/:name")
    public void searchContent(@PathVariable String name) {
        System.out.println("search for content with param: " + name);
    }

    @RequestMapping("/upload")
    public void uploadContent(@RequestBody Content content) {
        libraryService.upload(content);
    }
}
