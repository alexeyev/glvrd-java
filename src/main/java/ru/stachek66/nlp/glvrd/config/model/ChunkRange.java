package ru.stachek66.nlp.glvrd.config.model;

/**
 * Created by aam on 18.08.16.
 */
public class ChunkRange {

    private final int start;

    private final int end;

    private final String rule;

    public ChunkRange(final int start, final int end, final String rule) {
        this.start = start;
        this.end = end;
        this.rule = rule;
    }

    public String getRule() {
        return rule;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String toString() {
        return "ChunkRange{start=" + start
                + ",end=" + end
                + ",rule=" + rule + '}';
    }
}
