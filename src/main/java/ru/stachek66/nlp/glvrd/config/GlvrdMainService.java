package ru.stachek66.nlp.glvrd.config;

import okhttp3.ResponseBody;
import retrofit2.http.GET;

/**
 * Created by aam on 18.08.16.
 */
public interface GlvrdMainService {

    @GET("/")
    ResponseBody getPage();

}
