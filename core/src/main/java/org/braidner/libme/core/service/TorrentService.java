package org.braidner.libme.core.service;

import org.braidner.libme.core.model.SettingsEnum;
import org.braidner.libme.core.model.Torrent;
import org.braidner.libme.core.repository.TorrentRepository;
import org.braidner.libme.core.torrent.TorrentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @Autowired
    private SettingService settingService;

    public List<TorrentClient> initTorrentManager() {
        List<Torrent> torrents = torrentRepository.findAll();

        List<TorrentClient> collect = torrents
                .stream()
                .map(e -> new TorrentClient(e.getTorrentLocation(), e.getDownloadLocation()))
                .collect(Collectors.toList());
        collect.forEach(e -> e.getTorrent().download());
        return collect;
    }


    public void uploadTorrent(MultipartFile file) {
        String saveLocation = settingService.getValue(SettingsEnum.SAVE_PATH);
        try (final InputStream inputStream = file.getInputStream()){
            Files.copy(inputStream, Paths.get(saveLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
        TorrentClient torrentClient = new TorrentClient(saveLocation + file.getName(), saveLocation);
        torrentClient.getTorrent().download();
        torrentClient.getTorrent().waitForCompletion();
    }

}
