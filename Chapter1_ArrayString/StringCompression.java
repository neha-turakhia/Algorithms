package Chapter1_ArrayString;

import java.util.Scanner;

public class StringCompression {

    /**
     * CTCI 1.6 String Compression : Implement a method to perform basic string compression using the counts of repeated characters.
     *                              For example, the string aabcccccaaa would become a2blc5a3.
     *                              If the "compressed" string would not become smaller than the original string,
     *                              your method should return the original string.
     *                              You can assume the string has only uppercase and lowercase letters (a - z).
     *
     *  Example : Input = aabcccccaaa, Output = a2blc5a3
     *
     *  Solution : Use a string builder to perform concatenation - instead of string concat
     *  Time Complexity : O(N)
     *  Space Complexity : O(N) - for the output , if output is ignored O(1)
     **/

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String compressed_string = compress(str);
        System.out.println(compressed_string);
    }

    private static String compress(String original){
        StringBuilder sb = new StringBuilder();
        char prev = original.charAt(0);
        int count = 1;
        for(int i=1;i<original.length();++i){
            if(original.charAt(i) == prev) {
                count++;
            }else{
                sb.append(prev);
                sb.append(count);
                count = 1;
            }
            prev = original.charAt(i);
        }

        sb.append(prev);
        sb.append(count);
        return sb.length() >= original.length() ? original : sb.toString();
    }
}