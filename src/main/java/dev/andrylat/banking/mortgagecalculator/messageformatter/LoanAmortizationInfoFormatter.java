package dev.andrylat.banking.mortgagecalculator.messageformatter;

import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.List;

public class LoanAmortizationInfoFormatter implements MessageFormatter<List<Double>> {

    private static final int COLUMNS_NUMBER = 4;

    @Override
    public String formatMessage(List<Double> dataList) {
        StringBuilder result = new StringBuilder();
        Formatter header = new Formatter();

        result.append("\nAmortization table\n");
        result.append("--------------------------------------------\n");
        header.format("%-11s %-11s %-11s %-11s\n", "Month", "Interest", "Principal", "Balance");
        result.append(header);

        int columnsCounter = 0;
        DecimalFormat dataFormat = new DecimalFormat("0.##");

        for (Double data : dataList) {
            Formatter line = new Formatter();
            line.format("%-11s ", dataFormat.format(data));
            result.append(line);

            ++columnsCounter;

            if (columnsCounter == COLUMNS_NUMBER) {
                result.append("\n");
                columnsCounter = 0;
            }
        }

        return result.toString();
    }

}
