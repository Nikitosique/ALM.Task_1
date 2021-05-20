package dev.andrylat.banking.consoleapp;

import dev.andrylat.banking.consoleapp.menu.Menu;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.FRANCE);

        Menu menu = new Menu();
        menu.chooseOperation();
    }

}
