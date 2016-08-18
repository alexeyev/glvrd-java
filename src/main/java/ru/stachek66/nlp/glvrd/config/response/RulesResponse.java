package ru.stachek66.nlp.glvrd.config.response;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by aam on 19.08.16.
 */
public class RulesResponse {

    @SerializedName("rules")
    private Map<String, Rule> rules;

}
