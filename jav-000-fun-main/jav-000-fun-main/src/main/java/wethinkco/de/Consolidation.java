package wethinkco.de;
import java.util.ArrayList;
import java.util.List;

public class Consolidation {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    
    public String fibonacciSequence(int n) {
        if (n == 0) return "";
        if (n == 1) return "0";
        StringBuilder sb = new StringBuilder();
        int a = 0, b = 1;
        sb.append(a);
        for (int i = 1; i < n; i++) {
            sb.append(" ").append(b);
            int next = a + b;
            a = b;
            b = next;
        }
        return sb.toString();
    }


    public String calculate(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> String.valueOf(a + b);
            case "-" -> String.valueOf(a - b);
            case "*" -> String.valueOf(a * b);
            case "/" -> String.valueOf(a / b);
            case "%" -> String.valueOf(a % b);
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }


    public String drawTriangle(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            if (i != n) sb.append("\n");
        }
        return sb.toString();
    }

    
   public boolean isPalindrome(String str) {
        if (str == null) return false;
        String clean = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }


    public long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}