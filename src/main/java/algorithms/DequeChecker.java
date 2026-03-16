package algorithms;
import java.util.ArrayDeque;
import java.util.Deque;
public class DequeChecker implements PalindromeAlgorithm {
    public boolean isPalindrome(String input) {
        if (input == null) return false;
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) deque.addLast(Character.toLowerCase(c));
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
    public String getName() { return "Deque-Based Algorithm"; }
}
