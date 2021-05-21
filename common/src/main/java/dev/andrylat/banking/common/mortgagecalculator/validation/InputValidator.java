package dev.andrylat.banking.common.mortgagecalculator.validation;

import java.util.List;

public interface InputValidator {
    List<String> validate(InputData data);
}
