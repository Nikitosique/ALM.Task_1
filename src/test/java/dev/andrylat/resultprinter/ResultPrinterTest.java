package dev.andrylat.resultprinter;

import dev.andrylat.resultprinter.ResultPrinter;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultPrinterTest {

    @Test
    void PrintMastercardWhenCardIsValid() throws Exception {
        String result = tapSystemOut(() -> {
            ResultPrinter.printResult("5457623898234113");
        });
        assertEquals("Card is valid, your bank is \"MASTERCARD\".", result.trim());
    }

    @Test
    void PrintErrorWhenCardIsEmpty() throws Exception {
        String result = tapSystemOut(() -> {
            ResultPrinter.printResult("");
        });
        assertEquals("Card number is empty, can't define bank type!", result.trim());
    }

    @Test
    void PrintErrorWhenOnlyBankIsInvalid() throws Exception {
        String result = tapSystemOut(() -> {
            ResultPrinter.printResult("0000000000000000");
        });
        assertEquals("Card number is invalid, bank type is unknown", result.trim());
    }

    @Test
    void PrintErrorsWhenControlSumAndCardNumberAreInvalid() throws Exception {
        String result = tapSystemOut(() -> {
            ResultPrinter.printResult("000000000000aaaa");
        });
        String expected = "Card number should contain only digits\n" +
                "Card number has invalid control sum\n" +
                "Card number is invalid, bank type is unknown";
        assertEquals(expected, result.trim());
    }

    @Test
    void PrintErrorsWhenEverythingIsInvalid() throws Exception {
        String result = tapSystemOut(() -> {
            ResultPrinter.printResult("aaaa123QQQ");
        });
        String expected = "Card number should contain only digits\n" +
                "Card number length should be exactly 16 digits\n" +
                "Card number has invalid control sum\n" +
                "Card number is invalid, bank type is unknown";
        assertEquals(expected, result.trim());
    }

    @Test
    void PrintErrorsWhenCardNumberContainsOneDigit() throws Exception {
        String result = tapSystemOut(() -> {
            ResultPrinter.printResult("1");
        });
        String expected = "Card number length should be exactly 16 digits\n" +
                "Card number has invalid control sum\n" +
                "Card number is invalid, bank type is unknown";
        assertEquals(expected, result.trim());
    }
}