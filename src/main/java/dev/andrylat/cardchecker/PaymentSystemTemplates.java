package dev.andrylat.cardchecker;

public enum PaymentSystemTemplates {

    VISA("4[0-9]{15}", "VISA"),
    MASTERCARD("5[1-5][0-9]{14}", "Master Card"),
    DINERS_CLUB("3[68][0-9]{14}", "Diners Club"),
    DISCOVER("6(011[0-9]{12}|5[0-9]{14})", "Discover"),
    JCB("35[0-9]{14}", "JCB"),
    AMERICAN_EXPRESS("3[47][0-9]{14}", "American Express");

    private String paymentSystemTemplate;
    private String paymentSystemName;

    public String getPaymentSystemTemplate() {
        return paymentSystemTemplate;
    }

    public String getPaymentSystemName() {
        return paymentSystemName;
    }

    PaymentSystemTemplates(String paymentSystemTemplate, String paymentSystemName) {
        this.paymentSystemTemplate = paymentSystemTemplate;
        this.paymentSystemName = paymentSystemName;
    }

}
