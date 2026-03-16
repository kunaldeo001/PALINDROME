package algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueStackChecker implements PalindromeAlgorithm {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        String normalized = input.toLowerCase();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char current : normalized.toCharArray()) {
            queue.offer(current);
            stack.push(current);
        }

        while (!queue.isEmpty()) {
            if (!queue.poll().equals(stack.pop())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getName() {
        return "Queue + Stack Algorithm";
    }
}
