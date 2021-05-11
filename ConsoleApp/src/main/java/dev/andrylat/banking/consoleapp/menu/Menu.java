package dev.andrylat.banking.consoleapp.menu;


import dev.andrylat.banking.consoleapp.menu.operations.CardValidation;
import dev.andrylat.banking.consoleapp.menu.operations.MortgageCalculation;
import dev.andrylat.banking.consoleapp.menu.operations.Operation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private static final Map<Integer, Operation> menu = createMap();

    public void chooseOperation() {
        boolean isContinue;

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                isContinue = false;

                try {
                    printMenu();
                    int choice = Integer.parseInt(scanner.nextLine());

                    Operation operation = menu.get(choice);
                    operation.start();

                    System.out.println("Do you want to continue? (Y/N)");
                    String decision = scanner.nextLine().toUpperCase().trim();
                    if ("Y".equals(decision)) {
                        isContinue = true;
                    }
                } catch (NullPointerException | NumberFormatException exception) {
                    System.out.println("Invalid option, try again!\n");
                    isContinue = true;
                }
            } while (isContinue);

            System.out.println("Goodbye!");
        }
    }

    private void printMenu() {
        System.out.println("Please, choose option:");
        System.out.println("1. Credit card validation");
        System.out.println("2. Mortgage monthly payment calculation\n");
    }

    private static Map<Integer, Operation> createMap() {
        Map<Integer, Operation> menu = new HashMap<>();
        menu.put(1, new CardValidation());
        menu.put(2, new MortgageCalculation());
        return menu;
    }
}


