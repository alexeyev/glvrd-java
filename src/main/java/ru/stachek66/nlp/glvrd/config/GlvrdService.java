package ru.stachek66.nlp.glvrd.config;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by aam on 18.08.16.
 */
public interface GlvrdService {

    @FormUrlEncoded
    @POST("@process")
    ChunkRanges search(@Field("chunks") final String chunks);

}
