package dev.andrylat.banking.paymentsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentSystemRetrieverTest {

    PaymentSystemRetriever retriever;

    @BeforeEach
    void createValidator() {
        retriever = new PaymentSystemRetriever();
    }

    @Test
    public void retrievePaymentSystem_Unknown_PaymentSystemIsUnknown() {
        String cardNumber = "0000000000000000";
        PaymentSystem expected = PaymentSystem.UNKNOWN;
        PaymentSystem actual = retriever.retrievePaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void retrievePaymentSystem_Visa_PaymentSystemIsVisa() {
        String cardNumber = "4444444444444448";
        PaymentSystem expected = PaymentSystem.VISA;
        PaymentSystem actual = retriever.retrievePaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void retrievePaymentSystem_MasterCard_PaymentSystemIsMasterCard() {
        String cardNumber = "5500005555555559";
        PaymentSystem expected = PaymentSystem.MASTERCARD;
        PaymentSystem actual = retriever.retrievePaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void retrievePaymentSystem_AmericanExpress_PaymentSystemIsAmericanExpress() {
        String cardNumber = "3714496353984312";
        PaymentSystem expected = PaymentSystem.AMERICAN_EXPRESS;
        PaymentSystem actual = retriever.retrievePaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void retrievePaymentSystem_DinersClub_PaymentSystemIsDinersClub() {
        String cardNumber = "3643893643893659";
        PaymentSystem expected = PaymentSystem.DINERS_CLUB;
        PaymentSystem actual = retriever.retrievePaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void retrievePaymentSystem_Discover_PaymentSystemIsDiscover() {
        String cardNumber = "6011016011016011";
        PaymentSystem expected = PaymentSystem.DISCOVER;
        PaymentSystem actual = retriever.retrievePaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void retrievePaymentSystem_JCB_PaymentSystemIsJCB() {
        String cardNumber = "3566003566003566";
        PaymentSystem expected = PaymentSystem.JCB;
        PaymentSystem actual = retriever.retrievePaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

}