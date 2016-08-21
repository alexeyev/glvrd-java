package ru.stachek66.nlp.glvrd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;
import ru.stachek66.nlp.glvrd.bot.telegram.Bot;
import ru.stachek66.nlp.glvrd.services.GlvrdSingleTaskApi;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by aam on 18.08.16.
 */
public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(final String[] args) throws IOException {

        LOGGER.info("Go");

        final TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (final TelegramApiException e) {
            LOGGER.error("Error while registering bot: " + e.getMessage(), e);
        }
    }
}
