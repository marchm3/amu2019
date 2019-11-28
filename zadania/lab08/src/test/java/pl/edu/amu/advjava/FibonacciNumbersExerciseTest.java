package pl.edu.amu.advjava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class FibonacciNumbersExerciseTest {

    private static final int[] EXPECTED = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

    @Test
    public void generateFibonacciNumbers() {

        int[] actual = FibonacciNumbersExercise.generateFibonacciNumbers(10);
        assertThat(actual).isEqualTo(EXPECTED);
    }

    @Test
    public void generateFibonacciNumbersWithLambda() {
        int[] actual = FibonacciNumbersExercise.generateFibonacciNumbersWithLambda(10);
        assertThat(actual).isEqualTo(EXPECTED);
    }
}