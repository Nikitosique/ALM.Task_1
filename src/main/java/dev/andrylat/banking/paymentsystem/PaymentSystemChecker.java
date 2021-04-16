package dev.andrylat.banking.paymentsystem;

public class PaymentSystemChecker {

    public String checkPaymentSystem(String cardNumber) {
        StringBuilder result = new StringBuilder();

        for (PaymentSystem system : PaymentSystem.values()) {
            if (cardNumber.matches(system.getRegex())) {
                result.append(system.getName());
                return result.toString();
            }
        }

        return PaymentSystem.UNKNOWN.getName();
    }

}
