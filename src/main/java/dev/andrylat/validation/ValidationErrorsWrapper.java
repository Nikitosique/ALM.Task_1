package dev.andrylat.validation;

public class ValidationErrorsWrapper {

    private static final String MESSAGE_HEADER = "Card number is invalid.\n" + "Errors:\n";
    private static final String MESSAGE_LAST_LINE = "-> Payment System can't be determined";

    public String createErrorMessage(String errors) {
        StringBuilder message = new StringBuilder();
        message.append(MESSAGE_HEADER);
        message.append(errors);
        message.append(MESSAGE_LAST_LINE);
        return message.toString();
    }

}
