package dev.andrylat.banking.consoleapp.mortgagecalculator.messageformatter;

import dev.andrylat.banking.common.mortgagecalculator.calculator.ResultData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanAmortizationInfoFormatterTest {

    LoanAmortizationInfoFormatter formatter;

    @BeforeEach
    void createFormatter() {
        formatter = new LoanAmortizationInfoFormatter();
    }

    @Test
    void formatMessage_ReturnFormattedMessage_InputIsCalculatedData() {
        List<ResultData> amortizationData = Arrays.asList(
                new ResultData(1, 5.0, 81.07, 918.93),
                new ResultData(2, 4.59, 81.48, 837.45),
                new ResultData(3, 4.19, 81.88, 755.57),
                new ResultData(4, 3.78, 82.29, 673.28),
                new ResultData(5, 3.37, 82.7, 590.58),
                new ResultData(6, 2.95, 83.12, 507.46),
                new ResultData(7, 2.54, 83.53, 423.93),
                new ResultData(8, 2.12, 83.95, 339.98),
                new ResultData(9, 1.7, 84.37, 255.61),
                new ResultData(10, 1.28, 84.79, 170.81),
                new ResultData(11, 0.85, 85.22, 85.6),
                new ResultData(12, 0.43, 85.64, 0.0)
        );

        String expected = "\nAmortization table\n" +
                "--------------------------------------------\n" +
                "Month       Interest    Principal   Balance    \n" +
                "1           5           81,07       918,93      \n" +
                "2           4,59        81,48       837,45      \n" +
                "3           4,19        81,88       755,57      \n" +
                "4           3,78        82,29       673,28      \n" +
                "5           3,37        82,7        590,58      \n" +
                "6           2,95        83,12       507,46      \n" +
                "7           2,54        83,53       423,93      \n" +
                "8           2,12        83,95       339,98      \n" +
                "9           1,7         84,37       255,61      \n" +
                "10          1,28        84,79       170,81      \n" +
                "11          0,85        85,22       85,6        \n" +
                "12          0,43        85,64       0           \n";

        String actual = formatter.formatMessage(amortizationData);
        assertEquals(expected, actual);
    }

}