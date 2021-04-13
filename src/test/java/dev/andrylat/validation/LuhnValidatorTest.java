package dev.andrylat.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LuhnValidatorTest {
    LuhnValidator luhnChecker;

    @BeforeEach
    void createLuhnChecker() {
        luhnChecker = new LuhnValidator();
    }

    @Test
    public void validate_ReturnError_CardNumberIsNull() {
        String cardNumber = null;
        String expected = "-> Control sum is invalid\n";
        String actual = luhnChecker.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnError_CardNumberIsEmpty() {
        String cardNumber = "";
        String expected = "-> Control sum is invalid\n";
        String actual = luhnChecker.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnError_CardNumberIsWhitespaces() {
        String cardNumber = "       ";
        String expected = "-> Control sum is invalid\n";
        String actual = luhnChecker.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnError_CardNumberIsOneDigit() {
        String cardNumber = "1";
        String expected = "-> Control sum is invalid\n";
        String actual = luhnChecker.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnError_CardNumberIsOneNonDigit() {
        String cardNumber = "a";
        String expected = "-> Control sum is invalid\n";
        String actual = luhnChecker.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnError_CardNumberIsDigitsAndNonDigits() {
        String cardNumber = "1234567abcd87654";
        String expected = "-> Control sum is invalid\n";
        String actual = luhnChecker.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnError_CardNumberIsDigitsWithInvalidControlSum() {
        String cardNumber = "1234567890987654321";
        String expected = "-> Control sum is invalid\n";
        String actual = luhnChecker.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnTrue_CardNumberIsDigitsWithValidControlSum() {
        String cardNumber = "5457623898234113";
        String expected = "";
        String actual = luhnChecker.validate(cardNumber);
        assertEquals(expected, actual);
    }

}