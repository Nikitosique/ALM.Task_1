package dev.andrylat.bankidentifier;

import dev.andrylat.bankidentifier.BankChecker;
import dev.andrylat.bankidentifier.BankType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankCheckerTest {

    @Test
    void BankIsUnknown() {
        String cardNumber = "1111623898234113";
        BankType bankType = BankChecker.checkBankType(cardNumber);
        assertEquals(BankType.UNKNOWN, bankType);
    }

    @Test
    void BankIsVisa() {
        String cardNumber = "4144623898234113";
        BankType bankType = BankChecker.checkBankType(cardNumber);
        assertEquals(BankType.VISA, bankType);
    }

    @Test
    void BankIsMasterCard() {
        String cardNumber = "5544623898234113";
        BankType bankType = BankChecker.checkBankType(cardNumber);
        assertEquals(BankType.MASTERCARD, bankType);
    }

    @Test
    void BankIsDinersClub() {
        String cardNumber = "3644623898234283";
        BankType bankType = BankChecker.checkBankType(cardNumber);
        assertEquals(BankType.DINERS_CLUB, bankType);
    }

    @Test
    void BankIsAmericanExpress() {
        String cardNumber = "3444623898234283";
        BankType bankType = BankChecker.checkBankType(cardNumber);
        assertEquals(BankType.AMERICAN_EXPRESS, bankType);
    }

    @Test
    void BankIsJbc() {
        String cardNumber = "3544623898234283";
        BankType bankType = BankChecker.checkBankType(cardNumber);
        assertEquals(BankType.JCB, bankType);
    }

    @Test
    void BankIsDiscover() {
        String cardNumber = "6011623898234283";
        BankType bankType = BankChecker.checkBankType(cardNumber);
        assertEquals(BankType.DISCOVER, bankType);
    }

}