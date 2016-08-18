package ru.stachek66.nlp.glvrd.config.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aam on 19.08.16.
 */
public class Rule {
    //      {   "short_description": "Упростите синтаксис, уменьшите вложенность, удалите подчиненные конструкции или разделите на&nbsp;несколько предложений.",
    //          "penalty": "",
    //          "section": "второстепенный синтаксис",
    //          "name": "Возможно, перебор с запятыми",
    //          "description": "\n        \n\n            \n                <h1>Возможно, перебор с запятыми</h1>\n            \n\n\n            \n                <div class=\"rule-description\">Упростите синтаксис, уменьшите вложенность, удалите подчиненные конструкции или разделите на&nbsp;несколько предложений.</div>\n            \n\n\n            \n                <table class=\"rule-examples\">\n                <tr>\n                    <th width=\"50%\">Нет</th>\n                    <th>Да</th>\n                </tr>\n                \n                <tr>\n                    <td>Если хэш-суммы совпадают, получатель узнает, кто отправитель, и&nbsp;что сообщение в&nbsp;порядке.</td>\n                    <td>Если хэш-суммы совпадают, получатель узнает отправителя и&nbsp;что сообщение в&nbsp;порядке.</td>\n                </tr>\n                \n                </table>\n            \n\n            \n\n            \n                <h2>См. также</h2>\n                <ul class=\"see-also\">\n                    <li><a href=\"http://maximilyahov.ru/blog/?go=all/podchinitelnaya-svyaz-i-odnorodnye-chleny/\">Подчинительная связь и&nbsp;однородные члены</a></li>\n                </ul>\n            \n        \n        "
    //       }

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
}
