package algorithms;
public class RecursiveChecker implements PalindromeAlgorithm {
    public boolean isPalindrome(String input) {
        if (input == null) return false;
        String s = input.toLowerCase();
        return check(s, 0, s.length() - 1);
    }
    private boolean check(String s, int l, int r) {
        if (l >= r) return true;
        if (s.charAt(l) != s.charAt(r)) return false;
        return check(s, l + 1, r - 1);
    }
    public String getName() { return "Recursive Algorithm"; }
}
