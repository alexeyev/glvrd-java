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

    public List<String> getSplittedText() {
        return splittedText;
    }

    public void setSplittedText(List<String> splittedText) {
        this.splittedText = splittedText;
    }

    public ChunkRangesResponse getFullRangesResponse() {
        return fullRangesResponse;
    }

    public void setFullRangesResponse(ChunkRangesResponse fullRangesResponse) {
        this.fullRangesResponse = fullRangesResponse;
    }

    public RulesResponse getRulesResponse() {
        return rulesResponse;
    }

    public void setRulesResponse(RulesResponse rulesResponse) {
        this.rulesResponse = rulesResponse;
    }

    public String toString() {
        return "FullResponseData{rangesResponse=["
                + fullRangesResponse + "], rules=["
                + rulesResponse + "]}";
    }
}
