package algorithms;
import java.util.LinkedList;
public class LinkedListChecker implements PalindromeAlgorithm {
    public boolean isPalindrome(String input) {
        if (input == null) return false;
        LinkedList<Character> list = new LinkedList<>();
        for (char c : input.toCharArray()) list.add(Character.toLowerCase(c));
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (!list.get(i).equals(list.get(size - 1 - i))) return false;
        }
        return true;
    }
    public String getName() { return "Linked List Algorithm"; }
}
