package org.braidner.libme.web.service;

import org.braidner.libme.core.model.Content;
import org.braidner.libme.core.model.Film;
import org.braidner.libme.web.dto.KinopiskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author KuznetsovNE/ 31.03.2016.
 */
@Service
public class KinopoisService {
    private static final Pattern KINO_POISK_ID_PATTERN = Pattern.compile("/film/([0-9]*)/");

    @Autowired
    private KinopoiskApi kinopoiskApi;

    public Content parse(String url) {
        Film film = new Film();
        Matcher matcher = KINO_POISK_ID_PATTERN.matcher(url);

        if (matcher.find()) {
            String id = matcher.group(1);
            Call<KinopiskResponse> call = kinopoiskApi.searchFilm(id);
            Response<KinopiskResponse> execute = null;
            try {
                execute = call.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            KinopiskResponse body = execute.body();
            film.setName(body.getNameRU());
            film.setDescription(body.getDescription());
            film.setPoster(body.getPosterURL());
        }

        return film;
    }

    private interface KinopoiskApi {
        //        http://api.kinopoisk.cf/getFilm?filmID=714888
        @GET("/getFilm")
        Call<KinopiskResponse> searchFilm(@Query("filmID")String id);
    }

    @Bean
    public KinopoiskApi build() {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl("http://api.kinopoisk.cf/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return builder.create(KinopoiskApi.class);
    }

}
