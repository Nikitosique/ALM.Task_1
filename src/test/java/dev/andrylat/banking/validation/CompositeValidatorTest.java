package dev.andrylat.banking.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompositeValidatorTest {

    CompositeValidator validator;

    @BeforeEach
    void createValidator() {
        validator = new CompositeValidator();
    }

    @Test
    public void validate_ReturnListWithFailureMessages_CardNumberIsNull() {
        String cardNumber = null;
        List<String> expected = new ArrayList<>();
        expected.add("Card number should contain only digits");
        expected.add("Card number's length should be 16 digits");
        expected.add("Control sum is invalid");
        expected.add("Payment system cant be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessages_CardNumberIsEmpty() {
        String cardNumber = "";
        List<String> expected = new ArrayList<>();
        expected.add("Card number should contain only digits");
        expected.add("Card number's length should be 16 digits");
        expected.add("Control sum is invalid");
        expected.add("Payment system cant be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessages_CardNumberIsWhitespaces() {
        String cardNumber = "              ";
        List<String> expected = new ArrayList<>();
        expected.add("Card number should contain only digits");
        expected.add("Card number's length should be 16 digits");
        expected.add("Control sum is invalid");
        expected.add("Payment system cant be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessages_IsCardNumberIsOneDigit() {
        String cardNumber = "1";
        List<String> expected = new ArrayList<>();
        expected.add("Card number's length should be 16 digits");
        expected.add("Control sum is invalid");
        expected.add("Payment system cant be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessages_IsCardNumberIsOneNonDigit() {
        String cardNumber = "a";
        List<String> expected = new ArrayList<>();
        expected.add("Card number should contain only digits");
        expected.add("Card number's length should be 16 digits");
        expected.add("Control sum is invalid");
        expected.add("Payment system cant be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessages_CardNumberIsDigitsAndNonDigits() {
        String cardNumber = "123qwerty456";
        List<String> expected = new ArrayList<>();
        expected.add("Card number should contain only digits");
        expected.add("Card number's length should be 16 digits");
        expected.add("Control sum is invalid");
        expected.add("Payment system cant be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessages_CardNumberIsDigitsWithValidLength() {
        String cardNumber = "1111111111111111";
        List<String> expected = new ArrayList<>();
        expected.add("Control sum is invalid");
        expected.add("Payment system cant be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessages_CardNumberIsDigitsWithValidControlSum() {
        String cardNumber = "0000000000";
        List<String> expected = new ArrayList<>();
        expected.add("Card number's length should be 16 digits");
        expected.add("Payment system cant be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessages_CardNumberIsDigitsWithInvalidPaymentSystem() {
        String cardNumber = "0000000000000000";
        List<String> expected = new ArrayList<>();
        expected.add("Payment system cant be determined");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_CardNumberIsFullyValid() {
        String cardNumber = "5500005555555559";
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

}