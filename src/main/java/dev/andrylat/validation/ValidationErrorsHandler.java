package dev.andrylat.validation;

public class ValidationErrorsHandler {

    public static final String MESSAGE_HEADER = "Card number is invalid.\n" + "Errors:\n";
    public static final String MESSAGE_LAST_LINE = "-> Payment System can't be determined";

    public String getErrorMessage(String cardNumber) {
        CardValidator nonDigitsValidator = new NonDigitsValidator();
        CardValidator lengthValidator = new LengthValidator();
        CardValidator luhnValidator = new LuhnValidator();

        return MESSAGE_HEADER +
                nonDigitsValidator.validate(cardNumber) +
                lengthValidator.validate(cardNumber) +
                luhnValidator.validate(cardNumber) +
                MESSAGE_LAST_LINE;
    }
}
