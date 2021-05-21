package dev.andrylat.banking.common.mortgagecalculator.calculator;

import dev.andrylat.banking.common.mortgagecalculator.validation.InputData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanAmortizationCalculatorTest {

    LoanAmortizationCalculator calculator;
    InputData inputData;

    @BeforeEach
    void createValidator() {
        calculator = new LoanAmortizationCalculator();
        inputData = new InputData();
    }

    @Test
    public void calculate_CalculateAmortizationData_DataCalculatedCorrectly() {
        inputData.setLoanAmount("1000");
        inputData.setInterestRate("6");
        inputData.setTermYears("1");

        List<ResultData> expected = Arrays.asList(
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

        List<ResultData> actual = calculator.calculate(inputData);

        assertEquals(expected, actual);
    }

}