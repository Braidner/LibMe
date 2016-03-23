package org.braidner.libme.web.controller.rest;

import org.braidner.libme.core.service.TorrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author kuznetsovne/ 22.03.2016.
 */

@RestController
@RequestMapping("rest/torrent")
public class TorrentController {

    @Autowired
    private TorrentService torrentService;

    @RequestMapping(method = RequestMethod.POST)
    public HttpStatus loadTorrent(@RequestParam MultipartFile file) {
        torrentService.uploadTorrent(file);
        return HttpStatus.ACCEPTED;
    }
}
