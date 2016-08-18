package ru.stachek66.nlp.glvrd.config;

import retrofit2.Retrofit;

/**
 * Created by aam on 18.08.16.
 */
public final class GlvrdServiceBuilder {

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
