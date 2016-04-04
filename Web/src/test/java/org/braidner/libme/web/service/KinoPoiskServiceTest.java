package org.braidner.libme.web.service;

import org.braidner.libme.core.model.Content;
import org.braidner.libme.core.model.Film;
import org.braidner.libme.web.TestConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * @author KuznetsovNE/ 31.03.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
public class KinoPoiskServiceTest {

    @Autowired
    private KinoPoiskService kinoPoiskService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void parse() throws Exception {
        Content content = kinoPoiskService.parse("http://www.kinopoisk.ru/film/775276/");
        assertTrue(content instanceof Film);
        assertTrue(content.getName().equals("Зверополис"));
    }
}