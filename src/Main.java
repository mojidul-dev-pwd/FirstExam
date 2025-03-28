import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("How do you reverse a string?");
        System.out.println(reverseString("abcd"));

        System.out.println("How do you Swap two numbers without using a third variable?");
        swapNumbers(4,3);

        System.out.println("Check if a vowel is present in a string?");
        System.out.println(stringContainsVowels("9bcd"));

        System.out.println("Check if a prime number?");
        System.out.println(isPrime(12));

        System.out.println("Write a Fibonacci series using recursion?");
        printFibonacciSequence(10);

        System.out.println("Check odd number exists in list.");
        List<Integer> list=new ArrayList<Integer>();
        list.add(10);
        list.add(8);
        list.add(6);
        list.add(7);
        System.out.println(oddNumberExist(list));

        System.out.println("Check if a palindrome number?");
        System.out.println(checkPalindromeString("abcbaa"));

    }

    public static boolean checkPalindromeString(String input) {
        boolean result = true;
        int length = input.length();
        for (int i=0;i<length/2;i++){
            if (input.charAt(i) != (input.charAt(length -i-1))){
                result = false;
                break;
            }
        }
        return result;
    }
    public static boolean oddNumberExist(List<Integer> list){
        /*
        for(int i: list){
            if(i%2 == 0){
                return false;
            }
            return true;
        }
        */
        //another faster way
        return list.parallelStream().anyMatch(x->x % 2 != 0);
    }

    public static void printFibonacciSequence(int count) {
        int firstTerm = 0, secondTerm = 1;

        for (int i = 1; i <= count; ++i) {
            System.out.print(firstTerm + ", ");

            // compute the next term
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }

    public static boolean isPrime(int n) {
        if(n == 0 || n ==1){
            return false;
        }
        if(n == 2){
            return true;
        }
//        for(int i=2; i <= n; i++){
//            if(n%2==0){
//                return false;
//            }
//        }
//        return true;
        if(n%2==0){
            return false;
        }
        return true;
    }

    public static boolean stringContainsVowels(String input) {
        return input.toLowerCase().matches(".*[aeiou].*");
    }

    public static void swapNumbers(int a, int b){
        b = b + a; // now b is sum of both the numbers
        a = b - a; // b - a = (b + a) - a = b (a is swapped)
        b = b - a; // (b + a) - b = a (b is swapped)

        System.out.println("After swapping, a is " + a + " and b is " + b);
    }

    public static String reverseString(String in){
        if(in == null || in.isBlank()){
            throw new IllegalArgumentException("Invalid input");
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = in.toCharArray();
        int len = chars.length-1;
        for (int i = len;i>-1;i--){
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}