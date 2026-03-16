package algorithms;

import java.util.Stack;

public class StackChecker implements PalindromeAlgorithm {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        String normalized = input.toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char current : normalized.toCharArray()) {
            stack.push(current);
        }

        for (int index = 0; index < normalized.length(); index++) {
            if (normalized.charAt(index) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getName() {
        return "Stack-Based Algorithm";
    }
}
