package dev.andrylat.banking.common.mortgagecalculator.calculator;


import dev.andrylat.banking.common.mortgagecalculator.validation.InputData;

public interface Calculator<T> {
    T calculate(InputData inputData);
}
