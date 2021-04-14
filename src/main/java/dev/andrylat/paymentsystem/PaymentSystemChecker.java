package dev.andrylat.paymentsystem;

public class PaymentSystemChecker {

    private static final String UNKNOWN_PAYMENT_SYSTEM = "Card number is invalid.\n" + "Errors:\n"
            + "-> Payment System can't be determined";

    public String checkPaymentSystem(String cardNumber) {
        StringBuilder result = new StringBuilder();
        for (PaymentSystem system : PaymentSystem.values()) {
            if (cardNumber.matches(system.getRegex())) {
                result.append("Card is valid. Payment system is ");
                result.append(system.getName());
                return result.toString();
            }
        }

        return UNKNOWN_PAYMENT_SYSTEM;
    }
}
