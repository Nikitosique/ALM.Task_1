package dev.andrylat.banking.mortgagecalculator.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompositeInputValidatorTest {

    CompositeInputValidator validator;
    InputDataStorage inputData;

    @BeforeEach
    void createValidator() {
        validator = new CompositeInputValidator();
        inputData = new InputDataStorage();
    }

    @Test
    public void validate_ReturnListWithFailureMessages_AllParametersAreNull() {
        inputData.setLoanAmount(null);
        inputData.setInterestRate(null);
        inputData.setTermYears(null);

        List<String> expected = new ArrayList<>();
        expected.add("Loan Amount: you should enter only numbers");
        expected.add("Interest rate: you should enter only numbers");
        expected.add("Loan term: you should enter only integers");

        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessages_AllParametersAreEmpty() {
        inputData.setLoanAmount("");
        inputData.setInterestRate("");
        inputData.setTermYears("");

        List<String> expected = new ArrayList<>();
        expected.add("Loan Amount: you should enter only numbers");
        expected.add("Interest rate: you should enter only numbers");
        expected.add("Loan term: you should enter only integers");

        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessages_AllParametersAreWhitespaces() {
        inputData.setLoanAmount("          ");
        inputData.setInterestRate("          ");
        inputData.setTermYears("           ");

        List<String> expected = new ArrayList<>();
        expected.add("Loan Amount: you should enter only numbers");
        expected.add("Interest rate: you should enter only numbers");
        expected.add("Loan term: you should enter only integers");

        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnEmptyList_AllParametersAreOneDigit() {
        inputData.setLoanAmount("1");
        inputData.setInterestRate("2");
        inputData.setTermYears("3");

        List<String> expected = new ArrayList<>();

        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessages_AllParametersAreOneNonDigit() {
        inputData.setLoanAmount("a");
        inputData.setInterestRate("b");
        inputData.setTermYears("b");

        List<String> expected = new ArrayList<>();

        expected.add("Loan Amount: you should enter only numbers");
        expected.add("Interest rate: you should enter only numbers");
        expected.add("Loan term: you should enter only integers");

        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessages_AllParametersAreDigitsAndNonDigits() {
        inputData.setLoanAmount("123abc");
        inputData.setInterestRate("123abc");
        inputData.setTermYears("123abc");

        List<String> expected = new ArrayList<>();
        expected.add("Loan Amount: you should enter only numbers");
        expected.add("Interest rate: you should enter only numbers");
        expected.add("Loan term: you should enter only integers");

        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessages_AllParametersAreOutOfCorrectRange() {
        inputData.setLoanAmount("-1");
        inputData.setInterestRate("-1");
        inputData.setTermYears("-1");

        List<String> expected = new ArrayList<>();
        expected.add("Loan Amount: this value is less than the minimum (1 USD)");
        expected.add("Interest rate: this value is out of range [0% - 100%]");
        expected.add("Loan term: this value is out of range [1 year - 30 years]");

        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

    @Test
    public void validate_ReturnListWithFailureMessages_OneParameterIsIncorrectAndOneParameterIsOutOfCorrectRange() {
        inputData.setLoanAmount("100000");
        inputData.setInterestRate("-1");
        inputData.setTermYears("b");

        List<String> expected = new ArrayList<>();
        expected.add("Interest rate: this value is out of range [0% - 100%]");
        expected.add("Loan term: you should enter only integers");

        List<String> actual = validator.validate(inputData);
        assertEquals(expected, actual);
    }

}