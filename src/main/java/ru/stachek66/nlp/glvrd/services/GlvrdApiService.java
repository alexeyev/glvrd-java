package ru.stachek66.nlp.glvrd.services;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import ru.stachek66.nlp.glvrd.config.response.ChunkRangesResponse;
import ru.stachek66.nlp.glvrd.config.response.RulesResponse;

/**
 * Created by aam on 18.08.16.
 */
interface GlvrdApiService {

    @FormUrlEncoded
    @Headers(value = {"Referer: https://glvrd.ru/"})
    @POST("@process/")
    ChunkRangesResponse process(@Field("chunks") final String chunks,
                                @Field("csrfmiddlewaretoken") final String token);

    @FormUrlEncoded
    @Headers(value = {"Referer: https://glvrd.ru/"})
    @POST("@rules/")
    RulesResponse rules(@Field("rules") final String rules,
                        @Field("csrfmiddlewaretoken") final String token);
}
