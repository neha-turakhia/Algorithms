package Chapter1_ArrayString;

import java.util.Scanner;

public class StringRotation {

    /**
     * CTCI 1.9 - String rotation: Assume you have a method isSubstring which checks if one word is a substring of another.
     *                              Given two strings, write the code to check if one string is a rotation of the other using only one call to isSubstring
     *  Example : waterbottle is a rotation of erbottlewat
     *
     * Solution: Using a string builder append the string twice and then call isSubstring given based on the question
     *           Since we dont know the implementation of isSubstring() - it is implemented using indexOf which runs in O(N)
     *
     * Time Complexity: O(2N) ~ O(N)
     * Space Complexity: O(N)
     **/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        boolean isRotatedString = isRotatedString(s1,s2);
        System.out.println(isRotatedString);
    }

    private static boolean isRotatedString(String s1,String s2){
        if(s1.length() != s2.length()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s1);

        return (isSubstring(sb.toString(),s2) != -1);
    }

    private static int isSubstring(String s1,String s2){
        return s1.indexOf(s2);
    }
}