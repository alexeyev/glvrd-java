package ru.stachek66.nlp.glvrd.config;

import java.util.concurrent.TimeUnit;

import com.google.common.base.CaseFormat;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * Copy-pasted from GopStopBot
 * Created by Semyon on 30.07.2016.
 */
public final class RetrofitConfig {

    private static final boolean DEBUG = true;

    private static final int READ_TIMEOUT = 10;

    private static final int CONNECT_TIMEOUT = 5;

    private static OkHttpClient createClient() {

        final OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);

        if (DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }

        return builder.build();
    }

    public static Retrofit createApi() {

        return new Retrofit.Builder()
                .baseUrl("https://api.glvrd.ru/v0/")
                .client(createClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addCallAdapterFactory(SynchronousCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit createMain() {

        return new Retrofit.Builder()
                .baseUrl("https://glvrd.ru/")
                .client(createClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addCallAdapterFactory(SynchronousCallAdapterFactory.create())
                // пусть возвращает ResponseBody
                .build();
    }

    private RetrofitConfig() {

    }
}