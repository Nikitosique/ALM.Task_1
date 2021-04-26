package dev.andrylat.banking.card.messageformatter;

public class PaymentSystemInfoFormatter implements MessageFormatter<String> {

    @Override
    public String formatMessage(String message) {
        return "Card is valid. Payment system is \"" + message + "\".";
    }

}
