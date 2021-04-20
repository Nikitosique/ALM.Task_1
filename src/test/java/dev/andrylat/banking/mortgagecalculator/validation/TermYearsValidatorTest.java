package dev.andrylat.banking.mortgagecalculator.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TermYearsValidatorTest {

    TermYearsValidator validator;
    InputDataStorage inputData;

    @BeforeEach
    void createValidator() {
        validator = new TermYearsValidator();
        inputData = new InputDataStorage();
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsNull() {
        inputData.setTermYears(null);
        List<String> expected = new ArrayList<>();
        expected.add("Loan term: you should enter only integers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsEmpty() {
        inputData.setTermYears("");
        List<String> expected = new ArrayList<>();
        expected.add("Loan term: you should enter only integers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsWhitespaces() {
        inputData.setTermYears("         ");
        List<String> expected = new ArrayList<>();
        expected.add("Loan term: you should enter only integers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_InputIsOneDigit() {
        inputData.setTermYears("1");
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsOneNonDigit() {
        inputData.setTermYears("a");
        List<String> expected = new ArrayList<>();
        expected.add("Loan term: you should enter only integers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsDigitsAndNonDigits() {
        inputData.setTermYears("123345abc90");
        List<String> expected = new ArrayList<>();
        expected.add("Loan term: you should enter only integers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsNonInteger() {
        inputData.setTermYears("1.5");
        List<String> expected = new ArrayList<>();
        expected.add("Loan term: you should enter only integers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsNonIntegerWithFractionalPartOnly() {
        inputData.setTermYears(".10");
        List<String> expected = new ArrayList<>();
        expected.add("Loan term: you should enter only integers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsNonIntegerWithIntegerPartOnly() {
        inputData.setTermYears("10.");
        List<String> expected = new ArrayList<>();
        expected.add("Loan term: you should enter only integers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_InputIsNumberInCorrectRange() {
        inputData.setTermYears("30");
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsNumberOutOfCorrectRange() {
        inputData.setTermYears("100");
        List<String> expected = new ArrayList<>();
        expected.add("Loan term: this value is out of range [1 year - 30 years]");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

}