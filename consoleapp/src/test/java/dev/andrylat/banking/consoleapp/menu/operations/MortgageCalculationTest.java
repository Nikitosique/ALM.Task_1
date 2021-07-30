package dev.andrylat.banking.consoleapp.menu.operations;

import dev.andrylat.banking.common.mortgagecalculator.validation.InputData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MortgageCalculationTest {

    MortgageCalculation calculation;
    InputData inputData;

    @BeforeEach
    void createCalculation() {
        calculation = new MortgageCalculation();
        inputData = new InputData();
    }

    @Test
    void getResult_returnErrorMessages_AllParametersAreNull() {
        inputData.setLoanAmount(null);
        inputData.setInterestRate(null);
        inputData.setTermYears(null);

        String expected = "Entered data is incorrect.\n" +
                "Errors:\n" +
                "-> Loan Amount: you should enter only numbers\n" +
                "-> Interest rate: you should enter only numbers\n" +
                "-> Loan term: you should enter only integers\n";

        String actual = calculation.getResult(inputData);
        assertEquals(expected, actual);
    }

    @Test
    void getResult_returnErrorMessages_AllParametersAreEmpty() {
        inputData.setLoanAmount("");
        inputData.setInterestRate("");
        inputData.setTermYears("");

        String expected = "Entered data is incorrect.\n" +
                "Errors:\n" +
                "-> Loan Amount: you should enter only numbers\n" +
                "-> Interest rate: you should enter only numbers\n" +
                "-> Loan term: you should enter only integers\n";

        String actual = calculation.getResult(inputData);
        assertEquals(expected, actual);
    }

    @Test
    void getResult_returnErrorMessages_AllParametersAreWhitespaces() {
        inputData.setLoanAmount("            ");
        inputData.setInterestRate("           ");
        inputData.setTermYears("           ");

        String expected = "Entered data is incorrect.\n" +
                "Errors:\n" +
                "-> Loan Amount: you should enter only numbers\n" +
                "-> Interest rate: you should enter only numbers\n" +
                "-> Loan term: you should enter only integers\n";

        String actual = calculation.getResult(inputData);
        assertEquals(expected, actual);
    }

    @Test
    void getResult_returnCalculatedData_AllParametersAreOneDigit() {
        inputData.setLoanAmount("9");
        inputData.setInterestRate("9");
        inputData.setTermYears("1");

        String expected = "\nMonthly payment value is 0,79 USD\n\n" +
                "Amortization table\n" +
                "--------------------------------------------\n" +
                "Month       Interest    Principal   Balance    \n" +
                "1           0,07        0,72        8,28        \n" +
                "2           0,06        0,73        7,55        \n" +
                "3           0,06        0,73        6,82        \n" +
                "4           0,05        0,74        6,08        \n" +
                "5           0,05        0,74        5,33        \n" +
                "6           0,04        0,75        4,58        \n" +
                "7           0,03        0,76        3,83        \n" +
                "8           0,03        0,76        3,07        \n" +
                "9           0,02        0,77        2,3         \n" +
                "10          0,02        0,77        1,53        \n" +
                "11          0,01        0,78        0,75        \n" +
                "12          0,01        0,78        0           \n";

        String actual = calculation.getResult(inputData);
        assertEquals(expected, actual);
    }

    @Test
    void getResult_returnErrorMessages_AllParametersAreOneNonDigit() {
        inputData.setLoanAmount("a");
        inputData.setInterestRate("a");
        inputData.setTermYears("a");

        String expected = "Entered data is incorrect.\n" +
                "Errors:\n" +
                "-> Loan Amount: you should enter only numbers\n" +
                "-> Interest rate: you should enter only numbers\n" +
                "-> Loan term: you should enter only integers\n";

        String actual = calculation.getResult(inputData);
        assertEquals(expected, actual);
    }

    @Test
    void getResult_returnErrorMessages_AllParametersAreDigitsAndNonDigits() {
        inputData.setLoanAmount("123abc");
        inputData.setInterestRate("123abc");
        inputData.setTermYears("123abc");

        String expected = "Entered data is incorrect.\n" +
                "Errors:\n" +
                "-> Loan Amount: you should enter only numbers\n" +
                "-> Interest rate: you should enter only numbers\n" +
                "-> Loan term: you should enter only integers\n";

        String actual = calculation.getResult(inputData);
        assertEquals(expected, actual);
    }

    @Test
    void getResult_returnErrorMessages_AllParametersAreOutOfCorrectRange() {
        inputData.setLoanAmount("-1000");
        inputData.setInterestRate("-1000");
        inputData.setTermYears("-1000");

        String expected = "Entered data is incorrect.\n" +
                "Errors:\n" +
                "-> Loan Amount: this value is less than the minimum (1 USD)\n" +
                "-> Interest rate: this value is out of range [0% - 100%] (Lower bound excluded)\n" +
                "-> Loan term: this value is out of range [1 year - 30 years]\n";

        String actual = calculation.getResult(inputData);
        assertEquals(expected, actual);
    }

    @Test
    void getResult_returnCalculatedData_AllParametersAreCorrect() {
        inputData.setLoanAmount("100000");
        inputData.setInterestRate("10");
        inputData.setTermYears("1");

        String expected = "\nMonthly payment value is 8791,59 USD\n" + "\n" +
                "Amortization table\n" +
                "--------------------------------------------\n" +
                "Month       Interest    Principal   Balance    \n" +
                "1           833,33      7958,26     92041,74    \n" +
                "2           767,01      8024,58     84017,17    \n" +
                "3           700,14      8091,45     75925,72    \n" +
                "4           632,71      8158,88     67766,85    \n" +
                "5           564,72      8226,87     59539,98    \n" +
                "6           496,17      8295,42     51244,56    \n" +
                "7           427,04      8364,55     42880       \n" +
                "8           357,33      8434,26     34445,75    \n" +
                "9           287,05      8504,54     25941,2     \n" +
                "10          216,18      8575,41     17365,79    \n" +
                "11          144,71      8646,88     8718,92     \n" +
                "12          72,66       8718,93     0           \n";

        String actual = calculation.getResult(inputData);
        assertEquals(expected, actual);
    }

}