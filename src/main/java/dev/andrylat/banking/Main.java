package dev.andrylat.banking;


import dev.andrylat.banking.dialog.CardNumberProcessor;
import dev.andrylat.banking.dialog.Dialog;

public class Main {

    public static void main(String[] args) {
        Dialog start = new CardNumberProcessor();
        start.perform();
    }

}

