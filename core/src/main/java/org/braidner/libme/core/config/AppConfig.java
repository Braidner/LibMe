package org.braidner.libme.core.config;

import org.braidner.libme.core.service.TorrentService;
import org.braidner.libme.core.torrent.TorrentClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

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


    private static Logger logger = LoggerFactory.getLogger(AppConfig.class);

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Core module loaded");

        List<TorrentClient> torrentClients = torrentService.initTorrentManager();


    }
}
