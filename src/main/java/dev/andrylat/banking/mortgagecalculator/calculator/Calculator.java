package dev.andrylat.banking.mortgagecalculator.calculator;

import dev.andrylat.banking.mortgagecalculator.validation.InputDataStorage;

public interface Calculator<T> {
    T calculate(InputDataStorage storage);
}
