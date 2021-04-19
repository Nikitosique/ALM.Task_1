package dev.andrylat.banking.validation;

import java.util.List;

public interface CardValidator {
    List<String> validate(String cardNumber);
}