import algorithms.*;
import service.PalindromeService;

import java.util.ArrayList;
import java.util.List;

public class PalindromeApp {
    private static final String SAMPLE = "madam";
    private static final String NORMALIZED_SAMPLE = "A man a plan a canal Panama";

    public static void main(String[] args) {
        printHeader();
        run02Uc1And03Uc2();
        run04Uc3To11Uc10();
        run12Uc11And13Uc12();
        run14Uc13();
    }

    private static void printHeader() {
        System.out.println("==================================================");
        System.out.println("         Welcome to Palindrome Checker App        ");
        System.out.println("==================================================");
    }

    private static void run02Uc1And03Uc2() {
        System.out.println("\n02 UC1 - Application Entry & Welcome Message");
        System.out.println("Application started successfully.");

        String hardcoded = "radar";
        System.out.println("\n03 UC2 - Print a Hardcoded Palindrome Result");
        System.out.println("Input: " + hardcoded);
        System.out.println("Is palindrome: true");
    }

    private static void run04Uc3To11Uc10() {
        System.out.println("\n04 UC3 - Palindrome Check Using String Reverse");
        printResult(new StringReverseChecker(), SAMPLE, false);

        System.out.println("\n05 UC4 - Character Array Based Palindrome Check");
        printResult(new CharacterArrayChecker(), SAMPLE, false);

        System.out.println("\n06 UC5 - Stack-Based Palindrome Checker");
        printResult(new StackChecker(), SAMPLE, false);

        System.out.println("\n07 UC6 - Queue + Stack Based Palindrome Check");
        printResult(new QueueStackChecker(), SAMPLE, false);

        System.out.println("\n08 UC7 - Deque-Based Optimized Palindrome Checker");
        printResult(new DequeChecker(), SAMPLE, false);

        System.out.println("\n09 UC8 - Linked List Based Palindrome Checker");
        printResult(new LinkedListChecker(), SAMPLE, false);

        System.out.println("\n10 UC9 - Recursive Palindrome Checker");
        printResult(new RecursiveChecker(), SAMPLE, false);

        System.out.println("\n11 UC10 - Case-Insensitive & Space-Ignored Palindrome");
        printResult(new StringReverseChecker(), NORMALIZED_SAMPLE, true);
    }

    private static void run12Uc11And13Uc12() {
        System.out.println("\n12 UC11 - Object-Oriented Palindrome Service");
        PalindromeService service = new PalindromeService(new StringReverseChecker());
        System.out.println("Service algorithm: " + service.getAlgorithmName());
        System.out.println("Input: " + SAMPLE);
        System.out.println("Is palindrome: " + service.check(SAMPLE, false));

        System.out.println("\n13 UC12 - Strategy Pattern for Palindrome Algorithms");
        List<PalindromeAlgorithm> strategies = List.of(
                new StringReverseChecker(),
                new CharacterArrayChecker(),
                new StackChecker(),
                new QueueStackChecker(),
                new DequeChecker(),
                new LinkedListChecker(),
                new RecursiveChecker()
        );

        String strategyInput = "level";
        for (PalindromeAlgorithm strategy : strategies) {
            service.setAlgorithm(strategy);
            System.out.println(service.getAlgorithmName() + " -> " + service.check(strategyInput, false));
        }
    }

    private static void run14Uc13() {
        System.out.println("\n14 UC13 - Performance Comparison");
        List<PalindromeAlgorithm> algorithms = List.of(
                new StringReverseChecker(),
                new CharacterArrayChecker(),
                new StackChecker(),
                new QueueStackChecker(),
                new DequeChecker(),
                new LinkedListChecker(),
                new RecursiveChecker()
        );

        String performanceInput = "neveroddoreven";
        int iterations = 10_000;
        List<String> results = new ArrayList<>();

        for (PalindromeAlgorithm algorithm : algorithms) {
            long start = System.nanoTime();
            boolean result = false;
            for (int i = 0; i < iterations; i++) {
                result = algorithm.isPalindrome(performanceInput);
            }
            long end = System.nanoTime();
            long duration = end - start;
            results.add(String.format("%s -> result=%s, time=%d ns", algorithm.getName(), result, duration));
        }

        for (String line : results) {
            System.out.println(line);
        }
    }

    private static void printResult(PalindromeAlgorithm algorithm, String input, boolean ignoreCaseAndSpace) {
        PalindromeService service = new PalindromeService(algorithm);
        System.out.println("Algorithm: " + service.getAlgorithmName());
        System.out.println("Input: " + input);
        System.out.println("Is palindrome: " + service.check(input, ignoreCaseAndSpace));
    }
}
