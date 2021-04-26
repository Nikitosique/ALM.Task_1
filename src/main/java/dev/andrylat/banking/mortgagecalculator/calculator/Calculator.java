package dev.andrylat.banking.mortgagecalculator.calculator;

import dev.andrylat.banking.mortgagecalculator.validation.InputData;

public interface Calculator<T> {
    T calculate(InputData inputData);
}
