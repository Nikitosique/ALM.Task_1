package dev.andrylat.banking.messageformatter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentSystemInfoFormatterTest {

    @Test
    public void formatMessage_ReturnFormattedMessage_InputMessageIsVISA() {
        PaymentSystemInfoFormatter formatter = new PaymentSystemInfoFormatter();
        String expected = "Card is valid. Payment system is \"" + "VISA" + "\".";
        String actual = formatter.formatMessage("VISA");
        assertEquals(expected, actual);
    }

}