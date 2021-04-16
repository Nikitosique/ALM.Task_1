package dev.andrylat.banking.paymentsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentSystemCheckerTest {

    PaymentSystemChecker checker;

    @BeforeEach
    void createValidator() {
        checker = new PaymentSystemChecker();
    }

    @Test
    public void checkPaymentSystem_Unknown_PaymentSystemIsUnknown() {
        String cardNumber = "0000000000000000";
        String expected = "Unknown";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_Visa_PaymentSystemIsVisa() {
        String cardNumber = "4444444444444448";
        String expected = "VISA";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_MasterCard_PaymentSystemIsMasterCard() {
        String cardNumber = "5500005555555559";
        String expected = "Master Card";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_AmericanExpress_PaymentSystemIsAmericanExpress() {
        String cardNumber = "3714496353984312";
        String expected = "American Express";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_DinersClub_PaymentSystemIsDinersClub() {
        String cardNumber = "3643893643893659";
        String expected = "Diners Club";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_Discover_PaymentSystemIsDiscover() {
        String cardNumber = "6011016011016011";
        String expected = "Discover";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPaymentSystem_JCB_PaymentSystemIsJCB() {
        String cardNumber = "3566003566003566";
        String expected = "JCB";
        String actual = checker.checkPaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

}