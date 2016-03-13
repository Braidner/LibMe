package org.braidner.libme.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 30/01/2016
 * Time: 14:56
 */
@Controller
public class AppController {

    @RequestMapping({"film/*", "serial/*"})
    public String index() {
        return "forward:/index.html";
    }

}
