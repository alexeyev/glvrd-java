package ru.stachek66.nlp.glvrd.bot.telegram;

import ru.stachek66.nlp.glvrd.config.model.ChunkRange;
import ru.stachek66.nlp.glvrd.config.model.FullResponseData;
import ru.stachek66.nlp.glvrd.config.response.Rule;

import java.util.List;

/**
 * Created: aam
 * Date:    21.08.16
 */
public final class ResponseRepresentation {

    public static String responseToHTMLMessage(final FullResponseData data) {

        final StringBuilder res = new StringBuilder("Разбор: {\n");

        final List<List<ChunkRange>> ranges =
                data.getFullRangesResponse().getChunkRanges();

        for (int i = 0; i < ranges.size(); i++) {

            final List<ChunkRange> rangesForLine = ranges.get(i);

            if (rangesForLine.size() > 0) {

                final String line = data.getSplittedText().get(i);
                res.append("<i>").append(line).append("</i>\n");

                for (final ChunkRange range : rangesForLine) {
                    res.append("<b>[")
                            .append(line.substring(range.getStart(), range.getEnd()))
                            .append("]</b>\n");

                    final Rule rule =
                            data
                                    .getRulesResponse()
                                    .getRules()
                                    .get(range.getRule());

                    if (rule == null) {
                        res.append("Не удаётся найти правило\n");
                    } else {
                        res.append("<i>")
                                .append(rule.getName())
                                .append(".</i> ")
                                .append(
                                        rule
                                                .getShortDescription()
                                                .replaceAll("&nbsp;", " ")
                                                .replaceAll("\\s+", " "))
                                .append("\n");
                    }
                }
                res.append("\n\n");
            }
        }
        return res.append("}").toString();
    }

    public static String responseToMdMessage(final FullResponseData data) {

        //todo: ответ с дескрипшеном в md
        throw new RuntimeException("Not implemented yet");
    }

    private ResponseRepresentation() {
    }

}
