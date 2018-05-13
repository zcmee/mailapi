package com.github.zcmee.mailapi.api;

public interface SendMessage<T, R> {
    void sendMessage(T addressee, R message);
}
