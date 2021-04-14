package dev.andrylat.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LuhnValidatorTest {
    LuhnValidator luhnChecker;

    @BeforeEach
    void createLuhnChecker() {
        luhnChecker = new LuhnValidator();
    }

    @Test
    public void validate_ReturnFalse_CardNumberIsNull() {
        String cardNumber = null;
        boolean actual = luhnChecker.validate(cardNumber);
        assertFalse(actual);
    }

    @Test
    public void validate_ReturnFalse_CardNumberIsEmpty() {
        String cardNumber = "";
        boolean actual = luhnChecker.validate(cardNumber);
        assertFalse(actual);
    }

    @Test
    public void validate_ReturnFalse_CardNumberIsWhitespaces() {
        String cardNumber = "       ";
        boolean actual = luhnChecker.validate(cardNumber);
        assertFalse(actual);
    }

    @Test
    public void validate_ReturnFalse_CardNumberIsOneDigit() {
        String cardNumber = "1";
        boolean actual = luhnChecker.validate(cardNumber);
        assertFalse(actual);
    }

    @Test
    public void validate_ReturnFalse_CardNumberIsOneNonDigit() {
        String cardNumber = "a";
        boolean actual = luhnChecker.validate(cardNumber);
        assertFalse(actual);
    }

    @Test
    public void validate_ReturnFalse_CardNumberIsDigitsAndNonDigits() {
        String cardNumber = "1234567abcd87654";
        boolean actual = luhnChecker.validate(cardNumber);
        assertFalse(actual);
    }

    @Test
    public void validate_ReturnFalse_CardNumberIsDigitsWithInvalidControlSum() {
        String cardNumber = "1234567890987654321";
        boolean actual = luhnChecker.validate(cardNumber);
        assertFalse(actual);
    }

    @Test
    public void validate_ReturnTrue_CardNumberIsDigitsWithValidControlSum() {
        String cardNumber = "5457623898234113";
        boolean actual = luhnChecker.validate(cardNumber);
        assertTrue(actual);
    }

}