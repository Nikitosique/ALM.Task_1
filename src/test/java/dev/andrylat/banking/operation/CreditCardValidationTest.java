package dev.andrylat.banking.operation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditCardValidationTest {

    CreditCardValidation processor;

    @BeforeEach
    void createProcessor() {
        processor = new CreditCardValidation();
    }

    @Test
    public void returnResult_returnErrorMessages_CardNumberIsNull() {
        String cardNumber = null;
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment system cant be determined\n";
        String actual = processor.returnResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void returnResult_returnErrorMessages_CardNumberIsEmptyLine() {
        String cardNumber = "";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment system cant be determined\n";
        String actual = processor.returnResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void returnResult_returnErrorMessages_CardNumberIsWhitespaces() {
        String cardNumber = "               ";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment system cant be determined\n";
        String actual = processor.returnResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void returnResult_returnErrorMessages_CardNumberIsOneDigit() {
        String cardNumber = "1";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment system cant be determined\n";
        String actual = processor.returnResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void returnResult_returnErrorMessages_CardNumberIsOneNonDigit() {
        String cardNumber = "a";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment system cant be determined\n";
        String actual = processor.returnResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void returnResult_returnErrorMessages_CardNumberIsDigitsAndNonDigits() {
        String cardNumber = "123abc456def3";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number should contain only digits\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment system cant be determined\n";
        String actual = processor.returnResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void returnResult_returnErrorMessages_CardNumberIsDigitsWithValidLength() {
        String cardNumber = "1234567890";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Control sum is invalid\n" +
                "-> Payment system cant be determined\n";
        String actual = processor.returnResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void returnResult_returnErrorMessages_CardNumberIsDigitsWithValidControlSum() {
        String cardNumber = "1234567890987654";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Control sum is invalid\n" +
                "-> Payment system cant be determined\n";
        String actual = processor.returnResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void returnResult_returnErrorMessages_CardNumberIsDigitsWithInvalidPaymentSystem() {
        String cardNumber = "0000000000000000";
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Payment system cant be determined\n";
        String actual = processor.returnResult(cardNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void returnResult_returnPaymentSystemInfo_CardNumberIsFullValid() {
        String cardNumber = "5500005555555559";
        String expected = "Card is valid. Payment system is \"" + "Master Card" + "\".";
        String actual = processor.returnResult(cardNumber);
        assertEquals(expected, actual);
    }

}