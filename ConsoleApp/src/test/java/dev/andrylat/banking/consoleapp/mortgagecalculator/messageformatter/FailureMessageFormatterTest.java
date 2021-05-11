package dev.andrylat.banking.consoleapp.mortgagecalculator.messageformatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FailureMessageFormatterTest {

    FailureMessageFormatter formatter;

    @BeforeEach
    void createFormatter() {
        formatter = new FailureMessageFormatter();
    }

    @Test
    public void formatMessage_ReturnFormattedMessage_InputListContainsOneMessage() {
        List<String> inputMessages = new ArrayList<>();
        inputMessages.add("Loan Amount: you should enter only numbers");

        String expected = "Entered data is incorrect.\n" +
                "Errors:\n" + "-> " +
                "Loan Amount: you should enter only numbers\n";
        String actual = formatter.formatMessage(inputMessages);
        assertEquals(expected, actual);
    }

    @Test
    public void formatMessage_ReturnFormattedMessage_InputListContainsTwoMessages() {
        List<String> inputMessages = new ArrayList<>();
        inputMessages.add("Loan Amount: you should enter only numbers");
        inputMessages.add("Interest rate: you should enter only numbers");

        String expected = "Entered data is incorrect.\n" +
                "Errors:\n" +
                "-> Loan Amount: you should enter only numbers\n" +
                "-> Interest rate: you should enter only numbers\n";
        String actual = formatter.formatMessage(inputMessages);
        assertEquals(expected, actual);
    }

    @Test
    public void formatMessage_ReturnFormattedMessage_InputListContainsThreeMessages() {
        List<String> inputMessages = new ArrayList<>();
        inputMessages.add("Loan Amount: this value is less than the minimum (1 USD)");
        inputMessages.add("Interest rate: this value is out of range [0% - 100%]");
        inputMessages.add("Loan term: this value is out of range [1 year - 30 years]");

        String expected = "Entered data is incorrect.\n" +
                "Errors:\n" +
                "-> Loan Amount: this value is less than the minimum (1 USD)\n" +
                "-> Interest rate: this value is out of range [0% - 100%]\n" +
                "-> Loan term: this value is out of range [1 year - 30 years]\n";
        String actual = formatter.formatMessage(inputMessages);
        assertEquals(expected, actual);
    }

}