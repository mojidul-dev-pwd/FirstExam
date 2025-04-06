import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

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

        System.out.println("How to remove space from a string?");
        System.out.println(removeSpaceFromString(" abca "));

        String s = "  abc  def  vb   \t";
        System.out.println("How to remove Leading and Trailing Whitespaces from a string?");
        System.out.println(removeLeadingAndTrailingWhitespace(s));

        int[] array = {1, 2, 3, -1, -2, 4};
        System.out.println("How to sort of an array?");
        System.out.println(Arrays.toString(sortArray(array)));

        System.out.println("How to express factorial?");
        System.out.println(factorial(6));

        System.out.println("How to reverse a LinkedList?");
        reverseLinkList();

        System.out.println("binary search?");
        int arr[] = { 10, 20, 15, 22, 35 };
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int h = arr.length;
        System.out.println(binarySearch(arr, 0,h-1, 15));

        System.out.println("Given an array {7, 5, 8, 3, 1, 4} – write a simple program in Java that will return the largest 3 nos.");
        int[] arr1 = {7, 5, 8, 3, 1, 4};
        findLargestThreeNos(arr1);

        int x = 5;
        int y = ++x;
        //int y = x++;
        System.out.println(x+","+y);
        findValue();

        //What is the difference between ‘>>’ and ‘>>>’ operators in java?
        System.out.println(8 >> 1); //1000 = 8 ;;; 0100 = 4 (signed bit) This operator shifts each bit to its right position
        System.out.println(8 >>> 1); //1000 = 8 ;;; 0100 = 4 (unsigned bit) This operator also shifts each bit to its right position

        //checking string difference
        System.out.println(checking()); //return true
        System.out.println(checkingTwo()); // return false ... created in the heap memory even if the same content object is present

        //Synchronization example
        CheckingSync obj1 = new CheckingSync();
        obj1.testSync();
        obj1.testWithoutSync();

        //varargs method example
        varargsMethod("foo", "bar");
        varargsMethod("foo", "bar", "boo");
        varargsMethod(new String[]{"foo", "var", "boo"});
    }

    public static void varargsMethod(String... variables){ //Can receive multiple arguments of the datatype String
        for(String variable : variables){
            System.out.println(variable);
        }
    }

    public static boolean checking() {
        String first = "InterviewBit";
        String second = "InterviewBit";
        if (first == second)
            return true;
        else
            return false;
    }

    public static boolean checkingTwo() {
        String first = new String("InterviewBit");
        String second = new String("InterviewBit");
        if (first == second)
            return true;
        else
            return false;
    }

    public static void findValue() {
        int i = 20;
        int j = 55;
        int z = 0;
        z = i < j ? i : j; // ternary operator
        System.out.println("The value assigned is " + z);
    }


    public static void findLargestThreeNos(int[] arr){

        int len = arr.length;
        Arrays.sort(arr);
        System.out.println("Largest Three nos = "+arr[len-1]+","+arr[len-2]+","+arr[len-3]);

        //OR
        int largest = 0;
        int secondLargest = 0;
        int thirdLargest= 0;

        for(int i=0 ;i <= arr.length-1; i++) {

            if(arr[i] > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = arr[i];
            }else if(arr[i] > secondLargest && secondLargest < largest) {

                thirdLargest = secondLargest;
                secondLargest = arr[i];

            }else if(arr[i] > thirdLargest && thirdLargest < secondLargest ) {
                thirdLargest = arr[i];
            }
        }
        System.out.println("Largest Three nos are = "+largest+","+secondLargest+","+thirdLargest);
    }

    public static int binarySearch(int arr[], int low, int high, int key){
        int mid = (low + high) / 2;

        if (low > high) {
            return -1;
        }

        while (low <= high) {
            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] == key) {
                return mid;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return -1;
    }

    public static void reverseLinkList(){
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(2);
        l1.add(6);
        l1.add(7);
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.descendingIterator().forEachRemaining(l2::add);
        System.out.println(l2);
    }

    public static long factorial(int n){
        if (n == 0 || n == 1) {
            return 1;
        }
        return (n*factorial(n-1));
    }

    public static int[] sortArray(int[] arr){
        Arrays.sort(arr);
        return arr;
    }

    public static String removeLeadingAndTrailingWhitespace(String s){
        return s.strip();
    }

    public static String removeSpaceFromString(String input) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = input.toCharArray();
        for(char c: charArr){
            if(!Character.isWhitespace(c))
                sb.append(c);
        }
        //System.out.println(sb.length());
        return sb.toString();
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