package org.braidner.libme.core.config;

import com.turn.ttorrent.tracker.Tracker;
import org.braidner.libme.core.service.TorrentService;
import org.braidner.libme.core.torrent.TorrentClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 30/01/2016
 * Time: 13:29
 */
@SpringBootApplication(scanBasePackages = "org.braidner.libme")
@EnableMongoRepositories("org.braidner.libme.core.repository")
@PropertySource(value = "classpath:application_core.properties")
public class AppConfig implements CommandLineRunner {

    @Autowired
    private TorrentService torrentService;

    @Autowired
    private Tracker tracker;


    private static Logger logger = LoggerFactory.getLogger(AppConfig.class);

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Core module loaded");

        List<TorrentClient> torrentClients = torrentService.initTorrentManager();

        torrentClients.parallelStream().forEach(torrentClient -> tracker.announce(torrentClient.getTrackedTorrent()));
        tracker.start();
    }

    @Bean
    public Tracker tracker() {
        try {
            return new Tracker(InetAddress.getLocalHost());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
