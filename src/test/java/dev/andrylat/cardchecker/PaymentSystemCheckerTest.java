package dev.andrylat.cardchecker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentSystemCheckerTest {

    PaymentSystemChecker checker;

    @BeforeEach
    void createChecker() {
        checker = new PaymentSystemChecker();
    }

    @Test
    public void Should_ReturnErrors_When_CardNumberIsNull() {
        String cardNumber = null;
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number is blank\n" +
                "-> Payment System can't be determined";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void Should_ReturnErrors_When_CardNumberIsEmpty() {
        String cardNumber = "";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number is blank\n" +
                "-> Payment System can't be determined";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void Should_ReturnErrors_When_CardNumberIsOnlyWhitespaces() {
        String cardNumber = "                             ";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number is blank\n" +
                "-> Payment System can't be determined";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void Should_ReturnError_When_CardNumberIsOneDigit() {
        String cardNumber = "1";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Payment System can't be determined";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void Should_ReturnError_When_CardNumberIsNonDigits() {
        String cardNumber = "aaa";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Payment System can't be determined";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void Should_ReturnError_When_CardNumberIsDigitsAndWhitespaces() {
        String cardNumber = "  1            1";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Payment System can't be determined";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void Should_ReturnError_When_CardNumberIsDigitsAndNonDigits() {
        String cardNumber = "1234abc5678abcd";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Payment System can't be determined";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void Should_ReturnError_When_ControlSumIsInvalid() {
        String cardNumber = "4000000000000000";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Payment System can't be determined";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void Should_ReturnVisa_When_CardIsValid() {
        String cardNumber = "4444444444444448";
        String expected = "Card is valid. Payment system is VISA";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void Should_ReturnMasterCard_When_CardIsMasterCard() {
        String cardNumber = "5500005555555559";
        String expected = "Card is valid. Payment system is Master Card";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void Should_ReturnDiscover_When_CardIsDiscover() {
        String cardNumber = "6011016011016011";
        String expected = "Card is valid. Payment system is Discover";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

}