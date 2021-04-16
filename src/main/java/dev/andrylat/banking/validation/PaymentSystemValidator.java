package dev.andrylat.banking.validation;

import dev.andrylat.banking.paymentsystem.PaymentSystem;
import dev.andrylat.banking.paymentsystem.PaymentSystemChecker;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PaymentSystemValidator implements CardValidator {

    private static final String MESSAGE = "Payment system cant be determined";

    @Override
    public List<String> validate(String cardNumber) {
        List<String> failureMessage = new ArrayList<>();

        if (StringUtils.isBlank(cardNumber)) {
            failureMessage.add(MESSAGE);
            return failureMessage;
        }

        PaymentSystemChecker checker = new PaymentSystemChecker();
        String paymentSystem = checker.checkPaymentSystem(cardNumber);
        if (PaymentSystem.UNKNOWN.getName().equals(paymentSystem)) {
            failureMessage.add(MESSAGE);
            return failureMessage;
        }

        return failureMessage;
    }
}
