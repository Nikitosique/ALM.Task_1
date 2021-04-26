package dev.andrylat.banking.card.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentSystemValidatorTest {

    PaymentSystemValidator validator;

    @BeforeEach
    void createValidator() {
        validator = new PaymentSystemValidator();
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsNull() {
        String cardNumber = null;
        List<String> expected = new ArrayList<>();
        expected.add("Payment system can't be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsEmpty() {
        String cardNumber = "";
        List<String> expected = new ArrayList<>();
        expected.add("Payment system can't be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsWhitespaces() {
        String cardNumber = "          ";
        List<String> expected = new ArrayList<>();
        expected.add("Payment system can't be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsOneDigit() {
        String cardNumber = "1";
        List<String> expected = new ArrayList<>();
        expected.add("Payment system can't be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsOneNonDigit() {
        String cardNumber = "a";
        List<String> expected = new ArrayList<>();
        expected.add("Payment system can't be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsDigitsAndNonDigits() {
        String cardNumber = "1234abc567def";
        List<String> expected = new ArrayList<>();
        expected.add("Payment system can't be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberHasInvalidPaymentSystem() {
        String cardNumber = "0000000000000000";
        List<String> expected = new ArrayList<>();
        expected.add("Payment system can't be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_CardNumberHasValidPaymentSystem() {
        String cardNumber = "6011016011016015";
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

}