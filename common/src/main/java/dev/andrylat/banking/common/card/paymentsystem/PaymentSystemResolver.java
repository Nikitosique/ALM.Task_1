package dev.andrylat.banking.common.card.paymentsystem;

public class PaymentSystemResolver {

    public PaymentSystem resolvePaymentSystem(String cardNumber) {
        for (PaymentSystem system : PaymentSystem.values()) {
            if (cardNumber.matches(system.getRegex())) {
                return system;
            }
        }

        return PaymentSystem.UNKNOWN;
    }

}
