package dev.andrylat.resultprinter;

import dev.andrylat.bankidentifier.BankChecker;
import dev.andrylat.bankidentifier.BankType;
import dev.andrylat.numbervalidator.*;

public class ResultPrinter {

    public static void printResult(String cardNumber) {
        StringBuilder result = new StringBuilder();
        CardStatus numberIsEmpty = CardNumberIsEmpty.checkForEmptiness(cardNumber);
        if (CardStatus.CARD_IS_EMPTY.equals(numberIsEmpty)) {
            System.out.println("Card number is empty, can't define bank type!");
        } else {

            if (!printCardNumberInfo(cardNumber).isEmpty()) {
                result.append(printCardNumberInfo(cardNumber));
            }

            if (!printNumberLengthInfo(cardNumber).isEmpty()) {
                result.append(printNumberLengthInfo(cardNumber));
            }

            if (!printControlSumInfo(cardNumber).isEmpty()) {
                result.append(printControlSumInfo(cardNumber));
            }

            if (result.isEmpty()) {
                BankType bankType = BankChecker.checkBankType(cardNumber);
                if (BankType.UNKNOWN.equals(bankType)) {
                    result.append("Card number is invalid, bank type is unknown");
                } else {
                    result.append(printBankName(bankType));
                }
            } else result.append("Card number is invalid, bank type is unknown");
        }
        System.out.println(result.toString());
    }

    public static String printCardNumberInfo(String cardNumber) {
        CardStatus numberChecker = CardNumberChecker.checkCardNumber(cardNumber);
        if (CardStatus.INVALID_CARD_NUMBER.equals(numberChecker)) {
            return "Card number should contain only digits\n";
        }
        return "";
    }

    public static String printNumberLengthInfo(String cardNumber) {
        CardStatus numberLength = LengthChecker.checkLength(cardNumber);
        if (CardStatus.INVALID_LENGTH.equals(numberLength)) {
            return "Card number length should be exactly 16 digits\n";
        }
        return "";
    }

    public static String printControlSumInfo(String cardNumber) {
        CardStatus numberControlSum = ControlSumChecker.checkControlSum(cardNumber);
        if (CardStatus.INVALID_CONTROL_SUM.equals(numberControlSum)) {
            return "Card number has invalid control sum\n";
        }
        return "";
    }

    public static String printBankName(BankType bankType) {
        StringBuilder bankName = new StringBuilder();
        bankName.append("Card is valid, your bank is ");

        if (BankType.VISA.equals(bankType)) {
            bankName.append("\"VISA\".");
        } else if (BankType.MASTERCARD.equals(bankType)) {
            bankName.append("\"MASTERCARD\".");
        } else if (BankType.DINERS_CLUB.equals(bankType)) {
            bankName.append("\"Diners Club\".");
        } else if (BankType.DISCOVER.equals(bankType)) {
            bankName.append("\"Discover\".");
        } else if (BankType.JCB.equals(bankType)) {
            bankName.append("\"JBC\".");
        } else {
            bankName.append("\"American Express\".");
        }
        return bankName.toString();
    }


}
