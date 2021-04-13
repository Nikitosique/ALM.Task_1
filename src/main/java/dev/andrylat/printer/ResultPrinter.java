package dev.andrylat.printer;

import dev.andrylat.paymentsystem.PaymentSystemChecker;
import dev.andrylat.validation.ValidationErrorsHandler;

public class ResultPrinter {

    public static final String UNKNOWN = "Unknown payment system";

    public void printResult(String cardNumber) {
        PaymentSystemChecker checker = new PaymentSystemChecker();
        String result = checker.checkPaymentSystem(cardNumber);
        if (UNKNOWN.equals(result)) {
            ValidationErrorsHandler handler = new ValidationErrorsHandler();
            String errorMessage = handler.getErrorMessage(cardNumber);
            System.out.println(errorMessage);
        } else {
            System.out.println(result);
        }
    }
}
