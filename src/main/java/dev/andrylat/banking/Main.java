package dev.andrylat.banking;


import dev.andrylat.banking.operation.CreditCardValidation;
import dev.andrylat.banking.operation.Operation;

public class Main {

    public static void main(String[] args) {
        Operation creditCardValidation = new CreditCardValidation();
        creditCardValidation.perform();
    }

}

