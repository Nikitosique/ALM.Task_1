package dev.andrylat.numbervalidator;

import dev.andrylat.numbervalidator.CardNumberChecker;
import dev.andrylat.numbervalidator.CardStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardNumberCheckerTest {

    @Test
    void CardNumberInvalidIfCardNumberContainsLetters() {
        String cardNumber = "1234abc5789tr";
        CardStatus cardNumberStatus = CardNumberChecker.checkCardNumber(cardNumber);
        assertEquals(CardStatus.INVALID_CARD_NUMBER, cardNumberStatus);
    }

    @Test
    void CardNumberValidIfCardNumberContainsOnlyNumbers() {
        String cardNumber = "12345789101112";
        CardStatus cardNumberStatus = CardNumberChecker.checkCardNumber(cardNumber);
        assertEquals(CardStatus.VALID_CARD_NUMBER, cardNumberStatus);
    }

    @Test
    void CardNumberInValidIfCardNumberIsEmpty() {
        String cardNumber = "";
        CardStatus cardNumberStatus = CardNumberChecker.checkCardNumber(cardNumber);
        assertEquals(CardStatus.INVALID_CARD_NUMBER, cardNumberStatus);
    }

    @Test
    void CardNumberInValidIfCardNumberIsNull() {
        String cardNumber = null;
        CardStatus cardNumberStatus = CardNumberChecker.checkCardNumber(cardNumber);
        assertEquals(CardStatus.INVALID_CARD_NUMBER, cardNumberStatus);
    }

    @Test
    void CardNumberInValidIfCardNumberContainsWhitespaces() {
        String cardNumber = "              ";
        CardStatus cardNumberStatus = CardNumberChecker.checkCardNumber(cardNumber);
        assertEquals(CardStatus.INVALID_CARD_NUMBER, cardNumberStatus);
    }

    @Test
    void CardNumberInValidIfCardNumberContainsDoubles() {
        String cardNumber = "1234567871.42";
        CardStatus cardNumberStatus = CardNumberChecker.checkCardNumber(cardNumber);
        assertEquals(CardStatus.INVALID_CARD_NUMBER, cardNumberStatus);
    }
}