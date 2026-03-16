package service;

import algorithms.PalindromeAlgorithm;
import util.TextCleaner;

public class PalindromeService {
    private PalindromeAlgorithm algorithm;

    public PalindromeService() {}

    public PalindromeService(PalindromeAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void setAlgorithm(PalindromeAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithmName() {
        return algorithm == null ? "No Algorithm Selected" : algorithm.getName();
    }

    public boolean check(String input, boolean ignoreCaseAndSpace) {
        if (algorithm == null || input == null) {
            return false;
        }

        String processed = ignoreCaseAndSpace ? TextCleaner.clean(input) : input;
        return algorithm.isPalindrome(processed);
    }
}
