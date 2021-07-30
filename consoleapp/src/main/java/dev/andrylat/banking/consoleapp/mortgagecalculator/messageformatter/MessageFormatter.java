package dev.andrylat.banking.consoleapp.mortgagecalculator.messageformatter;

public interface MessageFormatter<T> {
    String formatMessage(T message);
}
