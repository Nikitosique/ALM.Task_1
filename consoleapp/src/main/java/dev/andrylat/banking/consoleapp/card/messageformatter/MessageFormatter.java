package dev.andrylat.banking.consoleapp.card.messageformatter;

public interface MessageFormatter<T> {
    String formatMessage(T message);
}
