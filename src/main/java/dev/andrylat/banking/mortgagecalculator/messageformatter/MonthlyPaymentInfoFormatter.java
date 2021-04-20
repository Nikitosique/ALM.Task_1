package dev.andrylat.banking.mortgagecalculator.messageformatter;

public class MonthlyPaymentInfoFormatter implements MessageFormatter<Double> {

    @Override
    public String formatMessage(Double value) {
        return String.format("\nMonthly payment value is %.2f USD\n", value);
    }

}
