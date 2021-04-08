package dev.andrylat.numbervalidator;

import dev.andrylat.numbervalidator.CardStatus;
import dev.andrylat.numbervalidator.ControlSumChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControlSumCheckerTest {

    @Test
    void ControlSumIsValid() {
        String cardNumber = "5457623898234113";
        CardStatus controlSumStatus = ControlSumChecker.checkControlSum(cardNumber);
        assertEquals(CardStatus.VALID_CONTROL_SUM, controlSumStatus);
    }

    @Test
    void ControlSumIsInvalid() {
        String cardNumber = "11076dd248aaaa82QQQQ";
        CardStatus controlSumStatus = ControlSumChecker.checkControlSum(cardNumber);
        assertEquals(CardStatus.INVALID_CONTROL_SUM, controlSumStatus);
    }

}