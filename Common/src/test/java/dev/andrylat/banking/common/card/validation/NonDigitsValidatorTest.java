package dev.andrylat.banking.common.card.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NonDigitsValidatorTest {

    NonDigitsValidator validator;

    @BeforeEach
    void createValidator() {
        validator = new NonDigitsValidator();
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsNull() {
        String cardNumber = null;
        List<String> expected = new ArrayList<>();
        expected.add("Card number should contain only digits");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsEmpty() {
        String cardNumber = "";
        List<String> expected = new ArrayList<>();
        expected.add("Card number should contain only digits");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsWhitespaces() {
        String cardNumber = "          ";
        List<String> expected = new ArrayList<>();
        expected.add("Card number should contain only digits");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_CardNumberIsOneDigit() {
        String cardNumber = "1";
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsOneNonDigit() {
        String cardNumber = "a";
        List<String> expected = new ArrayList<>();
        expected.add("Card number should contain only digits");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsDigitsAndNonDigits() {
        String cardNumber = "1234abc567def";
        List<String> expected = new ArrayList<>();
        expected.add("Card number should contain only digits");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_CardNumberIsDigits() {
        String cardNumber = "0000000000000000";
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

}