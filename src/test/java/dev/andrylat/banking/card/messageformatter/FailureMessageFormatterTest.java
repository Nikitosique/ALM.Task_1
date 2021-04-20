package dev.andrylat.banking.card.messageformatter;

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
        inputMessages.add("Control sum is invalid");
        String expected = "Card number is invalid.\n" +
                "Errors:\n" + "-> " +
                "Control sum is invalid\n";
        String actual = formatter.formatMessage(inputMessages);
        assertEquals(expected, actual);
    }

    @Test
    public void formatMessage_ReturnFormattedMessage_InputListContainsTwoMessages() {
        List<String> inputMessages = new ArrayList<>();
        inputMessages.add("Control sum is invalid");
        inputMessages.add("Card number's length should be 16 digits");
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Control sum is invalid\n" +
                "-> Card number's length should be 16 digits\n";
        String actual = formatter.formatMessage(inputMessages);
        assertEquals(expected, actual);
    }

    @Test
    public void formatMessage_ReturnFormattedMessage_InputListContainsFourMessages() {
        List<String> inputMessages = new ArrayList<>();
        inputMessages.add("Control sum is invalid");
        inputMessages.add("Card number's length should be 16 digits");
        inputMessages.add("Card number should contain only digits");
        inputMessages.add("Payment system cant be determined");
        String expected = "Card number is invalid.\n" +
                "Errors:\n" +
                "-> Control sum is invalid\n" +
                "-> Card number's length should be 16 digits\n" +
                "-> Card number should contain only digits\n" +
                "-> Payment system cant be determined\n";
        String actual = formatter.formatMessage(inputMessages);
        assertEquals(expected, actual);
    }

}