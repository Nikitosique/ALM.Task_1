package dev.andrylat.banking.card.validation;

import dev.andrylat.banking.card.paymentsystem.PaymentSystem;
import dev.andrylat.banking.card.paymentsystem.PaymentSystemResolver;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PaymentSystemValidator implements CardValidator {

    private static final String MESSAGE = "Payment system can't be determined";

    @Override
    public List<String> validate(String cardNumber) {
        List<String> failureMessages = new ArrayList<>();

        if (StringUtils.isBlank(cardNumber)) {
            failureMessages.add(MESSAGE);
            return failureMessages;
        }

        PaymentSystemResolver resolver = new PaymentSystemResolver();
        PaymentSystem system = resolver.resolvePaymentSystem(cardNumber);
        if (PaymentSystem.UNKNOWN.equals(system)) {
            failureMessages.add(MESSAGE);
            return failureMessages;
        }

        return failureMessages;
    }

}
