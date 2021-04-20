package dev.andrylat.banking.card.messageformatter;

import java.util.List;

public class FailureMessageFormatter implements MessageFormatter<List<String>> {

    @Override
    public String formatMessage(List<String> messages) {
        StringBuilder result = new StringBuilder();

        result.append("Card number is invalid.\n");
        result.append("Errors:\n");
        for (String message : messages) {
            result.append("-> ");
            result.append(message);
            result.append("\n");
        }

        return result.toString();
    }

}
