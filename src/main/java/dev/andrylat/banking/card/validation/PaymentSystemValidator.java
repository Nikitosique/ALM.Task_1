package dev.andrylat.banking.card.validation;

import dev.andrylat.banking.card.paymentsystem.PaymentSystem;
import dev.andrylat.banking.card.paymentsystem.PaymentSystemRetriever;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PaymentSystemValidator implements CardValidator {

    private static final String MESSAGE = "Payment system cant be determined";

    @Override
    public List<String> validate(String cardNumber) {
        List<String> failureMessages = new ArrayList<>();

        if (StringUtils.isBlank(cardNumber)) {
            failureMessages.add(MESSAGE);
            return failureMessages;
        }

        PaymentSystemRetriever retriever = new PaymentSystemRetriever();
        PaymentSystem system = retriever.retrievePaymentSystem(cardNumber);
        if (PaymentSystem.UNKNOWN.equals(system)) {
            failureMessages.add(MESSAGE);
            return failureMessages;
        }

        return failureMessages;
    }
}
