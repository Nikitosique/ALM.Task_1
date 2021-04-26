package dev.andrylat.banking.operations;

import dev.andrylat.banking.card.messageformatter.FailureMessageFormatter;
import dev.andrylat.banking.card.messageformatter.MessageFormatter;
import dev.andrylat.banking.card.messageformatter.PaymentSystemInfoFormatter;
import dev.andrylat.banking.card.paymentsystem.PaymentSystem;
import dev.andrylat.banking.card.paymentsystem.PaymentSystemResolver;
import dev.andrylat.banking.card.validation.CardValidator;
import dev.andrylat.banking.card.validation.CompositeCardValidator;

import java.util.List;
import java.util.Scanner;

public class CardValidation implements Operation {

    @Override
    public void startOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter card number:");
        String cardNumber = scanner.nextLine();
        System.out.println(getResult(cardNumber));
    }


    public String getResult(String cardNumber) {
        CardValidator validator = new CompositeCardValidator();
        List<String> failureMessages = validator.validate(cardNumber);

        if (failureMessages.isEmpty()) {
            PaymentSystemResolver resolver = new PaymentSystemResolver();
            PaymentSystem system = resolver.resolvePaymentSystem(cardNumber);

            String paymentSystemName = system.getName();
            MessageFormatter<String> formatter = new PaymentSystemInfoFormatter();
            return formatter.formatMessage(paymentSystemName);
        } else {
            MessageFormatter<List<String>> formatter = new FailureMessageFormatter();
            return formatter.formatMessage(failureMessages);
        }
    }

}
