package dev.andrylat.banking.card.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthValidatorTest {

    LengthValidator validator;

    @BeforeEach
    void createValidator() {
        validator = new LengthValidator();
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsNull() {
        String cardNumber = null;
        List<String> expected = new ArrayList<>();
        expected.add("Card number's length should be 16 digits");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsEmpty() {
        String cardNumber = "";
        List<String> expected = new ArrayList<>();
        expected.add("Card number's length should be 16 digits");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsWhitespaces() {
        String cardNumber = "          ";
        List<String> expected = new ArrayList<>();
        expected.add("Card number's length should be 16 digits");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsOneDigit() {
        String cardNumber = "1";
        List<String> expected = new ArrayList<>();
        expected.add("Card number's length should be 16 digits");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsOneNonDigit() {
        String cardNumber = "a";
        List<String> expected = new ArrayList<>();
        expected.add("Card number's length should be 16 digits");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_CardNumberIsDigitsAndNonDigits() {
        String cardNumber = "1234abc567def";
        List<String> expected = new ArrayList<>();
        expected.add("Card number's length should be 16 digits");
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_CardNumberHasCorrectLength() {
        String cardNumber = "1234567890987654";
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(cardNumber);
        assertEquals(expected, actual);
    }

}