package dev.andrylat.banking.mortgagecalculator.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterestRateValidatorTest {

    InterestRateValidator validator;
    InputDataStorage inputData;

    @BeforeEach
    void createValidator() {
        validator = new InterestRateValidator();
        inputData = new InputDataStorage();
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsNull() {
        inputData.setInterestRate(null);
        List<String> expected = new ArrayList<>();
        expected.add("Interest rate: you should enter only numbers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsEmpty() {
        inputData.setInterestRate("");
        List<String> expected = new ArrayList<>();
        expected.add("Interest rate: you should enter only numbers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsWhitespaces() {
        inputData.setInterestRate("         ");
        List<String> expected = new ArrayList<>();
        expected.add("Interest rate: you should enter only numbers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_InputIsOneDigit() {
        inputData.setInterestRate("1");
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsOneNonDigit() {
        inputData.setInterestRate("a");
        List<String> expected = new ArrayList<>();
        expected.add("Interest rate: you should enter only numbers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsDigitsAndNonDigits() {
        inputData.setInterestRate("123345abc90");
        List<String> expected = new ArrayList<>();
        expected.add("Interest rate: you should enter only numbers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_InputIsNonIntegerWithIntegerAndFractionalParts() {
        inputData.setInterestRate("1.00");
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_InputIsNonIntegerWithFractionalPartOnly() {
        inputData.setInterestRate(".10");
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_InputIsNonIntegerWithIntegerPartOnly() {
        inputData.setInterestRate("1.");
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_InputIsNumberInCorrectRange() {
        inputData.setInterestRate("10");
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsNumberOutOfCorrectRange() {
        inputData.setInterestRate("10000");
        List<String> expected = new ArrayList<>();
        expected.add("Interest rate: this value is out of range [0% - 100%]");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

}