package org.braidner.libme.core.torrent;

import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.client.SharedTorrent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 06/02/2016
 * Time: 18:26
 */
public class TorrentClient {

    private final static Logger logger = LoggerFactory.getLogger(TorrentClient.class);

    private Client torrent;

    private String name;

    public TorrentClient(String filePath, String output) {
        File torrentFile = new File(filePath);
        File outputDir = new File(output);
        try {
            Client client = new Client(
                    // This is the interface the client will listen on (you might need something
                    // else than localhost here).
                    InetAddress.getLocalHost(),

                    // Load the torrent from the torrent file and use the given
                    // output directory. Partials downloads are automatically recovered.
                    SharedTorrent.fromFile(
                            torrentFile,
                            outputDir));
            client.setMaxDownloadRate(50.0);
            client.setMaxUploadRate(50.0);

            name = torrentFile.getName();
            torrent = client;

//            Tracker tracker = new Tracker(new InetSocketAddress(6969));
//            tracker.getTrackedTorrents().forEach(trackedTorrent -> trackedTorrent.getAnnounceList());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public Client getTorrent() {
        return torrent;
    }

    public void setTorrent(Client torrent) {
        this.torrent = torrent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
