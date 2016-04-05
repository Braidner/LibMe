package org.braidner.libme.web.controller.rest;

import org.braidner.libme.core.model.Content;
import org.braidner.libme.web.service.KinopoiskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KuznetsovNE/ 05.04.2016.
 */
@RestController
@RequestMapping("rest/kinopoisk")
public class KinopoiskController {

    private final static Logger LOG = LoggerFactory.getLogger(KinopoiskController.class);

    @Autowired
    private KinopoiskService kinopoiskService;

    @RequestMapping(method = RequestMethod.GET)
    public Content parseKinopoisk(@RequestParam("url") String url) {
        Content parse = kinopoiskService.parse(url);
        LOG.info("Parsed film from kinopoisk" + parse.getName());
        return parse;
    }

}
