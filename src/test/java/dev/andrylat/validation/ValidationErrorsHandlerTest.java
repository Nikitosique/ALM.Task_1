package dev.andrylat.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidationErrorsHandlerTest {
    ValidationErrorsHandler errors;

    @BeforeEach
    void createValidationErrors() {
        errors = new ValidationErrorsHandler();
    }

    @Test
    public void getErrorMessage_ReturnMessages_CardNumberIsNull() {
        String cardNumber = null;
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = errors.getErrorMessage(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void getErrorMessage_ReturnMessages_CardNumberIsEmpty() {
        String cardNumber = "";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = errors.getErrorMessage(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void getErrorMessage_ReturnMessages_CardNumberIsWhitespaces() {
        String cardNumber = "                ";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = errors.getErrorMessage(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void getErrorMessage_ReturnMessages_CardNumberIsOneDigit() {
        String cardNumber = "1";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = errors.getErrorMessage(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void getErrorMessage_ReturnMessages_CardNumberIsOneNonDigit() {
        String cardNumber = "a";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = errors.getErrorMessage(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void getErrorMessage_ReturnMessages_CardNumberIsDigitsAndWhitespaces() {
        String cardNumber = "1            1";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = errors.getErrorMessage(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void getErrorMessage_ReturnMessages_CardNumberIsDigitsAndNonDigits() {
        String cardNumber = "987qwe.!?abc654";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = errors.getErrorMessage(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void getErrorMessage_ReturnMessages_ControlSumIsInvalid() {
        String cardNumber = "4000000000000000";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = errors.getErrorMessage(cardNumber);
        assertEquals(expected, actual);
    }
}