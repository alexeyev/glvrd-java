package ru.stachek66.nlp.glvrd.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stachek66.nlp.glvrd.config.model.ChunkRange;
import ru.stachek66.nlp.glvrd.config.model.FullResponseData;
import ru.stachek66.nlp.glvrd.config.response.ChunkRangesResponse;
import ru.stachek66.nlp.glvrd.config.response.RulesResponse;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created: aam
 * Date:    18.08.16
 */
public class GlvrdSingleTaskApi {

    // csrf_token: '2rbyLKnvlyDIgjqmu4Umt9gm2ZXFF729'
    private static final Pattern TOKEN_PATTERN = Pattern.compile("csrf_token:\\s+'([^']+)'");

    private static final Gson GSON = new GsonBuilder().create();

    private GlvrdApiService serviceApi = GlvrdServiceBuilder.getGlvrdApiService();
    private GlvrdMainService serviceMain = GlvrdServiceBuilder.getGlvrdMainService();

    /**
     * Пожалуйста, удержитесь от комментариев
     * о парсинге HTML регулярными выраженяими, хорошо?
     */
    private String extractToken() throws IOException {

        final String page = serviceMain.getPage().string();
        final Matcher matcher = TOKEN_PATTERN.matcher(page);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

    public FullResponseData getFullResponse(final List<String> textSplittedLines) throws IOException {

        final String token = extractToken();
        final String linesListString = GSON.toJson(textSplittedLines);
        final ChunkRangesResponse res = serviceApi.process(linesListString, token);
        final List<List<ChunkRange>> chunks = res.getChunkRanges();

        //todo: make cache global
        final Set<String> rulesForRequest = new HashSet<>();

        for (int i = 0; i < textSplittedLines.size(); i++) {
            for (ChunkRange range : chunks.get(i)) {
                final String rule = range.getRule();
                rulesForRequest.add(rule);
            }
        }

        final RulesResponse resp =
                serviceApi.rules(GSON.toJson(rulesForRequest), token);

        return new FullResponseData(textSplittedLines, res, resp);
    }
}
