package ru.stachek66.nlp.glvrd.config;

import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.tuple.Pair;
import ru.stachek66.nlp.glvrd.config.model.ChunkRange;
import ru.stachek66.nlp.glvrd.config.response.ChunkRangesResponse;
import ru.stachek66.nlp.glvrd.config.response.RulesResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aam on 18.08.16.
 */
public class GlvrdTool {

    private GlvrdApiService serviceApi = GlvrdServiceBuilder.getGlvrdApiService();

    private GlvrdMainService serviceMain = GlvrdServiceBuilder.getGlvrdMainService();

    // csrf_token: '2rbyLKnvlyDIgjqmu4Umt9gm2ZXFF729'
    private static final Pattern TOKEN_PATTERN = Pattern.compile("csrf_token:\\s+'([^']+)'");

    private String getToken() throws IOException {

        final String page = serviceMain.getPage().string();
        final Matcher matcher = TOKEN_PATTERN.matcher(page);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

    public Pair<String, ChunkRangesResponse> getTokenAndRanges(final List<String> textSplittedLines) throws IOException {

        final String token = getToken();
        final GsonBuilder gb = new GsonBuilder();
        final String linesList = gb.create().toJson(textSplittedLines);

        final ChunkRangesResponse res = serviceApi.process(linesList, token);

        System.out.println(token + " " + res);

        return Pair.of(token, res);
    }


    public void testRulesParsingGivenTokenAndRanges(final List<String> textSplittedLines) throws IOException {

        final String token = getToken();
        final GsonBuilder gb = new GsonBuilder();
        final String linesListString = gb.create().toJson(textSplittedLines);
        final ChunkRangesResponse res = serviceApi.process(linesListString, token);

        System.out.println(token + " " + res);

        List<List<ChunkRange>> chunks = res.getChunkRanges();

        // очень неэффективно
        for (int i = 0; i < textSplittedLines.size(); i++) {

            System.out.println(textSplittedLines.get(i));
            System.out.println(chunks.get(i));

            for (ChunkRange range : chunks.get(i)) {
                System.out.println(range);
                System.out.println(textSplittedLines.get(i).substring(range.getStart(), range.getEnd()));
                final String rulesString = gb.create().toJson(Collections.singletonList(range.getRule()));
                RulesResponse resp = serviceApi.rules(rulesString, token);
                System.out.println(resp);
            }
        }
    }
}
