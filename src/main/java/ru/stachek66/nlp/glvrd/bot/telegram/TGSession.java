package ru.stachek66.nlp.glvrd.bot.telegram;

import java.util.HashMap;
import java.util.Map;

import org.telegram.telegrambots.api.objects.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Semyon on 30.07.2016.
 *
 * Сессия пользователя в конкретном чате
 * Для одного и того же пользователя может быть несколько сессий
 * если он общается с ботом в приватном чате, то это одна сессия;
 * если в групповом, то уже другая
 *
 */
class TGSession {

    private Long chatId;

    private User user;

    private boolean isNew = true;

    private Map<String, Object> sessionParams = new HashMap<>();

    TGSession(final Long chatId, final User user) {
        this.chatId = chatId;
        this.user = user;
    }

    public Long getChatId() {
        return chatId;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(final boolean aNew) {
        isNew = aNew;
    }

    public Object put(final String key, final Object value) {
        return sessionParams.put(key, value);
    }

    public Object get(final String key) {
        return sessionParams.get(key);
    }

    public Object remove(final String key) {
        return sessionParams.remove(key);
    }

    public User getUser() {
        return user;
    }

    public TGSessionKey getSessionKey() {
        return  new TGSessionKey(getUser(), getChatId());
    }
}
