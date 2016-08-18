package ru.stachek66.nlp.glvrd.cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * todo
 * Created by aam on 19.08.16.
 */
public final class RulesCache {

    private static final Logger LOGGER = LogManager.getLogger(RulesCache.class);

    private static final RulesCache INSTANCE;

    static {
        try {
            INSTANCE = new RulesCache();
        } catch (final Throwable ioe) {
            LOGGER.error("Stress map is dead, no use in continuations", ioe);
            throw new RuntimeException(ioe);
        }
    }

    private RulesCache() {
        //todo: set cache
    }

    public static RulesCache getInstance() {
        return INSTANCE;
    }
}
