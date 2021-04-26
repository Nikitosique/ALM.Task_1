package dev.andrylat.banking.card.paymentsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentSystemResolverTest {

    PaymentSystemResolver resolver;

    @BeforeEach
    void createValidator() {
        resolver = new PaymentSystemResolver();
    }

    @Test
    public void resolvePaymentSystem_Unknown_PaymentSystemIsUnknown() {
        String cardNumber = "0000000000000000";
        PaymentSystem expected = PaymentSystem.UNKNOWN;
        PaymentSystem actual = resolver.resolvePaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void resolvePaymentSystem_Visa_PaymentSystemIsVisa() {
        String cardNumber = "4444444444444448";
        PaymentSystem expected = PaymentSystem.VISA;
        PaymentSystem actual = resolver.resolvePaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void resolvePaymentSystem_MasterCard_PaymentSystemIsMasterCard() {
        String cardNumber = "5500005555555559";
        PaymentSystem expected = PaymentSystem.MASTERCARD;
        PaymentSystem actual = resolver.resolvePaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void resolvePaymentSystem_AmericanExpress_PaymentSystemIsAmericanExpress() {
        String cardNumber = "3714496353984312";
        PaymentSystem expected = PaymentSystem.AMERICAN_EXPRESS;
        PaymentSystem actual = resolver.resolvePaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void resolvePaymentSystem_DinersClub_PaymentSystemIsDinersClub() {
        String cardNumber = "3643893643893659";
        PaymentSystem expected = PaymentSystem.DINERS_CLUB;
        PaymentSystem actual = resolver.resolvePaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void resolvePaymentSystem_Discover_PaymentSystemIsDiscover() {
        String cardNumber = "6011016011016011";
        PaymentSystem expected = PaymentSystem.DISCOVER;
        PaymentSystem actual = resolver.resolvePaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void resolvePaymentSystem_JCB_PaymentSystemIsJCB() {
        String cardNumber = "3566003566003566";
        PaymentSystem expected = PaymentSystem.JCB;
        PaymentSystem actual = resolver.resolvePaymentSystem(cardNumber);
        assertEquals(expected, actual);
    }

}