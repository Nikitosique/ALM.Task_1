package dev.andrylat.main;

import dev.andrylat.printer.ResultPrinter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Enter card number for validation:");
        String cardNumber = scanner.nextLine();
        ResultPrinter printer = new ResultPrinter();
        printer.printResult(cardNumber);
    }
}

