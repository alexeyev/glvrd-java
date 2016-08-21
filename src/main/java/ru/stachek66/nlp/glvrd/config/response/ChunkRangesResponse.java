package ru.stachek66.nlp.glvrd.config.response;

import com.google.gson.annotations.SerializedName;
import ru.stachek66.nlp.glvrd.config.model.ChunkRange;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aam on 18.08.16.
 */
public class ChunkRangesResponse {

    @SerializedName("chunks_ranges")
    private List<List<List<String>>> chunkRanges;

    public List<List<List<String>>> getRawChunkRanges() {
        return chunkRanges;
    }

    private static ChunkRange toRange(final List<String> rawRange) {

        return new ChunkRange(
                Integer.parseInt(rawRange.get(0)),
                Integer.parseInt(rawRange.get(1)),
                rawRange.get(2));
    }

    public List<List<ChunkRange>> getChunkRanges() {
        return chunkRanges
                .stream()
                .map(chunk ->
                        chunk
                                .stream()
                                .map(ChunkRangesResponse::toRange)
                                .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public String toString() {
        return "ChunkRanges:" + chunkRanges + "";
    }
}
