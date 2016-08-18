package ru.stachek66.nlp.glvrd.services;

import retrofit2.Retrofit;
import ru.stachek66.nlp.glvrd.config.RetrofitConfig;

/**
 * Created by aam on 18.08.16.
 */
final class GlvrdServiceBuilder {

    public static GlvrdApiService getGlvrdApiService() {
        final Retrofit retrofit = RetrofitConfig.createApi();
        return retrofit.create(GlvrdApiService.class);
    }

    public static GlvrdMainService getGlvrdMainService() {
        final Retrofit retrofit = RetrofitConfig.createMain();
        return retrofit.create(GlvrdMainService.class);
    }

    private GlvrdServiceBuilder() {
    }
}
