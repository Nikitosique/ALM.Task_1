package dev.andrylat.paymentsystem;

import dev.andrylat.validation.CardValidator;
import dev.andrylat.validation.LuhnValidator;
import org.junit.platform.commons.util.StringUtils;

public class PaymentSystemChecker {

    public static final String UNKNOWN = "Unknown payment system";

    public String checkPaymentSystem(String cardNumber) {
        if (StringUtils.isBlank(cardNumber)) {
            return UNKNOWN;
        }

        CardValidator luhnValidator = new LuhnValidator();
        StringBuilder result = new StringBuilder();
        for (PaymentSystem system : PaymentSystem.values()) {
            if (cardNumber.matches(system.getRegex()) && luhnValidator.validate(cardNumber).isEmpty()) {
                result.append("Card is valid. Payment system is ");
                result.append(system.getName());
                return result.toString();
            }
        }

        result.append(UNKNOWN);
        return result.toString();
    }
}
