package ru.stachek66.nlp.glvrd.bot.telegram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.ActionType;
import org.telegram.telegrambots.api.methods.send.SendChatAction;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import ru.stachek66.nlp.glvrd.config.model.FullResponseData;
import ru.stachek66.nlp.glvrd.services.GlvrdSingleTaskApi;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created: aam
 * Date:    21.08.16
 */
class Controller {

    private static final Logger LOGGER = LogManager.getLogger(Controller.class);

    private Bot bot;

    private GlvrdSingleTaskApi glvrdSingleTaskApi = new GlvrdSingleTaskApi();

    Controller(final Bot bot) {
        this.bot = bot;
    }

    /**
     * Обработка входящего сообщения
     *
     * @param request
     * @throws TelegramApiException
     */
    public void handleMessage(final Message request, final TGSession session) throws TelegramApiException {

        final String text = request.getText();
        sendAction(request.getChatId().toString(), ActionType.TYPING);

        try {
            final FullResponseData apiResponse = glvrdSingleTaskApi.getFullResponse(Arrays.asList(text.split("\\n")));
            LOGGER.info("RESPONSE PREPARED\t" + apiResponse.toString());
            sendHtmlMessage(
                    request.getChatId().toString(),
                    ResponseRepresentation.responseToHTMLMessage(apiResponse));
        } catch (final IOException ioe) {
            sendMessage(request.getChatId().toString(), "Сломалось что-то в Датском королевстве.");
        }
    }

    void sendMessage(final String chatId, final String reply) throws TelegramApiException {
        final SendMessage msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText(reply);
        msg.enableMarkdown(true);
        LOGGER.info("MESsAGE\t" + msg.toString());
        bot.sendMessage(msg);
    }

    void sendHtmlMessage(final String chatId, final String reply) throws TelegramApiException {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText(reply);
        msg.enableHtml(true);
        bot.sendMessage(msg);
    }

    void sendAction(final String chatId, final ActionType actionType) throws TelegramApiException {
        SendChatAction action = new SendChatAction();
        action.setChatId(chatId);
        action.setAction(actionType);
        bot.sendChatAction(action);
    }

    protected Bot getBot() {
        return bot;
    }

}
