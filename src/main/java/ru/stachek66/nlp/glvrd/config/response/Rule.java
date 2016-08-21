package ru.stachek66.nlp.glvrd.config.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aam on 19.08.16.
 */
public class Rule {

    @SerializedName("short_description")
    private String shortDescription;

    @SerializedName("penalty")
    private String penalty;

    @SerializedName("section")
    private String section;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    public String getShortDescription() {
        return shortDescription;
    }

    public String getPenalty() {
        return penalty;
    }

    public String getSection() {
        return section;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "shortDescription='" + shortDescription + '\'' +
                ", penalty='" + penalty + '\'' +
                ", section='" + section + '\'' +
                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
                '}';
    }
}
