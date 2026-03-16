import algorithms.*;
import service.PalindromeService;

import java.util.ArrayList;
import java.util.List;

public class PalindromeApp {
    private static final String SAMPLE = "madam";
    private static final String NORMALIZED_SAMPLE = "A man a plan a canal Panama";
    private static final List<PalindromeAlgorithm> ALGORITHMS = List.of(
            new StringReverseChecker(),
            new CharacterArrayChecker(),
            new StackChecker(),
            new QueueStackChecker(),
            new DequeChecker(),
            new LinkedListChecker(),
            new RecursiveChecker()
    );

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
        List<TestCase> uc11Cases = List.of(
                new TestCase(NORMALIZED_SAMPLE, true, true),
                new TestCase("Never odd or even", true, true),
                new TestCase("Open AI", true, false)
        );
        printTestCases(new StringReverseChecker(), uc11Cases);
    }

    private static void run12Uc11And13Uc12() {
        System.out.println("\n12 UC11 - Object-Oriented Palindrome Service");
        PalindromeService service = new PalindromeService(new StringReverseChecker());
        System.out.println("Service algorithm: " + service.getAlgorithmName());
        List<TestCase> uc12Cases = List.of(
                new TestCase(SAMPLE, false, true),
                new TestCase("refer", false, true),
                new TestCase("java", false, false)
        );
        printTestCases(service, uc12Cases);

        System.out.println("\n13 UC12 - Strategy Pattern for Palindrome Algorithms");
        List<TestCase> uc13Cases = List.of(
                new TestCase("level", false, true),
                new TestCase("Rotor", false, true),
                new TestCase("coding", false, false)
        );
        for (PalindromeAlgorithm strategy : ALGORITHMS) {
            service.setAlgorithm(strategy);
            System.out.println("Algorithm: " + service.getAlgorithmName());
            printTestCases(service, uc13Cases);
        }
    }

    private static void run14Uc13() {
        System.out.println("\n14 UC13 - Performance Comparison");
        List<TestCase> uc14Cases = List.of(
                new TestCase("neveroddoreven", false, true),
                new TestCase("racecar", false, true),
                new TestCase("algorithm", false, false),
                new TestCase("Malayalam", false, true)
        );
        String performanceInput = "neveroddoreven";
        int iterations = 10_000;
        List<String> results = new ArrayList<>();

        for (PalindromeAlgorithm algorithm : ALGORITHMS) {
            int passed = countPassingCases(algorithm, uc14Cases);
            long start = System.nanoTime();
            boolean result = false;
            for (int i = 0; i < iterations; i++) {
                result = algorithm.isPalindrome(performanceInput);
            }
            long end = System.nanoTime();
            long duration = end - start;
            results.add(String.format(
                    "%s -> passed=%d/%d, result=%s, time=%d ns",
                    algorithm.getName(),
                    passed,
                    uc14Cases.size(),
                    result,
                    duration
            ));
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

    private static void printTestCases(PalindromeAlgorithm algorithm, List<TestCase> testCases) {
        PalindromeService service = new PalindromeService(algorithm);
        System.out.println("Algorithm: " + service.getAlgorithmName());
        printTestCases(service, testCases);
    }

    private static void printTestCases(PalindromeService service, List<TestCase> testCases) {
        for (int index = 0; index < testCases.size(); index++) {
            TestCase testCase = testCases.get(index);
            boolean actual = service.check(testCase.input, testCase.ignoreCaseAndSpace);
            System.out.printf(
                    "Test %d: input=%s, expected=%s, actual=%s%n",
                    index + 1,
                    testCase.input,
                    testCase.expected,
                    actual
            );
        }
    }

    private static int countPassingCases(PalindromeAlgorithm algorithm, List<TestCase> testCases) {
        PalindromeService service = new PalindromeService(algorithm);
        int passed = 0;

        for (TestCase testCase : testCases) {
            if (service.check(testCase.input, testCase.ignoreCaseAndSpace) == testCase.expected) {
                passed++;
            }
        }

        return passed;
    }

    private static class TestCase {
        private final String input;
        private final boolean ignoreCaseAndSpace;
        private final boolean expected;

        private TestCase(String input, boolean ignoreCaseAndSpace, boolean expected) {
            this.input = input;
            this.ignoreCaseAndSpace = ignoreCaseAndSpace;
            this.expected = expected;
        }
    }
}
