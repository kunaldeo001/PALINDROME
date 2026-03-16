package algorithms;

public class StringReverseChecker implements PalindromeAlgorithm {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    }

    @Override
    public String getName() {
        return "String Reverse Algorithm";
    }
}
