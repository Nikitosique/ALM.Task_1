package dev.andrylat.validation;

public interface CardValidator {
    boolean validate(String cardNumber);

    String getValidationError();
}