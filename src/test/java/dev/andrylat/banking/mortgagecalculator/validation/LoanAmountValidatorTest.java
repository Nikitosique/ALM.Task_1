package dev.andrylat.banking.mortgagecalculator.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanAmountValidatorTest {

    LoanAmountValidator validator;
    InputData inputData;

    @BeforeEach
    void createValidator() {
        validator = new LoanAmountValidator();
        inputData = new InputData();
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsNull() {
        inputData.setLoanAmount(null);
        List<String> expected = new ArrayList<>();
        expected.add("Loan Amount: you should enter only numbers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsEmpty() {
        inputData.setLoanAmount("");
        List<String> expected = new ArrayList<>();
        expected.add("Loan Amount: you should enter only numbers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsWhitespaces() {
        inputData.setLoanAmount("         ");
        List<String> expected = new ArrayList<>();
        expected.add("Loan Amount: you should enter only numbers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_InputIsOneDigit() {
        inputData.setLoanAmount("3");
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsOneNonDigit() {
        inputData.setLoanAmount("a");
        List<String> expected = new ArrayList<>();
        expected.add("Loan Amount: you should enter only numbers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsDigitsAndNonDigits() {
        inputData.setLoanAmount("123345abc90");
        List<String> expected = new ArrayList<>();
        expected.add("Loan Amount: you should enter only numbers");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_InputIsNonIntegerWithIntegerAndFractionalParts() {
        inputData.setLoanAmount("10000.5");
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsNonIntegerWithFractionalPartOnly() {
        inputData.setLoanAmount(".10");
        List<String> expected = new ArrayList<>();
        expected.add("Loan Amount: this value is less than the minimum (1 USD)");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_InputIsNonIntegerWithIntegerPartOnly() {
        inputData.setLoanAmount("10.");
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_InputIsNumberInCorrectRange() {
        inputData.setLoanAmount("100000");
        List<String> expected = new ArrayList<>();
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessage_InputIsNumberOutOfCorrectRange() {
        inputData.setLoanAmount("-100000");
        List<String> expected = new ArrayList<>();
        expected.add("Loan Amount: this value is less than the minimum (1 USD)");
        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

}