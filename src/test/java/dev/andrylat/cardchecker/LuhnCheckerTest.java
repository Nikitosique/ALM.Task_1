package dev.andrylat.cardchecker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LuhnCheckerTest {
    LuhnChecker luhnChecker;

    @BeforeEach
    void createLuhnChecker() {
        luhnChecker = new LuhnChecker();
    }

    @Test
    public void Should_ReturnFalse_When_CardNumberIsNull() {
        String cardNumber = null;
        boolean actual = luhnChecker.check(cardNumber);
        assertFalse(actual);
    }

    @Test
    public void Should_ReturnFalse_When_CardNumberIsEmpty() {
        String cardNumber = "";
        boolean actual = luhnChecker.check(cardNumber);
        assertFalse(actual);
    }

    @Test
    public void Should_ReturnFalse_When_CardNumberIsWhitespaces() {
        String cardNumber = "       ";
        boolean actual = luhnChecker.check(cardNumber);
        assertFalse(actual);
    }

    @Test
    public void Should_ReturnFalse_When_CardNumberIsOneDigit() {
        String cardNumber = "1";
        boolean actual = luhnChecker.check(cardNumber);
        assertFalse(actual);
    }

    @Test
    public void Should_ReturnFalse_When_CardNumberIsOneNonDigit() {
        String cardNumber = "a";
        boolean actual = luhnChecker.check(cardNumber);
        assertFalse(actual);
    }

    @Test
    public void Should_ReturnFalse_When_CardNumberIsDigitsAndNonDigits() {
        String cardNumber = "1234567abcd87654";
        boolean actual = luhnChecker.check(cardNumber);
        assertFalse(actual);
    }

    @Test
    public void Should_ReturnFalse_When_CardNumberIsDigitsWithInvalidControlSum() {
        String cardNumber = "1234567890987654321";
        boolean actual = luhnChecker.check(cardNumber);
        assertFalse(actual);
    }

    @Test
    public void Should_ReturnTrue_When_CardNumberIsDigitsWithValidControlSum() {
        String cardNumber = "5457623898234113";
        boolean actual = luhnChecker.check(cardNumber);
        assertTrue(actual);
    }


}