package dev.andrylat.main;

import dev.andrylat.resultdefiner.ResultDefiner;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Enter card number for validation:");
        String cardNumber = scanner.nextLine();
        ResultDefiner definer = new ResultDefiner();
        System.out.println(definer.defineResult(cardNumber));
    }

}

