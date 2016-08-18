package ru.stachek66.nlp.glvrd;

import org.apache.commons.lang3.tuple.Pair;
import ru.stachek66.nlp.glvrd.config.GlvrdTool;
import ru.stachek66.nlp.glvrd.config.response.ChunkRangesResponse;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by aam on 18.08.16.
 */
public class BasicCallTool {


    public static void main(final String[] args) throws IOException {

        final GlvrdTool tool = new GlvrdTool();
//        final Pair<String, ChunkRangesResponse> result =
//
//                tool.getTokenAndRanges(
//                        Arrays.asList(
//                                "мамы мыли раммы а вообще-то знаете ли",
//                                "ватка, лолжка, жгут, баян"));
//        System.out.println(result);
//
//        System.out.println(result.getRight().getChunkRanges());

        tool.testRulesParsingGivenTokenAndRanges(
                Arrays.asList(
                        "мамы мыли раммы а вообще-то знаете ли",
                        "ватка, лолжка, жгут, баян")
        );
    }
}
