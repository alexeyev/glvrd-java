package ru.stachek66.nlp.glvrd;

import ru.stachek66.nlp.glvrd.services.GlvrdSingleTaskApi;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by aam on 18.08.16.
 */
public class BasicCallTool {


    public static void main(final String[] args) throws IOException {

        final GlvrdSingleTaskApi tool = new GlvrdSingleTaskApi();

        tool.getFullResponse(
                Arrays.asList(
                        "мамы мыли раммы а вообще-то знаете ли",
                        "ватка, лолжка, жгут, баян")
        );
    }
}
