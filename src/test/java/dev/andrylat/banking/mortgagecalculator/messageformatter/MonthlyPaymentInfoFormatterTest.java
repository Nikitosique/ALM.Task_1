package dev.andrylat.banking.mortgagecalculator.messageformatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonthlyPaymentInfoFormatterTest {

    MonthlyPaymentInfoFormatter formatter;

    @BeforeEach
    void createFormatter() {
        formatter = new MonthlyPaymentInfoFormatter();
    }

    @Test
    void formatMessage_ReturnFormattedMessage_InputIsCalculatedData() {
        double input = 28.04d;
        String expected = "\nMonthly payment value is 28,04 USD\n";
        String actual = formatter.formatMessage(input);
        assertEquals(expected, actual);
    }

}