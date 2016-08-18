package ru.stachek66.nlp.glvrd.config.model;

import ru.stachek66.nlp.glvrd.config.response.ChunkRangesResponse;
import ru.stachek66.nlp.glvrd.config.response.RulesResponse;

import java.util.List;

/**
 * Created: aam
 * Date:    19.08.16
 */
public class FullResponseData {

    private List<String> splittedText;

    private ChunkRangesResponse fullRangesResponse;

    private RulesResponse rulesResponse;

    public FullResponseData(final List<String> splittedText,
                            final ChunkRangesResponse fullRangesResponse,
                            final RulesResponse rulesResponse) {
        this.splittedText = splittedText;
        this.fullRangesResponse = fullRangesResponse;
        this.rulesResponse = rulesResponse;
    }

}
