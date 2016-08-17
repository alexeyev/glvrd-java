package ru.stachek66.nlp.glvrd.config;

import retrofit2.Retrofit;

/**
 * Created by aam on 18.08.16.
 */
public final class GlvrdServiceBuilder {

    public static GlvrdService getGlvrdService() {
        final Retrofit retrofit = RetrofitConfig.create();
        return retrofit.create(GlvrdService.class);
    }

    private GlvrdServiceBuilder() {

    }
}
