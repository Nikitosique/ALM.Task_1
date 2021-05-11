package dev.andrylat.banking.common.card.paymentsystem;

public enum PaymentSystem {

    VISA("VISA", "4[0-9]{15}"),
    MASTERCARD("Master Card", "5[1-5][0-9]{14}"),
    DINERS_CLUB("Diners Club", "3[68][0-9]{14}"),
    DISCOVER("Discover", "6(011[0-9]{12}|5[0-9]{14})"),
    JCB("JCB", "35[0-9]{14}"),
    AMERICAN_EXPRESS("American Express", "3[47][0-9]{14}"),
    UNKNOWN("Unknown", "");

    private final String regex;
    private final String name;

    PaymentSystem(String name, String regex) {
        this.name = name;
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public String getName() {
        return name;
    }

}
