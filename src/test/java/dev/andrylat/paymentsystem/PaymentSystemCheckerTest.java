package dev.andrylat.paymentsystem;

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
    public void checkPaymentSystem_ReturnError_CardNumberIsNull() {
        String cardNumber = null;
        String expected = "Unknown payment system";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_ReturnError_CardNumberIsEmpty() {
        String cardNumber = "";
        String expected = "Unknown payment system";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_ReturnError_CardNumberIsOnlyWhitespaces() {
        String cardNumber = "                             ";
        String expected = "Unknown payment system";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_ReturnError_CardNumberIsOneDigit() {
        String cardNumber = "1";
        String expected = "Unknown payment system";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_ReturnError_CardNumberIsNonDigits() {
        String cardNumber = "aaa";
        String expected = "Unknown payment system";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_ReturnError_CardNumberIsDigitsAndWhitespaces() {
        String cardNumber = "  1            1";
        String expected = "Unknown payment system";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_ReturnError_CardNumberIsDigitsAndNonDigits() {
        String cardNumber = "1234abc5678abcd";
        String expected = "Unknown payment system";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_ReturnError_ControlSumIsInvalid() {
        String cardNumber = "4000000000000000";
        String expected = "Unknown payment system";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_ReturnVisa_CardIsValid() {
        String cardNumber = "4444444444444448";
        String expected = "Card is valid. Payment system is VISA";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_ReturnMasterCard_CardIsMasterCard() {
        String cardNumber = "5500005555555559";
        String expected = "Card is valid. Payment system is Master Card";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_ReturnDiscover_CardIsDiscover() {
        String cardNumber = "6011016011016011";
        String expected = "Card is valid. Payment system is Discover";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

}