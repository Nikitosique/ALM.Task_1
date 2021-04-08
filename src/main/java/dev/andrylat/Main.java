package dev.andrylat;

import dev.andrylat.resultprinter.ResultPrinter;

import java.util.Scanner;

public class Main {
    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter card number:");
        String cardNumber = scanner.nextLine();
        ResultPrinter.printResult(cardNumber);
    }
}

