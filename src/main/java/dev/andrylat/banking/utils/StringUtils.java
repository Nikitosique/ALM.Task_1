package dev.andrylat.banking.utils;

public final class StringUtils {

    private static final String COMMAS_REGEX = ",";
    private static final String REPLACEMENT_REGEX = ".";

    private StringUtils() {
        throw new IllegalStateException("Exception to prevent instantiation");
    }

    public static String replaceCommas(String input) {
        return input.replaceAll(COMMAS_REGEX, REPLACEMENT_REGEX);
    }

}
