package dev.andrylat.banking.card.messageformatter;

public interface MessageFormatter<T> {
    String formatMessage(T message);
}
