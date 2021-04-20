package dev.andrylat.banking.mortgagecalculator.utilityclasses;

public final class CommasReplacer {

    private static final String COMMAS_REGEX = ",";
    private static final String REPLACEMENT_REGEX = ".";

    private CommasReplacer() {
        throw new IllegalStateException("Exception to prevent instantiation");
    }

    public static String replace(String input) {
        return input.replaceAll(COMMAS_REGEX, REPLACEMENT_REGEX);
    }

}
