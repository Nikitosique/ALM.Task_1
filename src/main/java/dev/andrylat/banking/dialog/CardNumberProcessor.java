package dev.andrylat.banking.dialog;

import dev.andrylat.banking.messageformatter.FailureMessageFormatter;
import dev.andrylat.banking.messageformatter.MessageFormatter;
import dev.andrylat.banking.messageformatter.PaymentSystemInfoFormatter;
import dev.andrylat.banking.paymentsystem.PaymentSystemChecker;
import dev.andrylat.banking.validation.CardValidator;
import dev.andrylat.banking.validation.CompositeValidator;

import java.util.List;
import java.util.Scanner;

public class CardNumberProcessor implements Dialog {

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter card number:");
        String cardNumber = scanner.nextLine();
        System.out.println(returnResult(cardNumber));
    }

    public String returnResult(String cardNumber) {
        CardValidator validator = new CompositeValidator();

        List<String> failureMessages = validator.validate(cardNumber);
        if (failureMessages.isEmpty()) {
            PaymentSystemChecker checker = new PaymentSystemChecker();
            String paymentSystem = checker.checkPaymentSystem(cardNumber);
            MessageFormatter<String> formatter = new PaymentSystemInfoFormatter();
            return formatter.formatMessage(paymentSystem);
        } else {
            MessageFormatter<List<String>> formatter = new FailureMessageFormatter();
            return formatter.formatMessage(failureMessages);
        }
    }

}
