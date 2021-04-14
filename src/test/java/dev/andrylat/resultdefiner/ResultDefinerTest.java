package dev.andrylat.resultdefiner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultDefinerTest {

    ResultDefiner definer;

    @BeforeEach
    void createDefiner() {
        definer = new ResultDefiner();
    }

    @Test
    public void defineResult_ReturnErrors_CardNumberIsNull() {
        String cardNumber = null;
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = definer.defineResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void defineResult_ReturnErrors_CardNumberIsEmpty() {
        String cardNumber = "";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = definer.defineResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void defineResult_ReturnErrors_CardNumberIsWhitespaces() {
        String cardNumber = "                ";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = definer.defineResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void defineResult_ReturnErrors_CardNumberIsOneDigit() {
        String cardNumber = "1";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = definer.defineResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void defineResult_ReturnErrors_CardNumberIsOneNonDigit() {
        String cardNumber = "a";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = definer.defineResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void defineResult_ReturnErrors_CardNumberIsDigitsAndNonDigits() {
        String cardNumber = "1234567abcd87654";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = definer.defineResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void defineResult_ReturnErrors_CardNumberIsDigitsWithInvalidControlSum() {
        String cardNumber = "4567890987654321";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Control sum is invalid\n" +
                "-> Payment System can't be determined";
        String actual = definer.defineResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void defineResult_ReturnErrors_PaymentSystemNotDetermined() {
        String cardNumber = "0000000000000000";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Payment System can't be determined";
        String actual = definer.defineResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void defineResult_ReturnVisa_CardIsVisa() {
        String cardNumber = "4444444444444448";
        String expected = "Card is valid. Payment system is VISA";
        String actual = definer.defineResult(cardNumber);
        assertEquals(expected, actual);
    }

}