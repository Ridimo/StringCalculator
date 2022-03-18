package app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    //STEP 1
    @Test
    @DisplayName("Given an input with two numbers delimited by a comma, should return their sum")
    void should_sum_two_numbers() {
        //Given
        var numbers = "1,2";
        int expectedSum = 3;
        //When
        var resultSum = StringCalculator.add(numbers);
        //Then
        Assertions.assertEquals(resultSum, expectedSum);
    }

    @Test
    @DisplayName("Given an input with one number, should return the number")
    void should_sum_one_number() {
        //Given
        var numbers = "2";
        int expectedSum = 2;
        //When
        var resultSum = StringCalculator.add(numbers);
        //Then
        Assertions.assertEquals(resultSum, expectedSum);
    }

    @Test
    @DisplayName("Given an empty string, should return zero")
    void should_return_zero_if_numbers_is_empty() {
        //Given
        var numbers = "";
        int expectedSum = 0;
        //When
        var resultSum = StringCalculator.add(numbers);
        //Then
        Assertions.assertEquals(resultSum, expectedSum);
    }

    //----------------------------------------------------------------------------------

    //STEP 2
    @Test
    @DisplayName("Given an input with multiple numbers delimited by a comma, should return their sum")
    void should_sum_multiple_numbers() {
        //Given
        var numbers = "1,2,2,0,2";
        int expectedSum = 7;
        //When
        var resultSum = StringCalculator.add(numbers);
        //Then
        Assertions.assertEquals(resultSum, expectedSum);
    }

    //----------------------------------------------------------------------------------

    //STEP 3
    @Test
    @DisplayName("Given an input with multiple numbers delimited by a comma and new lines between numbers, should return their sum")
    void should_sum_multiple_numbers_with_new_lines_with_delimiter() {
        //Given
        var numbers = "1\n2,2\n0,2";
        int expectedSum = 7;
        //When
        var resultSum = StringCalculator.add(numbers);
        //Then
        Assertions.assertEquals(resultSum, expectedSum);
    }

    @Test
    @DisplayName("Given an input with multiple numbers without delimiter and new lines between numbers, should return their sum")
    void should_sum_multiple_numbers_with_new_lines_without_delimiter() {
        //Given
        var numbers = "1\n2\n2";
        int expectedSum = 5;
        //When
        var resultSum = StringCalculator.add(numbers);
        //Then
        Assertions.assertEquals(resultSum, expectedSum);
    }

    //----------------------------------------------------------------------------------

    //STEP 4
    @Test
    @DisplayName("Given an input with a delimiter line at the beginning and multiple numbers and new lines between numbers, should return their sum")
    void should_sum_multiple_numbers_with_new_lines_and_delimiter_added_at_the_beginning() {
        //Given
        var numbers = "//;\n1;2;2;0;2";
        int expectedSum = 7;
        //When
        var resultSum = StringCalculator.add(numbers);
        //Then
        Assertions.assertEquals(resultSum, expectedSum);
    }

    @Test
    @DisplayName("Given an input with a comma delimiter line at the beginning and multiple numbers and new lines between numbers, should return their sum")
    void should_sum_multiple_numbers_with_new_lines_and_a_comma_delimiter_added_at_the_beginning() {
        //Given
        var numbers = "//,\n1,2,2,0,2";
        int expectedSum = 7;
        //When
        var resultSum = StringCalculator.add(numbers);
        //Then
        Assertions.assertEquals(resultSum, expectedSum);
    }

    //----------------------------------------------------------------------------------

    //STEP 5
    @Test
    @DisplayName("Given an input with a negative number, should throw an exception wth a message and the negative number")
    void should_throw_exception_with_unique_negative_number() {
        //Given
        var numbers = "1,-2";
        var expectedExceptionMessage = """
                Negatives not Allowed : -2""";
        //Then
        NegativeNotAllowedException expectedException = Assertions.assertThrows(NegativeNotAllowedException.class, () -> StringCalculator.add(numbers));
        Assertions.assertEquals(expectedException.getMessage(), expectedExceptionMessage);
    }

    @Test
    @DisplayName("Given an input with a multiple negative numbers, should throw an exception wth a message and all negative numbers")
    void should_throw_exception_with_multiple_negative_numbers() {
        //Given
        var numbers = "1,-2,4,-6,-3";
        var expectedExceptionMessage = """
                Negatives not Allowed : -2,-6,-3""";
        //Then
        NegativeNotAllowedException expectedException = Assertions.assertThrows(NegativeNotAllowedException.class, () -> StringCalculator.add(numbers));
        Assertions.assertEquals(expectedException.getMessage(), expectedExceptionMessage);
    }
}