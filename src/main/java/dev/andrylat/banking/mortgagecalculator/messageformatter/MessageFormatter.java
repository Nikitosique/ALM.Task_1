package dev.andrylat.banking.mortgagecalculator.messageformatter;

public interface MessageFormatter<T> {
    String formatMessage(T message);
}
