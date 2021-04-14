package dev.andrylat.resultdefiner;

import dev.andrylat.paymentsystem.PaymentSystemChecker;
import dev.andrylat.validation.CardValidator;
import dev.andrylat.validation.ValidationErrorsWrapper;
import dev.andrylat.validation.ValidatorsCollector;

import java.util.List;

public class ResultDefiner {

    public String defineResult(String cardNumber) {
        ValidatorsCollector collector = new ValidatorsCollector();
        List<CardValidator> validatorsList = collector.collectValidators();
        StringBuilder errors = new StringBuilder();
        for (CardValidator validator : validatorsList) {
            if (!validator.validate(cardNumber)) {
                errors.append(validator.getValidationError());
            }
        }

        String result;
        if (errors.length() == 0) {
            PaymentSystemChecker checker = new PaymentSystemChecker();
            result = checker.checkPaymentSystem(cardNumber);
        } else {
            ValidationErrorsWrapper wrapper = new ValidationErrorsWrapper();
            result = wrapper.createErrorMessage(errors.toString());
        }
        return result;
    }

}
