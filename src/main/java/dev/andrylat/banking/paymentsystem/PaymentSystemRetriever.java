package dev.andrylat.banking.paymentsystem;

public class PaymentSystemRetriever {

    public PaymentSystem retrievePaymentSystem(String cardNumber) {
        for (PaymentSystem system : PaymentSystem.values()) {
            if (cardNumber.matches(system.getRegex())) {
                return system;
            }
        }

        return PaymentSystem.UNKNOWN;
    }

}
