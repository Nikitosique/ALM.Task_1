package dev.andrylat.banking.consoleapp.mortgagecalculator.messageformatter;


import dev.andrylat.banking.common.mortgagecalculator.calculator.ResultData;

import java.text.DecimalFormat;
import java.util.List;

public class LoanAmortizationInfoFormatter implements MessageFormatter<List<ResultData>> {

    @Override
    public String formatMessage(List<ResultData> resultData) {
        StringBuilder result = new StringBuilder();

        result.append("\nAmortization table\n");
        result.append("--------------------------------------------\n");
        result.append(String.format("%-11s %-11s %-11s %-11s\n", "Month", "Interest", "Principal", "Balance"));

        for (ResultData data : resultData) {
            result.append(formatCell(data.getMonth()));
            result.append(formatCell(data.getInterest()));
            result.append(formatCell(data.getPrincipal()));
            result.append(formatCell(data.getBalance()));
            result.append("\n");
        }

        return result.toString();
    }

    private String formatCell(Number dataCell) {
        DecimalFormat dataFormat = new DecimalFormat("0.##");
        return String.format("%-11s ", dataFormat.format(dataCell));
    }

}
