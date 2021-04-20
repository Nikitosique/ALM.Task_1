package dev.andrylat.banking.operationselector;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {

    static private final Map<Integer, Operation> menu = Map.of(
            1, new CardValidation(),
            2, new MortgageCalculation()
    );

    public void printMenu() {
        System.out.println("Please, choose option:");
        System.out.println("1. Credit card validation");
        System.out.println("2. Mortgage monthly payment calculation\n");
    }

    public void chooseOperation() {
        while (true) {
            try {
                printMenu();

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                Operation operation = menu.getOrDefault(choice, null);
                operation.startOperation();

                scanner.close();
                break;
            } catch (NullPointerException | NoSuchElementException exception) {
                System.out.println("Invalid option, try again!\n");
            }
        }
    }

}


