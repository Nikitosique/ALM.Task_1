package dev.andrylat.cardchecker;

import org.junit.platform.commons.util.StringUtils;

public class PaymentSystemChecker {

    public String checkPaymentSystem(String cardNumber) {
        NonDigitsChecker nonDigitsChecker = new NonDigitsChecker();
        LengthChecker lengthChecker = new LengthChecker();
        LuhnChecker luhnChecker = new LuhnChecker();
        StringBuilder totalResult = new StringBuilder();
        totalResult.append("Card number is invalid.\n");
        totalResult.append("Errors:\n");

        if (StringUtils.isBlank(cardNumber)) {
            totalResult.append("-> Card number is blank\n");
            totalResult.append("-> Payment System can't be determined");
            return totalResult.toString();
        }

        for (PaymentSystemTemplates template : PaymentSystemTemplates.values()) {
            if (cardNumber.matches(template.getPaymentSystemTemplate()) && luhnChecker.check(cardNumber)) {
                totalResult.setLength(0);
                totalResult.append("Card is valid. Payment system is ");
                totalResult.append(template.getPaymentSystemName());
                return totalResult.toString();
            }
        }

        if (!nonDigitsChecker.check(cardNumber)) {
            totalResult.append("-> Card number should contain only digits\n");
        }

        if (!lengthChecker.check(cardNumber)) {
            totalResult.append("-> Card number's length should be 16 digits\n");
        }

        totalResult.append("-> Payment System can't be determined");
        return totalResult.toString();
    }

}
