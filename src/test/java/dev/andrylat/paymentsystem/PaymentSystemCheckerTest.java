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
    public void checkPaymentSystem_ReturnUnknown_PaymentSystemNotDetermined() {
        String cardNumber = "0000000000000000";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Payment System can't be determined";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_ReturnVisa_CardIsVisa() {
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