package dev.andrylat.banking.messageformatter;

public interface MessageFormatter<T> {
    String formatMessage(T message);
}
