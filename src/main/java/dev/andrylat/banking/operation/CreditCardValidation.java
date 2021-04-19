package dev.andrylat.banking.operation;

import dev.andrylat.banking.messageformatter.FailureMessageFormatter;
import dev.andrylat.banking.messageformatter.MessageFormatter;
import dev.andrylat.banking.messageformatter.PaymentSystemInfoFormatter;
import dev.andrylat.banking.paymentsystem.PaymentSystem;
import dev.andrylat.banking.paymentsystem.PaymentSystemRetriever;
import dev.andrylat.banking.validation.CardValidator;
import dev.andrylat.banking.validation.CompositeValidator;

import java.util.List;
import java.util.Scanner;

public class CreditCardValidation implements Operation {

    @Override
    public void perform() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please, enter card number:");
            String cardNumber = scanner.nextLine();
            System.out.println(returnResult(cardNumber));
        }
    }

    public String returnResult(String cardNumber) {
        CardValidator validator = new CompositeValidator();
        List<String> failureMessages = validator.validate(cardNumber);

        if (failureMessages.isEmpty()) {
            PaymentSystemRetriever retriever = new PaymentSystemRetriever();
            PaymentSystem system = retriever.retrievePaymentSystem(cardNumber);

            String paymentSystemName = system.getName();
            MessageFormatter<String> formatter = new PaymentSystemInfoFormatter();
            return formatter.formatMessage(paymentSystemName);
        } else {
            MessageFormatter<List<String>> formatter = new FailureMessageFormatter();
            return formatter.formatMessage(failureMessages);
        }
    }

}
