package org.braidner.libme.core.service;

import org.braidner.libme.core.model.Torrent;
import org.braidner.libme.core.repository.TorrentRepository;
import org.braidner.libme.core.torrent.TorrentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 06/02/2016
 * Time: 19:14
 */
@Service
public class TorrentService {

    @Autowired
    private TorrentRepository torrentRepository;

    public List<TorrentClient> initTorrentManager() {
        List<Torrent> torrents = torrentRepository.findAll();

        List<TorrentClient> collect = torrents
                .stream()
                .map(e -> new TorrentClient(e.getTorrentLocation(), e.getDownloadLocation()))
                .collect(Collectors.toList());
        collect.forEach(e -> e.getTorrent().download());
        return collect;
    }
}
