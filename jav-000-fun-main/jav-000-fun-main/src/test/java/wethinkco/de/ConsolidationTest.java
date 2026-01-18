package wethinkco.de;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ConsolidationTest {

    @Test
    public void testFizzBuzz() {
        List<String> expected = Arrays.asList(
            "1", "2", "Fizz", "4", "Buzz",
            "Fizz", "7", "8", "Fizz", "Buzz",
            "11", "Fizz", "13", "14", "FizzBuzz"
        );
        Consolidation cons = new Consolidation();
        List<String> actual = cons.fizzBuzz(15);
        assertEquals(expected, actual);
    }

    @Test
    public void testFibonacciSequence() {
        Consolidation cons = new Consolidation();
        assertEquals("", cons.fibonacciSequence(0), "n=0 should return empty string");
        assertEquals("0", cons.fibonacciSequence(1), "n=1 should return '0'");
        assertEquals("0 1 1 2 3 5 8", cons.fibonacciSequence(7), "n=7 should return first 7 Fibonacci numbers");
    }

    @Test
    public void testCalculate() {
        Consolidation cons = new Consolidation();
        assertEquals("13", cons.calculate(10, 3, "+"));
        assertEquals("7", cons.calculate(10, 3, "-"));
        assertEquals("30", cons.calculate(10, 3, "*"));
        assertEquals("3", cons.calculate(10, 3, "/"));
        assertEquals("1", cons.calculate(10, 3, "%"));
    }

    @Test
    public void testDrawTriangle() {
        Consolidation cons = new Consolidation();
        assertEquals("*", cons.drawTriangle(1));
        assertEquals("*\n**", cons.drawTriangle(2));
        assertEquals("*\n**\n***", cons.drawTriangle(3));
        assertEquals("*\n**\n***\n****", cons.drawTriangle(4));
    }

    @Test
    public void testIsPalindrome() {
        Consolidation cons = new Consolidation();
    // Palindromes
        assertTrue(cons.isPalindrome("racecar"));
        assertTrue(cons.isPalindrome("Racecar"));
        assertTrue(cons.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(cons.isPalindrome("a"));
        assertTrue(cons.isPalindrome(""));
    // Not palindromes
        assertFalse(cons.isPalindrome("hello"));
        assertFalse(cons.isPalindrome("Java"));
        assertFalse(cons.isPalindrome("Palindrome"));
    }

    @Test
    public void testFactorial() {
        Consolidation cons = new Consolidation();
        assertEquals(1L, cons.factorial(0));
        assertEquals(1L, cons.factorial(1));
        assertEquals(2L, cons.factorial(2));
        assertEquals(6L, cons.factorial(3));
        assertEquals(24L, cons.factorial(4));
        assertEquals(120L, cons.factorial(5));
        assertEquals(3628800L, cons.factorial(10));
    }
}
