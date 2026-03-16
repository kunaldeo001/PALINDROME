package util;
public class TextCleaner {
    public static String clean(String input) {
        return input == null ? "" : input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }
}
