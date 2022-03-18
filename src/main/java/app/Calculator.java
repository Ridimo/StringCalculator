package app;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    public static final String DEFAULT_DELIMITER = "[,\n]";
    public static final int DELIMITER_BEGIN_INDEX = 2;
    public static final int DELIMITER_END_INDEX = 3;
    public static final int NUMBERS_STRING_BEGIN_INDEX = 4;
    public static final String DELIMITER_START_PREFIX = "//";
    private final List<Integer> numbers;

    private Calculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Calculator fromString(String input) {

        var extractedDelimiterFromInput = extractDelimiter(input);
        var extractedNumbersFromInput = extractNumbers(input);

        var numbers = splitStringIntoNumbers(extractedDelimiterFromInput, extractedNumbersFromInput);

        if (areThereNegatives(numbers)) {
            var negativeNumbers = extractNegativeNumbers(numbers);
            throw new NegativeNotAllowedException(negativeNumbers);
        }

        return new Calculator(numbers);
    }

    public int sum() {
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static List<Integer> splitStringIntoNumbers(String delimiter, String inputNumbers) {
        return inputNumbers.isEmpty() ? Collections.singletonList(0) : Pattern.compile(delimiter).splitAsStream(inputNumbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    private static List<Integer> extractNegativeNumbers(List<Integer> inputNumbers) {
        return inputNumbers.stream().filter(number -> number < 0).collect(Collectors.toList());
    }

    private static boolean areThereNegatives(List<Integer> inputNumbers) {
        return inputNumbers.stream().anyMatch(number -> number < 0);
    }

    private static String extractNumbers(String input) {
        return isDelimiterDefinedFor(input) ? input.substring(NUMBERS_STRING_BEGIN_INDEX) : input;
    }

    private static String extractDelimiter(String input) {
        return isDelimiterDefinedFor(input) ? input.substring(DELIMITER_BEGIN_INDEX, DELIMITER_END_INDEX) : DEFAULT_DELIMITER;
    }

    private static boolean isDelimiterDefinedFor(String numbers) {
        return numbers.startsWith(DELIMITER_START_PREFIX);
    }

}
