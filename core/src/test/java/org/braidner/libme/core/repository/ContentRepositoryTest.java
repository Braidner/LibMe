package org.braidner.libme.core.repository;

import org.braidner.libme.core.config.AppConfig;
import org.braidner.libme.core.model.Content;
import org.braidner.libme.core.model.Film;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 30/01/2016
 * Time: 15:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppConfig.class)
public class ContentRepositoryTest {

    @Autowired
    private ContentRepository contentRepository;
    Film film;

    @Before
    public void setUp() throws Exception {
        film = new Film();
        film.setName("Зверополис");
        film.setDescription("Добро пожаловать в Зверополис — современный город, населенный самыми разными животными, от огромных слонов до крошечных мышек. Зверополис разделен на районы, полностью повторяющие естественную среду обитания разных жителей — здесь есть и элитный район Площадь Сахары и неприветливый Тундратаун. В этом городе появляется новый офицер полиции, жизнерадостная зайчиха Джуди Хоппс, которая с первых дней работы понимает, как сложно быть маленькой и пушистой среди больших и сильных полицейских. Джуди хватается за первую же возможность проявить себя, несмотря на то, что ее партнером будет болтливый хитрый лис Ник Уайлд. Вдвоем им предстоит раскрыть сложное дело, от которого будет зависеть судьба всех обитателей Зверополиса.");
        film.setType("film");
        film.setPoster("http://www.kinopoisk.ru/images/film_big/775276.jpg");
        film = contentRepository.save(film);
    }

    @After
    public void tearDown() throws Exception {
        contentRepository.delete(film);
    }

    @Test
    public void testFindByType() throws Exception {
        List<Content> films = contentRepository.findByType(film.getType());
        assertNotNull("Content with type " + film.getType() + " не найден", films);
        films = films.stream().filter(film -> film.getId().equals(this.film.getId())).collect(Collectors.toList());
        assertFalse(films.isEmpty());
    }

    @Test
    public void testFindByName() throws Exception {
        List<Content> films = contentRepository.findByName(film.getName());
        assertNotNull("Content with name ${}", film);
        films = films.stream().filter(film -> film.getId().equals(this.film.getId())).collect(Collectors.toList());
        assertFalse(films.isEmpty());
    }
}