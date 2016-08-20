package ru.stachek66.nlp.glvrd.bot.telegram;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.ActionType;
import org.telegram.telegrambots.api.methods.send.SendChatAction;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

/**
 * Created: aam
 * Date:    21.08.16
 */
public class OnlyController {

    private Bot bot;

    OnlyController(final Bot bot) {
        this.bot = bot;
    }


    /**
     * Обработка входящего сообщения
     *
     * @param request
     * @throws TelegramApiException
     */
    public void handleMessage(final Message request, final TGSession session) throws TelegramApiException {

    }

    void sendMessage(final String chatId, final String reply) throws TelegramApiException {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText(reply);
        msg.enableMarkdown(true);
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
