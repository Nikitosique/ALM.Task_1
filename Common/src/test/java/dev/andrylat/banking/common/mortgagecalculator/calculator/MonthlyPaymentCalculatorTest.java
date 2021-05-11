package dev.andrylat.banking.common.mortgagecalculator.calculator;

import dev.andrylat.banking.common.mortgagecalculator.validation.InputData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonthlyPaymentCalculatorTest {

    MonthlyPaymentCalculator calculator;
    InputData inputData;

    @BeforeEach
    void createValidator() {
        calculator = new MonthlyPaymentCalculator();
        inputData = new InputData();
    }

    @Test
    public void calculate_CalculateMonthlyPaymentData_DataCalculatedCorrectly() {
        inputData.setLoanAmount("1000");
        inputData.setInterestRate("6");
        inputData.setTermYears("1");

        double expected = 86.07d;
        double actual = calculator.calculate(inputData);
        assertEquals(expected, actual);
    }

}