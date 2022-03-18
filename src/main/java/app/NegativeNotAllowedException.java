package app;

import java.util.List;
import java.util.stream.Collectors;

public class NegativeNotAllowedException extends RuntimeException {
    public NegativeNotAllowedException(List<Integer> messageParameters) {
        super("Negatives not Allowed : ".concat(paramToString(messageParameters)));
    }

    private static String paramToString(List<Integer> messageParameters) {
        return messageParameters.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }
}
