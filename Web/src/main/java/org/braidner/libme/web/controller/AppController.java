package org.braidner.libme.web.controller;

import org.braidner.libme.core.model.Content;
import org.braidner.libme.core.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 30/01/2016
 * Time: 14:56
 */
@Controller
public class AppController {

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(value = {"film/*", "serial/*"}, method = RequestMethod.GET)
    public String index() {
        List<Content> contents = libraryService.loadLibrary();
        return "forward:/index.html";
    }

}
