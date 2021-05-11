package dev.andrylat.banking.common.card.validation;

import java.util.List;

public interface CardValidator {
    List<String> validate(String cardNumber);
}