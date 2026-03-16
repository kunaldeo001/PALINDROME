package algorithms;

public class CharacterArrayChecker implements PalindromeAlgorithm {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        char[] characters = input.toLowerCase().toCharArray();
        int left = 0;
        int right = characters.length - 1;

        while (left < right) {
            if (characters[left] != characters[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    @Override
    public String getName() {
        return "Character Array Algorithm";
    }
}
