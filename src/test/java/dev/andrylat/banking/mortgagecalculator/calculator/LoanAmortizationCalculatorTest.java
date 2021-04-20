package dev.andrylat.banking.mortgagecalculator.calculator;

import dev.andrylat.banking.mortgagecalculator.validation.InputDataStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanAmortizationCalculatorTest {

    LoanAmortizationCalculator calculator;
    InputDataStorage inputData;

    @BeforeEach
    void createValidator() {
        calculator = new LoanAmortizationCalculator();
        inputData = new InputDataStorage();
    }

    @Test
    public void calculate_CalculateAmortizationData_DataCalculatedCorrectly() {
        inputData.setLoanAmount("1000");
        inputData.setInterestRate("6");
        inputData.setTermYears("1");

        List<Double> expected = new ArrayList<>(List.of(
                1.0, 5.0, 81.07, 918.93,
                2.0, 4.59, 81.48, 837.45,
                3.0, 4.19, 81.88, 755.57,
                4.0, 3.78, 82.29, 673.28,
                5.0, 3.37, 82.7, 590.58,
                6.0, 2.95, 83.12, 507.46,
                7.0, 2.54, 83.53, 423.93,
                8.0, 2.12, 83.95, 339.98,
                9.0, 1.7, 84.37, 255.61,
                10.0, 1.28, 84.79, 170.81,
                11.0, 0.85, 85.22, 85.6,
                12.0, 0.43, 85.64, 0.0));

        List<Double> actual = calculator.calculate(inputData);
        assertEquals(expected, actual);
    }

}