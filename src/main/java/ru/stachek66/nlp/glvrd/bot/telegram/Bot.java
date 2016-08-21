package ru.stachek66.nlp.glvrd.bot.telegram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * Created by Semyon on 30.07.2016.
 * <p>
 * Телеграм бот
 */
public class Bot extends TelegramLongPollingBot {

    private static final Logger LOGGER = LogManager.getLogger(Bot.class);

    private Map<TGSessionKey, TGSession> sessionMap = new HashMap<>();

    private String token = "";

    private Executor executor = Executors.newFixedThreadPool(Constants.THREAD_POOL_SIZE);

    private Controller controller;

    public Bot() {
        controller = new Controller(this);
    }

    public void onUpdateReceived(final Update update) {

        if (update.hasMessage()) {

            final Message message = update.getMessage();

            if (message.hasText() || message.hasLocation()) {
                executor.execute(() -> {
                    try {
                        handleIncomingMessage(message);
                    } catch (final Throwable t) {
                        // чтобы не умер поток из пула ловим вообще всё
                        LOGGER.error(t);
                    }
                });
            }
        }
    }

    private void handleIncomingMessage(final Message message) {

        final Long chatId = message.getChatId();
        final User fromUser = message.getFrom();

        LOGGER.info("Message from "
                + fromUser.getLastName()
                + ' ' + fromUser.getFirstName()
                + " (" + fromUser.getUserName() + ")"
                + ": " + message.getText());

        final TGSessionKey key = new TGSessionKey(fromUser, chatId);
        TGSession session = sessionMap.get(key);

        if (session == null) {
            LOGGER.info("No session in map for key " + key);
            session = new TGSession(chatId, fromUser);
            // новый пользователь (или старый, но пишет из группового чата, неважно)
            session.setNew(true);
            sessionMap.put(key, session);
        }

        try {
            controller.handleMessage(message, session);
        } catch (final TelegramApiException e) {
            LOGGER.error("Error while handling incoming message: " + e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error("Unknown err", e);
            throw e;
        }
    }

    public String getBotUsername() {
        return "glavred_bot";
    }

    @Override
    public String getBotToken() {

        if (token == null || token.isEmpty()) {
            final Properties properties = new Properties();

            try {
                properties.load(properties.getClass().getResourceAsStream("/secret.properties"));
            } catch (IOException e) {
                throw new RuntimeException("No secret.properties with telegram token found in resources/");
            }

            token = properties.getProperty("token");

            if (token == null || token.isEmpty()) {
                throw new RuntimeException("No telegram token found in resources/secret.properties");
            }

            return token;
        }
        return token;
    }
}
